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


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


import Customer.Session;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddCompany {

	int i;
	public JFrame frame;
	private JTextField usernametf;
	private JTextField textPhone;
	private JTextField textCEO;
	private JTextField textAddress;
	private JTextField textContact;
	private JTextField idtf;
	private JTextField emailtf;
	private JTextField datetf;

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

				System.out.println("\n"
						+ rs.getString("comid") + "\t" + rs.getString("comname") + "\t"
						+ rs.getString("address") + "\t" + rs.getString("about") + "\t"
						+ rs.getString("found") + "\t" + rs.getString("phone") + "\t"
						+ rs.getString("ceo")+"\t"+ rs.getString("email"));

				// String dates = new
				// SimpleDateFormat("dd/MM/yyyy").format(rs.getString(5));

			}
		} catch (Exception eb) {
			System.err.println(eb);

		}

		frame = new JFrame();
		frame.setBounds(100, 100, 587, 521);
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

			/*	usernametf.setText("");
				textAddress.setText("");
				textPhone.setText("");
				textCEO.setText("");
				textContact.setText("");*/
				
				/*JTable_Search window = new JTable_Search();
				window.setVisible(true);*/
				frame.dispose();
				
			}
		});
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
		
		datetf = new JTextField();
		datetf.setColumns(10);

		try {




			String qq = "SELECT * FROM com where comid = '" + comid + "'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(qq);

			while (rs.next()) {
				
			

				

				idtf.setText(rs.getString("comid"));
				usernametf.setText(rs.getString("comname"));
				textAddress.setText(rs.getString("address"));
				textPhone.setText(rs.getString("phone"));
				datetf.setText(rs.getString("found"));
				textCEO.setText(rs.getString("ceo"));
				textContact.setText(rs.getString("about"));
				emailtf.setText(rs.getString("email"));

			}
		} catch (Exception eb) {
			System.err.println(eb);

		}

		JButton btnSave = new JButton("\u0E1A\u0E31\u0E19\u0E17\u0E36\u0E01");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				sql = "UPDATE com SET comname = '" + usernametf.getText()
						+ "',address='" + textAddress.getText() + "',found='"
						+ datetf.getText() + "',phone='" + textPhone.getText() + "',ceo='"
						+ textCEO.getText() + "',about='"
						+ textContact.getText() + "',email='"
						+ emailtf.getText() + "'where comid = '" + comid + "'";

				try {

					int confirm = JOptionPane.showConfirmDialog(null,
							"คุณต้องการแก้ไข:" + usernametf.getText()
									+ "ใช้", "ไม่",
							JOptionPane.YES_NO_OPTION);
					if (confirm == JOptionPane.YES_OPTION) {

						Statement s = conn.createStatement();

						if (s.executeUpdate(sql) != 0) {
							JOptionPane.showMessageDialog(null,
									"บันทึกเรียบร้อย");
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
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblCompany)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(Address, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblId)
								.addComponent(Phone, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblUsername)
								.addComponent(Bdate)
								.addComponent(lblCeo)
								.addComponent(AboutME)
								.addComponent(lblEmail))
							.addGap(4)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textCEO, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(datetf, Alignment.LEADING)
									.addComponent(textPhone, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
								.addComponent(textAddress, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
								.addComponent(idtf, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
								.addComponent(usernametf, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(emailtf, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(textContact, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)))
					.addGap(69))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(372, Short.MAX_VALUE)
					.addComponent(btnCancel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnSave)
					.addGap(65))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(idtf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblId))
							.addGap(8)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(usernametf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblUsername)))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblCompany, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
							.addGap(46)))
					.addGap(5)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textAddress, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(datetf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(Bdate, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
							.addGap(8)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(Phone, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
						.addComponent(Address, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(textCEO, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(14)
							.addComponent(textContact, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblCeo)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(AboutME, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(emailtf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmail))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(142))
		);
		frame.getContentPane().setLayout(groupLayout);

	}
}