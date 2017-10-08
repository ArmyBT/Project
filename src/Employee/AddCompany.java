package Employee;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Font;

import javax.swing.LayoutStyle.ComponentPlacement;

import javax.swing.text.JTextComponent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import Customer.Session;

import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddCompany {

	int i;
	public JFrame frame;
	private JTextField usernametf;
	private JTextField textPhone;
	private JTextField textCEO;
	protected JTextComponent dateChooser;
	private JTextField textAddress;
	private JTextField textContact;
	private JTextField idtf;
	private JTextField emailtf;

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
					AddCompany window = new AddCompany();
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
	public AddCompany() {
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
		frame.setBounds(100, 100, 587, 554);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblCompany = new JLabel(
				"\u0E02\u0E49\u0E2D\u0E21\u0E39\u0E25\u0E1A\u0E23\u0E34\u0E29\u0E31\u0E17");
		lblCompany.setFont(new Font("Tahoma", Font.BOLD, 44));

		JLabel lblUsername = new JLabel(
				"\u0E0A\u0E37\u0E48\u0E2D\u0E1A\u0E23\u0E34\u0E29\u0E31\u0E17 :");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 18));

		usernametf = new JTextField();

		frame.getContentPane().add(usernametf);
		usernametf.setColumns(10);

		JButton btnCancel = new JButton("\u0E22\u0E01\u0E40\u0E25\u0E34\u0E01");
		btnCancel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				usernametf.setText("");
				textAddress.setText("");
				textPhone.setText("");
				textCEO.setText("");
				textContact.setText("");
			}
		});

		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setDateFormatString("dd/MM/yyyy");
		dateChooser_1.setEnabled(true);
		// String dob=""+dateChooser_1.getDate();

		JLabel Bdate = new JLabel(
				"\u0E27\u0E31\u0E19\u0E17\u0E35\u0E48\u0E01\u0E48\u0E2D\u0E15\u0E31\u0E49\u0E07 :");
		Bdate.setFont(new Font("Tahoma", Font.BOLD, 18));

		JLabel Phone = new JLabel(
				"\u0E2B\u0E21\u0E32\u0E22\u0E40\u0E25\u0E02\u0E42\u0E17\u0E23\u0E28\u0E31\u0E1E\u0E17\u0E4C :");
		Phone.setFont(new Font("Tahoma", Font.BOLD, 18));

		textPhone = new JTextField();
		textPhone.setBounds(182, 80, 119, 26);
		frame.getContentPane().add(textPhone);
		textPhone.setColumns(10);

		JLabel Address = new JLabel(
				"\u0E17\u0E35\u0E48\u0E2D\u0E22\u0E39\u0E48 :");
		Address.setFont(new Font("Tahoma", Font.BOLD, 18));

		JLabel AboutME = new JLabel(
				"\u0E23\u0E32\u0E22\u0E25\u0E30\u0E40\u0E2D\u0E35\u0E22\u0E14\u0E40\u0E1E\u0E34\u0E48\u0E21\u0E40\u0E15\u0E34\u0E48\u0E21 :");
		AboutME.setFont(new Font("Tahoma", Font.BOLD, 18));

		JLabel lblCeo = new JLabel("\u0E0A\u0E37\u0E48\u0E2D CEO :");
		lblCeo.setFont(new Font("Tahoma", Font.BOLD, 18));

		textCEO = new JTextField();
		textCEO.setBounds(182, 80, 119, 26);
		frame.getContentPane().add(textCEO);
		textCEO.setColumns(10);

		textAddress = new JTextField();
		textAddress.setColumns(10);

		textContact = new JTextField();
		textContact.setColumns(10);

		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 18));

		idtf = new JTextField();
		idtf.setColumns(10);
		idtf.setEditable(false);

		emailtf = new JTextField();
		emailtf.setColumns(10);

		try {

			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

			conn = DriverManager
					.getConnection("jdbc:ucanaccess://C:/AdvoopPrj/prjoop.accdb");

			// C:\Users\numan\git\Project\AdvoopPrj\prjoop.accdb

			String qq = "SELECT * FROM com where comid = '" + comid + "'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(qq);

			while (rs.next()) {
				String dateValue = rs.getString(4);
				java.util.Date date = new SimpleDateFormat("dd-MM-yyyy")
						.parse(dateValue);
				// String dates = new
				// SimpleDateFormat("dd/MM/yyyy").format(rs.getString(5));

				idtf.setText(rs.getString(8));
				usernametf.setText(rs.getString(1));
				textAddress.setText(rs.getString(2));
				textPhone.setText(rs.getString(5));
				dateChooser_1.setDate(date);
				textCEO.setText(rs.getString(6));
				textContact.setText(rs.getString(3));
				emailtf.setText(rs.getString(7));

			}
		} catch (Exception eb) {
			System.err.println(eb);

		}

		String dates = new SimpleDateFormat("dd/MM/yyyy").format(dateChooser_1
				.getDate());

		JButton btnSave = new JButton("\u0E1A\u0E31\u0E19\u0E17\u0E36\u0E01");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				sql = "UPDATE com SET comname = '" + usernametf.getText()
						+ "',address='" + textAddress.getText() + "',found=#"
						+ dates + "#,phone='" + textPhone.getText() + "',ceo='"
						+ textCEO.getText() + "',about='"
						+ textContact.getText() + "',email='"
						+ emailtf.getText() + "'where comid = '" + comid + "'";

				try {

					int confirm = JOptionPane.showConfirmDialog(null,
							"คุณต้องการแก้ไข:" + usernametf.getText()
									+ "หรือไม่", "คำยืนยัน",
							JOptionPane.YES_NO_OPTION);
					if (confirm == JOptionPane.YES_OPTION) {

						Statement s = conn.createStatement();

						if (s.executeUpdate(sql) != 0) {
							JOptionPane.showMessageDialog(null,
									"แก้ไขข้อมูลเรียบร้อยแล้ว");
						} else {
							JOptionPane.showMessageDialog(null, "ERROR");
						}

					} else if (confirm == JOptionPane.NO_OPTION) {
						return;
					}

				} catch (Exception err) {
					err.printStackTrace();
				}
			}

		});

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 18));

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.TRAILING)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGap(403)
																		.addComponent(
																				btnCancel)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				btnSave))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGap(10)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.TRAILING)
																						.addComponent(
																								lblCompany)
																						.addGroup(
																								groupLayout
																										.createSequentialGroup()
																										.addGroup(
																												groupLayout
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addGroup(
																																groupLayout
																																		.createParallelGroup(
																																				Alignment.TRAILING)
																																		.addComponent(
																																				lblCeo)
																																		.addComponent(
																																				Phone,
																																				GroupLayout.PREFERRED_SIZE,
																																				160,
																																				GroupLayout.PREFERRED_SIZE)
																																		.addComponent(
																																				Bdate)
																																		.addComponent(
																																				AboutME)
																																		.addComponent(
																																				lblEmail))
																														.addGroup(
																																groupLayout
																																		.createSequentialGroup()
																																		.addGap(80)
																																		.addGroup(
																																				groupLayout
																																						.createParallelGroup(
																																								Alignment.TRAILING)
																																						.addComponent(
																																								lblId)
																																						.addComponent(
																																								lblUsername)
																																						.addComponent(
																																								Address,
																																								GroupLayout.PREFERRED_SIZE,
																																								48,
																																								GroupLayout.PREFERRED_SIZE))))
																										.addGap(4)))
																		.addGap(18)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								emailtf,
																								GroupLayout.DEFAULT_SIZE,
																								276,
																								Short.MAX_VALUE)
																						.addComponent(
																								textCEO,
																								GroupLayout.DEFAULT_SIZE,
																								276,
																								Short.MAX_VALUE)
																						.addComponent(
																								textContact,
																								GroupLayout.DEFAULT_SIZE,
																								276,
																								Short.MAX_VALUE)
																						.addComponent(
																								textAddress,
																								GroupLayout.DEFAULT_SIZE,
																								276,
																								Short.MAX_VALUE)
																						.addComponent(
																								idtf,
																								GroupLayout.DEFAULT_SIZE,
																								276,
																								Short.MAX_VALUE)
																						.addComponent(
																								usernametf,
																								GroupLayout.DEFAULT_SIZE,
																								276,
																								Short.MAX_VALUE)
																						.addGroup(
																								groupLayout
																										.createParallelGroup(
																												Alignment.TRAILING,
																												false)
																										.addComponent(
																												dateChooser_1,
																												Alignment.LEADING,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												Short.MAX_VALUE)
																										.addComponent(
																												textPhone,
																												Alignment.LEADING,
																												GroupLayout.DEFAULT_SIZE,
																												169,
																												Short.MAX_VALUE)))))
										.addGap(69)));
		groupLayout
				.setVerticalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(lblCompany,
												GroupLayout.PREFERRED_SIZE, 76,
												GroupLayout.PREFERRED_SIZE)
										.addGap(40)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addComponent(
																				idtf,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(8)
																		.addComponent(
																				usernametf,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addComponent(
																				lblId)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				lblUsername)))
										.addGap(5)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																textAddress,
																GroupLayout.PREFERRED_SIZE,
																65,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																Address,
																GroupLayout.PREFERRED_SIZE,
																22,
																GroupLayout.PREFERRED_SIZE))
										.addGap(11)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																Bdate,
																GroupLayout.PREFERRED_SIZE,
																22,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																dateChooser_1,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(8)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addComponent(
																				textPhone,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				textCEO,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(18)
																		.addComponent(
																				textContact,
																				GroupLayout.PREFERRED_SIZE,
																				65,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addComponent(
																				Phone,
																				GroupLayout.PREFERRED_SIZE,
																				22,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				lblCeo)
																		.addGap(18)
																		.addComponent(
																				AboutME,
																				GroupLayout.PREFERRED_SIZE,
																				22,
																				GroupLayout.PREFERRED_SIZE)))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(lblEmail)
														.addComponent(
																emailtf,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(13)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																btnSave,
																GroupLayout.PREFERRED_SIZE,
																26,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																btnCancel,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addGap(76)));
		frame.getContentPane().setLayout(groupLayout);

	}
}
