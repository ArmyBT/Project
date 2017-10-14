package Employee;

import java.awt.EventQueue;

import javax.swing.JFrame;

import Customer.ApplyingSession;
import Customer.Session;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OfferingForm {

	 JFrame frame;
	 private JTextField cusidtf;
	 private JTextField comidtf;
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
					OfferingForm window = new OfferingForm();
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
	public OfferingForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Session ss = new Session();
		OfferingSession as = new OfferingSession();
		int comid = Integer.parseInt(ss.getSession());
		int cusid =  Integer.parseInt(as.getCol1());
		
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
		frame.setBounds(100, 100, 601, 435);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u0E41\u0E1A\u0E1A\u0E1F\u0E2D\u0E23\u0E4C\u0E21\u0E2A\u0E21\u0E31\u0E04\u0E23\u0E07\u0E32\u0E19");
		label.setFont(new Font("Tahoma", Font.BOLD, 25));
		label.setBounds(48, 36, 229, 36);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u0E2B\u0E21\u0E32\u0E22\u0E40\u0E25\u0E02\u0E1C\u0E39\u0E49\u0E23\u0E31\u0E1A\u0E02\u0E49\u0E2D\u0E40\u0E2A\u0E19\u0E2D:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_1.setBounds(34, 122, 204, 22);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u0E2B\u0E21\u0E32\u0E22\u0E40\u0E25\u0E02\u0E1A\u0E23\u0E34\u0E29\u0E31\u0E17:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_2.setBounds(80, 168, 134, 38);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u0E23\u0E32\u0E22\u0E25\u0E30\u0E40\u0E2D\u0E35\u0E22\u0E14\u0E02\u0E49\u0E2D\u0E40\u0E2A\u0E19\u0E2D:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_3.setBounds(49, 217, 165, 29);
		frame.getContentPane().add(label_3);
		
		cusidtf = new JTextField();
		cusidtf.setEditable(false);
		cusidtf.setBounds(230, 122, 217, 29);
		frame.getContentPane().add(cusidtf);
		cusidtf.setColumns(10);
		
		comidtf = new JTextField();
		comidtf.setEditable(false);
		comidtf.setBounds(230, 177, 217, 26);
		frame.getContentPane().add(comidtf);
		comidtf.setColumns(10);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(231, 224, 323, 101);
		frame.getContentPane().add(editorPane);
		
		cusidtf.setText(Integer.toString(cusid));
		comidtf.setText(Integer.toString(comid));
		
		JButton button = new JButton("\u0E22\u0E37\u0E19\u0E22\u0E31\u0E19");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sql = "insert into offer (cusid,comid,offer,status) values('"
						+ cusid
						+ "','"
						+ comid
						+ "','"
						+ editorPane.getText()
						+ "','รอ')";
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
		button.setBounds(465, 349, 89, 23);
		frame.getContentPane().add(button);
		
		JButton canclebtn = new JButton("\u0E22\u0E01\u0E40\u0E25\u0E34\u0E01");
		canclebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				editorPane.setText(null);
				frame.dispose();
			}
		});
		canclebtn.setBounds(372, 349, 89, 23);
		frame.getContentPane().add(canclebtn);
		
		
		
	}
}
