package com.doggywood.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.doggywood.entities.EmployeeWelcomeBean;
import com.doggywood.entities.Pet;   // => Pets assigned to vet employee?
import com.doggywood.entities.Customer;
import com.doggywood.entities.Employee;
import com.doggywood.entities.EmployeeWelcomeBean;
import com.doggywood.services.EmployeeService;


@CrossOrigin(origins = "*")
@RestController
public class EmployeeWelcomeController {
	
	@Autowired
	EmployeeService es;

	// CUSTOMER LANDING
	@GetMapping(value = "/employee-welcome")
	public String  employeeWelcome() {
		return ("Welcome to Doggywood");
	}
// CUSTOMER BEAN LANDING 
	@GetMapping(value = "/employee-welcome-bean")
	public EmployeeWelcomeBean employeeWelcomBean() {
		return new EmployeeWelcomeBean("Welcome to Doggywood");
	}
//	 CUSTOMER BEAN LANDING - get info
//employee-welcome/value-variable/
	@GetMapping(value = "/employee-welcome/{email}")
	public EmployeeWelcomeBean employeeWelcomeBean(@PathVariable String email) {
		return new EmployeeWelcomeBean(String.format("Welcome to Doggywood, %s!", email));
	}

//employee-welcome/value-variable/
	@GetMapping(value = "/employee-welcome/profile/{email}")
	public Employee employeeProfile(@PathVariable String email) {
		return es.getEmployeeByEmail(email);// .toString();
	}
	
	// employee-welcome/value-variable/ POST
	@PostMapping(value = "/employee-welcome/profile/login")
	public Employee employeePostProfile(@RequestBody Employee employee) {
//		System.out.println(email+password);
		try {
			if (es.getEmployeeByEmailAndPassword(employee.getEmail(), employee.getPassword()) != null) {
				return es.getEmployeeByEmailAndPassword(employee.getEmail(), employee.getPassword());
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
//	 
//	@PostMapping(value = "/employee-welcome/register")
//	public boolean registerEmployee(@RequestBody Employee employee) {
//		if (es.getEmployeeByEmailAndPassword(employee.getEmail(), employee.getPassword()) != null) {
//			return true;
//		} else {
//			return false;
//		} 
//	};
//	 /// TEMPORARY PASSWORD THRU PARAMS    this testing through params....gonna make email/pw in requestbody!
//	@GetMapping(value = "/employee-login/")//{email}/{password}
////	public Employee loginEmployee(@RequestParam String email, @RequestParam String password ) {
//	public String loginEmployee(@RequestParam String email, @RequestParam String password ) {
//			if (email != null && password != null) {
//				return es.getEmployeeByEmailAndPassword(email, password).toString(); 
//			}
//			return null;
//	};
 

}
