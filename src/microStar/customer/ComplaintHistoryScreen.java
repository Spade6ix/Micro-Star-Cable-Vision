package microStar.customer;

import java.awt.BorderLayout;
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
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
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
	
	private String mainCol[] = {"Last Response Date", "Complaint Details", "Rep Name"};
	private String moreCol[] = {"Rep Name", "Responses", "Proposed Visit Date"};
	private String mainData[][] = null;
	private String moreData[][] = null;
	private DefaultTableModel mainTableModel = null;
	private DefaultTableModel moreTableModel = null;
	private JScrollPane mainScrollPane;
	private JScrollPane moreScrollPane;
	private JLayeredPane layeredPane = new JLayeredPane();
	
	public JButton moreInfo = new JButton("More Info");
	public JTable mainTable = null;
	public JTable moreTable = null;
	
	
	
	
	public ComplaintHistoryScreen(String d1[][], String d2[][]) {
		this.mainData = d1;
		this.moreData = d2;
		
		//Table Setup
		mainTableModel = new DefaultTableModel(mainData, mainCol); //table data & column names
		mainTable = new JTable(mainTableModel) {
			
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int d, int column) { //makes table non editable
				return false;
			}
			
			public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
				Component c = super.prepareRenderer(renderer, row, col);
				return c;
			}
		};
		mainScrollPane = new JScrollPane(mainTable); //add table to ScrollPane
		
		
		//Panel Setup
		this.setLayout(new GridBagLayout());
		this.setBackground(new Color(0x333333));
		this.setBorder(new EmptyBorder(20, 0, 20, 0)); //top left bottom right
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weightx = 1;
		gbc.weighty = 1;
		
		
		//Table Header
		JTableHeader header = mainTable.getTableHeader();
		header.setBackground(new Color(0x4d4d4d));
		header.setForeground(new Color(0x999999));
		header.setPreferredSize(new Dimension(0, 28));
		header.setFont(new Font("Calibri", Font.BOLD, 18));
		UIManager.getDefaults().put("TableHeader.cellBorder", new EmptyBorder(0,0,0,0)); //removes grid from table header

		
		//Table Body
		mainTable.setRowHeight(20);
        mainTable.setFont(new Font("calibri", Font.PLAIN, 15));
        mainTable.setGridColor(new Color(0x5a5a5a));
        mainTable.setBackground(new Color(0x666666));
        mainTable.setForeground(new Color(0xc2c2c2));
		mainTable.setPreferredSize(new Dimension(1100, 450));	
        mainTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        
        //ScrollPane
        mainScrollPane.setBackground(new Color(0x333333));
        mainScrollPane.getVerticalScrollBar().setUI(null); //removes vertical slider
        mainScrollPane.setBorder(new EmptyBorder(0,0,0,0)); //removes ScrollPane border
        mainScrollPane.setBounds(0,0,1100,450);
        
      
        //LayeredPane
        gbc.gridx = 1;
		gbc.gridy = 1;
		layeredPane.setPreferredSize(new Dimension(1100, 450));
		layeredPane.setBackground(new Color(0x6666ff));
		layeredPane.setOpaque(true);
		layeredPane.add(mainScrollPane);
		this.add(layeredPane, gbc);
		
		
		
		//More Info Button
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
	
	
	
	
	
	
	
	
	
	private void moreInfoWindow() {
		JInternalFrame iFrame = new JInternalFrame("More Info");
		
		iFrame.setLayout(new GridBagLayout());
		iFrame.setBackground(new Color(0x333333));
		iFrame.setBorder(new EmptyBorder(0, 0, 0, 0)); 
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridx = 1;
		gbc.gridy = 1;
		
		
		
		//Table
		moreTableModel = new DefaultTableModel(moreData, moreCol); //table data & column names
		moreTable = new JTable(moreTableModel) {
			
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int d, int column) { //makes table non editable
				return false;
			}
			
			public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
				Component c = super.prepareRenderer(renderer, row, col);
				return c;
			}
		};
		moreScrollPane = new JScrollPane(moreTable); //add table to ScrollPane
		
		//Table Header
		JTableHeader header = moreTable.getTableHeader();
		header.setBackground(new Color(0x4d4d4d));
		header.setForeground(new Color(0x999999));
		header.setPreferredSize(new Dimension(0, 28));
		header.setFont(new Font("Calibri", Font.BOLD, 18));
		UIManager.getDefaults().put("TableHeader.cellBorder", new EmptyBorder(0,0,0,0)); //removes grid from table header

		
		//Table Body
		moreTable.setRowHeight(20);
		moreTable.setFont(new Font("calibri", Font.PLAIN, 15));
		moreTable.setGridColor(new Color(0x5a5a5a));
		moreTable.setBackground(new Color(0x666666));
		moreTable.setForeground(new Color(0xc2c2c2));
		moreTable.setPreferredSize(new Dimension(890, 360));	
		moreTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        
        //ScrollPane
        moreScrollPane.setBackground(new Color(0x333333));
        moreScrollPane.getVerticalScrollBar().setUI(null); //removes vertical slider
        moreScrollPane.setBorder(new EmptyBorder(0,0,0,0)); //removes ScrollPane border
        moreScrollPane.setPreferredSize(new Dimension(890, 360));
		
        
        //LayeredPane
        iFrame.add(moreScrollPane, gbc);
        layeredPane.add(iFrame);
		
        
		//setup JInternal Frame
		iFrame.setBounds(100,25,900,400);
        iFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        iFrame.setResizable(false);
        iFrame.setClosable(true);
        iFrame.setVisible(true);
	}
	
	
	
	
	
	
	

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(e.getSource() == moreInfo) {
			moreInfoWindow();
		}
		
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
