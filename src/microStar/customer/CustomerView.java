package microStar.customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import microStar.employee.EmployeeController;
import microStar.employee.LiveChatScreen;
import microStar.model.Customer;
import microStar.model.Payment;


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
		ComplaintHistoryScreen obj = new ComplaintHistoryScreen(CustomerController.getComplaintHistory(), CustomerController.getComplaintDetails());
		complaintHistoryScreen = obj;
	}
	
	
	
	
	
	
	
	public void createCustomerPaymentHistoryScreen() {
		PaymentHistoryScreen obj = new PaymentHistoryScreen(CustomerController.getPaymentHistory());
		paymentHistoryScreen = obj;
	}

	
	
	
	
	public void createCustomerLiveChatScreen() {
		LiveChatScreen obj = new LiveChatScreen();
		liveChatScreen = obj;
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
			if(e.getSource() == dashboard.lodgeComplaint) {
				
				createCustomerLodgeComplaintScreen();  //creates new panel
				dashboard.remove(currentPanel);  //removes current panel from dashboard
				dashboard.add(lodgeComplaintScreen);  //loads new panel in dashboard
				currentPanel = lodgeComplaintScreen;  // sets new panel to current panel
				dashboard.setVisible(true);  //Reloads Component
			}
			
			//Account Status
			if(e.getSource() == dashboard.accountStatus) {
				createCustomerAccountStatusScreen();  
				dashboard.remove(currentPanel);  
				dashboard.add(accountStatusScreen);  
				currentPanel = accountStatusScreen;
				CustomerController.getAccountStatus();
				dashboard.setVisible(true);  
			}
			
			
			//Lodge Complaint
			if(e.getSource() == dashboard.complaintHistory) {
				
				createCustomerComplaintHistoryScreen();  
				dashboard.remove(currentPanel);  
				dashboard.add(complaintHistoryScreen);  
				currentPanel = complaintHistoryScreen;  
				dashboard.setVisible(true);  
			}
			
			//payment history
			if(e.getSource() == dashboard.paymentHistory) {
				createCustomerPaymentHistoryScreen();
				dashboard.remove(currentPanel);
				dashboard.add(paymentHistoryScreen);
				currentPanel = paymentHistoryScreen;
				dashboard.setVisible(true);
			}
			
			//Live chat
			if(e.getSource() == dashboard.liveChat) {
				createCustomerLiveChatScreen();
				dashboard.remove(currentPanel);
				dashboard.add(liveChatScreen);
				currentPanel = liveChatScreen;
				dashboard.setVisible(true);
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
			}
		} catch (Exception ex) {
			//lodge complaint screen null
		}
		
		
		
		
		
		
		//ACCOUNT STATUS SCREEN
		try {
			
			
		} catch (Exception ex) {
			//Account status screen null
		}
		
		
		
		
		
		//PAYMENT HISTORY SCREEN
		try {
			
			
		} catch (Exception ex) {
			//payment history screen null
		}
		
		
		
		
		
		//COMPLAINT HISTORY SCREEN
		try {
			
			
		} catch (Exception ex) {
			//payment history screen null
		}
		
		
		
	}
	
	
}
