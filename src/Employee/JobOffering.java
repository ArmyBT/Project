package Employee;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import Customer.Session;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JobOffering {

	 JFrame frame;
	private JTable table;
	String query, sql, driver;
	Statement stmt;
	ResultSet rs;
	Connection conn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JobOffering window = new JobOffering();
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
	public JobOffering() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		Session ss = new Session();
		int cusid = Integer.parseInt(ss.getSession());
		System.out.println(cusid);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 802, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(81, 69, 705, 150);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addColumn("������¡����Ѥçҹ");
		model.addColumn("���ʼ����Ѥ�");
		model.addColumn("���ͼ����Ѥ�");
		model.addColumn("���ҡ");
		model.addColumn("�زԡ���֡��");
		model.addColumn("��������´�������");
		model.addColumn("�����Ţ����ѷ");
		
		try {

			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

			conn = DriverManager
					.getConnection("jdbc:ucanaccess://C:/AdvoopPrj/prjoop.accdb");

			// C:\Users\numan\git\Project\AdvoopPrj\prjoop.accdb

			query = "SELECT applying.appid,applying.cusid,cus.cusname,cus.graduatedfrom,cus.education, applying.appliying, applying.comid FROM applying INNER JOIN cus ON applying.cusid = cus.cusid";
			PreparedStatement pre;
			pre = conn.prepareStatement(query);
			ResultSet rs = pre.executeQuery();

			int row = 0;
			while ((rs != null) && (rs.next())) {
				model.addRow(new Object[0]);
				model.addRow(new Object[0]);
				model.setValueAt(rs.getString(1), row, 0);
				model.setValueAt(rs.getString(2), row, 1);
				model.setValueAt(rs.getString(3), row, 2);
				model.setValueAt(rs.getString(4), row, 3);
				model.setValueAt(rs.getString(5), row, 4);
				model.setValueAt(rs.getString(6), row, 5);
				model.setValueAt(rs.getString(7), row, 6);
				 // model.setValueAt(rs.getString(6), row, 5);
				 

				row++;

			}

		} catch (Exception eb) {
			System.err.println(eb);

		}
		
		JLabel label = new JLabel("\u0E22\u0E37\u0E19\u0E22\u0E31\u0E19\u0E2A\u0E16\u0E32\u0E19\u0E30\u0E1C\u0E39\u0E49\u0E2A\u0E21\u0E31\u0E04\u0E23");
		label.setFont(new Font("Tahoma", Font.BOLD, 25));
		label.setBounds(47, 27, 241, 31);
		frame.getContentPane().add(label);
		
		JButton button = new JButton("\u0E1B\u0E34\u0E14\u0E2B\u0E19\u0E49\u0E32\u0E15\u0E48\u0E32\u0E07\u0E19\u0E35\u0E49");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				
			}
		});
		button.setBounds(637, 227, 115, 23);
		frame.getContentPane().add(button);
		
		JButton button_2 = new JButton("\u0E1C\u0E48\u0E32\u0E19");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int column1 = 1;
				int column = 0;
				int row = table.getSelectedRow();
				String value = table.getModel().getValueAt(row, column1).toString();
				String value1 = table.getModel().getValueAt(row, column).toString();
				int off = Integer.parseInt(value1);
				
				sql = "UPDATE applying SET status = '��ҹ'WHERE appid = '"+off+"'; ";

				try {

					int confirm = JOptionPane.showConfirmDialog(null,
							"�س��ͧ���������� '��ҹ'�������:" + value + "��",
							"���", JOptionPane.YES_NO_OPTION);
					if (confirm == JOptionPane.YES_OPTION) {

						Statement s = conn.createStatement();
						//stmt = conn.createStatement();

						if (s.executeUpdate(sql) != 0) {
							JOptionPane.showMessageDialog(null,
									"�ѹ�֡���º����");
							
							model.setValueAt("����¹ʶҹ�����", row, 2);
							
						} else {
							JOptionPane.showMessageDialog(null, "ERROR");
						}

					} else if (confirm == JOptionPane.NO_OPTION) {
						return;
					}

				} catch (Exception err) {
					err.printStackTrace();
				}
			}
		});
		button_2.setBounds(528, 37, 115, 23);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("\u0E44\u0E21\u0E48\u0E1C\u0E48\u0E32\u0E19");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int column1 = 1;
				int column = 0;
				int row = table.getSelectedRow();
				String value = table.getModel().getValueAt(row, column1).toString();
				String value1 = table.getModel().getValueAt(row, column).toString();
				int off = Integer.parseInt(value1);
				
				sql = "UPDATE applying SET status = '����ҹ'WHERE appid = '"+off+"'; ";

				try {

					int confirm = JOptionPane.showConfirmDialog(null,
							"�س����ͧ����������Ѥ� '��ҹ'���������:" + value + "��",
							"���", JOptionPane.YES_NO_OPTION);
					if (confirm == JOptionPane.YES_OPTION) {

						Statement s = conn.createStatement();

						if (s.executeUpdate(sql) != 0) {
							JOptionPane.showMessageDialog(null,
									"�ѹ�֡���º����");
							
							model.setValueAt("�������ҹ", row, 2);
							
						} else {
							JOptionPane.showMessageDialog(null, "ERROR");
						}

					} else if (confirm == JOptionPane.NO_OPTION) {
						return;
					}

				} catch (Exception err) {
					err.printStackTrace();
				}
				
			}
		});
		button_3.setBounds(652, 37, 100, 23);
		
		
		
		frame.getContentPane().add(button_3);
	}

}
