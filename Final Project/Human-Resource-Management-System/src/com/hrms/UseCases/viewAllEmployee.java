package com.hrms.UseCases;

import java.util.List;

import com.hrms.Exceptions.EmployeeException;
import com.hrms.bean.Employee;
import com.hrms.dao.EmployeeDao;
import com.hrms.dao.EmployeeDaoImp;

public class viewAllEmployee {

	public static void main(String[] args) {
		
		
//		viewByDepartment
//		EmployeeDao edao = new EmployeeDaoImp() ;
//		try {
//			List<Employee> emp = edao.viewEmployeeByDepartment(1) ;
//			System.out.println(emp);
//		} catch (EmployeeException e) {
//			e.printStackTrace();
//		}
		
		
		
		EmployeeDao edao = new EmployeeDaoImp() ;
		try {
			List<Employee> emp = edao.viewEmployee() ;
			System.out.println(emp);
		} catch (EmployeeException e) {
			e.printStackTrace();
		}

	}

}
