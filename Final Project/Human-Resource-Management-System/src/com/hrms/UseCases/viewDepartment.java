package com.hrms.UseCases;

import java.util.List;

import com.hrms.Exceptions.DepartmentException;
import com.hrms.bean.Department;
import com.hrms.dao.DepartmentDao;
import com.hrms.dao.DepartmentDaoImp;

public class viewDepartment {

	public static void main(String[] args) {
		
		DepartmentDao ddao = new DepartmentDaoImp() ;
		try {
			List<Department> dep = ddao.viewDepartment() ;
			System.out.println(dep);
		} catch (DepartmentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
