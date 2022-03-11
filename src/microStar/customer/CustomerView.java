package microStar.customer;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;


public class CustomerView implements MouseListener{
	
	public static JPanel currentPanel = null;
	
	public static LoginScreen loginScreen = null;
	public static Dashboard dashboard = null;
	public static WelcomeScreen welcomeScreen = null;
	
	
	
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
		obj.loginButton.addMouseListener(this);
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
		obj.lodgeComplaint.addMouseListener(this);
		obj.accountStatus.addMouseListener(this);
		obj.paymentHistory.addMouseListener(this);
		obj.complaintHistory.addMouseListener(this);
		obj.liveVideoChat.addMouseListener(this);
		obj.liveChat.addMouseListener(this);
		dashboard = obj;
	}
	
	
	
	
	public void createCustomerWelcomeScreen() {
		/*public vars
		  
		 welcomeScreen.welcomeMessage    			    - Welcome message JLabel
		 */
		WelcomeScreen obj = new WelcomeScreen();
		welcomeScreen = obj;
	}









	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(e.getSource() == loginScreen.loginButton) {
			
			if(true) { //if correct credentials
				loginScreen.dispose();
				createCustomerDashboard();
				createCustomerWelcomeScreen();
				dashboard.add(welcomeScreen);
			}
			
		}
		
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
	
	
}
