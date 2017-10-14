package Customer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;





import Employee.JTable_Search;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginForm {

	public JFrame frame;
	private JTextField usernametf;
	private JPasswordField passwordtf;
	String query, sql, driver;
	Statement stmt;
	ResultSet rs;
	Connection conn;
	public int ses;

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
			         java.util.logging.Logger.getLogger(JTable_Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			     } catch (InstantiationException ex) {
			         java.util.logging.Logger.getLogger(JTable_Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			     } catch (IllegalAccessException ex) {
			         java.util.logging.Logger.getLogger(JTable_Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			     } catch (javax.swing.UnsupportedLookAndFeelException ex) {
			         java.util.logging.Logger.getLogger(JTable_Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			     }
				
				try {
					LoginForm window = new LoginForm();
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
	public LoginForm() {
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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblLogin.setBounds(25, 11, 91, 66);
		frame.getContentPane().add(lblLogin);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblUsername.setBounds(58, 94, 118, 32);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblPassword.setBounds(58, 137, 118, 32);
		frame.getContentPane().add(lblPassword);
		
		usernametf = new JTextField();
		usernametf.setBounds(186, 98, 214, 28);
		frame.getContentPane().add(usernametf);
		usernametf.setColumns(10);
		
		passwordtf = new JPasswordField();
		passwordtf.setBounds(186, 141, 214, 28);
		frame.getContentPane().add(passwordtf);
		
		JButton btnLogin = new JButton("Login");
		
		Session ss = new Session();
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				String ps = new String(passwordtf.getPassword());
				try{
					String sql = " SELECT * FROM  login " +" WHERE username = ? " +" AND password = ? " ;
					 
					PreparedStatement pre;
						pre = conn.prepareStatement(sql);
						pre.setString(1, usernametf.getText());
						pre.setString(2,ps);
						
						
						ResultSet rs = pre.executeQuery();
						
						
						if(rs.next()) {
							//JOptionPane.showMessageDialog(null, "Correct Username/Password");
							String sLevel = rs.getString(4);
							//ses = Integer.parseInt(rs.getString(1));
							if(sLevel.equals("Company")) {
								ss.setSesion(rs.getString(1));
								JTable_Search window = new JTable_Search();
								window.setVisible(true);
								frame.dispose();
								// Menu Admin
								System.out.println(ses);
								} else if (sLevel.equals("Appllicant")){
									ss.setSesion(rs.getString(1));
									Testjtable window4 = new Testjtable();
									window4.setVisible(true);
									frame.dispose();
								}
							
						} else {
						JOptionPane.showMessageDialog(null, "Incorrect Username/Password");
						}
						} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
						System.out.println(ex);
						}
				
			}
		});
		btnLogin.setBounds(311, 185, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		frame.getRootPane().setDefaultButton(btnLogin);
		btnLogin.requestFocus();
		
		JButton btnCancle = new JButton("Cancle");
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usernametf.setText(null);
				passwordtf.setText(null);
				
			}
		});
		btnCancle.setBounds(212, 185, 89, 23);
		frame.getContentPane().add(btnCancle);
		
		JButton btnRegistry = new JButton("Registry");
		btnRegistry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				RegisterForm window = new RegisterForm();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnRegistry.setBounds(335, 11, 89, 23);
		frame.getContentPane().add(btnRegistry);
	}
}
