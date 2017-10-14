package Employee;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.AbstractListModel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.TextArea;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.Font;

public class Feature {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Feature window = new Feature();
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
	public Feature() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u0E04\u0E38\u0E13\u0E2A\u0E21\u0E1A\u0E31\u0E15\u0E34\u0E04\u0E27\u0E32\u0E21\u0E2A\u0E32\u0E21\u0E32\u0E23\u0E16\u0E1E\u0E34\u0E40\u0E28\u0E29");
		frame.setBounds(100, 100, 574, 390);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u0E0A\u0E37\u0E48\u0E2D\u0E1A\u0E23\u0E34\u0E29\u0E31\u0E17 :");
		label.setFont(new Font("TH Sarabun New", Font.BOLD, 18));
		label.setBounds(62, 106, 51, 22);
		frame.getContentPane().add(label);
		
		JLabel label_2 = new JLabel("\u0E04\u0E27\u0E32\u0E21\u0E2A\u0E32\u0E21\u0E32\u0E23\u0E16\u0E1E\u0E34\u0E40\u0E28\u0E29 :");
		label_2.setFont(new Font("TH Sarabun New", Font.BOLD, 18));
		label_2.setBounds(10, 128, 174, 20);
		frame.getContentPane().add(label_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(123, 107, 234, 20);
		frame.getContentPane().add(comboBox);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(108, 153, 380, 128);
		frame.getContentPane().add(textArea);
		
		Button button = new Button("\u0E25\u0E1A\u0E02\u0E49\u0E2D\u0E21\u0E39\u0E25");
		button.setBounds(150, 287, 70, 22);
		frame.getContentPane().add(button);
		
		Button button_1 = new Button("\u0E1A\u0E31\u0E19\u0E17\u0E36\u0E01");
		button_1.setBounds(226, 287, 70, 22);
		frame.getContentPane().add(button_1);
		
		Button button_2 = new Button("\u0E41\u0E01\u0E49\u0E44\u0E02");
		button_2.setBounds(302, 287, 70, 22);
		frame.getContentPane().add(button_2);
		
		Button button_3 = new Button("\u0E22\u0E01\u0E40\u0E25\u0E34\u0E01");
		button_3.setBounds(378, 287, 70, 22);
		frame.getContentPane().add(button_3);
		
		JLabel label_1 = new JLabel("\u0E04\u0E38\u0E13\u0E2A\u0E21\u0E1A\u0E31\u0E15\u0E34\u0E02\u0E2D\u0E07\u0E1C\u0E39\u0E49\u0E2A\u0E31\u0E21\u0E04\u0E23\u0E07\u0E32\u0E19");
		label_1.setFont(new Font("TH Sarabun New", Font.BOLD, 44));
		label_1.setBounds(31, 0, 496, 76);
		frame.getContentPane().add(label_1);
	}
}
