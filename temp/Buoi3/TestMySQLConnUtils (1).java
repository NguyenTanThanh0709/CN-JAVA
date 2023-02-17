package test;

import java.sql.Connection;

import database.MySQLConnUtils;

public class TestMySQLConnUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Bước 1
		Connection connection=MySQLConnUtils.getConnectionn();
		System.out.println(connection);
		
	}

}
