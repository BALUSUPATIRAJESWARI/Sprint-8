package com.cabapp.pro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cabapp.pro.entity.Customer;

public interface ICustomerService {
	
	
	public Customer insertCustomer(Customer customer);
	public Customer viewCustomer(int customerId);//getting customers based on userId not on cuatomerId problem
	public List<Customer> viewCustomers();
	public Customer validateCustomer(String userName, String password);
	public Customer updateCustomer(Customer customer, int id );
	public Customer deleteCustomer(int customerId);

}
