import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Component;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JPanel;
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
import java.util.Vector;

import javax.swing.border.EmptyBorder;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.DefaultComboBoxModel;

import java.awt.Color;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.ImageIcon;

import org.eclipse.wb.swing.FocusTraversalOnArray;


public class helpdesk extends JInternalFrame {

	private JPanel contentPane;
	private JTextField hid,hgn;
	private JComboBox<String> hfrno,htype,hstype;
	private JTextArea hremark;
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
					helpdesk frame = new helpdesk();
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
			hfrno.addItem(rs.getString("FLAT_ROWHOUUSE_NO"));
			
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
	public helpdesk() throws SQLException,NullPointerException{
		try{
		
		setTitle("Help Desk");
		//setMaximum(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 963, 741);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHelpDesk = new JLabel("Help Desk");
		lblHelpDesk.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblHelpDesk.setBounds(123, 11, 145, 34);
		 getContentPane().add(lblHelpDesk);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(23, 73, 46, 14);
		 getContentPane().add(lblNewLabel);
		
		JLabel lblFlatRow = new JLabel("Flat / Row House Number");
		lblFlatRow.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblFlatRow.setBounds(23, 96, 163, 14);
		 getContentPane().add(lblFlatRow);
		
		JLabel lblGuestName = new JLabel("Guest Name");
		lblGuestName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblGuestName.setBounds(23, 121, 94, 14);
		 getContentPane().add(lblGuestName);
		
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblType.setBounds(23, 146, 46, 14);
		 getContentPane().add(lblType);
		
		JLabel lblRemark = new JLabel("Remark");
		lblRemark.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblRemark.setBounds(23, 202, 63, 14);
		 getContentPane().add(lblRemark);
		
		hid = new JTextField();
		hid.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		hid.setEditable(false);
		hid.setBounds(195, 71, 86, 20);
		 getContentPane().add(hid);
		hid.setColumns(10);
		
		hgn = new JTextField();
		hgn.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ))
				        e.consume();
			}
		});
		hgn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		hgn.setColumns(10);
		hgn.setBounds(195, 118, 150, 20);
		 getContentPane().add(hgn);
		
		hfrno = new JComboBox<String>();
		hfrno.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		hfrno.setBounds(196, 94, 85, 20);
		 getContentPane().add(hfrno);
		 fillcombobox();
		 
		htype = new JComboBox<String>();
		htype.setModel(new DefaultComboBoxModel<String>(new String[] {"Housekeeping", "Security", "Service", "Suggestions/Feedback"}));
		htype.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		htype.setBounds(195, 144, 150, 23);
		 getContentPane().add(htype);
		 
		hstype = new JComboBox<String>();
		hstype.setModel(new DefaultComboBoxModel<String>(new String[] {"Children Play Area", "Commom Area", "Electric/Wiring", "Exterior/Cabling", "Exterior/Walls/Paint", "Generator", "Gym", "Interior/Walls/Paint", "Interior/Wood Work", "Lifts", "Others", "Plumbing", "Sewage"}));
		hstype.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		hstype.setBounds(195, 171, 150, 20);
		getContentPane().add(hstype);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(61, 277, 303, 49);
		 getContentPane().add(panel);
		
		JButton hdadd = new JButton("Add");
		hdadd.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\new.png"));
		hdadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				hid.setText(null);
				hgn.setText(null);
				//hfrno.setText(null);
				//htype.setText(null);
				hremark.setText(null);
				
				hid.enableInputMethods(true);
				hgn.enableInputMethods(true);
				hfrno.enableInputMethods(true);
				htype.enableInputMethods(true);
				hremark.enableInputMethods(true);
			}
		});
		hdadd.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(hdadd);
		
		JButton hsave = new JButton("Save");
		hsave.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\Save.png"));
		hsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try{
					
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con=DriverManager.getConnection("jdbc:odbc:mypro");
					
					Statement st=con.createStatement();
					String q1="select * from HELP_DESK";
					ResultSet rs=st.executeQuery(q1);
					int cnt=0;
					while(rs.next())
						cnt++;
					cnt=cnt+1;
					
					String q2="INSERT INTO HELP_DESK (FLAT_ROWHOUUSE_NO,GUEST_NAME,HELP_TYPE,HELP_SUB_TYPE,REMARK) VALUES('"+hfrno.getSelectedItem()+"','"+hgn.getText()+"','"+htype.getSelectedItem()+"','"+hstype.getSelectedItem()+"','"+hremark.getText()+"')";
					
					int rs_int=st.executeUpdate(q2);
					
				    if(rs_int>0){
				       message_dialog=""+hid.getText().toUpperCase()+"Record inserted";
				    int type_dialog = JOptionPane.PLAIN_MESSAGE;
				    JOptionPane.showMessageDialog((Component) null, message_dialog, add_dialog, type_dialog);}
				    else 
				    {message_dialog=""+hid.getText().toUpperCase()+"Record Not inserted";
				    int type_dialog = JOptionPane.PLAIN_MESSAGE;
				    JOptionPane.showMessageDialog((Component) null, message_dialog, not_dialog, type_dialog);}
				    	System.out.println("Record not inserted");
				
				    	
				    	hid.enableInputMethods(false);
						hgn.enableInputMethods(false);
						hfrno.enableInputMethods(false);
						htype.enableInputMethods(false);
						hremark.enableInputMethods(false);	
				    	
						table.repaint();
						validate();
						
						con.close();
				}
				catch(ClassNotFoundException ce) {System.out.println("Class not found exception.");}
				catch(SQLException sqle){System.out.println(sqle);}
				catch(Exception l){System.out.println("In catch "+l);}
			
				
			}
		});
		hsave.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(hsave);
		
		JButton hcancel = new JButton("Cancel");
		hcancel.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\cancel.png"));
		hcancel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(hcancel);
		
		JLabel lblSubtype = new JLabel("Sub-Type");
		lblSubtype.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblSubtype.setBounds(23, 173, 107, 14);
		contentPane.add(lblSubtype);
		
		
		hremark = new JTextArea();
		hremark.setBounds(195, 199, 150, 61);
		contentPane.add(hremark);
		hremark.setBackground(new Color(255, 255, 255));
		hremark.setLineWrap(true);
		hremark.setWrapStyleWord(true);
		hremark.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		try{
			
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:mypro");
			Statement stmt = con.createStatement();
			ResultSet rs=null;
			
			String q1="select * from HELP_DESK";
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
		
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{hid, hfrno, hgn, htype, hstype, hremark, hdadd, hsave, hcancel, lblHelpDesk, lblNewLabel, lblFlatRow, lblGuestName, lblType, lblRemark, panel, lblSubtype}));
		
		}catch(Exception e){e.printStackTrace();}
	}
}
