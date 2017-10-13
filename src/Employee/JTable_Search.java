package Employee;

//Creates new form JTable_Search

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import Customer.LoginForm;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
*
* @author 1BestCsharp
*/
public class JTable_Search extends javax.swing.JFrame {

 /**
  * Creates new form JTable_Search
  */
 public JTable_Search() {
 	setAutoRequestFocus(false);
 	
 	JMenuBar menuBar = new JMenuBar();
 	setJMenuBar(menuBar);
 	
 	JMenu mnMenu = new JMenu("Menu");
 	mnMenu.setFont(new Font("Segoe UI", Font.BOLD, 15));
 	menuBar.add(mnMenu);
 	
 	JMenuItem menuItem = new JMenuItem("\u0E1B\u0E23\u0E30\u0E01\u0E32\u0E28\u0E2A\u0E21\u0E31\u0E04\u0E23\u0E07\u0E32\u0E19");
 	menuItem.addActionListener(new ActionListener() {
 		public void actionPerformed(ActionEvent arg0) {
 			Announcejob ann = new Announcejob();
			ann.frame.setVisible(true);
			
 			
 		}
 	});
 	
 	JMenuItem mntmProfile = new JMenuItem("Profile");
 	mntmProfile.addActionListener(new ActionListener() {
 		public void actionPerformed(ActionEvent e) {
 			AddCompany window = new AddCompany();
			window.frame.setVisible(true);
 			
 		}
 	});
 	mnMenu.add(mntmProfile);
 	
 	JSeparator separator = new JSeparator();
 	mnMenu.add(separator);
 	mnMenu.add(menuItem);
 	
 	JMenuItem menuItem_1 = new JMenuItem("\u0E1C\u0E39\u0E49\u0E17\u0E35\u0E48\u0E2A\u0E21\u0E31\u0E04\u0E23\u0E07\u0E32\u0E19");
 	menuItem_1.addActionListener(new ActionListener() {
 		public void actionPerformed(ActionEvent e) {
 			OfferingForm window = new OfferingForm();
 			window.frame.setVisible(true);
 			frame.dispose();
 		}
 	});
 	mnMenu.add(menuItem_1);
 	
 	JSeparator separator_1 = new JSeparator();
 	mnMenu.add(separator_1);

 	
 	
 	JMenuItem mntmLogout = new JMenuItem("Logout");
 	mntmLogout.addActionListener(new ActionListener() {
 		public void actionPerformed(ActionEvent e) {
 			
 			
 			LoginForm lf = new  LoginForm();
			lf.frame.setVisible(true);
			 new JTable_Search().setDefaultCloseOperation(DISPOSE_ON_CLOSE);
 		}
 	});
 	
 	JMenuItem menuItem_2 = new JMenuItem("\u0E1C\u0E25\u0E01\u0E32\u0E23\u0E40\u0E2A\u0E19\u0E2D\u0E07\u0E32\u0E19");
 	mnMenu.add(menuItem_2);
 	
 	JSeparator separator_2 = new JSeparator();
 	mnMenu.add(separator_2);
 	mnMenu.add(mntmLogout);
 	
 	JMenuItem mntmExits = new JMenuItem("Exits");
 	mntmExits.addActionListener(new ActionListener() {
 		public void actionPerformed(ActionEvent e) {
 			
 			System.exit(0);
 		}
 	});
 	mnMenu.add(mntmExits);
     initComponents();
     
     // call findUsers function
     findUsers();
     
 }

 
 // function to connect to mysql database
 public Connection getConnection()
 {
     Connection con = null;
     
     try{
    	 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
         con = DriverManager.getConnection("jdbc:ucanaccess://C:/AdvoopPrj/prjoop.accdb");
     }catch(Exception ex){
         System.out.println(ex.getMessage());
     }
     
     return con;
 }
 
// function to return users arraylist with particular data 
 public ArrayList<SearchCus> ListUsers(String ValToSearch)
 {
     ArrayList<SearchCus> usersList = new ArrayList<SearchCus>();
     
     Statement st;
     ResultSet rs;
     
     try{
         Connection con = getConnection();
         st = con.createStatement();
         String searchQuery = "SELECT * FROM `cus` WHERE CONCAT(`cusid`, `cusname`, `bdate`, `graduatedfrom`, `faculty`, `talent`,`address`, `phone`, `education`, `aboutme`, `email`) LIKE '%"+ValToSearch+"%'";
         rs = st.executeQuery(searchQuery);
         
         SearchCus user;
         
         while(rs.next())
         {
             user = new SearchCus(
            		 rs.getInt("cusid"),
            		 rs.getString("cusname"),
            		 rs.getDate("bdate"),
            		 rs.getString("graduatedfrom"),
            		 rs.getString("faculty"),
            		 rs.getString("talent"),
            		 rs.getString("address"),
            		 rs.getString("phone"),
            		 rs.getString("education"),
            		 rs.getString("aboutme"),
            		 rs.getString("email")

             );
             usersList.add(user);
         }
         
     }catch(Exception ex){
         System.out.println(ex.getMessage());
     }
     
     return usersList;
 }
 
 // function to display data in jtable
 public void findUsers()
 {
     ArrayList<SearchCus> users = ListUsers(jText_Search.getText());
     DefaultTableModel model = new DefaultTableModel();
     model.setColumnIdentifiers(new Object[]{"Id","Name","Date","Graduatedfrom","Faculty","Talent","Address","Phone","Education","AboutME","Email"});
     Object[] row = new Object[11];
     
     for(int i = 0; i < users.size(); i++)
     {
         row[0] = users.get(i).getId();
         row[1] = users.get(i).getName();
         row[2] = users.get(i).getDate();
         row[3] = users.get(i).getGraduatedfrom();
         row[4] = users.get(i).getFaculty();
         row[5] = users.get(i).getTalent();
         row[6] = users.get(i).getAddress();
         row[7] = users.get(i).getPhone();
         row[8] = users.get(i).getEducation();
         row[9] = users.get(i).getAboutME();
         row[10] = users.get(i).getEmail();
         
         
         model.addRow(row);
     }
    jTable_Users.setModel(model);
    
 }
 
 
 @SuppressWarnings("unchecked")
 // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
 private void initComponents() {

     jPanel2 = new javax.swing.JPanel();
     jButton_Search = new javax.swing.JButton();
     jText_Search = new javax.swing.JTextField();
     jScrollPane1 = new javax.swing.JScrollPane();
     jTable_Users = new javax.swing.JTable();

     setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

     jButton_Search.setText("Search");
     jButton_Search.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
             jButton_SearchActionPerformed(evt);
         }
     });

     jText_Search.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

     jTable_Users.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
     jTable_Users.setModel(new javax.swing.table.DefaultTableModel(
         new Object [][] {
             {null, null, null, null},
             {null, null, null, null},
             {null, null, null, null},
             {null, null, null, null}
         },
         new String [] {
             "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11"
         }
     ));
     jScrollPane1.setViewportView(jTable_Users);
     
     lblHomeCompany = new JLabel("Home Company");
     lblHomeCompany.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));

     javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
     jPanel2Layout.setHorizontalGroup(
     	jPanel2Layout.createParallelGroup(Alignment.LEADING)
     		.addGroup(Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
     			.addContainerGap(44, Short.MAX_VALUE)
     			.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING, false)
     				.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 1266, GroupLayout.PREFERRED_SIZE)
     				.addGroup(jPanel2Layout.createSequentialGroup()
     					.addComponent(lblHomeCompany, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)
     					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
     					.addComponent(jText_Search, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
     					.addPreferredGap(ComponentPlacement.RELATED)
     					.addComponent(jButton_Search)))
     			.addGap(44))
     );
     jPanel2Layout.setVerticalGroup(
     	jPanel2Layout.createParallelGroup(Alignment.LEADING)
     		.addGroup(jPanel2Layout.createSequentialGroup()
     			.addContainerGap()
     			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
     				.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
     					.addComponent(jText_Search, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
     					.addComponent(jButton_Search, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
     				.addComponent(lblHomeCompany))
     			.addGap(18)
     			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
     			.addContainerGap(73, Short.MAX_VALUE))
     );
     jPanel2.setLayout(jPanel2Layout);

     javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
     getContentPane().setLayout(layout);
     layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
     );
     layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
     );

     pack();
 }// </editor-fold>  


                     



 // Button Filter/search 
  
 private void jButton_SearchActionPerformed(java.awt.event.ActionEvent evt) {                                               
  
    findUsers();
    
 }                                              

 /**
  * @param args the command line arguments
  */
 public static void main(String args[]) {
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
     //</editor-fold>

     /* Create and display the form */
     java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
             new JTable_Search().setVisible(true);
             
          
         }
     });
 }

 // Variables declaration - do not modify                     
 private javax.swing.JButton jButton_Search;
 private javax.swing.JPanel jPanel2;
 private javax.swing.JScrollPane jScrollPane1;
 private javax.swing.JTable jTable_Users;
 private javax.swing.JTextField jText_Search;
 private JLabel lblHomeCompany;
 public JFrame frame;
}
