package com.hrms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hrms.Exceptions.EmployeeException;
import com.hrms.Util.DBConnection;
import com.hrms.bean.EmployeeDto;

public class EmployeeLeveImp implements EmployeeLevel {

	@Override
	public EmployeeDto viewDetails(int empId) throws EmployeeException {
		EmployeeDto result = null ;
		
		
		String query = "select * from employee e inner join department d on d.deptId = e.empDepId where e.empId = ?" ;
		
		try(Connection conn = DBConnection.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(query) ;
			ps.setInt(1, empId);
			ResultSet rs = ps.executeQuery() ;
			boolean flag = true ;
			while(rs.next()) {
				flag = false ;
				int eid = rs.getInt("empId") ;
				String ename = rs.getString("empName") ;
				String euser = rs.getString("empuser") ;
				int esal = rs.getInt("empSal") ;
				java.util.Date date = rs.getDate("empJoin" ) ;
				int elev = rs.getInt("empLeave") ;
				int did = rs.getInt("deptId") ;
				int mid = rs.getInt("empMangId") ;
				String dname = rs.getString("deptName") ;
				String dloc = rs.getString("deptLoc") ;
				
				EmployeeDto employee = new EmployeeDto(empId, euser, ename, esal, date, elev, did, mid, dname, dloc) ;
				
				return employee ;
				
				
				
			}
			if(flag) {
				throw new EmployeeException("You have entered wrong empId") ;
			}
			
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage()) ;
			// TODO: handle exception
		}
		
		
		
		
		
		
		
		
		return result ;
	}

	@Override
	public String applyForLeave(int empId , int day , String reason )   {
		String result = "Not applied for leaves" ;
		
		String query = "insert into leaves(empId , leaveday , leaveres) values(?,?,?)" ;
		try(Connection conn = DBConnection.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, empId);
			ps.setInt(2, day);
			ps.setString(3, reason);
			
			int x = ps.executeUpdate() ;
			if( x > 0) {
				result = "You have applied for leave wait for admin to take action" ;
			}
			
			
		} catch (SQLException e) {
			result = e.getMessage() ;
		}
		
		
		
		
		
		
		
		
		return result ;
	}

	@Override
	public String updatePassword(int empId, String password) {
		String result = "Password Not changed" ;
		
		String query = "update employee set emppass = ? where empId = ?" ;
		try(Connection conn = DBConnection.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(query) ;
			ps.setString(1, password);
			ps.setInt(2, empId);
			int x = ps.executeUpdate() ;
			if(x > 0) {
				result = "Password changed successfully" ;
			}
			
			
		} catch (SQLException e) {
			result = e.getMessage() ;
		}
		
		
		
		
		
		
		return result ;
	}

}
