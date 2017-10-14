package Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class command {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		System.out
				.println("enter data base want see 1=com 2=cus 3=applying 4=offer: ");
		String data = input.nextLine();
		System.out.println("Check username: ");
		String name = input.nextLine();
		
		String check = "";
		

		try {

			Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/AdvoopPrj/prjoop.accdb");
			Statement s = conn.createStatement();

			// s.executeUpdate("insert into lab6 (sakul,country,cast) values('fsf','Gafme',12345)");
			// s.executeUpdate("insert into lab6 (sakul,country,cast) values('rwfe','32212',3223)");

			
			if(data.equals("1")){
				check = "SELECT * FROM com";
			}else if(data.equals("2")){
				check = "SELECT * FROM cus";
			}
			
			PreparedStatement pstmt = conn.prepareStatement("select * from login where username = ? ");
			pstmt.setString(1,name);
			ResultSet rs1= pstmt.executeQuery();
			if(rs1.next())
			  System.out.println("record found");
			else
			  System.out.println("record not found");
			
			ResultSet rs = s.executeQuery(check);
			
			
			
			
			while (rs.next()) {
				// System.out.println(rs.getString(1));
				if (data.equals("1")) {
					System.out.println("\n" + rs.getString(1) + "\t"
							+ rs.getString(2) + "\t" + rs.getString(3) + "\t"
							+ rs.getString(4) + "\t" + rs.getString(5) + "\t"
							+ rs.getString(6) + "\t" + rs.getString(7) + "\t"
							+ rs.getString(8));
				} else if (data.equals("2")) {
					System.out.println("\n" + rs.getString(1) + "\t"
							+ rs.getString(2) + "\t" + rs.getString(3) + "\t"
							+ rs.getString(4) + "\t" + rs.getString(5) + "\t"
							+ rs.getString(6) + "\t" + rs.getString(7) + "\t"
							+ rs.getString(8) + "\t" + rs.getString(9) + "\t"
							+ rs.getString(10) + "\t" + rs.getString(11) + "\t"
							+ rs.getString(12) + "\t" + rs.getString(13) + "\t"
							+ rs.getString(14));

				}else{
					System.out.println("Error");
				}
			}
		} catch (Exception e) {

			System.out.println(e);

		}

	}
}
