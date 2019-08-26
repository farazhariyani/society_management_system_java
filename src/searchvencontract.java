import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.sql.*;

import net.proteanit.sql.DbUtils;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


public class searchvencontract extends JInternalFrame {

	private JPanel contentPane;
	private ButtonGroup group;
	private JComboBox<String> c2;
	private JRadioButton r2;
	private Vector<String> columnNames = new Vector<String>();
	private Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	private javax.swing.JScrollPane scrollPane;
	private JTable table;
	private JPanel tablePanel;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws NullPointerException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchflat frame = new searchflat();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void fillcombobox()
	{
		
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con = DriverManager.getConnection("jdbc:odbc:mypro");
		
		String query="select * from FLAT order by FLAT_ROWHOUSE_NO ";
		PreparedStatement pst=con.prepareStatement(query);
		ResultSet rs=pst.executeQuery();
		
		while(rs.next())
		{
			
			//c1.addItem(rs.getString("FLAT_ROWHOUSE_NO"));
		
		}
		con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void fillcombobox2()
	{
		
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con = DriverManager.getConnection("jdbc:odbc:mypro");
		
		String query="select distinct VENDOR_ID from VENDOR_CONTRACT order by VENDOR_ID ";
		PreparedStatement pst=con.prepareStatement(query);
		ResultSet rs=pst.executeQuery();
		
		while(rs.next())
		{	
			
			c2.addItem(rs.getString("VENDOR_ID"));
		}
		con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Create the frame.
	 */
	public searchvencontract() throws SQLException{
	  try
	  {
		  setTitle("Vendor Contract");
			//setMaximum(true);
			setMaximizable(true);
			setClosable(true);
			setBounds(100, 100, 839, 554);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			contentPane.setLayout(null);
			contentPane.setLayout(null);
			
			JLabel lblOwner = new JLabel("VENDOR CONTRACT");
			lblOwner.setFont(new Font("Times New Roman", Font.BOLD, 20));
			lblOwner.setBounds(187, 11, 236, 24);
			 getContentPane().add(lblOwner);
			
			JLabel lblSearchBy = new JLabel("Search By");
			lblSearchBy.setFont(new Font("Times New Roman", Font.BOLD, 14));
			lblSearchBy.setBounds(42, 91, 66, 24);
			 getContentPane().add(lblSearchBy);
		
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(483, 254, 280, 93);
			 getContentPane().add(panel_1);
		 
		 c2 = new JComboBox<String>();
		 c2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		 c2.setBounds(293, 94, 96, 20);
		 contentPane.add(c2);
		 
		 fillcombobox();
		 fillcombobox2();
		 
		 r2 = new JRadioButton("Vendor Id");
		 r2.addFocusListener(new FocusAdapter() {
			 	public void focusLost(FocusEvent e) {
			 		if(r2.isSelected())
			 		{
			 			//r1.setSelected(false);
			 		}
			 	}
			 });
		 r2.setSelected(true);
		 r2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		 r2.setBounds(168, 91, 114, 25);
		 contentPane.add(r2);
		 
		 ButtonGroup bg=new ButtonGroup();
		 bg.add(r2);

		 
		

		/*table1 = new JTable(1,7);	
		DefaultTableModel model = (DefaultTableModel)table1.getModel();	
		table1.setBounds(44, 115, 433, 280);
		 contentPane.add(table1);
		 
		 model.addColumn("Id"); 
		 model.addColumn("FLAT/ROWHOUSE NO."); 
		 model.addColumn("UNIT TYPE"); 
		 model.addColumn("UNIT SIZE"); 
		 model.addColumn("TERRACE SIZE"); 
		 model.addColumn("USAGE");
		 model.addColumn("CURRENT STATUS");*/
		 
		 JButton Search = new JButton("Search");
		 Search.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\search.png"));
			Search.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				try{
					
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con=DriverManager.getConnection("jdbc:odbc:mypro");
					Statement stmt = con.createStatement();
					ResultSet rs=null;
					
					data.clear();
					
					/*if(r1.isSelected())
					{
						String q1="select * from FLAT where FLAT_ROWHOUSE_NO="+(int)c1.getSelectedItem();
						Statement stmt = con.createStatement();
						System.out.println("1"+c1.getSelectedItem().getClass());
						ResultSet rs = stmt.executeQuery( q1 );
						System.out.println("2");
						//buildTableModel(rs);
						ResultSetMetaData md = rs.getMetaData();
						
						int columns = md.getColumnCount();
						System.out.println("2");
						for (int i = 1; i <= columns; i++) 
						    {
							columnNames.addElement( md.getColumnName(i) );
							System.out.println("c"+md.getColumnName(i));
							}
						rs = stmt.executeQuery( q1 );
						System.out.println(columns);
							while (rs.next()) 
							{
							Vector<Object> row = new Vector<Object>(columns);
							for (int i = 1; i <= columns; i++) 
							  {
								row.addElement( rs.getObject(i) );
							  }
							System.out.println("row is:"+row);
							data.addElement( row );
							}
							rs.close();
							stmt.close();
					}
					*/
					//System.out.println("c");
					//if(rbtnoid.isSelected())
					{
						//System.out.println("d");
						String q1="select * from VENDOR_CONTRACT where VENDOR_ID="+c2.getSelectedItem();
						rs = stmt.executeQuery( q1 );
						//buildTableModel(rs);
						ResultSetMetaData md = rs.getMetaData();
						int columns = md.getColumnCount();
						for (int i = 1; i <= columns; i++) 
						    {
							columnNames.addElement( md.getColumnName(i) );
							//System.out.println("c"+md.getColumnName(i));
							}
						System.out.println(rs.getFetchSize()+"in");
						rs = stmt.executeQuery( q1 );
							while (rs.next()) 
							{
								
							Vector<Object> row = new Vector<Object>(columns);
							for (int i = 1; i <= columns; i++) 
							  {
								row.addElement( rs.getObject(i) );
								
							  }
							//System.out.println("row is:"+row);
							data.addElement( row );
							}
							rs.close();
							stmt.close();
					}
					table = new JTable(data, columnNames);
				 
					contentPane.add(table);
					 scrollPane = new JScrollPane( table );
					tablePanel = new JPanel();
					
					
					//tablePanel.setBounds(35, 300, 405, 225);
					//tablePanel.setSize(200,200);
				  tablePanel.setLayout(new BorderLayout(1,2));
				  
					
					tablePanel.setBounds(186, 160, 127, 68);
					tablePanel.setLocation(60, 200);
					tablePanel.add(scrollPane,BorderLayout.SOUTH);
					getContentPane().add( tablePanel,BorderLayout.WEST );
					
					DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				    dtm.setRowCount(10);
					validate();
					
					getContentPane().repaint();
					table.repaint();
					
				}
					catch(Exception e1) 
					{
					System.out.println( e1 );
					}
				 

				
				}
			});
		Search.setFont(new Font("Times New Roman", Font.BOLD, 14));
		Search.setBounds(418, 87, 144, 33);
		 getContentPane().add(Search);
		 
		 JButton delete = new JButton("Delete");
		 delete.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\delete.png"));
			delete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				try
				{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");					
					Connection  con= DriverManager.getConnection("jdbc:odbc:mypro");
					//Statement stmt;
					DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				
					//tableModel.getDataVector().elementAt(table.getSelectedRow());
					
					
					int row = table.getSelectedRow();
					String value = table.getModel().getValueAt(row, 0).toString();
					//System.out.println("selected Value is :"+tableModel.getValueAt(table.getSelectedRow(), table.getSelectedColumn()));
					
					PreparedStatement pst;
					String query = "Delete from VENDOR_CONTRACT where VENDOR_ID="+value;
					pst = con.prepareStatement(query);
					int result = pst.executeUpdate();
					if(result == 1)
						{
						String message_dialog = "Record Deleted";
					    JOptionPane.showMessageDialog((Component) null, message_dialog);
					    DefaultTableModel dtm = (DefaultTableModel) table.getModel();
					    dtm.fireTableChanged(null);
					    table.repaint();
					    data.clear();
						}
					else
						{
						String message_dialog = "Record not Deleted";
					    JOptionPane.showMessageDialog((Component) null, message_dialog);	
							
						}
					pst.close();		
					getContentPane().repaint();
					table.repaint();
				}
				catch(Exception e1)
				{e1.printStackTrace();}
				}
			});
			delete.setFont(new Font("Times New Roman", Font.BOLD, 14));
			panel_1.add(delete);
			
			JButton update = new JButton("To Update");
			update.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\refresh.png"));
			update.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try
					{
						int row = table.getSelectedRow();
						int value = Integer.parseInt(table.getModel().getValueAt(row, 1).toString());
					vendorcontract so=new vendorcontract(value);
					
					so.getContentPane().setLayout(new BorderLayout(1,1));
					//System.out.println("clicked");
					contentPane.add(so);
					so.setVisible(true);
					so.setSelected(true);
					so.toFront();
					so.repaint();
					so.setMaximum(true);
					so.setMaximizable(true);
					}catch(Exception e1){
					e1.printStackTrace();
					}			
					}
			});
			update.setFont(new Font("Times New Roman", Font.BOLD, 14));
			panel_1.add(update);       
			
			JButton cancel = new JButton("Cancel");
			cancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				dispose();
				}
			});
			cancel.setFont(new Font("Times New Roman", Font.BOLD, 14));
			panel_1.add(cancel);
		  
		 
		 
		 
	  }
	  catch(Exception e){
		  
		  e.printStackTrace();
	  }
		 		
		
	}
	
	public static DefaultTableModel buildTableModel(ResultSet rs)
	        throws SQLException {

	    ResultSetMetaData metaData = rs.getMetaData();

	    // names of columns
	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
	    for (int column = 1; column <= columnCount; column++) {
	        columnNames.add(metaData.getColumnName(column));
	    }

	    // data of the table
	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    while (rs.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	            vector.add(rs.getObject(columnIndex));
	        }
	        data.add(vector);
	    }

	    return new DefaultTableModel(data, columnNames);

	}
	
}
