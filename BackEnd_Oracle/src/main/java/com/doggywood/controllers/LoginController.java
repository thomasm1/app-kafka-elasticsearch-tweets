package com.doggywood.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.doggywood.entities.Customer;
import com.doggywood.entities.Employee;
import com.doggywood.services.CustomerService;
import com.doggywood.services.EmployeeService; 


public class LoginController {

	@Autowired
	CustomerService cs;
	
	@PostMapping(value="/login")
	public boolean loginCustomer(@RequestBody Customer customer, HttpSession httpSession) {
		
		String username = httpSession.getAttribute("login_attempt_username").toString();
		
		if(cs.getCustomerByEmailAndPassword(customer.getEmail(), customer.getPassword()) != null) {
			return true;
		}
		else {
			return false;
		}
		
	}	

	@Autowired
	EmployeeService es;
	
	@PostMapping(value="/admin")
	public boolean loginEmployee(@RequestBody Employee employee, HttpSession httpSession) {
		
		String username = httpSession.getAttribute("login_attempt_username").toString();
		
		if(es.getEmployeeByEmailAndPassword(employee.getEmail(), employee.getPassword()) != null) {
			return true;
		}
		else {
			return false;
		}
		
	}	
	
}
