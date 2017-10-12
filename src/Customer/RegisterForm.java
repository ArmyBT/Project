package Customer;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Font;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;

import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;

import Employee.JTable_Search;

import com.toedter.calendar.JDateChooser;

import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterForm {

	JFrame frame;
	private JTextField usernametf;
	private JPasswordField passwordtf;
	String query, sql, driver;
	Statement stmt;
	ResultSet rs;
	Connection conn;
	String checkun;
	String type;
	String check;
	String id;

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
			         java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			     } catch (InstantiationException ex) {
			         java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			     } catch (IllegalAccessException ex) {
			         java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			     } catch (javax.swing.UnsupportedLookAndFeelException ex) {
			         java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			     }
				
				try {
					RegisterForm window = new RegisterForm();
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
	public RegisterForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
try {
			
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

			conn = DriverManager.getConnection("jdbc:ucanaccess://C:/AdvoopPrj/prjoop.accdb");

			//C:\Users\numan\git\Project\AdvoopPrj\prjoop.accdb

			query = "SELECT * FROM com";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
		} catch (Exception eb) {
			System.err.println(eb);

		}
		
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 533, 337);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblLogin = new JLabel("Register");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 44));
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		usernametf = new JTextField();
		usernametf.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				usernametf.setText(null);
				passwordtf.setText(null);
			}
		});
		
		JButton btnLogin = new JButton("Sign up");
		
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Company");
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Appllicant");
		
		ButtonGroup groupStatus = new ButtonGroup();
		groupStatus.add(rdbtnNewRadioButton);
		groupStatus.add(rdbtnNewRadioButton_1);
		
		
		JButton btnClickHereTo = new JButton("Click Here to Login");
		btnClickHereTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				LoginForm window = new LoginForm();
				window.frame.setVisible(true);
				
				frame.dispose();

			}
		});
		
		JLabel lblCandidateStatus = new JLabel("Candidate status:");
		lblCandidateStatus.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		passwordtf = new JPasswordField();
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		System.out.println(dtf.format(localDate));
		Date myDate = new Date();
		System.out.println(myDate);
		System.out.println(new SimpleDateFormat("dd/MM/yyyy").format(myDate));
		String dates = new SimpleDateFormat("dd/MM/yyyy").format(myDate);
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				String un = usernametf.getText();
				String ps = new String(passwordtf.getPassword());
				String dio;
				   dio = null;
				if(rdbtnNewRadioButton.isSelected()){
					dio = rdbtnNewRadioButton.getText();
				}else if(rdbtnNewRadioButton_1.isSelected()){
					dio = rdbtnNewRadioButton_1.getText();
				}
			
				

				if(dio.equals("Company")){
					
					sql = "insert into login (username,password,type) values('"
							+ un + "','"
							+ ps + "','"
							+ dio + "')";
					
					checkun = "select * from login where username = ?";
					
				}else if(dio.equals("Appllicant")){
					
					sql = "insert into login (username,password,type) values('"
							+ un + "','"
							+ ps + "','"
							+ dio + "')";
					checkun = "select * from login where username = ?";
					
				}
				
				check = "SELECT id FROM login where username = '" +un+ "'";
				
				try {

					
					PreparedStatement pstmt = conn.prepareStatement(checkun);
					pstmt.setString(1,un);
					ResultSet rs1= pstmt.executeQuery();
					
					if(rs1.next()){
						JOptionPane.showMessageDialog(null,
								"มี Username นี้อยู่แล้วกรุณาสมัครใหม่");
						usernametf.setText(null);
						passwordtf.setText(null);
					}else{
					if (stmt.executeUpdate(sql) != 0) {
						JOptionPane.showMessageDialog(null,
								"บันทึกข้อมูลเรียบร้อยแล้ว");}else{
									JOptionPane.showMessageDialog(null,
											"ERROR");}
					
					
					ResultSet rs = stmt.executeQuery(check);
					while (rs.next()) {
					 id = rs.getString(1);
					}
					String id1 = id;
					//System.out.println(id1);
					
					if(dio.equals("Company")){
						type = "insert into com (comid,comname,address,about,found,phone,ceo,email) values('"+id1+"','empty','empty','empty',#"+dates+"#,'empty','empty','empty')";
					}else if(dio.equals("Appllicant")){
						type = "insert into cus (cusid,cusname,bdate,graduatedfrom,faculty,talent,address,phone,education,aboutme,email) values('"+id1+"','empty',#"+dates+"#,'empty','empty','empty','empty','empty','empty','empty','empty')";
					}
					stmt.executeUpdate(type);
					
					}

					
					

				} catch (Exception err) {
					System.out.println(err);
				}
				
				usernametf.setText(null);
				passwordtf.setText(null);

				
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(41, Short.MAX_VALUE)
					.addComponent(lblLogin)
					.addGap(141)
					.addComponent(btnClickHereTo, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(289)
							.addComponent(btnCancel)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnLogin))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblCandidateStatus)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblPassword)
									.addComponent(lblUsername)))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(rdbtnNewRadioButton)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(rdbtnNewRadioButton_1))
								.addComponent(usernametf, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
								.addComponent(passwordtf, Alignment.TRAILING))))
					.addContainerGap(57, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblLogin, GroupLayout.PREFERRED_SIZE, 112, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(rdbtnNewRadioButton)
										.addComponent(rdbtnNewRadioButton_1))
									.addGap(12))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblCandidateStatus)
									.addPreferredGap(ComponentPlacement.UNRELATED))))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnClickHereTo)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(usernametf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsername))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordtf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancel, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
						.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(35))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
