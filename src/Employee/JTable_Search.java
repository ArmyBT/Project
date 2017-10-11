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

     javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
     jPanel2Layout.setHorizontalGroup(
     	jPanel2Layout.createParallelGroup(Alignment.LEADING)
     		.addGroup(jPanel2Layout.createSequentialGroup()
     			.addContainerGap()
     			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
     				.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 1192, GroupLayout.PREFERRED_SIZE)
     				.addGroup(jPanel2Layout.createSequentialGroup()
     					.addComponent(jText_Search, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
     					.addGap(18)
     					.addComponent(jButton_Search)))
     			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
     );
     jPanel2Layout.setVerticalGroup(
     	jPanel2Layout.createParallelGroup(Alignment.LEADING)
     		.addGroup(jPanel2Layout.createSequentialGroup()
     			.addGap(31)
     			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
     				.addComponent(jButton_Search)
     				.addComponent(jText_Search, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
     			.addGap(28)
     			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
     			.addContainerGap(41, Short.MAX_VALUE))
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
 // End of variables declaration                   
}
