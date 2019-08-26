import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Label;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.JMenuItem;

import java.awt.Font;

import javax.swing.ImageIcon;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sun.rowset.internal.Row;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
public class payments_reports extends JInternalFrame {
	 private Vector<String> columnNames = new Vector<String>();
		private Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		private javax.swing.JScrollPane scrollPane;
		private JTable table;
		private JPanel tablePanel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					payments_reports frame = new payments_reports();
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
	public payments_reports() {
		setClosable(true);
		setMaximizable(true);
		setTitle("Payment Report");
		setBounds(100, 100, 1362, 718);
		getContentPane().setLayout(null);
		
		JMenuItem mntmPrint = new JMenuItem("Print");
		mntmPrint.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JFrame yourComponent = new JFrame();
				PrinterJob pjob = PrinterJob.getPrinterJob();
				PageFormat preformat = pjob.defaultPage();
				preformat.setOrientation(PageFormat.LANDSCAPE);
				PageFormat postformat = pjob.pageDialog(preformat);
				//If user does not hit cancel then print.
				if (preformat != postformat) 
				{//Set print component
				    pjob.setPrintable(new Printer(yourComponent), postformat);
				    if (pjob.printDialog()) 
				    {
				        try {pjob.print();} 
				        catch (PrinterException e1) {e1.printStackTrace();}
							
					}
			
				}
			}	
				});
		mntmPrint.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\print-icon.png"));
		mntmPrint.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mntmPrint.setBounds(0, 0, 87, 30);
		getContentPane().add(mntmPrint);
		
		JMenuItem mntmExport = new JMenuItem("Export ");
		mntmExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
                    /*ExcelExporter exp = new ExcelExporter();
                    exp.fillData(table, new File("F:\\DBProjectJan2017\\src\\payment_result.xls"));
                    JOptionPane.showMessageDialog(null, "Data saved at " +
                            "'F:\\DBProjectJan2017\\src\\payment_result.xls' successfully", "Message",
                            JOptionPane.INFORMATION_MESSAGE);*/
					
					 File file= new File("F:\\DBProjectJan2017\\src\\payment_result.xls");
		              
		               
	                   HSSFWorkbook fWorkbook = new HSSFWorkbook();
	                   HSSFSheet fSheet = fWorkbook.createSheet("new Sheet");
	                   HSSFFont sheetTitleFont = fWorkbook.createFont();
	                 
	                   HSSFCellStyle cellStyle = fWorkbook.createCellStyle();

	                   sheetTitleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	                   //sheetTitleFont.setColor();
	                   TableModel model = table.getModel();


	                   for (int i = 0; i < model.getRowCount(); i++) {
	                       HSSFRow fRow = fSheet.createRow((short) i);
	                       for (int j = 0; j < model.getColumnCount(); j++) {
	                           HSSFCell cell = fRow.createCell((short) j);
	                           cell.setCellValue(model.getValueAt(i, j).toString());
	                           cell.setCellStyle(cellStyle);

	                       }

	                   }
	   FileOutputStream fileOutputStream;
	               fileOutputStream = new FileOutputStream(file);
	               BufferedOutputStream bos = new BufferedOutputStream(fileOutputStream);
	               fWorkbook.write(bos);
	               bos.close();
	               fileOutputStream.close();
	   


	for (int i = 0; i < model.getColumnCount(); i++) {
	               HSSFRow fRow = fSheet.createRow((short) i);
	               for(int j = 0; j < model.getColumnCount(); j++) {
	                   HSSFCell cell = fRow.createCell((short) j);
	                   cell.setCellValue(model.getValueAt(i, j).toString());

	                   System.out.println(model.getColumnName(j));
	               }
	           }   
					
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

			
			}
		});
		mntmExport.setIcon(new ImageIcon("F:\\DBProjectJan2017\\src\\Logos-Excel-icon.png"));
		mntmExport.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mntmExport.setBounds(86, 0, 87, 30);
		getContentPane().add(mntmExport);
		
		try{
			
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:mypro");
			Statement stmt = con.createStatement();
			ResultSet rs=null;
			
			//data.clear();
			
			
				//System.out.println("d");
				String q1="select * from PAYMENT order by PAYMENT_ID";
				rs = stmt.executeQuery( q1 );
				//buildTableModel(rs);
				ResultSetMetaData md = rs.getMetaData();
				int columns = md.getColumnCount();
				for (int i = 1; i <= columns; i++) 
				    {
					columnNames.addElement( md.getColumnName(i) );
					//System.out.println("c"+md.getColumnName(i));
					}
				System.out.println(rs.getFetchSize()+"in");
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
			tablePanel = new JPanel();
		  
			
			tablePanel.setBounds(50, 50, 1266, 590);
			tablePanel.setLocation(50, 50);
			getContentPane().add( tablePanel,BorderLayout.CENTER );
			tablePanel.setLayout(null);
			
			table = new JTable(data, columnNames);
			
			getContentPane().add(table);
			scrollPane = new JScrollPane( table );
			scrollPane.setBounds(10, 11, 1246, 568);
			tablePanel.add(scrollPane);
			
			DefaultTableModel dtm = (DefaultTableModel) table.getModel();
			table.repaint();
		    //dtm.setRowCount(10);
			validate();
			
			getContentPane().repaint();
			
		}
			catch(Exception e1) 
			{
			System.out.println( e1 );
			}
		
		
		/*scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 41, 414, 218);
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);*/
		
	}

}
