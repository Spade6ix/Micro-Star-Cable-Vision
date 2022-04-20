package microStar.employee;



import microStar.customer.CustomerController;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;






public class EmployeeView implements MouseListener, ActionListener{

public static JPanel currentPanel = null;
	
	public static LoginScreen loginScreen = null;
	public static Dashboard dashboard = null;
	public static WelcomeScreen welcomeScreen = null;
	public static AssignScreen assignScreen = null;
	public static RespondScreen respondScreen = null;
	public static LiveChatScreen liveChatScreen = null;
	public static LiveVideoChatScreen liveVideoChatScreen = null;
	
	
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
		obj.save.addActionListener(this);
		respondScreen = obj;
	}




	String[][] d1 = EmployeeController.getCustomerList(); //TEMP DATA, SWAP FOR REAL DATA ARRAY
	public void createEmployeeLiveChatScreen() {
		/*public vars
		  
	  	liveChatScreen.message										- message textfield
	  	liveChatScreen.chat											- chat text area
	  	liveChatScreen.send											- send button
		 */
		LiveChatScreen obj = new LiveChatScreen(d1);
		obj.send.addActionListener(this);
		liveChatScreen = obj;
	}
	
	
	
	
	
	public void createCustomerLiveVideoChatScreen() {
		/*public vars
		  
	  	liveVideoChatScreen.video1											- video 1(receiving)
	  	liveVideoChatScreen.video2											- video 2(sending)
	  	liveVideoChatScreen.id												- id text field
	  	liveVideoChatScreen.start_stop										- start/stop button
	  	liveVideoChatScreen.status											- connection status
	  	liveVideoChatScreen.toggle											- start_stop toggle value
		 */
		LiveVideoChatScreen obj = new LiveVideoChatScreen();
		obj.start_stop.addActionListener(this);
		liveVideoChatScreen = obj;
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
			
		}
		
		
		
		
		
		//DASHBOARD
		try {
					
			//Assign
			if(e.getSource() == dashboard.assign) {
				EmployeeController.exitVideoChatScreen();
				createEmployeeAssignScreen();
				dashboard.remove(currentPanel);
				dashboard.add(assignScreen);
				currentPanel = assignScreen;
				dashboard.setVisible(true);
			}
			
			//Respond
			if(e.getSource() == dashboard.respond) {
				EmployeeController.exitVideoChatScreen();
				createEmployeeRespondScreen();
				dashboard.remove(currentPanel);
				dashboard.add(respondScreen);
				currentPanel = respondScreen;
				dashboard.setVisible(true);
			}
			
			//Live chat
			if(e.getSource() == dashboard.liveChat) {
				EmployeeController.exitVideoChatScreen();
				createEmployeeLiveChatScreen();
				dashboard.remove(currentPanel);
				dashboard.add(liveChatScreen);
				currentPanel = liveChatScreen;
				dashboard.setVisible(true);
			}
			
			//Live Video chat
			if(e.getSource() == dashboard.liveVideoChat) {
				EmployeeController.exitVideoChatScreen();
				createCustomerLiveVideoChatScreen();
				dashboard.remove(currentPanel);
				dashboard.add(liveVideoChatScreen);
				currentPanel = liveVideoChatScreen;
				dashboard.setVisible(true);
				EmployeeController.incomingVideo();
			}
		
		} catch (Exception ex) {
			//dashboard obj null
		}
		
		
		
		
		//ASSIGN
		try{
			
			//Save button
			if (e.getSource() == assignScreen.save) {
				//Save Changes
				int selectedRow = assignScreen.table.getSelectedRow();
				int selectedCol = assignScreen.table.getSelectedColumn();
				String cellValue = (String) assignScreen.table.getValueAt(selectedRow, selectedCol);
				String idValue = (String) assignScreen.table.getValueAt(selectedRow, 0);
				EmployeeController.assignTechnician(idValue, cellValue);
				JOptionPane.showMessageDialog(respondScreen, "Technician assigned successfully", "successful", JOptionPane.INFORMATION_MESSAGE);
			}
			
			
			
			//Query button
			if (e.getSource() == assignScreen.querry) {
				setComplaintsTotal();
			}
			
		}catch (Exception ex) {
			//assign screen is null
		}
		
		
		
		
		
		
		
		
		//RESPOND
		try {
			
			//Save Changes
			if (e.getSource() == respondScreen.save) {
				String response = null;
				int selectedRow = respondScreen.table.getSelectedRow();
				
				response = respondScreen.response.getText();
				String dov = respondScreen.dov.getText();
				String complaintId = (String) respondScreen.table.getValueAt(selectedRow, 0);
				EmployeeController.setComplaintResponse(response, dov, complaintId);
				JOptionPane.showMessageDialog(respondScreen, "Response saved successfully", "successful", JOptionPane.INFORMATION_MESSAGE);
			}
			
		} catch(Exception ex) {
			//respond screen is null
		}
		
		
		
		
		
		
		
		//LIVE CHAT SCREEN
		try {
			
			//Save Changes
			if (e.getSource() == liveChatScreen.send) {
				String message = null;
				String customerID = null;
				//System.out.println("send live chat message");
				
				message = liveChatScreen.message.getText();
				int selectedRow = liveChatScreen.table.getSelectedRow();
				customerID = (String) liveChatScreen.table.getValueAt(selectedRow, 0);
				EmployeeController.sendLiveChat(message,customerID);
				JOptionPane.showMessageDialog(liveChatScreen, "Message sent", "successful", JOptionPane.INFORMATION_MESSAGE);
			}
			
		} catch(Exception ex) {
			//respond screen is null
		}
		
		
		
		
		
		
		
		
		//LIVE VIDEO CHAT SCREEN
		try {
			
			//Start/Stop
			if (e.getSource() == liveVideoChatScreen.start_stop) {
				
				if(liveVideoChatScreen.toggle == 0) {
					liveVideoChatScreen.toggle = 1;
					liveVideoChatScreen.start_stop.setBackground(new Color(0x43c6e0));
				} else {
					liveVideoChatScreen.toggle = 0;
					liveVideoChatScreen.start_stop.setBackground(new Color(0x6666ff));
				}
				
				String id = liveVideoChatScreen.id.getText();
				
				if (liveVideoChatScreen.toggle == 1) {
					EmployeeController.outgoingVideo(id);
				}
			}
			
		} catch(Exception ex) {
			//respond screen is null
		}
		
		
	}
	
}
