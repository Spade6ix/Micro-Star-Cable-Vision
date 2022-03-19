package microStar.customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;



public class CustomerView implements MouseListener, ActionListener{
	
	public static JPanel currentPanel = null;
	
	public static LoginScreen loginScreen = null;
	public static Dashboard dashboard = null;
	public static WelcomeScreen welcomeScreen = null;
	public static LodgeComplaintScreen lodgeComplaintScreen = null;
	public static AccountStatusScreen accountStatusScreen= null;
	
	
	
	public static void main(String[] args) {  //FOR UI TESTING PURPOSES
		CustomerView customerView = new CustomerView();
		customerView.createCustomerLoginScreen();
	}
	
	
	
	
	

	public void createCustomerLoginScreen() {
		/*public vars
		  
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
		obj.id.addActionListener(this);
		obj.firstName.addActionListener(this);
		obj.lastName.addActionListener(this);
		obj.email.addActionListener(this);
		obj.contact.addActionListener(this);
		obj.street.addActionListener(this);
		obj.parish_state.addActionListener(this);
		obj.issueType.addActionListener(this);
		obj.issueDetails.addActionListener(this);
		obj.submit.addActionListener(this);
		lodgeComplaintScreen = obj;
	}

	
	
	public void createCustomerAccountStatusScreen() {
		/*public vars
		  
		 acountStatusScreen.txtps						-Payment Status TextField	
    	 acountStatusScreen.passwordTextField 			-Amount Due TextField
    	 acountStatusScreen.loginButton 				-Payment Due Date TextField
		 */
		AccountStatusScreen obj = new AccountStatusScreen();
		accountStatusScreen = obj;
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
		
		
		//Login button
		if(e.getSource() == loginScreen.loginButton) {
			
			if(true) { //if correct credentials
				System.out.println("login successfull");
				loginScreen.dispose();
				createCustomerDashboard();
				createCustomerWelcomeScreen();
				dashboard.add(welcomeScreen);
				currentPanel = welcomeScreen;
			}
		}
		
		
		//Lodge Complaint
		if(e.getSource() == dashboard.lodgeComplaint) {
			
			System.out.println("lodge complaint screen");
			createCustomerLodgeComplaintScreen();  //creates new panel
			dashboard.remove(currentPanel);  //removes current panel from dashboard
			dashboard.add(lodgeComplaintScreen);  //loads new panel in dashboard
			currentPanel = lodgeComplaintScreen;  // sets new panel to current panel
			dashboard.setVisible(true);  //Reloads Component
		}
		
		
		//Account Status
		if(e.getSource() == dashboard.accountStatus) {
			
			System.out.println("account status screen");
			createCustomerAccountStatusScreen();  
			dashboard.remove(currentPanel);  
			dashboard.add(accountStatusScreen);  
			currentPanel = accountStatusScreen;  
			dashboard.setVisible(true);  
		}
		
	}
	
	
}
