package com.dennis.springdemo.service;

import java.util.List;

import com.dennis.springdemo.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);
}
