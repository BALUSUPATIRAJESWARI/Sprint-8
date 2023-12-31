package com.cabapp.pro.service;

import java.util.List;


import com.cabapp.pro.exception.AdminException;
import com.cabapp.pro.exception.CustomerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabapp.pro.entity.Customer;
import com.cabapp.pro.repository.ICustomerRepository;



@Service
public class CustomerServiceImpl implements ICustomerService {
	
	
	@Autowired
	ICustomerRepository customerRepository;
	
	

	public CustomerServiceImpl() {
	 System.out.println("Inside the service");
	}



	@Override
	public Customer insertCustomer(Customer customer) {
		
		 Customer savedCustomer=customerRepository.save(customer);
	
	  return savedCustomer;
	}



	@Override
	public Customer viewCustomer(int customerId) {
		 Customer savedCustomer=customerRepository.getCustomerByCustomerId(customerId);
		 if(savedCustomer!=null) {
			 return savedCustomer;
		 }
		 else {
			 throw new CustomerException(404, "Customer details not found");
		 }
	}



	@Override
	public List<Customer> viewCustomers() {
	 List<Customer> allCustomerList=customerRepository.findAll();
	 if(allCustomerList != null || allCustomerList.size() != 0)
	 {
		 return allCustomerList;
	 }
	 else {
		 throw new CustomerException(404, "Customer details not found");
	 }
	 
	}



	@Override
	public Customer validateCustomer(String userName, String password) {
		 
		List<Customer> c1  =customerRepository.findAll();
		if(c1 !=null){
			for (int i = 0; i < c1.size(); i++) {
				if (c1.get(i).getUsername().equals(userName) && c1.get(i).getPassword().equals(password))
					return c1.get(i);
			}
		}
		 else {
			throw new CustomerException(404, "Customer details not found");
		}
		 return null;
	}



	@Override
	public Customer updateCustomer(Customer customer, int id) {   
		Customer c1=customerRepository.findById(id).get();
		
	       if(c1!=null) {
			
			c1.setAddress(customer.getAddress());
			c1.setEmail(customer.getEmail());
			c1.setMobileNumber(customer.getMobileNumber());
			c1.setPassword(customer.getPassword());
			c1.setUsername(customer.getUsername());
			 
			customerRepository.save(c1);
	       
			
			return c1;
	       }
		   else {
			   throw new CustomerException(404, "Customer details not found");
		   }
			//doubt on address entity

		 
	}



	@Override
	public Customer deleteCustomer(int customerId) {
		 Customer customer=customerRepository.findById( customerId).get();
		 customerRepository.delete(customer);
		 return customer;//delete but doubt
		 
	}

}
