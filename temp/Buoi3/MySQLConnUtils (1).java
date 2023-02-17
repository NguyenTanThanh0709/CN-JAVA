package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnUtils {

	public static Connection getConnectionn(){
	
		Connection con=null;
		try {
			//Đăng ký MySQL
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		
			//Các thông số
			String url="jdbc:mysql://localhost:3306/demomysql";
			String username="root";
			String password="";
			
			//Tạo kết nối
			con=DriverManager.getConnection(url, username, password);
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}
	
}
