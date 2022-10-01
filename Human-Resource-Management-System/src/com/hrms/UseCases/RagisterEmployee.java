package com.hrms.UseCases;

import com.hrms.Exceptions.EmployeeException;
import com.hrms.bean.Employee;
import com.hrms.dao.EmployeeDao;
import com.hrms.dao.EmployeeDaoImp;

public class RagisterEmployee {

	public static void main(String[] args) {
		
		EmployeeDao employeeDao = new EmployeeDaoImp() ;
		Employee employee = new Employee(1, "abcd", "123", "zakir", 1, 1, 50000, "2020-06-04", 24) ;
		
		try {
			String result = employeeDao.ragisterEmployee(employee) ;
			System.out.println(result);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
}
