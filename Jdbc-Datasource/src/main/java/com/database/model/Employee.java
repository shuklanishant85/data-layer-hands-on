package com.database.model;

public class Employee {

	private String empName;
	private long empId;
	private long empSalary;
	private String empRole;
	private boolean isAdmin;

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public long getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(long empSalary) {
		this.empSalary = empSalary;
	}

	public String getEmpRole() {
		return empRole;
	}

	public void setEmpRole(String empRole) {
		this.empRole = empRole;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

}
