package microStar.employee;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class EmployeeLoginScreen implements MouseListener{
	/* COLOURS:

	   --grays
	   0x333333
	   0x4d4d4d
	   0x4f4f4f
	   0xbfbfbf
	   0x999999

	   -blues
	   0x6666ff
	 */

    JFrame frame = new JFrame("Login");
    JPanel form = new JPanel();
    JLabel companyNameLabel = new JLabel("Micro Star Cable Vision");
    JLabel idLabel = new JLabel("ID");
    JLabel passwordLabel = new JLabel("Password");
    JTextField idTextField = new JTextField();
    JTextField passwordTextField = new JTextField();
    JButton loginButton = new JButton("Login");



    public EmployeeLoginScreen() {

        //initialize Components
        JPanel content = (JPanel) frame.getContentPane();
        content.setLayout(new GridBagLayout());
        content.setBackground(new Color(0x333333));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;
        //------COMPANY NAME-----------------------------------------------------------------------
        gbc.gridx = 2;
        gbc.gridy = 1;
        companyNameLabel.setVerticalAlignment(JLabel.CENTER);
        companyNameLabel.setHorizontalAlignment(JLabel.CENTER);
        companyNameLabel.setFont(new Font("Calibri", Font.PLAIN, 80));
        companyNameLabel.setForeground(new Color(0xbfbfbf));
        content.add(companyNameLabel, gbc);
        //-----FORM-------------------------------------------------------------------------------
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.NORTH;
        form.setLayout(new GridBagLayout());
        form.setBackground(new Color(0x4d4d4d));
        form.setPreferredSize(new Dimension(500, 250));
        content.add(form, gbc);
        //---------ID Label------------------------------------------------------------------------
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(20,20,0,0); //top left bottom right
        gbc.anchor = GridBagConstraints.WEST;
        idLabel.setVerticalAlignment(JLabel.CENTER);
        idLabel.setHorizontalAlignment(JLabel.CENTER);
        idLabel.setFont(new Font("Calibri", Font.PLAIN, 28));
        idLabel.setForeground(new Color(0xbfbfbf));
        idLabel.setPreferredSize(new Dimension(150, 40));
        form.add(idLabel, gbc);
        //---------Password Label------------------------------------------------------------------------
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.insets = new Insets(0,20,0,0); //top left bottom right
        gbc.anchor = GridBagConstraints.WEST;
        passwordLabel.setVerticalAlignment(JLabel.CENTER);
        passwordLabel.setHorizontalAlignment(JLabel.CENTER);
        passwordLabel.setFont(new Font("Calibri", Font.PLAIN, 28));
        passwordLabel.setForeground(new Color(0xbfbfbf));
        passwordLabel.setPreferredSize(new Dimension(150, 40));
        form.add(passwordLabel, gbc);
        //---------ID TextField------------------------------------------------------------------------
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.insets = new Insets(20,0,0,0); //top left bottom right
        gbc.anchor = GridBagConstraints.WEST;
        idTextField.setHorizontalAlignment(JLabel.CENTER);
        idTextField.setFont(new Font("Calibri", Font.PLAIN, 20));
        idTextField.setForeground(new Color(0x333333));
        idTextField.setBackground(new Color(0x999999));
        idTextField.setBorder(null);
        idTextField.setPreferredSize(new Dimension(270, 40));
        form.add(idTextField, gbc);
        //---------Password TextField------------------------------------------------------------------------
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.insets = new Insets(0,0,0,0); //top left bottom right
        gbc.anchor = GridBagConstraints.WEST;
        passwordTextField.setHorizontalAlignment(JLabel.CENTER);
        passwordTextField.setFont(new Font("Calibri", Font.PLAIN, 20));
        passwordTextField.setForeground(new Color(0x333333));
        passwordTextField.setBackground(new Color(0x999999));
        passwordTextField.setBorder(null);
        passwordTextField.setPreferredSize(new Dimension(270, 40));
        form.add(passwordTextField, gbc);
        //---------Login Button------------------------------------------------------------------------
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(0,0,0,0); //top left bottom right
        gbc.anchor = GridBagConstraints.CENTER;
        loginButton.setVerticalAlignment(JLabel.CENTER);
        loginButton.setHorizontalAlignment(JLabel.CENTER);
        loginButton.setFont(new Font("Calibri", Font.PLAIN, 30));
        loginButton.setVerticalTextPosition(SwingConstants.CENTER);
        loginButton.setForeground(new Color(0x333333));
        loginButton.setBackground(new Color(0x6666ff));
        loginButton.setBorder(null);
        loginButton.setPreferredSize(new Dimension(100, 50));
        loginButton.addMouseListener(this);
        form.add(loginButton, gbc);




        //setup window
        frame.setSize(1024, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        ImageIcon icon = new ImageIcon("images/logo.png");
        frame.setIconImage(icon.getImage());
        frame.setVisible(true);
    }





    @Override
    public void mouseClicked(MouseEvent e) {


    }


    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource() == loginButton) {
            loginButton.setBackground(new Color(0xbfbfff));
            Border border = BorderFactory.createLineBorder(Color.gray, 1, false);
            loginButton.setBorder(border);
        }

    }


    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getSource() == loginButton) {
            loginButton.setBackground(new Color(0x6666ff));
            loginButton.setBorder(null);
        }

    }


    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == loginButton) {
            loginButton.setBackground(new Color(0x7272f2));
            Border border = BorderFactory.createLineBorder(Color.gray, 1, false);
            loginButton.setBorder(border);
        }

    }


    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == loginButton) {
            loginButton.setBackground(new Color(0x6666ff));
            loginButton.setBorder(null);
        }

    }
}


