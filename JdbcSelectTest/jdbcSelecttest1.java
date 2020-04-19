package JdbcSelectTest;

import java.sql.*;
import java.util.Scanner;

public class jdbcSelecttest1 {
	public static void main(String[] args) {
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nothwinds?"
				+ "&serverTimezone=UTC" + "&useSSL=false" + "&allowPublicKeyRetrieval=true", "root", "");
				Statement stmt = conn.createStatement();) {
//			1/ 	String strSelect = "select CompanyName from customers";
			Scanner scan = new Scanner(System.in);
			String name = scan.nextLine();

			String strSelect ="select CompanyName from customers where CompanyName='"+name+"'";
			ResultSet rset = stmt.executeQuery(strSelect);
			int rowCount = 0;
			while(rset.next()) {
				String Names = rset.getString("CompanyName");
				System.out.println(Names+"\n");
				++rowCount;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
