package com.andrei.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andrei.thymeleafdemo.entity.Customer;




//for Spring Data JPA
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	//<Entity type, PK type>
	
	
	//add method to sort by last name
	public List<Customer>findAllByOrderByLastNameAsc();
}
