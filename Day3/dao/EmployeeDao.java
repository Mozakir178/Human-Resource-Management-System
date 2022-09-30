package com.hrms.dao;

import java.util.List;

import com.hrms.Exceptions.EmployeeException;
import com.hrms.bean.Employee;
import com.hrms.bean.Leaves;

public interface EmployeeDao {
	
	public String ragisterEmployee(Employee employee) throws EmployeeException ;
	public String transferEmployee (int empId , int deptId) throws EmployeeException ;
	public List<Leaves> getLeavesList() throws EmployeeException ;

}
