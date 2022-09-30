package com.hrms.UseCases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hrms.Util.DBConnection;
import com.hrms.dao.DepartmentDao;
import com.hrms.dao.DepartmentDaoImp;

public class UpdateDepartment {

	public static void main(String[] args) {
		
		DepartmentDao departmentDao = new DepartmentDaoImp() ;
//		String original = "Human Resource" ;
//		String after = "Marketing" ;
//		
//		String result = departmentDao.updateDepartmentName(original, after) ;
		
		String deptName = "Marketing" ;
		String location = "Mumbai" ;
		String result = departmentDao.updateDepartmentLocation(deptName, location) ;
		System.out.println(result);
	}

}
