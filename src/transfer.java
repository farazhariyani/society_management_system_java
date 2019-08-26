import java.awt.BorderLayout;
import java.awt.Component;

import org.jdesktop.swingx.JXDatePicker;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;

import javax.swing.JLabel;

import java.awt.Font;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.DefaultComboBoxModel;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


public class transfer extends JInternalFrame {
	
	private JTextField tid,txtDate,ttamt;
	//private JFormattedTextField ttamt;
	private JXDatePicker tdt;
	private JButton btnNewButton;
	private JComboBox<String> tut,tfrn,toidold,toidnew;
	String message_dialog;
	String add_dialog = "Database Record Added";
	String not_dialog = "Database Record Not Added";
	Double amount;
	private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private Vector<String> columnNames = new Vector<String>();
	private Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	private javax.swing.JScrollPane scrollPane;
	private JTable table,table_1;
	private JPanel tablePanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					transfer frame = new transfer();
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
		
		String query="select * from FLAT";
		PreparedStatement pst=con.prepareStatement(query);
		ResultSet rs=pst.executeQuery();
		
		while(rs.next())
		{
			tfrn.addItem(rs.getString("FLAT_ROWHOUSE_NO"));
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
			String query2="select * from OWNER";
			PreparedStatement pst2=con.prepareStatement(query2);
			ResultSet rs2=pst2.executeQuery();
			
			while(rs2.next())
			{
				toidold.addItem(rs2.getString("OWNER_ID"));
				toidnew.addItem(rs2.getString("OWNER_ID"));
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
	public void fillcombobox3()
	{
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con = DriverManager.getConnection("jdbc:odbc:mypro");
			String query2="select * from OWNER";
			PreparedStatement pst2=con.prepareStatement(query2);
			ResultSet rs2=pst2.executeQuery();
			
			while(rs2.next())
			{
				//toidold.addItem(rs2.getString("OWNER_ID"));
				toidnew.addItem(rs2.getString("OWNER_ID"));
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
	public transfer() {
		try{
		setTitle("Transfer");
		//setMaximum(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 491, 390);
		getContentPane().setLayout(null);
		
		JLabel lblTransfer = new JLabel("Transfer");
		lblTransfer.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTransfer.setBounds(170, 21, 136, 14);
		 getContentPane().add(lblTransfer);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblId.setBounds(52, 62, 46, 14);
		 getContentPane().add(lblId);
		
		JLabel lblUnitType = new JLabel("Unit Type");
		lblUnitType.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblUnitType.setBounds(52, 87, 75, 14);
		 getContentPane().add(lblUnitType);
		
		JLabel lblFlatRow = new JLabel("Flat / Row House Number");
		lblFlatRow.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblFlatRow.setBounds(52, 112, 169, 14);
		 getContentPane().add(lblFlatRow);
		
		JLabel lblOwnerIdold = new JLabel("Owner ID (Old)");
		lblOwnerIdold.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblOwnerIdold.setBounds(52, 137, 109, 14);
		 getContentPane().add(lblOwnerIdold);
		
		JLabel lblOwnerIdnew = new JLabel("Owner ID (New)");
		lblOwnerIdnew.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblOwnerIdnew.setBounds(52, 164, 109, 14);
		 getContentPane().add(lblOwnerIdnew);
		
		JLabel lblTransferAmount = new JLabel("Transfer Amount");
		lblTransferAmount.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTransferAmount.setBounds(52, 189, 109, 14);
		 getContentPane().add(lblTransferAmount);
		
		JLabel lblTransferDate = new JLabel("Transfer Date");
		lblTransferDate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTransferDate.setBounds(52, 214, 109, 14);
		 getContentPane().add(lblTransferDate);
		
		tid = new JTextField();
		tid.setEditable(false);
		tid.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		tid.setBounds(236, 60, 128, 20);
		 getContentPane().add(tid);
		tid.setColumns(10);
		System.out.print("5");
		ttamt = new JTextField();//NumberFormat.getNumberInstance());
		//amount=Double.parseDouble(ttamt.getText());
		 System.out.print("4");
		
		ttamt.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		//ttamt.setText(amount.toString());//new Double(amount));
		ttamt.setColumns(10);
      /*  ttamt.addPropertyChangeListener("value", (PropertyChangeListener) this);
		ttamt.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent e) {
				//amount = ((Number)ttamt.getValue()).doubleValue();
				amount=Double.parseDouble((ttamt.getText()));
			}
		});*/
		ttamt.setBounds(236, 187, 128, 20);
		 getContentPane().add(ttamt);
		 System.out.print("3");
		tut = new JComboBox<String>();
		System.out.print("2");
		tut.setModel(new DefaultComboBoxModel(new String[] {"FALT", "ROW HOUSE"}));
		System.out.print("1");
		tut.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		tut.setEditable(true);
		tut.setBounds(236, 85, 128, 20);
		 getContentPane().add(tut);
		 System.out.print("2");
		
		tfrn = new JComboBox<String>();
		tfrn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		tfrn.setEditable(true);
		tfrn.setBounds(236, 110, 128, 20);
		 getContentPane().add(tfrn);
		
		toidold = new JComboBox<String>();
		toidold.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		toidold.setEditable(true);
		toidold.setBounds(236, 134, 128, 20);
		 getContentPane().add(toidold);
		
		toidnew = new JComboBox<String>();
		toidnew.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		toidnew.setEditable(true);
		toidnew.setBounds(236, 162, 128, 20);
		 getContentPane().add(toidnew);
		 
		 fillcombobox();
		 fillcombobox2();
		 fillcombobox3();
		JPanel panel = new JPanel();
		panel.setBounds(98, 248, 281, 77);
		 getContentPane().add(panel);

		

		//create text field
		txtDate = new JTextField();
		//set bounds of text field
		txtDate.setBounds(236,215,128,20);
		//add text field to contentPane
		getContentPane().add(txtDate);
		//set columns
		txtDate.setColumns(10);
		
		//create button and there object
		btnNewButton = new JButton("...");
		//perform action listener
		btnNewButton.addActionListener(new ActionListener() 
		{	
			//performed action
			public void actionPerformed(ActionEvent arg0) 
			{
				//create frame new object  f
				final JFrame f = new JFrame();
				//set text which is collected by date picker i.e. set date 
				txtDate.setText(new DatePicker(f).setPickedDate());
			}
		});
		//set button bound
		btnNewButton.setBounds(374,215,17,20);//+107
		//add button in contentPane
		getContentPane().add(btnNewButton);
		
		/*tdt = new JXDatePicker();
		tdt.getEditor().setFont(new Font("Times New Roman", Font.PLAIN, 14));
		tdt.setBounds(236,215,94,20);
		tdt.setDate(Calendar.getInstance().getTime());
        //sregdt.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
        //sregdt.setFormats("dd.mm.yyyy");
         getContentPane().add(tdt);*/
		
				
		JButton tadd = new JButton("Add");
		tadd.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\new.png"));
		tadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tid.enableInputMethods(true);
				ttamt.enableInputMethods(true);
				tdt.enableInputMethods(true);
				tut.enableInputMethods(true);
				tfrn.enableInputMethods(true);
				toidold.enableInputMethods(true);
				toidnew.enableInputMethods(true);
				
				tid.setText(null);
				ttamt.setText(null);
				
			}
		});
		tadd.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(tadd);
		
		JButton tsave = new JButton("Save");
		tsave.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\Save.png"));
		tsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con=DriverManager.getConnection("jdbc:odbc:mypro");
					
					Statement st=con.createStatement();
					String q1="select * from TRANSFER";
					ResultSet rs=st.executeQuery(q1);
					int cnt=0;
					while(rs.next())
						cnt++;
					cnt=cnt+1;
					
					String q2="INSERT INTO TRANSFER (UNIT_TYPE,FLAT_ROWHOUSE_NO,OWNER_ID,OWNER_ID_NEW,TRANSFER_AMOUNT,TRANSFER_DATE) VALUES('"+tut.getSelectedItem()+"','"+tfrn.getSelectedItem()+"','"+toidold.getSelectedItem()+"','"+toidnew.getSelectedItem()+"',"+Integer.parseInt(ttamt.getText())+",'"+tdt.getDate()+"')";

					int rs_int=st.executeUpdate(q2);
					if(rs_int>0){
					       message_dialog=""+tid.getText().toUpperCase()+"Record inserted";
					    int type_dialog = JOptionPane.PLAIN_MESSAGE;
					    JOptionPane.showMessageDialog((Component) null, message_dialog, add_dialog, type_dialog);}
					    else 
					    {message_dialog=""+tid.getText().toUpperCase()+"Record Not inserted";
					    int type_dialog = JOptionPane.PLAIN_MESSAGE;
					    JOptionPane.showMessageDialog((Component) null, message_dialog, not_dialog, type_dialog);}
					    	System.out.println("Record not inserted");
					    	
				tid.enableInputMethods(false);
				ttamt.enableInputMethods(false);
				tdt.enableInputMethods(false);
				tut.enableInputMethods(false);
				tfrn.enableInputMethods(false);
				toidold.enableInputMethods(false);
				toidnew.enableInputMethods(false);
				con.close();
				}
				catch(ClassNotFoundException ce) {System.out.println("Class not found exception.");}
				catch(SQLException sqle){System.out.println(sqle);}
				catch(Exception l){System.out.println("In catch "+l);}
			
			
			}
		});
		tsave.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(tsave);
		
		JButton tcancel = new JButton("Cancel");
		tcancel.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\cancel.png"));
		tcancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tid.setText(null);
				ttamt.setText(null);
			}
		});
		tcancel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(tcancel);
		
		JLabel label = new JLabel("in Rupees");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label.setBounds(379, 190, 86, 14);
		getContentPane().add(label);
		
		try{
			
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:mypro");
			Statement stmt = con.createStatement();
			ResultSet rs=null;
			
			String q1="select * from TRANSFER";
			rs = stmt.executeQuery( q1 );
			//buildTableModel(rs);
			ResultSetMetaData md = rs.getMetaData();
			int columns = md.getColumnCount();
			for (int i = 1; i <= columns; i++) 
			    {
				columnNames.addElement( md.getColumnName(i) );
				//System.out.println("c"+md.getColumnName(i));
				}
			//System.out.println(rs.getFetchSize()+"in");
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
		
		table = new JTable(data, columnNames);
	 
		
		table.setCellEditor(null);
		table.setAutoscrolls(true);
		table.setAlignmentY(CENTER_ALIGNMENT);
		table.setAlignmentX(CENTER_ALIGNMENT);
		
		getContentPane().add(table);
		 
		tablePanel = new JPanel();
		
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(10);
		columnModel.getColumn(1).setPreferredWidth(20);
		columnModel.getColumn(2).setPreferredWidth(30);
		columnModel.getColumn(3).setPreferredWidth(30);
		columnModel.getColumn(4).setPreferredWidth(30);
		columnModel.getColumn(5).setPreferredWidth(50);
		columnModel.getColumn(6).setPreferredWidth(50);
		
		scrollPane = new JScrollPane( table );
		scrollPane.setBounds(10, 11, 716, 398);
		//scrollPane.setPreferredSize(new Dimension(480, 300));
		//tablePanel.setBounds(35, 300, 405, 225);
		//tablePanel.setSize(200,200);
	  //tablePanel.setLayout(new BorderLayout(1,2));
	  //tablePanel.setLayout(new BorderLayout());
	  
		
		tablePanel.setBounds(600,100,736,420);
		tablePanel.setLocation(600,100);
		tablePanel.setLayout(null);
		tablePanel.add(scrollPane);
		getContentPane().add( tablePanel,BorderLayout.WEST );
		
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
	    //dtm.setRowCount(10);
		validate();
		
		getContentPane().repaint();
		table.repaint();
			
		}catch(Exception e){e.printStackTrace();}
		
		
		
		}
		catch(Exception e ){}
		
	}
	
	
	public transfer(int value) throws SQLException,NullPointerException{
		try{
		
			setTitle("Transfer");
			//setMaximum(true);
			setMaximizable(true);
			setClosable(true);
			setBounds(100, 100, 491, 390);
			getContentPane().setLayout(null);
			
			JLabel lblTransfer = new JLabel("Transfer");
			lblTransfer.setFont(new Font("Times New Roman", Font.BOLD, 20));
			lblTransfer.setBounds(170, 21, 136, 14);
			 getContentPane().add(lblTransfer);
			
			JLabel lblId = new JLabel("ID");
			lblId.setFont(new Font("Times New Roman", Font.BOLD, 14));
			lblId.setBounds(52, 62, 46, 14);
			 getContentPane().add(lblId);
			
			JLabel lblUnitType = new JLabel("Unit Type");
			lblUnitType.setFont(new Font("Times New Roman", Font.BOLD, 14));
			lblUnitType.setBounds(52, 87, 75, 14);
			 getContentPane().add(lblUnitType);
			
			JLabel lblFlatRow = new JLabel("Flat / Row House Number");
			lblFlatRow.setFont(new Font("Times New Roman", Font.BOLD, 14));
			lblFlatRow.setBounds(52, 112, 169, 14);
			 getContentPane().add(lblFlatRow);
			
			JLabel lblOwnerIdold = new JLabel("Owner ID (Old)");
			lblOwnerIdold.setFont(new Font("Times New Roman", Font.BOLD, 14));
			lblOwnerIdold.setBounds(52, 137, 109, 14);
			 getContentPane().add(lblOwnerIdold);
			
			JLabel lblOwnerIdnew = new JLabel("Owner ID (New)");
			lblOwnerIdnew.setFont(new Font("Times New Roman", Font.BOLD, 14));
			lblOwnerIdnew.setBounds(52, 164, 109, 14);
			 getContentPane().add(lblOwnerIdnew);
			
			JLabel lblTransferAmount = new JLabel("Transfer Amount");
			lblTransferAmount.setFont(new Font("Times New Roman", Font.BOLD, 14));
			lblTransferAmount.setBounds(52, 189, 109, 14);
			 getContentPane().add(lblTransferAmount);
			
			JLabel lblTransferDate = new JLabel("Transfer Date");
			lblTransferDate.setFont(new Font("Times New Roman", Font.BOLD, 14));
			lblTransferDate.setBounds(52, 214, 109, 14);
			 getContentPane().add(lblTransferDate);
			
			tid = new JTextField();
			tid.setEditable(false);
			tid.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			tid.setBounds(236, 60, 128, 20);
			 getContentPane().add(tid);
			tid.setColumns(10);
			System.out.print("5");
			ttamt = new JTextField();//NumberFormat.getNumberInstance());
			//amount=Double.parseDouble(ttamt.getText());
			 System.out.print("4");
			
			ttamt.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			//ttamt.setText(amount.toString());//new Double(amount));
			ttamt.setColumns(10);
	      /*  ttamt.addPropertyChangeListener("value", (PropertyChangeListener) this);
			ttamt.addPropertyChangeListener(new PropertyChangeListener() {
				public void propertyChange(PropertyChangeEvent e) {
					//amount = ((Number)ttamt.getValue()).doubleValue();
					amount=Double.parseDouble((ttamt.getText()));
				}
			});*/
			ttamt.setBounds(236, 187, 128, 20);
			 getContentPane().add(ttamt);
			 System.out.print("3");
			tut = new JComboBox<String>();
			System.out.print("2");
			tut.setModel(new DefaultComboBoxModel(new String[] {"FALT", "ROW HOUSE"}));
			System.out.print("1");
			tut.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			tut.setEditable(true);
			tut.setBounds(236, 85, 128, 20);
			 getContentPane().add(tut);
			 System.out.print("2");
			
			tfrn = new JComboBox<String>();
			tfrn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			tfrn.setEditable(true);
			tfrn.setBounds(236, 110, 128, 20);
			 getContentPane().add(tfrn);
			
			toidold = new JComboBox<String>();
			toidold.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			toidold.setEditable(true);
			toidold.setBounds(236, 134, 128, 20);
			 getContentPane().add(toidold);
			
			toidnew = new JComboBox<String>();
			toidnew.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			toidnew.setEditable(true);
			toidnew.setBounds(236, 162, 128, 20);
			 getContentPane().add(toidnew);
			 
			 fillcombobox();
			 fillcombobox2();
			 fillcombobox3();
			JPanel panel = new JPanel();
			panel.setBounds(98, 248, 281, 77);
			 getContentPane().add(panel);

			

			//create text field
			txtDate = new JTextField();
			//set bounds of text field
			txtDate.setBounds(236,215,128,20);
			//add text field to contentPane
			getContentPane().add(txtDate);
			//set columns
			txtDate.setColumns(10);
			
			//create button and there object
			btnNewButton = new JButton("...");
			//perform action listener
			btnNewButton.addActionListener(new ActionListener() 
			{	
				//performed action
				public void actionPerformed(ActionEvent arg0) 
				{
					//create frame new object  f
					final JFrame f = new JFrame();
					//set text which is collected by date picker i.e. set date 
					txtDate.setText(new DatePicker(f).setPickedDate());
				}
			});
			//set button bound
			btnNewButton.setBounds(374,215,17,20);//+107
			//add button in contentPane
			getContentPane().add(btnNewButton);
			
			/*tdt = new JXDatePicker();
			tdt.getEditor().setFont(new Font("Times New Roman", Font.PLAIN, 14));
			tdt.setBounds(236,215,94,20);
			tdt.setDate(Calendar.getInstance().getTime());
	        //sregdt.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
	        //sregdt.setFormats("dd.mm.yyyy");
	         getContentPane().add(tdt);*/
		
		
		
		JButton tsave = new JButton("UPDATE");
		tsave.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\Save.png"));
		tsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con=DriverManager.getConnection("jdbc:odbc:mypro");
					
					Statement st=con.createStatement();
					String q1="select * from TRANSFER";
					ResultSet rs=st.executeQuery(q1);
					int cnt=0;
					while(rs.next())
						cnt++;
					cnt=cnt+1;
					
					String q2="INSERT INTO TRANSFER (UNIT_TYPE,FLAT_ROWHOUSE_NO,OWNER_ID,OWNER_ID_NEW,TRANSFER_AMOUNT,TRANSFER_DATE) VALUES('"+tut.getSelectedItem()+"','"+tfrn.getSelectedItem()+"','"+toidold.getSelectedItem()+"','"+toidnew.getSelectedItem()+"',"+Integer.parseInt(ttamt.getText())+",'"+tdt.getDate()+"')";

					int rs_int=st.executeUpdate(q2);
					if(rs_int>0){
					       message_dialog=""+tid.getText().toUpperCase()+"Record inserted";
					    int type_dialog = JOptionPane.PLAIN_MESSAGE;
					    JOptionPane.showMessageDialog((Component) null, message_dialog, add_dialog, type_dialog);}
					    else 
					    {message_dialog=""+tid.getText().toUpperCase()+"Record Not inserted";
					    int type_dialog = JOptionPane.PLAIN_MESSAGE;
					    JOptionPane.showMessageDialog((Component) null, message_dialog, not_dialog, type_dialog);}
					    	System.out.println("Record not inserted");
					    	
				tid.enableInputMethods(false);
				ttamt.enableInputMethods(false);
				tdt.enableInputMethods(false);
				tut.enableInputMethods(false);
				tfrn.enableInputMethods(false);
				toidold.enableInputMethods(false);
				toidnew.enableInputMethods(false);
				con.close();
				}
				catch(ClassNotFoundException ce) {System.out.println("Class not found exception.");}
				catch(SQLException sqle){System.out.println(sqle);}
				catch(Exception l){System.out.println("In catch "+l);}
			
			
			}
		});
		tsave.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(tsave);
		
		JButton tcancel = new JButton("Cancel");
		tcancel.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\cancel.png"));
		tcancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tid.setText(null);
				ttamt.setText(null);
			}
		});
		tcancel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(tcancel);
		
		JLabel label = new JLabel("in Rupees");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label.setBounds(379, 190, 86, 14);
		getContentPane().add(label);
		}
		catch(Exception e ){}
		
	}

}
