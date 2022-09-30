package com.hrms.bean;

import java.util.Date;

public class EmployeeDto {
	
	private int empId ;
	private String username ;
	private String name ;
	private int salary ;
	private Date joinDate ;
	private int leaveAvi ;
	private int deptId ;
	private int mangId ;
	private String deptName ;
	private String deptLoc ;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public int getLeaveAvi() {
		return leaveAvi;
	}
	public void setLeaveAvi(int leaveAvi) {
		this.leaveAvi = leaveAvi;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public int getMangId() {
		return mangId;
	}
	public void setMangId(int mangId) {
		this.mangId = mangId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptLoc() {
		return deptLoc;
	}
	public void setDeptLoc(String deptLoc) {
		this.deptLoc = deptLoc;
	}
	public EmployeeDto() {
		super();
	}
	public EmployeeDto(int empId, String username, String name, int salary, Date joinDate, int leaveAvi, int deptId,
			int mangId, String deptName, String deptLoc) {
		super();
		this.empId = empId;
		this.username = username;
		this.name = name;
		this.salary = salary;
		this.joinDate = joinDate;
		this.leaveAvi = leaveAvi;
		this.deptId = deptId;
		this.mangId = mangId;
		this.deptName = deptName;
		this.deptLoc = deptLoc;
	}
	@Override
	public String toString() {
		return "EmployeeDto [empId=" + empId + ", username=" + username + ", name=" + name + ", salary=" + salary
				+ ", joinDate=" + joinDate + ", leaveAvi=" + leaveAvi + ", deptId=" + deptId + ", mangId=" + mangId
				+ ", deptName=" + deptName + ", deptLoc=" + deptLoc + "]";
	}
	
	
	

}
