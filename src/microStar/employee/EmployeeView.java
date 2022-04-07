package microStar.employee;

import microStar.customer.CustomerController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;





public class EmployeeView implements MouseListener, ActionListener{

public static JPanel currentPanel = null;
	
	public static LoginScreen loginScreen = null;
	public static Dashboard dashboard = null;
	public static WelcomeScreen welcomeScreen = null;
	public static ResolvedScreen resolvedScreen = null;
	public static OutstandingScreen outstandingScreen = null;
	public static RespondScreen respondScreen = null;
	public static LiveChatScreen liveChatScreen = null;
	
	
	public static void main(String[] args) {  //FOR UI TESTING PURPOSES
		new EmployeeController();
		EmployeeView employeeView = new EmployeeView();
		employeeView.createEmployeeLoginScreen();
	}
	
	
	
	
	

	public void createEmployeeLoginScreen() {
		/*public vars
		  
		  Customer representative login = "cusRep"
		  Technician login = "tech"
		  
		 loginScreen.idTextField						-ID TextField	
    	 loginScreen.passwordTextField 					-Password TextField
    	 loginScreen.loginButton 						-Login Button
		 */
		LoginScreen obj = new LoginScreen();
		obj.loginButton.addActionListener(this);
		loginScreen = obj;
	}

	
	
	
	
	
	
	
	public void createEmployeeDashboard() {
		/*public vars
		  
	  	dashboard.outstanding							- outstanding
	  	dashboard.resolved								- resolved 
	  	dashboard.respond								-respond (technician)
		dashboard.liveVideoChat 						-live video chat 
		dashboard.liveChat								-liveChat
		 */
		Dashboard obj = new Dashboard();
		obj.outstanding.addActionListener(this);
		obj.resolved.addActionListener(this);
		obj.respond.addActionListener(this);
		obj.liveVideoChat.addActionListener(this);
		obj.liveChat.addActionListener(this);
		dashboard = obj;
	}
	
	
	
	
	
	
	
	
	public void createEmployeeWelcomeScreen() {
		/*public vars
		  
		 welcomeScreen.welcomeMessage    			    - Welcome message JLabel
		 */
		WelcomeScreen obj = new WelcomeScreen();
		welcomeScreen = obj;
	}
	
	
	
	
	
	//resolved screen
	public void createEmployeeResolvedScreen() {
		
		ResolvedScreen obj = new ResolvedScreen (allData, internetData, cableData, paymentData, otherData);
		resolvedScreen = obj;
	}
	
	
	
	
	
	
	private String allData[][] = { //DUMMY DATA for resolved and outstanding screens
			{"197272", "billy love", "sjdjdjs@gmail.com","987-383-3737","123 barcelona rd","Internet","Slow internet","Alanzo Black"},
			{"197272", "Lowe Richards", "sjdjdjs@gmail.com","987-383-3737","123 barcelona rd","Cable","Slow Cable","Alanzo Black"},
			{"197272", "Tessa Lweis", "sjdjdjs@gmail.com","987-383-3737","123 barcelona rd","Payment","No payment","Alanzo Black"},
			{"197272", "Janae Hope", "sjdjdjs@gmail.com","987-383-3737","123 barcelona rd","Other","Misc concerns","Alanzo Black"}
	};
	
	private String internetData[][] = {
			{"197272", "billy love", "sjdjdjs@gmail.com","987-383-3737","123 barcelona rd","Internet","Slow internet","Alanzo Black"}
	};
	private String cableData[][] = {
			{"197272", "Lowe Richards", "sjdjdjs@gmail.com","987-383-3737","123 barcelona rd","Cable","Slow Cable","Alanzo Black"}
			
	};
	private String paymentData[][] = {
			{"197272", "Tessa Lweis", "sjdjdjs@gmail.com","987-383-3737","123 barcelona rd","Payment","No payment","Alanzo Black"}		
	};
	private String otherData[][] = {
			{"197272", "Janae Hope", "sjdjdjs@gmail.com","987-383-3737","123 barcelona rd","Other","Misc concerns","Alanzo Black"}		
	};
	public void createEmployeeOustandingScreen() {
		
		OutstandingScreen obj = new OutstandingScreen (allData, internetData, cableData, paymentData, otherData);
		outstandingScreen = obj;
	}
	
	
	
	
	
	private String resolvedData[][] = { //DUMMY DATA for resolved and outstanding screens
			{"197272", "billy love", "sjdjdjs@gmail.com","987-383-3737","123 barcelona rd","Internet","Slow internet","true"},
			{"197272", "Lowe Richards", "sjdjdjs@gmail.com","987-383-3737","123 barcelona rd","Cable","Slow Cable","false"},
			{"197272", "Tessa Lweis", "sjdjdjs@gmail.com","987-383-3737","123 barcelona rd","Payment","No payment","false"},
			{"197272", "Janae Hope", "sjdjdjs@gmail.com","987-383-3737","123 barcelona rd","Other","Misc concerns","true"}
	};
	public void createEmployeeRespondScreen() {
		RespondScreen obj = new RespondScreen(resolvedData);
		respondScreen = obj;
	}
	
	
	
	
	
	public void createEmployeeLiveChatScreen() {
		LiveChatScreen obj = new LiveChatScreen();
		liveChatScreen = obj;
	}
	
	
	
	
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
		try {
			if(e.getSource() == loginScreen.loginButton) {
				EmployeeController.e.setStaffID(String.valueOf(loginScreen.idTextField.getText()));
				EmployeeController.e.setPassword(String.valueOf(loginScreen.passwordTextField.getText()));
				EmployeeController.empClient.sendAction("Employee Login");
				EmployeeController.empClient.sendEmployeeObj(EmployeeController.e);
				EmployeeController.empClient.receiveResponse();
				EmployeeController.empClient.sendAction("Is Employee a Technician?");
				EmployeeController.empClient.sendEmployeeObj(EmployeeController.e);
				EmployeeController.empClient.receiveResponse();

				if(EmployeeController.empClient.isLogin()) { //customer rep
					if (!EmployeeController.empClient.isFlag()) {
						System.out.println("rep login successful");
						loginScreen.dispose();
						createEmployeeDashboard();
						createEmployeeWelcomeScreen();
						dashboard.respond.setVisible(false);
						welcomeScreen.welcomeMessage.setText("Welcome " + EmployeeController.empClient.getEmployeeObj().getFirstName() + " " + EmployeeController.empClient.getEmployeeObj().getLastName());
						dashboard.add(welcomeScreen);
						currentPanel = welcomeScreen;
					}
				}
				
				if(EmployeeController.empClient.isLogin()) { //technician
					if(EmployeeController.empClient.isFlag()) {
						System.out.println("tech login successful");
						loginScreen.dispose();
						createEmployeeDashboard();
						createEmployeeWelcomeScreen();
						dashboard.outstanding.setVisible(false);
						dashboard.resolved.setVisible(false);
						welcomeScreen.welcomeMessage.setText("Welcome "  + EmployeeController.empClient.getEmployeeObj().getFirstName() + " " + EmployeeController.empClient.getEmployeeObj().getLastName());
						dashboard.add(welcomeScreen);
						currentPanel = welcomeScreen;
					}
				}
			}
		} catch(Exception ex) {
			//login screen obj null
		}
		
		
		
		try {
			//resolved
			if(e.getSource() == dashboard.resolved) {
				createEmployeeResolvedScreen();
				dashboard.remove(currentPanel);
				dashboard.add(resolvedScreen);
				currentPanel = resolvedScreen;
				dashboard.setVisible(true);
			}
			
			
			//Outstanding
			if(e.getSource() == dashboard.outstanding) {
				createEmployeeOustandingScreen();
				dashboard.remove(currentPanel);
				dashboard.add(outstandingScreen);
				currentPanel = outstandingScreen;
				dashboard.setVisible(true);
			}
			
			//Respond
			if(e.getSource() == dashboard.respond) {
				createEmployeeRespondScreen();
				dashboard.remove(currentPanel);
				dashboard.add(respondScreen);
				currentPanel = respondScreen;
				dashboard.setVisible(true);
			}
			
			//Live chat
			if(e.getSource() == dashboard.liveChat) {
				createEmployeeLiveChatScreen();
				dashboard.remove(currentPanel);
				dashboard.add(liveChatScreen);
				currentPanel = liveChatScreen;
				dashboard.setVisible(true);
			}
		
		} catch (Exception ex) {
			//dashboard obj null
		}
		
		
		
		
		
	}
	
	
	
}
