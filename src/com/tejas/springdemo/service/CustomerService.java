package com.tejas.springdemo.service;

import java.util.List;

import com.tejas.springdemo.entity.Customer;

public interface CustomerService {

	
	public List<Customer> getCustomers();

	public void save(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);

	public List<Customer> searchCustomers(String searchName);
}
