package com.hrms.UseCases;

import com.hrms.dao.EmployeeLeveImp;
import com.hrms.dao.EmployeeLevel;

public class ChangePassword {
	public static void main(String[] args) {
		
		EmployeeLevel emp = new EmployeeLeveImp() ;
		int empId = 1 ;
		String password = "Zakir123" ;
		String result = emp.updatePassword(empId, password) ;
		System.out.println(result);
	}

}
