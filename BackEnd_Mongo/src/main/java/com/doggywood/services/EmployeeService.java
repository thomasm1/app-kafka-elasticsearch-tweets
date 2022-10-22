package com.doggywood.services;

import java.util.List;

import com.doggywood.entities.Employee;


public interface EmployeeService {

	public Employee createEmployee(Employee employee);
	public Employee getEmployeeById(int id);
	public Employee getEmployeeByEmail(String email);
//	public Object getEmployeeByEmailAndPassword(String email, String password);
	
	public List<Employee> getAllEmployees();
	public Employee updatesEmployee(Employee change);
	public boolean deleteEmployee(Employee employee);
	public Employee getEmployeeByEmailAndPassword(String email, String password);
	
}
