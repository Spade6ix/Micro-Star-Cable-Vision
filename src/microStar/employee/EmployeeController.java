package microStar.employee;

import microStar.model.Complaint;
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
    	List<Complaint> data1 = new ArrayList<Complaint>();
    	
		empClient.sendAction("View Internet Complaints");
		empClient.sendComplaintObj(empClient.getComplaintObj());
		empClient.receiveResponse();
		
		data1 = empClient.getComplaintList();
		data = new String[empClient.getComplaintList().size()][8];
        int i=0;
        int j=0;
        for (Complaint p: data1){
            data[i][j] = (p.getComplaintID()) + "";
            j++;
            data[i][j] = p.getCustomerID();
            j++;
            data[i][j] = "Name";
            j++;
            data[i][j] = "Contact";
            j++;
            data[i][j] = "Address";
            j++;
            data[i][j] = p.getComplaintType();
            j++;
            data[i][j] = p.getComplaintDetails();
            j++;
            data[i][j] = p.getStaffID();
            j=0;
            i++;
        }
		
		return data;
    }
    
    
    
    
    public static String[][] getCableComplaintsData() {
    	String[][] data = null;
    	List<Complaint> data1 = new ArrayList<Complaint>();
    	
		empClient.sendAction("View Cable Complaints");
		empClient.sendComplaintObj(empClient.getComplaintObj());
		empClient.receiveResponse();
		
		data1 = empClient.getComplaintList();
		data = new String[empClient.getComplaintList().size()][8];
        int i=0;
        int j=0;
        for (Complaint p: data1){
            data[i][j] = (p.getComplaintID()) + "";
            j++;
            data[i][j] = p.getCustomerID();
            j++;
            data[i][j] = "Name";
            j++;
            data[i][j] = "Contact";
            j++;
            data[i][j] = "Address";
            j++;
            data[i][j] = p.getComplaintType();
            j++;
            data[i][j] = p.getComplaintDetails();
            j++;
            data[i][j] = p.getStaffID();
            j=0;
            i++;
        }
		
		return data;
    }
    
    
    
    
    public static String[][] getPaymentComplaintsData() {
    	String[][] data = null;
    	List<Complaint> data1 = new ArrayList<Complaint>();
    	
		empClient.sendAction("View Payment Complaints");
		empClient.sendComplaintObj(empClient.getComplaintObj());
		empClient.receiveResponse();
		
		data1 = empClient.getComplaintList();
		data = new String[empClient.getComplaintList().size()][8];
        int i=0;
        int j=0;
        for (Complaint p: data1){
            data[i][j] = (p.getComplaintID()) + "";
            j++;
            data[i][j] = p.getCustomerID();
            j++;
            data[i][j] = "Name";
            j++;
            data[i][j] = "Contact";
            j++;
            data[i][j] = "Address";
            j++;
            data[i][j] = p.getComplaintType();
            j++;
            data[i][j] = p.getComplaintDetails();
            j++;
            data[i][j] = p.getStaffID();
            j=0;
            i++;
        }
		
		return data;
    }
    
    
    
    
    public static String[][] getOtherComplaintsData() {
    	String[][] data = null;
    	List<Complaint> data1 = new ArrayList<Complaint>();
    	
		empClient.sendAction("View Other Complaints");
		empClient.sendComplaintObj(empClient.getComplaintObj());
		empClient.receiveResponse();
		
		data1 = empClient.getComplaintList();
		data = new String[empClient.getComplaintList().size()][8];
        int i=0;
        int j=0;
        for (Complaint p: data1){
            data[i][j] = (p.getComplaintID()) + "";
            j++;
            data[i][j] = p.getCustomerID();
            j++;
            data[i][j] = "Name";
            j++;
            data[i][j] = "Contact";
            j++;
            data[i][j] = "Address";
            j++;
            data[i][j] = p.getComplaintType();
            j++;
            data[i][j] = p.getComplaintDetails();
            j++;
            data[i][j] = p.getStaffID();
            j=0;
            i++;
        }
		
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
        //System.out.println(empClient.getComplaintObj().getStaffID());
		empClient.sendComplaintObj(empClient.getComplaintObj());
		empClient.receiveResponse();
		
		data1 = empClient.getComplaintList();
		data = new String[empClient.getComplaintList().size()][8];
        int i=0;
        int j=0;
        for (Complaint p: data1){
            data[i][j] = (p.getComplaintID()) + "";
            j++;
            data[i][j] = p.getCustomerID();
            j++;
            data[i][j] = "Name";
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
    	empClient.getResponseObj().setProposedDateOfVisit(date);
    	empClient.getResponseObj().setResponseDetails(response);
    	empClient.getResponseObj().setComplaintID(Integer.parseInt(complaintId));
		empClient.sendResponseObj(empClient.getResponseObj());
		empClient.receiveResponse();	
		
    }
    
}
