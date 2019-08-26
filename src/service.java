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
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;

import org.jdesktop.swingx.JXDatePicker;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.text.PlainDocument;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.Color;

import javax.swing.ImageIcon;


public class service extends JInternalFrame {
	
	private JTextField seid,sename,senum,sepurf,txtDate,txt_Date,txtdate,sevalue;
	//private JFormattedTextField sevalue;
	private JButton btnNewButton,NewButton,btnNew;
	private JXDatePicker sdos,swsd,swed;
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
					service frame = new service();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public service() throws SQLException,NullPointerException{
try{
		setTitle("Service");
		//setMaximum(true);
		setMaximizable(true);
		setClosable(true);
		setResizable(true);
		setBounds(100, 100, 549, 418);
		getContentPane().setLayout(null);
		
		//create text field
				txtDate = new JTextField();
				//set bounds of text field
				txtDate.setBounds(202,99,182,20);
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
				btnNewButton.setBounds(387,99,17,20);//+107
				//add button in contentPane
				getContentPane().add(btnNewButton);
				
				/*sdos = new JXDatePicker();
		sdos.getEditor().setFont(new Font("Times New Roman", Font.PLAIN, 14));
		sdos.setBounds(202,99,94,20);
		sdos.setDate(Calendar.getInstance().getTime());
        //sdos.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
        //sdos.setFormats("dd.mm.yyyy");
         getContentPane().add(sdos);*/
		        
				//create text field
				txt_Date = new JTextField();
				//set bounds of text field
				txt_Date.setBounds(202,120,182,20);
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
						//create frame new object  f
						final JFrame f = new JFrame();
						//set text which is collected by date picker i.e. set date 
						txt_Date.setText(new DatePicker(f).setPickedDate());
					}
				});
				//set button bound
				NewButton.setBounds(387,120,17,20);//+107
				//add button in contentPane
				getContentPane().add(NewButton);
        
        /*swsd = new JXDatePicker();
		swsd.getEditor().setFont(new Font("Times New Roman", Font.PLAIN, 14));
		swsd.setBounds(202,120,94,20);
		swsd.setDate(Calendar.getInstance().getTime());
        //swsd.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
        //swsd.setFormats("dd.mm.yyyy");
         getContentPane().add(swsd);*/
		
				//create text field
				txtdate = new JTextField();
				//set bounds of text field
				txtdate.setBounds(202,145,182,20);
				//add text field to contentPane
				getContentPane().add(txtdate);
				//set columns
				txtdate.setColumns(10);
				
				//create button and there object
				btnNew = new JButton("...");
				//perform action listener
				btnNew.addActionListener(new ActionListener() 
				{	
					//performed action
					public void actionPerformed(ActionEvent arg0) 
					{
						//create frame new object  f
						final JFrame f = new JFrame();
						//set text which is collected by date picker i.e. set date 
						txtdate.setText(new DatePicker(f).setPickedDate());
					}
				});
				//set button bound
				btnNew.setBounds(387,145,17,20);//+107
				//add button in contentPane
				getContentPane().add(btnNew);
				
        /*swed = new JXDatePicker();
		swed.getEditor().setFont(new Font("Times New Roman", Font.PLAIN, 14));
		swed.setBounds(202,145,94,20);
		swed.setDate(Calendar.getInstance().getTime());
        //swed.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
        //swed.setFormats("dd.mm.yyyy");
         getContentPane().add(swed);*/
        
		JLabel lblService = new JLabel("SERVICE");
		lblService.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblService.setBounds(174, 11, 86, 14);
		 getContentPane().add(lblService);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblId.setBounds(34, 50, 46, 14);
		 getContentPane().add(lblId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblName.setBounds(34, 73, 46, 14);
		 getContentPane().add(lblName);
		
		JLabel lblDateOfPurchase = new JLabel("Date of Purchase");
		lblDateOfPurchase.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDateOfPurchase.setBounds(34, 98, 116, 14);
		 getContentPane().add(lblDateOfPurchase);
		
		JLabel lblWarrantyStartDate = new JLabel("Warranty Start Date");
		lblWarrantyStartDate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblWarrantyStartDate.setBounds(34, 123, 135, 14);
		 getContentPane().add(lblWarrantyStartDate);
		
		JLabel lblWarrantyEndDate = new JLabel("Warranty End Date");
		lblWarrantyEndDate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblWarrantyEndDate.setBounds(34, 148, 135, 14);
		 getContentPane().add(lblWarrantyEndDate);
		
		JLabel lblPurchasedFrom = new JLabel("Purchased From");
		lblPurchasedFrom.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPurchasedFrom.setBounds(34, 174, 116, 14);
		 getContentPane().add(lblPurchasedFrom);
		
		JLabel lblServiceValue = new JLabel("Service Value");
		lblServiceValue.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblServiceValue.setBounds(34, 199, 116, 14);
		 getContentPane().add(lblServiceValue);
		
		JLabel lblSerialNumber = new JLabel("Serial Number");
		lblSerialNumber.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblSerialNumber.setBounds(34, 222, 116, 14);
		 getContentPane().add(lblSerialNumber);
		System.out.println("1");
		seid = new JTextField();
		seid.setEditable(false);
		seid.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		seid.setBounds(202, 48, 86, 20);
		 getContentPane().add(seid);
		seid.setColumns(10);
		System.out.println("2");
		sename = new JTextField();
		/*
		sename.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
			
				char keyChar = e.getKeyChar();
			    if (Character.isLowerCase(keyChar)) {
			      e.setKeyChar(Character.toUpperCase(keyChar));
			    }
				char c=e.getKeyChar();
				if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ))
				        e.consume();
			}
		});*/
		sename.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		sename.setColumns(10);
		sename.setBounds(202, 71, 182, 20);
		 getContentPane().add(sename);
			System.out.println("3");
		// amount=Double.parseDouble(sevalue.getText());
			sevalue = new JTextField();
			sevalue.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			//sevalue.setText((amount.toString()));
			sevalue.setColumns(10);
			/*sevalue.addPropertyChangeListener("value", (PropertyChangeListener) this);
			sevalue.addPropertyChangeListener(new PropertyChangeListener() {
				public void propertyChange(PropertyChangeEvent e) {
					amount = ((Number)sevalue.getValue()).doubleValue();
				}
			});*/
		sevalue.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		sevalue.setColumns(10);
		sevalue.setBounds(202, 197, 182, 20);
		 getContentPane().add(sevalue);
			System.out.println("4");
		senum = new JTextField(20);
		/*PlainDocument doc = (PlainDocument) senum.getDocument();
	      doc.setDocumentFilter(new TextLengthDocFilter(16));
		senum.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				  if((Character.isAlphabetic(c) ||  (c==KeyEvent.VK_SPACE)))
			      {
			    	  senum.setText("0");
			      }
			}
		});*/
		senum.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		senum.setColumns(10);
		senum.setBounds(202, 220, 182, 20);
		 getContentPane().add(senum);
		
		sepurf = new JTextField(12);
		/*sepurf.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char keyChar = e.getKeyChar();
			    if (Character.isLowerCase(keyChar)) {
			      e.setKeyChar(Character.toUpperCase(keyChar));
			    }
				char c=e.getKeyChar();
				if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ))
				        e.consume();
			}
		});*/
		sepurf.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		sepurf.setColumns(10);
		sepurf.setBounds(202, 171, 182, 20);
		 getContentPane().add(sepurf);
		
		JPanel panel = new JPanel();
		panel.setBounds(83, 257, 301, 56);
		 getContentPane().add(panel);
		
		JButton sadd = new JButton("Add");
		sadd.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\new.png"));
		sadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seid.enableInputMethods(true);
				sename.enableInputMethods(true);
				sevalue.enableInputMethods(true);
				senum.enableInputMethods(true);
				sepurf.enableInputMethods(true);
				sdos.enableInputMethods(true);
				swsd.enableInputMethods(true);
				swed.enableInputMethods(true);
				
				seid.setText(null);
				sename.setText(null);
				sevalue.setText(null);
				senum.setText(null);
				sepurf.setText(null);
				
			}
		});
		sadd.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(sadd);
		
		JButton sesave = new JButton("Save");
		sesave.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\Save.png"));
		sesave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con=DriverManager.getConnection("jdbc:odbc:mypro");
					
					Statement st=con.createStatement();
					String q1="select * from SERVICE";
					ResultSet rs=st.executeQuery(q1);
					int cnt=0;
					while(rs.next())
						cnt++;
					cnt=cnt+1;
					
					String q2="INSERT INTO SERVICE (SERVICE_NAME,DATE_OF_PURCHACE,WARRANTY_START_DATE,WARRANTY_STOP_DATE,PURCHACED_FROM,SERVICE_VALUE,SERIAL_NO) VALUES('"+sename.getText()+"','"+sdos.getDate()+"','"+swsd.getDate()+"','"+swed.getDate()+"','"+sepurf.getText()+"','"+Integer.parseInt(sevalue.getText())+"','"+senum.getText()+"')";
					//,REGISTRATION_DATE  ,'"+(Date)sregdt.getDate()+"'
					int rs_int=st.executeUpdate(q2);
					
				    if(rs_int>0){
				       message_dialog=""+sename.getText().toUpperCase()+"Record inserted";
				    int type_dialog = JOptionPane.PLAIN_MESSAGE;
				    JOptionPane.showMessageDialog((Component) null, message_dialog, add_dialog, type_dialog);}
				    else 
				    {message_dialog=""+sename.getText().toUpperCase()+"Record Not inserted";
				    int type_dialog = JOptionPane.PLAIN_MESSAGE;
				    JOptionPane.showMessageDialog((Component) null, message_dialog, not_dialog, type_dialog);}
				    	System.out.println("Record not inserted");
				
				    	seid.enableInputMethods(false);
						sename.enableInputMethods(false);
						sevalue.enableInputMethods(false);
						senum.enableInputMethods(false);
						sepurf.enableInputMethods(false);
						sdos.enableInputMethods(false);
						swsd.enableInputMethods(false);
						swed.enableInputMethods(false);
				
				}
				catch(ClassNotFoundException ce) {System.out.println("Class not found exception.");}
				catch(SQLException sqle){System.out.println(sqle);}
				catch(Exception l){System.out.println("In catch "+l);}
			
			}
		});
		sesave.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(sesave);
		
		JButton secancel = new JButton("Cancel");
		secancel.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\cancel.png"));
		secancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				seid.setText(null);
				sename.setText(null);
				sevalue.setText(null);
				senum.setText(null);
				sepurf.setText(null);
			}
		});
		secancel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(secancel);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(202, 124, 46, 14);
		 getContentPane().add(lblNewLabel);
		 
		 JLabel lblDigits = new JLabel("16 digits");
		 lblDigits.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		 lblDigits.setBounds(394, 223, 46, 14);
		 getContentPane().add(lblDigits);
		 
		 JLabel lblInRupees = new JLabel("in Rupees");
		 lblInRupees.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		 lblInRupees.setBounds(394, 200, 70, 14);
		 getContentPane().add(lblInRupees);
		 
		 try{
				
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:mypro");
				Statement stmt = con.createStatement();
				ResultSet rs=null;
				
				String q1="select * from SERVICE";
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
catch(Exception e ){e.printStackTrace();}
	}

	
	public service(int value) throws SQLException,NullPointerException{
try{
		
		getContentPane().setBackground(new Color(204, 204, 255));
		setTitle("Service");
		//setMaximum(true);
		setMaximizable(true);
		setClosable(true);
		setResizable(true);
		setBounds(100, 100, 549, 418);
		getContentPane().setLayout(null);
		
		//create text field
				txtDate = new JTextField();
				//set bounds of text field
				txtDate.setBounds(202,99,182,20);
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
				btnNewButton.setBounds(387,99,17,20);//+107
				//add button in contentPane
				getContentPane().add(btnNewButton);
				
				/*sdos = new JXDatePicker();
		sdos.getEditor().setFont(new Font("Times New Roman", Font.PLAIN, 14));
		sdos.setBounds(202,99,94,20);
		sdos.setDate(Calendar.getInstance().getTime());
        //sdos.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
        //sdos.setFormats("dd.mm.yyyy");
         getContentPane().add(sdos);*/
		        
				//create text field
				txt_Date = new JTextField();
				//set bounds of text field
				txt_Date.setBounds(202,120,182,20);
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
						//create frame new object  f
						final JFrame f = new JFrame();
						//set text which is collected by date picker i.e. set date 
						txt_Date.setText(new DatePicker(f).setPickedDate());
					}
				});
				//set button bound
				NewButton.setBounds(387,120,17,20);//+107
				//add button in contentPane
				getContentPane().add(NewButton);
        
        /*swsd = new JXDatePicker();
		swsd.getEditor().setFont(new Font("Times New Roman", Font.PLAIN, 14));
		swsd.setBounds(202,120,94,20);
		swsd.setDate(Calendar.getInstance().getTime());
        //swsd.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
        //swsd.setFormats("dd.mm.yyyy");
         getContentPane().add(swsd);*/
		
				//create text field
				txtdate = new JTextField();
				//set bounds of text field
				txtdate.setBounds(202,145,182,20);
				//add text field to contentPane
				getContentPane().add(txtdate);
				//set columns
				txtdate.setColumns(10);
				
				//create button and there object
				btnNew = new JButton("...");
				//perform action listener
				btnNew.addActionListener(new ActionListener() 
				{	
					//performed action
					public void actionPerformed(ActionEvent arg0) 
					{
						//create frame new object  f
						final JFrame f = new JFrame();
						//set text which is collected by date picker i.e. set date 
						txtdate.setText(new DatePicker(f).setPickedDate());
					}
				});
				//set button bound
				btnNew.setBounds(387,145,17,20);//+107
				//add button in contentPane
				getContentPane().add(btnNew);
				
        /*swed = new JXDatePicker();
		swed.getEditor().setFont(new Font("Times New Roman", Font.PLAIN, 14));
		swed.setBounds(202,145,94,20);
		swed.setDate(Calendar.getInstance().getTime());
        //swed.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
        //swed.setFormats("dd.mm.yyyy");
         getContentPane().add(swed);*/
        
		JLabel lblService = new JLabel("SERVICE");
		lblService.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblService.setBounds(174, 11, 86, 14);
		 getContentPane().add(lblService);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblId.setBounds(34, 50, 46, 14);
		 getContentPane().add(lblId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblName.setBounds(34, 73, 46, 14);
		 getContentPane().add(lblName);
		
		JLabel lblDateOfPurchase = new JLabel("Date of Purchase");
		lblDateOfPurchase.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDateOfPurchase.setBounds(34, 98, 116, 14);
		 getContentPane().add(lblDateOfPurchase);
		
		JLabel lblWarrantyStartDate = new JLabel("Warranty Start Date");
		lblWarrantyStartDate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblWarrantyStartDate.setBounds(34, 123, 135, 14);
		 getContentPane().add(lblWarrantyStartDate);
		
		JLabel lblWarrantyEndDate = new JLabel("Warranty End Date");
		lblWarrantyEndDate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblWarrantyEndDate.setBounds(34, 148, 135, 14);
		 getContentPane().add(lblWarrantyEndDate);
		
		JLabel lblPurchasedFrom = new JLabel("Purchased From");
		lblPurchasedFrom.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPurchasedFrom.setBounds(34, 174, 116, 14);
		 getContentPane().add(lblPurchasedFrom);
		
		JLabel lblServiceValue = new JLabel("Service Value");
		lblServiceValue.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblServiceValue.setBounds(34, 199, 116, 14);
		 getContentPane().add(lblServiceValue);
		
		JLabel lblSerialNumber = new JLabel("Serial Number");
		lblSerialNumber.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblSerialNumber.setBounds(34, 222, 116, 14);
		 getContentPane().add(lblSerialNumber);
		
		seid = new JTextField();
		seid.setEditable(false);
		seid.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		seid.setBounds(202, 48, 86, 20);
		 getContentPane().add(seid);
		seid.setColumns(10);
		
		sename = new JTextField();
		sename.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
			
				char keyChar = e.getKeyChar();
			    if (Character.isLowerCase(keyChar)) {
			      e.setKeyChar(Character.toUpperCase(keyChar));
			    }
				char c=e.getKeyChar();
				if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ))
				        e.consume();
			}
		});
		sename.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		sename.setColumns(10);
		sename.setBounds(202, 71, 182, 20);
		 getContentPane().add(sename);
		
		 //amount=Double.parseDouble(sevalue.getText());
			sevalue = new JTextField();
			sevalue.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			//sevalue.setText(amount.toString());
			sevalue.setColumns(10);
			/*sevalue.addPropertyChangeListener("value", (PropertyChangeListener) this);
			sevalue.addPropertyChangeListener(new PropertyChangeListener() {
				public void propertyChange(PropertyChangeEvent e) {
					amount = ((Number)sevalue.getValue()).doubleValue();
				}
			});*/
		sevalue.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		//sevalue.setColumns(10);
		sevalue.setBounds(202, 197, 182, 20);
		 getContentPane().add(sevalue);
		
		senum = new JTextField(20);
		/*PlainDocument doc = (PlainDocument) senum.getDocument();
	      doc.setDocumentFilter(new TextLengthDocFilter(16));
		senum.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				  if((Character.isAlphabetic(c) ||  (c==KeyEvent.VK_SPACE)))
			      {
			    	  senum.setText("0");
			      }
			}
		});*/
		senum.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		senum.setColumns(10);
		senum.setBounds(202, 220, 182, 20);
		 getContentPane().add(senum);
		
		sepurf = new JTextField();
		/*sepurf.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char keyChar = e.getKeyChar();
			    if (Character.isLowerCase(keyChar)) {
			      e.setKeyChar(Character.toUpperCase(keyChar));
			    }
				char c=e.getKeyChar();
				if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ))
				        e.consume();
			}
		});*/
		sepurf.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		sepurf.setColumns(10);
		sepurf.setBounds(202, 171, 182, 20);
		 getContentPane().add(sepurf);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(83, 257, 301, 56);
		 getContentPane().add(panel);
		
		
		
		JButton update = new JButton("Update");
		update.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\Save.png"));
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con=DriverManager.getConnection("jdbc:odbc:mypro");
					
					Statement st=con.createStatement();
					String q1="select * from SERVICE";
					ResultSet rs=st.executeQuery(q1);
					int cnt=0;
					while(rs.next())
						cnt++;
					cnt=cnt+1;
					PreparedStatement pst;
					String query="UPDATE SERVICE SET SERVICE_NAME=?,DATE_OF_PURCHACE=?,WARRANTY_START_DATE=?,WARRANTY_STOP_DATE=?,PURCHACED_FROM=?,SERVICE_VALUE=?,SERIAL_NO=? WHERE SERVICE_ID=?";
				
					pst = con.prepareStatement(query);
					pst.setString(2,sename.getText());
					pst.setString(3,txtDate.getText());
					pst.setString(4,txt_Date.getText());
					pst.setString(5,txtdate.getText());
					pst.setInt(6,Integer.parseInt(sevalue.getText().toString()));
					 pst.setString(7,senum.getText());
					
					

					int result = pst.executeUpdate();
					
					
				    if(result == 1){
				       message_dialog=""+"Record updated";
				    int type_dialog = JOptionPane.PLAIN_MESSAGE;
				    JOptionPane.showMessageDialog((Component) null, message_dialog, add_dialog, type_dialog);}
				    else 
				    {message_dialog=""+"Record Not updated";
				    int type_dialog = JOptionPane.PLAIN_MESSAGE;
				    JOptionPane.showMessageDialog((Component) null, message_dialog, not_dialog, type_dialog);}
				    	System.out.println("Record not updated");

					
				    	seid.enableInputMethods(false);
						sename.enableInputMethods(false);
						sevalue.enableInputMethods(false);
						senum.enableInputMethods(false);
						sepurf.enableInputMethods(false);
						sdos.enableInputMethods(false);
						swsd.enableInputMethods(false);
						swed.enableInputMethods(false);
				
				}
				catch(ClassNotFoundException ce) {System.out.println("Class not found exception.");}
				catch(SQLException sqle){System.out.println(sqle);}
				catch(Exception l){System.out.println("In catch "+l);}
			
			}
		});
		update.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(update);
		
		JButton secancel = new JButton("Cancel");
		secancel.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\cancel.png"));
		secancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				seid.setText(null);
				sename.setText(null);
				sevalue.setText(null);
				senum.setText(null);
				sepurf.setText(null);
			}
		});
		secancel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(secancel);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(202, 124, 46, 14);
		 getContentPane().add(lblNewLabel);
		 
		 JLabel lblDigits = new JLabel("16 digits");
		 lblDigits.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		 lblDigits.setBounds(394, 223, 46, 14);
		 getContentPane().add(lblDigits);
		 
		 JLabel lblInRupees = new JLabel("in Rupees");
		 lblInRupees.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		 lblInRupees.setBounds(394, 200, 70, 14);
		 getContentPane().add(lblInRupees);


Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");					
	Connection con = DriverManager.getConnection("jdbc:odbc:mypro");
	Statement stmt;
	stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery("Select * from SERVICE where SERVICE_ID="+value);
	while(rs.next())
	{
	//seid.setText(Integer.parseInt(rs.getInt(1).toString()));
		sename.setText(rs.getString(2));
		txtDate.setText(rs.getString(3));
		txt_Date.setText(rs.getString(4));
		txtdate.setText(rs.getString(5));
		sepurf.setText(rs.getString(6));
		sevalue.setText(rs.getString(7));
		senum.setText(rs.getString(8));
			}
	rs.close();
	stmt.close();






}
catch(Exception e ){}
	}

	
}
