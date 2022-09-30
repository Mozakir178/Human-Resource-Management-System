package com.hrms.dao;

import java.util.List;

import com.hrms.Exceptions.DepartmentException;
import com.hrms.bean.Department;

public interface DepartmentDao {
	
	public abstract String addDepartment(Department department) throws DepartmentException;
	
	public abstract String updateDepartmentName(String original , String after );
	
	public abstract String updateDepartmentLocation(String deptName , String location) ;
	
	public abstract List<Department> viewDepartment() throws DepartmentException ;
	
	

}
