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
	public static AssignScreen assignScreen = null;
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
		  
	  	dashboard.assign								- assign
	  	dashboard.respond								-respond (technician)
		dashboard.liveVideoChat 						-live video chat 
		dashboard.liveChat								-liveChat
		 */
		Dashboard obj = new Dashboard();
		obj.assign.addActionListener(this);
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
	
	
	
	
	
	
	
	public void createEmployeeAssignScreen() {
		
		AssignScreen obj = new AssignScreen (EmployeeController.getInternetComplaintsData(), EmployeeController.getCableComplaintsData(), 
				EmployeeController.getPaymentComplaintsData(), EmployeeController.getOtherComplaintsData());
		obj.save.addActionListener(this);
		assignScreen = obj;
		setComplaintsTotal();
	}
	
	
	
	
	
	
	public void createEmployeeRespondScreen() {
		RespondScreen obj = new RespondScreen(EmployeeController.getRespondData());
		respondScreen = obj;
	}
	
	
	
	
	
	public void createEmployeeLiveChatScreen() {
		LiveChatScreen obj = new LiveChatScreen();
		liveChatScreen = obj;
	}
	
	
	
	
	private void setComplaintsTotal() {
		System.out.println("total");
		int out = EmployeeController.getCoutstandingCount();
		int resolved = EmployeeController.getResolvedCount();
		
		assignScreen.outstanding.setText("Outstanding: " + out);
		assignScreen.resolved.setText("Resolved: " + resolved);
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
		
		//Login Screen
		try {
			if(e.getSource() == loginScreen.loginButton) {
				EmployeeController.login();
				
				if (EmployeeController.empClient.isLogin()) { //customer rep
					EmployeeController.empClient.sendAction("Is Employee a Technician?");
					EmployeeController.empClient.sendEmployeeObj(EmployeeController.e);
					EmployeeController.empClient.receiveResponse();
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

				if (EmployeeController.empClient.isLogin()) { //technician
					if (EmployeeController.empClient.isFlag()) {
						System.out.println("tech login successful");
						loginScreen.dispose();
						createEmployeeDashboard();
						createEmployeeWelcomeScreen();
						dashboard.assign.setVisible(false);
						welcomeScreen.welcomeMessage.setText("Welcome " + EmployeeController.empClient.getEmployeeObj().getFirstName() + " " + EmployeeController.empClient.getEmployeeObj().getLastName());
						dashboard.add(welcomeScreen);
						currentPanel = welcomeScreen;
					}
				}

				if (!EmployeeController.empClient.isLogin()) {
					loginScreen.idTextField.setText(null);
					loginScreen.passwordTextField.setText(null);
				}
			}
		} catch(Exception ex) {
			System.out.println("login ex");
		}
		
		
		
		
		
		//DASHBOARD
		try {
					
			//Outstanding
			if(e.getSource() == dashboard.assign) {
				createEmployeeAssignScreen();
				dashboard.remove(currentPanel);
				dashboard.add(assignScreen);
				currentPanel = assignScreen;
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
		
		
		
		
		//ASSIGN
		try {
			//Save button
			if (e.getSource() == assignScreen.save) {
				//Save Changes
				int selectedRow = assignScreen.table.getSelectedRow();
				int selectedCol = assignScreen.table.getSelectedColumn();
				String cellValue = (String) assignScreen.table.getValueAt(selectedRow, selectedCol);
				String idValue = (String) assignScreen.table.getValueAt(selectedRow, 0);
				EmployeeController.assignTechnician(idValue, cellValue);
				System.out.println("dawda");
			}
			else {
				System.out.println("Nothing selected");
			}
			
			
			//Querry button
			if (e.getSource() == assignScreen.querry) {
				setComplaintsTotal();
			}
		} 
		catch (Exception ex) {
<<<<<<< HEAD
			//assign screen is null
=======
			System.out.println("Nothing selected");
			ex.printStackTrace();
>>>>>>> d8d12f82ca7fee5611c92da124ba704f74720acf
		}
		
		
		
		
		
		//RESPOND
		try {
			//Save Changes
			if (e.getSource() == respondScreen.save) {
				String response = null;
				int selectedRow = respondScreen.table.getSelectedRow();
				
				response = respondScreen.response.getText();
				String idValue = (String) respondScreen.table.getValueAt(selectedRow, 0);
				String complaintId = (String) respondScreen.table.getValueAt(selectedRow, 1);
				EmployeeController.setComplaintResponse(response, idValue, complaintId);
			}
		}
		catch(Exception ex) {
			//tresdpond svreen is null
		}
		
		
		
		
		
	}
	
}
