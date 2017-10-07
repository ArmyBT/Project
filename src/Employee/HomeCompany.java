package Employee;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import Customer.RegisterForm;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;



public class HomeCompany {

	private JFrame frame;
	private JTable table;
	private JTextField textField;

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
		frame = new JFrame();
		frame.setBounds(100, 100, 586, 359);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblHome = new JLabel("Home");
		lblHome.setBounds(10, 10, 62, 32);
		lblHome.setFont(new Font("TH Sarabun New", Font.BOLD, 30));
		
		JButton applybtn = new JButton("\u0E40\u0E07\u0E37\u0E48\u0E2D\u0E19\u0E44\u0E02\u0E01\u0E32\u0E23\u0E2A\u0E21\u0E31\u0E04\u0E23");
		applybtn.setFont(new Font("TH Sarabun New", Font.PLAIN, 18));
		applybtn.setBounds(280, 55, 121, 23);
		
		JButton profilebtn = new JButton("Profile");
		profilebtn.setFont(new Font("TH Sarabun New", Font.PLAIN, 18));
		profilebtn.setBounds(401, 55, 84, 23);
		profilebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCompany window = new AddCompany();
				window.frame.setVisible(true);
				
				frame.dispose();
			}
		});
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("TH Sarabun New", Font.PLAIN, 18));
		btnLogout.setBounds(483, 11, 77, 34);
		
		table = new JTable();
		table.setBounds(7, 81, 478, 163);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		
		JButton button = new JButton("\u0E2D\u0E48\u0E32\u0E19");
		button.setFont(new Font("TH Sarabun New", Font.PLAIN, 18));
		button.setBounds(495, 209, 65, 36);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(table);
		frame.getContentPane().add(lblHome);
		frame.getContentPane().add(applybtn);
		frame.getContentPane().add(profilebtn);
		frame.getContentPane().add(button);
		frame.getContentPane().add(btnLogout);
		
		JLabel label = new JLabel("\u0E23\u0E32\u0E22\u0E0A\u0E37\u0E48\u0E2D\u0E1C\u0E39\u0E49\u0E2A\u0E21\u0E31\u0E04\u0E23");
		label.setFont(new Font("TH Sarabun New", Font.BOLD, 18));
		label.setBounds(7, 58, 69, 17);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(82, 56, 128, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton button_1 = new JButton("\u0E04\u0E49\u0E19\u0E2B\u0E32");
		button_1.setFont(new Font("TH Sarabun New", Font.PLAIN, 18));
		button_1.setBounds(210, 55, 69, 23);
		frame.getContentPane().add(button_1);
	}
}
