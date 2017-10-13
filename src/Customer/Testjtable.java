package Customer;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import Employee.JTable_Search;
import java.awt.Font;
import javax.swing.JSeparator;

public class Testjtable  extends JFrame {
	
	Connection connect = null;
	Statement s = null;
	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
			         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
			             if ("Nimbus".equals(info.getName())) {
			                 javax.swing.UIManager.setLookAndFeel(info.getClassName());
			                 break;
			             }
			         }
			     } catch (ClassNotFoundException ex) {
			         java.util.logging.Logger.getLogger(JTable_Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			     } catch (InstantiationException ex) {
			         java.util.logging.Logger.getLogger(JTable_Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			     } catch (IllegalAccessException ex) {
			         java.util.logging.Logger.getLogger(JTable_Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			     } catch (javax.swing.UnsupportedLookAndFeelException ex) {
			         java.util.logging.Logger.getLogger(JTable_Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			     }
				try {
				Testjtable frame = new Testjtable();
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
	public Testjtable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 991, 368);
		setTitle("Home");
		getContentPane().setLayout(null);
		
		// Customer Label
		JLabel lblCustomer = new JLabel("\u0E07\u0E32\u0E19\u0E17\u0E35\u0E48\u0E01\u0E33\u0E25\u0E31\u0E07\u0E40\u0E1B\u0E34\u0E14\u0E23\u0E31\u0E1A\u0E2A\u0E21\u0E31\u0E04\u0E23");
		lblCustomer.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblCustomer.setBounds(72, 25, 270, 31);
		getContentPane().add(lblCustomer);
		
		// ScrollPane for Table
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(72, 63, 836, 188);
		getContentPane().add(scrollPane);
		
		
		// Table
		JTable table = new JTable();
				
		// Model for Table
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.addColumn("รหัสใบสมัคร");
		model.addColumn("หมายเลขบริษัท");
		model.addColumn("บริษัท");
		model.addColumn("วันที่รับสมัคร");
		model.addColumn("งาน");
		model.addColumn("จำนวนที่รับ(คน)");
		
		Scanner input = new Scanner(System.in);

	/*	System.out
				.println("enter data base want see 1=com 2=cus 3=applying 4=offer: ");
		String data = input.nextLine();
		System.out.println("Check username: ");
		String name = input.nextLine();
		
		String check = "SELECT announce.anid,com.comname,announce.adate,announce.aboutjob,announce.amount FROM announce INNER JOIN com ON announce.comid = com.comid;  ";

		String test = "";*/
		
		String check = "SELECT announce.anid,com.comid,com.comname,announce.adate,announce.aboutjob,announce.amount FROM announce INNER JOIN com ON announce.comid = com.comid;  ";

		
		try {

			Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/AdvoopPrj/prjoop.accdb");
			Statement s = conn.createStatement();

			// s.executeUpdate("insert into lab6 (sakul,country,cast) values('fsf','Gafme',12345)");
			// s.executeUpdate("insert into lab6 (sakul,country,cast) values('rwfe','32212',3223)");

			
		/*	if(data.equals("1")){
				check = "SELECT announce.anid,com.comname,announce.adate,announce.aboutjob,announce.amount FROM announce INNER JOIN com ON announce.comid = com.comid;  ";
			}else if(data.equals("2")){
				check = "SELECT * FROM com";
			}*/
			
			/*PreparedStatement pstmt = conn.prepareStatement("select * from login where username = ? ");
			pstmt.setString(1,name);
			ResultSet rs1= pstmt.executeQuery();*/
			int row = 0;
			
			ResultSet rs = s.executeQuery(check);
			
			while((rs!=null) && (rs.next()))
            {			
				model.addRow(new Object[0]);
				model.setValueAt(rs.getString(1), row, 0);
				model.setValueAt(rs.getString(2), row, 1);
				model.setValueAt(rs.getString(3), row, 2);
				model.setValueAt(rs.getString(4), row, 3);
				model.setValueAt(rs.getString(5), row, 4);
				model.setValueAt(rs.getString(6), row, 5);
				row++;
				
				/*
				 * 		model.addRow(new Object[]{
						rec.getString("CustomerID")
						,rec.getString("Name"),rec.getString("Email")
						,rec.getString("CountryCode")
						,rec.getString("Budget")
						,rec.getString("Used")
						});
				 */
            }
			//rs1.close();
             
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
		
		int row = table.getRowCount();
		int column = table.getColumnCount();
		for (int j = 0; j  < row; j++) {
		    for (int i = 0; i  < column; i++) {
		        System.out.println(table.getValueAt(j, i));
		    }
		}
		
		try {
			if(s != null) {
				s.close();
				connect.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		scrollPane.setViewportView(table);		
		
		JButton btnSelect = new JButton("\u0E2A\u0E21\u0E31\u0E04\u0E23");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int column1 = 0;
				int column2 = 1;
				int row = table.getSelectedRow();
				String value = table.getModel().getValueAt(row, column1).toString();
				String value1 = table.getModel().getValueAt(row, column2).toString();
				System.out.println(value);
				System.out.println(value1);
				
				   ApplyingSession as = new ApplyingSession();
				   as.setCol1(value);
				   as.setCol2(value1);
				   
				   ApplyingForm af = new ApplyingForm();
				   af.frame.setVisible(true);
				
				
			}
		});
		btnSelect.setBounds(819, 262, 89, 23);
		getContentPane().add(btnSelect);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		mnMenu.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnMenu);
		
		JMenuItem mntmProfile = new JMenuItem("Profile");
		mntmProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddCustomer ac = new AddCustomer();
				ac.frame.setVisible(true);
				
			}
		});
		mnMenu.add(mntmProfile);
		
		JSeparator separator = new JSeparator();
		mnMenu.add(separator);
		
		JMenuItem menuItem = new JMenuItem("\u0E1C\u0E25\u0E01\u0E32\u0E23\u0E2A\u0E21\u0E31\u0E04\u0E23\u0E07\u0E32\u0E19");
		mnMenu.add(menuItem);
		
		JMenuItem menuItem_2 = new JMenuItem("\u0E02\u0E49\u0E2D\u0E40\u0E2A\u0E19\u0E2D\u0E07\u0E32\u0E19");
		mnMenu.add(menuItem_2);
		
		JSeparator separator_1 = new JSeparator();
		mnMenu.add(separator_1);
		
		JMenuItem menuItem_1 = new JMenuItem("\u0E2D\u0E2D\u0E01\u0E08\u0E32\u0E01\u0E23\u0E30\u0E1A\u0E1A");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Testjtable frame = new Testjtable();
				frame.setVisible(false);
				
				LoginForm lf = new LoginForm();
				lf.frame.setVisible(true);
			}
		});
		mnMenu.add(menuItem_1);
		
		JMenuItem mntmExits = new JMenuItem("Exits");
		mntmExits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		mnMenu.add(mntmExits);

	}
}