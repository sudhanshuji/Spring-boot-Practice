package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String userId = "root";
		String password = "Welcome123";
		
		try {
			System.out.println("Connecting to database......"+jdbcUrl);
			Connection myConn = DriverManager.getConnection(jdbcUrl, userId, password);
			System.out.println("Connection Successfull !!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
	}

}
