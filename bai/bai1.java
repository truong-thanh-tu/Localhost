package bai;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class bai1 {
	static String getstrSelect(String tacgia) {
		String  select ="SELECT * FROM sach WHERE sach.TENTG = "+tacgia;
		return select;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		try (
			Connection  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop?"+ "&serverTimezone=UTC" +
	                "&useSSL=false" +
	                "&allowPublicKeyRetrieval=true","root","");
			Statement stmt = conn.createStatement();
			){
			String strSelect ;
			//Xem toan bo 3 cuon sach moi nhat
			strSelect="SELECT * FROM sach ORDER BY NGAYXB DESC LIMIT 5";
			
			//Xem 3 cuon sach ban chay nhat
			strSelect ="SELECT C.MASACH FROM cthd C ORDER BY C.SL DESC LIMIT 3";
			
			//Tim kiem thong tin theo tac gia
			System.out.println("Nhap ten tac gia");
			String name = scan.nextLine();
			strSelect = getstrSelect(name);
			
			
			//Hien thi don hang moi tiep nhap
			strSelect ="SELECT * FROM hoadon where hoadon.trangthai = 1";
			
			//Hien thị don hang theo ma khach hang
			strSelect ="SELECT * FROM hoadon ORDER BY makh DESC LIMIT 5";
			//Hien thi trang thai don hang theo ma don hang
			strSelect ="SELECT trangthai FROM hoadon ORDER BY mahd DESC LIMIT 5";
			//Hien thị thong tin chi tiet cua mot don hang theo ma don duoc nhap vap
			System.out.println("Nhap ma don hang");
			String code = scan.nextLine();
			strSelect ="SELECT hoadon.*,cthd.sl FROM hoadon H inner join cthd C where H.mahd = "+code+" mahd = "+code;
			//Hien thi don hang da dong goi
			strSelect ="SELECT * FROM hoadon where hoadon.trangthai = 3";
			//Hien thi don hang da gui van chuyen
			strSelect ="SELECT * FROM hoadon where hoadon.trangthai = 5";
			ResultSet rset = stmt.executeQuery(strSelect);
			
			int rowCount = 0;
			while(rset.next()) {
				 //hien thị
				System.out.println(rset);
				++rowCount;
			}
			System.out.println("Total number of records = "+rowCount);
			//Thuc hien khi lo
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
