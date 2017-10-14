package Employee;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import Customer.Session;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ResultOffering {

	 JFrame frame;
	private JTable table;
	String query, sql, driver;
	Statement stmt;
	ResultSet rs;
	Connection conn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResultOffering window = new ResultOffering();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ResultOffering() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		Session ss = new Session();
		int comid = Integer.parseInt(ss.getSession());
		System.out.println(comid);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 788, 329);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u0E1C\u0E25\u0E01\u0E32\u0E23\u0E40\u0E2A\u0E19\u0E2D\u0E07\u0E32\u0E19");
		label.setFont(new Font("Tahoma", Font.BOLD, 25));
		label.setBounds(60, 23, 187, 39);
		frame.getContentPane().add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(58, 61, 658, 181);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addColumn("หมายเลขข้อเสนอ");
		model.addColumn("ชื่อบริษัท");
		model.addColumn("ผู้รับข้อเสนอ");
		model.addColumn("รายละเอียด");
		model.addColumn("สถานะ");
		
		try {

			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

			conn = DriverManager
					.getConnection("jdbc:ucanaccess://C:/AdvoopPrj/prjoop.accdb");

			// C:\Users\numan\git\Project\AdvoopPrj\prjoop.accdb

			query = "SELECT offer.offid,com.comname,cus.cusname,offer.offer,offer.status FROM (offer inner join com on offer.comid=com.comid)inner join cus on offer.cusid=cus.cusid where com.comid = '"
					+ comid + "'";
			PreparedStatement pre;
			pre = conn.prepareStatement(query);
			ResultSet rs = pre.executeQuery();

			int row = 0;
			while ((rs != null) && (rs.next())) {
				model.addRow(new Object[0]);
				model.setValueAt(rs.getString(1), row, 0);
				model.setValueAt(rs.getString(2), row, 1);
				model.setValueAt(rs.getString(3), row, 2);
				model.setValueAt(rs.getString(4), row, 3);
                model.setValueAt(rs.getString(5), row, 4);
				 // model.setValueAt(rs.getString(6), row, 5);
				 

				row++;

			}

		} catch (Exception eb) {
			System.err.println(eb);

		}

		
		JButton closebtn = new JButton("\u0E1B\u0E34\u0E14\u0E2B\u0E19\u0E49\u0E32\u0E15\u0E48\u0E32\u0E07\u0E19\u0E35\u0E49");
		closebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
			}
		});
		closebtn.setBounds(613, 253, 103, 23);
		frame.getContentPane().add(closebtn);
		
		JButton button = new JButton("\u0E25\u0E1A\u0E02\u0E49\u0E2D\u0E40\u0E2A\u0E19\u0E2D");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int column1 = 0;
				int row = table.getSelectedRow();
				String value = table.getModel().getValueAt(row, column1).toString();
				int del = Integer.parseInt(value);
				System.out.println(del);
				
				sql = "delete from  offer where offid  = '"
						+ del + "'";
				try {


					int confirm = JOptionPane.showConfirmDialog(null,
							"คุณต้องการลบ:" + value + "หรือไม่",
							"คำยืนยัน", JOptionPane.YES_NO_OPTION);
					if (confirm == JOptionPane.YES_OPTION) {

						stmt = conn.createStatement();
						stmt.executeUpdate(sql);

						JOptionPane
								.showMessageDialog(null, "ลบข้อมูลเรียบร้อย");
						
						int row1 = 0;
						while ((rs != null) && (rs.next())) {
							model.addRow(new Object[0]);
							model.setValueAt(rs.getString(1), row1, 0);
							model.setValueAt(rs.getString(2), row1, 1);
							model.setValueAt(rs.getString(3), row1, 2);
							model.setValueAt(rs.getString(4), row1, 3);
			                model.setValueAt(rs.getString(5), row1, 4);
							 // model.setValueAt(rs.getString(6), row, 5);
							 

			                row1++;

						}


					} else if (confirm == JOptionPane.NO_OPTION) {
						return;
					}

				} catch (Exception err) {
					err.printStackTrace();
				}
			}
		});
		button.setBounds(60, 253, 89, 23);
		frame.getContentPane().add(button);
	}
}
