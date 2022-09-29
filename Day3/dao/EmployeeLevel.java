package com.hrms.dao;

import com.hrms.Exceptions.EmployeeException;
import com.hrms.bean.EmployeeDto;

public interface EmployeeLevel {
	
	public abstract EmployeeDto viewDetails(int empId) throws EmployeeException ;
	public abstract String applyForLeave(int empId , int day , String resaon);
	public abstract String updatePassword(int empId , String password) ;

}
