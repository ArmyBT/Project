package Customer;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JLabel;
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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import javax.swing.JFormattedTextField;
import com.toedter.calendar.JDateChooser;

public class RegisterForm {

	private JFrame frame;
	private JTextField usernametf;
	private JTextField passwordtf;

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
		frame = new JFrame();
		frame.setBounds(100, 100, 491, 333);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblLogin = new JLabel("Register");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 44));
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		usernametf = new JTextField();
		usernametf.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		passwordtf = new JTextField();
		passwordtf.setColumns(10);
		
		JButton btnCancel = new JButton("Cancel");
		
		JButton btnLogin = new JButton("Login");
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Company");
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Appllicant");
		
		JButton btnClickHereTo = new JButton("Click Here to Login");
		
		JLabel lblCandidateStatus = new JLabel("Candidate status:");
		lblCandidateStatus.setFont(new Font("Tahoma", Font.BOLD, 18));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(41, Short.MAX_VALUE)
					.addComponent(lblLogin)
					.addGap(291))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(btnClickHereTo, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(btnCancel)
								.addGap(18)
								.addComponent(btnLogin)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblCandidateStatus)
								.addComponent(lblUsername))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(rdbtnNewRadioButton)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(rdbtnNewRadioButton_1))
								.addComponent(usernametf, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblPassword)
							.addGap(18)
							.addComponent(passwordtf, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(57, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
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
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(usernametf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsername))
					.addGap(8)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordtf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnClickHereTo)
					.addGap(113))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
