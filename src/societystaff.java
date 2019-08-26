import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JInternalFrame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


public class societystaff extends JInternalFrame {
	
	private JTextField ssid,ssname,ssphno,ssdes,sssal;
	//private JFormattedTextField sssal;
	private JTextArea ssaddr;
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
					societystaff frame = new societystaff();
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
	public societystaff() throws SQLException,NullPointerException{
		try{
		setTitle("Society Staff");
		//setMaximum(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 1402, 567);
		getContentPane().setLayout(null);
		
		JLabel lblSocietyStaff = new JLabel("Society Staff");
		lblSocietyStaff.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblSocietyStaff.setBounds(174, 11, 153, 24);
		 getContentPane().add(lblSocietyStaff);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblId.setBounds(35, 51, 46, 14);
		 getContentPane().add(lblId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblName.setBounds(35, 76, 46, 14);
		 getContentPane().add(lblName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblAddress.setBounds(35, 103, 70, 14);
		 getContentPane().add(lblAddress);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPhoneNumber.setBounds(35, 154, 99, 14);
		 getContentPane().add(lblPhoneNumber);
		
		JLabel lblDesignation = new JLabel("Designation");
		lblDesignation.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDesignation.setBounds(35, 179, 85, 15);
		 getContentPane().add(lblDesignation);
		
		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblSalary.setBounds(35, 205, 46, 14);
		 getContentPane().add(lblSalary);
		
		 //amount=Double.parseDouble(sssal.getText());
		 sssal = new JTextField();
		 sssal.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		 sssal.setColumns(10);
		/* sssal.addPropertyChangeListener("value", (PropertyChangeListener) this);
		 sssal.addPropertyChangeListener(new PropertyChangeListener() {
				public void propertyChange(PropertyChangeEvent e) {
					amount = ((Number)sssal.getValue()).doubleValue();
				}
			});*/
		sssal.setBounds(158, 203, 153, 20);
		 getContentPane().add(sssal);
		 
		 ssaddr = new JTextArea();
		ssaddr.addKeyListener(new KeyAdapter() {
			
			public void keyTyped(KeyEvent e) {
				char keyChar = e.getKeyChar();
			    if (Character.isLowerCase(keyChar)) {
			      e.setKeyChar(Character.toUpperCase(keyChar));
			    }
			}
		});
		ssaddr.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		ssaddr.setBounds(158, 99, 153, 46);
		 getContentPane().add(ssaddr);
		
		ssid = new JTextField();
		ssid.setEditable(false);
		ssid.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		ssid.setBounds(158, 49, 153, 20);
		 getContentPane().add(ssid);
		ssid.setColumns(10);
		
		ssname = new JTextField();
		ssname.addKeyListener(new KeyAdapter() {
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
		ssname.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		ssname.setColumns(10);
		ssname.setBounds(158, 74, 153, 20);
		 getContentPane().add(ssname);
		
		ssphno = new JTextField();
		ssphno.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				String number=ssphno.getText();
				Pattern pattern = Pattern.compile("\\d{10}");
				      Matcher matcher = pattern.matcher(number);
				      if (matcher.matches()) {
				    	  e.consume();
				    	  //System.out.println("Phone Number Valid");
				      }
				      else
				      {
				  //System.out.println("Phone Number must be in the form XXX-XXXXXXX");
				      }
			   if((Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ))
				  {
				   ssphno.setText("0");
				      }

			}
		});
		ssphno.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		ssphno.setColumns(10);
		ssphno.setBounds(158, 152, 153, 20);
		 getContentPane().add(ssphno);
		
		ssdes = new JTextField();
		ssdes.addKeyListener(new KeyAdapter() {
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
		ssdes.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		ssdes.setColumns(10);
		ssdes.setBounds(158, 177, 153, 20);
		 getContentPane().add(ssdes);
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(67, 230, 270, 87);
		 getContentPane().add(panel);
		
		JButton ssadd = new JButton("Add");
		ssadd.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\new.png"));
		ssadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				ssid.enableInputMethods(true);
				ssname.enableInputMethods(true);
				ssphno.enableInputMethods(true);
				ssdes.enableInputMethods(true);
				sssal.enableInputMethods(true);
				ssaddr.enableInputMethods(true);
				
				ssid.setText(null);
				ssname.setText(null);
				ssphno.setText(null);
				ssdes.setText(null);
				sssal.setText(null);
				ssaddr.setText(null);

			}
		});
		ssadd.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(ssadd);
		
		JButton sssave = new JButton("Save");
		sssave.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\Save.png"));
		sssave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con=DriverManager.getConnection("jdbc:odbc:mypro");
					
					Statement st=con.createStatement();
					String q1="select * from SOCIETY_STAFF";
					ResultSet rs=st.executeQuery(q1);
					int cnt=0;
					while(rs.next())
						cnt++;
					cnt=cnt+1;
					
					String q2="INSERT INTO SOCIETY_STAFF (STAFF_NAME,ADDRESS,PHONE_NO,DESIGNATION,SALARY) VALUES('"+ssname.getText()+"','"+ssaddr.getText()+"','"+ssphno.getText()+"','"+ssdes.getText()+"',"+Integer.parseInt(sssal.getText())+")";
					
					int rs_int=st.executeUpdate(q2);
					
				    if(rs_int>0){
				       message_dialog=""+ssname.getText().toUpperCase()+"Record inserted";
				    int type_dialog = JOptionPane.PLAIN_MESSAGE;
				    JOptionPane.showMessageDialog((Component) null, message_dialog, add_dialog, type_dialog);}
				    else 
				    {message_dialog=""+ssname.getText().toUpperCase()+"Record Not inserted";
				    int type_dialog = JOptionPane.PLAIN_MESSAGE;
				    JOptionPane.showMessageDialog((Component) null, message_dialog, not_dialog, type_dialog);}
				    	System.out.println("Record not inserted");
				
				    	ssid.enableInputMethods(false);
						ssname.enableInputMethods(false);
						ssphno.enableInputMethods(false);
						ssdes.enableInputMethods(false);
						sssal.enableInputMethods(false);
						ssaddr.enableInputMethods(false);
						con.close();
				}
				catch(ClassNotFoundException ce) {System.out.println("Class not found exception.");}
				catch(SQLException sqle){System.out.println(sqle);}
				catch(Exception l){System.out.println("In catch "+l);}
			
				
			}
		});
		sssave.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(sssave);
		
		JButton sscancel = new JButton("Cancel");
		sscancel.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\cancel.png"));
		sscancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ssid.setText(null);
				ssname.setText(null);
				ssphno.setText(null);
				ssdes.setText(null);
				sssal.setText(null);
				ssaddr.setText(null);
			}
		});
		sscancel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(sscancel);
		
		JLabel label = new JLabel("in Rupees");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label.setBounds(332, 206, 86, 14);
		getContentPane().add(label);
		
		JLabel lblDigits = new JLabel("10 digits");
		lblDigits.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblDigits.setBounds(332, 155, 86, 14);
		getContentPane().add(lblDigits);

		try{
			
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:mypro");
			Statement stmt = con.createStatement();
			ResultSet rs=null;
			
			String q1="select * from SOCIETY_STAFF";
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
	
	public societystaff(int value) throws SQLException,NullPointerException{
		try{
		
		getContentPane().setBackground(new Color(204, 204, 255));
		setTitle("Society Staff");
		//setMaximum(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 490, 358);
		getContentPane().setLayout(null);
		
		JLabel lblSocietyStaff = new JLabel("Society Staff");
		lblSocietyStaff.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblSocietyStaff.setBounds(174, 11, 153, 24);
		 getContentPane().add(lblSocietyStaff);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblId.setBounds(35, 51, 46, 14);
		 getContentPane().add(lblId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblName.setBounds(35, 76, 46, 14);
		 getContentPane().add(lblName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblAddress.setBounds(35, 103, 70, 14);
		 getContentPane().add(lblAddress);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPhoneNumber.setBounds(35, 154, 99, 14);
		 getContentPane().add(lblPhoneNumber);
		
		JLabel lblDesignation = new JLabel("Designation");
		lblDesignation.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDesignation.setBounds(35, 179, 85, 15);
		 getContentPane().add(lblDesignation);
		
		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblSalary.setBounds(35, 205, 46, 14);
		 getContentPane().add(lblSalary);
		
		ssaddr = new JTextArea();
		ssaddr.addKeyListener(new KeyAdapter() {
			
			public void keyTyped(KeyEvent e) {
				char keyChar = e.getKeyChar();
			    if (Character.isLowerCase(keyChar)) {
			      e.setKeyChar(Character.toUpperCase(keyChar));
			    }
			}
		});
		ssaddr.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		ssaddr.setBounds(158, 99, 153, 46);
		 getContentPane().add(ssaddr);
		
		ssid = new JTextField();
		ssid.setEditable(false);
		ssid.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		ssid.setBounds(158, 49, 153, 20);
		 getContentPane().add(ssid);
		ssid.setColumns(10);
		
		ssname = new JTextField();
		ssname.addKeyListener(new KeyAdapter() {
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
		ssname.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		ssname.setColumns(10);
		ssname.setBounds(158, 74, 153, 20);
		 getContentPane().add(ssname);
		
		ssphno = new JTextField();
		ssphno.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				String number=ssphno.getText();
				Pattern pattern = Pattern.compile("\\d{10}");
				      Matcher matcher = pattern.matcher(number);
				      if (matcher.matches()) {
				    	  e.consume();
				    	  //System.out.println("Phone Number Valid");
				      }
				      else
				      {
				  //System.out.println("Phone Number must be in the form XXX-XXXXXXX");
				      }
			   if((Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ))
				  {
				   ssphno.setText("0");
				      }

			}
		});
		ssphno.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		ssphno.setColumns(10);
		ssphno.setBounds(158, 152, 153, 20);
		 getContentPane().add(ssphno);
		
		ssdes = new JTextField();
		ssdes.addKeyListener(new KeyAdapter() {
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
		ssdes.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		ssdes.setColumns(10);
		ssdes.setBounds(158, 177, 153, 20);
		 getContentPane().add(ssdes);
		
		//amount=Double.parseDouble(sssal.getText());
		 sssal = new JTextField();
		 sssal.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		 sssal.setColumns(10);
		/* sssal.addPropertyChangeListener("value", (PropertyChangeListener) this);
		 sssal.addPropertyChangeListener(new PropertyChangeListener() {
				public void propertyChange(PropertyChangeEvent e) {
					amount = ((Number)sssal.getValue()).doubleValue();
				}
			});*/
		sssal.setBounds(158, 203, 153, 20);
		 getContentPane().add(sssal);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(67, 230, 270, 87);
		 getContentPane().add(panel);
		
		
		
		JButton sssave = new JButton("Update");
		sssave.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\Save.png"));
		sssave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con=DriverManager.getConnection("jdbc:odbc:mypro");
					
					Statement st=con.createStatement();
					String q1="select * from SOCIETY_STAFF";
					ResultSet rs=st.executeQuery(q1);
					int cnt=0;
					while(rs.next())
						cnt++;
					cnt=cnt+1;
					
					String q2="INSERT INTO SOCIETY_STAFF (STAFF_NAME,ADDRESS,PHONE_NO,DESIGNATION,SALARY) VALUES('"+ssname.getText()+"','"+ssaddr.getText()+"','"+ssphno.getText()+"','"+ssdes.getText()+"',"+Integer.parseInt(sssal.getText())+")";
					
					int rs_int=st.executeUpdate(q2);
					
				    if(rs_int>0){
				       message_dialog=""+ssname.getText().toUpperCase()+"Record inserted";
				    int type_dialog = JOptionPane.PLAIN_MESSAGE;
				    JOptionPane.showMessageDialog((Component) null, message_dialog, add_dialog, type_dialog);}
				    else 
				    {message_dialog=""+ssname.getText().toUpperCase()+"Record Not inserted";
				    int type_dialog = JOptionPane.PLAIN_MESSAGE;
				    JOptionPane.showMessageDialog((Component) null, message_dialog, not_dialog, type_dialog);}
				    	System.out.println("Record not inserted");
				
				    	ssid.enableInputMethods(false);
						ssname.enableInputMethods(false);
						ssphno.enableInputMethods(false);
						ssdes.enableInputMethods(false);
						sssal.enableInputMethods(false);
						ssaddr.enableInputMethods(false);
						con.close();
				}
				catch(ClassNotFoundException ce) {System.out.println("Class not found exception.");}
				catch(SQLException sqle){System.out.println(sqle);}
				catch(Exception l){System.out.println("In catch "+l);}
			
				
			}
		});
		sssave.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(sssave);
		
		JButton sscancel = new JButton("Cancel");
		sscancel.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\cancel.png"));
		sscancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ssid.setText(null);
				ssname.setText(null);
				ssphno.setText(null);
				ssdes.setText(null);
				sssal.setText(null);
				ssaddr.setText(null);
			}
		});
		sscancel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(sscancel);
		
		JLabel label = new JLabel("in Rupees");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label.setBounds(332, 206, 86, 14);
		getContentPane().add(label);
		
		JLabel lblDigits = new JLabel("10 digits");
		lblDigits.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblDigits.setBounds(332, 155, 86, 14);
		getContentPane().add(lblDigits);

		}
		catch(Exception e ){}
	}
	

}
