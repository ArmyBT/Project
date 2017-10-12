package Employee;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import Customer.Session;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Announcejob {

	public JFrame frame;
	private JTextField idtf;
	private JTextField nametf;
	private JTextField datetf;
	private JTextField amounttf;
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
					Announcejob window = new Announcejob();
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
	public Announcejob() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		Session ss = new Session();
		// LoginForm lf = new LoginForm();
		int comid = Integer.parseInt(ss.getSession());
		System.out.println(comid);

		try {

			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

			conn = DriverManager
					.getConnection("jdbc:ucanaccess://C:/AdvoopPrj/prjoop.accdb");

			// C:\Users\numan\git\Project\AdvoopPrj\prjoop.accdb

			String qq = "SELECT * FROM com where comid = '" + comid + "' ";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(qq);

			while (rs.next()) {

				System.out.println("\n" + rs.getString(8) + "\t"
						+ rs.getString(1) + "\t" + rs.getString(2) + "\t"
						+ rs.getString(3) + "\t" + rs.getString(4) + "\t"
						+ rs.getString(5) + "\t" + rs.getString(6) + "\t"
						+ rs.getString(7));

				// String dates = new
				// SimpleDateFormat("dd/MM/yyyy").format(rs.getString(5));

			}
		} catch (Exception eb) {
			System.err.println(eb);

		}

		frame = new JFrame();
		frame.setBounds(100, 100, 608, 461);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel label = new JLabel(
				"\u0E1B\u0E23\u0E30\u0E01\u0E32\u0E28\u0E23\u0E31\u0E1A\u0E2A\u0E21\u0E31\u0E04\u0E23\u0E07\u0E32\u0E19");
		label.setFont(new Font("Tahoma", Font.BOLD, 25));
		label.setBounds(10, 11, 238, 31);
		frame.getContentPane().add(label);

		JLabel lblId = new JLabel(
				"\u0E23\u0E2B\u0E31\u0E2A\u0E1A\u0E23\u0E34\u0E29\u0E31\u0E17:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblId.setBounds(161, 83, 107, 27);
		frame.getContentPane().add(lblId);

		JLabel label_1 = new JLabel(
				"\u0E40\u0E01\u0E35\u0E48\u0E22\u0E27\u0E01\u0E31\u0E1A\u0E07\u0E32\u0E19:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_1.setBounds(148, 130, 120, 27);
		frame.getContentPane().add(label_1);

		JLabel label_2 = new JLabel(
				"\u0E40\u0E1B\u0E34\u0E14\u0E23\u0E31\u0E1A\u0E15\u0E31\u0E49\u0E07\u0E41\u0E15\u0E48\u0E27\u0E31\u0E19\u0E17\u0E35\u0E48\u0E16\u0E36\u0E07\u0E27\u0E31\u0E19\u0E17\u0E35\u0E48:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_2.setBounds(39, 184, 229, 27);
		frame.getContentPane().add(label_2);

		JLabel label_3 = new JLabel(
				"\u0E08\u0E33\u0E19\u0E27\u0E19\u0E17\u0E35\u0E48\u0E23\u0E31\u0E1A:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_3.setBounds(159, 236, 109, 31);
		frame.getContentPane().add(label_3);

		idtf = new JTextField();
		idtf.setEditable(false);
		idtf.setBounds(280, 90, 191, 20);
		frame.getContentPane().add(idtf);
		idtf.setColumns(10);
		idtf.setText(Integer.toString(comid));

		nametf = new JTextField();
		nametf.setBounds(278, 137, 193, 20);
		frame.getContentPane().add(nametf);
		nametf.setColumns(10);

		datetf = new JTextField();
		datetf.setBounds(278, 191, 193, 20);
		frame.getContentPane().add(datetf);
		datetf.setColumns(10);

		amounttf = new JTextField();
		amounttf.setBounds(278, 245, 193, 20);
		frame.getContentPane().add(amounttf);
		amounttf.setColumns(10);

		JButton savebtn = new JButton("\u0E1B\u0E23\u0E30\u0E01\u0E32\u0E28");
		savebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				sql = "insert into announce (aboutjob,adate,amount,comid) values('"
						+ nametf.getText()
						+ "','"
						+ datetf.getText()
						+ "','"
						+ amounttf.getText() + "','" + comid + "')";
				try {

					if (stmt.executeUpdate(sql) != 0) {
						JOptionPane.showMessageDialog(null,
								"บันทึกข้อมูลเรียบร้อยแล้ว");
					} else {
						JOptionPane.showMessageDialog(null, "ERROR");
					}

					/*
					 * rs.first(); textField1.setText(rs.getString(2));
					 * textField2.setText(rs.getString(3));
					 * textField3.setText(rs.getString(4));
					 */

				} catch (Exception err) {
					err.printStackTrace();
				}

			}
		});
		savebtn.setBounds(466, 302, 89, 23);
		frame.getContentPane().add(savebtn);

		JButton canclebtn = new JButton("\u0E22\u0E01\u0E40\u0E25\u0E34\u0E01");
		canclebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*JTable_Search window = new JTable_Search();
				window.setVisible(true);*/
				frame.dispose();
				
				nametf.setText(null);
				datetf.setText(null);
				amounttf.setText(null);

			}
		});
		canclebtn.setBounds(368, 302, 89, 23);
		frame.getContentPane().add(canclebtn);
	}
}
