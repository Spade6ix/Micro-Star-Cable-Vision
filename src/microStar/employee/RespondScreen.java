package microStar.employee;

import java.awt.Color;
import java.awt.Component;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

public class RespondScreen extends JPanel implements MouseListener, ActionListener{
	
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
	
	private String col[] = {"Customer ID", "Customer Name", "Email", "Contact", "Address", "Issue Type", "Details", "Resolved"};
	private String data[][] = null;
	private DefaultTableModel tableModel = null;
	private JScrollPane scrollPane;
	public JTable table = null;
	
	private JLabel responseLabel = new JLabel("Response:");
	public JTextArea response = new JTextArea();
	public JButton save = new JButton("Save Changes");
	
	
	public RespondScreen(String d1[][]) {
		this.data = d1;
		
		//Panel Setup
		this.setLayout(new GridBagLayout());
		this.setBackground(new Color(0x333333));
		this.setBorder(new EmptyBorder(10, 30, 30, 30)); //top left bottom right
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weightx = 1;
		gbc.weighty = 1;
		
		//Table Setup
		tableModel = new DefaultTableModel(data, col); //table data & column names
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
		table.setPreferredSize(new Dimension(1100, 390));	
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        
        //ScrollPane
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        scrollPane.setBackground(new Color(0x333333));
        scrollPane.getVerticalScrollBar().setUI(null); //removes vertical slider
        scrollPane.setBorder(new EmptyBorder(0,0,0,0)); //removes ScrollPane border
        scrollPane.setPreferredSize(new Dimension(1100, 390));	
        this.add(scrollPane, gbc);
        
        
        //Response Label
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        responseLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
        responseLabel.setForeground(new Color(0x999999));
	    this.add(responseLabel, gbc);
        
        //Issue Details TextArea
	    gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.SOUTHWEST;
        response.setFont(new Font("Calibri", Font.PLAIN, 15));
        response.setForeground(new Color(0x333333));
        response.setBackground(new Color(0x999999));
        response.setPreferredSize(new Dimension(500, 150));
        response.setLineWrap(true);
        response.setBorder(null);
	    this.add(response, gbc);
        
        //Save Button
		gbc.gridx = 3;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.SOUTHEAST;
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

		//SAVE BUTTON
		if(e.getSource() == save) {
			try {
				int selectedRow = table.getSelectedRow();
				String text = response.getText();
				String idValue = (String) table.getValueAt(selectedRow, 0);
				response.setText("");
				//call method to update database
				System.out.println(idValue + " " + text);
				JOptionPane.showMessageDialog(table, "Response saved successfully", "successful", JOptionPane.INFORMATION_MESSAGE);
			}
			catch (Exception ex) {
				System.out.println("Nothing selected");
			}
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
