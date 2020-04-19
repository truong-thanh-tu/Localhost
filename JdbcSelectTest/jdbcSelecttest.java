package JdbcSelectTest;

import java.sql.*;

public class jdbcSelecttest {
	public static void main(String[] args) {
		//Tao co so du lieu lam o xam
		//Tao Connection (truy cap den du lieu) va Statement(Dong goi du lieu)
		
		try (
			Connection  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop?"+ "&serverTimezone=UTC" +
	                "&useSSL=false" +
	                "&allowPublicKeyRetrieval=true","root","");
			Statement stmt = conn.createStatement();
			){
		//Viet cau lenh truy van 
//			String strSelect ="select title, price, qty from book";
//			String strSelect ="select title, price, qty from book where author ='CodeLean VN'";
			String strSelect ="select title,author, price, qty from book where author ='CodeLean VN' or price >= 30 order by price desc, id asc";
			System.out.println("The SQL statemet is : "+strSelect+" \n");
			ResultSet rset = stmt.executeQuery(strSelect);
		//Xuy ly ket qua truy van
			
			System.out.print("The records selected are : ");
			int rowCount = 0;
			while(rset.next()) {
				String title = rset.getString("title");
				double price = rset.getDouble("price");
				int    qty   = rset.getInt("qty");
				System.out.println("\n"+title+",\n "+price+",\n "+qty);
				++rowCount;
			}
			System.out.println("Total number of records = "+rowCount);
			//Thuc hien khi lo
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
