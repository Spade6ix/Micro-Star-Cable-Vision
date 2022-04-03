package microStar.customer;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.JScrollPane;

public class PaymentHistoryScreen extends JPanel {
	
	private String col[] = {"Payment Date", "Amount Paid $"};
	private DefaultTableModel tableModel = null;
	
	public JTable table = null;
	
	
	public PaymentHistoryScreen(String data[][]) {
		
		//Table Setup
		tableModel = new DefaultTableModel(data, col); 
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


	}
	
}
