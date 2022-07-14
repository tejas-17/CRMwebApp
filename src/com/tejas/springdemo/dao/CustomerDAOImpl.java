package com.tejas.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tejas.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Customer> getCustomers() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query
		Query<Customer> theQuery = 
				currentSession.createQuery("from Customer order by last_name", Customer.class);
		
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
				
		// return the results		
		return customers;
	}

	@Override
	public void save(Customer theCustomer) {
		//get current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
		
		//ssave the customer to db..

		//save/update customer..
		currentSession.saveOrUpdate(theCustomer);
		
		
		
		
		
	}

	@Override
	public Customer getCustomer(int theId) {
		// TODO Auto-generated method stub
		
		//get current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
		
		
		
		//retirueve/read from DB using promary key
		Customer theCustomer=currentSession.get(Customer.class,theId);
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		//get the current hibernate sesion
		Session currentSession=sessionFactory.getCurrentSession();
		

		//delete the object with primary key
	Query theQuery= currentSession.createQuery("delete from Customer where id=:CustomerId");
	theQuery.setParameter("CustomerId", theId);
	
	
	
	theQuery.executeUpdate();
	
	}

	@Override
	public List<Customer> searchCustomers(String searchName) {
		 // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        Query theQuery = null;
        
        //
        // only search by name if theSearchName is not empty
        //
        if (searchName != null && searchName.trim().length() > 0) {
            // search for firstName or lastName ... case insensitive
            theQuery =currentSession.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
            theQuery.setParameter("theName", "%" + searchName.toLowerCase() + "%");
        }
        else {
            // theSearchName is empty ... so just get all customers
            theQuery =currentSession.createQuery("from Customer", Customer.class);            
        }
        
        // execute query and get result list
        List<Customer> customers = theQuery.getResultList();
                
        // return the results        
        return customers;
		
	}



		
	}

		
	


