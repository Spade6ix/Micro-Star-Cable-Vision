package microStar.employee;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

public class AssignScreen extends JPanel implements MouseListener, ActionListener{

	/* COLOURS:

	   --grays
	   0x333333 - panel Background
	   0x4d4d4d - header
	   0x666666 - table background
	   0x5a5a5a - grid colour
	   0x999999 - header text
	   0xc2c2c2 - table text

	   -blues
	   0x6666ff
	   0x43c6e0 - querry 
	 */
	private String col[] = {"Customer ID", "Customer Name", "Email", "Contact", "Address", "Issue Type", "Details", "Techncian Name"};
	private String[] issueTypeData = {"Internet", "Cable", "Payment", "Other"};
	private String internetData[][] = null;
	private String cableData[][] = null;
	private String paymentData[][] = null;
	private String otherData[][] = null;
	private DefaultTableModel tableModel = null;
	private JScrollPane scrollPane;
	private JComboBox<String> issueType = new JComboBox<String>(issueTypeData);
	
	public JLabel resolved = new JLabel("Resolved");
	public JLabel outstanding = new JLabel("Outstanding");
	public JButton querry = new JButton("Querry");
	public JButton save = new JButton("Save Changes");
	public JTable table = null;
	
	public AssignScreen(String d1[][], String d2[][], String d3[][], String d4[][]) {
		
		this.internetData = d1;
		this.cableData = d2;
		this.paymentData = d3;
		this.otherData = d4;
		
		
		
		//Panel Setup
		this.setLayout(new GridBagLayout());
		this.setBackground(new Color(0x333333));
		this.setBorder(new EmptyBorder(10, 30, 10, 30)); //top left bottom right
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weightx = 1;
		gbc.weighty = 1;
		
		
		
		//Resolved
	    gbc.gridx = 1;
	    gbc.gridy = 1;
	    gbc.anchor = GridBagConstraints.CENTER;
	    resolved.setFont(new Font("Calibri", Font.PLAIN, 20));
	    resolved.setForeground(new Color(0xbfbfbf));
	    this.add(resolved, gbc);
		
		
		
		//Outstanding
	    gbc.gridx = 2;
	    gbc.gridy = 1;
	    gbc.anchor = GridBagConstraints.CENTER;
	    outstanding.setFont(new Font("Calibri", Font.PLAIN, 20));
	    outstanding.setForeground(new Color(0xbfbfbf));
	    this.add(outstanding, gbc);
		
		
		//Issue type ComboBox
        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        issueType.setFont(new Font("Calibri", Font.PLAIN, 25));
        issueType.setForeground(new Color(0x333333));
        issueType.setBackground(new Color(0x999999));
        issueType.setPreferredSize(new Dimension(250, 40));
        issueType.setBorder(null);
        issueType.setSelectedIndex(0);
        this.add(issueType, gbc);
		
		
		
		
		//Table Setup
		tableModel = new DefaultTableModel(internetData, col); //table data & column names
		table = new JTable(tableModel) {
			
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int d, int column) { //makes table non editable
				if(column == 7) {
					return true;
				}
				else {
					return false;
				}
			}
			
			public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
				Component c = super.prepareRenderer(renderer, row, col);
				return c;
			}
		};
		scrollPane = new JScrollPane(table); //add table to ScrollPane
		
		
		
		//Table Header
		JTableHeader header = table.getTableHeader();
		header.setBackground(new Color(0x4d4d4d));
		header.setForeground(new Color(0x999999));
		header.setPreferredSize(new Dimension(0, 28));
		header.setFont(new Font("Calibri", Font.BOLD, 18));
		UIManager.getDefaults().put("TableHeader.cellBorder", new EmptyBorder(0,0,0,0)); //removes grid from table header

		
		//Table Body
		table.setRowHeight(20);
        table.setFont(new Font("calibri", Font.PLAIN, 15));
        table.setGridColor(new Color(0x5a5a5a));
        table.setBackground(new Color(0x666666));
        table.setForeground(new Color(0xc2c2c2));
		table.setPreferredSize(new Dimension(1100, 400));	
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        
        //ScrollPane
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 4;
        scrollPane.setBackground(new Color(0x333333));
        scrollPane.getVerticalScrollBar().setUI(null); //removes vertical slider
        scrollPane.setBorder(new EmptyBorder(0,0,0,0)); //removes ScrollPane border
        scrollPane.setPreferredSize(new Dimension(1100, 400));	
        this.add(scrollPane, gbc);
        
        
        //Querry Button
        gbc.gridwidth = 1;
		gbc.gridx = 1;
		gbc.gridy = 3;
		//gbc.insets = new Insets(0, 50, 0, 0);
		gbc.anchor = GridBagConstraints.WEST;
		querry.setFont(new Font("Calibri", Font.PLAIN, 25));
		querry.setVerticalTextPosition(SwingConstants.CENTER);
		querry.setForeground(new Color(0x333333));
		querry.setBackground(new Color(0x43c6e0));
		querry.setBorder(null);
		querry.setPreferredSize(new Dimension(115, 45));
		querry.addActionListener(this);
		this.add(querry, gbc);
		
		
		
		//Save Button
		gbc.gridx = 4;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.EAST;
        save.setFont(new Font("Calibri", Font.PLAIN, 25));
        save.setVerticalTextPosition(SwingConstants.CENTER);
        save.setForeground(new Color(0x333333));
        save.setBackground(new Color(0x6666ff));
        save.setBorder(null);
        save.setPreferredSize(new Dimension(150, 45));
        save.addActionListener(this);
		this.add(save, gbc);
	}
	
	
	
	
	
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//QUERRY BUTTON
		if(e.getSource() == querry && issueType.getSelectedItem() == "Internet") {
			tableModel.setDataVector(internetData, col);
		}
		
		if(e.getSource() == querry && issueType.getSelectedItem() == "Cable") {
			tableModel.setDataVector(cableData, col);
		}
		
		if(e.getSource() == querry && issueType.getSelectedItem() == "Payment") {
			tableModel.setDataVector(paymentData, col);
		}
		
		if(e.getSource() == querry && issueType.getSelectedItem() == "Other") {
			tableModel.setDataVector(otherData, col);
		}
		
		
		
			

		
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
