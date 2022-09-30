package com.hrms.bean;

public class Employee {
	
	private int empId ;
	private String username ;
	private String password ;
	private String name ;
	private int deptId ;
	private int mangId ;
	private int salary ;
	private String joinDate ;
	private int leaveAvi ;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public int getLeaveAvi() {
		return leaveAvi;
	}
	public void setLeaveAvi(int leaveAvi) {
		this.leaveAvi = leaveAvi;
	}
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", deptId=" + deptId + ", mangId=" + mangId + ", salary=" + salary + ", joinDate=" + joinDate
				+ ", leaveAvi=" + leaveAvi + "]";
	}
	 
	public Employee(int empId, String username, String password, String name, int deptId, int mangId, int salary,
			String joinDate, int leaveAvi) {
		super();
		this.empId = empId;
		this.username = username;
		this.password = password;
		this.name = name;
		this.deptId = deptId;
		this.mangId = mangId;
		this.salary = salary;
		this.joinDate = joinDate;
		this.leaveAvi = leaveAvi;
	}
	public Employee() {
		
	}
	
	

}
