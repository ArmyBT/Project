package Employee;


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

import Customer.AddCustomer;
import Customer.ApplyingForm;
import Customer.ApplyingSession;
import Customer.LoginForm;
import Customer.Session;
import Customer.Testjtable;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.Font;
import javax.swing.JSeparator;

public class JobOffering  extends JFrame {
	
	Connection conn;
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
				JobOffering frame = new JobOffering();
				frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public JobOffering() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 991, 368);
		setTitle("");
		getContentPane().setLayout(null);
		
		// Customer Label
		JLabel lblCustomer = new JLabel("\u0E08\u0E33\u0E19\u0E27\u0E19\u0E1C\u0E39\u0E49\u0E2A\u0E21\u0E31\u0E04\u0E23\u0E07\u0E32\u0E19");
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
		model.addColumn("หมายเลยการสมัครงาน");
		model.addColumn("รหัสผู้สมัคร");
		model.addColumn("ชื่อผู้สมัคร");
		model.addColumn("จบจาก");
		model.addColumn("วุฒิการศึกษา");
		model.addColumn("รายละเอียดเพิ่มเติม");
		model.addColumn("หมายเลขบริษัท");
		
		Scanner input = new Scanner(System.in);
		String check = "SELECT applying.appid,applying.cusid,cus.cusname,cus.graduatedfrom,cus.education, applying.appliying, applying.comid FROM applying INNER JOIN cus ON applying.cusid = cus.cusid;  ";

		try {

			Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/AdvoopPrj/prjoop.accdb");
			Statement s = conn.createStatement();
			
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
				model.setValueAt(rs.getString(7), row, 6);
				row++;
				
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
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		scrollPane.setViewportView(table);		
		
		
	}
}