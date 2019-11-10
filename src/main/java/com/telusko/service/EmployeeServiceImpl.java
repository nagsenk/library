package com.telusko.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.telusko.dao.EmployeeDao;
import com.telusko.model.Employee;
import com.telusko.model.Issue;

@Service
@Component
public class EmployeeServiceImpl implements EmployeeService {
	EmployeeDao employeeDao;
	@Autowired
	public void setEmployeedao(EmployeeDao employeedao) {
		this.employeeDao = employeedao;
	}

	
	@Override
public List<Employee> listAllEmployee(){
		return employeeDao.listAllEmployee();
	}
	@Override
	public void addEmployee(Employee employee) {
		employeeDao. addEmployee(employee);
	}
	@Override
	public void updateEmployee(Employee employee)
	{
		employeeDao.updateEmployee(employee);
	}
	@Override
	public void deleteEmployee(int id) {
		employeeDao.deleteEmployee(id);
	}
	@Override
	public Employee findEmployeeById(int id)
	{
		return employeeDao.findEmployeeById(id);
	}
	
	

}
