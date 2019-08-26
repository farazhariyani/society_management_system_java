import java.awt.EventQueue;

import javax.swing.JMenuBar;

import java.awt.Font;

import javax.swing.JMenuItem;
import javax.swing.JMenu;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Mainmen extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainmen frame = new Mainmen();
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
	public Mainmen() {
		setForeground(new Color(100, 149, 237));
		setTitle("Society Management System");
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1350, 725);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(0, 255, 204));
		menuBar.setForeground(new Color(0, 255, 204));
		menuBar.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		setJMenuBar(menuBar);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(new Color(255, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		setContentPane(contentPane);
		//contentPane.setLayout(null);
		
		
		
		JMenu mnNewMenu = new JMenu("Society");
		mnNewMenu.setFont(new Font("Times New Roman", Font.BOLD, 14));
		mnNewMenu.setBackground(SystemColor.activeCaption);
		menuBar.add(mnNewMenu);
		
		JMenuItem SAdd = new JMenuItem("Add");
		
		
		SAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				Society sc=new Society();
				
				sc.getContentPane().setLayout(new BorderLayout(1,1));
				//System.out.println("clicked");
				contentPane.add(sc);
				sc.setVisible(true);
				sc.setSelected(true);
				sc.toFront();
				sc.repaint();
				 sc.setMaximum(true);
				}catch(Exception e1){
					e1.printStackTrace();
				}			
				}
		});
		mnNewMenu.add(SAdd);
		
		JMenu Owner = new JMenu("Owner");
		Owner.setBackground(SystemColor.activeCaption);
		menuBar.add(Owner);
		Owner.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JMenuItem OAdd = new JMenuItem("Add");
		OAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				main_owner mo=new main_owner();
				
				mo.getContentPane().setLayout(new BorderLayout(1,1));
				//System.out.println("clicked");
				contentPane.add(mo);
				mo.setVisible(true);
				mo.setSelected(true);
				mo.toFront();
				mo.repaint();
				mo.setMaximum(true);
				}catch(Exception e1){
					e1.printStackTrace();
				}			
				}
		});

		Owner.add(OAdd);
		
		JMenuItem OSearch = new JMenuItem("Search/Update");
		OSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					//System.out.println("clicked1");
				searchowner so=new searchowner();
				//System.out.println("clicked2");
				so.getContentPane().setLayout(new BorderLayout(1,1));
				//System.out.println("clicked");
				contentPane.add(so);
				so.setVisible(true);
				so.setSelected(true);
				so.toFront();
				so.repaint();
				so.setMaximum(true);
				}catch(Exception e1){
					e1.printStackTrace();
				}			
				}
		});
		Owner.add(OSearch);
		
		JMenu mnFlat = new JMenu("Flat");
		mnFlat.setBackground(SystemColor.activeCaption);
		menuBar.add(mnFlat);
		mnFlat.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JMenuItem FAdd = new JMenuItem("Add");
		FAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				flat so=new flat();
				
				so.getContentPane().setLayout(new BorderLayout(1,1));
				//System.out.println("clicked");
				contentPane.add(so);
				so.setVisible(true);
				so.setSelected(true);
				so.toFront();
				so.repaint();
				so.setMaximum(true);
				}catch(Exception e1){
					e1.printStackTrace();
				}			
				}
		});
		mnFlat.add(FAdd);
		
		JMenuItem FModify = new JMenuItem("Search/Update");
		FModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				searchflat so=new searchflat();
				
				
				so.getContentPane().setLayout(new BorderLayout(2,1));
				//System.out.println("clicked");
				contentPane.add(so);
				so.setVisible(true);
				so.setSelected(true);
				so.toFront();
				so.repaint();
				so.setMaximum(true);
				}catch(Exception e1){
					e1.printStackTrace();
				}			
				}
		});
		mnFlat.add(FModify);
		
		JSeparator separator = new JSeparator();
		mnFlat.add(separator);
		
		JMenu mnFlatmember = new JMenu("Flat_Member");
		mnFlatmember.setFont(new Font("Times New Roman", Font.BOLD, 12));
		mnFlat.add(mnFlatmember);
		
		JMenuItem FMAdd = new JMenuItem("Add");
		FMAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				flatmember so=new flatmember();
				
				so.getContentPane().setLayout(new BorderLayout(1,1));
				//System.out.println("clicked");
				contentPane.add(so);
				so.setVisible(true);
				so.setSelected(true);
				so.toFront();
				so.repaint();
				so.setMaximum(true);
				}catch(Exception e1){
					e1.printStackTrace();
				}			
				}
		});
		mnFlatmember.add(FMAdd);
		
		JMenuItem FMSearch = new JMenuItem("Search/Update");
		
		FMSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				searchfmember so=new searchfmember();
				
				so.getContentPane().setLayout(new BorderLayout(1,1));
				//System.out.println("clicked");
				contentPane.add(so);
				so.setVisible(true);
				so.setSelected(true);
				so.toFront();
				so.repaint();
				so.setMaximum(true);
				}catch(Exception e1){
					e1.printStackTrace();
				}			
				}
		});
		mnFlatmember.add(FMSearch);
		
		JSeparator separator_1 = new JSeparator();
		mnFlat.add(separator_1);
		
		JMenu mnTransfer = new JMenu("Transfer");
		mnTransfer.setFont(new Font("Times New Roman", Font.BOLD, 12));
		mnFlat.add(mnTransfer);
		
		JMenuItem TAdd = new JMenuItem("Add");
		TAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				transfer so=new transfer();
				
				so.getContentPane().setLayout(new BorderLayout(1,1));
				//System.out.println("clicked");
				contentPane.add(so);
				so.setVisible(true);
				so.setSelected(true);
				so.toFront();
				so.repaint();
				so.setMaximum(true);
				}catch(Exception e1){
					e1.printStackTrace();
				}			
				}
		});
		mnTransfer.add(TAdd);
		
		JMenuItem TSearch = new JMenuItem("Search/Update");
		
		TSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				searchtransfer so=new searchtransfer();
				
				so.getContentPane().setLayout(new BorderLayout(1,1));
				//System.out.println("clicked");
				contentPane.add(so);
				so.setVisible(true);
				so.setSelected(true);
				so.toFront();
				so.repaint();
				so.setMaximum(true);
				
				}catch(Exception e1){
				e1.printStackTrace();
				}			
				}
		});
		mnTransfer.add(TSearch);
		
		JMenu mnService = new JMenu("Service");
		mnService.setFont(new Font("Times New Roman", Font.BOLD, 14));
		mnService.setBackground(SystemColor.activeCaption);
		menuBar.add(mnService);
		
		JMenuItem SeAdd = new JMenuItem("Add");
		
		SeAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				service so=new service();
				
				so.getContentPane().setLayout(new BorderLayout(1,1));
				//System.out.println("clicked");
				contentPane.add(so);
				so.setVisible(true);
				so.setSelected(true);
				so.toFront();
				so.repaint();
				so.setMaximum(true);
				}catch(Exception e1){
					e1.printStackTrace();
				}			
				}
		});
		mnService.add(SeAdd);
		
		JMenuItem SeModify = new JMenuItem("Search/Update");
		
		SeModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				searchservice so=new searchservice();
				
				so.getContentPane().setLayout(new BorderLayout(1,1));
				//System.out.println("clicked");
				contentPane.add(so);
				so.setVisible(true);
				so.setSelected(true);
				so.toFront();
				so.repaint();
				so.setMaximum(true);
				}catch(Exception e1){
					e1.printStackTrace();
				}			
				}
		});
		mnService.add(SeModify);
		
		JSeparator separator_2 = new JSeparator();
		mnService.add(separator_2);
		
		JMenu mnServicehistory = new JMenu("Service_History");
		mnServicehistory.setFont(new Font("Times New Roman", Font.BOLD, 12));
		mnService.add(mnServicehistory);
		
		JMenuItem SHAdd = new JMenuItem("Add");
		
		SHAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				servicehistory so=new servicehistory();
				
				so.getContentPane().setLayout(new BorderLayout(1,1));
				//System.out.println("clicked");
				contentPane.add(so);
				so.setVisible(true);
				so.setSelected(true);
				so.toFront();
				so.repaint();
				so.setMaximum(true);
				}catch(Exception e1){
					e1.printStackTrace();
				}			
				}
		});
		mnServicehistory.add(SHAdd);
		
		JMenuItem SHModify = new JMenuItem("Search/Update");
		
		SHModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				searchserhistory so=new searchserhistory();
				
				so.getContentPane().setLayout(new BorderLayout(1,1));
				//System.out.println("clicked");
				contentPane.add(so);
				so.setVisible(true);
				so.setSelected(true);
				so.toFront();
				so.repaint();
				so.setMaximum(true);
				}catch(Exception e1){
					e1.printStackTrace();
				}			
				
				}
		});
		mnServicehistory.add(SHModify);
		
		JMenu mnVendor = new JMenu("Vendor");
		mnVendor.setFont(new Font("Times New Roman", Font.BOLD, 14));
		mnVendor.setBackground(SystemColor.activeCaption);
		menuBar.add(mnVendor);
		
		JMenuItem VAdd = new JMenuItem("Add");
		
		VAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				vendor so=new vendor();
				
				so.getContentPane().setLayout(new BorderLayout(1,1));
				//System.out.println("clicked");
				contentPane.add(so);
				so.setVisible(true);
				so.setSelected(true);
				so.toFront();
				so.repaint();
				so.setMaximum(true);
				}catch(Exception e1){
					e1.printStackTrace();
				}			
				}
		});
		mnVendor.add(VAdd);
		
		JMenuItem VModify = new JMenuItem("Search/Update");
		
		VModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				searchvendor so=new searchvendor();
				
				so.getContentPane().setLayout(new BorderLayout(1,1));
				//System.out.println("clicked");
				contentPane.add(so);
				so.setVisible(true);
				so.setSelected(true);
				so.toFront();
				so.repaint();
				so.setMaximum(true);
				}catch(Exception e1){
					e1.printStackTrace();
				}			
				}
		});
		mnVendor.add(VModify);
		
		JSeparator separator_3 = new JSeparator();
		mnVendor.add(separator_3);
		
		JMenu mnNewMvendorcontractenu = new JMenu("Vendor_Contract");
		mnNewMvendorcontractenu.setFont(new Font("Times New Roman", Font.BOLD, 12));
		mnVendor.add(mnNewMvendorcontractenu);
		
		JMenuItem VCAdd = new JMenuItem("Add");
		
		VCAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				vendorcontract so=new vendorcontract();
				
				so.getContentPane().setLayout(new BorderLayout(1,1));
				//System.out.println("clicked");
				contentPane.add(so);
				so.setVisible(true);
				so.setSelected(true);
				so.toFront();
				so.repaint();
				so.setMaximum(true);
				}catch(Exception e1){
					e1.printStackTrace();
				}			
				}
		});
		mnNewMvendorcontractenu.add(VCAdd);
		
		JMenuItem VCModify = new JMenuItem("Search/Update");
		
		VCModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				searchvencontract so=new searchvencontract();
				
				so.getContentPane().setLayout(new BorderLayout(1,1));
				//System.out.println("clicked");
				contentPane.add(so);
				so.setVisible(true);
				so.setSelected(true);
				so.toFront();
				so.repaint();
				so.setMaximum(true);
				}catch(Exception e1){
					e1.printStackTrace();
				}			
				}
		});
		mnNewMvendorcontractenu.add(VCModify);
		
		JMenu mnSocietystaff = new JMenu("Society_Staff");
		mnSocietystaff.setFont(new Font("Times New Roman", Font.BOLD, 14));
		mnSocietystaff.setBackground(SystemColor.activeCaption);
		menuBar.add(mnSocietystaff);
		
		JMenuItem SSAdd = new JMenuItem("Add");
		
		SSAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				societystaff so=new societystaff();
				
				so.getContentPane().setLayout(new BorderLayout(1,1));
				//System.out.println("clicked");
				contentPane.add(so);
				so.setVisible(true);
				so.setSelected(true);
				so.toFront();
				so.repaint();
				so.setMaximum(true);
				}catch(Exception e1){
					e1.printStackTrace();
				}			
				}
		});
		mnSocietystaff.add(SSAdd);
		
		JMenuItem SSModify = new JMenuItem("Search/Update");
		
		SSModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				searchsocstaff so=new searchsocstaff();
				
				so.getContentPane().setLayout(new BorderLayout(1,1));
				//System.out.println("clicked");
				contentPane.add(so);
				so.setVisible(true);
				so.setSelected(true);
				so.toFront();
				so.repaint();
				so.setMaximum(true);
				}catch(Exception e1){
					e1.printStackTrace();
				}			
				}
		});
		mnSocietystaff.add(SSModify);
		
		JMenu mnBills = new JMenu("Bills");
		mnBills.setFont(new Font("Times New Roman", Font.BOLD, 14));
		mnBills.setBackground(SystemColor.activeCaption);
		menuBar.add(mnBills);
		
		JMenu mnReceicpt = new JMenu("Receipt");
		mnReceicpt.setFont(new Font("Times New Roman", Font.BOLD, 12));
		mnBills.add(mnReceicpt);
		
		JMenuItem RAdd = new JMenuItem("Add");
		
		RAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				receipt so=new receipt();
				
				so.getContentPane().setLayout(new BorderLayout(1,1));
				//System.out.println("clicked");
				contentPane.add(so);
				so.setVisible(true);
				so.setSelected(true);
				so.toFront();
				so.repaint();
				so.setMaximum(true);
				}catch(Exception e1){
				e1.printStackTrace();
				}			
				}
		});
		mnReceicpt.add(RAdd);
		
		/*JMenuItem RModify = new JMenuItem("Search/Update");
		
		RModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				servicehistory so=new servicehistory();
				
				so.getContentPane().setLayout(new BorderLayout(1,1));
				//System.out.println("clicked");
				contentPane.add(so);
				so.setVisible(true);
				so.setSelected(true);
				so.toFront();
				so.repaint();
				so.setMaximum(true);
				}catch(Exception e1){
					e1.printStackTrace();
				}			
				}
		});
		mnReceicpt.add(RModify);*/
		
		JSeparator separator_4 = new JSeparator();
		mnBills.add(separator_4);
		
		JMenu mnPayments = new JMenu("Payments");
		mnPayments.setFont(new Font("Times New Roman", Font.BOLD, 12));
		mnBills.add(mnPayments);
		
		JMenuItem PAdd = new JMenuItem("Add");
		
		PAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				
				{
				
					payment so=new payment();
					System.out.println("1");
				so.getContentPane().setLayout(new BorderLayout(1,1));
				//System.out.println("clicked");
				contentPane.add(so);
				so.setVisible(true);
				so.setSelected(true);
				so.toFront();
				so.repaint();
				so.setMaximum(true);
				}catch(Exception e1){
					e1.printStackTrace();
				}			
				}
		});
		mnPayments.add(PAdd);
		
		/*JMenuItem PModify = new JMenuItem("Search/Update");
		
		PModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				servicehistory so=new servicehistory();
				
				so.getContentPane().setLayout(new BorderLayout(1,1));
				//System.out.println("clicked");
				contentPane.add(so);
				so.setVisible(true);
				so.setSelected(true);
				so.toFront();
				so.repaint();
				so.setMaximum(true);
				}catch(Exception e1){
					e1.printStackTrace();
				}			
				}
		});
		mnPayments.add(PModify);*/
		
		JMenu mnHelpdesk = new JMenu("Help_Desk");
		mnHelpdesk.setFont(new Font("Times New Roman", Font.BOLD, 14));
		mnHelpdesk.setBackground(SystemColor.activeCaption);
		menuBar.add(mnHelpdesk);
		
		JMenuItem HDAdd = new JMenuItem("Add");
		
		HDAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				helpdesk so=new helpdesk();
				
				so.getContentPane().setLayout(new BorderLayout(1,1));
				//System.out.println("clicked");
				contentPane.add(so);
				so.setVisible(true);
				so.setSelected(true);
				so.toFront();
				so.repaint();
				so.setMaximum(true);
				}catch(Exception e1){
				e1.printStackTrace();
				}			
				}
		});
		mnHelpdesk.add(HDAdd);
		
		JMenu mnReports = new JMenu("Reports");
		mnReports.setFont(new Font("Times New Roman", Font.BOLD, 14));
		mnReports.setBackground(SystemColor.activeCaption);
		menuBar.add(mnReports);
		
		JMenuItem mntmOwnerReports = new JMenuItem("Owner Reports");
		mntmOwnerReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try
				{
				owner_report so=new owner_report();
				
				so.getContentPane().setLayout(new BorderLayout(1,1));
				//System.out.println("clicked");
				contentPane.add(so);
				so.setVisible(true);
				so.setSelected(true);
				so.toFront();
				so.repaint();
				so.setMaximum(true);
				}catch(Exception e1){
				e1.printStackTrace();
				}
			
			}
		});
		mnReports.add(mntmOwnerReports);
		
		JMenu mnFlat_1 = new JMenu("Flat");
		mnFlat_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		mnReports.add(mnFlat_1);
		
		JMenuItem mntmFlatReports = new JMenuItem("Flat Reports");
		mntmFlatReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				Flat_Reports so=new Flat_Reports();
				
				so.getContentPane().setLayout(new BorderLayout(1,1));
				//System.out.println("clicked");
				contentPane.add(so);
				so.setVisible(true);
				so.setSelected(true);
				so.toFront();
				so.repaint();
				so.setMaximum(true);
				}catch(Exception e1){
				e1.printStackTrace();
				}
			
			}
		});
		mnFlat_1.add(mntmFlatReports);
		
		JMenuItem menuItem = new JMenuItem("Flat Members Reports");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try
				{
				fmem_reports so=new fmem_reports();
				
				so.getContentPane().setLayout(new BorderLayout(1,1));
				//System.out.println("clicked");
				contentPane.add(so);
				so.setVisible(true);
				so.setSelected(true);
				so.toFront();
				so.repaint();
				so.setMaximum(true);
				}catch(Exception e1){
				e1.printStackTrace();
				}
			
			}
		});
		mnFlat_1.add(menuItem);
		
		JMenuItem mntmFlatTransferReports = new JMenuItem("Flat Transfer Reports");
		mntmFlatTransferReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try
				{
				ftransfer_report so=new ftransfer_report();
				
				so.getContentPane().setLayout(new BorderLayout(1,1));
				//System.out.println("clicked");
				contentPane.add(so);
				so.setVisible(true);
				so.setSelected(true);
				so.toFront();
				so.repaint();
				so.setMaximum(true);
				}catch(Exception e1){
				e1.printStackTrace();
				}
				
			}
		});
		mnFlat_1.add(mntmFlatTransferReports);
		
		JMenu mnService_1 = new JMenu("Service");
		mnService_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		mnReports.add(mnService_1);
		
		JMenuItem mntmServiceReports = new JMenuItem("Service Reports");
		mntmServiceReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try
				{
				service_report so=new service_report();
				
				so.getContentPane().setLayout(new BorderLayout(1,1));
				//System.out.println("clicked");
				contentPane.add(so);
				so.setVisible(true);
				so.setSelected(true);
				so.toFront();
				so.repaint();
				so.setMaximum(true);
				}catch(Exception e1){
				e1.printStackTrace();
				}
			
			}
		});
		mnService_1.add(mntmServiceReports);
		
		JMenuItem mntmServiceHistoryReports = new JMenuItem("Service History Reports");
		mntmServiceHistoryReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try
				{
				service_hist_report so=new service_hist_report();
				
				so.getContentPane().setLayout(new BorderLayout(1,1));
				//System.out.println("clicked");
				contentPane.add(so);
				so.setVisible(true);
				so.setSelected(true);
				so.toFront();
				so.repaint();
				so.setMaximum(true);
				}catch(Exception e1){
				e1.printStackTrace();
				}
			
			}
		});
		mnService_1.add(mntmServiceHistoryReports);
		
		JMenu mnVendor_1 = new JMenu("Vendor");
		mnVendor_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		mnReports.add(mnVendor_1);
		
		JMenuItem mntmVendorReports = new JMenuItem("Vendor Reports");
		mntmVendorReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try
				{
				vendor_reports so=new vendor_reports();
				
				so.getContentPane().setLayout(new BorderLayout(1,1));
				//System.out.println("clicked");
				contentPane.add(so);
				so.setVisible(true);
				so.setSelected(true);
				so.toFront();
				so.repaint();
				so.setMaximum(true);
				}catch(Exception e1){
				e1.printStackTrace();
				}
			
			}
		});
		mnVendor_1.add(mntmVendorReports);
		
		JMenuItem mntmVendorContractReports = new JMenuItem("Vendor Contract Reports");
		mntmVendorContractReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try
				{
				ven_cont_report so=new ven_cont_report();
				
				so.getContentPane().setLayout(new BorderLayout(1,1));
				//System.out.println("clicked");
				contentPane.add(so);
				so.setVisible(true);
				so.setSelected(true);
				so.toFront();
				so.repaint();
				so.setMaximum(true);
				}catch(Exception e1){
				e1.printStackTrace();
				}
			
			}
		});
		mnVendor_1.add(mntmVendorContractReports);
		
		JMenuItem mntmSocietyStaffReports = new JMenuItem("Society Staff Reports");
		mntmSocietyStaffReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try
				{
				socstaff_report so=new socstaff_report();
				
				so.getContentPane().setLayout(new BorderLayout(1,1));
				//System.out.println("clicked");
				contentPane.add(so);
				so.setVisible(true);
				so.setSelected(true);
				so.toFront();
				so.repaint();
				so.setMaximum(true);
				}catch(Exception e1){
				e1.printStackTrace();
				}
			
			}
		});
		mnReports.add(mntmSocietyStaffReports);
		
		JMenu mnBills_1 = new JMenu("Bills");
		mnBills_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		mnReports.add(mnBills_1);
		
		JMenuItem mntmReceiptsReports = new JMenuItem("Receipts Reports");
		mntmReceiptsReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try
				{
				receipt_reports so=new receipt_reports();
				
				so.getContentPane().setLayout(new BorderLayout(1,1));
				//System.out.println("clicked");
				contentPane.add(so);
				so.setVisible(true);
				so.setSelected(true);
				so.toFront();
				so.repaint();
				so.setMaximum(true);
				}catch(Exception e1){
				e1.printStackTrace();
				}
			
			}
		});
		mnBills_1.add(mntmReceiptsReports);
		
		JMenuItem mntmPaymentsReports = new JMenuItem("Payments Reports");
		mntmPaymentsReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try
				{
				payments_reports so=new payments_reports();
				
				so.getContentPane().setLayout(new BorderLayout(1,1));
				//System.out.println("clicked");
				contentPane.add(so);
				so.setVisible(true);
				so.setSelected(true);
				so.toFront();
				so.repaint();
				so.setMaximum(true);
				}catch(Exception e1){
				e1.printStackTrace();
				}
			
			}
		});
		mnBills_1.add(mntmPaymentsReports);
		
		JMenu mnLogOut = new JMenu("Log Out");
		mnLogOut.setFont(new Font("Times New Roman", Font.BOLD, 14));
		mnLogOut.setBackground(SystemColor.activeCaption);
		menuBar.add(mnLogOut);
		
		JMenuItem Close = new JMenuItem("Close");
		Close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				dispose();
			Loginn lo=new Loginn();
			
				}catch(Exception e1){
					e1.printStackTrace();
				}
			
			}
		});
		mnLogOut.add(Close);
		getContentPane().setLayout(null);
		
		
		/*JLabel background = new JLabel(new ImageIcon("F:\\DBProjectJan2017\\image\\scover2.jpg"));
		background.setForeground(new Color(127, 255, 0));
		background.setBackground(new Color(127, 255, 0));
		background.setBounds(0, -21, 1336, 699);
		getContentPane().add(background);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{menuBar, mnNewMenu, SAdd, Owner, OAdd, OSearch, mnFlat, FAdd, FModify, separator, mnFlatmember, FMAdd, FMSearch, separator_1, mnTransfer, TAdd, TSearch, mnService, SeAdd, SeModify, separator_2, mnServicehistory, SHAdd, SHModify, mnVendor, VAdd, VModify, separator_3, mnNewMvendorcontractenu, VCAdd, VCModify, mnSocietystaff, SSAdd, SSModify, mnBills, mnReceicpt, RAdd, RModify, separator_4, mnPayments, PAdd, PModify, mnHelpdesk, HDAdd, mnLogOut, Close, contentPane, background}));*/		
	}
	public void toFront() {
		 int sta = super.getExtendedState() & ~JFrame.ICONIFIED & JFrame.NORMAL;

		    super.setExtendedState(sta);
		    super.setAlwaysOnTop(true);
		    super.toFront();
		    super.requestFocus();
		    super.setAlwaysOnTop(false);
		   
		}
}
