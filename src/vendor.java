import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.text.PlainDocument;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Color;

import javax.swing.ImageIcon;


public class vendor extends JInternalFrame {
	
	private JTextField vid,vcnm,vrno,vcp,vcno,vtan,vpan;
	private JTextArea vaddress;
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
					vendor frame = new vendor();
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
	public vendor() throws SQLException,NullPointerException{
		try{
		setTitle("Vendor");
		//setMaximum(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 603, 431);
		getContentPane().setLayout(null);
		
		JLabel lblVendorDetails = new JLabel("Vendor Details");
		lblVendorDetails.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblVendorDetails.setBounds(191, 11, 138, 14);
		 getContentPane().add(lblVendorDetails);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblId.setBounds(40, 47, 46, 14);
		 getContentPane().add(lblId);
		
		JLabel lblCompanyName = new JLabel("Company Name");
		lblCompanyName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblCompanyName.setBounds(40, 72, 104, 14);
		 getContentPane().add(lblCompanyName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblAddress.setBounds(40, 97, 81, 14);
		 getContentPane().add(lblAddress);
		
		JLabel lblRegistrationNumber = new JLabel("Registration Number");
		lblRegistrationNumber.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblRegistrationNumber.setBounds(40, 151, 138, 14);
		 getContentPane().add(lblRegistrationNumber);
		
		JLabel lblContactPerson = new JLabel("Contact Person");
		lblContactPerson.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblContactPerson.setBounds(40, 176, 119, 14);
		 getContentPane().add(lblContactPerson);
		
		JLabel lblContactNumber = new JLabel("Contact Number");
		lblContactNumber.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblContactNumber.setBounds(40, 201, 138, 14);
		 getContentPane().add(lblContactNumber);
		
		JLabel lblTan = new JLabel("TAN");
		lblTan.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTan.setBounds(40, 226, 138, 14);
		 getContentPane().add(lblTan);
		
		JLabel lblPan = new JLabel("PAN");
		lblPan.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPan.setBounds(40, 251, 138, 14);
		 getContentPane().add(lblPan);
		
		vid = new JTextField();
		vid.setEditable(false);
		vid.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		vid.setBounds(221, 45, 86, 20);
		 getContentPane().add(vid);
		vid.setColumns(10);
		
		vcnm = new JTextField();
		vcnm.addKeyListener(new KeyAdapter() {
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
		vcnm.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		vcnm.setColumns(10);
		vcnm.setBounds(221, 70, 203, 20);
		 getContentPane().add(vcnm);
		
		vrno = new JTextField(15);
		vrno.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		vrno.setBounds(221, 149, 119, 20);
		 getContentPane().add(vrno);
		 PlainDocument doc = (PlainDocument) vrno.getDocument();
	      doc.setDocumentFilter(new TextLengthDocFilter(10));
		
		vcp = new JTextField();
		vcp.addKeyListener(new KeyAdapter() {
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
		vcp.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		vcp.setColumns(10);
		vcp.setBounds(221, 174, 203, 20);
		 getContentPane().add(vcp);
		
		vcno = new JTextField();
		PlainDocument doc2 = (PlainDocument) vcno.getDocument();
	      doc2.setDocumentFilter(new TextLengthDocFilter(10));
		vcno.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				  if((Character.isAlphabetic(c) ||  (c==KeyEvent.VK_SPACE)))
			      {
			    	  vcno.setText("0");
			      }
			}
		});
		vcno.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		vcno.setColumns(10);
		vcno.setBounds(221, 199, 119, 20);
		 getContentPane().add(vcno);
		
		vtan = new JTextField();
		PlainDocument doc3 = (PlainDocument) vtan.getDocument();
	      doc3.setDocumentFilter(new TextLengthDocFilter(16));
		vtan.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				  if((Character.isAlphabetic(c) ||  (c==KeyEvent.VK_SPACE)))
			      {
			    	  vtan.setText("0");
			      }
			}
		});
		vtan.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		vtan.setColumns(10);
		vtan.setBounds(221, 224, 119, 20);
		 getContentPane().add(vtan);
		
		vpan = new JTextField();
		PlainDocument doc1 = (PlainDocument) vpan.getDocument();
	      doc1.setDocumentFilter(new TextLengthDocFilter(16));
		vpan.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				  if((Character.isAlphabetic(c) ||  (c==KeyEvent.VK_SPACE)))
			      {
			    	  vpan.setText("0");
			      }
			}
		});
		vpan.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		vpan.setColumns(10);
		vpan.setBounds(221, 249, 119, 20);
		 getContentPane().add(vpan);
		
		vaddress = new JTextArea();
		vaddress.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char keyChar = e.getKeyChar();
			    if (Character.isLowerCase(keyChar)) {
			      e.setKeyChar(Character.toUpperCase(keyChar));
			    }
			}
		});
		vaddress.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		vaddress.setBounds(221, 93, 203, 48);
		 getContentPane().add(vaddress);
		
		JPanel panel = new JPanel();
		panel.setBounds(104, 284, 320, 78);
		 getContentPane().add(panel);
		
		JButton vadd = new JButton("Add");
		vadd.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\new.png"));
		vadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vid.enableInputMethods(true);
				vcnm.enableInputMethods(true);
				vrno.enableInputMethods(true);
				vcp.enableInputMethods(true);
				vcno.enableInputMethods(true);
				vtan.enableInputMethods(true);
				vpan.enableInputMethods(true);
				vaddress.enableInputMethods(true);
				
				vid.setText(null);
				vcnm.setText(null);
				vrno.setText(null);
				vcp.setText(null);
				vcno.setText(null);
				vtan.setText(null);
				vpan.setText(null);
				vaddress.setText(null);
			}
		});
		vadd.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(vadd);
		
		JButton vsave = new JButton("Save");
		vsave.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\Save.png"));
		vsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con=DriverManager.getConnection("jdbc:odbc:mypro");
					
					Statement st=con.createStatement();
					String q1="select * from VENDOR";
					ResultSet rs=st.executeQuery(q1);
					int cnt=0;
					while(rs.next())
						cnt++;
					cnt=cnt+1;
					
					String q2="INSERT INTO VENDOR (COMPANY_NAME,ADDRESS,REGISTRATION_NO,CONTACT_PERSON,NUMBER,TAN,PAN) VALUES('"+vcnm.getText()+"','"+vaddress.getText()+"','"+vrno.getText()+"','"+vcp.getText()+"',"+Integer.parseInt(vcno.getText())+",'"+vtan.getText()+"','"+vpan.getText()+"')";
					
					int rs_int=st.executeUpdate(q2);
					
				    if(rs_int>0){
				       message_dialog=""+vcnm.getText().toUpperCase()+"Record inserted";
				    int type_dialog = JOptionPane.PLAIN_MESSAGE;
				    JOptionPane.showMessageDialog((Component) null, message_dialog, add_dialog, type_dialog);}
				    else 
				    {message_dialog=""+vcnm.getText().toUpperCase()+"Record Not inserted";
				    int type_dialog = JOptionPane.PLAIN_MESSAGE;
				    JOptionPane.showMessageDialog((Component) null, message_dialog, not_dialog, type_dialog);}
				    	System.out.println("Record not inserted");
				
				    	vid.enableInputMethods(false);
						vcnm.enableInputMethods(false);
						vrno.enableInputMethods(false);
						vcp.enableInputMethods(false);
						vcno.enableInputMethods(false);
						vtan.enableInputMethods(false);
						vpan.enableInputMethods(false);
						vaddress.enableInputMethods(false);
						con.close();		
				}
				catch(ClassNotFoundException ce) {System.out.println("Class not found exception.");}
				catch(SQLException sqle){System.out.println(sqle);}
				catch(Exception l){System.out.println("In catch "+l);}
			
				
			}
		});
		vsave.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(vsave);
		
		JButton vcancel = new JButton("Cancel");
		vcancel.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\cancel.png"));
		vcancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		vcancel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(vcancel);
		
		JLabel lblDigits = new JLabel("10 digits");
		lblDigits.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblDigits.setBounds(350, 152, 46, 14);
		getContentPane().add(lblDigits);
		
		JLabel label = new JLabel("10 digits");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label.setBounds(350, 202, 46, 14);
		getContentPane().add(label);
		
		JLabel lblDigits_1 = new JLabel("16 digits");
		lblDigits_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblDigits_1.setBounds(350, 227, 46, 14);
		getContentPane().add(lblDigits_1);
		
		JLabel lblDigits_2 = new JLabel("16 digits");
		lblDigits_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblDigits_2.setBounds(350, 252, 46, 14);
		getContentPane().add(lblDigits_2);
		
		
		try{
			
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:mypro");
			Statement stmt = con.createStatement();
			ResultSet rs=null;
			
			String q1="select * from VENDOR";
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
		
		
		
		
		getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{vcnm, vaddress, vrno, vcp, vcno, vtan, vpan, vadd, vsave, vcancel, vid, lblVendorDetails, lblId, lblCompanyName, lblAddress, lblRegistrationNumber, lblContactPerson, lblContactNumber, lblTan, lblPan, panel, lblDigits, label, lblDigits_1, lblDigits_2}));

		}
		catch(Exception e ){}
		
	}
	
	
	public vendor(int value) throws SQLException,NullPointerException{
		try{
		
		getContentPane().setBackground(new Color(204, 204, 255));
		setTitle("Vendor");
		//setMaximum(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 603, 431);
		getContentPane().setLayout(null);
		
		JLabel lblVendorDetails = new JLabel("Vendor Details");
		lblVendorDetails.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblVendorDetails.setBounds(191, 11, 138, 14);
		 getContentPane().add(lblVendorDetails);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblId.setBounds(40, 47, 46, 14);
		 getContentPane().add(lblId);
		
		JLabel lblCompanyName = new JLabel("Company Name");
		lblCompanyName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblCompanyName.setBounds(40, 72, 104, 14);
		 getContentPane().add(lblCompanyName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblAddress.setBounds(40, 97, 81, 14);
		 getContentPane().add(lblAddress);
		
		JLabel lblRegistrationNumber = new JLabel("Registration Number");
		lblRegistrationNumber.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblRegistrationNumber.setBounds(40, 151, 138, 14);
		 getContentPane().add(lblRegistrationNumber);
		
		JLabel lblContactPerson = new JLabel("Contact Person");
		lblContactPerson.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblContactPerson.setBounds(40, 176, 119, 14);
		 getContentPane().add(lblContactPerson);
		
		JLabel lblContactNumber = new JLabel("Contact Number");
		lblContactNumber.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblContactNumber.setBounds(40, 201, 138, 14);
		 getContentPane().add(lblContactNumber);
		
		JLabel lblTan = new JLabel("TAN");
		lblTan.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTan.setBounds(40, 226, 138, 14);
		 getContentPane().add(lblTan);
		
		JLabel lblPan = new JLabel("PAN");
		lblPan.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPan.setBounds(40, 251, 138, 14);
		 getContentPane().add(lblPan);
		
		vid = new JTextField();
		vid.setEditable(false);
		vid.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		vid.setBounds(221, 45, 86, 20);
		 getContentPane().add(vid);
		vid.setColumns(10);
		
		vcnm = new JTextField();
		vcnm.addKeyListener(new KeyAdapter() {
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
		vcnm.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		vcnm.setColumns(10);
		vcnm.setBounds(221, 70, 203, 20);
		 getContentPane().add(vcnm);
		
		vrno = new JTextField(15);
		vrno.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		vrno.setBounds(221, 149, 119, 20);
		 getContentPane().add(vrno);
		 PlainDocument doc = (PlainDocument) vrno.getDocument();
	      doc.setDocumentFilter(new TextLengthDocFilter(10));
		
		vcp = new JTextField();
		vcp.addKeyListener(new KeyAdapter() {
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
		vcp.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		vcp.setColumns(10);
		vcp.setBounds(221, 174, 203, 20);
		 getContentPane().add(vcp);
		
		vcno = new JTextField();
		PlainDocument doc2 = (PlainDocument) vcno.getDocument();
	      doc2.setDocumentFilter(new TextLengthDocFilter(10));
		vcno.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				  if((Character.isAlphabetic(c) ||  (c==KeyEvent.VK_SPACE)))
			      {
			    	  vcno.setText("0");
			      }
			}
		});
		vcno.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		vcno.setColumns(10);
		vcno.setBounds(221, 199, 119, 20);
		 getContentPane().add(vcno);
		
		vtan = new JTextField();
		PlainDocument doc3 = (PlainDocument) vtan.getDocument();
	      doc3.setDocumentFilter(new TextLengthDocFilter(16));
		vtan.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				  if((Character.isAlphabetic(c) ||  (c==KeyEvent.VK_SPACE)))
			      {
			    	  vtan.setText("0");
			      }
			}
		});
		vtan.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		vtan.setColumns(10);
		vtan.setBounds(221, 224, 119, 20);
		 getContentPane().add(vtan);
		
		vpan = new JTextField();
		PlainDocument doc1 = (PlainDocument) vpan.getDocument();
	      doc1.setDocumentFilter(new TextLengthDocFilter(16));
		vpan.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				  if((Character.isAlphabetic(c) ||  (c==KeyEvent.VK_SPACE)))
			      {
			    	  vpan.setText("0");
			      }
			}
		});
		vpan.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		vpan.setColumns(10);
		vpan.setBounds(221, 249, 119, 20);
		 getContentPane().add(vpan);
		
		vaddress = new JTextArea();
		vaddress.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char keyChar = e.getKeyChar();
			    if (Character.isLowerCase(keyChar)) {
			      e.setKeyChar(Character.toUpperCase(keyChar));
			    }
			}
		});
		vaddress.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		vaddress.setBounds(221, 93, 203, 48);
		 getContentPane().add(vaddress);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(104, 284, 320, 78);
		 getContentPane().add(panel);
		
		
		
		JButton vsave = new JButton("Update");
		vsave.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\Save.png"));
		vsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con=DriverManager.getConnection("jdbc:odbc:mypro");
					
					Statement st=con.createStatement();
					String q1="select * from VENDOR";
					ResultSet rs=st.executeQuery(q1);
					int cnt=0;
					while(rs.next())
						cnt++;
					cnt=cnt+1;
					
					String q2="INSERT INTO VENDOR (COMPANY_NAME,ADDRESS,REGISTRATION_NO,CONTACT_PERSON,NUMBER,TAN,PAN) VALUES('"+vcnm.getText()+"','"+vaddress.getText()+"','"+vrno.getText()+"','"+vcp.getText()+"',"+Integer.parseInt(vcno.getText())+",'"+vtan.getText()+"','"+vpan.getText()+"')";
					
					int rs_int=st.executeUpdate(q2);
					
				    if(rs_int>0){
				       message_dialog=""+vcnm.getText().toUpperCase()+"Record inserted";
				    int type_dialog = JOptionPane.PLAIN_MESSAGE;
				    JOptionPane.showMessageDialog((Component) null, message_dialog, add_dialog, type_dialog);}
				    else 
				    {message_dialog=""+vcnm.getText().toUpperCase()+"Record Not inserted";
				    int type_dialog = JOptionPane.PLAIN_MESSAGE;
				    JOptionPane.showMessageDialog((Component) null, message_dialog, not_dialog, type_dialog);}
				    	System.out.println("Record not inserted");
				
				    	vid.enableInputMethods(false);
						vcnm.enableInputMethods(false);
						vrno.enableInputMethods(false);
						vcp.enableInputMethods(false);
						vcno.enableInputMethods(false);
						vtan.enableInputMethods(false);
						vpan.enableInputMethods(false);
						vaddress.enableInputMethods(false);
						con.close();		
				}
				catch(ClassNotFoundException ce) {System.out.println("Class not found exception.");}
				catch(SQLException sqle){System.out.println(sqle);}
				catch(Exception l){System.out.println("In catch "+l);}
			
				
			}
		});
		vsave.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(vsave);
		
		JButton vcancel = new JButton("Cancel");
		vcancel.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\cancel.png"));
		vcancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		vcancel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(vcancel);
		
		JLabel lblDigits = new JLabel("10 digits");
		lblDigits.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblDigits.setBounds(350, 152, 46, 14);
		getContentPane().add(lblDigits);
		
		JLabel label = new JLabel("10 digits");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label.setBounds(350, 202, 46, 14);
		getContentPane().add(label);
		
		JLabel lblDigits_1 = new JLabel("16 digits");
		lblDigits_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblDigits_1.setBounds(350, 227, 46, 14);
		getContentPane().add(lblDigits_1);
		
		JLabel lblDigits_2 = new JLabel("16 digits");
		lblDigits_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblDigits_2.setBounds(350, 252, 46, 14);
		getContentPane().add(lblDigits_2);
		getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{vcnm, vaddress, vrno, vcp, vcno, vtan, vpan, vsave, vcancel, vid, lblVendorDetails, lblId, lblCompanyName, lblAddress, lblRegistrationNumber, lblContactPerson, lblContactNumber, lblTan, lblPan, panel, lblDigits, label, lblDigits_1, lblDigits_2}));

		}
		catch(Exception e ){}
		
	}
	

}

