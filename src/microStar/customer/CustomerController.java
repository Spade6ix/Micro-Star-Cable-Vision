package microStar.customer;


import com.mysql.cj.xdevapi.Client;
import microStar.factory.DBConnectorFactory;
import microStar.factory.SessionFactoryBuilder;
import microStar.model.Complaint;
import microStar.model.Customer;
import microStar.model.Payment;
import microStar.model.Response;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomerController {
    private static final Logger logger = LogManager.getLogger(CustomerController.class);
    public static CustomerClient client;
    public static Customer c;

    public CustomerController(){
        client = new CustomerClient();
        c = new Customer();
    }

    /*public static void main(String[] args) {
        try{

        }
        catch(Exception e){
            e.printStackTrace();
            logger.error("Exception Occurred");
        }
        //finally{
            //client.closeConnection();
        //}
    }*/
    
    
    
    
    public static void login() {
    	c.setCustomerID(String.valueOf(CustomerView.loginScreen.idTextField.getText()));
		c.setPassword(String.valueOf(CustomerView.loginScreen.passwordTextField.getText()));
		client.sendAction("Customer Login");
		client.sendCustomerObj(CustomerController.c);
		client.receiveResponse();
    }
    
    
    
    
    
    public static void getAccountStatus() {
    	client.sendAction("Make Query");
		client.sendCustomerID(CustomerController.client.getCustomerObj().getCustomerID());
		client.receiveResponse();
		
		CustomerView.accountStatusScreen.txtps.setText(client.getQueryObj().getPaymentStatus());
		CustomerView.accountStatusScreen.txtad.setText(client.getQueryObj().getAmountDue().toString());
		CustomerView.accountStatusScreen.txtpdd.setText(client.getQueryObj().getDueDate());
    }
    
    
    
    
    
    
    public static String[][] getPaymentHistory(){
            String[][] data = null;
            List<Payment> data1 = new ArrayList<Payment>();
            
            client.sendAction("View All Payments made by a Customer");
            client.sendCustomerObj(client.getCustomerObj());
            client.receiveResponse();
    
            data1 = client.getPaymentList();
    
            data = new String[client.getPaymentList().size()][2];
            int i=0;
            int j=0;
            for (Payment p: data1){
                data[i][j] = p.getDateOfPayment();
                j++;
                data[i][j] = p.getAmountPaid().toString();
                j=0;
                i++;
            }
            return data;
    	}
    
    
    
    
    
    public static String[][] getComplaintHistory(){
    	String[][] data = null;
    	List<Complaint> data1 = new ArrayList<Complaint>();
    	
		client.sendAction("View All Complaints of a Customer");
		client.sendCustomerObj(client.getCustomerObj());
		client.receiveResponse();
		
		data1 = client.getComplaintList();
		data = Arrays.copyOf(data1.toArray(), data1.size(), String[][].class);

		return data;
    }
    
    
    
    
    public static String[][] getComplaintDetails(){
    	String[][] data = null;
    	List<Response> data1 = new ArrayList<Response>();
    	
		client.sendAction("View All Responses to a complaint");
		client.sendCustomerObj(client.getCustomerObj());
		client.receiveResponse();
		
		data1 = client.getResponseList();
		data = Arrays.copyOf(data1.toArray(), data1.size(), String[][].class);
		

		return data;
    }
    
    
    
    
    
    
    
    
}
