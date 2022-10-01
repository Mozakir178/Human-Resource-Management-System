package com.hrms.UseCases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hrms.Util.DBConnection;
import com.hrms.dao.EmployeeLeveImp;
import com.hrms.dao.EmployeeLevel;

public class ApplyLeave {
	
	public static void main(String[] args) {
		
		EmployeeLevel emp = new EmployeeLeveImp() ;
		int empId = 1 ;
		int day = 5 ;
		String reason = "Health Essue" ;
		
		String result = emp.applyForLeave(empId, day, reason) ;
		System.out.println(result);
	}
}
