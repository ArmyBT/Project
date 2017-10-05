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

public class Login {

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
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblLogin = new JLabel("Login");
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
		
		JButton btnClickHereTo = new JButton("Click Here to Create a new account");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblUsername)
									.addGap(18)
									.addComponent(usernametf, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblPassword)
									.addGap(18)
									.addComponent(passwordtf, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnClickHereTo)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnCancel)
									.addGap(18)
									.addComponent(btnLogin))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(156)
							.addComponent(lblLogin)))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addComponent(lblLogin, GroupLayout.PREFERRED_SIZE, 52, Short.MAX_VALUE)
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(usernametf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsername))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordtf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnClickHereTo)
					.addGap(20))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
