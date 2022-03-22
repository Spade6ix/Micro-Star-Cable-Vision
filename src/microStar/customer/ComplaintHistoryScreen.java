package microStar.customer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.ScrollBarUI;
import javax.swing.table.*;


public class ComplaintHistoryScreen extends JPanel implements MouseListener{
	
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
	 */
	
	private String col[] = {"Last Response Date", "Complaint Details", "Rep Name"};
	private DefaultTableModel tableModel = null;
	
	public JButton moreInfo = new JButton("More Info");
	public JTable table = null;
	
	
	
	
	public ComplaintHistoryScreen(String data[][]) {
		
		//Table Setup
		tableModel = new DefaultTableModel(data, col); //table data & column names
		table = new JTable(tableModel) {
			
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int d, int column) { //makes table non editable
				return false;
			}
			
			public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
				Component c = super.prepareRenderer(renderer, row, col);
				return c;
			}
		};
		JScrollPane scrollPane = new JScrollPane(table); //add table to ScrollPane
		
		
		//Panel Setup
		this.setLayout(new GridBagLayout());
		this.setBackground(new Color(0x333333));
		this.setBorder(new EmptyBorder(20, 0, 20, 0)); 
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weightx = 1;
		gbc.weighty = 1;
		
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		
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
		table.setPreferredSize(new Dimension(1100, 450));	
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        
        //Scroll Pane
        scrollPane.setPreferredSize(new Dimension(1100, 450));
        scrollPane.setBackground(new Color(0x333333));
        scrollPane.getVerticalScrollBar().setUI(null); //removes vertical slider
        scrollPane.setBorder(new EmptyBorder(0,0,0,0)); //removes ScrollPane border
		this.add(scrollPane, gbc);
		
		
		//More Infor Button
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.insets = new Insets(0, 50, 0, 0);
		gbc.anchor = GridBagConstraints.WEST;
        moreInfo.setFont(new Font("Calibri", Font.PLAIN, 25));
        moreInfo.setVerticalTextPosition(SwingConstants.CENTER);
        moreInfo.setForeground(new Color(0x333333));
        moreInfo.setBackground(new Color(0x6666ff));
        moreInfo.setBorder(null);
        moreInfo.setPreferredSize(new Dimension(115, 45));
        moreInfo.addMouseListener(this);
		this.add(moreInfo, gbc);
		
		
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
