package com.dennis.springdemo.dao;

import java.util.List;

import com.dennis.springdemo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);
	
}
