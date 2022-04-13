package microStar.employee;

import microStar.model.Complaint;
import microStar.model.Customer;
import microStar.model.CustomerEmail;
import microStar.model.CustomerPhone;
import microStar.model.Employee;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
    	List<Complaint> complaintData = new ArrayList<Complaint>();
    	List<Customer> customerData = new ArrayList<Customer>();
    	List<CustomerEmail> emailData = new ArrayList<CustomerEmail>();
    	List<CustomerPhone> phoneData = new ArrayList<CustomerPhone>();
    	
		empClient.sendAction("View Internet Complaints");
		empClient.sendComplaintObj(empClient.getComplaintObj());
		empClient.receiveResponse();
		
		complaintData = empClient.getComplaintList();
		customerData = empClient.getCustomerList();
		emailData = empClient.getCustomerEmailList();
		phoneData = empClient.getCustomerPhoneList();		
		
        data = getTableData(complaintData, customerData, emailData, phoneData);
		
		return data;
    }
    
    
    
    
    
    
    public static String[][] getCableComplaintsData() {
    	String[][] data = null;
    	List<Complaint> complaintData = new ArrayList<Complaint>();
    	List<Customer> customerData = new ArrayList<Customer>();
    	List<CustomerEmail> emailData = new ArrayList<CustomerEmail>();
    	List<CustomerPhone> phoneData = new ArrayList<CustomerPhone>();
    	
		empClient.sendAction("View Cable Complaints");
		empClient.sendComplaintObj(empClient.getComplaintObj());
		empClient.receiveResponse();
		
		complaintData = empClient.getComplaintList();
		customerData = empClient.getCustomerList();
		emailData = empClient.getCustomerEmailList();
		phoneData = empClient.getCustomerPhoneList();		
		
        data = getTableData(complaintData, customerData, emailData, phoneData);
		
		return data;
    }
    
    
    
    
    
    
    public static String[][] getPaymentComplaintsData() {
    	String[][] data = null;
    	List<Complaint> complaintData = new ArrayList<Complaint>();
    	List<Customer> customerData = new ArrayList<Customer>();
    	List<CustomerEmail> emailData = new ArrayList<CustomerEmail>();
    	List<CustomerPhone> phoneData = new ArrayList<CustomerPhone>();
    	
		empClient.sendAction("View Payment Complaints");
		empClient.sendComplaintObj(empClient.getComplaintObj());
		empClient.receiveResponse();
		
		complaintData = empClient.getComplaintList();
		customerData = empClient.getCustomerList();
		emailData = empClient.getCustomerEmailList();
		phoneData = empClient.getCustomerPhoneList();		
		
        data = getTableData(complaintData, customerData, emailData, phoneData);
		
		return data;
    }
    
    
    
    
    
    
    public static String[][] getOtherComplaintsData() {
    	String[][] data = null;
    	List<Complaint> complaintData = new ArrayList<Complaint>();
    	List<Customer> customerData = new ArrayList<Customer>();
    	List<CustomerEmail> emailData = new ArrayList<CustomerEmail>();
    	List<CustomerPhone> phoneData = new ArrayList<CustomerPhone>();
    	
		empClient.sendAction("View Other Complaints");
		empClient.sendComplaintObj(empClient.getComplaintObj());
		empClient.receiveResponse();
		
		complaintData = empClient.getComplaintList();
		customerData = empClient.getCustomerList();
		emailData = empClient.getCustomerEmailList();
		phoneData = empClient.getCustomerPhoneList();		
		
        data = getTableData(complaintData, customerData, emailData, phoneData);
		
		return data;
    }
    
    
    
    
    
    public static void assignTechnician(String complaintId, String techId) {
    	empClient.sendAction("Add a Technician ID to a Complaint");
    	empClient.getComplaintObj().setComplaintID(Integer.parseInt(complaintId));
    	empClient.getComplaintObj().setStaffID(techId);
		empClient.sendComplaintObj(empClient.getComplaintObj());
		empClient.receiveResponse();	
    }
    
    
    
    
    
    public static int getResolvedCount() {
    	empClient.sendAction("View Number of Resolved & Unresolved Complaints");
    	empClient.sendComplaintObj(empClient.getComplaintObj());
		empClient.receiveResponse();
		
		return empClient.getResolved();
    }
    
    
    
    
    
    
    public static int getCoutstandingCount() {
    	empClient.sendAction("View Number of Resolved & Unresolved Complaints");
    	empClient.sendComplaintObj(empClient.getComplaintObj());
		empClient.receiveResponse();
		
		return empClient.getUnresolved();
    }
    
    
    
    
    
    
    public static String[][] getRespondData() {
    	String[][] data = null;
    	List<Complaint> data1 = new ArrayList<Complaint>();
    	
		empClient.sendAction("View Complaints assigned to a Technician");
        empClient.getComplaintObj().setStaffID(empClient.getEmployeeObj().getStaffID());
		empClient.sendComplaintObj(empClient.getComplaintObj());
		empClient.receiveResponse();
		
		data1 = empClient.getComplaintList();
		data = new String[empClient.getComplaintList().size()][9];
        int i=0;
        int j=0;
        for (Complaint p: data1){
            data[i][j] = (p.getComplaintID()) + "";
            j++;
            data[i][j] = p.getCustomerID();
            j++;
            data[i][j] = "Name";
            j++;
            data[i][j] = "Email";
            j++;
            data[i][j] = "Contact";
            j++;
            data[i][j] = "Address";
            j++;
            data[i][j] = p.getComplaintType();
            j++;
            data[i][j] = p.getComplaintDetails();
            j++;
            data[i][j] = p.getStatus() + "";
            j=0;
            i++;
        }
		
		return data;
    }
    
    
    
    
    
    
    public static void setComplaintResponse(String response, String dov, String complaintId) {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    	LocalDateTime date = LocalDateTime.parse(dov, formatter);

    	empClient.sendAction("Technician Create Response");
    	System.out.println("complete");
    	empClient.getResponseObj().setProposedDateOfVisit(date);
    	empClient.getResponseObj().setResponseDetails(response);
    	empClient.getResponseObj().setComplaintID(Integer.parseInt(complaintId));
		empClient.sendResponseObj(empClient.getResponseObj());
		empClient.receiveResponse();	
		
    }
    
    
    
    
    
    
    
    //HELPER METHODS---------------------------------------------------------------------
    
    @SuppressWarnings("unused")
	private static String[][] getTableData(List<Complaint> complaintData, List<Customer> customerData, 
    		List<CustomerEmail> emailData, List<CustomerPhone> phoneData) {
    	
    	String[][] data = new String[empClient.getComplaintList().size()][9];
    	
    	int i=0;
        int j=0;
        for (Complaint p: complaintData){
            data[i][j] = (p.getComplaintID()) + "";
            j++;
            data[i][j] = p.getCustomerID();
            j++;
            data[i][j] = "";
            j++;
            data[i][j] = "";
            j++;
            data[i][j] = "";
            j++;
            data[i][j] = "";
            j++;
            data[i][j] = p.getComplaintType();
            j++;
            data[i][j] = p.getComplaintDetails();
            j++;
            data[i][j] = p.getStaffID();
            j=0;
            i++;
        }
        
        i=0;
        j=0;
        for (Customer p: customerData) {
        	data[i][j+2] = p.getFirstName() + " " + p.getLastName();
        	j = 0;
        	data[i][j+5] = p.getAddress();
        	j = 0;
        	i++;
        }
        i=0;
        j=0;
        for (CustomerEmail p: emailData) {
        	data[i][j+3] = p.getEmail();
        	j = 0;
        	i++;
        }
        i=0;
        j=0;
        for (CustomerPhone p: phoneData) {
        	data[i][j+4] = p.getPhone();
        	j = 0;
        	i++;
        }
        
        return data;
    }
    
    
    
    
    
}
