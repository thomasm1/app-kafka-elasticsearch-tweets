package com.doggywood.services;

import java.util.List;

import com.doggywood.entities.Customer;


public interface CustomerService {

	public Customer createCustomer(Customer customer);
	public Customer getCustomerById(int id);
	public Customer getCustomerByEmail(String email);
	public List<Customer> getAllCustomers();
	public Customer updatesCustomer(Customer change);
	public boolean deleteCustomer(Customer customer);
	// login auth return Person
	public Customer getCustomerByEmailAndPassword(String email, String password);
	  
	// post-login authentication, get cust's nfts: Not in nfts
//	public Nft getNftsByCustEmail(String email);
	
}
