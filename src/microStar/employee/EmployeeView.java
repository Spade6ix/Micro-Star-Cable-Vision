package microStar.employee;

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
	
	
	public static void main(String[] args) {  //FOR UI TESTING PURPOSES
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
	
	
	
	
	
	
	public void createEmployeeResolvedScreen() {
		
		ResolvedScreen obj = new ResolvedScreen (allData, internetData, cableData, paymentData);
		resolvedScreen = obj;
	}
	
	
	
	
	
	
	private String allData[][] = { //DUMMY DATA for resolved and outstanding screens
			{"197272", "billy love", "sjdjdjs@gmail.com","987-383-3737","123 barcelona rd","Internet","Slow internet","Alanzo Black"},
			{"197272", "Lowe Richards", "sjdjdjs@gmail.com","987-383-3737","123 barcelona rd","Cable","Slow Cable","Alanzo Black"},
			{"197272", "Tessa Lweis", "sjdjdjs@gmail.com","987-383-3737","123 barcelona rd","Payment","No payment","Alanzo Black"}
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
	public void createEmployeeOustandingScreen() {
		
		OutstandingScreen obj = new OutstandingScreen (allData, internetData, cableData, paymentData);
		outstandingScreen = obj;
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

				if(loginScreen.idTextField.getText().equals("cusRep")) { //customer rep
					System.out.println("rep login successfull");
					loginScreen.dispose();
					createEmployeeDashboard();
					createEmployeeWelcomeScreen();
					dashboard.respond.setVisible(false);
					welcomeScreen.welcomeMessage.setText("Welcome <emp name>");
					dashboard.add(welcomeScreen);
					currentPanel = welcomeScreen;
				}
				
				if(loginScreen.idTextField.getText().equals("tech")) { //technician
					System.out.println("tech login successfull");
					loginScreen.dispose();
					createEmployeeDashboard();
					createEmployeeWelcomeScreen();
					dashboard.outstanding.setVisible(false);
					dashboard.resolved.setVisible(false);
					welcomeScreen.welcomeMessage.setText("Welcome <emp name>");
					dashboard.add(welcomeScreen);
					currentPanel = welcomeScreen;
				}
			}
		} catch(Exception ex) {
			//login screen obj null
		}
		
		
		
		try {
			if(e.getSource() == dashboard.resolved) {
				createEmployeeResolvedScreen();
				dashboard.remove(currentPanel);
				dashboard.add(resolvedScreen);
				currentPanel = resolvedScreen;
				dashboard.setVisible(true);
			}
			
			
			
			if(e.getSource() == dashboard.outstanding) {
				createEmployeeOustandingScreen();
				dashboard.remove(currentPanel);
				dashboard.add(outstandingScreen);
				currentPanel = outstandingScreen;
				dashboard.setVisible(true);
			}
		
		} catch (Exception ex) {
			//dashboard obj null
		}
		
		
		
		
		
	}
	
	
	
}
