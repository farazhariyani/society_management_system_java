import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.sql.*;
import java.text.SimpleDateFormat;

import org.jdesktop.swingx.JXDatePicker;


public class Society extends JInternalFrame {

	private JPanel contentPane;
	private JTextField sname,sland,scity,sstate,spin,sregno,sharecap,tshare,tan,pan,txtDate;
	private JTextArea sadd;
	private JButton btnSave,btnCancel,btnNewButton;
	String message_dialog;
	String add_dialog = "Database Record Added";
	String not_dialog = "Database Record Not Added";
	String modify_dialog = "Database Record Updated";
	private JButton btnPrint;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Society frame = new Society();
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
	public Society() throws SQLException{
		setTitle("Society");
		//setMaximum(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 1130, 696);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInsertSocietyDetails = new JLabel("INSERT SOCIETY DETAILS");
		lblInsertSocietyDetails.setBounds(94, 0, 684, 48);
		lblInsertSocietyDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertSocietyDetails.setFont(new Font("Times New Roman", Font.BOLD, 20));
		 getContentPane().add(lblInsertSocietyDetails);
		
		sname = new JTextField(30);
		sname.setBounds(242, 110, 442, 23);
		sname.setHorizontalAlignment(SwingConstants.LEFT);
		sname.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		 getContentPane().add(sname);
		sname.setColumns(10);
		
		JLabel lblAddresss = new JLabel("ADDRESSS");
		lblAddresss.setBounds(43, 139, 72, 29);
		lblAddresss.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddresss.setFont(new Font("Times New Roman", Font.BOLD, 14));
		 getContentPane().add(lblAddresss);
		
		JLabel lblLandmark = new JLabel("LANDMARK");
		lblLandmark.setBounds(43, 188, 80, 29);
		lblLandmark.setHorizontalAlignment(SwingConstants.LEFT);
		lblLandmark.setFont(new Font("Times New Roman", Font.BOLD, 14));
		 getContentPane().add(lblLandmark);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setBounds(43, 107, 182, 29);
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		 getContentPane().add(lblName);
		
		sland = new JTextField(20);
		sland.setBounds(242, 194, 442, 23);
		sland.setHorizontalAlignment(SwingConstants.LEFT);
		sland.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		sland.setColumns(10);
		 getContentPane().add(sland);
		
		JLabel lblCity = new JLabel("CITY");
		lblCity.setBounds(43, 228, 182, 29);
		lblCity.setHorizontalAlignment(SwingConstants.LEFT);
		lblCity.setFont(new Font("Times New Roman", Font.BOLD, 14));
		 getContentPane().add(lblCity);
		
		scity = new JTextField(20);
		scity.setBounds(242, 234, 187, 23);
		scity.setHorizontalAlignment(SwingConstants.LEFT);
		scity.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		scity.setColumns(10);
		 getContentPane().add(scity);
		
		JLabel lblState = new JLabel("STATE");
		lblState.setBounds(709, 228, 182, 29);
		lblState.setHorizontalAlignment(SwingConstants.LEFT);
		lblState.setFont(new Font("Times New Roman", Font.BOLD, 14));
		 getContentPane().add(lblState);
		
		sstate = new JTextField(20);
		sstate.setBounds(927, 228, 187, 23);
		sstate.setHorizontalAlignment(SwingConstants.LEFT);
		sstate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		sstate.setColumns(10);
		 getContentPane().add(sstate);
		
		JLabel lblPinCode = new JLabel("PIN CODE");
		lblPinCode.setBounds(43, 268, 66, 29);
		lblPinCode.setHorizontalAlignment(SwingConstants.LEFT);
		lblPinCode.setFont(new Font("Times New Roman", Font.BOLD, 14));
		 getContentPane().add(lblPinCode);
		
		spin = new JTextField(6);
		spin.setBounds(242, 271, 116, 23);
		spin.setHorizontalAlignment(SwingConstants.LEFT);
		spin.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		spin.setColumns(10);
		/*spin.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent ke)	
			{
				Pattern p= Pattern.compile("\\d(6)");//Regex for pincode validation
				Matcher m= p.matcher(spin.getText());
				if(!m.matches())
					spin.setText(null);*/
					
			/*for(int i=0;i<6;i++)
			{
			if(ke.getKeyChar()>='0' && ke.getKeyChar()>='9')
				spin.setEditable(true);
			else
				spin.setText("");
			}*/
			/*}
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub	
			}
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub				
			}});*/
		 getContentPane().add(spin);
		
		JLabel lblRegistrationNumber = new JLabel("REGISTRATION NUMBER");
		lblRegistrationNumber.setBounds(43, 308, 182, 29);
		lblRegistrationNumber.setHorizontalAlignment(SwingConstants.LEFT);
		lblRegistrationNumber.setFont(new Font("Times New Roman", Font.BOLD, 14));
		 getContentPane().add(lblRegistrationNumber);
		
		sregno = new JTextField(16);
		sregno.setBounds(242, 311, 221, 23);
		sregno.setHorizontalAlignment(SwingConstants.LEFT);
		sregno.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		sregno.setColumns(10);
		 getContentPane().add(sregno);
		
		JLabel lblRegistrationDate = new JLabel("REGISTRATION DATE");
		lblRegistrationDate.setBounds(709, 308, 155, 29);
		lblRegistrationDate.setHorizontalAlignment(SwingConstants.LEFT);
		lblRegistrationDate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		 getContentPane().add(lblRegistrationDate);
		
		JLabel lblShareCapital = new JLabel("SHARE CAPITAL");
		lblShareCapital.setBounds(43, 348, 111, 29);
		lblShareCapital.setHorizontalAlignment(SwingConstants.LEFT);
		lblShareCapital.setFont(new Font("Times New Roman", Font.BOLD, 14));
		 getContentPane().add(lblShareCapital);
		
		sharecap = new JTextField(5);
		sharecap.setBounds(242, 351, 116, 23);
		sharecap.setHorizontalAlignment(SwingConstants.LEFT);
		sharecap.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		sharecap.setColumns(10);
		 getContentPane().add(sharecap);
		
		JLabel lblTotalShares = new JLabel("TOTAL NUMBER OF SHARES");
		lblTotalShares.setToolTipText("COUNT OF SHARES");
		lblTotalShares.setBounds(709, 348, 208, 29);
		lblTotalShares.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotalShares.setFont(new Font("Times New Roman", Font.BOLD, 14));
		 getContentPane().add(lblTotalShares);
		
		tshare = new JTextField(5);
		tshare.setBounds(927, 348, 116, 23);
		tshare.setHorizontalAlignment(SwingConstants.LEFT);
		tshare.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		tshare.setColumns(10);
		 getContentPane().add(tshare);
		
		JLabel lblTanNumber = new JLabel("TAN NUMBER");
		lblTanNumber.setToolTipText("Tax Deduction and Collection Account Number");
		lblTanNumber.setBounds(43, 388, 88, 29);
		lblTanNumber.setHorizontalAlignment(SwingConstants.LEFT);
		lblTanNumber.setFont(new Font("Times New Roman", Font.BOLD, 14));
		 getContentPane().add(lblTanNumber);
		
		tan = new JTextField(16);
		tan.setBounds(242, 391, 343, 23);
		tan.setHorizontalAlignment(SwingConstants.LEFT);
		tan.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		tan.setColumns(10);
		 getContentPane().add(tan);
		
		JLabel lblPanNumber = new JLabel("PAN NUMBER");
		lblPanNumber.setToolTipText("Permanent Account Number");
		lblPanNumber.setBounds(43, 428, 88, 29);
		lblPanNumber.setHorizontalAlignment(SwingConstants.LEFT);
		lblPanNumber.setFont(new Font("Times New Roman", Font.BOLD, 14));
		 getContentPane().add(lblPanNumber);
		
		pan = new JTextField(16);
		pan.setBounds(242, 431, 343, 23);
		pan.setHorizontalAlignment(SwingConstants.LEFT);
		pan.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		pan.setColumns(10);
		 getContentPane().add(pan);
		
		sadd = new JTextArea();
		sadd.setWrapStyleWord(true);
		sadd.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		sadd.setLineWrap(true);
		sadd.setBounds(242, 144, 442, 39);
		 getContentPane().add(sadd);
		
		//create text field
			txtDate = new JTextField();
			//set bounds of text field
			txtDate.setBounds(927,309,105,20);
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
			btnNewButton.setBounds(1034,309,17,20);
			//add button in contentPane
			contentPane.add(btnNewButton);
		 
		 /*sregdt = new JXDatePicker();
		sregdt.getEditor().setFont(new Font("Times New Roman", Font.PLAIN, 14));
		sregdt.setBounds(673,312,105,20);//242,396,116,20);
		sregdt.setDate(Calendar.getInstance().getTime());
        //sregdt.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
        //sregdt.setFormats("dd.mm.yyyy");
         getContentPane().add(sregdt);*/
		
		
		Panel panel = new Panel();
		panel.setBounds(169, 487, 451, 56);
		 getContentPane().add(panel);
		
		btnSave = new JButton("SAVE");
		btnSave.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\Save.png"));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
										
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con=DriverManager.getConnection("jdbc:odbc:mypro");
					if(con!=null)
					{ System.out.print("Con Success"); }
					Statement st=con.createStatement();
					String q1="select * from SOCIETY";
					ResultSet rs=st.executeQuery(q1);
				
					if(rs.next()){
						
						message_dialog="Only One Society Can Be There In The Database.";
					    int type_dialog = JOptionPane.WARNING_MESSAGE;
					    JOptionPane.showMessageDialog((Component) null, message_dialog, add_dialog, type_dialog);
						
					}
					
					String q2="INSERT INTO SOCIETY(SOCIETY_NAME,ADDRESS,LANDMARK,CITY,STATE,PIN_NO,REGISTRATION_NO,REGISTRATION_DATE,SHARE_CAPITAL,TOTAL_SHARES,TAN,PAN) VALUES('"+sname.getText()+"','"+sadd.getText()+"','"+sland.getText()+"','"+scity.getText()+"','"+sstate.getText()+"',"+Integer.parseInt(spin.getText())+",'"+sregno.getText()+"','"+txtDate.getText()+"','"+sharecap.getText()+"','"+tshare.getText()+"','"+tan.getText()+"','"+pan.getText()+"')";
				
					
					//,REGISTRATION_DATE  ,'"+(Date)sregdt.getDate()+"'
					int rs_int=st.executeUpdate(q2);
					/*
					PreparedStatement pst=con.prepareStatement("insert into SOCIETY values(?,?,?,?,?,?,?,?,?,?,?)");//,?
					pst.setString(0,sname.getText());
					pst.setString(1,sadd.getText());
					pst.setString(2,sland.getText());
					pst.setString(3,scity.getText());
					pst.setString(4,sstate.getText());
					int pin=Integer.parseInt(spin.getText());
					pst.setInt(5,pin);
					pst.setString(6,sregno.getText());
					//pst.setDate(7,(Date)sregdt.getDate());//(Date) sregdt.getDate()
					pst.setString(8,sharecap.getText());
					pst.setString(9,tshare.getText());
					pst.setString(10,tan.getText());
					pst.setString(11,pan.getText());
					int x=pst.executeUpdate();*/
				    if(rs_int>0){
				       message_dialog=""+sname.getText().toUpperCase()+"Record inserted";
				    int type_dialog = JOptionPane.PLAIN_MESSAGE;
				    JOptionPane.showMessageDialog((Component) null, message_dialog, add_dialog, type_dialog);}
				    else 
				    {message_dialog=""+sname.getText().toUpperCase()+"Record Not inserted";
				    int type_dialog = JOptionPane.PLAIN_MESSAGE;
				    JOptionPane.showMessageDialog((Component) null, message_dialog, not_dialog, type_dialog);}
				    	System.out.println("Record not inserted");
				
				    	sname.enableInputMethods(false);
						sadd.enableInputMethods(false);
						sland.enableInputMethods(false);
						scity.enableInputMethods(false);
						sstate.enableInputMethods(false);
						spin.enableInputMethods(false);
						sregno.enableInputMethods(false);
						txtDate.enableInputMethods(false);
						btnNewButton.enableInputMethods(false);
						sharecap.enableInputMethods(false);
						tshare.enableInputMethods(false);
						tan.enableInputMethods(false);
						pan.enableInputMethods(false);	
						
						con.close();
				}
				catch(ClassNotFoundException ce) {System.out.println("Class not found exception.");}
				catch(SQLException sqle){System.out.println(sqle);}
				catch(Exception l){System.out.println("In catch "+l);}
			
			}
		});
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(btnSave);
		
		btnCancel = new JButton("CANCEL");
		btnCancel.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\cancel.png"));
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(btnCancel);
		
		btnPrint = new JButton("PRINT");
		btnPrint.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\print-icon.png"));
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame yourComponent = new JFrame();
				PrinterJob pjob = PrinterJob.getPrinterJob();
				PageFormat preformat = pjob.defaultPage();
				preformat.setOrientation(PageFormat.LANDSCAPE);
				PageFormat postformat = pjob.pageDialog(preformat);
				//If user does not hit cancel then print.
				if (preformat != postformat) {
				    //Set print component
				    pjob.setPrintable(new Printer(yourComponent), postformat);
				    if (pjob.printDialog()) {
				        try {
							pjob.print();
						} catch (PrinterException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				    }
				}
			
			}
		});
		btnPrint.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(btnPrint);
		
		JLabel lblInRupees = new JLabel("in Rupees");
		lblInRupees.setBounds(368, 356, 70, 14);
		contentPane.add(lblInRupees);
		
		try{
			sname.enableInputMethods(true);
			sadd.enableInputMethods(true);
			sland.enableInputMethods(true);
			scity.enableInputMethods(true);
			sstate.enableInputMethods(true);
			spin.enableInputMethods(true);
			sregno.enableInputMethods(true);
			txtDate.enableInputMethods(true);
			btnNewButton.enableInputMethods(true);
			sharecap.enableInputMethods(true);
			tshare.enableInputMethods(true);
			tan.enableInputMethods(true);
			pan.enableInputMethods(true);
			
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");					
			Connection conObject = DriverManager.getConnection("jdbc:odbc:mypro");
			String sg="select * from SOCIETY";
			PreparedStatement pst = conObject.prepareStatement(sg);
			
			int cnt=0;
			
			ResultSet rst=pst.executeQuery(sg);
			while(rst.next())
			{
				if(cnt!=0){  break;  }
			
				
			 //tfbrname.setText(rs.getString(i));
			sname.setText(rst.getString("SOCIETY_NAME"));
			sadd.setText(rst.getString("ADDRESS"));
			sland.setText(rst.getString("LANDMARK"));
			scity.setText(rst.getString("CITY"));
			sstate.setText(rst.getString("STATE"));
			int ipin = Integer.parseInt(rst.getString("PIN_NO"));
			spin.setText(rst.getString(ipin));
			int irno = Integer.parseInt(rst.getString("REGISTRATION_NO"));
			sregno.setText(rst.getString(irno));
			txtDate.setText(rst.getString("REGISTRATION_DATE"));
			int iscp = Integer.parseInt(rst.getString("SHARE_CAPITAL"));
			sharecap.setText(rst.getString(iscp));
			int its = Integer.parseInt(rst.getString("TOTAL_SHARES"));
			tshare.setText(rst.getString(its));
			int itan = Integer.parseInt(rst.getString("TAN"));
			tan.setText(rst.getString(itan));
			int ipan = Integer.parseInt(rst.getString("PAN"));
			pan.setText(rst.getString(ipan));
		
			cnt++;
			
			}
conObject.close(); 
	}
		catch(Exception ue)
		{ue.printStackTrace();}
}
	}


