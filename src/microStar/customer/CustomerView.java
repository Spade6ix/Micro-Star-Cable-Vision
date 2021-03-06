package microStar.customer;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import microStar.employee.EmployeeController;
import microStar.model.VideoRecieve;



public class CustomerView implements MouseListener, ActionListener{
	
	public static JPanel currentPanel = null;
	
	public static LoginScreen loginScreen = null;
	public static Dashboard dashboard = null;
	public static WelcomeScreen welcomeScreen = null;
	public static LodgeComplaintScreen lodgeComplaintScreen = null;
	public static AccountStatusScreen accountStatusScreen= null;
	public static ComplaintHistoryScreen complaintHistoryScreen= null;
	public static PaymentHistoryScreen paymentHistoryScreen = null;
	public static LiveChatScreen liveChatScreen = null;
	public static LiveVideoChatScreen liveVideoChatScreen = null;
	
	
	public static void main(String[] args) {  //FOR UI TESTING PURPOSES
		new CustomerController();
		CustomerView customerView = new CustomerView();
		customerView.createCustomerLoginScreen();
	}
	
	
	
	

	public void createCustomerLoginScreen() {
		/*public vars
		  
		  Customer login = "cust"
		  
		 loginScreen.idTextField						-ID TextField	
    	 loginScreen.passwordTextField 					-Password TextField
    	 loginScreen.loginButton 						-Login Button
		 */
		LoginScreen obj = new LoginScreen();
		obj.loginButton.addActionListener(this);
		loginScreen = obj;
	}
	
	
	
	
	
	
	
	public void createCustomerDashboard() {
		/*public vars
		  
	  	dashboard.lodgeComplaint 						-Lodge Complaint
		dashboard.accountStatus 						-Account Status
		dashboard.paymentHistory 						-Payment History
		dashboard.complaintHistory 						-Complaint History
		dashboard.liveVideoChat 						-live video chat 
		dashboard.liveChat								-liveChat
		 */
		Dashboard obj = new Dashboard();
		obj.lodgeComplaint.addActionListener(this);
		obj.accountStatus.addActionListener(this);
		obj.paymentHistory.addActionListener(this);
		obj.complaintHistory.addActionListener(this);
		obj.liveVideoChat.addActionListener(this);
		obj.liveChat.addActionListener(this);
		dashboard = obj;
	}
	
	
	
	
	
	
	
	
	public void createCustomerWelcomeScreen() {
		/*public vars
		  
		 welcomeScreen.welcomeMessage    			    - Welcome message JLabel
		 */
		WelcomeScreen obj = new WelcomeScreen();
		welcomeScreen = obj;
	}
	
	
	
	
	
	
	public void createCustomerLodgeComplaintScreen() {
		/*public vars
		  
		lodgeComplainScreen.id							- id TextField
		lodgeComplainScreen.firstName 					- first name TextField
		lodgeComplainScreen.lastName 					- last name TextField
		lodgeComplainScreen.contact 					- contact TextField
		lodgeComplainScreen.email 						- email TextField
		lodgeComplainScreen.street 						- street TextField
		lodgeComplainScreen.parish_state				- parish/state TextField
		lodgeComplainScreen.issueType 					- issueType TextField
		lodgeComplainScreen.issueDetails 				- issue details TextField
		lodgeComplainScreen.submit 						- submit TextField
		 */
		LodgeComplaintScreen obj = new LodgeComplaintScreen();
		obj.submit.addActionListener(this);
		lodgeComplaintScreen = obj;
	}

	
	
	
	
	
	public void createCustomerAccountStatusScreen() {
		/*public vars
		  
		 acountStatusScreen.txtps						-Payment Status TextField	
    	 acountStatusScreen.txtad			 			-Amount Due TextField
    	 acountStatusScreen.txtpdd		 				-Payment Due Date TextField
		 */
		AccountStatusScreen obj = new AccountStatusScreen();
		accountStatusScreen = obj;
	}
	

	
	
	


	public void createCustomerComplaintHistoryScreen() {
		/*public vars
		  
		  complaintHistory.moreTable						-more info table
		  complaintHistory.mainTable						-main table
		  complaintHistory.moreInfo							-more info button
		 */
		ComplaintHistoryScreen obj = new ComplaintHistoryScreen(CustomerController.getComplaintHistory());
		obj.moreInfo.addActionListener(this);
		complaintHistoryScreen = obj;
	}
	
	
	
	
	
	
	
	public void createCustomerPaymentHistoryScreen() {
		PaymentHistoryScreen obj = new PaymentHistoryScreen(CustomerController.getPaymentHistory());
		paymentHistoryScreen = obj;
	}

	
	
	
	String[][] d1 = CustomerController.getEmployeeList(); //TEMP DATA, SWAP FOR REAL DATA ARRAY
	public void createCustomerLiveChatScreen() {
		/*public vars
		  
	  	liveChatScreen.message										- message textfield
	  	liveChatScreen.chat											- chat text area
	  	liveChatScreen.send											- send button
		 */
		LiveChatScreen obj = new LiveChatScreen(d1);
		obj.send.addActionListener(this);
		liveChatScreen = obj;
	}
	
	
	
	
	
	
	public void createCustomerLiveVideoChatScreen() {
		/*public vars
		  
	  	liveVideoChatScreen.video1											- video 1(receiving)
	  	liveVideoChatScreen.video2											- video 2(sending)
	  	liveVideoChatScreen.id												- id text field
	  	liveVideoChatScreen.start_stop										- start/stop button
	  	liveVideoChatScreen.status											- connection status
	  	liveVideoChatScreen.toggle											- start_stop toggle value
		 */
		LiveVideoChatScreen obj = new LiveVideoChatScreen();
		obj.start_stop.addActionListener(this);
		liveVideoChatScreen = obj;
	}
	
	

	@Override
	public void mouseClicked(MouseEvent e) {
				
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	class Refresh extends Thread{

		public Refresh(){

		}

		@Override
		public void run() {
			String chats;
			boolean flag;
			while(true){
				flag = true;
				try {
					while(flag) {
						chats = CustomerController.readAllLiveChats();
						liveChatScreen.chat.setText(chats);
						flag = false;
					}
					if(!flag){
						Thread.sleep(3500);
					}
				}
				catch(Exception x){
					System.err.println("Exception Occurred");
					x.printStackTrace();
				}
			}
		}
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		//LOGIN SCREEN
		try {
			if(e.getSource() == loginScreen.loginButton) {
				CustomerController.login();
				
				if(CustomerController.client.isLogin()) { //if correct credentials
					System.out.println("login successful");
					loginScreen.dispose();
					createCustomerDashboard();
					createCustomerWelcomeScreen();
					dashboard.add(welcomeScreen);
					welcomeScreen.welcomeMessage.setText("Welcome " + CustomerController.client.getCustomerObj().getFirstName() + " " + CustomerController.client.getCustomerObj().getLastName());
					currentPanel = welcomeScreen;
				}
				if (!CustomerController.client.isLogin()) {
					loginScreen.idTextField.setText("");
					loginScreen.passwordTextField.setText("");
				}
			}
		} catch(Exception ex) {
			//login screen is null
		}
		
		
		
		
		
		
		
		
		//DASHBOARD
		try {
			Refresh refresher = new Refresh();
			//refresher.setDaemon(true);

			if(e.getSource() == dashboard.lodgeComplaint) {
				CustomerController.exitVideoChatScreen();
				createCustomerLodgeComplaintScreen();  //creates new panel
				dashboard.remove(currentPanel);  //removes current panel from dashboard
				dashboard.add(lodgeComplaintScreen);  //loads new panel in dashboard
				currentPanel = lodgeComplaintScreen;  // sets new panel to current panel
				dashboard.setVisible(true);  //Reloads Component
			}
			
			//Account Status
			if(e.getSource() == dashboard.accountStatus) {
				CustomerController.exitVideoChatScreen();
				createCustomerAccountStatusScreen();  
				dashboard.remove(currentPanel);  
				dashboard.add(accountStatusScreen);  
				currentPanel = accountStatusScreen;
				CustomerController.getAccountStatus();
				dashboard.setVisible(true);
			}
			
			
			//Complaint History
			if(e.getSource() == dashboard.complaintHistory) {
				CustomerController.exitVideoChatScreen();
				createCustomerComplaintHistoryScreen();  
				dashboard.remove(currentPanel);  
				dashboard.add(complaintHistoryScreen);  
				currentPanel = complaintHistoryScreen;  
				dashboard.setVisible(true);
			}
			
			//payment history
			if(e.getSource() == dashboard.paymentHistory) {
				CustomerController.exitVideoChatScreen();
				createCustomerPaymentHistoryScreen();
				dashboard.remove(currentPanel);
				dashboard.add(paymentHistoryScreen);
				currentPanel = paymentHistoryScreen;
				dashboard.setVisible(true);
			}
			
			//Live chat
			if(e.getSource() == dashboard.liveChat) {
				CustomerController.exitVideoChatScreen();
				createCustomerLiveChatScreen();
				dashboard.remove(currentPanel);
				dashboard.add(liveChatScreen);
				currentPanel = liveChatScreen;
				dashboard.setVisible(true);
				refresher.start();
			}
			
			//Live Video chat
			if(e.getSource() == dashboard.liveVideoChat) {
				CustomerController.exitVideoChatScreen();
				createCustomerLiveVideoChatScreen();
				dashboard.remove(currentPanel);
				dashboard.add(liveVideoChatScreen);
				currentPanel = liveVideoChatScreen;
				dashboard.setVisible(true);
				CustomerController.incomingVideo();
			}
		} catch(Exception ex) {
			//Dashboard is null
		}
		
		
		
		
		
		
		
		
		//LODGE COMPLAINT SCREEN
		try {
			
			//submit button
			if (e.getSource() == lodgeComplaintScreen.submit){
				CustomerController.client.getComplaintObj().setComplaintType(lodgeComplaintScreen.issueType.getSelectedItem().toString());
				CustomerController.client.getComplaintObj().setComplaintDetails(lodgeComplaintScreen.issueDetails.getText());
				CustomerController.client.getComplaintObj().setStatus('U');
				CustomerController.client.getComplaintObj().setCustomerID(CustomerController.client.getCustomerObj().getCustomerID());
				CustomerController.client.getComplaintObj().setStaffID(null);
				CustomerController.client.sendAction("Create Complaint");
				CustomerController.client.sendComplaintObj(CustomerController.client.getComplaintObj());
				CustomerController.client.receiveResponse();
				JOptionPane.showMessageDialog(lodgeComplaintScreen, "Complaint lodged successfully", "successful", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception ex) {
			//lodge complaint screen null
		}
		
		
		
		
		
		
		
		
		//COMPLAINT HISTORY SCREEN
		try {
			if(e.getSource() == complaintHistoryScreen.moreInfo) {
				int row = complaintHistoryScreen.mainTable.getSelectedRow();
				String id = (String) complaintHistoryScreen.mainTable.getValueAt(row, 0);

				complaintHistoryScreen.moreInfoWindow(CustomerController.getComplaintDetails(id));
			}
			
		} catch (Exception ex) {
			//payment history screen null
		}
		
		
		
		
		
		
		
		//LIVE CHAT SCREEN
		try {
			
			//Save Changes
			if (e.getSource() == liveChatScreen.send) {
				String message = null;
				String employeeID = null;
				//System.out.println("send live chat message");
				
				message = liveChatScreen.message.getText();
				int selectedRow = liveChatScreen.table.getSelectedRow();
				employeeID = (String) liveChatScreen.table.getValueAt(selectedRow, 0);
				CustomerController.sendLiveChat(message,employeeID);
				JOptionPane.showMessageDialog(liveChatScreen, "Message sent", "successful", JOptionPane.INFORMATION_MESSAGE);
			}
			
		} catch(Exception ex) {
			//respond screen is null
			//System.err.println("NULL");
		}
		
		
		
		
		
		
		
		//LIVE VIDEO CHAT SCREEN
		try {
			
			//Start/Stop
			if (e.getSource() == liveVideoChatScreen.start_stop) {
				
				if(liveVideoChatScreen.toggle == 0) {
					liveVideoChatScreen.toggle = 1;
					liveVideoChatScreen.start_stop.setBackground(new Color(0x43c6e0));
				} else {
					liveVideoChatScreen.toggle = 0;
					liveVideoChatScreen.start_stop.setBackground(new Color(0x6666ff));
				}
				
				String id = liveVideoChatScreen.id.getText();
				
				if (liveVideoChatScreen.toggle == 1) {
					CustomerController.outgoingVideo(id);
				}
			}
			
		} catch(Exception ex) {
			//respond screen is null
		}
		
		
		
	}
	
	
}
