package microStar.employee;

import microStar.model.*;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.sarxos.webcam.Webcam;

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
    	e = new Employee();
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
		/*empClient.getComplaintObj().setComplaintID(Integer.parseInt(complaintId));
		empClient.getComplaintObj().setStaffID(techId);
		System.err.println(empClient.getComplaintObj().getComplaintID());*/
		Employee emp = new Employee();
		emp.setStaffID(techId);

		empClient.sendAction("Is Employee a Technician?");
		empClient.sendEmployeeObj(emp);
		empClient.receiveResponse();
		if (empClient.isFlag()){
			empClient.sendAction("Add a Technician ID to a Complaint");

			Complaint complaint = new Complaint();
			complaint.setComplaintID(Integer.parseInt(complaintId));
			complaint.setStaffID(techId);

			empClient.sendComplaintObj(complaint);
			empClient.receiveResponse();
		}
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
		List<Customer> data2 = new ArrayList<Customer>();
		List<CustomerPhone> data3 = new ArrayList<CustomerPhone>();
		List<CustomerEmail> data4 = new ArrayList<CustomerEmail>();
		Complaint c = new Complaint();

		c.setStaffID(empClient.getEmployeeObj().getStaffID());

		empClient.sendAction("View Complaints assigned to a Technician");
		empClient.sendComplaintObj(c);
		empClient.receiveResponse();
		
		data1 = empClient.getComplaintList();
		data2 = empClient.getCustomerList();
		data3 = empClient.getCustomerPhoneList();
		data4 = empClient.getCustomerEmailList();

		data = new String[empClient.getComplaintList().size()][9];
        int i=0;
        int j=0;
        for (Complaint p: data1){
            data[i][j] = (p.getComplaintID()) + "";
            j++;
            data[i][j] = p.getCustomerID();
            j=j+5;
            data[i][j] = p.getComplaintType();
            j++;
            data[i][j] = p.getComplaintDetails();
            j++;
            data[i][j] = p.getStatus() + "";
            j=0;
            i++;
        }

		i=0;
		j=2;
		for (Customer p: data2){
			data[i][j] = p.getFirstName() + " " + p.getLastName();
			j=j+3;
			data[i][j] = p.getAddress();
			j=2;
			i++;
		}

		i=0;
		j=4;
		for (CustomerPhone p: data3){
			data[i][j] = p.getPhone();
			i++;
		}

		i=0;
		j=3;
		for (CustomerEmail p: data4){
			data[i][j] = p.getEmail();
			i++;
		}
		
		return data;
    }
    
    
    
    
    
    
    public static void setComplaintResponse(String response, String dov, String complaintId) {
    	/*DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    	LocalDateTime date = LocalDateTime.parse(dov, formatter);
    	empClient.sendAction("Technician Create Response");
    	empClient.getResponseObj().setProposedDateOfVisit(date);
    	empClient.getResponseObj().setResponseDetails(response);
    	empClient.getResponseObj().setComplaintID(Integer.parseInt(complaintId));
		empClient.getResponseObj().setStaffID(empClient.getEmployeeObj().getStaffID());
		empClient.sendResponseObj(empClient.getResponseObj());
		empClient.receiveResponse();*/

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    	LocalDateTime date = LocalDateTime.parse(dov, formatter);
		Response rObj = new Response();

		rObj.setProposedDateOfVisit(date);
		rObj.setResponseDetails(response);
		rObj.setComplaintID(Integer.parseInt(complaintId));
		rObj.setStaffID(empClient.getEmployeeObj().getStaffID());

    	empClient.sendAction("Technician Create Response");
		empClient.sendResponseObj(rObj);
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
    
    
    
    
    
    
    
    
    
public static VideoRecieve videoRecieve = new VideoRecieve();
	
    public static void incomingVideo() { //Listen for incoming video chat requests
    	
    	videoRecieve  = new VideoRecieve(){
    		@Override
    		public void run() {
    			
    			System.out.println("incoming video chat thread is running");
    			
    			EmployeeView.liveVideoChatScreen.statusLabel.setText("Status: Disconnected");
    			EmployeeView.liveVideoChatScreen.status2Label.setText("Incoming from: ");
    			
    			while(true) {
    			
    				empClient.receiveVideoResponse();
    				
    				if(EmployeeView.liveVideoChatScreen.toggle == 0) {
    					EmployeeView.liveVideoChatScreen.statusLabel.setText("Status: Disconnected");  
    					EmployeeView.liveVideoChatScreen.video2.setIcon(new ImageIcon("images/image2.png"));
    					
    					if(empClient.getVideoSourceState().equals("exit")) {
        					break;
        				}
    		    	}
    				
    				if(empClient.getVideoSourceState().equals("end")) {
    					EmployeeView.liveVideoChatScreen.status2Label.setText("Incoming from: "); 
    					EmployeeView.liveVideoChatScreen.video1.setIcon(empClient.getVideoFrame());
    				}

    		    	
    		    	if(empClient.getVideoSourceState().equals("go")) {
    		    		EmployeeView.liveVideoChatScreen.video1.setIcon(empClient.getVideoFrame());
    		    		EmployeeView.liveVideoChatScreen.status2Label.setText("Incoming from: " + empClient.getVideoSourceId());
    		    		
    		    		if(EmployeeView.liveVideoChatScreen.toggle == 1) {
    		    			EmployeeView.liveVideoChatScreen.statusLabel.setText("Status: Connected"); 
    		    		}
    		    	}
    	    	}

    		}
    	};
    	videoRecieve.start();
    }
 
 
 
 
 
 
 
 
 public static void exitVideoChatScreen() throws Exception{
 	if(videoRecieve.isAlive()) {
 		if(EmployeeView.liveVideoChatScreen.toggle == 1) {
     		JOptionPane.showMessageDialog(EmployeeView.liveVideoChatScreen, "You must stop video chat before leaving this screen!", "Error", JOptionPane.INFORMATION_MESSAGE);
     		throw new Exception("stop video chat");
     	}

     	ImageIcon defaultFrame = new ImageIcon("images/image1.png");
     	empClient.sendAction("Transmit video frame");
 		empClient.sendVideoFrameObj(defaultFrame, empClient.getEmployeeObj().getStaffID(), "exit");
 		
 		while(true) {
 			if(!videoRecieve.isAlive()) {
 				break;
 			}
 		}
 	}
 }
    
    
    
    
    
    
    
    
    
 public static VideoSend videoSend = new VideoSend();
	
	public static void outgoingVideo(String id) { //Listen for incoming video chat requests
	    	
		videoSend = new VideoSend() {
			@Override
			public void run() {
				
				System.out.println("outgoing video chat thread is running");
				
				ImageIcon frame;
				ImageIcon defaultFrame = new ImageIcon("images/image1.png");
				BufferedImage bf;
				
				try {
					
					Webcam cam = Webcam.getDefault();
					cam.setViewSize(new Dimension(640, 480));
					cam.open();
					
	    			while(true) {
	    				
	    				if(EmployeeView.currentPanel != EmployeeView.liveVideoChatScreen || EmployeeView.liveVideoChatScreen.toggle == 0){
	    					empClient.sendAction("Transmit video frame");
		    				empClient.sendVideoFrameObj(defaultFrame, id, "end");
	    					if(cam.isOpen()) {
	    						cam.close();
	    					}  
	    		    		break;
	    		    	}
	    				
	    				bf = cam.getImage();
	    				frame = new ImageIcon(bf);
	    				
	    				//video1
	    				empClient.sendAction("Transmit video frame");
	    				empClient.sendVideoFrameObj(frame, id, "go");
	    				
	    				//video 2
	    				frame = new ImageIcon(bf.getScaledInstance(320, 240, Image.SCALE_FAST));
	    				EmployeeView.liveVideoChatScreen.video2.setIcon(frame);
	    	    	}
				}catch(Exception ex) {
					logger.info("camera is being used by another application");
				}
		
			}
		};
	    videoSend.start();	
	 }
    
    
}
