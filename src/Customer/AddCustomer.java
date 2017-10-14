package Customer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JEditorPane;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import Employee.JTable_Search;

import com.toedter.calendar.JDateChooser;

public class AddCustomer {

	public JFrame frame;
	private JTextField idtf;
	private JTextField nametf;
	private JTextField gratf;
	private JTextField sakhatf;
	private JTextField talenttf;
	private JTextField phonetf;
	private JTextField edutf;
	private JTextField aboutmetf;
	private JTextField emailtf;

	String query, sql, driver;
	Statement stmt;
	ResultSet rs;
	Connection conn;
	private JTextField datetf;

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
			         java.util.logging.Logger.getLogger(AddCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			     } catch (InstantiationException ex) {
			         java.util.logging.Logger.getLogger(AddCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			     } catch (IllegalAccessException ex) {
			         java.util.logging.Logger.getLogger(AddCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			     } catch (javax.swing.UnsupportedLookAndFeelException ex) {
			         java.util.logging.Logger.getLogger(AddCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			     }
				
				try {
					AddCustomer window = new AddCustomer();
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
	public AddCustomer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		Session ss = new Session();
		// LoginForm lf = new LoginForm();
		int cusid = Integer.parseInt(ss.getSession());
		System.out.println(cusid);
		try {

			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

			conn = DriverManager
					.getConnection("jdbc:ucanaccess://C:/AdvoopPrj/prjoop.accdb");

			// C:\Users\numan\git\Project\AdvoopPrj\prjoop.accdb

			String qq = "SELECT * FROM cus where cusid = '" + cusid + "' ";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(qq);

			while (rs.next()) {

				System.out.println("\n" + rs.getString(8) + "\t"
						+ rs.getString(1) + "\t" + rs.getString(2) + "\t"
						+ rs.getString(3) + "\t" + rs.getString(4) + "\t"
						+ rs.getString(5) + "\t" + rs.getString(6) + "\t"
						+ rs.getString(7) + "\t" + rs.getString(8) + "\t"
						+ rs.getString(9) + "\t" + rs.getString(10) + "\t"
						+ rs.getString(11));

				// String dates = new
				// SimpleDateFormat("dd/MM/yyyy").format(rs.getString(5));

			}
		} catch (Exception eb) {
			System.err.println(eb);

		}

		frame = new JFrame();
		frame.setBounds(100, 100, 615, 542);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*
		 * UtilDateModel model = new UtilDateModel();
		 * //model.setDate(20,04,2014); // Need this... Properties p = new
		 * Properties(); p.put("text.today", "Today"); p.put("text.month",
		 * "Month"); p.put("text.year", "Year"); JDatePanelImpl datePanel = new
		 * JDatePanelImpl(model, p); // Don't know about the formatter, but
		 * there it is... JDatePickerImpl datePicker = new
		 * JDatePickerImpl(datePanel, new DateLabelFormatter());
		 */

		JLabel label = new JLabel(
				"\u0E02\u0E49\u0E2D\u0E21\u0E39\u0E25\u0E2A\u0E48\u0E27\u0E19\u0E15\u0E31\u0E27");
		label.setBounds(10, 0, 142, 46);
		label.setFont(new Font("Tahoma", Font.BOLD, 25));

		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(127, 57, 23, 14);
		lblId.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel label_1 = new JLabel(
				"\u0E0A\u0E37\u0E48\u0E2D-\u0E2A\u0E01\u0E38\u0E25:");
		label_1.setBounds(90, 79, 62, 24);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel label_2 = new JLabel(
				"\u0E27\u0E31\u0E19\u0E40\u0E01\u0E34\u0E14:");
		label_2.setBounds(101, 114, 51, 24);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel label_3 = new JLabel(
				"\u0E08\u0E1A\u0E01\u0E32\u0E23\u0E28\u0E36\u0E01\u0E29\u0E32\u0E08\u0E32\u0E01:");
		label_3.setBounds(36, 149, 116, 28);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel label_4 = new JLabel("\u0E2A\u0E32\u0E02\u0E32:");
		label_4.setBounds(106, 188, 46, 24);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel label_5 = new JLabel(
				"\u0E04\u0E27\u0E32\u0E21\u0E2A\u0E32\u0E21\u0E32\u0E23\u0E16\u0E1E\u0E34\u0E40\u0E28\u0E29:");
		label_5.setBounds(19, 223, 133, 24);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel label_6 = new JLabel(
				"\u0E17\u0E35\u0E48\u0E2D\u0E22\u0E39\u0E48:");
		label_6.setBounds(116, 258, 36, 33);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel label_7 = new JLabel(
				"\u0E40\u0E1A\u0E2D\u0E23\u0E4C\u0E42\u0E17\u0E23\u0E28\u0E31\u0E1E\u0E17\u0E4C:");
		label_7.setBounds(60, 329, 97, 24);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel label_8 = new JLabel(
				"\u0E27\u0E38\u0E12\u0E34\u0E01\u0E32\u0E23\u0E28\u0E36\u0E01\u0E29\u0E32:");
		label_8.setBounds(60, 364, 93, 26);
		label_8.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel label_9 = new JLabel(
				"\u0E40\u0E01\u0E35\u0E48\u0E22\u0E27\u0E01\u0E31\u0E1A\u0E09\u0E31\u0E19:");
		label_9.setBounds(70, 401, 85, 25);
		label_9.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(101, 437, 46, 25);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));

		JButton editbtn = new JButton("\u0E41\u0E01\u0E49\u0E44\u0E02");

		editbtn.setBounds(500, 57, 89, 23);

		JButton savebtn = new JButton("\u0E1A\u0E31\u0E19\u0E17\u0E36\u0E01");

		savebtn.setEnabled(false);
		savebtn.setBounds(500, 91, 89, 23);

		JButton canclebtn = new JButton("\u0E22\u0E01\u0E40\u0E25\u0E34\u0E01");
		canclebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
			}
		});
		canclebtn.setBounds(500, 121, 89, 23);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(label);
		frame.getContentPane().add(lblId);
		frame.getContentPane().add(label_1);
		frame.getContentPane().add(label_2);
		frame.getContentPane().add(label_3);
		frame.getContentPane().add(label_4);
		frame.getContentPane().add(label_5);
		frame.getContentPane().add(label_6);
		frame.getContentPane().add(label_7);
		frame.getContentPane().add(label_8);
		frame.getContentPane().add(label_9);
		frame.getContentPane().add(lblEmail);
		frame.getContentPane().add(editbtn);
		frame.getContentPane().add(savebtn);
		frame.getContentPane().add(canclebtn);

		idtf = new JTextField();
		idtf.setEditable(false);
		idtf.setBounds(163, 56, 254, 24);
		frame.getContentPane().add(idtf);
		idtf.setColumns(10);

		nametf = new JTextField();
		nametf.setEditable(false);
		nametf.setBounds(163, 83, 254, 24);
		frame.getContentPane().add(nametf);
		nametf.setColumns(10);

		gratf = new JTextField();
		gratf.setEditable(false);
		gratf.setBounds(163, 155, 254, 24);
		frame.getContentPane().add(gratf);
		gratf.setColumns(10);

		sakhatf = new JTextField();
		sakhatf.setEditable(false);
		sakhatf.setBounds(163, 192, 254, 24);
		frame.getContentPane().add(sakhatf);
		sakhatf.setColumns(10);

		talenttf = new JTextField();
		talenttf.setEditable(false);
		talenttf.setBounds(163, 227, 254, 24);
		frame.getContentPane().add(talenttf);
		talenttf.setColumns(10);

		JEditorPane adressEP = new JEditorPane();
		adressEP.setEditable(false);
		adressEP.setBounds(164, 266, 253, 56);
		frame.getContentPane().add(adressEP);

		phonetf = new JTextField();
		phonetf.setEditable(false);
		phonetf.setBounds(164, 333, 253, 28);
		frame.getContentPane().add(phonetf);
		phonetf.setColumns(10);

		edutf = new JTextField();
		edutf.setEditable(false);
		edutf.setBounds(164, 369, 253, 24);
		frame.getContentPane().add(edutf);
		edutf.setColumns(10);

		aboutmetf = new JTextField();
		aboutmetf.setEditable(false);
		aboutmetf.setBounds(163, 401, 254, 28);
		frame.getContentPane().add(aboutmetf);
		aboutmetf.setColumns(10);

		emailtf = new JTextField();
		emailtf.setEditable(false);
		emailtf.setBounds(163, 437, 254, 28);
		frame.getContentPane().add(emailtf);
		emailtf.setColumns(10);
		
		datetf = new JTextField();
		datetf.setEditable(false);
		datetf.setBounds(162, 118, 255, 26);
		frame.getContentPane().add(datetf);
		datetf.setColumns(10);

		try {

			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

			conn = DriverManager
					.getConnection("jdbc:ucanaccess://C:/AdvoopPrj/prjoop.accdb");

			// C:\Users\numan\git\Project\AdvoopPrj\prjoop.accdb

			String qq = "SELECT * FROM cus where cusid = '" + cusid + "'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(qq);

			while (rs.next()) {
				//String dateValue = rs.getString(2);
				//Date date = new SimpleDateFormat("dd-MM-yyyy").parse(dateValue);

				// Date date = new
				// SimpleDateFormat("dd/MM/yyyy").parse(rs.getString(4));

				idtf.setText(rs.getString("cusid"));
				nametf.setText(rs.getString("cusname"));
				gratf.setText(rs.getString("graduatedfrom"));
				phonetf.setText(rs.getString("phone"));
				datetf.setText(rs.getString("bdate"));
				talenttf.setText(rs.getString("talent"));
				aboutmetf.setText(rs.getString("aboutme"));
				emailtf.setText(rs.getString("email"));
				adressEP.setText(rs.getString("address"));
				edutf.setText(rs.getString("education"));
				sakhatf.setText(rs.getString("faculty"));

			}
		} catch (Exception eb) {
			System.err.println(eb);

		}

		editbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				savebtn.setEnabled(true);

				nametf.setEditable(true);
				gratf.setEditable(true);
				phonetf.setEditable(true);
				talenttf.setEditable(true);
				aboutmetf.setEditable(true);
				emailtf.setEditable(true);
				adressEP.setEditable(true);
				edutf.setEditable(true);
				sakhatf.setEditable(true);
				datetf.setEditable(true);
				editbtn.setEnabled(false);
			}
		});

		canclebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				savebtn.setEnabled(false);
				nametf.setEditable(false);// 1
				gratf.setEditable(false);// 1
				phonetf.setEditable(false);// 1
				talenttf.setEditable(false);
				aboutmetf.setEditable(false);// 1
				emailtf.setEditable(false);// 1
				adressEP.setEditable(false);// 1
				edutf.setEditable(false);// 1
				sakhatf.setEditable(false);// 1
				datetf.setEditable(false);
				editbtn.setEnabled(true);
				
				

			}
		});

		savebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				sql = "UPDATE cus SET cusname = '" + nametf.getText()
						+ "',address='" + adressEP.getText() + "',bdate='"
						+ datetf.getText() + "',phone='" + phonetf.getText()
						+ "',aboutme='" + aboutmetf.getText()
						+ "',graduatedfrom='" + gratf.getText() + "',email='"
						+ emailtf.getText() + "',education='" + edutf.getText()
						+ "',faculty='" + sakhatf.getText() + "',talent='"
						+ talenttf.getText() + "' where cusid = '" + cusid
						+ "'";

				try {

					int confirm = JOptionPane.showConfirmDialog(null,
							"คุณต้องการแก้ไข:" + nametf.getText() + "ใช้",
							"ไม่", JOptionPane.YES_NO_OPTION);
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
				
				savebtn.setEnabled(false);
				nametf.setEditable(false);// 1
				gratf.setEditable(false);// 1
				phonetf.setEditable(false);// 1
				talenttf.setEditable(false);
				aboutmetf.setEditable(false);// 1
				emailtf.setEditable(false);// 1
				adressEP.setEditable(false);// 1
				edutf.setEditable(false);// 1
				sakhatf.setEditable(false);// 1
				datetf.setEditable(false);
				editbtn.setEnabled(true);
				

			}
		});

	}
}
