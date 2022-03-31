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
	public static ComplaintHistoryScreen complaintHistoryScreen= null;
	public static PaymentHistoryScreen paymentHistoryScreen = null;
	
	
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
	


	private String data[][] = { //DUMMY DATA
			{"20/02/2021", "aefaefes efsefse fswefwf", "Sarah Die"},
			{"20/02/2021", "aefaefes efsefse fswefwf", "Sarah Die"},
			{"20/02/2021", "aefaefes efsefse fswefwf", "Sarah Die"}
		};
	public void createCustomerComplaintHistoryScreen() {
		/*public vars
		  
		 */
		ComplaintHistoryScreen obj = new ComplaintHistoryScreen(data);
		complaintHistoryScreen = obj;
	}
	
	private String data1[][] = { //dummy data for payment history
			{"12/20/2022", "$10,000"},
			{"13/2/2020", "$125,000"},
			{"12,6,2021", "$126,452"}
	};
	
	public void createCustomerPaymentHistoryScreen() {
		PaymentHistoryScreen obj = new PaymentHistoryScreen(data1);
		paymentHistoryScreen = obj;
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
		
	}
	
	
}
