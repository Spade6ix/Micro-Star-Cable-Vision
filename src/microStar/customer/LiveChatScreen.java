package microStar.customer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class LiveChatScreen extends JPanel implements MouseListener, ActionListener{
	
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
	
	private static final long serialVersionUID = 1L;
	
	public JTextField message = new JTextField();
	public JTextArea chat = new JTextArea();
	public JButton send = new JButton("Send");
	
	
	
	
	
	
	public LiveChatScreen() {
		this.setBackground(new Color(0x333333));
		this.setLayout(new GridBagLayout());
		this.setBorder(new EmptyBorder(50, 50, 40, 50));
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;
        
        
        //CHAT TextArea
	    gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        chat.setFont(new Font("Calibri", Font.PLAIN, 15));
        chat.setForeground(new Color(0x333333));
        chat.setBackground(new Color(0x999999));
        chat.setPreferredSize(new Dimension(1000, 400));
        chat.setLineWrap(true);
        chat.setBorder(null);
	    this.add(chat, gbc);
        
        
        //MESSAGE TextField
	    gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        message.setHorizontalAlignment(JTextField.CENTER);
        message.setFont(new Font("Calibri", Font.PLAIN, 25));
        message.setForeground(new Color(0x333333));
        message.setBackground(new Color(0x999999));
        message.setPreferredSize(new Dimension(800, 40));
        message.setBorder(null);
	    this.add(message, gbc);
	    
	    
	    
	    //Submit Button
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.SOUTHEAST;
        send.setVerticalAlignment(JLabel.CENTER);
        send.setHorizontalAlignment(JLabel.CENTER);
        send.setFont(new Font("Calibri", Font.PLAIN, 30));
        send.setVerticalTextPosition(SwingConstants.CENTER);
        send.setForeground(new Color(0x333333));
        send.setBackground(new Color(0x6666ff));
        send.setBorder(null);
        send.setPreferredSize(new Dimension(100, 50));
        send.addMouseListener(this);
        this.add(send, gbc);
	}

	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
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

}
