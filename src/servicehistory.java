import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JLabel;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;

import org.jdesktop.swingx.JXDatePicker;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


public class servicehistory extends JInternalFrame {

	private JTextField shid,txtDate,txt_Date;
	private JButton btnNewButton,NewButton;
	private JXDatePicker shsd,shnsd;
	private JComboBox<String> shsid,shvid; 
	String message_dialog;
	String add_dialog = "Database Record Added";
	String not_dialog = "Database Record Not Added";
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
					servicehistory frame = new servicehistory();
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
		
		String query="select * from SERVICE";
		PreparedStatement pst=con.prepareStatement(query);
		ResultSet rs=pst.executeQuery();
		
		while(rs.next())
		{
			shsid.addItem(rs.getString("SERVICE_ID"));
			
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
	public void fillcombobox1()
	{
		
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con = DriverManager.getConnection("jdbc:odbc:mypro");
		
		String query2="select * from VENDOR";
		PreparedStatement pst2=con.prepareStatement(query2);
		ResultSet rs2=pst2.executeQuery();
		
		while(rs2.next())
		{
			shvid.addItem(rs2.getString("VENDOR_ID"));
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
	 * Create the  
	 */
	public servicehistory() throws SQLException,NullPointerException {
		try{
		setTitle("Service History");
		//setMaximum(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 1428, 741);
		getContentPane().setLayout(null);
		
		//create text field
				txtDate = new JTextField();
				//set bounds of text field
				txtDate.setBounds(194,129,94,20);
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
				btnNewButton.setBounds(289,129,17,20);//+107
				//add button in contentPane
				getContentPane().add(btnNewButton);
				
				/*shsd = new JXDatePicker();
		shsd.getEditor().setFont(new Font("Times New Roman", Font.PLAIN, 14));
		shsd.setBounds(194,129,94,20);
		shsd.setDate(Calendar.getInstance().getTime());
        //shnsd.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
        //shsd.setFormats("dd.mm.yyyy");
         getContentPane().add(shsd);*/
		        
				//create text field
				txt_Date = new JTextField();
				//set bounds of text field
				txt_Date.setBounds(194,157,94,20);
				//add text field to contentPane
				getContentPane().add(txt_Date);
				//set columns
				txt_Date.setColumns(10);
				
				//create button and there object
				NewButton = new JButton("...");
				//perform action listener
				NewButton.addActionListener(new ActionListener() 
				{	
					//performed action
					public void actionPerformed(ActionEvent arg0) 
					{
						//create frame new object  
						final JFrame f = new JFrame();
						//set text which is collected by date picker i.e. set date 
						txt_Date.setText(new DatePicker(f).setPickedDate());
					}
				});
				//set button bound
				NewButton.setBounds(289,157,17,20);//+107
				//add button in contentPane
				getContentPane().add(NewButton);
		
		/*shnsd = new JXDatePicker();
		shnsd.getEditor().setFont(new Font("Times New Roman", Font.PLAIN, 14));
		shnsd.setBounds(194,157,94,20);
		shnsd.setDate(Calendar.getInstance().getTime());
        //shnsd.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
        //shnsd.setFormats("dd.mm.yyyy");
         getContentPane().add(shnsd);*/
		
		JLabel lblServiceHistory = new JLabel("Service History");
		lblServiceHistory.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblServiceHistory.setBounds(194, 11, 148, 24);
		 getContentPane().add(lblServiceHistory);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(53, 54, 46, 14);
		 getContentPane().add(lblNewLabel);
		
		JLabel lblServiceId = new JLabel("Service ID");
		lblServiceId.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblServiceId.setBounds(53, 79, 75, 14);
		 getContentPane().add(lblServiceId);
		
		JLabel lblVendorId = new JLabel("Vendor ID");
		lblVendorId.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblVendorId.setBounds(53, 104, 75, 14);
		 getContentPane().add(lblVendorId);
		
		JLabel lblServiceDate = new JLabel("Service Date");
		lblServiceDate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblServiceDate.setBounds(53, 128, 90, 14);
		 getContentPane().add(lblServiceDate);
		
		JLabel lblNextServiceDate = new JLabel("Next Service Date");
		lblNextServiceDate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNextServiceDate.setBounds(53, 155, 119, 14);
		 getContentPane().add(lblNextServiceDate);
		
		shid = new JTextField();
		shid.setEditable(false);
		shid.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar(); 
				if((!(Character.isDigit(c))) && (c!='\b')) // Only digits ,backspace 
				{ 
				e.consume(); 
				} 
			}
		});
		shid.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		shid.setBounds(194, 51, 86, 20);
		shid.setColumns(10);
		getContentPane().add(shid);
		
		shsid = new JComboBox<String>();
		shsid.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		shsid.setBounds(194, 77, 86, 20);
		 getContentPane().add(shsid);
		
		shvid = new JComboBox<String>();
		shvid.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		shvid.setBounds(194, 102, 86, 20);
		 getContentPane().add(shvid);
		
		fillcombobox();
		fillcombobox1();
		
		JPanel panel = new JPanel();
		panel.setBounds(91, 200, 251, 85);
		 getContentPane().add(panel);
		
		JButton shadd = new JButton("Add");
		shadd.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\new.png"));
		shadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shid.enableInputMethods(true);
				shsd.enableInputMethods(true);
				shnsd.enableInputMethods(true);
				shsid.enableInputMethods(true);
				shvid.enableInputMethods(true);
				shid.setText(null);
				/*shsd
				shnsd
				shsid
				shvid*/
			}
		});
		shadd.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(shadd);
		
		JButton shsave = new JButton("Save");
		shsave.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\Save.png"));
		shsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con=DriverManager.getConnection("jdbc:odbc:mypro");
					
					Statement st=con.createStatement();
					String q1="select * from SERVICE_HISTORY";
					ResultSet rs=st.executeQuery(q1);
					int cnt=0;
					while(rs.next())
						cnt++;
					cnt=cnt+1;
					
					String q2="INSERT INTO SERVICE_HISTORY (SERVICE_ID,VENDOR_ID,SERVICE_DATE,NEXT_DATE_FOR_SERVICE) VALUES('"+shsid.getSelectedItem()+"','"+shvid.getSelectedItem()+"','"+shsd.getDate()+"','"+shnsd.getDate()+"')";

					int rs_int=st.executeUpdate(q2);
					
				    if(rs_int>0){
				       message_dialog=""+shid.getText().toUpperCase()+"Record inserted";
				    int type_dialog = JOptionPane.PLAIN_MESSAGE;
				    JOptionPane.showMessageDialog((Component) null, message_dialog, add_dialog, type_dialog);}
				    else 
				    {message_dialog=""+shid.getText().toUpperCase()+"Record Not inserted";
				    int type_dialog = JOptionPane.PLAIN_MESSAGE;
				    JOptionPane.showMessageDialog((Component) null, message_dialog, not_dialog, type_dialog);}
				    	System.out.println("Record not inserted");
				
				    	shid.enableInputMethods(false);
						shsd.enableInputMethods(false);
						shnsd.enableInputMethods(false);
						shsid.enableInputMethods(false);
						shvid.enableInputMethods(false);
				
				}
				catch(ClassNotFoundException ce) {System.out.println("Class not found exception.");}
				catch(SQLException sqle){System.out.println(sqle);}
				catch(Exception l){System.out.println("In catch "+l);}
			
			}
		});
		shsave.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(shsave);
		
		JButton shcancel = new JButton("Cancel");
		shcancel.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\cancel.png"));
		shcancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shid.setText(null);
				/*shsd
				shnsd
				shsid
				shvid*/
			}
		});
		shcancel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(shcancel);
		
		

		 try{
				
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:mypro");
				Statement stmt = con.createStatement();
				ResultSet rs=null;
				
				String q1="select * from SERVICE_HISTORY";
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
			//columnModel.getColumn(5).setPreferredWidth(50);
			//columnModel.getColumn(6).setPreferredWidth(50);
			
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

	
	public servicehistory(int value) throws SQLException,NullPointerException {
		try{
		
		getContentPane().setBackground(new Color(204, 204, 255));
		setTitle("Service History");
		//setMaximum(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 480, 341);
		getContentPane().setLayout(null);
		
		//create text field
				txtDate = new JTextField();
				//set bounds of text field
				txtDate.setBounds(194,129,94,20);
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
				btnNewButton.setBounds(289,129,17,20);//+107
				//add button in contentPane
				getContentPane().add(btnNewButton);
				
				/*shsd = new JXDatePicker();
		shsd.getEditor().setFont(new Font("Times New Roman", Font.PLAIN, 14));
		shsd.setBounds(194,129,94,20);
		shsd.setDate(Calendar.getInstance().getTime());
        //shnsd.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
        //shsd.setFormats("dd.mm.yyyy");
         getContentPane().add(shsd);*/
		        
				//create text field
				txt_Date = new JTextField();
				//set bounds of text field
				txt_Date.setBounds(194,157,94,20);
				//add text field to contentPane
				getContentPane().add(txt_Date);
				//set columns
				txt_Date.setColumns(10);
				
				//create button and there object
				NewButton = new JButton("...");
				//perform action listener
				NewButton.addActionListener(new ActionListener() 
				{	
					//performed action
					public void actionPerformed(ActionEvent arg0) 
					{
						//create frame new object  
						final JFrame f = new JFrame();
						//set text which is collected by date picker i.e. set date 
						txt_Date.setText(new DatePicker(f).setPickedDate());
					}
				});
				//set button bound
				NewButton.setBounds(289,157,17,20);//+107
				//add button in contentPane
				getContentPane().add(NewButton);
		
		/*shnsd = new JXDatePicker();
		shnsd.getEditor().setFont(new Font("Times New Roman", Font.PLAIN, 14));
		shnsd.setBounds(194,157,94,20);
		shnsd.setDate(Calendar.getInstance().getTime());
        //shnsd.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
        //shnsd.setFormats("dd.mm.yyyy");
         getContentPane().add(shnsd);*/
		
		JLabel lblServiceHistory = new JLabel("Service History");
		lblServiceHistory.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblServiceHistory.setBounds(194, 11, 148, 24);
		 getContentPane().add(lblServiceHistory);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(53, 54, 46, 14);
		 getContentPane().add(lblNewLabel);
		
		JLabel lblServiceId = new JLabel("Service ID");
		lblServiceId.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblServiceId.setBounds(53, 79, 75, 14);
		 getContentPane().add(lblServiceId);
		
		JLabel lblVendorId = new JLabel("Vendor ID");
		lblVendorId.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblVendorId.setBounds(53, 104, 75, 14);
		 getContentPane().add(lblVendorId);
		
		JLabel lblServiceDate = new JLabel("Service Date");
		lblServiceDate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblServiceDate.setBounds(53, 128, 90, 14);
		 getContentPane().add(lblServiceDate);
		
		JLabel lblNextServiceDate = new JLabel("Next Service Date");
		lblNextServiceDate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNextServiceDate.setBounds(53, 155, 119, 14);
		 getContentPane().add(lblNextServiceDate);
		
		shid = new JTextField();
		shid.setEditable(false);
		shid.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar(); 
				if((!(Character.isDigit(c))) && (c!='\b')) // Only digits ,backspace 
				{ 
				e.consume(); 
				} 
			}
		});
		shid.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		shid.setBounds(194, 51, 86, 20);
		 getContentPane().add(shid);
		shid.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(91, 200, 251, 85);
		 getContentPane().add(panel);
		
		 shsid = new JComboBox<String>();
			shsid.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			shsid.setBounds(194, 77, 86, 20);
			 getContentPane().add(shsid);
			
			shvid = new JComboBox<String>();
			shvid.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			shvid.setBounds(194, 102, 86, 20);
			 getContentPane().add(shvid);
		 
			fillcombobox();
			fillcombobox1();
		
		JButton shsave = new JButton("Update");
		shsave.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\Save.png"));
		shsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con=DriverManager.getConnection("jdbc:odbc:mypro");
					
					Statement st=con.createStatement();
					String q1="select * from SERVICE_HISTORY";
					ResultSet rs=st.executeQuery(q1);
					int cnt=0;
					while(rs.next())
						cnt++;
					cnt=cnt+1;
					
					String q2="INSERT INTO SERVICE_HISTORY (SERVICE_ID,VENDOR_ID,SERVICE_DATE,NEXT_DATE_FOR_SERVICE) VALUES('"+shsid.getSelectedItem()+"','"+shvid.getSelectedItem()+"','"+shsd.getDate()+"','"+shnsd.getDate()+"')";

					int rs_int=st.executeUpdate(q2);
					
				    if(rs_int>0){
				       message_dialog=""+shid.getText().toUpperCase()+"Record inserted";
				    int type_dialog = JOptionPane.PLAIN_MESSAGE;
				    JOptionPane.showMessageDialog((Component) null, message_dialog, add_dialog, type_dialog);}
				    else 
				    {message_dialog=""+shid.getText().toUpperCase()+"Record Not inserted";
				    int type_dialog = JOptionPane.PLAIN_MESSAGE;
				    JOptionPane.showMessageDialog((Component) null, message_dialog, not_dialog, type_dialog);}
				    	System.out.println("Record not inserted");
				
				    	shid.enableInputMethods(false);
						shsd.enableInputMethods(false);
						shnsd.enableInputMethods(false);
						shsid.enableInputMethods(false);
						shvid.enableInputMethods(false);
				
				}
				catch(ClassNotFoundException ce) {System.out.println("Class not found exception.");}
				catch(SQLException sqle){System.out.println(sqle);}
				catch(Exception l){System.out.println("In catch "+l);}
			
			}
		});
		shsave.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(shsave);
		
		JButton shcancel = new JButton("Cancel");
		shcancel.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\cancel.png"));
		shcancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shid.setText(null);
				/*shsd
				shnsd
				shsid
				shvid*/
			}
		});
		shcancel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(shcancel);
		
		

		}
		catch(Exception e ){}
	}
	
}
