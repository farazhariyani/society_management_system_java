import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JButton;

import org.jdesktop.swingx.JXDatePicker;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JInternalFrame;

import java.awt.Color;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import javax.swing.ImageIcon;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class receipt extends JInternalFrame {

	private JPanel contentPane;
	private JTextField rid,txtDate,ramt;
	//private JFormattedTextField ramt;
	private JXDatePicker sregdt;
	private JButton btnNewButton;
	private JComboBox<String> rfrn,rtype;
	private JTextArea rremark;
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
					receipt frame = new receipt();
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
			rfrn.addItem(rs.getString("FLAT_ROWHOUSE_NO"));
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
	public receipt() throws SQLException,NullPointerException{
		try{
		
		setTitle("Receipt");
		//setMaximum(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 543, 472);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//create text field
		txtDate = new JTextField();
		//set bounds of text field
		txtDate.setBounds(235,153,93,20);
		//add text field to contentPane
		contentPane.add(txtDate);
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
		btnNewButton.setBounds(330,153,17,20);//+107
		//add button in contentPane
		contentPane.add(btnNewButton);

		/*sregdt = new JXDatePicker();
		sregdt.getEditor().setFont(new Font("Times New Roman", Font.PLAIN, 14));
		sregdt.setBounds(235,153,93,20);
		sregdt.setDate(Calendar.getInstance().getTime());
        //sregdt.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
        //sregdt.setFormats("dd.mm.yyyy");
         getContentPane().add(sregdt);*/
		
		JLabel lblReceipt = new JLabel("Receipt");
		lblReceipt.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblReceipt.setBounds(175, 11, 110, 24);
		 getContentPane().add(lblReceipt);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblId.setBounds(45, 54, 46, 14);
		 getContentPane().add(lblId);
		
		JLabel lblFlatRow = new JLabel("Flat / Row House Number");
		lblFlatRow.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblFlatRow.setBounds(45, 77, 164, 14);
		 getContentPane().add(lblFlatRow);
		
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblType.setBounds(45, 102, 164, 14);
		 getContentPane().add(lblType);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblAmount.setBounds(45, 127, 164, 14);
		 getContentPane().add(lblAmount);
		
		JLabel lblReciept = new JLabel("Date");
		lblReciept.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblReciept.setBounds(45, 152, 164, 14);
		 getContentPane().add(lblReciept);
		
		JLabel lblRemarks = new JLabel("Remarks");
		lblRemarks.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblRemarks.setBounds(45, 191, 164, 14);
		 getContentPane().add(lblRemarks);
		
		rid = new JTextField();
		rid.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		rid.setBounds(235, 52, 86, 20);
		 getContentPane().add(rid);
		rid.setColumns(10);
		
		//amount=Double.parseDouble(ramt.getText());
		ramt = new JTextField();
		ramt.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		ramt.setColumns(10);
       /* ramt.addPropertyChangeListener("value", (PropertyChangeListener) this);
		ramt.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent e) {
				amount = ((Number)ramt.getValue()).doubleValue();
			}
		});*/
		ramt.setBounds(235, 124, 86, 20);
		 getContentPane().add(ramt);
		
		rfrn = new JComboBox<String>();
		rfrn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		rfrn.setBounds(235, 75, 86, 20);
		 getContentPane().add(rfrn);
		
		rtype = new JComboBox<String>();
		rtype.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		rtype.setBounds(235, 100, 86, 20);
		 getContentPane().add(rtype);
		
		rremark = new JTextArea();
		rremark.addKeyListener(new KeyAdapter() {


			public void keyTyped(KeyEvent e) {
				char keyChar = e.getKeyChar();
			    if (Character.isLowerCase(keyChar)) {
			      e.setKeyChar(Character.toUpperCase(keyChar));
			    }
			}
		});
		rremark.setBounds(235, 187, 133, 78);
		 getContentPane().add(rremark);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(114, 276, 233, 84);
		 getContentPane().add(panel);
		
		JButton radd = new JButton("Add");
		radd.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\new.png"));
		radd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				rid.enableInputMethods(true);
				ramt.enableInputMethods(true);
				sregdt.enableInputMethods(true);
				rfrn.enableInputMethods(true);
				rtype.enableInputMethods(true);
				rremark.enableInputMethods(true);
				
				rid.setText(null);
				ramt.setText(null);
				//sregdt.setText(null);
				//rfrn.setText(null);
				//rtype.setText(null);
				rremark.setText(null);
			
			}
		});
		radd.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(radd);
		
		JButton rsave = new JButton("Save");
		rsave.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\Save.png"));
		rsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:mypro");
				
				Statement st=con.createStatement();
				String q1="select * from RECEIPT";
				ResultSet rs=st.executeQuery(q1);
				int cnt=0;
				while(rs.next())
					cnt++;
				cnt=cnt+1;
				
				String q2="INSERT INTO RECEIPT (FLAT_ROWHOUSE_NO,TYPE,AMOUNT,RECEIPT_DATE,REMARKS) VALUES('"+rfrn.getSelectedItem()+"','"+rtype.getSelectedItem()+"','"+ramt.getText()+"','"+sregdt.getDate()+"','"+rremark.getText()+"')";
				
				int rs_int=st.executeUpdate(q2);
				
			    if(rs_int>0){
			       message_dialog=""+rid.getText().toUpperCase()+"Record inserted";
			    int type_dialog = JOptionPane.PLAIN_MESSAGE;
			    JOptionPane.showMessageDialog((Component) null, message_dialog, add_dialog, type_dialog);}
			    else 
			    {message_dialog=""+rid.getText().toUpperCase()+"Record Not inserted";
			    int type_dialog = JOptionPane.PLAIN_MESSAGE;
			    JOptionPane.showMessageDialog((Component) null, message_dialog, not_dialog, type_dialog);}
			    	System.out.println("Record not inserted");
			    	
				rid.enableInputMethods(false);
				ramt.enableInputMethods(false);
				sregdt.enableInputMethods(false);
				rfrn.enableInputMethods(false);
				rtype.enableInputMethods(false);
				rremark.enableInputMethods(false);
				con.close();
			}
			catch(ClassNotFoundException ce) {System.out.println("Class not found exception.");}
			catch(SQLException sqle){System.out.println(sqle);}
			catch(Exception l){System.out.println("In catch "+l);}
		
			}
		});
		rsave.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(rsave);
		
		JButton rcancel = new JButton("Cancel");
		rcancel.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\cancel.png"));
		rcancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				rid.setText(null);
				ramt.setText(null);
				//sregdt.setText(null);
				//rfrn.setText(null);
				//rtype.setText(null);
				rremark.setText(null);
			}
		});
		rcancel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(rcancel);
		
		JLabel label = new JLabel("in Rupees");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label.setBounds(330, 128, 86, 14);
		contentPane.add(label);
		
		try{
			
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:mypro");
			Statement stmt = con.createStatement();
			ResultSet rs=null;
			
			String q1="select * from RECEIPT";
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
		
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{rid, rfrn, rtype, ramt, btnNewButton, rremark, radd, rsave, rcancel, txtDate, lblReceipt, lblId, lblFlatRow, lblType, lblAmount, lblReciept, lblRemarks, panel, label}));
		}
		catch(Exception e ){}
		}

}
