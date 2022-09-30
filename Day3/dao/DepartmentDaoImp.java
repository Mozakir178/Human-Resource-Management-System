package com.hrms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.hrms.Util.DBConnection;
import com.hrms.bean.Department;

public class DepartmentDaoImp implements DepartmentDao {

	@Override
	public String addDepartment(Department department)  {
		String result = "Department Not Added" ;
		try (Connection conn = DBConnection.getConnection()){
			String query = "insert into department(deptName , deptLoc) values(?,?)" ;
			PreparedStatement ps = conn.prepareStatement(query) ;
			ps.setString(1, department.getDeptName());
			ps.setString(2, department.getDeptLoc());
			int x = ps.executeUpdate() ;
			if(x>0) {
				result = "Department Added successfully" ;
			}
			
			
			
		} catch (SQLException e) {
			result = e.getMessage() ;
		}
		
		return result;
	}

	@Override
	public String updateDepartmentName(String original, String after) {
		String result = "Not update" ;
		
		try(Connection conn = DBConnection.getConnection()) {
			
			String query = "update department set deptName = ? where deptName = ?" ;
			PreparedStatement ps =conn.prepareStatement(query) ;
			ps.setString(1, after);
			ps.setString(2, original);
			int x = ps.executeUpdate() ;
			if(x>0) {
				result = "Department Update Successfully" ;
			}
			
		} catch (SQLException e) {
				result = e.getMessage() ;
		}
		
		
		
		
		
		
		return result ;
	}

	@Override
	public String updateDepartmentLocation(String deptName, String location) {
		
		
		String result = "Not update" ;
		
		try(Connection conn = DBConnection.getConnection()) {
			
			String query = "update department set deptLoc = ? where deptName = ?" ;
			PreparedStatement ps =conn.prepareStatement(query) ;
			ps.setString(1, location);
			ps.setString(2, deptName);
			int x = ps.executeUpdate() ;
			if(x>0) {
				result = "Department Update Successfully" ;
			}
			
		} catch (SQLException e) {
				result = e.getMessage() ;
		}
		
		
		
		
		
		
		return result ;
	}

}
