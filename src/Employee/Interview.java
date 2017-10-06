package Employee;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Label;
import java.awt.TextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButton;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Button;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Interview {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interview window = new Interview();
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
	public Interview() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 618, 355);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Label label = new Label("\u0E40\u0E23\u0E35\u0E22\u0E19 :");
		label.setFont(new Font("TH Sarabun New", Font.BOLD, 13));
		label.setBounds(10, 10, 30, 22);
		frame.getContentPane().add(label);
		
		TextField textField = new TextField();
		textField.setBounds(46, 10, 122, 22);
		frame.getContentPane().add(textField);
		
		Label label_1 = new Label("\u0E1A\u0E23\u0E34\u0E29\u0E31\u0E17\u0E17\u0E35\u0E48\u0E17\u0E48\u0E32\u0E19\u0E44\u0E14\u0E49\u0E17\u0E33\u0E01\u0E32\u0E23\u0E2A\u0E21\u0E31\u0E04\u0E23\u0E07\u0E32\u0E19\u0E44\u0E27\u0E49\u0E25\u0E48\u0E32\u0E2A\u0E38\u0E14\u0E04\u0E37\u0E2D :");
		label_1.setFont(new Font("TH Sarabun New", Font.BOLD, 13));
		label_1.setBounds(10, 71, 238, 22);
		frame.getContentPane().add(label_1);
		
		TextField textField_1 = new TextField();
		textField_1.setBounds(254, 71, 195, 22);
		frame.getContentPane().add(textField_1);
		
		Label label_2 = new Label("\u0E27\u0E31\u0E19\u0E17\u0E35\u0E48\u0E17\u0E33\u0E01\u0E32\u0E23\u0E2A\u0E21\u0E31\u0E04\u0E23 :");
		label_2.setFont(new Font("TH Sarabun New", Font.BOLD, 13));
		label_2.setBounds(152, 99, 97, 22);
		frame.getContentPane().add(label_2);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(255, 99, 135, 20);
		frame.getContentPane().add(dateChooser);
		
		Label label_3 = new Label("\u0E1C\u0E25\u0E01\u0E32\u0E23\u0E15\u0E23\u0E27\u0E08\u0E2A\u0E2D\u0E1A\u0E04\u0E38\u0E13\u0E2A\u0E21\u0E1A\u0E31\u0E15\u0E34");
		label_3.setFont(new Font("TH Sarabun New", Font.BOLD, 13));
		label_3.setBounds(152, 139, 155, 22);
		frame.getContentPane().add(label_3);
		
		JRadioButton radioButton = new JRadioButton("\u0E1C\u0E48\u0E32\u0E19");
		radioButton.setFont(new Font("TH Sarabun New", Font.BOLD, 17));
		radioButton.setForeground(new Color(0, 153, 102));
		radioButton.setBounds(313, 138, 47, 23);
		frame.getContentPane().add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("\u0E44\u0E21\u0E48\u0E1C\u0E48\u0E32\u0E19");
		radioButton_1.setHorizontalAlignment(SwingConstants.CENTER);
		radioButton_1.setFont(new Font("TH Sarabun New", Font.BOLD, 17));
		radioButton_1.setForeground(new Color(255, 0, 0));
		radioButton_1.setBounds(362, 138, 59, 23);
		frame.getContentPane().add(radioButton_1);
		
		Label label_4 = new Label("\u0E17\u0E31\u0E49\u0E07\u0E19\u0E31\u0E49 \u0E1C\u0E39\u0E49\u0E17\u0E35\u0E48\u0E1C\u0E48\u0E32\u0E19\u0E04\u0E38\u0E13\u0E2A\u0E21\u0E1A\u0E31\u0E15\u0E34\u0E15\u0E32\u0E21\u0E17\u0E35\u0E48\u0E1A\u0E23\u0E34\u0E29\u0E31\u0E17\u0E15\u0E49\u0E2D\u0E07\u0E01\u0E32\u0E23");
		label_4.setFont(new Font("TH Sarabun New", Font.BOLD, 13));
		label_4.setBounds(191, 173, 244, 22);
		frame.getContentPane().add(label_4);
		
		Label label_5 = new Label("\u0E02\u0E2D\u0E43\u0E2B\u0E49\u0E17\u0E48\u0E32\u0E19\u0E21\u0E32\u0E2A\u0E2D\u0E1A\u0E2A\u0E31\u0E21\u0E20\u0E32\u0E29\u0E13\u0E4C\u0E43\u0E19\u0E27\u0E31\u0E19\u0E17\u0E35\u0E48 ");
		label_5.setFont(new Font("TH Sarabun New", Font.BOLD, 13));
		label_5.setBounds(68, 201, 195, 22);
		frame.getContentPane().add(label_5);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(269, 203, 116, 20);
		frame.getContentPane().add(dateChooser_1);
		
		Label label_6 = new Label("\u0E40\u0E27\u0E25\u0E32 09 : 00 \u0E19.");
		label_6.setFont(new Font("TH Sarabun New", Font.BOLD, 13));
		label_6.setBounds(391, 201, 97, 22);
		frame.getContentPane().add(label_6);
		
		Label label_7 = new Label("\u0E2B\u0E32\u0E01\u0E21\u0E35\u0E02\u0E49\u0E2D\u0E2A\u0E07\u0E2A\u0E31\u0E22\u0E40\u0E1E\u0E34\u0E48\u0E21\u0E40\u0E15\u0E34\u0E21 \u0E2A\u0E32\u0E21\u0E32\u0E23\u0E16\u0E2A\u0E2D\u0E1A\u0E16\u0E32\u0E19\u0E44\u0E14\u0E49\u0E17\u0E35\u0E48 Facebook : Nong Singsom, Nu'man Arsengbaramae");
		label_7.setFont(new Font("TH Sarabun New", Font.BOLD, 13));
		label_7.setBounds(10, 229, 582, 22);
		frame.getContentPane().add(label_7);
		
		Button button = new Button("\u0E2A\u0E48\u0E07");
		button.setFont(new Font("Britannic Bold", Font.BOLD, 13));
		button.setBounds(456, 284, 70, 22);
		frame.getContentPane().add(button);
	}
}
