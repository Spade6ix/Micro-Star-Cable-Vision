package microStar.customer;


import com.github.sarxos.webcam.Webcam;
import com.mysql.cj.xdevapi.Client;
import microStar.factory.DBConnectorFactory;
import microStar.factory.SessionFactoryBuilder;
import microStar.model.*;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

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
        c = new Customer();
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
		CustomerView.accountStatusScreen.txtad.setText(client.getQueryObj().getAmountDue() + "");
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
                data[i][j] = p.getAmountPaid() + "";
                j=0;
                i++;
            }
            return data;
    	}
    
    
    
    
    
    public static String[][] getComplaintHistory(){
    	String[][] data = null;
    	List<Complaint> data1 = new ArrayList<Complaint>();
        List<Response> data2 = new ArrayList<Response>();
        List<Employee> data3 = new ArrayList<Employee>();
    	
		client.sendAction("View All Complaints of a Customer");
		client.sendCustomerObj(client.getCustomerObj());
		client.receiveResponse();
		
		data1 = client.getComplaintList();
		data2 = client.getResponseList();
		data3 = client.getEmployeeList();

		data = new String[client.getComplaintList().size()][4];
        int i=0;
        int j=0;
        for (Complaint p: data1){
            data[i][j] = (p.getComplaintID()) + "";
            j = j+3;
            data[i][j] = p.getComplaintDetails();
            j=0;
            i++;
        }

        i=0;
        j=1;
        for (Employee p: data3){
            data[i][j] = p.getFirstName() + " " + p.getLastName() + "";
            i++;
        }

        i=0;
        j=2;
        for (Response p: data2){
            data[i][j] = p.getResponseDateTime().getYear() + "-" + p.getResponseDateTime().getMonthValue() + "-" + p.getResponseDateTime().getDayOfMonth() + "";
            i++;
        }
		
		return data;
    }
    
    
    
    
    public static String[][] getComplaintDetails(String complaintId){
    	String[][] data = null;
    	List<Response> data1 = new ArrayList<Response>();

        Complaint c = new Complaint();
        //c = client.getComplaintObj();
        c.setComplaintID(Integer.parseInt(complaintId));

		client.sendAction("View All Responses to a Complaint");
		//client.getComplaintObj().setComplaintID(Integer.parseInt(complaintId));
		client.sendComplaintObj(c);
		client.receiveResponse();
		data1 = client.getResponseList();
		
		data = new String[client.getResponseList().size()][3];
        int i=0;
        int j=0;
        for (Response p: data1){
            data[i][j] = p.getStaffID();
            j++;
            data[i][j] = p.getResponseDetails();
            j++;
            data[i][j] = p.getProposedDateOfVisit() + "";
            j=0;
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
    			
    			CustomerView.liveVideoChatScreen.statusLabel.setText("Status: Disconnected");
    			CustomerView.liveVideoChatScreen.status2Label.setText("Incoming from: ");
    			
    			while(true) {
    			
    				client.receiveVideoResponse();
    				
    				if(CustomerView.liveVideoChatScreen.toggle == 0) {
    					CustomerView.liveVideoChatScreen.statusLabel.setText("Status: Disconnected");  
    					CustomerView.liveVideoChatScreen.video2.setIcon(new ImageIcon("images/image2.png"));
    					
    					if(client.getVideoSourceState().equals("exit")) {
        					break;
        				}
    		    	}
    				
    				if(client.getVideoSourceState().equals("end")) {
    					CustomerView.liveVideoChatScreen.status2Label.setText("Incoming from: "); 
    					CustomerView.liveVideoChatScreen.video1.setIcon(client.getVideoFrame());
    				}

    		    	
    		    	if(client.getVideoSourceState().equals("go")) {
    		    		CustomerView.liveVideoChatScreen.video1.setIcon(client.getVideoFrame());
    		    		CustomerView.liveVideoChatScreen.status2Label.setText("Incoming from: " + client.getVideoSourceId());
    		    		
    		    		if(CustomerView.liveVideoChatScreen.toggle == 1) {
    		    			CustomerView.liveVideoChatScreen.statusLabel.setText("Status: Connected"); 
    		    		}
    		    	}
    	    	}

    		}
    	};
    	videoRecieve.start();
    }
    
    
    
    
    
    public static void exitVideoChatScreen() throws Exception{
    	if(videoRecieve.isAlive()) {
    		if(CustomerView.liveVideoChatScreen.toggle == 1) {
        		JOptionPane.showMessageDialog(CustomerView.liveVideoChatScreen, "You must stop video chat before leaving this screen!", "Error", JOptionPane.INFORMATION_MESSAGE);
        		throw new Exception("stop video chat");
        	}

        	ImageIcon defaultFrame = new ImageIcon("images/image1.png");
        	client.sendAction("Transmit video frame");
    		client.sendVideoFrameObj(defaultFrame, client.getCustomerObj().getCustomerID(), "exit");
    		
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
	    				
	    				if(CustomerView.currentPanel != CustomerView.liveVideoChatScreen || CustomerView.liveVideoChatScreen.toggle == 0){
	    					client.sendAction("Transmit video frame");
		    				client.sendVideoFrameObj(defaultFrame, id, "end");
	    					if(cam.isOpen()) {
	    						cam.close();
	    					}  
	    		    		break;
	    		    	}
	    				
	    				bf = cam.getImage();
	    				frame = new ImageIcon(bf);
	    				
	    				//video1
	    				client.sendAction("Transmit video frame");
	    				client.sendVideoFrameObj(frame, id, "go");
	    				
	    				//video 2
	    				frame = new ImageIcon(bf.getScaledInstance(320, 240, Image.SCALE_FAST));
	    				CustomerView.liveVideoChatScreen.video2.setIcon(frame);
	    	    	}
				}catch(Exception ex) {
					logger.info("camera is being used by another application");
				}
		
			}
		};
	    videoSend.start();	
	 }
    
  
    
}
