package com.hrms.UseCases;

import java.util.List;

import com.hrms.Exceptions.EmployeeException;
import com.hrms.bean.Leaves;
import com.hrms.dao.EmployeeDao;
import com.hrms.dao.EmployeeDaoImp;

public class GetListOfLeaave {
	
	public static void main(String[] args) {
		
		EmployeeDao emp = new EmployeeDaoImp() ;
		try {
			List<Leaves> list = emp.getLeavesList() ;
			System.out.println(list);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
