package microStar.employee;

import java.awt.Color;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;



import javax.swing.JLabel;

public class ResolvedScreen extends JPanel {
	
	
	public ResolvedScreen() {
		
	}
	
		private String[] issues = {"","Internet", "Cable", "Payment"};
		public JComboBox<String> issueType = new JComboBox<String>(issues);
	
		private String col[] = {"Customer ID", "Customer Name", "Email","Contact","Address","Issue Type","Complaint Details", "Tech"};
		private DefaultTableModel tableModel = null;
		
		private String data[][] = null;
		private String data1[][] = null;
		private String data2[][] = null;
		private String data3[][]= null;
	
		public JTable table = null;
		public JButton query = new JButton("Query");
		public JLabel issuetype = new JLabel("Issue Type:");
		
		
		public ResolvedScreen(String d1[][], String d11[][], String d2[][], String d3[][]) {
			this.data = d1;
			this.data1 = d11;
			this.data2 = d2;
			this.data3 = d3;
			
			tableModel = new DefaultTableModel(d1, col); 
			table = new JTable(tableModel) {
				
				private static final long serialVersionUID = 1L;

				public boolean isCellEditable(int d, int column) {
					return false;
				}
				
				public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
					Component c = super.prepareRenderer(renderer, row, col);
					return c;
				}
			};
			JScrollPane scrollpane = new JScrollPane(table);
			
			this.setLayout(new GridBagLayout());
			this.setBackground(new Color(0x333333));
			this.setBorder(new EmptyBorder(20, 0, 20, 0)); 
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.weightx = 1;
			gbc.weighty = 1;
			
			
			gbc.gridx = 1;
			gbc.gridy = 1;
			
			JTableHeader header = table.getTableHeader();
			header.setBackground(new Color(0x4d4d4d));
			header.setForeground(new Color(0x999999));
			header.setPreferredSize(new Dimension(0, 28));
			header.setFont(new Font("Calibri", Font.BOLD, 18));
			UIManager.getDefaults().put("TableHeader.cellBorder", new EmptyBorder(0,0,0,0));
			
			table.setRowHeight(20);
	        table.setFont(new Font("calibri", Font.PLAIN, 15));
	        table.setGridColor(new Color(0x5a5a5a));
	        table.setBackground(new Color(0x666666));
	        table.setForeground(new Color(0xc2c2c2));
			table.setPreferredSize(new Dimension(1100, 450));	
	        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	        
	        
	    
	        scrollpane.setPreferredSize(new Dimension(1100, 450));
	        scrollpane.setBackground(new Color(0x333333));
	        scrollpane.getVerticalScrollBar().setUI(null);
	        scrollpane.setBorder(new EmptyBorder(0,0,0,0)); 
			this.add(scrollpane, gbc);
			
			 gbc.gridx = 2;
		     gbc.gridy = 0;
		     issueType.setFont(new Font("Calibri", Font.PLAIN, 25));
		     issueType.setForeground(new Color(0xbfbfbf));
		     this.add(issueType, gbc);
			
		//	combobox
		    gbc.gridx = 1;
		    gbc.gridy = 0;
		    gbc.anchor = GridBagConstraints.NORTHEAST;
		    gbc.insets = new Insets(0,0,0,30);
		    issueType.setFont(new Font("Calibri", Font.PLAIN, 25));
		    issueType.setForeground(new Color(0x333333));
		    issueType.setBackground(new Color(0x999999));
		    issueType.setPreferredSize(new Dimension(250, 40));
		  //  issueType.setBorder(null);
		    issueType.setBorder(new EmptyBorder(0,0,0,0));
		    this.add(issueType,gbc);
	
			
			gbc.gridx = 1;
			gbc.gridy = 2;
			gbc.insets = new Insets(0, 50, 0, 0);
			gbc.anchor = GridBagConstraints.WEST;
	        query.setFont(new Font("Calibri", Font.PLAIN, 25));
	        query.setVerticalTextPosition(SwingConstants.CENTER);
	        query.setForeground(new Color(0x333333));
	        query.setBackground(new Color(0x6666ff));
	        query.setBorder(null);
	        query.setPreferredSize(new Dimension(115, 45));
	      //  query.addMouseListener(this);
			this.add(query, gbc);
		
		
		
	      query.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
	      	
	      		String combo = null;
	      		combo = issueType.getSelectedItem().toString();
	      	 	
	      		if(combo=="Internet") {
	      		//	String[] issues = {"Internet"};
	      			tableModel.setDataVector(d11,d11);
	      		}
	      		
	      		if(combo=="Cable") {
	      			tableModel.setDataVector(d2, d2);
	      		}
	      		
	      		if(combo=="Payment") {
	      			tableModel.setDataVector(d3, d3);
	      		}
	      	}
	      });
		
		

			   
	}
		


}
	


