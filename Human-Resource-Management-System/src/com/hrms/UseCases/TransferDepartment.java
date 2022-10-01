package com.hrms.UseCases;

import com.hrms.Exceptions.EmployeeException;
import com.hrms.dao.EmployeeDao;
import com.hrms.dao.EmployeeDaoImp;

public class TransferDepartment {
	public static void main(String[] args) {
		
		EmployeeDao  employeeDao = new EmployeeDaoImp() ;
		int empId = 1 ;
		int deptId = 4 ;
		
		try {
			String result  = employeeDao.transferEmployee(empId, deptId) ;
			System.out.println(result);
		} catch (EmployeeException e) {
			e.printStackTrace();
		}
	}

}
