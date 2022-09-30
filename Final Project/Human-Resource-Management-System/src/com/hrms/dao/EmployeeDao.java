package com.hrms.dao;

import java.util.List;

import com.hrms.Exceptions.EmployeeException;
import com.hrms.bean.Employee;
import com.hrms.bean.Leaves;

public interface EmployeeDao {
	
	public String ragisterEmployee(Employee employee) throws EmployeeException ;
	public String transferEmployee (int empId , int deptId) throws EmployeeException ;
	public List<Leaves> getLeavesList() throws EmployeeException ;
	public List<Employee> viewEmployee() throws EmployeeException ;
	public List<Employee> viewEmployeeByDepartment(int deptId) throws EmployeeException ;
	public String acceptLeave(int empId) ;
	public String rejectLeave(int empId) ;
	public boolean adminLogin(String username , String password) throws EmployeeException;

}
