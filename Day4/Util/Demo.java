package com.hrms.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo {

	public static void main(String[] args) {
		
		Connection conn = DBConnection.getConnection() ;
		System.out.println(conn);
		try {
			PreparedStatement ps = conn.prepareStatement("show tables") ;
			ResultSet rs = ps.executeQuery() ;
			while(rs.next()) {
				String table = rs.getString(1) ;
				System.out.println(table);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
