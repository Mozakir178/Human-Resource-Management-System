package com.hrms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hrms.Exceptions.DepartmentException;
import com.hrms.Exceptions.EmployeeException;
import com.hrms.Util.DBConnection;
import com.hrms.bean.Department;

public class DepartmentDaoImp implements DepartmentDao {

	@Override
	public String addDepartment(Department department)  {
		String result = "Department Not Added" ;
		if(department.getDeptName().length() < 1 || department.getDeptLoc().length() < 1) {
			return "Field cannot be empty" ;
		}
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

	@Override
	public List<Department> viewDepartment() throws DepartmentException {
		List<Department> departments = new ArrayList<>() ;
		
		
		String query = "select * from department" ;
		
		try(Connection conn = DBConnection.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(query) ;
			ResultSet rs = ps.executeQuery() ;
			while(rs.next()) {
				int deptId = rs.getInt(1) ;
				String deptName = rs.getString(2) ;
				String deptLoc = rs.getString(3) ;
				
				Department dep = new Department(deptId, deptName, deptLoc) ;
				departments.add(dep) ;
			}
			
			if(departments.isEmpty()) {
				throw new DepartmentException("No Department exist please add department first") ;
			}
			
		} catch (SQLException e) {
			throw new DepartmentException(e.getMessage()) ;
		}
		
		
		
		
		
		
		
		return departments ;
	}

}
