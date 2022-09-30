package com.hrms.UseCases;

import com.hrms.Exceptions.EmployeeException;
import com.hrms.bean.EmployeeDto;
import com.hrms.dao.EmployeeLeveImp;
import com.hrms.dao.EmployeeLevel;

public class ViewEmployee {
	public static void main(String[] args) {
		
		EmployeeLevel emp = new EmployeeLeveImp() ;
		try {
			EmployeeDto details = emp.viewDetails(1) ;
			System.out.println(details);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
