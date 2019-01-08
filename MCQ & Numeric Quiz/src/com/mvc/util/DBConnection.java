package com.mvc.util;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class DBConnection {

	public static Connection createConnection() {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/icsi518_hw4f"; 
		String username = "root"; 
		String password = "root"; 

		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			con = (Connection) DriverManager.getConnection(url, username, password); 
			System.out.println(" Creating connection object..... " + con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}