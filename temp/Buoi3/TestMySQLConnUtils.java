package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import database.MySQLConnUtils;

public class TestMySQLConnUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//Bước 1: Tạo kết nối
			Connection connection=MySQLConnUtils.getConnection();
			System.out.println(connection);
			
			MySQLConnUtils.printInfo(connection);
			
			//Bước 2: Tạo đối tượng statement
			Statement st=connection.createStatement();
			//Bước 3: Thực thi câu lênh SQL
			String sql="INSERT INTO persons(last_name, firts_name, gender, dod, income)"
					+ "VALUES (\"Tran\", \"Trui\", \"C\", \"2005-01-01\", 1000)";
			int check=st.executeUpdate(sql);
			
			//Bước 4: xử lý kết quả
			System.out.println("Số dòng vừa thêm: "+check );
			if (check>0) {
				System.out.println(" Thêm dữ liệu thành công!");
			}else {
				System.out.println(" Thêm dữ liệu thất bại!");
			}
			//Bước 5 ngắt kết nối
			MySQLConnUtils.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
