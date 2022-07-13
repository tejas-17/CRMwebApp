package com.tejas.springdemo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tejas.springdemo.entity.Customer;
@Repository
public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void save(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
	
}