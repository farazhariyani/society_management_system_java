import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JTextField;

import java.awt.Panel;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JInternalFrame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.ImageIcon;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class main_owner extends JInternalFrame {

	private JPanel contentPane;
	private JTextField ofname,omname,olname,omobile,oemail,oproof,oproofno,ooid;
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
					main_owner frame = new main_owner();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
 }
	
	/**
	 * Create the frame.
	 */
	public main_owner() throws SQLException,NullPointerException{
		try{
		
		setTitle("Owner");
		//setMaximum(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 652, 551);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblFirstName.setHorizontalAlignment(SwingConstants.LEFT);
		lblFirstName.setBounds(84, 102, 73, 29);
		getContentPane().add(lblFirstName);
		
		JLabel lblMiddleName = new JLabel("Middle Name");
		lblMiddleName.setHorizontalAlignment(SwingConstants.LEFT);
		lblMiddleName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblMiddleName.setBounds(84, 144, 88, 29);
		getContentPane().add(lblMiddleName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setHorizontalAlignment(SwingConstants.LEFT);
		lblLastName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblLastName.setBounds(84, 184, 73, 29);
		getContentPane().add(lblLastName);
		
		JLabel lblMobileNumber = new JLabel("Mobile Number");
		lblMobileNumber.setHorizontalAlignment(SwingConstants.LEFT);
		lblMobileNumber.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblMobileNumber.setBounds(84, 234, 111, 29);
		getContentPane().add(lblMobileNumber);
		
		JLabel lblEmailId = new JLabel("Email ID");
		lblEmailId.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmailId.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblEmailId.setBounds(84, 284, 73, 29);
		getContentPane().add(lblEmailId);
		
		JLabel lblIdProof = new JLabel("ID Proof");
		lblIdProof.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdProof.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblIdProof.setBounds(84, 324, 73, 29);
		getContentPane().add(lblIdProof);
		
		JLabel lblIdProofNumber = new JLabel("ID Proof Number");
		lblIdProofNumber.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdProofNumber.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblIdProofNumber.setBounds(84, 364, 111, 29);
		getContentPane().add(lblIdProofNumber);
		
		ofname = new JTextField();
		ofname.addKeyListener(new KeyAdapter() {
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
		ofname.setHorizontalAlignment(SwingConstants.LEFT);
		ofname.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		ofname.setBounds(254, 107, 178, 20);
		getContentPane().add(ofname);
		ofname.setColumns(10);
		
		omname = new JTextField();
		omname.addKeyListener(new KeyAdapter() {
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
		omname.setHorizontalAlignment(SwingConstants.LEFT);
		omname.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		omname.setColumns(10);
		omname.setBounds(254, 149, 178, 20);
		getContentPane().add(omname);
		
		olname = new JTextField();
		olname.addKeyListener(new KeyAdapter() {
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
		olname.setHorizontalAlignment(SwingConstants.LEFT);
		olname.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		olname.setColumns(10);
		olname.setBounds(254, 189, 178, 20);
		getContentPane().add(olname);
		
		omobile = new JTextField();
		omobile.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				
				char c=e.getKeyChar();
				String number=omobile.getText();
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
			    	  omobile.setText(null);
			      }
				
			}
		});
		omobile.setHorizontalAlignment(SwingConstants.LEFT);
		omobile.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		omobile.setColumns(10);
		omobile.setBounds(254, 239, 178, 20);
		getContentPane().add(omobile);
		
		oemail = new JTextField();
		oemail.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char keyChar = e.getKeyChar();
			    if (Character.isLowerCase(keyChar)) {
			      e.setKeyChar(Character.toUpperCase(keyChar));
			    }
			}
		});
		oemail.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
			
				if(isValidEmailAddress(oemail.getText()))
				{
					//e..consume();
				}
				else
				{
					oemail.setText(null);
				}
			}
		});
		/*oemail.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				
			}
		});*/
		oemail.setHorizontalAlignment(SwingConstants.LEFT);
		oemail.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		oemail.setColumns(10);
		oemail.setBounds(254, 289, 178, 20);
		getContentPane().add(oemail);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"LICENSE", "ADHAAR CARD", "PAN CARD", "PASSPORT"}));
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		comboBox.setBounds(254, 329, 178, 20);
		contentPane.add(comboBox);
		
		oproof = new JTextField();
		oproof.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char keyChar = e.getKeyChar();
			    if (Character.isLowerCase(keyChar)) {
			      e.setKeyChar(Character.toUpperCase(keyChar));
			    }
				char c=e.getKeyChar();
				if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE )|| (c==KeyEvent.VK_SPACE))
				        e.consume();
			}
		});
		oproof.setHorizontalAlignment(SwingConstants.LEFT);
		oproof.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		oproof.setColumns(10);
		oproof.setBounds(254, 328, 178, 20);
		
		getContentPane().add(oproof);
		
		oproofno = new JTextField();
		oproofno.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				String number=oproofno.getText();
				Pattern pattern = Pattern.compile("\\d{16}");
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
			    	  omobile.setText(null);
			      }
			}
		});
		oproofno.setHorizontalAlignment(SwingConstants.LEFT);
		oproofno.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		oproofno.setColumns(10);
		oproofno.setBounds(254, 369, 178, 20);
		getContentPane().add(oproofno);
		
		ooid = new JTextField();
		ooid.setEditable(false);
		ooid.setHorizontalAlignment(SwingConstants.LEFT);
		ooid.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		ooid.setColumns(10);
		ooid.setBounds(254, 69, 178, 20);
		getContentPane().add(ooid);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(145, 427, 365, 51);
		getContentPane().add(panel);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\Save.png"));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String oprof=(String) comboBox.getSelectedItem();
					oproof.setText(oprof);
					
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con=DriverManager.getConnection("jdbc:odbc:mypro");
					
					Statement st=con.createStatement();
					String q1="select * from OWNER";
					ResultSet rs=st.executeQuery(q1);
					int cnt=0;
					while(rs.next())
						cnt++;
					cnt=cnt+1;
					
					String q2="INSERT INTO OWNER (FIRST_NAME,MIDDLE_NAME,LAST_NAME,MOBILE_NO,EMAIL_ID,ID_PROOF,ID_NO) VALUES('"+ofname.getText()+"','"+omname.getText()+"','"+olname.getText()+"','"+omobile.getText()+"','"+oemail.getText()+"','"+oproof.getText()+"','"+oproofno.getText()+"')";
					//,REGISTRATION_DATE  ,'"+(Date)sregdt.getDate()+"'
					
					//String q2="INSERT INTO OWNER (FIRST_NAME,MIDDLE_NAME,LAST_NAME) "+ //,MOBILE_NO,EMAIL_ID,ID_PROOF,ID_NO)
				//	"VALUES('"+ofname.getText()+"','"+omname.getText()+"','"+olname.getText()+"')"; //,'"+omobile.getText()+"','"+oemail.getText()+"','"+oproof.getText()+"','"+oproofno.getText()+"')";
					
					int rs_int=st.executeUpdate(q2);
					
				    if(rs_int>0){
				       message_dialog=""+ofname.getText().toUpperCase()+"Record inserted";
				    int type_dialog = JOptionPane.PLAIN_MESSAGE;
				    JOptionPane.showMessageDialog((Component) null, message_dialog, add_dialog, type_dialog);}
				    else 
				    {message_dialog=""+ofname.getText().toUpperCase()+"Record Not inserted";
				    int type_dialog = JOptionPane.PLAIN_MESSAGE;
				    JOptionPane.showMessageDialog((Component) null, message_dialog, not_dialog, type_dialog);}
				    	System.out.println("Record not inserted");
					
				ofname.enableInputMethods(false);
				omname.enableInputMethods(false);
				olname.enableInputMethods(false);
				omobile.enableInputMethods(false);
				oemail.enableInputMethods(false);
				oproof.enableInputMethods(false);
				oproofno.enableInputMethods(false);
				ooid.enableInputMethods(false);
				
				con.close();
				}
				catch(ClassNotFoundException ce) {System.out.println("Class not found exception.");}
				catch(SQLException sqle){System.out.println(sqle);}
				catch(Exception l){System.out.println("In catch "+l);}
			
				}
		});
		
		JButton oadd = new JButton("ADD");
		oadd.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\new.png"));
		oadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				ofname.enableInputMethods(true);
				omname.enableInputMethods(true);
				olname.enableInputMethods(true);
				omobile.enableInputMethods(true);
				oemail.enableInputMethods(true);
				oproof.enableInputMethods(true);
				oproofno.enableInputMethods(true);
				ooid.enableInputMethods(true);
				
				ofname.setText(null);
				omname.setText(null);
				olname.setText(null);
				omobile.setText(null);
				oemail.setText(null);
				oproof.setText(null);
				oproofno.setText(null);
				ooid.setText(null);
			}
		});
		oadd.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(oadd);
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(btnSave);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\cancel.png"));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				ofname.setText(null);
				omname.setText(null);
				olname.setText(null);
				omobile.setText(null);
				oemail.setText(null);
				oproof.setText(null);
				oproofno.setText(null);
				ooid.setText(null);
			}
		});
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(btnCancel);
		
		JLabel lblEnterOwnerDetails = new JLabel("ENTER OWNER DETAILS");
		lblEnterOwnerDetails.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblEnterOwnerDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterOwnerDetails.setBounds(101, 11, 263, 43);
		getContentPane().add(lblEnterOwnerDetails);
		
		JLabel lblOwnerId = new JLabel("Owner ID");
		lblOwnerId.setHorizontalAlignment(SwingConstants.LEFT);
		lblOwnerId.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblOwnerId.setBounds(84, 64, 73, 29);
		getContentPane().add(lblOwnerId);
		
		JLabel lblDigit = new JLabel("10 digit");
		lblDigit.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblDigit.setBounds(448, 242, 46, 14);
		contentPane.add(lblDigit);
		
		JLabel lblDigit_1 = new JLabel("16 digit");
		lblDigit_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblDigit_1.setBounds(448, 372, 46, 14);
		contentPane.add(lblDigit_1);
		
		try{
			
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:mypro");
			Statement stmt = con.createStatement();
			ResultSet rs=null;
			
			String q1="select * from OWNER";
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
		
		contentPane.add(table);
		 
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
		
		
		
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{ofname, omname, olname, omobile, oemail, oproof, oproofno, oadd, btnSave, btnCancel, lblFirstName, lblMiddleName, lblLastName, lblMobileNumber, lblEmailId, lblIdProof, lblIdProofNumber, ooid, panel, lblEnterOwnerDetails, lblOwnerId, lblDigit, lblDigit_1}));
		
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
	    //dtm.setRowCount(10);
		validate();
		
		getContentPane().repaint();
		table.repaint();
			
		}catch(Exception e){e.printStackTrace();}

		}catch(Exception e){e.printStackTrace();}
	}

	public main_owner(int value) throws SQLException,NullPointerException{
		try{
		
		setTitle("Owner");
		//setMaximum(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 652, 551);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblFirstName.setHorizontalAlignment(SwingConstants.LEFT);
		lblFirstName.setBounds(84, 102, 73, 29);
		getContentPane().add(lblFirstName);
		
		JLabel lblMiddleName = new JLabel("Middle Name");
		lblMiddleName.setHorizontalAlignment(SwingConstants.LEFT);
		lblMiddleName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblMiddleName.setBounds(84, 144, 88, 29);
		getContentPane().add(lblMiddleName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setHorizontalAlignment(SwingConstants.LEFT);
		lblLastName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblLastName.setBounds(84, 184, 73, 29);
		getContentPane().add(lblLastName);
		
		JLabel lblMobileNumber = new JLabel("Mobile Number");
		lblMobileNumber.setHorizontalAlignment(SwingConstants.LEFT);
		lblMobileNumber.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblMobileNumber.setBounds(84, 234, 111, 29);
		getContentPane().add(lblMobileNumber);
		
		JLabel lblEmailId = new JLabel("Email ID");
		lblEmailId.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmailId.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblEmailId.setBounds(84, 284, 73, 29);
		getContentPane().add(lblEmailId);
		
		JLabel lblIdProof = new JLabel("ID Proof");
		lblIdProof.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdProof.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblIdProof.setBounds(84, 324, 73, 29);
		getContentPane().add(lblIdProof);
		
		JLabel lblIdProofNumber = new JLabel("ID Proof Number");
		lblIdProofNumber.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdProofNumber.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblIdProofNumber.setBounds(84, 364, 111, 29);
		getContentPane().add(lblIdProofNumber);
		
		ofname = new JTextField();
		ofname.addKeyListener(new KeyAdapter() {
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
		ofname.setHorizontalAlignment(SwingConstants.LEFT);
		ofname.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		ofname.setBounds(254, 107, 178, 20);
		getContentPane().add(ofname);
		ofname.setColumns(10);
		
		omname = new JTextField();
		omname.addKeyListener(new KeyAdapter() {
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
		omname.setHorizontalAlignment(SwingConstants.LEFT);
		omname.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		omname.setColumns(10);
		omname.setBounds(254, 149, 178, 20);
		getContentPane().add(omname);
		
		olname = new JTextField();
		olname.addKeyListener(new KeyAdapter() {
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
		olname.setHorizontalAlignment(SwingConstants.LEFT);
		olname.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		olname.setColumns(10);
		olname.setBounds(254, 189, 178, 20);
		getContentPane().add(olname);
		
		omobile = new JTextField();
		omobile.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				
				char c=e.getKeyChar();
				String number=omobile.getText();
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
			    	  omobile.setText(null);
			      }
				
			}
		});
		omobile.setHorizontalAlignment(SwingConstants.LEFT);
		omobile.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		omobile.setColumns(10);
		omobile.setBounds(254, 239, 178, 20);
		getContentPane().add(omobile);
		
		oemail = new JTextField();
		oemail.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char keyChar = e.getKeyChar();
			    if (Character.isLowerCase(keyChar)) {
			      e.setKeyChar(Character.toUpperCase(keyChar));
			    }
			}
		});
		oemail.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
			
				if(isValidEmailAddress(oemail.getText()))
				{
					//e..consume();
				}
				else
				{
					oemail.setText(null);
				}
			}
		});
		/*oemail.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				
			}
		});*/
		oemail.setHorizontalAlignment(SwingConstants.LEFT);
		oemail.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		oemail.setColumns(10);
		oemail.setBounds(254, 289, 178, 20);
		getContentPane().add(oemail);
		
		/*final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"LICENSE", "ADHAAR CARD", "PAN CARD", "PASSPORT"}));
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		comboBox.setBounds(254, 329, 178, 20);
		contentPane.add(comboBox);*/
		
		oproof = new JTextField();
		oproof.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char keyChar = e.getKeyChar();
			    if (Character.isLowerCase(keyChar)) {
			      e.setKeyChar(Character.toUpperCase(keyChar));
			    }
				char c=e.getKeyChar();
				if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE )|| (c==KeyEvent.VK_SPACE))
				        e.consume();
			}
		});
		oproof.setHorizontalAlignment(SwingConstants.LEFT);
		oproof.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		oproof.setColumns(10);
		oproof.setBounds(254, 329, 178, 20);
		getContentPane().add(oproof);
		
		oproofno = new JTextField();
		oproofno.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				String number=oproofno.getText();
				Pattern pattern = Pattern.compile("\\d{16}");
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
			    	  omobile.setText(null);
			      }
			}
		});
		oproofno.setHorizontalAlignment(SwingConstants.LEFT);
		oproofno.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		oproofno.setColumns(10);
		oproofno.setBounds(254, 369, 178, 20);
		getContentPane().add(oproofno);
		
		ooid = new JTextField();
		ooid.setEditable(false);
		ooid.setHorizontalAlignment(SwingConstants.LEFT);
		ooid.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		ooid.setColumns(10);
		ooid.setBounds(254, 69, 178, 20);
		getContentPane().add(ooid);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(145, 427, 365, 51);
		getContentPane().add(panel);
		
		JButton btnupdate = new JButton("Update");
		btnupdate.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\Save.png"));
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					
					/*String oprof=(String) comboBox.getSelectedItem();
					oproof.setText(oprof);*/
					
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con=DriverManager.getConnection("jdbc:odbc:mypro");
					
					Statement st=con.createStatement();
					String q1="select * from OWNER";
					ResultSet rs=st.executeQuery(q1);
					int cnt=0;
					while(rs.next())
						cnt++;
					cnt=cnt+1;
					PreparedStatement pst;
					
					String query="UPDATE OWNER SET FIRST_NAME=?,MIDDLE_NAME=?,LAST_NAME=?,MOBILE_NO=?,EMAIL_ID=?,ID_PROOF=?,ID_NO=? WHERE OWNER_ID=?";
					
					pst = con.prepareStatement(query);
					//pst.setInt(1,Integer.parseInt(foid.getSelectedItem().toString()));
					pst.setString(2,ofname.getText());
					pst.setString(3,omname.getText());
					pst.setString(4,olname.getText());
					pst.setString(5,omobile.getText());
					pst.setString(6,oemail.getText());
					pst.setString(7,oproof.getText());
					pst.setString(8,oproofno.getText());

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
					
					
				ofname.enableInputMethods(false);
				omname.enableInputMethods(false);
				olname.enableInputMethods(false);
				omobile.enableInputMethods(false);
				oemail.enableInputMethods(false);
				oproof.enableInputMethods(false);
				oproofno.enableInputMethods(false);
				ooid.enableInputMethods(false);
				
				con.close();
				}
				catch(ClassNotFoundException ce) {System.out.println("Class not found exception.");}
				catch(SQLException sqle){System.out.println(sqle);}
				catch(Exception l){System.out.println("In catch "+l);}
			
				}
		});
		btnupdate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(btnupdate);
		
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\cancel.png"));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				ofname.setText(null);
				omname.setText(null);
				olname.setText(null);
				omobile.setText(null);
				oemail.setText(null);
				oproof.setText(null);
				oproofno.setText(null);
				ooid.setText(null);
			}
		});
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(btnCancel);
		
		JLabel lblEnterOwnerDetails = new JLabel("ENTER OWNER DETAILS");
		lblEnterOwnerDetails.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblEnterOwnerDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterOwnerDetails.setBounds(101, 11, 263, 43);
		getContentPane().add(lblEnterOwnerDetails);
		
		JLabel lblOwnerId = new JLabel("Owner ID");
		lblOwnerId.setHorizontalAlignment(SwingConstants.LEFT);
		lblOwnerId.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblOwnerId.setBounds(84, 64, 73, 29);
		getContentPane().add(lblOwnerId);
		
		JLabel lblDigit = new JLabel("10 digit");
		lblDigit.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblDigit.setBounds(448, 242, 46, 14);
		contentPane.add(lblDigit);
		
		JLabel lblDigit_1 = new JLabel("16 digit");
		lblDigit_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblDigit_1.setBounds(448, 372, 46, 14);
		contentPane.add(lblDigit_1);
		
		
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");					
		Connection con = DriverManager.getConnection("jdbc:odbc:mypro");
		Statement stmt;
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("Select * from OWNER where OWNER_ID="+value);
		while(rs.next())
		{
			ooid.setText(rs.getString(1));
			ofname.setText(rs.getString(2));
			omname.setText(rs.getString(3));
			olname.setText(rs.getString(4));
			//System.out.print("value is :"+rs.getInt(1));
			omobile.setText(rs.getString(5));
			oemail.setText(rs.getString(6));
			oproof.setText(rs.getString(7));
			oproofno.setText(rs.getString(8));
			
			
			
			//System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
		}
		rs.close();
		stmt.close();
		
		
		
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnupdate,ofname, omname, olname, omobile, oemail, oproof, oproofno,  btnupdate, btnCancel, lblFirstName, lblMiddleName, lblLastName, lblMobileNumber, lblEmailId, lblIdProof, lblIdProofNumber, ooid, panel, lblEnterOwnerDetails, lblOwnerId, lblDigit, lblDigit_1}));

		}catch(Exception e){e.printStackTrace();}
	}
}
