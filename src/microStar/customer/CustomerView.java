package microStar.customer;

import java.awt.Component;


public class CustomerView {

	public static Component createCustomerLoginScreen() {
		/*public vars
		  
		 CustomerLoginScreen.idTextField			-ID TextField	
    	 CustomerLoginScreen.passwordTextField 		-Password TextField
    	 CustomerLoginScreen.loginButton 			-Login Button
		 */
		CustomerLoginScreen loginScreen = new CustomerLoginScreen();
		return loginScreen;
	}
	
	
}
