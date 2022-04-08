package microStar.employee;

import microStar.customer.CustomerClient;
import microStar.customer.CustomerController;
import microStar.factory.DBConnectorFactory;
import microStar.factory.SessionFactoryBuilder;
import microStar.model.Complaint;
import microStar.model.Customer;
import microStar.model.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EmployeeController {
    private static final Logger logger = LogManager.getLogger(EmployeeController.class);
    public static EmployeeClient empClient;
    public static Employee e;

    public EmployeeController(){
        empClient = new EmployeeClient();
        e = new Employee();
    }

    /*public static void main(String[] args) {
        try{

        }
        catch(Exception e){
            e.printStackTrace();
            logger.error("Exception Occurred");
        }
        finally {
            
        }
    }*/
    
    
    
    public static void login() {
    	e.setStaffID(String.valueOf(EmployeeView.loginScreen.idTextField.getText()));
		e.setPassword(String.valueOf(EmployeeView.loginScreen.passwordTextField.getText()));
		empClient.sendAction("Employee Login");
		empClient.sendEmployeeObj(e);
		empClient.receiveResponse();
    }
    
    
    
    public static String[][] getInternetComplaintsData() {
    	String[][] data = null;
    	List<Complaint> data1 = new ArrayList<Complaint>();
    	
		empClient.sendAction("View Internet Complaints");
		empClient.sendComplaintObj(empClient.getComplaintObj());
		empClient.receiveResponse();
		
		data1 = empClient.getComplaintList();
		data = Arrays.copyOf(data1.toArray(), data1.size(), String[][].class);
		
		return data;
    }
    
    
    
    
    public static String[][] getCableComplaintsData() {
    	String[][] data = null;
    	List<Complaint> data1 = new ArrayList<Complaint>();
    	
		empClient.sendAction("View Cable Complaints");
		empClient.sendComplaintObj(empClient.getComplaintObj());
		empClient.receiveResponse();
		
		data1 = empClient.getComplaintList();
		data = Arrays.copyOf(data1.toArray(), data1.size(), String[][].class);
		
		return data;
    }
    
    
    
    
    public static String[][] getPaymentComplaintsData() {
    	String[][] data = null;
    	List<Complaint> data1 = new ArrayList<Complaint>();
    	
		empClient.sendAction("View Payment Complaints");
		empClient.sendComplaintObj(empClient.getComplaintObj());
		empClient.receiveResponse();
		
		data1 = empClient.getComplaintList();
		data = Arrays.copyOf(data1.toArray(), data1.size(), String[][].class);
		
		return data;
    }
    
    
    
    
    public static String[][] getOtherComplaintsData() {
    	String[][] data = null;
    	List<Complaint> data1 = new ArrayList<Complaint>();
    	
		empClient.sendAction("View Other Complaints");
		empClient.sendComplaintObj(empClient.getComplaintObj());
		empClient.receiveResponse();
		
		data1 = empClient.getComplaintList();
		data = Arrays.copyOf(data1.toArray(), data1.size(), String[][].class);
		
		return data;
    }
    
    
    
    public static void assignTechnician(String id, String tech) {
    	// save value
    }
    
}
