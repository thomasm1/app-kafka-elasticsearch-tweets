package com.doggywood.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doggywood.entities.Customer;
//import com.doggywood.entities.Pet;
import com.doggywood.repositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository cr;

	@Override
	public Customer createCustomer(Customer customer) {
		return cr.save(customer);
	}

// GET CUSTOMER
	@Override
	public Customer getCustomerById(int id) {
		try {
			return cr.findById(id).get();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Customer getCustomerByEmail(String email) {
		try {
			return cr.findByEmail(email).get();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Customer getCustomerByEmailAndPassword(String email, String password) {
		try {
			return cr.findByEmailAndPassword(email, password).get();
		} catch (Exception e) {
			return null;
		}
	}

// GET ALL CUSTOMERS
	@Override
	public List<Customer> getAllCustomers() {
		return (List<Customer>) cr.findAll();
	}

	@Override
	public Customer updatesCustomer(Customer change) {
		return cr.save(change);
	}

	@Override
	public boolean deleteCustomer(Customer customer) {
		try {
			cr.delete(customer);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
