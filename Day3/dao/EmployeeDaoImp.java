package com.hrms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hrms.Exceptions.EmployeeException;
import com.hrms.Util.DBConnection;
import com.hrms.bean.Employee;
import com.hrms.bean.Leaves;

public class EmployeeDaoImp implements EmployeeDao {

	@Override
	public String ragisterEmployee(Employee employee) throws EmployeeException  {
		String result = "Not Added" ;
		
		 try(Connection conn = DBConnection.getConnection()) {
			 String query = "insert into employee(empName,empuser,emppass,empDepId,empSal,empJoin,empLeave,empMangId) "+
					 		"values(? , ? , ? , ? , ? , ? , ? , ?)";
			 
			 PreparedStatement ps = conn.prepareStatement(query) ;
			 ps.setString(1, employee.getName());
			 ps.setString(2, employee.getUsername());
			 ps.setString(3, employee.getPassword());
			 ps.setInt(4, employee.getDeptId());
			 ps.setInt(5, employee.getSalary());
			 ps.setString(6, employee.getJoinDate());
			 ps.setInt(7, employee.getLeaveAvi());
			 ps.setInt(8, employee.getMangId());
			 
			 int x = ps.executeUpdate() ;
			 if(x>0) {
				 result = "Employee Ragister Successfully" ;
			 }
			 else
				 throw new EmployeeException("Something went wrong") ;
			
		} catch (SQLException e) {
				throw new EmployeeException(e.getMessage()) ;
		}
		
		
		return result ;
	}

	@Override
	public String transferEmployee(int empId , int deptId) throws EmployeeException {
		
		String result = "Not Transfered" ;
		
		String query = "update employee set empDepId = ? where empId = ?" ;
		
		try(Connection conn = DBConnection.getConnection()) {
			
			PreparedStatement ps = conn.prepareStatement(query) ;
			ps.setInt(1, deptId);
			ps.setInt(2, empId);
			
			int x = ps.executeUpdate() ;
			if(x>0) {
				result = "Employee Transfered to deptId no: "+deptId ;
			}
			
		} catch (SQLException e) {
			
			throw new EmployeeException(e.getMessage()) ;
			// TODO: handle exception
		}
		
		
		return result;
	}

	@Override
	public List<Leaves> getLeavesList() throws EmployeeException {
		
		List<Leaves> list = new ArrayList<>() ;
		
		String query = "select * from leaves" ;
		try(Connection conn = DBConnection.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery() ;
		while(rs.next()) {
			int empId = rs.getInt("empId") ;
			int leaveNo = rs.getInt("leaveNo") ;
			int leaveDay = rs.getInt("leaveday") ;
			String reason = rs.getString("leaveres") ;
			
			Leaves leaves = new Leaves(empId, leaveNo, leaveDay, reason) ;
			list.add(leaves) ;
		}
		
		if(list.size() == 0) {
			throw new EmployeeException("There is no pending leave request") ;
		}
			
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage()) ;
		}
		
		
		
		
		
		
		return list ;
	}

}
