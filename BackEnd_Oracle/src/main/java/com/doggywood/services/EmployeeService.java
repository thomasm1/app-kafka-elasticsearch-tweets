package com.doggywood.services;

import java.util.List;

import com.doggywood.dto.APIResponseDto;
import com.doggywood.dto.DashboardDto;
import com.doggywood.dto.EmployeeDto;
import com.doggywood.entities.Employee;


public interface EmployeeService {

	public Employee saveEmployee(Employee employee);

	EmployeeDto createEmployee(EmployeeDto employeeDto);


	public APIResponseDto getEmployeeById(int id);

	EmployeeDto saveEmployee(EmployeeDto employeeDto);

	APIResponseDto getEmployeeById(Integer eId);

	public Employee getEmployeeByEmail(String email);
//	public Object getEmployeeByEmailAndPassword(String email, String password);

	public List<Employee> getAllEmployees();
	public Employee updatesEmployee(Employee change);
	public boolean deleteEmployee(Employee employee);
	public Employee getEmployeeByEmailAndPassword(String email, String password);

	DashboardDto getDashboardByEmployeeId(int id);
}
