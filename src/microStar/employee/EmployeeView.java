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
	
	
	
	public static void main(String[] args) {  //FOR UI TESTING PURPOSES
		EmployeeView employeeView = new EmployeeView();
		employeeView.createEmployeeLoginScreen();
	}
	
	
	
	
	

	public void createEmployeeLoginScreen() {
		/*public vars
		  
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
		dashboard.liveVideoChat 						-live video chat 
		dashboard.liveChat								-liveChat
		 */
		Dashboard obj = new Dashboard();
		obj.outstanding.addActionListener(this);
		obj.resolved.addActionListener(this);
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
		if(e.getSource() == loginScreen.loginButton) {
			
			if(true) { //if correct credentials
				System.out.println("login successfull");
				loginScreen.dispose();
				createEmployeeDashboard();
				createEmployeeWelcomeScreen();
				welcomeScreen.welcomeMessage.setText("Welcome <emp name>");
				dashboard.add(welcomeScreen);
				currentPanel = welcomeScreen;
			}
		}
		
	}
}
