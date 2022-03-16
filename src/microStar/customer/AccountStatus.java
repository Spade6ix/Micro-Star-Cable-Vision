package microstar.customer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;


public class AccountStatus extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTextField txtps;
	private JTextField txtad;
	private JTextField txtpdd;

	
	public static void main(String[] args) {
					AccountStatus frame = new AccountStatus();
					frame.setVisible(true);
		
	}

	public AccountStatus() {
		setTitle("Account Status");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 1084, 561);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel ilbps = new JLabel("Payment Status:");			//paymwnt status = ps
		ilbps.setForeground(Color.LIGHT_GRAY);
		ilbps.setFont(new Font("Calibri", Font.PLAIN, 20));
		ilbps.setBounds(274, 176, 145, 23);
		panel.add(ilbps);
		
		JLabel lblad = new JLabel("Amount Due $:");				//amount due = ad
		lblad.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblad.setForeground(Color.LIGHT_GRAY);
		lblad.setBounds(274, 269, 145, 23);
		panel.add(lblad);
		
		JLabel lblpdd = new JLabel("Payment Due Date:");		// payment due date = pdd
		lblpdd.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblpdd.setForeground(Color.LIGHT_GRAY);
		lblpdd.setBounds(274, 355, 160, 23);
		panel.add(lblpdd);
		
		txtps = new JTextField();
		txtps.setForeground(new Color(105, 105, 105));
		txtps.setBackground(new Color(105, 105, 105));
		txtps.setBounds(455, 160, 327, 53);
		panel.add(txtps);
		txtps.setColumns(10);
		txtps.setEnabled(false); //User cannot edit the payment field
		
		txtad = new JTextField();
		txtad.setBackground(new Color(105, 105, 105));
		txtad.setBounds(455, 264, 198, 30);
		panel.add(txtad);
		txtad.setColumns(10);
		txtad.setEnabled(false); ////User cannot edit the amount due
		
		txtpdd = new JTextField();
		txtpdd.setBackground(new Color(105, 105, 105));
		txtpdd.setBounds(455, 350, 198, 30);
		panel.add(txtpdd);
		txtpdd.setColumns(10);
		txtpdd.setEnabled(false); ///User cannot edit the payment due date
	}
}
