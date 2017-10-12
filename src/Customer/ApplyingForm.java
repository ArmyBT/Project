package Customer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JButton;

import Employee.JTable_Search;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ApplyingForm {

	protected JFrame frame;
	private JTextField annidtf;
	private JTextField comidtf;
	private JTextField cusidtf;

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
					for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
							.getInstalledLookAndFeels()) {
						if ("Nimbus".equals(info.getName())) {
							javax.swing.UIManager.setLookAndFeel(info
									.getClassName());
							break;
						}
					}
				} catch (ClassNotFoundException ex) {
					java.util.logging.Logger.getLogger(
							ApplyingForm.class.getName()).log(
							java.util.logging.Level.SEVERE, null, ex);
				} catch (InstantiationException ex) {
					java.util.logging.Logger.getLogger(
							ApplyingForm.class.getName()).log(
							java.util.logging.Level.SEVERE, null, ex);
				} catch (IllegalAccessException ex) {
					java.util.logging.Logger.getLogger(
							ApplyingForm.class.getName()).log(
							java.util.logging.Level.SEVERE, null, ex);
				} catch (javax.swing.UnsupportedLookAndFeelException ex) {
					java.util.logging.Logger.getLogger(
							ApplyingForm.class.getName()).log(
							java.util.logging.Level.SEVERE, null, ex);
				}

				try {
					ApplyingForm window = new ApplyingForm();
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
	public ApplyingForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		Session ss = new Session();
		ApplyingSession as = new ApplyingSession();
		int cusid = Integer.parseInt(ss.getSession());
		String annid = as.getCol1();
		String comid = as.getCol2();
		System.out.println(annid);
		System.out.println(comid);
		System.out.println(cusid);

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
		frame.setBounds(100, 100, 628, 465);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel(
				"\u0E41\u0E1A\u0E1A\u0E1F\u0E2D\u0E23\u0E4C\u0E21\u0E2A\u0E21\u0E31\u0E04\u0E23\u0E07\u0E32\u0E19");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(10, 11, 233, 36);
		frame.getContentPane().add(lblNewLabel);

		JLabel label = new JLabel(
				"\u0E2B\u0E21\u0E32\u0E22\u0E40\u0E25\u0E02\u0E07\u0E32\u0E19\u0E17\u0E35\u0E48\u0E40\u0E1B\u0E34\u0E14\u0E23\u0E31\u0E1A\u0E2A\u0E21\u0E31\u0E04\u0E23:");
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(33, 89, 255, 25);
		frame.getContentPane().add(label);

		JLabel label_1 = new JLabel(
				"\u0E2B\u0E21\u0E32\u0E22\u0E40\u0E25\u0E02\u0E1A\u0E23\u0E34\u0E29\u0E31\u0E17:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_1.setBounds(140, 139, 144, 25);
		frame.getContentPane().add(label_1);

		JLabel label_2 = new JLabel(
				"\u0E23\u0E2B\u0E31\u0E2A\u0E1B\u0E23\u0E30\u0E08\u0E33\u0E15\u0E31\u0E27\u0E1C\u0E39\u0E49\u0E2A\u0E21\u0E31\u0E04\u0E23:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_2.setBounds(95, 189, 193, 25);
		frame.getContentPane().add(label_2);

		JLabel label_3 = new JLabel(
				"\u0E23\u0E32\u0E22\u0E25\u0E30\u0E40\u0E2D\u0E35\u0E22\u0E14\u0E40\u0E1E\u0E34\u0E48\u0E21\u0E40\u0E15\u0E34\u0E21:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_3.setBounds(108, 238, 182, 25);
		frame.getContentPane().add(label_3);

		annidtf = new JTextField();
		annidtf.setEditable(false);
		annidtf.setBounds(298, 95, 86, 25);
		frame.getContentPane().add(annidtf);
		annidtf.setColumns(10);

		comidtf = new JTextField();
		comidtf.setEditable(false);
		comidtf.setBounds(298, 143, 86, 25);
		frame.getContentPane().add(comidtf);
		comidtf.setColumns(10);

		cusidtf = new JTextField();
		cusidtf.setEditable(false);
		cusidtf.setBounds(298, 195, 86, 25);
		frame.getContentPane().add(cusidtf);
		cusidtf.setColumns(10);

		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(300, 244, 284, 126);
		frame.getContentPane().add(editorPane);

		annidtf.setText(annid);
		comidtf.setText(comid);
		cusidtf.setText(Integer.toString(cusid));

		JButton button = new JButton("\u0E22\u0E37\u0E19\u0E22\u0E31\u0E19");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				sql = "insert into applying (cusid,comid,appliying,anid,status) values('"
						+ cusid
						+ "','"
						+ Integer.parseInt(comid)
						+ "','"
						+ editorPane.getText()
						+ "','"
						+ Integer.parseInt(annid) + "','รอ')";
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
		button.setBounds(498, 381, 89, 23);
		frame.getContentPane().add(button);

		JButton button_1 = new JButton("\u0E22\u0E01\u0E40\u0E25\u0E34\u0E01");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
				editorPane.setText(null);

			}
		});
		button_1.setBounds(399, 381, 89, 23);
		frame.getContentPane().add(button_1);
	}
}
