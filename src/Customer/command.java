package Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class command {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out
				.println("enter data base want see 1=com 2=cus 3=applying 4=offer: ");
		String data = input.nextLine();

		try {

			Connection conn = DriverManager
					.getConnection("jdbc:ucanaccess://C:\\Users\\Nong\\workspace\\Project\\AdvoopPrj\\prjoop.accdb");
			Statement s = conn.createStatement();

			// s.executeUpdate("insert into lab6 (sakul,country,cast) values('fsf','Gafme',12345)");
			// s.executeUpdate("insert into lab6 (sakul,country,cast) values('rwfe','32212',3223)");

			
			ResultSet rs = s.executeQuery("SELECT * FROM cus");

			while (rs.next()) {
				// System.out.println(rs.getString(1));
				if (data.equals("1")) {
					System.out.println("\n" + rs.getString(1) + "\t"
							+ rs.getString(2) + "\t" + rs.getString(3) + "\t"
							+ rs.getString(4) + "\t" + rs.getString(5) + "\t"
							+ rs.getString(6) + "\t" + rs.getString(7) + "\t"
							+ rs.getString(8) + "\t" + rs.getString(9) + "\t"
							+ rs.getString(10));
				} else if (data.equals("2")) {
					System.out.println("\n" + rs.getString(1) + "\t"
							+ rs.getString(2) + "\t" + rs.getString(3) + "\t"
							+ rs.getString(4) + "\t" + rs.getString(5) + "\t"
							+ rs.getString(6) + "\t" + rs.getString(7) + "\t"
							+ rs.getString(8) + "\t" + rs.getString(9) + "\t"
							+ rs.getString(10) + "\t" + rs.getString(11) + "\t"
							+ rs.getString(12) + "\t" + rs.getString(13) + "\t"
							+ rs.getString(14));

				}
			}
		} catch (Exception e) {

			System.out.println(e);

		}

	}
}
