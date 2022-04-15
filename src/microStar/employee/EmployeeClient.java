package microStar.employee;

import microStar.customer.CustomerClient;
import microStar.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeClient {
    private Socket connectionSocket;
    private static ObjectOutputStream objOs;
    private ObjectInputStream objIs;
    private String action;
    private VideoFrame videoFrameObj;
    private Complaint complaintObj;
    private Customer customerObj;
    private CustomerEmail customerEmailObj;
    private CustomerPhone customerPhoneObj;
    private Employee employeeObj;
    private LiveChat liveChatObj;
    private Payment paymentObj;
    private Query queryObj;
    private Response responseObj;
    private boolean login;
    private boolean flag;
    private int resolved;
    private int unresolved;
    private String customerID;
    private String employeeID;
    private List<Response> responseList;
    private List<Complaint> complaintList;
    private List<Payment> paymentList;
    private List<CustomerEmail> customerEmailList;
    private List<CustomerPhone> customerPhoneList;
    private List<Employee> employeeList;
    private List<LiveChat> liveChatList;
    private List<Customer> customerList;
    private static final Logger logger = LogManager.getLogger(EmployeeClient.class);

    public EmployeeClient(){
        try{
            action = "";
            videoFrameObj = new VideoFrame();
            complaintObj = new Complaint();
            customerObj = new Customer();
            customerEmailObj = new CustomerEmail();
            customerPhoneObj = new CustomerPhone();
            employeeObj = new Employee();
            liveChatObj = new LiveChat();
            paymentObj = new Payment();
            queryObj = new Query();
            responseObj = new Response();
            login = false;
            resolved = 0;
            unresolved = 0;
            customerID = "";
            employeeID = "";
            responseList = new ArrayList<>();
            complaintList = new ArrayList<>();
            paymentList = new ArrayList<>();
            customerEmailList = new ArrayList<>();
            customerPhoneList = new ArrayList<>();
            employeeList = new ArrayList<>();
            liveChatList = new ArrayList<>();
            customerList = new ArrayList<>();
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
            objOs.flush();
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
            objOs.flush();
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
            objOs.flush();
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

    public void sendEmployeeID(String employeeID){
        try{
            objOs.writeObject(employeeID);
            logger.info("EmployeeID Sent");
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
    
    public void sendVideoFrameObj(VideoFrame videoFrame) {
    	try{
            objOs.writeObject(videoFrame);
            logger.info("Video Frame Sent");
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
            if (action.equalsIgnoreCase("Employee Login")) {
                login = (boolean) objIs.readObject();
                if(login){
                    employeeObj = (Employee) objIs.readObject();
                    logger.info("Employee Authenticated");
                }
                else{
                    logger.info("Employee provided incorrect credentials");
                }
            }
            else if (action.equalsIgnoreCase("View Number of Resolved & Unresolved Complaints")){
                resolved = (int) objIs.readObject();
                unresolved = (int) objIs.readObject();
                logger.info("Number of Resolved and Unresolved Complaints fetched successfully");
            }
            else if (action.equalsIgnoreCase("View Payment Complaints")){
                complaintList = (List<Complaint>) objIs.readObject();
                customerList = (List<Customer>) objIs.readObject();
                customerPhoneList = (List<CustomerPhone>) objIs.readObject();
                customerEmailList = (List<CustomerEmail>) objIs.readObject();
                logger.info("All Payment Complaints fetched");
            }
            else if (action.equalsIgnoreCase("View Internet Complaints")){
                complaintList = (List<Complaint>) objIs.readObject();
                customerList = (List<Customer>) objIs.readObject();
                customerPhoneList = (List<CustomerPhone>) objIs.readObject();
                customerEmailList = (List<CustomerEmail>) objIs.readObject();
                logger.info("All Internet Complaints fetched");
            }
            else if (action.equalsIgnoreCase("View Cable Complaints")){
                complaintList = (List<Complaint>) objIs.readObject();
                customerList = (List<Customer>) objIs.readObject();
                customerPhoneList = (List<CustomerPhone>) objIs.readObject();
                customerEmailList = (List<CustomerEmail>) objIs.readObject();
                logger.info("All Cable Complaints fetched");
            }
            else if (action.equalsIgnoreCase("View Other Complaints")){
                complaintList = (List<Complaint>) objIs.readObject();
                customerList = (List<Customer>) objIs.readObject();
                customerPhoneList = (List<CustomerPhone>) objIs.readObject();
                customerEmailList = (List<CustomerEmail>) objIs.readObject();
                logger.info("Other Complaints fetched");
            }
            else if (action.equalsIgnoreCase("View Complaint details and Customer account info")){
                customerObj = (Customer) objIs.readObject();
                complaintObj = (Complaint) objIs.readObject();
                customerPhoneList = (List<CustomerPhone>) objIs.readObject();
                customerEmailList = (List<CustomerEmail>) objIs.readObject();
                logger.info("Complaint details fetched along with associated Customer info");
            }
            else if (action.equalsIgnoreCase("Employee Create LiveChat")){
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
            else if (action.equalsIgnoreCase("CSR Create Response")){
                flag = (boolean) objIs.readObject();
                if (flag){
                    logger.info("Customer Service Rep created a Response successfully");
                }
                else{
                    logger.error("ERROR: Customer Service Rep's Response was not created");
                }
            }
            else if (action.equalsIgnoreCase("Add a Technician ID to a Complaint")){
                flag = (boolean) objIs.readObject();
                if (flag){
                    logger.info("Complaint updated successfully");
                }
                else{
                    logger.error("ERROR: Complaint was not updated");
                }
            }
            else if (action.equalsIgnoreCase("View Complaints assigned to a Technician")){
                complaintList = (List<Complaint>) objIs.readObject();
                customerList = (List<Customer>) objIs.readObject();
                customerPhoneList = (List<CustomerPhone>) objIs.readObject();
                customerEmailList = (List<CustomerEmail>) objIs.readObject();
                logger.info("Complaints assigned to a particular Technician fetched");
            }
            else if (action.equalsIgnoreCase("Technician Create Response")){
                flag = (boolean) objIs.readObject();
                if (flag){
                    logger.info("Technician created a Response successfully");
                }
                else{
                    logger.error("ERROR: Technician's Response was not created");
                }
            }
            else if (action.equalsIgnoreCase("Is Employee a Technician?")){
                flag = (boolean) objIs.readObject();
                if (flag){
                    logger.info("Employee is a Technician");
                }
                else{
                    logger.info("Employee is not a Technician");
                }
            }
            else if (action.equalsIgnoreCase("Transmit video frame")){
            	videoFrameObj = (VideoFrame) objIs.readObject();
            	logger.info("Video frame fetched");
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

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getResolved() {
        return resolved;
    }

    public void setResolved(int resolved) {
        this.resolved = resolved;
    }

    public int getUnresolved() {
        return unresolved;
    }

    public void setUnresolved(int unresolved) {
        this.unresolved = unresolved;
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

    public List<LiveChat> getLiveChatList() {
        return liveChatList;
    }

    public void setLiveChatList(List<LiveChat> liveChatList) {
        this.liveChatList = liveChatList;
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

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
    
    public VideoFrame getVideoFrame() {
        return videoFrameObj;
    }

    public void setVideoFrame(VideoFrame videoFrame) {
        this.videoFrameObj = videoFrame;
    }
}
