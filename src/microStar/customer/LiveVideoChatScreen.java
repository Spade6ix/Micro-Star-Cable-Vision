package microStar.customer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class LiveVideoChatScreen extends JPanel implements ActionListener{


	public JLabel video1 = new JLabel();
	public JLabel video2 = new JLabel();
	public JTextField id = new JTextField();
	public JButton start_stop = new JButton("Start/Stop");
	public JLabel statusLabel = new JLabel("Status: ");
	public JLabel status2Label = new JLabel("Incoming from: ");
	public int toggle = 0;
	
	private JLabel idLabel = new JLabel("ID:      ");
	
	
	
	public LiveVideoChatScreen() {
		
		this.setBackground(new Color(0x333333));
		this.setLayout(new GridBagLayout());
		this.setBorder(new EmptyBorder(10, 50, 0, 10));
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;
        
        
        
        //Status Label
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.SOUTHWEST;
        statusLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
        statusLabel.setForeground(new Color(0xbfbfbf));
        this.add(statusLabel, gbc);
        
        
        //Status2 Label
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.SOUTHWEST;
        status2Label.setFont(new Font("Calibri", Font.PLAIN, 25));
        status2Label.setForeground(new Color(0xbfbfbf));
        this.add(status2Label, gbc);
        
        
        //ID Label
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.SOUTHEAST;
        idLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
        idLabel.setForeground(new Color(0xbfbfbf));
        this.add(idLabel, gbc);
        
        
        //ID TextField
	    gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.SOUTHWEST;
        id.setHorizontalAlignment(JTextField.CENTER);
        id.setFont(new Font("Calibri", Font.PLAIN, 25));
        id.setForeground(new Color(0x333333));
        id.setBackground(new Color(0x999999));
        id.setPreferredSize(new Dimension(150, 35));
        id.setBorder(null);
	    this.add(id, gbc);
	    
	    
	    
	    //VIDEO 1
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        ImageIcon icon1 = new ImageIcon("images/image1.png"); 
        video1.setIcon(icon1);
        video1.setPreferredSize(new Dimension(640, 480));
        this.add(video1, gbc);
        
        
        //VIDEO 1
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        ImageIcon icon2 = new ImageIcon("images/image2.png"); 
        video2.setIcon(icon2);
        video2.setPreferredSize(new Dimension(320, 240));
        this.add(video2, gbc);
	    
	    
	    
	    //Start/Stop Button
        gbc.gridx = 4;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.NORTHEAST;
        start_stop.setVerticalAlignment(JLabel.CENTER);
        start_stop.setHorizontalAlignment(JLabel.CENTER);
        start_stop.setFont(new Font("Calibri", Font.PLAIN, 30));
        start_stop.setVerticalTextPosition(SwingConstants.CENTER);
        start_stop.setForeground(new Color(0x333333));
        start_stop.setBackground(new Color(0x6666ff));
        start_stop.setBorder(null);
        start_stop.setPreferredSize(new Dimension(150, 45));
        start_stop.addActionListener(this);
        this.add(start_stop, gbc);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
