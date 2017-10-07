package Employee;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.Spring;
import javax.swing.text.JTextComponent;
import javax.swing.JRadioButton;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JScrollPane;
import javax.swing.JFormattedTextField;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComponent;

public class AddCompany {
	
	int i;
	JFrame frame;
	private JTextField usernametf;
	private JTextField textPhone;
	private JTextField textCEO;
	String query,sql,driver;
	Statement stmt;
	 ResultSet rs;
	 Connection conn;
	protected JTextComponent dateChooser;
	private JTextField textAddress;
	private JTextField textContact;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCompany window = new AddCompany();
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
	public AddCompany() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			String driver= "jdbc:ucanaccess://C:/Users/Nong/workspace/Project/AdvoopPrj/prjoop.accdb";
			String user="";
			String paw="";
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			
		 conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Nong/workspace/Project/AdvoopPrj/prjoop.accdb");
		// System.out.println("Connection success");
		 query = "SELECT * FROM com";
		  stmt = conn.createStatement();
		 rs = stmt.executeQuery(query);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 587, 507);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCompany = new JLabel("\u0E02\u0E49\u0E2D\u0E21\u0E39\u0E25\u0E1A\u0E23\u0E34\u0E29\u0E31\u0E17");
		lblCompany.setFont(new Font("Tahoma", Font.BOLD, 44));
		
		JLabel lblUsername = new JLabel("\u0E0A\u0E37\u0E48\u0E2D\u0E1A\u0E23\u0E34\u0E29\u0E31\u0E17 :");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		usernametf = new JTextField();
		
		frame.getContentPane().add(usernametf);
		usernametf.setColumns(10);
		
		
		JButton btnCancel = new JButton("\u0E22\u0E01\u0E40\u0E25\u0E34\u0E01");
		btnCancel.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent arg0) {
				
				usernametf.setText("");
				textAddress.setText("");
				textPhone.setText("");
				textCEO.setText("");
				textContact.setText("");
			}
		});
		
		JButton btnSave = new JButton("\u0E1A\u0E31\u0E19\u0E17\u0E36\u0E01");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(i == 1){
					 
					
					sql = "insert into com (comname,address,about,phone,ceo) values('"+usernametf.getText()+"','"+textAddress.getText()+"','"+textPhone.getText()+"','"+textCEO.getText()+"','"+textContact.getText()+"')";
				try {
					
					Class.forName(driver);
					conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Nong/workspace/Project/AdvoopPrj/prjoop.accdb");
				  stmt = conn.createStatement();
				
				if(stmt.executeUpdate(sql) !=-1){
				 JOptionPane.showMessageDialog( null, "บันทึกข้อมูลเรียบร้อยแล้ว" );
			        
			 }
				}catch(Exception err){
					  err.printStackTrace();
					}
				
				
				}else{
					String driver= "jdbc:ucanaccess://C:/Users/Nong/workspace/Project/AdvoopPrj/prjoop.accdb";
					 sql = "UPDATE com SET comname = '"+usernametf.getText()+"',address='"+textAddress.getText()+"',phone='"+textPhone.getText()+"',ceo='"+textCEO.getText()+"',about='"+textContact.getText()+"'";
					
				}
			}
		});
		
		JLabel Bdate = new JLabel("\u0E27\u0E31\u0E19\u0E17\u0E35\u0E48\u0E01\u0E48\u0E2D\u0E15\u0E31\u0E49\u0E07 :");
		Bdate.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JDateChooser dateChooser = new JDateChooser();
		
		JLabel Phone = new JLabel("\u0E2B\u0E21\u0E32\u0E22\u0E40\u0E25\u0E02\u0E42\u0E17\u0E23\u0E28\u0E31\u0E1E\u0E17\u0E4C :");
		Phone.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		textPhone = new JTextField();
		textPhone.setBounds(182, 80, 119, 26);
		frame.getContentPane().add(textPhone);
		textPhone.setColumns(10);
		
		JLabel Address = new JLabel("\u0E17\u0E35\u0E48\u0E2D\u0E22\u0E39\u0E48 :");
		Address.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel AboutME = new JLabel("\u0E23\u0E32\u0E22\u0E25\u0E30\u0E40\u0E2D\u0E35\u0E22\u0E14\u0E40\u0E1E\u0E34\u0E48\u0E21\u0E40\u0E15\u0E34\u0E48\u0E21 :");
		AboutME.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblCeo = new JLabel("\u0E0A\u0E37\u0E48\u0E2D CEO :");
		lblCeo.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		textCEO = new JTextField();
		textCEO.setBounds(182, 80, 119, 26);
		frame.getContentPane().add(textCEO);
		textCEO.setColumns(10);
		
		textAddress = new JTextField();
		textAddress.setColumns(10);
		
		textContact = new JTextField();
		textContact.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(lblCompany)
					.addContainerGap(317, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnCancel)
							.addGap(18)
							.addComponent(btnSave))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblCeo)
									.addComponent(Phone, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
									.addComponent(AboutME))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(textCEO, GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
									.addComponent(textPhone, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
									.addComponent(textContact, GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)))
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addGap(81)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(Bdate)
									.addComponent(Address, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblUsername))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
										.addGap(120))
									.addComponent(textAddress, GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
									.addComponent(usernametf, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)))))
					.addGap(69))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addComponent(lblCompany, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(usernametf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsername))
					.addGap(8)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textAddress, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
						.addComponent(Address, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(13)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(Bdate, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(Phone, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(textPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCeo)
						.addComponent(textCEO, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(AboutME, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textContact, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(149))
		);
		frame.getContentPane().setLayout(groupLayout);
		}catch(Exception e){
			  System.err.println(e);	
			}
	}
}

