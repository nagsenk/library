package com.telusko.dao;

import java.util.List;

import com.telusko.model.Employee;

public interface EmployeeDao {

public List<Employee> listAllEmployee();
	
	public void addEmployee(Employee employee);
	
	public void updateEmployee(Employee employee); 
	
	public void deleteEmployee(int id);
	public Employee findEmployeeById(int id);

	
}
