package Customer;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Testjtable  extends JFrame {
	
	Connection connect = null;
	Statement s = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Testjtable frame = new Testjtable();
				frame.setVisible(true);
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Testjtable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 368);
		setTitle("ThaiCreate.Com Java GUI Tutorial");
		getContentPane().setLayout(null);
		
		// Customer Label
		JLabel lblCustomer = new JLabel("Customer List");
		lblCustomer.setBounds(231, 28, 95, 14);
		getContentPane().add(lblCustomer);
		
		// ScrollPane for Table
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 61, 494, 188);
		getContentPane().add(scrollPane);
		
		// Table
		JTable table = new JTable();
				
		// Model for Table
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.addColumn("CustomerID");
		model.addColumn("Name");
		model.addColumn("Email");
		model.addColumn("CountryCode");
		model.addColumn("Budget");
		model.addColumn("Used");
		
		Scanner input = new Scanner(System.in);

		System.out
				.println("enter data base want see 1=com 2=cus 3=applying 4=offer: ");
		String data = input.nextLine();
		System.out.println("Check username: ");
		String name = input.nextLine();
		
		String check = "";
		String test = "";
		
		try {

			Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/AdvoopPrj/prjoop.accdb");
			Statement s = conn.createStatement();

			// s.executeUpdate("insert into lab6 (sakul,country,cast) values('fsf','Gafme',12345)");
			// s.executeUpdate("insert into lab6 (sakul,country,cast) values('rwfe','32212',3223)");

			
			if(data.equals("1")){
				check = "SELECT announce.anid,com.comname,announce.adate,announce.aboutjob,announce.amount FROM announce INNER JOIN com ON announce.comid = com.comid;  ";
			}else if(data.equals("2")){
				check = "SELECT * FROM com";
			}
			
			PreparedStatement pstmt = conn.prepareStatement("select * from login where username = ? ");
			pstmt.setString(1,name);
			ResultSet rs1= pstmt.executeQuery();
			int row = 0;
			
			ResultSet rs = s.executeQuery(check);
			
			while((rs!=null) && (rs.next()))
            {			
				model.addRow(new Object[0]);
				model.setValueAt(rs.getString(1), row, 0);
				model.setValueAt(rs.getString(2), row, 1);
				model.setValueAt(rs.getString(3), row, 2);
				model.setValueAt(rs.getString(4), row, 3);
				model.setValueAt(rs.getString(5), row, 4);
				//model.setValueAt(rs.getString(6), row, 5);
				row++;
				
				/*
				 * 		model.addRow(new Object[]{
						rec.getString("CustomerID")
						,rec.getString("Name"),rec.getString("Email")
						,rec.getString("CountryCode")
						,rec.getString("Budget")
						,rec.getString("Used")
						});
				 */
            }
			rs1.close();
             
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
		
		int row = table.getRowCount();
		int column = table.getColumnCount();
		for (int j = 0; j  < row; j++) {
		    for (int i = 0; i  < column; i++) {
		        System.out.println(table.getValueAt(j, i));
		    }
		}
		
		try {
			if(s != null) {
				s.close();
				connect.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		scrollPane.setViewportView(table);		
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int column = 0;
				int row = table.getSelectedRow();
				String value = table.getModel().getValueAt(row, column).toString();
				System.out.println(value);
				
				   
				lblCustomer.setText("1");
				
			}
		});
		btnSelect.setBounds(421, 272, 89, 23);
		getContentPane().add(btnSelect);

	}
}