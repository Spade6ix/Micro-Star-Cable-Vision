package microStar.customer;


import com.mysql.cj.xdevapi.Client;
import microStar.factory.DBConnectorFactory;
import microStar.factory.SessionFactoryBuilder;
import microStar.model.Customer;
import microStar.model.Payment;

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
    
    
    
    
    public static String[][] getPaymentHistory(){
    	String[][] data = null;
    	List<Payment> data1 = new ArrayList<Payment>();
    	
		client.sendAction("View All Payments made by a Customer");
		client.sendCustomerObj(client.getCustomerObj());
		client.receiveResponse();
		
		data1 = client.getPaymentList();
		data = Arrays.copyOf(data1.toArray(), data1.size(), String[][].class);

		//System.out.println(data1.size());
		//System.out.println(data.length);
		return data;
    	}
}
