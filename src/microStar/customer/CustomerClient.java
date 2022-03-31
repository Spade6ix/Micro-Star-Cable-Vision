package microStar.customer;

import microStar.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerClient {
    private Socket connectionSocket;
    private static ObjectOutputStream objOs;
    private ObjectInputStream objIs;
    private String action;
    private Complaint complaintObj;
    private Customer customerObj;
    private CustomerEmail customerEmailObj;
    private CustomerPhone customerPhoneObj;
    private Employee employeeObj;
    private LiveChat liveChatObj;
    private Payment paymentObj;
    private Query queryObj;
    private Response responseObj;
    private ResultSet result;
    private boolean login;
    private boolean flag;
    private String customerID;
    private List<Response> responseList;
    private List<Complaint> complaintList;
    private List<Payment> paymentList;
    private List<CustomerEmail> customerEmailList;
    private List<CustomerPhone> customerPhoneList;
    private List<Employee> employeeList;
    private static final Logger logger = LogManager.getLogger(CustomerClient.class);

    public CustomerClient(){
        try{
            action = "";
            complaintObj = new Complaint();
            customerObj = new Customer();
            customerEmailObj = new CustomerEmail();
            customerPhoneObj = new CustomerPhone();
            employeeObj = new Employee();
            liveChatObj = new LiveChat();
            paymentObj = new Payment();
            queryObj = new Query();
            responseObj = new Response();
            ResultSet result = null;
            login = false;
            customerID = "";
            responseList = new ArrayList<>();
            complaintList = new ArrayList<>();
            paymentList = new ArrayList<>();
            customerEmailList = new ArrayList<>();
            customerPhoneList = new ArrayList<>();
            employeeList = new ArrayList<>();
            connectionSocket = new Socket("localhost", 9555);
            objOs = new ObjectOutputStream(connectionSocket.getOutputStream());
            objIs = new ObjectInputStream(connectionSocket.getInputStream());
        }
        catch(IOException ex){
            logger.error("IOException Occurred");
            ex.printStackTrace();
        }
        catch(Exception ex){
            logger.error("Exception Occurred");
            ex.printStackTrace();
        }
    }

    public void closeConnection(){
        try{
            objOs.close();
            objIs.close();
            connectionSocket.close();
            logger.info("Connection Closed");
        }
        catch(IOException ex){
            logger.error("IOException Occurred");
            ex.printStackTrace();
        }
        catch(Exception ex){
            logger.error("Exception Occurred");
            ex.printStackTrace();
        }
    }

    public void sendAction(String action){
        this.action = action;
        try{
            objOs.writeObject(action);
            logger.info("Action Sent");
        }
        catch(IOException ex){
            logger.error("IOException Occurred");
            ex.printStackTrace();
        }
        catch(Exception ex){
            logger.error("Exception Occurred");
            ex.printStackTrace();
        }
    }

    public void sendComplaintObj(Complaint complaintObj){
        try{
            objOs.writeObject(complaintObj);
            logger.info("Complaint Object Sent");
        }
        catch(IOException ex){
            logger.error("IOException Occurred");
            ex.printStackTrace();
        }
        catch(Exception ex){
            logger.error("Exception Occurred");
            ex.printStackTrace();
        }
    }

    public void sendCustomerObj(Customer customerObj){
        try{
            objOs.writeObject(customerObj);
            logger.info("Customer Object Sent");
        }
        catch(IOException ex){
            logger.error("IOException Occurred");
            ex.printStackTrace();
        }
        catch(Exception ex){
            logger.error("Exception Occurred");
            ex.printStackTrace();
        }
    }

    public void sendCustomerEmailObj(CustomerEmail customerEmailObj){
        try{
            objOs.writeObject(customerEmailObj);
            logger.info("CustomerEmail Object Sent");
        }
        catch(IOException ex){
            logger.error("IOException Occurred");
            ex.printStackTrace();
        }
        catch(Exception ex){
            logger.error("Exception Occurred");
            ex.printStackTrace();
        }
    }

    public void sendCustomerPhoneObj(CustomerPhone customerPhoneObj){
        try{
            objOs.writeObject(customerPhoneObj);
            logger.info("CustomerPhone Object Sent");
        }
        catch(IOException ex){
            logger.error("IOException Occurred");
            ex.printStackTrace();
        }
        catch(Exception ex){
            logger.error("Exception Occurred");
            ex.printStackTrace();
        }
    }

    public void sendEmployeeObj(Employee employeeObj){
        try{
            objOs.writeObject(employeeObj);
            logger.info("Employee Object Sent");
        }
        catch(IOException ex){
            logger.error("IOException Occurred");
            ex.printStackTrace();
        }
        catch(Exception ex){
            logger.error("Exception Occurred");
            ex.printStackTrace();
        }
    }

    public void sendLiveChatObj(LiveChat liveChatObj){
        try{
            objOs.writeObject(liveChatObj);
            logger.info("LiveChat Object Sent");
        }
        catch(IOException ex){
            logger.error("IOException Occurred");
            ex.printStackTrace();
        }
        catch(Exception ex){
            logger.error("Exception Occurred");
            ex.printStackTrace();
        }
    }

    public void sendPaymentObj(Payment paymentObj){
        try{
            objOs.writeObject(paymentObj);
            logger.info("Payment Object Sent");
        }
        catch(IOException ex){
            logger.error("IOException Occurred");
            ex.printStackTrace();
        }
        catch(Exception ex){
            logger.error("Exception Occurred");
            ex.printStackTrace();
        }
    }

    public void sendQueryObj(Query queryObj){
        try{
            objOs.writeObject(queryObj);
            logger.info("Query Object Sent");
        }
        catch(IOException ex){
            logger.error("IOException Occurred");
            ex.printStackTrace();
        }
        catch(Exception ex){
            logger.error("Exception Occurred");
            ex.printStackTrace();
        }
    }

    public void sendResponseObj(Response responseObj){
        try{
            objOs.writeObject(responseObj);
            logger.info("Response Object Sent");
        }
        catch(IOException ex){
            logger.error("IOException Occurred");
            ex.printStackTrace();
        }
        catch(Exception ex){
            logger.error("Exception Occurred");
            ex.printStackTrace();
        }
    }

    public void sendCustomerID(String customerID){
        try{
            objOs.writeObject(customerID);
            logger.info("CustomerID Sent");
        }
        catch(IOException ex){
            logger.error("IOException Occurred");
            ex.printStackTrace();
        }
        catch(Exception ex){
            logger.error("Exception Occurred");
            ex.printStackTrace();
        }

    }


    public void receiveResponse() {
        try {
            if (action.equalsIgnoreCase("Customer Login")) {
                login = (boolean) objIs.readObject();
                if(login){
                    logger.info("Customer Authenticated");
                }
                else{
                    logger.info("Customer provided incorrect credentials");
                }
            }
            else if (action.equalsIgnoreCase("Create Complaint")){
                flag = (boolean) objIs.readObject();
                if (flag){
                    logger.info("Complaint Created successfully");
                }
                else{
                    logger.error("ERROR: Complaint not created");
                }
            }
            else if (action.equalsIgnoreCase("Make Query")){
                result = (ResultSet) objIs.readObject();
                logger.info("Query Data fetched successfully");
            }
            else if (action.equalsIgnoreCase("View All Responses to a Complaint")){
                responseList = (List<Response>) objIs.readObject();
                logger.info("Responses fetched successfully");
            }
            else if (action.equalsIgnoreCase("View All Complaints of a Customer")){
                complaintList = (List<Complaint>) objIs.readObject();
                responseList = (List<Response>) objIs.readObject();
                employeeList = (List<Employee>) objIs.readObject();
                logger.info("Complaints fetched successfully");
            }
            else if (action.equalsIgnoreCase("View a Complaint of a Customer")){
                complaintObj = (Complaint) objIs.readObject();
                logger.info("Complaint fetched successfully");
            }
            else if (action.equalsIgnoreCase("View All Payments made by a Customer")){
                paymentList = (List<Payment>) objIs.readObject();
                logger.info("Payments fetched successfully");
            }
            else if (action.equalsIgnoreCase("Customer Create LiveChat")){
                flag = (boolean) objIs.readObject();
                if (flag){
                    logger.info("Live Chat sent to Database successfully");
                }
                else{
                    logger.error("Live Chat not sent to Database because Live Chat period is temporarily expired");
                }
            }
            else if (action.equalsIgnoreCase("Update Complaint Status")){
                flag = (boolean) objIs.readObject();
                if (flag){
                    logger.info("Complaint updated successfully");
                }
                else{
                    logger.error("Complaint not updated successfully");
                }
            }
            else if (action.equalsIgnoreCase("View Customer Account info")){
                customerObj = (Customer) objIs.readObject();
                customerPhoneList = (List<CustomerPhone>) objIs.readObject();
                customerEmailList = (List<CustomerEmail>) objIs.readObject();
                logger.info("Customer Account info fetched successfully");
            }
        }
        catch(ClassCastException ex){
            logger.error("ClassCastException Occurred");
            ex.printStackTrace();
        }
        catch(ClassNotFoundException ex){
            logger.error("ClassNotFoundException Occurred");
            ex.printStackTrace();
        }
        catch(IOException ex){
            logger.error("IOException Occurred");
            ex.printStackTrace();
        }
        catch(Exception ex){
            logger.error("Exception Occurred");
            ex.printStackTrace();
        }
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Complaint getComplaintObj() {
        return complaintObj;
    }

    public void setComplaintObj(Complaint complaintObj) {
        this.complaintObj = complaintObj;
    }

    public Customer getCustomerObj() {
        return customerObj;
    }

    public void setCustomerObj(Customer customerObj) {
        this.customerObj = customerObj;
    }

    public CustomerEmail getCustomerEmailObj() {
        return customerEmailObj;
    }

    public void setCustomerEmailObj(CustomerEmail customerEmailObj) {
        this.customerEmailObj = customerEmailObj;
    }

    public CustomerPhone getCustomerPhoneObj() {
        return customerPhoneObj;
    }

    public void setCustomerPhoneObj(CustomerPhone customerPhoneObj) {
        this.customerPhoneObj = customerPhoneObj;
    }

    public Employee getEmployeeObj() {
        return employeeObj;
    }

    public void setEmployeeObj(Employee employeeObj) {
        this.employeeObj = employeeObj;
    }

    public LiveChat getLiveChatObj() {
        return liveChatObj;
    }

    public void setLiveChatObj(LiveChat liveChatObj) {
        this.liveChatObj = liveChatObj;
    }

    public Payment getPaymentObj() {
        return paymentObj;
    }

    public void setPaymentObj(Payment paymentObj) {
        this.paymentObj = paymentObj;
    }

    public Query getQueryObj() {
        return queryObj;
    }

    public void setQueryObj(Query queryObj) {
        this.queryObj = queryObj;
    }

    public Response getResponseObj() {
        return responseObj;
    }

    public void setResponseObj(Response responseObj) {
        this.responseObj = responseObj;
    }

    public ResultSet getResult() {
        return result;
    }

    public void setResult(ResultSet result) {
        this.result = result;
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public List<Response> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<Response> responseList) {
        this.responseList = responseList;
    }

    public List<Complaint> getComplaintList() {
        return complaintList;
    }

    public void setComplaintList(List<Complaint> complaintList) {
        this.complaintList = complaintList;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    public List<CustomerEmail> getCustomerEmailList() {
        return customerEmailList;
    }

    public void setCustomerEmailList(List<CustomerEmail> customerEmailList) {
        this.customerEmailList = customerEmailList;
    }

    public List<CustomerPhone> getCustomerPhoneList() {
        return customerPhoneList;
    }

    public void setCustomerPhoneList(List<CustomerPhone> customerPhoneList) {
        this.customerPhoneList = customerPhoneList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
