package microStar.customer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class WelcomeScreen extends JPanel{

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
	
	private static final long serialVersionUID = 1L;
	private JLabel companyName = new JLabel("Micro Star Cable Vision");
	public JLabel welcomeMessage = new JLabel();

	public WelcomeScreen() {
		GridBagConstraints gbc = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
        gbc.weightx = 1;
        gbc.weighty = 1;
		
		//Company Name
        gbc.gridx = 1;
        gbc.gridy = 1;
        companyName.setVerticalAlignment(JLabel.BOTTOM);
        companyName.setHorizontalAlignment(JLabel.CENTER);
        companyName.setFont(new Font("Calibri", Font.PLAIN, 100));
        companyName.setForeground(new Color(0xbfbfbf));
        companyName.setPreferredSize(new Dimension(1000, 250));
        this.add(companyName, gbc);
        
        //Welcome Message
        gbc.gridy = 2;
        welcomeMessage.setVerticalAlignment(JLabel.TOP);
        welcomeMessage.setHorizontalAlignment(JLabel.CENTER);
        welcomeMessage.setFont(new Font("Calibri", Font.PLAIN, 70));
        welcomeMessage.setForeground(new Color(0xbfbfbf));
        welcomeMessage.setPreferredSize(new Dimension(900, 300));
        welcomeMessage.setText("Welcome <custName>");
        this.add(welcomeMessage, gbc);
        
        
        //setup Panel
        this.setBackground(new Color(0x333333));
	}
}
