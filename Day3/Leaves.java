package com.hrms.bean;

public class Leaves {
	
	private int empId ;
	private int leaveNo ;
	private int leaveDay ;
	private String reson ;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getLeaveNo() {
		return leaveNo;
	}
	public void setLeaveNo(int leaveNo) {
		this.leaveNo = leaveNo;
	}
	public int getLeaveDay() {
		return leaveDay;
	}
	public void setLeaveDay(int leaveDay) {
		this.leaveDay = leaveDay;
	}
	public String getReson() {
		return reson;
	}
	public void setReson(String reson) {
		this.reson = reson;
	}
	@Override
	public String toString() {
		return "Leaves [empId=" + empId + ", leaveNo=" + leaveNo + ", leaveDay=" + leaveDay + ", reson=" + reson + "]";
	}
	public Leaves(int empId, int leaveNo, int leaveDay, String reson) {
		super();
		this.empId = empId;
		this.leaveNo = leaveNo;
		this.leaveDay = leaveDay;
		this.reson = reson;
	}
	public Leaves() {
		super();
	}
	
	

}
