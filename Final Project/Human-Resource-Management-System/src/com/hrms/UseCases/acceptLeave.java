package com.hrms.UseCases;

import com.hrms.dao.EmployeeDao;
import com.hrms.dao.EmployeeDaoImp;

public class acceptLeave {
	public static void main(String[] args) {
		
		EmployeeDao edao = new EmployeeDaoImp() ;
		
		String result = edao.acceptLeave(1) ;
		System.out.println(result);
	}

}
