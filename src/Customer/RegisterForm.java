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
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;

import com.toedter.calendar.JDateChooser;

import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterForm {

	private JFrame frame;
	private JTextField usernametf;
	private JPasswordField passwordtf;
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

			conn = DriverManager
					.getConnection("jdbc:ucanaccess://C:/Users/numan/git/Project/AdvoopPrj/prjoop.accdb");
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
		
		JButton btnLogin = new JButton("Sign up");
		
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Company");
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Appllicant");
		
		ButtonGroup groupStatus = new ButtonGroup();
		groupStatus.add(rdbtnNewRadioButton);
		groupStatus.add(rdbtnNewRadioButton_1);
		
		
		JButton btnClickHereTo = new JButton("Click Here to Login");
		
		JLabel lblCandidateStatus = new JLabel("Candidate status:");
		lblCandidateStatus.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		passwordtf = new JPasswordField();
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String dio = null;
				if(rdbtnNewRadioButton.isSelected()){
					dio = rdbtnNewRadioButton.getText();
				}else if(rdbtnNewRadioButton_1.isSelected()){
					dio = rdbtnNewRadioButton_1.getText();
				}
				
				String un = usernametf.getText();
				String ps = new String(passwordtf.getPassword());
				
				sql = "insert into cus (username,password,status) values('"
						+ un + "','"
						+ ps + "','"
						+ dio + "')";
				

				if(dio.equals("Company")){
					
					sql = "insert into com (username,password,comstatus) values('"
							+ un + "','"
							+ ps + "','"
							+ dio + "')";
					
				}else if(dio.equals("Appllicant")){
					
					sql = "insert into cus (username,password,cusstatus) values('"
							+ un + "','"
							+ ps + "','"
							+ dio + "')";
					
				}
				
				
				try {

					stmt.executeUpdate(sql);
					
					if (stmt.executeUpdate(sql) != 0) {
						JOptionPane.showMessageDialog(null,
								"�ѹ�֡���������º��������");}else{
									JOptionPane.showMessageDialog(null,
											"ERROR");}


						/*rs.first();
						textField1.setText(rs.getString(2));
						textField2.setText(rs.getString(3));
						textField3.setText(rs.getString(4));*/
					

				} catch (Exception err) {
					err.printStackTrace();
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
