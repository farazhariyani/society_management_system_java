import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JRadioButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.text.PlainDocument;
import javax.swing.JInternalFrame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
public class flatmember extends JInternalFrame {

	private JPanel contentPane;
	private JTextField fmrm,fmmno,fmemid,fmidp,fmidpno;
	private JComboBox<String> fmfrn,fmten;
	private JRadioButton fmRowHouse,fmFlat,fmnyes,fmnno;
	private ButtonGroup group = new ButtonGroup();
	private ButtonGroup group2 = new ButtonGroup();
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
					flatmember frame = new flatmember();
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
			fmfrn.addItem(rs.getString("FLAT_ROWHOUSE_NO"));
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
	
	public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile

(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
 }
	/**
	 * Create the frame.
	 */
	public flatmember() throws SQLException,NullPointerException{
		try{
		
		setTitle("Flat Member");
		//setMaximum(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 1364, 1010);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JLabel lblEnterFlatMember = new JLabel("Enter Flat Member Details");
		lblEnterFlatMember.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblEnterFlatMember.setBounds(97, 11, 264, 24);
		 getContentPane().add(lblEnterFlatMember);
		
		JLabel lblNewLabel = new JLabel("Flat / Row House Number");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(21, 56, 164, 24);
		 getContentPane().add(lblNewLabel);
		
		fmfrn = new JComboBox<String>();
		fmfrn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		fmfrn.setBounds(217, 59, 94, 20);
		 getContentPane().add(fmfrn);
		
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblType.setBounds(21, 90, 164, 24);
		 getContentPane().add(lblType);
		
		JLabel lblResidenntName = new JLabel("Resident Name");
		lblResidenntName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblResidenntName.setBounds(21, 127, 164, 24);
		 getContentPane().add(lblResidenntName);
		
		JLabel lblMobileNumber = new JLabel("Mobile Number");
		lblMobileNumber.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblMobileNumber.setBounds(21, 163, 164, 24);
		 getContentPane().add(lblMobileNumber);
		
		JLabel lblEmailId = new JLabel("E-Mail ID");
		lblEmailId.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblEmailId.setBounds(21, 200, 164, 24);
		 getContentPane().add(lblEmailId);
		
		JLabel lblIdProof = new JLabel("ID Proof");
		lblIdProof.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblIdProof.setBounds(21, 237, 164, 24);
		 getContentPane().add(lblIdProof);
		
		JLabel lblIdProofNumber = new JLabel("ID Proof Number");
		lblIdProofNumber.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblIdProofNumber.setBounds(21, 272, 164, 24);
		 getContentPane().add(lblIdProofNumber);
		
		JLabel lblNotaryFiled = new JLabel("Notary Filed");
		lblNotaryFiled.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNotaryFiled.setBounds(21, 346, 164, 24);
		 getContentPane().add(lblNotaryFiled);
		
		fmrm = new JTextField();
		fmrm.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char keyChar = e.getKeyChar();
			    if (Character.isLowerCase(keyChar)) {
			      e.setKeyChar(Character.toUpperCase(keyChar));
			    }
				char c=e.getKeyChar();
				if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ))
				{   
					e.consume();
				}
			}
		});
		fmrm.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		fmrm.setBounds(217, 130, 214, 20);
		 getContentPane().add(fmrm);
		fmrm.setColumns(10);
		
		fmmno = new JTextField();
		PlainDocument doc = (PlainDocument) fmmno.getDocument();
	      doc.setDocumentFilter(new TextLengthDocFilter(10));
		fmmno.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				  if((Character.isAlphabetic(c) ||  (c==KeyEvent.VK_SPACE)))
			      {
			    	  fmmno.setText("0");
			      }
			}
		});
		fmmno.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		fmmno.setColumns(10);
		fmmno.setBounds(217, 166, 214, 20);
		 getContentPane().add(fmmno);
		
		fmemid = new JTextField();
		fmemid.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				
				if(!isValidEmailAddress(fmemid.getText()))
					 {
				 		fmemid.setText(null);
					 }
			}
		});
		fmemid.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		fmemid.setColumns(10);
		fmemid.setBounds(217, 203, 214, 20);
		 getContentPane().add(fmemid);
		
		fmidp = new JTextField();
		fmidp.addKeyListener(new KeyAdapter() {
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
		fmidp.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		fmidp.setColumns(10);
		fmidp.setBounds(217, 240, 214, 20);
		 getContentPane().add(fmidp);
		
		fmidpno = new JTextField();
		fmidpno.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				String number=fmidpno.getText();
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
			    	  fmidpno.setText("0");
			      }
			}
		});
		fmidpno.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		fmidpno.setColumns(10);
		fmidpno.setBounds(217, 275, 214, 20);
		 getContentPane().add(fmidpno);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(217, 90, 196, 29);
		 getContentPane().add(panel);
		
		fmFlat = new JRadioButton("Flat");
		fmFlat.setSelected(true);
		fmFlat.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(fmFlat);
		
		fmRowHouse = new JRadioButton("Row House");
		fmRowHouse.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(fmRowHouse);
		
		group.add(fmFlat);
		group.add(fmRowHouse);
		panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{fmFlat, fmRowHouse}));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(217, 337, 196, 33);
		 getContentPane().add(panel_1);
		
		fmnyes = new JRadioButton("Yes");
		fmnyes.setSelected(true);
		fmnyes.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_1.add(fmnyes);
		
		fmnno = new JRadioButton("No");
		fmnno.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_1.add(fmnno);
		
		group2.add(fmnyes);
		group2.add(fmnno);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(86, 390, 327, 48);
		 getContentPane().add(panel_2);
		
		fmten = new JComboBox<String>();
		fmten.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"}));
		fmten.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		fmten.setBounds(217, 310, 94, 20);
		 getContentPane().add(fmten);
		
		 
		 
		JButton btnAdd = new JButton("Add");
		btnAdd.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\new.png"));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				fmrm.enableInputMethods(true);
		    	fmmno.enableInputMethods(true);
		    	fmemid.enableInputMethods(true);
		    	fmidp.enableInputMethods(true);
		    	fmidpno.enableInputMethods(true);
		    	fmfrn.enableInputMethods(true);
		    	fmten.enableInputMethods(true);
		    	fmRowHouse.enableInputMethods(true);
		    	fmFlat.enableInputMethods(true);
		    	fmnyes.enableInputMethods(true);
		    	fmnno.enableInputMethods(true);
		    	//group.enableInputMethods(true);
		    	//group2.enableInputMethods(true);
		   fillcombobox();
			}
		});
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_2.add(btnAdd);
		
		JButton fmsave = new JButton("Save");
		fmsave.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\Save.png"));
		fmsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
try{
					
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con=DriverManager.getConnection("jdbc:odbc:mypro");
					
					Statement st=con.createStatement();
					String q1="select * from FLAT_MEMBER";
					ResultSet rs=st.executeQuery(q1);
					int cnt=0;
					while(rs.next())
						cnt++;
					cnt=cnt+1;
					
					String q2="INSERT INTO FLAT_MEMBER (FLAT_ROWHOUSE_NO,TYPE,RESIDENT_NAME,MOBILE_NO,EMAIL_ID,ID_PROOF,ID_NO,TENURE,NOTARY_FILED) VALUES('"+fmfrn.getSelectedItem()+"','"+group.getButtonCount()+"','"+fmrm.getText()+"','"+fmmno.getText()+"','"+fmemid.getText()+"','"+fmidp.getText()+"','"+fmidpno.getText()+"','"+fmten.getSelectedItem()+"','"+group2.getButtonCount()+"')";
					
					int rs_int=st.executeUpdate(q2);
					
				    if(rs_int>0){
				       message_dialog=""+fmrm.getText().toUpperCase()+"Record inserted";
				    int type_dialog = JOptionPane.PLAIN_MESSAGE;
				    JOptionPane.showMessageDialog((Component) null, message_dialog, add_dialog, type_dialog);}
				    else 
				    {message_dialog=""+fmrm.getText().toUpperCase()+"Record Not inserted";
				    int type_dialog = JOptionPane.PLAIN_MESSAGE;
				    JOptionPane.showMessageDialog((Component) null, message_dialog, not_dialog, type_dialog);}
				    	System.out.println("Record not inserted");
				
				    	fmrm.enableInputMethods(false);
				    	fmmno.enableInputMethods(false);
				    	fmemid.enableInputMethods(false);
				    	fmidp.enableInputMethods(false);
				    	fmidpno.enableInputMethods(false);
				    	fmfrn.enableInputMethods(false);
				    	fmten.enableInputMethods(false);
				    	fmRowHouse.enableInputMethods(false);
				    	fmFlat.enableInputMethods(false);
				    	fmnyes.enableInputMethods(false);
				    	fmnno.enableInputMethods(false);
				    	//group.enableInputMethods(false);
				    	//group2.enableInputMethods(false);

				    	table.repaint();
				    	validate();

				    	
				    	con.close();
				}
				catch(ClassNotFoundException ce) {System.out.println("Class not found exception.");}
				catch(SQLException sqle){System.out.println(sqle);}
				catch(Exception l){System.out.println("In catch "+l);}

			}
		});

		fmsave.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_2.add(fmsave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\cancel.png"));
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_2.add(btnCancel);
		
		JLabel lblTenure = new JLabel("Tenure");
		lblTenure.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTenure.setBounds(21, 307, 164, 24);
		 getContentPane().add(lblTenure);
		
		JLabel lblMonths = new JLabel("Month(s)");
		lblMonths.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblMonths.setBounds(316, 306, 164, 24);
		 getContentPane().add(lblMonths);
		 
		 JLabel label = new JLabel("10 digits");
		 label.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		 label.setBounds(441, 169, 46, 14);
		 contentPane.add(label);
		 
		 JLabel lblDigits = new JLabel("16 digits");
		 lblDigits.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		 lblDigits.setBounds(441, 278, 46, 14);
		 contentPane.add(lblDigits);
		 
		 try{
				
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:mypro");
				Statement stmt = con.createStatement();
				ResultSet rs=null;
				
				String q1="select * from FLAT_MEMBER";
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
			
			DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		    //dtm.setRowCount(10);
			validate();
			
			getContentPane().repaint();
			table.repaint();
				
			}catch(Exception e){e.printStackTrace();}
		 
		 
		 contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{fmfrn, fmFlat, fmRowHouse, fmrm, fmmno, fmemid, fmidp, fmidpno, fmten, fmnyes, fmnno, btnAdd, fmsave, btnCancel, lblType, lblNewLabel, lblResidenntName, lblMobileNumber, lblEnterFlatMember, lblEmailId, lblIdProof, lblIdProofNumber, lblNotaryFiled, panel, panel_1, panel_2, lblTenure, lblMonths, label, lblDigits}));
	}catch(Exception e)
	{e.printStackTrace();}
		}
	
	
	public flatmember(int value) throws SQLException,NullPointerException{
		try{
		
		setTitle("Flat Member");
		//setMaximum(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 584, 484);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JLabel lblEnterFlatMember = new JLabel("Enter Flat Member Details");
		lblEnterFlatMember.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblEnterFlatMember.setBounds(97, 11, 264, 24);
		 getContentPane().add(lblEnterFlatMember);
		
		JLabel lblNewLabel = new JLabel("Flat / Row Hoouse Number");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(21, 56, 164, 24);
		 getContentPane().add(lblNewLabel);
		
		fmfrn = new JComboBox<String>();
		fmfrn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		fmfrn.setBounds(217, 59, 94, 20);
		 getContentPane().add(fmfrn);
		
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblType.setBounds(21, 90, 164, 24);
		 getContentPane().add(lblType);
		
		JLabel lblResidenntName = new JLabel("Resident Name");
		lblResidenntName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblResidenntName.setBounds(21, 127, 164, 24);
		 getContentPane().add(lblResidenntName);
		
		JLabel lblMobileNumber = new JLabel("Mobile Number");
		lblMobileNumber.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblMobileNumber.setBounds(21, 163, 164, 24);
		 getContentPane().add(lblMobileNumber);
		
		JLabel lblEmailId = new JLabel("E-Mail ID");
		lblEmailId.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblEmailId.setBounds(21, 200, 164, 24);
		 getContentPane().add(lblEmailId);
		
		JLabel lblIdProof = new JLabel("ID Proof");
		lblIdProof.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblIdProof.setBounds(21, 237, 164, 24);
		 getContentPane().add(lblIdProof);
		
		JLabel lblIdProofNumber = new JLabel("ID Proof Number");
		lblIdProofNumber.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblIdProofNumber.setBounds(21, 272, 164, 24);
		 getContentPane().add(lblIdProofNumber);
		
		JLabel lblNotaryFiled = new JLabel("Notary Filed");
		lblNotaryFiled.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNotaryFiled.setBounds(21, 346, 164, 24);
		 getContentPane().add(lblNotaryFiled);
		
		fmrm = new JTextField();
		fmrm.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char keyChar = e.getKeyChar();
			    if (Character.isLowerCase(keyChar)) {
			      e.setKeyChar(Character.toUpperCase(keyChar));
			    }
				char c=e.getKeyChar();
				if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ))
				{   
					e.consume();
				}
			}
		});
		fmrm.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		fmrm.setBounds(217, 130, 214, 20);
		 getContentPane().add(fmrm);
		fmrm.setColumns(10);
		
		fmmno = new JTextField();
		PlainDocument doc = (PlainDocument) fmmno.getDocument();
	      doc.setDocumentFilter(new TextLengthDocFilter(10));
		fmmno.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				  if((Character.isAlphabetic(c) ||  (c==KeyEvent.VK_SPACE)))
			      {
			    	  fmmno.setText("0");
			      }
			}
		});
		fmmno.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		fmmno.setColumns(10);
		fmmno.setBounds(217, 166, 214, 20);
		 getContentPane().add(fmmno);
		
		fmemid = new JTextField();
		fmemid.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				
				if(!isValidEmailAddress(fmemid.getText()))
					 {
				 		fmemid.setText(null);
					 }
			}
		});
		fmemid.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		fmemid.setColumns(10);
		fmemid.setBounds(217, 203, 214, 20);
		 getContentPane().add(fmemid);
		
		fmidp = new JTextField();
		fmidp.addKeyListener(new KeyAdapter() {
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
		fmidp.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		fmidp.setColumns(10);
		fmidp.setBounds(217, 240, 214, 20);
		 getContentPane().add(fmidp);
		
		fmidpno = new JTextField();
		fmidpno.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				String number=fmidpno.getText();
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
			    	  fmidpno.setText("0");
			      }
			}
		});
		fmidpno.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		fmidpno.setColumns(10);
		fmidpno.setBounds(217, 275, 214, 20);
		 getContentPane().add(fmidpno);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(217, 90, 196, 29);
		 getContentPane().add(panel);
		
		fmFlat = new JRadioButton("Flat");
		fmFlat.setSelected(true);
		fmFlat.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(fmFlat);
		
		fmRowHouse = new JRadioButton("Row House");
		fmRowHouse.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(fmRowHouse);
		
		group.add(fmFlat);
		group.add(fmRowHouse);
		panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{fmFlat, fmRowHouse}));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 204, 255));
		panel_1.setBounds(217, 337, 196, 33);
		 getContentPane().add(panel_1);
		
		fmnyes = new JRadioButton("Yes");
		fmnyes.setSelected(true);
		fmnyes.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_1.add(fmnyes);
		
		fmnno = new JRadioButton("No");
		fmnno.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_1.add(fmnno);
		
		group2.add(fmnyes);
		group2.add(fmnno);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 204, 255));
		panel_2.setBounds(86, 390, 327, 48);
		 getContentPane().add(panel_2);
		
		fmten = new JComboBox<String>();
		fmten.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"}));
		fmten.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		fmten.setBounds(217, 310, 94, 20);
		 getContentPane().add(fmten);
		
		 
		 
		
		
		JButton fmupdate = new JButton("Update");
		fmupdate.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\Save.png"));
		fmupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
try{
					
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con=DriverManager.getConnection("jdbc:odbc:mypro");
					
					Statement st=con.createStatement();
					String q1="select * from FLAT_MEMBER";
					ResultSet rs=st.executeQuery(q1);
					int cnt=0;
					while(rs.next())
						cnt++;
					cnt=cnt+1;
					PreparedStatement pst;
					
					String query="UPDATE FLAT_MEMBER SET FLAT_ROWHOUSE_NO=?,TYPE=?,RESIDENT_NAME=?,MOBILE_NO=?,EMAIL_ID=?,ID_PROOF=?,ID_NO=?,TENURE=?,NOTARY_FILED=? WHERE FLAT_ROWHOUSE_NO=?";
					pst = con.prepareStatement(query);
					pst.setInt(1,Integer.parseInt(fmfrn.getSelectedItem().toString()));
					if(fmFlat.isSelected()){pst.setString(2,fmFlat.getText());}
					else if(fmRowHouse.isSelected()){pst.setString(2,fmRowHouse.getText());}
					pst.setString(3,fmrm.getText());
					pst.setString(4,fmmno.getText());
					pst.setString(5,fmemid.getText());
					pst.setString(6,fmidp.getText());
					pst.setString(7,fmidpno.getText());
					pst.setString(8,fmten.getSelectedItem().toString());
					if(fmnyes.isSelected()){pst.setString(9,fmnyes.getText());}
					else if(fmnno.isSelected()){pst.setString(9,fmnno.getText());}
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
				
				    	fmrm.enableInputMethods(false);
				    	fmmno.enableInputMethods(false);
				    	fmemid.enableInputMethods(false);
				    	fmidp.enableInputMethods(false);
				    	fmidpno.enableInputMethods(false);
				    	fmfrn.enableInputMethods(false);
				    	fmten.enableInputMethods(false);
				    	fmRowHouse.enableInputMethods(false);
				    	fmFlat.enableInputMethods(false);
				    	fmnyes.enableInputMethods(false);
				    	fmnno.enableInputMethods(false);
				    	//group.enableInputMethods(false);
				    	//group2.enableInputMethods(false);

				    	con.close();
				}
				catch(ClassNotFoundException ce) {System.out.println("Class not found exception.");}
				catch(SQLException sqle){System.out.println(sqle);}
				catch(Exception l){System.out.println("In catch "+l);}

			}
		});

		fmupdate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_2.add(fmupdate);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\cancel.png"));
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_2.add(btnCancel);
		
		JLabel lblTenure = new JLabel("Tenure");
		lblTenure.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTenure.setBounds(21, 307, 164, 24);
		 getContentPane().add(lblTenure);
		
		JLabel lblMonths = new JLabel("Month(s)");
		lblMonths.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblMonths.setBounds(316, 306, 164, 24);
		 getContentPane().add(lblMonths);
		 
		 JLabel label = new JLabel("10 digits");
		 label.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		 label.setBounds(441, 169, 46, 14);
		 contentPane.add(label);
		 
		 JLabel lblDigits = new JLabel("16 digits");
		 lblDigits.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		 lblDigits.setBounds(441, 278, 46, 14);
		 contentPane.add(lblDigits);
		 
		 
		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");					
			Connection con = DriverManager.getConnection("jdbc:odbc:mypro");
			Statement stmt;
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from FLAT_MEMBER where FLAT_ROWHOUSE_NO="+value);
			while(rs.next())
			{
				fmrm.setText(rs.getString(1));
				String a,b;
				a=rs.getString(2);
				if(a=="Flat"){fmFlat.setSelected(true);fmRowHouse.setSelected(false);}
				if(a=="Row House"){fmRowHouse.setSelected(true);fmFlat.setSelected(false);}
				//System.out.print("value is :"+rs.getInt(1));
				
				fmrm.setText(rs.getString(3));
				//String s=rs.getString(3);
				fmmno.setText(rs.getString(4));
				fmemid.setText(rs.getString(5));
				fmidp.setText(rs.getString(6));
				fmidpno.setText(rs.getString(7));
				fmten.setSelectedItem(rs.getString(8));
				b=rs.getString(9);
				if(a=="Yes"){fmnyes.setSelected(true);fmnno.setSelected(false);}
				if(a=="No"){fmnno.setSelected(true);fmnyes.setSelected(false);}
				
				//System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}
			rs.close();
			stmt.close();
		 
		 
		 
		 
		 contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{fmfrn, fmFlat, fmRowHouse, fmrm, fmmno, fmemid, fmidp, fmidpno, fmten, fmnyes, fmnno, fmupdate, btnCancel, lblType, lblNewLabel, lblResidenntName, lblMobileNumber, lblEnterFlatMember, lblEmailId, lblIdProof, lblIdProofNumber, lblNotaryFiled, panel, panel_1, panel_2, lblTenure, lblMonths, label, lblDigits}));
		
		}catch(Exception e)
	{e.printStackTrace();}
		}

}
