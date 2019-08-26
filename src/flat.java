import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JInternalFrame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

import javax.swing.ImageIcon;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import com.sun.media.sound.Toolkit;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import java.awt.SystemColor;
public class flat extends JInternalFrame {

	private JPanel contentPane;
	private JTextField frno,fut,fus,fts;
	private JComboBox<String> foid,fcs;
	private JRadioButton rbtnComm,rbtnResi;
	private ButtonGroup group = new ButtonGroup();
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
					System.out.println("122");
					flat frame = new flat(5);
					frame.setVisible(true);
					System.out.println("123");
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
		
		String query="select * from OWNER";
		PreparedStatement pst=con.prepareStatement(query);
		ResultSet rs=pst.executeQuery();
		
		while(rs.next())
		{
			foid.addItem(rs.getString("OWNER_ID"));
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
	public flat() {
		try
		{
		setMaximizable(true);
		//setMaximum(true);
		setTitle("Flat");
		setClosable(true);
	
		setBounds(100, 100, 1362, 561);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 jScrollPane1 = new javax.swing.JScrollPane();
	        table = new javax.swing.JTable();
	        
	        table.setModel(new javax.swing.table.DefaultTableModel(
	                new Object [][] {
	                    {null, null, null, null},
	                    {null, null, null, null},
	                    {null, null, null, null},
	                    {null, null, null, null}
	                },
	                new String [] {
	                    "Title 1", "Title 2", "Title 3", "Title 4"
	                }
	            ));
	            jScrollPane1.setViewportView(table);
	            
	            //loadDataPrefix();
		
		JLabel lblEnterFlatDetails = new JLabel("ENTER FLAT DETAILS");
		lblEnterFlatDetails.setBounds(149, 11, 221, 34);
		lblEnterFlatDetails.setFont(new Font("Times New Roman", Font.BOLD, 20));
		 getContentPane().add(lblEnterFlatDetails);
		
		JLabel lblNewLabel = new JLabel("Flat / Row House Number");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(63, 81, 185, 17);
		 getContentPane().add(lblNewLabel);
		
		JLabel lblOwnerId = new JLabel("Owner ID");
		lblOwnerId.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblOwnerId.setBounds(63, 112, 185, 17);
		 getContentPane().add(lblOwnerId);
		
		JLabel lblUnitType = new JLabel("Unit Type");
		lblUnitType.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblUnitType.setBounds(63, 141, 185, 17);
		 getContentPane().add(lblUnitType);
		
		JLabel lblUnitSize = new JLabel("Unit Size");
		lblUnitSize.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblUnitSize.setBounds(63, 169, 185, 17);
		 getContentPane().add(lblUnitSize);
		
		JLabel lblTerraceSize = new JLabel("Terrace Size");
		lblTerraceSize.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTerraceSize.setBounds(63, 197, 185, 17);
		 getContentPane().add(lblTerraceSize);
		
		JLabel lblUsage = new JLabel("Usage");
		lblUsage.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblUsage.setBounds(63, 225, 185, 17);
		 getContentPane().add(lblUsage);
		
		JLabel lblCurrentStatus = new JLabel("Current Status");
		lblCurrentStatus.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblCurrentStatus.setBounds(63, 269, 185, 17);
		 getContentPane().add(lblCurrentStatus);
		
		frno = new JTextField();
		frno.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar(); 
				if((!(Character.isDigit(c))) && (c!='\b')) // Only digits ,backspace 
				{ 
				e.consume(); 
				}
			}
		});
		frno.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		frno.setBounds(273, 80, 86, 20);
		 getContentPane().add(frno);
		frno.setColumns(10);
		
		fut = new JTextField();
		fut.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				char keyChar = e.getKeyChar();
			    if (Character.isLowerCase(keyChar)) {
			      e.setKeyChar(Character.toUpperCase(keyChar));
			    }
				if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ))
				        e.consume();
			}
		});
		fut.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		fut.setColumns(10);
		fut.setBounds(273, 140, 86, 20);
		 getContentPane().add(fut);
		
		fus = new JTextField();
		fus.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar(); 
				if((!(Character.isDigit(c))) && (c!='\b')) // Only digits ,backspace 
				{ 
				e.consume(); 
				}
			}
		});
		fus.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		fus.setColumns(10);
		fus.setBounds(273, 168, 86, 20);
		 getContentPane().add(fus);
		
		fts = new JTextField();
		fts.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar(); 
				if((!(Character.isDigit(c))) && (c!='\b')) // Only digits ,backspace 
				{ 
				e.consume(); 
				}
			}
		});
		fts.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		fts.setColumns(10);
		fts.setBounds(273, 196, 86, 20);
		 getContentPane().add(fts);
		
		JPanel panel = new JPanel();
		panel.setBounds(217, 219, 285, 34);
		 getContentPane().add(panel);
		
		rbtnResi = new JRadioButton("RESIDENTIAL");
		rbtnResi.setSelected(true);
		panel.add(rbtnResi);
		rbtnResi.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		rbtnComm = new JRadioButton("COMMERCIAL");
		panel.add(rbtnComm);
		rbtnComm.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		group.add(rbtnResi);
		group.add(rbtnComm);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(130, 321, 353, 50);
		 getContentPane().add(panel_1);
		
		fcs = new JComboBox<String>();
		fcs.setModel(new DefaultComboBoxModel(new String[] {"BY OWNER", "ON RENT"}));
		fcs.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		fcs.setBounds(273, 267, 112, 20);
		 getContentPane().add(fcs);
		
		foid = new JComboBox<String>();
		foid.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		foid.setBounds(273, 111, 112, 20);
		 getContentPane().add(foid);
		 fillcombobox();
		
		JButton fadd = new JButton("Add");
		fadd.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\new.png"));
		fadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frno.setText(null);
				fut.setText(null);
				fus.setText(null);
				fts.setText(null);
				
				frno.enableInputMethods(true);
				fut.enableInputMethods(true);
				fus.enableInputMethods(true);
				fts.enableInputMethods(true);
				foid.enableInputMethods(true);
				fcs.enableInputMethods(true);
				rbtnResi.enableInputMethods(true);	
				rbtnComm.enableInputMethods(true);
			}
		});
		fadd.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_1.add(fadd);
		
		JButton fsave = new JButton("Save");
		fsave.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\Save.png"));
		fsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con=DriverManager.getConnection("jdbc:odbc:mypro");
					
					Statement st=con.createStatement();
					String q1="select * from FLAT";
					ResultSet rs=st.executeQuery(q1);
					int cnt=0;
					while(rs.next())
						cnt++;
					cnt=cnt+1;
					
					String q2="INSERT INTO FLAT (OWNER_ID,FLAT_ROWHOUSE_NO,UNIT_TYPE,UNIT_SIZE,TERRACE_SIZE,CURRENT_STATUS) VALUES('"+foid.getSelectedItem()+"','"+frno.getText()+"','"+fut.getText()+"','"+fus.getText()+"','"+fts.getText()+"','"+fcs.getSelectedItem()+"')";
					//,USAGE  ,'"+group.getButtonCount()+"'
					int rs_int=st.executeUpdate(q2);
					
				    if(rs_int>0){
				       message_dialog=""+frno.getText().toUpperCase()+"Record inserted";
				    int type_dialog = JOptionPane.PLAIN_MESSAGE;
				    JOptionPane.showMessageDialog((Component) null, message_dialog, add_dialog, type_dialog);}
				    else 
				    {message_dialog=""+frno.getText().toUpperCase()+"Record Not inserted";
				    int type_dialog = JOptionPane.PLAIN_MESSAGE;
				    JOptionPane.showMessageDialog((Component) null, message_dialog, not_dialog, type_dialog);}
				    	System.out.println("Record not inserted");
				
				    	frno.enableInputMethods(false);
						fut.enableInputMethods(false);
						fus.enableInputMethods(false);
						fts.enableInputMethods(false);
						foid.enableInputMethods(false);
						fcs.enableInputMethods(false);
						rbtnResi.enableInputMethods(false);	
						rbtnComm.enableInputMethods(false);
						
						table.repaint();
						validate();
						
						con.close();
				
				}
				catch(ClassNotFoundException ce) {System.out.println("Class not found exception.");}
				catch(SQLException sqle){System.out.println(sqle);}
				catch(Exception l){System.out.println("In catch "+l);}
			
			}
		});
		fsave.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_1.add(fsave);
		
		JButton fcancel = new JButton("Cancel");
		fcancel.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\cancel.png"));
		fcancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				frno.setText(null);
				fut.setText(null);
				fus.setText(null);
				fts.setText(null);
			}
		});
		fcancel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_1.add(fcancel);
		
		/*JButton faddfm = new JButton("Go To Add Flat Member");
		faddfm.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\goto.png"));
		faddfm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					
				flatmember so=new flatmember();
				
				so.getContentPane().setLayout(new BorderLayout(1,1));
				System.out.println("clicked");
				contentPane.add(so);
				so.setVisible(true);
				so.setSelected(true);
				so.toFront();
				so.repaint();
				so.setMaximum(true);
				}catch(Exception e1){
					System.out.println("clicked"+e1);
				}			
				}			
		});
		faddfm.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_1.add(faddfm);*/
		
		JLabel lblMeters = new JLabel("meters");
		lblMeters.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblMeters.setBounds(369, 170, 61, 17);
		contentPane.add(lblMeters);
		
		JLabel label = new JLabel("meters");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label.setBounds(369, 198, 61, 17);
		contentPane.add(label);
		
		
		
		try{
			
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:mypro");
			Statement stmt = con.createStatement();
			ResultSet rs=null;
			
			String q1="select * from FLAT";
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
		tablePanel.setForeground(SystemColor.activeCaption);
		
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
		
		
		
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{tablePanel,table,frno, foid, fut, fus, fts, rbtnResi, rbtnComm, fcs, fadd, fsave, fcancel, lblEnterFlatDetails, lblNewLabel, lblOwnerId, lblUnitType, lblUnitSize, lblTerraceSize, lblUsage, lblCurrentStatus, panel, panel_1, lblMeters, label}));
		}
		catch(Exception e){}
		
	}
	
	

public flat(final int flatno) 
{
	try
	{
		
		
		setVisible(true);
	    
	     setSize(900, 600);
	     System.out.println("11");
	     repaint();
	//setBounds(100, 100, 1021, 465);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(204, 204, 255));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	 
	
	JLabel lblEnterFlatDetails = new JLabel("ENTER FLAT DETAILS");
	lblEnterFlatDetails.setBounds(149, 11, 221, 34);
	lblEnterFlatDetails.setFont(new Font("Times New Roman", Font.BOLD, 20));
	 getContentPane().add(lblEnterFlatDetails);
	
	JLabel lblNewLabel = new JLabel("Flat / Row House Number");
	lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
	lblNewLabel.setBounds(63, 81, 185, 17);
	 getContentPane().add(lblNewLabel);
	
	JLabel lblOwnerId = new JLabel("Owner ID");
	lblOwnerId.setFont(new Font("Times New Roman", Font.BOLD, 14));
	lblOwnerId.setBounds(63, 112, 185, 17);
	 getContentPane().add(lblOwnerId);
	
	JLabel lblUnitType = new JLabel("Unit Type");
	lblUnitType.setFont(new Font("Times New Roman", Font.BOLD, 14));
	lblUnitType.setBounds(63, 141, 185, 17);
	 getContentPane().add(lblUnitType);
	
	JLabel lblUnitSize = new JLabel("Unit Size");
	lblUnitSize.setFont(new Font("Times New Roman", Font.BOLD, 14));
	lblUnitSize.setBounds(63, 169, 185, 17);
	 getContentPane().add(lblUnitSize);
	
	JLabel lblTerraceSize = new JLabel("Terrace Size");
	lblTerraceSize.setFont(new Font("Times New Roman", Font.BOLD, 14));
	lblTerraceSize.setBounds(63, 197, 185, 17);
	 getContentPane().add(lblTerraceSize);
	
	JLabel lblUsage = new JLabel("Usage");
	lblUsage.setFont(new Font("Times New Roman", Font.BOLD, 14));
	lblUsage.setBounds(63, 225, 185, 17);
	 getContentPane().add(lblUsage);
	
	JLabel lblCurrentStatus = new JLabel("Current Status");
	lblCurrentStatus.setFont(new Font("Times New Roman", Font.BOLD, 14));
	lblCurrentStatus.setBounds(63, 269, 185, 17);
	 getContentPane().add(lblCurrentStatus);
	
	frno = new JTextField();
	frno.addKeyListener(new KeyAdapter() {
		public void keyTyped(KeyEvent e) {
			char c = e.getKeyChar(); 
			if((!(Character.isDigit(c))) && (c!='\b')) // Only digits ,backspace 
			{ 
			e.consume(); 
			}
		}
	});
	frno.setFont(new Font("Times New Roman", Font.PLAIN, 14));
	frno.setBounds(273, 80, 86, 20);
	 getContentPane().add(frno);
	frno.setColumns(10);
	
	fut = new JTextField();
	fut.addKeyListener(new KeyAdapter() {
		public void keyTyped(KeyEvent e) {
			char c=e.getKeyChar();
			char keyChar = e.getKeyChar();
		    if (Character.isLowerCase(keyChar)) {
		      e.setKeyChar(Character.toUpperCase(keyChar));
		    }
			if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ))
			        e.consume();
		}
	});
	fut.setFont(new Font("Times New Roman", Font.PLAIN, 14));
	fut.setColumns(10);
	fut.setBounds(273, 140, 86, 20);
	 getContentPane().add(fut);
	
	fus = new JTextField();
	fus.addKeyListener(new KeyAdapter() {
		public void keyTyped(KeyEvent e) {
			char c = e.getKeyChar(); 
			if((!(Character.isDigit(c))) && (c!='\b')) // Only digits ,backspace 
			{ 
			e.consume(); 
			}
		}
	});
	fus.setFont(new Font("Times New Roman", Font.PLAIN, 14));
	fus.setColumns(10);
	fus.setBounds(273, 168, 86, 20);
	 getContentPane().add(fus);
	
	fts = new JTextField();
	fts.addKeyListener(new KeyAdapter() {
		public void keyTyped(KeyEvent e) {
			char c = e.getKeyChar(); 
			if((!(Character.isDigit(c))) && (c!='\b')) // Only digits ,backspace 
			{ 
			e.consume(); 
			}
		}
	});
	fts.setFont(new Font("Times New Roman", Font.PLAIN, 14));
	fts.setColumns(10);
	fts.setBounds(273, 196, 86, 20);
	 getContentPane().add(fts);
	
	JPanel panel = new JPanel();
	panel.setBackground(new Color(204, 204, 255));
	panel.setBounds(217, 219, 285, 34);
	 getContentPane().add(panel);
	
	rbtnResi = new JRadioButton("RESIDENTIAL");
	rbtnResi.setSelected(true);
	panel.add(rbtnResi);
	rbtnResi.setFont(new Font("Times New Roman", Font.PLAIN, 14));
	
	rbtnComm = new JRadioButton("COMMERCIAL");
	panel.add(rbtnComm);
	rbtnComm.setFont(new Font("Times New Roman", Font.PLAIN, 14));
	
	group.add(rbtnResi);
	group.add(rbtnComm);
	
	JPanel panel_1 = new JPanel();
	panel_1.setBackground(new Color(204, 204, 255));
	panel_1.setBounds(130, 321, 353, 50);
	 getContentPane().add(panel_1);
	
	fcs = new JComboBox<String>();
	fcs.setModel(new DefaultComboBoxModel(new String[] {"BY OWNER", "ON RENT"}));
	fcs.setFont(new Font("Times New Roman", Font.PLAIN, 14));
	fcs.setBounds(273, 267, 112, 20);
	 getContentPane().add(fcs);
	
	foid = new JComboBox<String>();
	foid.setFont(new Font("Times New Roman", Font.PLAIN, 14));
	foid.setBounds(273, 111, 112, 20);
	 getContentPane().add(foid);
	 System.out.println("comobo");
	 fillcombobox();
	
	
	 JButton fupdate = new JButton("Update");
	 //fupdate.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\Save.png"));
	 fupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con=DriverManager.getConnection("jdbc:odbc:mypro");
					
					Statement st=con.createStatement();
					String q1="select * from FLAT";
					ResultSet rs=st.executeQuery(q1);
					int cnt=0;
					while(rs.next())
						cnt++;
					cnt=cnt+1;
					
					PreparedStatement pst;
					String query = "Update FLAT set OWNER_ID=?, FLAT_ROWHOUSE_NO=?, UNIT_TYPE=?, UNIT_SIZE=?, TERRACE_SIZE=?, USAGE=?, CURRENT_STATUS=? where FLAT_ROWHOUSE_NO="+flatno;
					
					pst = con.prepareStatement(query);
					pst.setInt(1,Integer.parseInt(foid.getSelectedItem().toString()));
					pst.setString(2,frno.getText());
					pst.setString(3,fut.getText());
					pst.setInt(4,Integer.parseInt(fus.getText().toString()));
					pst.setInt(5,Integer.parseInt(fts.getText().toString()));
					if(rbtnResi.isSelected()){pst.setString(6,rbtnResi.getText());}
					else if(rbtnComm.isSelected()){pst.setString(6,rbtnComm.getText());}
					pst.setString(7,fcs.getSelectedItem().toString());

					int result = pst.executeUpdate();
					
					
				    if(result == 1){
				       message_dialog=""+frno.getText().toUpperCase()+"Record updated";
				    int type_dialog = JOptionPane.PLAIN_MESSAGE;
				    JOptionPane.showMessageDialog((Component) null, message_dialog, add_dialog, type_dialog);}
				    else 
				    {message_dialog=""+frno.getText().toUpperCase()+"Record Not updated";
				    int type_dialog = JOptionPane.PLAIN_MESSAGE;
				    JOptionPane.showMessageDialog((Component) null, message_dialog, not_dialog, type_dialog);}
				    	System.out.println("Record not updated");
				
				    	frno.enableInputMethods(false);
						fut.enableInputMethods(false);
						fus.enableInputMethods(false);
						fts.enableInputMethods(false);
						foid.enableInputMethods(false);
						fcs.enableInputMethods(false);
						rbtnResi.enableInputMethods(false);	
						rbtnComm.enableInputMethods(false);
						
						con.close();
				
				}
				catch(ClassNotFoundException ce) {System.out.println("Class not found exception.");}
				catch(SQLException sqle){System.out.println(sqle);}
				catch(Exception l){System.out.println("In catch "+l);}
			
			}
		});
	 fupdate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_1.add(fupdate);
	
	
	JButton fcancel = new JButton("Cancel");
	fcancel.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\cancel.png"));
	fcancel.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			dispose();
			frno.setText(null);
			fut.setText(null);
			fus.setText(null);
			fts.setText(null);
		}
	});
	fcancel.setFont(new Font("Times New Roman", Font.BOLD, 14));
	panel_1.add(fcancel);
	
	
	JLabel lblMeters = new JLabel("meters");
	lblMeters.setFont(new Font("Times New Roman", Font.PLAIN, 12));
	lblMeters.setBounds(369, 170, 61, 17);
	contentPane.add(lblMeters);
	
	JLabel label = new JLabel("meters");
	label.setFont(new Font("Times New Roman", Font.PLAIN, 12));
	label.setBounds(369, 198, 61, 17);
	contentPane.add(label);
	
	
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");					
	Connection con = DriverManager.getConnection("jdbc:odbc:mypro");
	Statement stmt;
	stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery("Select * from FLAT where FLAT_ROWHOUSE_NO="+flatno);
	while(rs.next())
	{
		frno.setText(rs.getString(2));
		//System.out.print("value is :"+rs.getInt(1));
		foid.setSelectedItem(rs.getInt(1));
		String s=rs.getString(3);
		fut.setText(s);
		fus.setText(rs.getString(4));
		fts.setText(rs.getString(5));
		
		
		String a;
		a=rs.getString(7);
		
		if(a=="RESIDENTIAL"){rbtnResi.setSelected(true);rbtnComm.setSelected(false);}
		if(a=="COMMERCIAL"){rbtnComm.setSelected(true);rbtnResi.setSelected(false);}
		
		fcs.setSelectedItem(rs.getString(7));
		
		//System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
	}
	rs.close();
	stmt.close();
	
	
	
	contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{frno, foid, fut, fus, fts, rbtnResi, rbtnComm, fcs,  fcancel, lblEnterFlatDetails, lblNewLabel, lblOwnerId, lblUnitType, lblUnitSize, lblTerraceSize, lblUsage, lblCurrentStatus, panel, panel_1, lblMeters, label}));
	}
	catch(Exception e){}
	
}

 
}
