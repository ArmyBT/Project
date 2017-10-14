package Employee;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import Customer.LoginForm;
import Customer.RegisterForm;
import Customer.Session;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;



public class HomeCompany {

	public JFrame frame;
	private JTextField textField;
	int comid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeCompany window = new HomeCompany();
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
	public HomeCompany() {
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
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 802, 359);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblHome = new JLabel("Home");
		lblHome.setBounds(10, 10, 106, 32);
		lblHome.setFont(new Font("TH Sarabun New", Font.BOLD, 30));
		
		JButton applybtn = new JButton("\u0E1B\u0E23\u0E30\u0E01\u0E32\u0E28\u0E2A\u0E21\u0E31\u0E04\u0E23\u0E07\u0E32\u0E19");
		applybtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Announcejob ann = new Announcejob();
				ann.frame.setVisible(true);
				frame.dispose();
				
			}
		});
		applybtn.setFont(new Font("TH Sarabun New", Font.PLAIN, 18));
		applybtn.setBounds(395, 10, 169, 23);
		
		JButton profilebtn = new JButton("Profile");
		profilebtn.setFont(new Font("TH Sarabun New", Font.PLAIN, 18));
		profilebtn.setBounds(574, 10, 96, 23);
		profilebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCompany window = new AddCompany();
				window.frame.setVisible(true);
				
				frame.dispose();
			}
		});
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LoginForm lf = new  LoginForm();
				lf.frame.setVisible(true);
				frame.dispose();
				

			}
		});
		btnLogout.setFont(new Font("TH Sarabun New", Font.PLAIN, 18));
		btnLogout.setBounds(680, 10, 96, 23);
		
		// ScrollPane for Table

			
				
		
		JButton button = new JButton("\u0E2D\u0E48\u0E32\u0E19");
		button.setFont(new Font("TH Sarabun New", Font.PLAIN, 18));
		button.setBounds(642, 273, 124, 36);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblHome);
		frame.getContentPane().add(applybtn);
		frame.getContentPane().add(profilebtn);
		frame.getContentPane().add(button);
		frame.getContentPane().add(btnLogout);
		
		JLabel label = new JLabel("\u0E23\u0E32\u0E22\u0E0A\u0E37\u0E48\u0E2D\u0E1C\u0E39\u0E49\u0E21\u0E35\u0E04\u0E38\u0E13\u0E2A\u0E21\u0E1A\u0E31\u0E15\u0E34");
		label.setFont(new Font("TH Sarabun New", Font.BOLD, 18));
		label.setBounds(10, 77, 179, 22);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(498, 77, 161, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton button_1 = new JButton("\u0E04\u0E49\u0E19\u0E2B\u0E32");
		button_1.setFont(new Font("TH Sarabun New", Font.PLAIN, 18));
		button_1.setBounds(670, 77, 96, 22);
		frame.getContentPane().add(button_1);
	}
}
