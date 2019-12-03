package com.database.app;

import com.database.model.Employee;
import com.database.repository.UserDaoImpl;

public class Authenticate {
	public static void main(String[] args) {
		
		Employee emp = new UserDaoImpl().getEmployee(125645);
		System.out.println("name : " + emp.getEmpName());
		System.out.println("empId : " + emp.getEmpId());
		System.out.println("empRole : " + emp.getEmpRole());
		System.out.println("empSalary : " + emp.getEmpSalary());
		System.out.println("is admin? : " + emp.isAdmin());
		
	}
}
