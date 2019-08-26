import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.Vector;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.DefaultComboBoxModel;

import java.beans.PropertyChangeEvent;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;


public class payment extends JInternalFrame {

	private JPanel contentPane;
	private JTextField pid,pamount;
	//private JFormattedTextField pamount;
	private JComboBox<String> ptwhom,pvid,psid;
	private JTextArea premark;
	String message_dialog;
	String add_dialog = "Database Record Added";
	String not_dialog = "Database Record Not Added";
	double amount;
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
					payment frame = new payment();
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
			pvid.addItem(rs.getString("VENDOR_ID"));
		}
		String query2="select * from SOCIETY_STAFF";
		PreparedStatement pst2=con.prepareStatement(query2);
		ResultSet rs2=pst2.executeQuery();
		
		while(rs2.next())
		{
			psid.addItem(rs.getString("STAFF_ID"));
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
		
		
		String query2="select * from SOCIETY_STAFF";
		PreparedStatement pst2=con.prepareStatement(query2);
		ResultSet rs2=pst2.executeQuery();
		
		while(rs2.next())
		{
			psid.addItem(rs2.getString("STAFF_ID"));
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
	public payment() throws SQLException,NullPointerException {
		try
		{
		
		setTitle("Payment");
		//setMaximum(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 561, 383);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPayment = new JLabel("Payment");
		lblPayment.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblPayment.setBounds(179, 11, 95, 24);
		 getContentPane().add(lblPayment);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblId.setBounds(46, 58, 46, 14);
		 getContentPane().add(lblId);
		
		JLabel lblToWhom = new JLabel("To Whom");
		lblToWhom.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblToWhom.setBounds(46, 83, 72, 14);
		 getContentPane().add(lblToWhom);
		
		final JLabel lblVendorId = new JLabel("Vendor Id");
		lblVendorId.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblVendorId.setBounds(46, 114, 72, 14);
		 getContentPane().add(lblVendorId);
		
		final JLabel lblStaffId = new JLabel("Staff Id");
		lblStaffId.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblStaffId.setBounds(46, 143, 72, 14);
		 getContentPane().add(lblStaffId);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblAmount.setBounds(46, 170, 72, 14);
		 getContentPane().add(lblAmount);
		
		JLabel lblRemark = new JLabel("Remark");
		lblRemark.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblRemark.setBounds(46, 194, 72, 14);
		 getContentPane().add(lblRemark);
		
		ptwhom = new JComboBox<String>();
		ptwhom.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				System.out.println(ptwhom.getSelectedItem().toString());
				if(ptwhom.getSelectedItem().toString()=="SOCIETY_STAFF")
				{
					lblVendorId.setVisible(false);
					pvid.setVisible(false);
					lblStaffId.setVisible(true);
					psid.setVisible(true);
				}
				else
				{
					lblStaffId.setVisible(false);
					psid.setVisible(false);
					lblVendorId.setVisible(true);
					pvid.setVisible(true);
				}
			}
		});
		ptwhom.setModel(new DefaultComboBoxModel<String>(new String[] {"VENDOR", "SOCIETY_STAFF"}));
		ptwhom.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		ptwhom.setBounds(147, 81, 145, 20);
		 getContentPane().add(ptwhom);
		
		pid = new JTextField();
		pid.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		pid.setBounds(147, 56, 86, 20);
		 getContentPane().add(pid);
		pid.setColumns(10);
		
		premark = new JTextArea();
		premark.addKeyListener(new KeyAdapter() {


			public void keyTyped(KeyEvent e) {
				char keyChar = e.getKeyChar();
			    if (Character.isLowerCase(keyChar)) {
			      e.setKeyChar(Character.toUpperCase(keyChar));
			    }
			}
		});
		premark.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		premark.setBounds(147, 194, 145, 44);
		 getContentPane().add(premark);
		
		pvid = new JComboBox<String>();
		pvid.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		pvid.setBounds(147, 112, 84, 20);
		 getContentPane().add(pvid);
		
		psid = new JComboBox<String>();
		psid.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		psid.setBounds(147, 141, 84, 20);
		 getContentPane().add(psid);
		 
		 fillcombobox();
		 fillcombobox1();
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(102, 257, 229, 85);
		 getContentPane().add(panel);
		
		JButton padd = new JButton("Add");
		padd.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\new.png"));
		padd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				pid.enableInputMethods(true);
				pamount.enableInputMethods(true);
				ptwhom.enableInputMethods(true);
				pvid.enableInputMethods(true);
				psid.enableInputMethods(true);
				premark.enableInputMethods(true);
				
				pid.setText(null);
				pamount.setText(null);
				//ptwhom.setText(null);
				//pvid.setText(null);
				//psid.setText(null);
				premark.setText(null);

			}
		});
		padd.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(padd);
		
		JButton psave = new JButton("Save");
		psave.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\Save.png"));
		psave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:mypro");
				
				Statement st=con.createStatement();
				String q1="select * from PAYMENT";
				ResultSet rs=st.executeQuery(q1);
				int cnt=0;
				while(rs.next())
					cnt++;
				cnt=cnt+1;
				
				String q2="INSERT INTO PAYMENT (TO_WHOM,VENDOR_ID,STAFF_ID,AMOUNT,REMARK) VALUES('"+ptwhom.getSelectedItem()+"','"+pvid.getSelectedItem()+"','"+psid.getSelectedItem()+"','"+pamount.getText()+"','"+premark.getText()+"')";
				
				int rs_int=st.executeUpdate(q2);
			
			    if(rs_int>0){
			       message_dialog=""+pid.getText().toUpperCase()+"Record inserted";
			    int type_dialog = JOptionPane.PLAIN_MESSAGE;
			    JOptionPane.showMessageDialog((Component) null, message_dialog, add_dialog, type_dialog);}
			    else 
			    {message_dialog=""+pid.getText().toUpperCase()+"Record Not inserted";
			    int type_dialog = JOptionPane.PLAIN_MESSAGE;
			    JOptionPane.showMessageDialog((Component) null, message_dialog, not_dialog, type_dialog);}
			    	System.out.println("Record not inserted");
			

				pid.enableInputMethods(false);
				pamount.enableInputMethods(false);
				ptwhom.enableInputMethods(false);
				pvid.enableInputMethods(false);
				psid.enableInputMethods(false);
				premark.enableInputMethods(false);
				con.close();
			}
			catch(ClassNotFoundException ce) {System.out.println("Class not found exception.");}
			catch(SQLException sqle){System.out.println(sqle);}
			catch(Exception l){System.out.println("In catch "+l);}
		
			}
		});
		psave.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(psave);
		
		JButton pcancel = new JButton("Cancel");
		pcancel.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\cancel.png"));
		pcancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				pid.setText(null);
				pamount.setText(null);
				//ptwhom.setText(null);
				//pvid.setText(null);
				//psid.setText(null);
				premark.setText(null);
			}
		});
		pcancel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(pcancel);
		
		//amount=Double.parseDouble(pamount.getText());
		pamount = new JTextField();
		pamount.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		//pamount.setValue(new Double(amount));
		pamount.setColumns(10);
        /*pamount.addPropertyChangeListener("value", (PropertyChangeListener) this);
		pamount.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent e) {
				amount = ((Number)pamount.getValue()).doubleValue();
			}
		});*/
		pamount.setBounds(147, 168, 86, 20);
		contentPane.add(pamount);
		
		JLabel label = new JLabel("in Rupees");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label.setBounds(243, 171, 86, 14);
		contentPane.add(label);
		
		try{
			
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:mypro");
			Statement stmt = con.createStatement();
			ResultSet rs=null;
			
			String q1="select * from PAYMENT";
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
		
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{pid, ptwhom, pvid, psid, pamount, premark, padd, psave, pcancel, lblPayment, lblId, lblToWhom, lblVendorId, lblStaffId, lblAmount, lblRemark, panel, label}));
		
		}
		catch(Exception e ){}
	}
}
