package com.doggywood.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.doggywood.entities.Customer;
import com.doggywood.services.CustomerService;

@CrossOrigin(origins = "*")
@RestController
public class CustomerController {

	@Autowired
	CustomerService cs;
	
	@RequestMapping(value = "/customers", method = RequestMethod.POST, consumes = "application/json") 
	public Customer createCustomer(@RequestBody Customer customer) {
		return cs.createCustomer(customer);
	}
	
	@GetMapping(value = "/customers/{id}") 
	public Customer getCustomerById(@PathVariable("id") int id) {
		return cs.getCustomerById(id);
	}

	@GetMapping(value = "/customers") 
	public List<Customer> getAllCustomers() {
		return cs.getAllCustomers();
	}

	@PutMapping(value = "/customers", consumes = "application/json") 
	public Customer updatesCustomer(@RequestBody Customer change) {
		return cs.updatesCustomer(change);
	}

	@DeleteMapping(value = "/customers/{id}") 
	public boolean deleteCustomer(@PathVariable("id") int id) {
		try {
			cs.deleteCustomer(cs.getCustomerById(id));
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}

	