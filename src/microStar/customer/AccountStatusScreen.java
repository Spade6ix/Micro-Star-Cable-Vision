package microStar.customer;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;


public class AccountStatusScreen extends JPanel {
	
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

	public JTextField txtps;
	public JTextField txtad;
	public JTextField txtpdd;


	public AccountStatusScreen() {
		
		this.setLayout(null);
		this.setBackground(new Color(0x333333));
		
		JLabel ilbps = new JLabel("Payment Status:");			//paymwnt status = ps
		ilbps.setForeground(Color.LIGHT_GRAY);
		ilbps.setFont(new Font("Calibri", Font.PLAIN, 30));
		ilbps.setBounds(150, 176, 255, 35);
		this.add(ilbps);
		
		JLabel lblad = new JLabel("Amount Due $:");				//amount due = ad
		lblad.setFont(new Font("Calibri", Font.PLAIN, 30));
		lblad.setForeground(Color.LIGHT_GRAY);
		lblad.setBounds(150, 269, 255, 35);
		this.add(lblad);
		
		JLabel lblpdd = new JLabel("Payment Due Date:");		// payment due date = pdd
		lblpdd.setFont(new Font("Calibri", Font.PLAIN, 30));
		lblpdd.setForeground(Color.LIGHT_GRAY);
		lblpdd.setBounds(150, 355, 255, 35);
		this.add(lblpdd);
		
		txtps = new JTextField();
		txtps.setForeground(new Color(0x999999));
		txtps.setBackground(new Color(0x4d4d4d));
		txtps.setBounds(455, 160, 400, 70);
		this.add(txtps);
		txtps.setColumns(10);
		txtps.setEnabled(false); //User cannot edit the payment field
		txtps.setBorder(null);   //no outline
		
		txtad = new JTextField();
		txtad.setForeground(new Color(0x999999));
		txtad.setBackground(new Color(0x4d4d4d));
		txtad.setBounds(455, 264, 300, 50);
		this.add(txtad);
		txtad.setColumns(10);
		txtad.setEnabled(false); ////User cannot edit the amount due
		txtad.setBorder(null);   //no outline
		
		txtpdd = new JTextField();
		txtpdd.setForeground(new Color(0x999999));
		txtpdd.setBackground(new Color(0x4d4d4d));
	//	txtpdd.setBackground(new Color(105, 105, 105));
		txtpdd.setBounds(455, 350, 300, 50);
		this.add(txtpdd);
		txtpdd.setColumns(10);
		txtpdd.setEnabled(false); ///User cannot edit the payment due date
		txtpdd.setBorder(null);	   //no outline
	}
}
