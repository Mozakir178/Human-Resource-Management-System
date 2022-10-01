package com.hrms.UseCases;

import java.sql.Connection;
import java.sql.SQLException;

import com.hrms.Exceptions.EmployeeException;
import com.hrms.Util.DBConnection;
import com.hrms.bean.Employee;
import com.hrms.dao.EmployeeDao;
import com.hrms.dao.EmployeeDaoImp;

public class AddEmployee {
	
	public static void main(String[] args) {
		
		EmployeeDao employeeDao = new EmployeeDaoImp() ;
		Employee employee = new Employee(1, "abc","123"	 , "abc", 1, 1, 50000, "2015-06-08", 24) ;
		
		try {
			String result = employeeDao.ragisterEmployee(employee) ;
			System.out.println(result);
		} catch (EmployeeException e) {
			e.printStackTrace();
		}
		
	}

}
