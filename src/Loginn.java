import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.AbstractButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.Color;

import javax.swing.ImageIcon;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import javax.swing.JSeparator;
public class Loginn {

	private JFrame frmLogin;
	private JTextField tunm;
	private JPasswordField tpassword;
	int counter=0;
	//private final Action act = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loginn window = new Loginn();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Loginn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {


		frmLogin = new JFrame();
		frmLogin.getContentPane().setBackground(new Color(255, 255, 153));
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 541, 312);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setBounds(196, 56, 66, 35);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		frmLogin.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("User Name ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(124, 92, 76, 27);
		frmLogin.getContentPane().add(lblNewLabel_1);

		JLabel lblPassword = new JLabel("Password ");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPassword.setBounds(124, 130, 76, 27);
		frmLogin.getContentPane().add(lblPassword);

		tunm = new JTextField();
		tunm.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		tunm.setBounds(210, 102, 105, 20);
		frmLogin.getContentPane().add(tunm);
		tunm.setColumns(10);

		tpassword = new JPasswordField();
		tpassword.setFont(new Font("Times New Roman", Font.BOLD, 14));
		tpassword.setBounds(210, 133, 105, 20);
		frmLogin.getContentPane().add(tpassword);

		final JButton bcancel = new JButton("Cancel");
		bcancel.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\cancel.png"));
		bcancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==bcancel)
					System.exit(0);
				//EXIT_ON_CLOSE;
			}
		});
		bcancel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		bcancel.setBounds(272, 179, 138, 37);
		frmLogin.getContentPane().add(bcancel);

		ImageIcon icon=new ImageIcon("login.png");

		JButton blogin = new JButton("\r\nLogin",new ImageIcon("F:\\DBProjectJan2017\\src\\login.png"));
		blogin.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
			char c=e.getKeyChar();
			if(c==KeyEvent.VK_ENTER)
			{
				String unm=tunm.getText();
				char[] pass=null;
				pass=tpassword.getPassword();
				String valueOfchar = String.valueOf(pass);//CONVERTING CHAR[] TO STRING
				//System.out.println(unm+" "+valueOfchar);
				   if (unm.equals("faraz") && valueOfchar.equals("faraz@123"))
				   {
					   JOptionPane.showMessageDialog(null, "Login Successful.");
					   frmLogin.dispose();
					   Mainmen mm=new Mainmen();
					   mm.setVisible(true);
					   //new Mainmenu().setVisible(true);
				   }
				   else if (unm.equals("faraz") && (!valueOfchar.equals("faraz@123")))
				   { counter++;
					   JOptionPane.showMessageDialog(null, "Enter Valid Password");//System.out.println("Enter Valid password");

				   }
				   else if ((!unm.equals("faraz")) && valueOfchar.equals("faraz@123"))
				   {counter++;
				   JOptionPane.showMessageDialog(null, "Enter Valid Username");//System.out.println("Enter Valid username");
				   }
				   else
				   {counter++;
				   JOptionPane.showMessageDialog(null, "Enter Valid Username and Password");//System.out.println("Enter Valid username and password");
				   }


			}
			if(counter==3)
			   {
				   System.exit(0);

			   }
			}
		});


        blogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String unm=tunm.getText();
				char[] pass=null;
				pass=tpassword.getPassword();
				String valueOfchar = String.valueOf(pass);//CONVERTING CHAR[] TO STRING
				//System.out.println(unm+" "+valueOfchar);
				   if (unm.equals("faraz") && valueOfchar.equals("faraz@123"))
				   {
					   JOptionPane.showMessageDialog(null, "Login Successful.");
					   frmLogin.dispose();
					   Mainmen mm=new Mainmen();
					   mm.setVisible(true);
					   //new Mainmenu().setVisible(true);
				   }
				   else if (unm.equals("faraz") && (!valueOfchar.equals("faraz@123")))
				   {counter++;
				   JOptionPane.showMessageDialog(null, "Enter Valid Password");//System.out.println("Enter Valid password");
				   }
				   else if ((!unm.equals("faraz")) && valueOfchar.equals("faraz@123"))
				   {counter++;
				   JOptionPane.showMessageDialog(null, "Enter Valid Username");//System.out.println("Enter Valid username");
				   }
				   else
				   {counter++;
				   JOptionPane.showMessageDialog(null, "Enter Valid Username and Password");//System.out.println("Enter Valid username and password");
				   }

				   if(counter==3)
				   {
					   System.exit(0);

				   }
			}


		});
		blogin.setFont(new Font("Times New Roman", Font.BOLD, 16));
		blogin.setBounds(124, 180, 138, 35);


		frmLogin.getContentPane().add(blogin);

		JLabel lblByFarazHariyani = new JLabel("By Faraz Hariyani");
		lblByFarazHariyani.setBounds(395, 248, 105, 14);
		frmLogin.getContentPane().add(lblByFarazHariyani);

		JLabel lblHousingSocietyManagement = new JLabel("Society Management System");
		lblHousingSocietyManagement.setForeground(new Color(220, 20, 60));
		lblHousingSocietyManagement.setHorizontalAlignment(SwingConstants.CENTER);
		lblHousingSocietyManagement.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblHousingSocietyManagement.setBounds(47, 0, 390, 67);
		frmLogin.getContentPane().add(lblHousingSocietyManagement);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(10, 273, 505, -23);
		frmLogin.getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 227, 505, 48);
		frmLogin.getContentPane().add(separator_1);
		frmLogin.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{tunm, tpassword, blogin, bcancel, lblNewLabel, lblNewLabel_1, lblPassword, lblByFarazHariyani, lblHousingSocietyManagement}));



	}

	protected void setDefaultCloseOperation(int exitOnClose) {
		// TODO Auto-generated method stub

	}

}

