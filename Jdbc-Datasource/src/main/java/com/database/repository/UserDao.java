package com.database.repository;

import com.database.model.Employee;

public interface UserDao {
	
	public Employee getEmployee(long empId);
	
	public boolean addEmployee(Employee employee);
	
	public boolean deleteEmployee(Employee employee);
	
	public boolean updateEmployee(Employee employee);

}
