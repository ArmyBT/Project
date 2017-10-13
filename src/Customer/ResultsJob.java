package Customer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ResultsJob {

	protected JFrame frame;
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
					ResultsJob window = new ResultsJob();
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
	public ResultsJob() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		Session ss = new Session();
		int cusid = Integer.parseInt(ss.getSession());
		System.out.println(cusid);

		frame = new JFrame();
		frame.setBounds(100, 100, 804, 336);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 54, 716, 189);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addColumn("รหัสใบสมัคร");
		model.addColumn("ชื่อผู้สมัคร");
		model.addColumn("บริษัท");
		model.addColumn("ตำแหน่ง");
		model.addColumn("สถานะ");
		/*
		 * model.addColumn("§Ò¹"); model.addColumn("¨Ó¹Ç¹·ÕèÃÑº(¤¹)");
		 */

		try {

			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

			conn = DriverManager
					.getConnection("jdbc:ucanaccess://C:/AdvoopPrj/prjoop.accdb");

			// C:\Users\numan\git\Project\AdvoopPrj\prjoop.accdb

			query = "SELECT applying.appid,cus.cusname,com.comname,announce.aboutjob,applying.status FROM ((applying inner join com on applying.comid=com.comid)inner join cus on applying.cusid=cus.cusid)inner join announce on applying.anid=announce.anid where cus.cusid = '"
					+ cusid + "'";
			PreparedStatement pre;
			pre = conn.prepareStatement(query);
			ResultSet rs = pre.executeQuery();
			/*
			 * stmt = conn.createStatement(); rs = stmt.executeQuery(query);
			 */
			// table.setModel(DbUtils.resultSetToTableModel(rs));
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

		JLabel label = new JLabel(
				"\u0E1C\u0E25\u0E01\u0E32\u0E23\u0E2A\u0E21\u0E31\u0E04\u0E23\u0E07\u0E32\u0E19");
		label.setFont(new Font("Tahoma", Font.BOLD, 25));
		label.setBounds(44, 11, 203, 31);
		frame.getContentPane().add(label);
		
		JButton button = new JButton("ลบใบสมัคร");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int column1 = 0;
				int row = table.getSelectedRow();
				String value = table.getModel().getValueAt(row, column1).toString();
				int del = Integer.parseInt(value);
				System.out.println(del);
				
				sql = "delete from  applying where appid  = '"
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
		button.setBounds(43, 249, 89, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("ปิดหน้าต่างนี้");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
			}
		});
		button_1.setBounds(655, 254, 104, 23);
		frame.getContentPane().add(button_1);
	}
}