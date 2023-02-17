package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.MySQLConnUtils;
import model.Sach;

public class SachDAO implements DAOinterface<Sach>{

	public static SachDAO getInstance() {
		return new SachDAO();
	}
	
	public int insert(Sach t) {
		// TODO Auto-generated method stub
		try {
			//Bước 1: Tạo kết nối
			Connection connection=MySQLConnUtils.getConnection();
			//Bước 2: Tạo đối tượng statement
			Statement st=connection.createStatement();
			//Bước 3: Thực thi câu lênh SQL
			String sql="INSERT INTO sach(id, tensach, giaban, namxuatban)"
					+ "VALUES ('" + t.getId() + "' , '" + t.getTensach() + "' , " + t.getGiaban() + " , " + t.getNamxuatban() +")";
			
			int ketqua =st.executeUpdate(sql);
			
			//Bước 4: xử lý kết quả
			System.out.println("Bạn đã thực thi : "+sql);
			System.out.println("Số dòng vừa thêm: "+ketqua );
			
			//Bước 5 ngắt kết nối
			MySQLConnUtils.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int update(Sach t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delete(Sach t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<Sach> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Sach selectById(Sach t) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Sach> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
