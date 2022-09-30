package com.hrms.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static Connection getConnection() {
		Connection conn = null ;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver") ;
			String url = "jdbc:mysql://localhost:3306/hrms" ;
			
			try {
				conn = DriverManager.getConnection(url, "root", "Zakir@12");
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
		return conn ;
	}
}
