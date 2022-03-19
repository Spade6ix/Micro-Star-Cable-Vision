package microStar.customer;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class LodgeComplaintScreen extends JPanel {

	/* COLOURS:

	   --grays
	   0x333333 - Background
	   0x4d4d4d - menu
	   0x666666 - menu(mouseover)
	   0x4f4f4f
	   0xbfbfbf
	   0x999999

	   -blues
	   0x6666ff
	 */
	
	private String[] issues = {"Internet", "Cable", "Payment"};
	
	public JTextField id = new JTextField();
	public JTextField firstName = new JTextField();
	public JTextField lastName = new JTextField();
	public JTextField contact = new JTextField();
	public JTextField email = new JTextField();
	public JTextField street = new JTextField();
	public JTextField parish_state = new JTextField();
	public JComboBox<String> issueType = new JComboBox<String>(issues);
	public JTextField issueDetails = new JTextField();
	public JButton submit = new JButton("Submit");
	
	private JLabel idLabel = new JLabel("ID");
	private JLabel firstNameLabel = new JLabel("First Name");
	private JLabel lastNameLabel = new JLabel("Last Name");
	private JLabel contactLabel = new JLabel("Contact");
	private JLabel emailLabel = new JLabel("Email");
	private JLabel streetLabel = new JLabel("Street");
	private JLabel parish_stateLabel = new JLabel("Parish/State");
	private JLabel issueTypeLabel = new JLabel("Issue Type");
	private JLabel issueDetailsLabel = new JLabel("Issue Details");
	
	public LodgeComplaintScreen() {
		
		GridBagConstraints gbc = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
        gbc.weightx = 1;
        gbc.weighty = 1;
        
        //ID Label
        gbc.gridx = 1;
        gbc.gridy = 1;
        idLabel.setFont(new Font("Calibri", Font.PLAIN, 30));
        idLabel.setForeground(new Color(0xbfbfbf));
        Border border = BorderFactory.createLineBorder(Color.gray, 1, false);
        idLabel.setBorder(border);
        this.add(idLabel);
        
        
        //setup Panel
        this.setBackground(new Color(0x333333));
	}
	
	
	
	
	
	
	
	
	
}
