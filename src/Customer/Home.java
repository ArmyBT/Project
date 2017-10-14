package Customer;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;




public class Home {

	public JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
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
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblHome = new JLabel("Home");
		lblHome.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		
		JButton applybtn = new JButton("\u0E2A\u0E21\u0E31\u0E04\u0E23\u0E07\u0E32\u0E19");
		
		JButton alertapplybtn = new JButton("\u0E1C\u0E25\u0E01\u0E32\u0E23\u0E2A\u0E21\u0E31\u0E04\u0E23\u0E07\u0E32\u0E19");
		
		JButton profilebtn = new JButton("Profile");
		
		JButton btnLogout = new JButton("Logout");
	
		
		
		// Model for Table
			
		
		JButton button = new JButton("\u0E2D\u0E48\u0E32\u0E19");
		
		table = new JTable();
		
		
		
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(7)
					.addComponent(lblHome)
					.addGap(10)
					.addComponent(applybtn)
					.addGap(8)
					.addComponent(alertapplybtn)
					.addGap(8)
					.addComponent(profilebtn)
					.addGap(8)
					.addComponent(btnLogout)
					.addContainerGap(7, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(318, Short.MAX_VALUE)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(18)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(7)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblHome)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(11)
							.addComponent(applybtn))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(11)
							.addComponent(alertapplybtn))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(11)
							.addComponent(profilebtn))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(11)
							.addComponent(btnLogout)))
					.addGap(32)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
