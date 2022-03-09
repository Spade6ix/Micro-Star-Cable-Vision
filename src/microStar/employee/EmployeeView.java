package microStar.employee;

import java.awt.Component;


public class EmployeeView {

	public static Component createEmployeeLoginScreen() {
		/*public vars
		  
		 EmployeeLoginScreen.idTextField			-ID TextField	
    	 EmployeeLoginScreen.passwordTextField 		-Password TextField
    	 EmployeeLoginScreen.loginButton 			-Login Button
		 */
		EmployeeLoginScreen loginScreen = new EmployeeLoginScreen();
		return loginScreen;
	}
}
