import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.*;
import java.text.NumberFormat;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;

import org.jdesktop.swingx.JXDatePicker;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.Color;


public class vendorcontract extends JInternalFrame {
	
	private JTextField vcid,txtDate,txt_Date,vccval;
	//private JFormattedTextField vccval;
	private JButton btnNewButton,NewButton;
	private JXDatePicker vcsd,vced;
	private JComboBox<String> vcvid;
	private JTextArea vcremark;
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
					vendorcontract frame = new vendorcontract();
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
		
		String query="select * from VENDOR";
		PreparedStatement pst=con.prepareStatement(query);
		ResultSet rs=pst.executeQuery();
		
		while(rs.next())
		{
			vcvid.addItem(rs.getString("VENDOR_ID"));
			//foid.addItem(rs.getString(CURRENT_STATUS));
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
	public vendorcontract() throws SQLException,NullPointerException{
		try{
		setTitle("Vendor Contract");
		//setMaximum(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 1407, 591);
		getContentPane().setLayout(null);
		

		//create text field
		txtDate = new JTextField();
		//set bounds of text field
		txtDate.setBounds(207,188,173,20);
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
		btnNewButton.setBounds(390,188,17,20);//+107
		//add button in contentPane
		getContentPane().add(btnNewButton);
		
		/*vcsd = new JXDatePicker();
		vcsd.getEditor().setFont(new Font("Times New Roman", Font.PLAIN, 14));
		vcsd.setBounds(207,188,94,20);
		vcsd.setDate(Calendar.getInstance().getTime());
        //vcsd.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
        //vcsd.setFormats("dd.mm.yyyy");
         getContentPane().add(vcsd);*/
        
		//create text field
		txt_Date = new JTextField();
		//set bounds of text field
		txt_Date.setBounds(207,233,173,20);
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
		NewButton.setBounds(390,233,17,20);//+107
		//add button in contentPane
		getContentPane().add(NewButton);
		
        /*vced = new JXDatePicker();
		vced.getEditor().setFont(new Font("Times New Roman", Font.PLAIN, 14));
		vced.setBounds(207,233,94,20);
		vced.setDate(Calendar.getInstance().getTime());
        //vced.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
        //vced.setFormats("dd.mm.yyyy");
         getContentPane().add(vced);*/
		
		JLabel lblVendorContract = new JLabel("VENDOR CONTRACT");
		lblVendorContract.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblVendorContract.setBounds(240, 11, 202, 31);
		 getContentPane().add(lblVendorContract);
		
		JLabel lblId = new JLabel("Id");
		lblId.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblId.setBounds(47, 64, 105, 24);
		 getContentPane().add(lblId);
		
		JLabel lblVendorId = new JLabel("Vendor Id");
		lblVendorId.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblVendorId.setBounds(47, 99, 105, 24);
		 getContentPane().add(lblVendorId);
		
		JLabel lblContractValue = new JLabel("Contract Value");
		lblContractValue.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblContractValue.setBounds(47, 142, 105, 24);
		 getContentPane().add(lblContractValue);
		
		JLabel lblStartDate = new JLabel("Start Date");
		lblStartDate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblStartDate.setBounds(47, 182, 105, 24);
		 getContentPane().add(lblStartDate);
		
		JLabel lblEndDate = new JLabel("End Date");
		lblEndDate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblEndDate.setBounds(47, 227, 105, 24);
		 getContentPane().add(lblEndDate);
		
		JLabel lblRemark = new JLabel("Remark");
		lblRemark.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblRemark.setBounds(47, 270, 105, 24);
		 getContentPane().add(lblRemark);
		
		vcid = new JTextField(5);
		vcid.setEditable(false);
		vcid.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar(); 
				String number=vcid.getText();
				Pattern pattern = Pattern.compile("\\d{5}");
				      Matcher matcher = pattern.matcher(number);
				      if (matcher.matches()) {
				    	  if((!(Character.isDigit(c))) && (c!='\b')) // Only digits ,backspace 
							{ 
							e.consume(); 
							}
				      }
				      else if((Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ))
				  {
			  	vcid.setText(null);
				      }
				
				
			}
		});
		vcid.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		vcid.setBounds(207, 67, 173, 20);
		 getContentPane().add(vcid);
		vcid.setColumns(10);
		
		vcvid = new JComboBox<String>();
		vcvid.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		vcvid.setBounds(207, 102, 173, 20);
		 getContentPane().add(vcvid);
		
		vcremark = new JTextArea();
		vcremark.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char keyChar = e.getKeyChar();
			    if (Character.isLowerCase(keyChar)) {
			      e.setKeyChar(Character.toUpperCase(keyChar));
			    }
			}
		});
		vcremark.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		vcremark.setBounds(207, 271, 179, 54);
		 getContentPane().add(vcremark);
		
		JPanel panel = new JPanel();
		panel.setBounds(141, 346, 313, 77);
		 getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\new.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vcid.enableInputMethods(true);
				vccval.enableInputMethods(true);
				vcsd.enableInputMethods(true);
				vced.enableInputMethods(true);
				vcvid.enableInputMethods(true);
				vcremark.enableInputMethods(true);
				
				
				vcid.setText(null);
				vccval.setText(null);
				//vcsd.setText(null);
				//vced.setText(null);
				//vcvid.setText(null);
				vcremark.setText(null);
			
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(btnNewButton);
		
		JButton btnSave = new JButton("Save");
		btnSave.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\Save.png"));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con=DriverManager.getConnection("jdbc:odbc:mypro");
					
					Statement st=con.createStatement();
					String q1="select * from VENDOR_CONTRACT";
					ResultSet rs=st.executeQuery(q1);
					int cnt=0;
					while(rs.next())
						cnt++;
					cnt=cnt+1;
					
					String q2="INSERT INTO VENDOR_CONTRACT (VENDOR_ID,CONTRACT_VALUE,START_DATE,END_DATE,REMARK) VALUES("+vcvid.getSelectedItem()+","+Integer.parseInt(vccval.getText())+",'"+txtDate.getText()+"','"+txt_Date.getText()+"','"+vcremark.getText()+"')";
					
					int rs_int=st.executeUpdate(q2);
					
				    if(rs_int>0){
				       message_dialog=""+vcid.getText().toUpperCase()+"Record inserted";
				    int type_dialog = JOptionPane.PLAIN_MESSAGE;
				    JOptionPane.showMessageDialog((Component) null, message_dialog, add_dialog, type_dialog);}
				    else 
				    {message_dialog=""+vcid.getText().toUpperCase()+"Record Not inserted";
				    int type_dialog = JOptionPane.PLAIN_MESSAGE;
				    JOptionPane.showMessageDialog((Component) null, message_dialog, not_dialog, type_dialog);}
				    	System.out.println("Record not inserted");
				
				    	vcid.enableInputMethods(false);
						vccval.enableInputMethods(false);
						vcsd.enableInputMethods(false);
						vced.enableInputMethods(false);
						vcvid.enableInputMethods(false);
						vcremark.enableInputMethods(false);
					
						con.close();
				}
				catch(ClassNotFoundException ce) {System.out.println("Class not found exception.");}
				catch(SQLException sqle){System.out.println(sqle);}
				catch(Exception l){System.out.println("In catch "+l);}
			
			}
		});
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\cancel.png"));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vcid.setText(null);
				vccval.setText(null);
				//vcsd.setText(null);
				//vced.setText(null);
				//vcvid.setText(null);
				vcremark.setText(null);
			
			}
		});
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(btnCancel);
		
		JLabel lblInRupees = new JLabel("in Rupees");
		lblInRupees.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblInRupees.setBounds(390, 148, 86, 14);
		getContentPane().add(lblInRupees);
		
		//amount=Double.parseDouble(vccval.getText());
		vccval = new JTextField();
		//vccval.setText((amount.toString()));
		vccval.setColumns(10);
        /*vccval.addPropertyChangeListener("value", (PropertyChangeListener) this);
		vccval.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				amount = ((Number)vccval.getValue()).doubleValue();
			}
		});*/
		vccval.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		vccval.setBounds(207, 145, 173, 20);
		getContentPane().add(vccval);
		
		try{
			
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:mypro");
			Statement stmt = con.createStatement();
			ResultSet rs=null;
			
			String q1="select * from VENDOR_CONTRACT";
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
	
	public vendorcontract(int value) throws SQLException,NullPointerException{
		try{
		
		getContentPane().setBackground(new Color(204, 204, 255));
		setTitle("Vendor Contract");
		//setMaximum(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 618, 443);
		getContentPane().setLayout(null);
		

		//create text field
		txtDate = new JTextField();
		//set bounds of text field
		txtDate.setBounds(207,188,173,20);
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
		btnNewButton.setBounds(390,188,17,20);//+107
		//add button in contentPane
		getContentPane().add(btnNewButton);
		
		/*vcsd = new JXDatePicker();
		vcsd.getEditor().setFont(new Font("Times New Roman", Font.PLAIN, 14));
		vcsd.setBounds(207,188,94,20);
		vcsd.setDate(Calendar.getInstance().getTime());
        //vcsd.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
        //vcsd.setFormats("dd.mm.yyyy");
         getContentPane().add(vcsd);*/
        
		//create text field
		txt_Date = new JTextField();
		//set bounds of text field
		txt_Date.setBounds(207,233,173,20);
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
		NewButton.setBounds(390,233,17,20);//+107
		//add button in contentPane
		getContentPane().add(NewButton);
		
        /*vced = new JXDatePicker();
		vced.getEditor().setFont(new Font("Times New Roman", Font.PLAIN, 14));
		vced.setBounds(207,233,94,20);
		vced.setDate(Calendar.getInstance().getTime());
        //vced.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
        //vced.setFormats("dd.mm.yyyy");
         getContentPane().add(vced);*/
		
		JLabel lblVendorContract = new JLabel("VENDOR CONTRACT");
		lblVendorContract.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblVendorContract.setBounds(240, 11, 202, 31);
		 getContentPane().add(lblVendorContract);
		
		JLabel lblId = new JLabel("Id");
		lblId.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblId.setBounds(47, 64, 105, 24);
		 getContentPane().add(lblId);
		
		JLabel lblVendorId = new JLabel("Vendor Id");
		lblVendorId.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblVendorId.setBounds(47, 99, 105, 24);
		 getContentPane().add(lblVendorId);
		
		JLabel lblContractValue = new JLabel("Contract Value");
		lblContractValue.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblContractValue.setBounds(47, 142, 105, 24);
		 getContentPane().add(lblContractValue);
		
		JLabel lblStartDate = new JLabel("Start Date");
		lblStartDate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblStartDate.setBounds(47, 182, 105, 24);
		 getContentPane().add(lblStartDate);
		
		JLabel lblEndDate = new JLabel("End Date");
		lblEndDate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblEndDate.setBounds(47, 227, 105, 24);
		 getContentPane().add(lblEndDate);
		
		JLabel lblRemark = new JLabel("Remark");
		lblRemark.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblRemark.setBounds(47, 270, 105, 24);
		 getContentPane().add(lblRemark);
		
		vcid = new JTextField(5);
		vcid.setEditable(false);
		vcid.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar(); 
				String number=vcid.getText();
				Pattern pattern = Pattern.compile("\\d{5}");
				      Matcher matcher = pattern.matcher(number);
				      if (matcher.matches()) {
				    	  if((!(Character.isDigit(c))) && (c!='\b')) // Only digits ,backspace 
							{ 
							e.consume(); 
							}
				      }
				      else if((Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ))
				  {
			  	vcid.setText(null);
				      }
				
				
			}
		});
		vcid.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		vcid.setBounds(207, 67, 173, 20);
		 getContentPane().add(vcid);
		vcid.setColumns(10);
		
		vcvid = new JComboBox<String>();
		vcvid.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		vcvid.setBounds(207, 102, 173, 20);
		 getContentPane().add(vcvid);
		
		vcremark = new JTextArea();
		vcremark.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char keyChar = e.getKeyChar();
			    if (Character.isLowerCase(keyChar)) {
			      e.setKeyChar(Character.toUpperCase(keyChar));
			    }
			}
		});
		vcremark.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		vcremark.setBounds(207, 271, 179, 54);
		 getContentPane().add(vcremark);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(141, 346, 313, 77);
		 getContentPane().add(panel);
		
		
		JButton btnSave = new JButton("Update");
		btnSave.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\Save.png"));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con=DriverManager.getConnection("jdbc:odbc:mypro");
					
					Statement st=con.createStatement();
					String q1="select * from VENDOR_CONTRACT";
					ResultSet rs=st.executeQuery(q1);
					int cnt=0;
					while(rs.next())
						cnt++;
					cnt=cnt+1;
					
					String q2="INSERT INTO VENDOR_CONTRACT (VENDOR_ID,CONTRACT_VALUE,START_DATE,END_DATE,REMARK) VALUES("+vcvid.getSelectedItem()+","+Integer.parseInt(vccval.getText())+",'"+txtDate.getText()+"','"+txt_Date.getText()+"','"+vcremark.getText()+"')";
					
					int rs_int=st.executeUpdate(q2);
					
				    if(rs_int>0){
				       message_dialog=""+vcid.getText().toUpperCase()+"Record inserted";
				    int type_dialog = JOptionPane.PLAIN_MESSAGE;
				    JOptionPane.showMessageDialog((Component) null, message_dialog, add_dialog, type_dialog);}
				    else 
				    {message_dialog=""+vcid.getText().toUpperCase()+"Record Not inserted";
				    int type_dialog = JOptionPane.PLAIN_MESSAGE;
				    JOptionPane.showMessageDialog((Component) null, message_dialog, not_dialog, type_dialog);}
				    	System.out.println("Record not inserted");
				
				    	vcid.enableInputMethods(false);
						vccval.enableInputMethods(false);
						vcsd.enableInputMethods(false);
						vced.enableInputMethods(false);
						vcvid.enableInputMethods(false);
						vcremark.enableInputMethods(false);
					
						con.close();
				}
				catch(ClassNotFoundException ce) {System.out.println("Class not found exception.");}
				catch(SQLException sqle){System.out.println(sqle);}
				catch(Exception l){System.out.println("In catch "+l);}
			
			}
		});
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\cancel.png"));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vcid.setText(null);
				vccval.setText(null);
				//vcsd.setText(null);
				//vced.setText(null);
				//vcvid.setText(null);
				vcremark.setText(null);
			
			}
		});
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(btnCancel);
		
		JLabel lblInRupees = new JLabel("in Rupees");
		lblInRupees.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblInRupees.setBounds(390, 148, 86, 14);
		getContentPane().add(lblInRupees);
		
		//amount=Double.parseDouble(vccval.getText());
		vccval = new JTextField();
		//vccval.setText((amount.toString()));
		vccval.setColumns(10);
        /*vccval.addPropertyChangeListener("value", (PropertyChangeListener) this);
		vccval.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				amount = ((Number)vccval.getValue()).doubleValue();
			}
		});*/
		vccval.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		vccval.setBounds(207, 145, 173, 20);
		getContentPane().add(vccval);

		}
		catch(Exception e ){}
		
	}
	
}
