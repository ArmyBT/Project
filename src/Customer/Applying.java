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

public class Applying {

	private JFrame frame;
	private JTextField usernametf;
	private JTextField passwordtf;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Applying window = new Applying();
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
	public Applying() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 533, 551);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblLogin = new JLabel("\u0E41\u0E1A\u0E1A\u0E1F\u0E2D\u0E23\u0E4C\u0E21\u0E01\u0E32\u0E23\u0E2A\u0E21\u0E31\u0E04\u0E23\u0E07\u0E32\u0E19");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 44));
		
		JLabel lblUsername = new JLabel("\u0E0A\u0E37\u0E48\u0E2D - \u0E19\u0E32\u0E21\u0E2A\u0E38\u0E01\u0E25 :");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		usernametf = new JTextField();
		usernametf.setColumns(10);
		
		JLabel Education = new JLabel("\u0E27\u0E38\u0E12\u0E34\u0E01\u0E32\u0E23\u0E28\u0E36\u0E01\u0E29\u0E32 :");
		Education.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		passwordtf = new JTextField();
		passwordtf.setColumns(10);
		
		JButton btnCancel = new JButton("\u0E22\u0E01\u0E40\u0E25\u0E34\u0E01");
		
		JButton btnSave = new JButton("\u0E1A\u0E31\u0E19\u0E17\u0E36\u0E01");
		
		JLabel Graduated = new JLabel("\u0E08\u0E1A\u0E08\u0E32\u0E01 :");
		Graduated.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel Faculty = new JLabel("\u0E04\u0E13\u0E30:");
		Faculty.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel Talent = new JLabel("\u0E04\u0E27\u0E32\u0E21\u0E2A\u0E32\u0E21\u0E32\u0E23\u0E16\u0E1E\u0E34\u0E40\u0E28\u0E29 :");
		Talent.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JTextArea textArea = new JTextArea();
		
		JLabel Bdate = new JLabel("\u0E40\u0E01\u0E34\u0E14\u0E27\u0E31\u0E19\u0E17\u0E35\u0E48 :");
		Bdate.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JDateChooser dateChooser = new JDateChooser();
		
		JLabel Phone = new JLabel("\u0E2B\u0E21\u0E32\u0E22\u0E40\u0E25\u0E02\u0E42\u0E17\u0E23\u0E28\u0E31\u0E1E\u0E17\u0E4C :");
		Phone.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel Address = new JLabel("\u0E17\u0E35\u0E48\u0E2D\u0E22\u0E39\u0E48 :");
		Address.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JTextArea textArea_1 = new JTextArea();
		
		JLabel AboutME = new JLabel("\u0E23\u0E32\u0E22\u0E25\u0E30\u0E40\u0E2D\u0E35\u0E22\u0E14\u0E40\u0E1E\u0E34\u0E48\u0E21\u0E40\u0E15\u0E34\u0E48\u0E21 :");
		AboutME.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JTextArea textArea_2 = new JTextArea();
		
		JRadioButton ButtonMale = new JRadioButton("\u0E0A\u0E32\u0E22");
		
		JRadioButton ButtonFemale = new JRadioButton("\u0E2B\u0E0D\u0E34\u0E07");
		
		JLabel sex = new JLabel("\u0E40\u0E1E\u0E28 :");
		sex.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JDateChooser dateChooser_1 = new JDateChooser();
		
		JLabel label = new JLabel("\u0E40\u0E01\u0E34\u0E14\u0E27\u0E31\u0E19\u0E17\u0E35\u0E48\u0E2A\u0E21\u0E31\u0E04\u0E23 :");
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(88)
									.addComponent(Bdate, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(6)
									.addComponent(Phone, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(Education)
										.addGap(18)
										.addComponent(passwordtf, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(Graduated, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(Faculty, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(Talent, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE))
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
											.addComponent(sex)
											.addComponent(lblUsername))
										.addGap(18)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(ButtonMale)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(ButtonFemale))
											.addComponent(usernametf, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE))))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(118)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(Address, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(textArea_1, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(btnCancel)
											.addGap(18)
											.addComponent(btnSave))))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(AboutME)
									.addGap(18)
									.addComponent(textArea_2, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(53)
							.addComponent(label)
							.addGap(18)
							.addComponent(dateChooser_1, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(22)
							.addComponent(lblLogin)))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblLogin, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(dateChooser_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(ButtonMale)
							.addComponent(ButtonFemale))
						.addComponent(sex, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(usernametf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsername))
					.addGap(3)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordtf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(Education))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(Graduated, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(Faculty, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(17)
							.addComponent(Talent, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(Bdate, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(Phone, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(17)
							.addComponent(Address, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addComponent(textArea_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textArea_2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(17)
							.addComponent(AboutME, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(52))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
