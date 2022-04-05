package microStar.employee;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Dashboard extends JFrame implements MouseListener {
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
	private JMenuBar menuBar = new JMenuBar();
	private JMenu complaints = new JMenu("Complaints");
	private JMenu other = new JMenu("Other");
	private JMenu gap = new JMenu();
	public JMenuItem  resolved = new JMenuItem("Resolved  'r'");
	public JMenuItem outstanding = new JMenuItem("Outstanding  'o'");
	public JMenuItem respond = new JMenuItem("Respond  'r'  ");
	public JMenuItem liveChat = new JMenuItem("Live Chat  't'");
	public JMenuItem liveVideoChat = new JMenuItem("Live Video Chat  'v'");
	
	
	
	public Dashboard() {
		
        //this.getContentPane().setBackground(new Color(0x333333));
        
        //Gap
        gap.setPreferredSize(new Dimension(30, 0));
        gap.setBackground(new Color(0xffffff));
        gap.setEnabled(false);
        
        
        //Complaints Menu
        complaints.setPreferredSize(new Dimension(100, 0)); 
        complaints.setForeground(new Color(0xffffff));
        respond.setFont(new Font("Calibri", Font.PLAIN, 15));
        respond.setToolTipText("Respond to complaints");
        respond.setMnemonic('r');
        complaints.add(respond);
        
        resolved.setFont(new Font("Calibri", Font.PLAIN, 15));
        resolved.setToolTipText("Resolved complaints");
        resolved.setMnemonic('r');
        complaints.add(resolved);
        
        outstanding.setFont(new Font("Calibri", Font.PLAIN, 15));
        outstanding.setToolTipText("Outstanding complaints");
        outstanding.setMnemonic('o');
        complaints.add(outstanding);
        
        
        
        //Other Menu
        liveChat.setFont(new Font("Calibri", Font.PLAIN, 15));
        liveChat.setToolTipText("Live text chat");
        liveChat.setMnemonic('t');
        other.add(liveChat);
        liveVideoChat.setFont(new Font("Calibri", Font.PLAIN, 15));
        liveVideoChat.setToolTipText("Live video chat");
        liveVideoChat.setMnemonic('v');
        other.add(liveVideoChat);
        other.setPreferredSize(new Dimension(100, 0));
        other.setForeground(new Color(0xffffff));
        
        //Menu bar
        menuBar.setBackground(new Color(0x6666ff));
        menuBar.setPreferredSize(new Dimension(0, 30));
        menuBar.add(gap);
        menuBar.add(complaints);
        menuBar.add(other);
        this.setJMenuBar(menuBar);
        
        
        
        //setup window
        this.setTitle("Miro-Star CableVision");
	    this.setSize(1180, 680); //vertical, horizantal 1100 * 600
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setResizable(false);
	    ImageIcon icon = new ImageIcon("images/logo.png");
	    this.setIconImage(icon.getImage());
	    this.setVisible(true);
	    
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
