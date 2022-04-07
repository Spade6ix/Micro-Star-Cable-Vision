package microStar.customer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class LodgeComplaintScreen extends JPanel implements MouseListener{

	/* COLOURS:

	   --grays
	   0x333333 - Background
	   0x4d4d4d - menu
	   0x666666 - menu(mouseover)
	   0x4f4f4f
	   0xbfbfbf
	   0x999999 - textFields

	   -blues
	   0x6666ff
	 */
	
	private String[] issues = {"Internet", "Cable", "Payment", "Other"};
	
	public JTextField id = new JTextField();
	public JTextField firstName = new JTextField();
	public JTextField lastName = new JTextField();
	public JTextField contact = new JTextField();
	public JTextField email = new JTextField();
	public JTextField street = new JTextField();
	public JTextField parish_state = new JTextField();
	public JComboBox<String> issueType = new JComboBox<String>(issues);
	public JTextArea issueDetails = new JTextArea();
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
		
		Border border = BorderFactory.createLineBorder(Color.gray, 1, false);
		GridBagConstraints gbc = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		this.setBorder(new EmptyBorder(50, 50, 40, 50));
        gbc.weightx = 1;
        gbc.weighty = 1;
        
        //ID Label
        gbc.gridx = 1;
        gbc.gridy = 1;
        idLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
        idLabel.setForeground(new Color(0xbfbfbf));
        this.add(idLabel, gbc);
        
        
        //FirstName Label
        gbc.gridx = 1;
        gbc.gridy = 2;
        firstNameLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
        firstNameLabel.setForeground(new Color(0xbfbfbf));
        this.add(firstNameLabel, gbc);
        
        
        //LastName Label
	    gbc.gridx = 1;
	    gbc.gridy = 3;
	    lastNameLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
	    lastNameLabel.setForeground(new Color(0xbfbfbf));
	    this.add(lastNameLabel, gbc);
        
	    
	    //Email Label
	    gbc.gridx = 1;
	    gbc.gridy = 4;
	    emailLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
	    emailLabel.setForeground(new Color(0xbfbfbf));
	    this.add(emailLabel, gbc);
	    
	    
	    //Contact Label
	    gbc.gridx = 1;
	    gbc.gridy = 5;
	    contactLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
	    contactLabel.setForeground(new Color(0xbfbfbf));
	    this.add(contactLabel, gbc);
	    
	    
	    //Issue Details Label
	    gbc.gridx = 1;
	    gbc.gridy = 6;
	    issueDetailsLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
	    issueDetailsLabel.setForeground(new Color(0xbfbfbf));
	    this.add(issueDetailsLabel, gbc);
	    
	    
	    //ID TextField
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        id.setHorizontalAlignment(JTextField.CENTER);
        id.setFont(new Font("Calibri", Font.PLAIN, 25));
        id.setForeground(new Color(0x333333));
        id.setBackground(new Color(0x999999));
        id.setPreferredSize(new Dimension(200, 40));
        id.setBorder(null);
        this.add(id, gbc);
        
        
        //FirstName TextField
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        firstName.setHorizontalAlignment(JTextField.CENTER);
        firstName.setFont(new Font("Calibri", Font.PLAIN, 25));
        firstName.setForeground(new Color(0x333333));
        firstName.setBackground(new Color(0x999999));
        firstName.setPreferredSize(new Dimension(200, 40));
        firstName.setBorder(null);
        this.add(firstName, gbc);
        
        
        //LastName TextField
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        lastName.setHorizontalAlignment(JTextField.CENTER);
        lastName.setFont(new Font("Calibri", Font.PLAIN, 25));
        lastName.setForeground(new Color(0x333333));
        lastName.setBackground(new Color(0x999999));
        lastName.setPreferredSize(new Dimension(200, 40));
        lastName.setBorder(null);
	    this.add(lastName, gbc);
        
	    
	    //Email TextField
	    gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        email.setHorizontalAlignment(JTextField.CENTER);
        email.setFont(new Font("Calibri", Font.PLAIN, 25));
        email.setForeground(new Color(0x333333));
        email.setBackground(new Color(0x999999));
        email.setPreferredSize(new Dimension(200, 40));
        email.setBorder(null);
	    this.add(email, gbc);
	    
	    
	    //Contact TextField
	    gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        contact.setHorizontalAlignment(JTextField.CENTER);
        contact.setFont(new Font("Calibri", Font.PLAIN, 25));
        contact.setForeground(new Color(0x333333));
        contact.setBackground(new Color(0x999999));
        contact.setPreferredSize(new Dimension(200, 40));
        contact.setBorder(null);
	    this.add(contact, gbc);
	    
	    
	    //Issue Details TextArea
	    gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.WEST;
        issueDetails.setFont(new Font("Calibri", Font.PLAIN, 15));
        issueDetails.setForeground(new Color(0x333333));
        issueDetails.setBackground(new Color(0x999999));
        issueDetails.setPreferredSize(new Dimension(300, 150));
        issueDetails.setLineWrap(true);
        issueDetails.setBorder(null);
	    this.add(issueDetails, gbc);
        
	    
	    //Street Label
        gbc.gridx = 3;
        gbc.gridy = 1;
        streetLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
        streetLabel.setForeground(new Color(0xbfbfbf));
        this.add(streetLabel, gbc);
        
        
        //Parish/ State Label
        gbc.gridx = 3;
        gbc.gridy = 2;
        parish_stateLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
        parish_stateLabel.setForeground(new Color(0xbfbfbf));
        this.add(parish_stateLabel, gbc);
        
        
        //Issue Type Label
        gbc.gridx = 3;
        gbc.gridy = 3;
        issueTypeLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
        issueTypeLabel.setForeground(new Color(0xbfbfbf));
        this.add(issueTypeLabel, gbc);
        
        
        //Street TextField
        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        street.setHorizontalAlignment(JTextField.CENTER);
        street.setFont(new Font("Calibri", Font.PLAIN, 25));
        street.setForeground(new Color(0x333333));
        street.setBackground(new Color(0x999999));
        street.setPreferredSize(new Dimension(200, 40));
        street.setBorder(null);
        this.add(street, gbc);
        
        
        //Parish/State TextField
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        parish_state.setHorizontalAlignment(JTextField.CENTER);
        parish_state.setFont(new Font("Calibri", Font.PLAIN, 25));
        parish_state.setForeground(new Color(0x333333));
        parish_state.setBackground(new Color(0x999999));
        parish_state.setPreferredSize(new Dimension(200, 40));
        parish_state.setBorder(null);
        this.add(parish_state, gbc);
        
        
        //Issue type ComboBox
        gbc.gridx = 4;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        issueType.setFont(new Font("Calibri", Font.PLAIN, 25));
        issueType.setForeground(new Color(0x333333));
        issueType.setBackground(new Color(0x999999));
        issueType.setPreferredSize(new Dimension(250, 40));
        issueType.setBorder(null);
        this.add(issueType, gbc);
        
        //Submit Button
        gbc.gridx = 4;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.SOUTHEAST;
        submit.setVerticalAlignment(JLabel.CENTER);
        submit.setHorizontalAlignment(JLabel.CENTER);
        submit.setFont(new Font("Calibri", Font.PLAIN, 30));
        submit.setVerticalTextPosition(SwingConstants.CENTER);
        submit.setForeground(new Color(0x333333));
        submit.setBackground(new Color(0x6666ff));
        submit.setBorder(null);
        submit.setPreferredSize(new Dimension(110, 50));
        submit.addMouseListener(this);
        this.add(submit, gbc);
        
        
        
        
        //setup Panel
        this.setBackground(new Color(0x333333));
        
	}
	
	
	
	
	

	@Override
    public void mouseClicked(MouseEvent e) {
    	
    }


    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource() == submit) {
        	submit.setBackground(new Color(0xbfbfff));
            Border border = BorderFactory.createLineBorder(Color.gray, 1, false);
            submit.setBorder(border);
        }

    }


    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getSource() == submit) {
        	submit.setBackground(new Color(0x6666ff));
        	submit.setBorder(null);
        }

    }


    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == submit) {
        	submit.setBackground(new Color(0x7272f2));
            Border border = BorderFactory.createLineBorder(Color.gray, 1, false);
            submit.setBorder(border);
        }

    }


    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == submit) {
        	submit.setBackground(new Color(0x6666ff));
        	submit.setBorder(null);
        }

    }
	
	
	
	
	
	
	
	
	
}
