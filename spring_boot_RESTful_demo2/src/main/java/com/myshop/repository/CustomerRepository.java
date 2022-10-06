package com.myshop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.myshop.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	
	//Query creation based on the method name
	// select c from Customer c where c.emailId1 = ?1
	//Optional<Customer> findByEmailId(String emailId);
 // select c.name from Customer c where c.emailId = ?1
  //  String  findNameByEmailId(String emailId);

	//@Query("select c from Customer c where emailId=:email")
	//Optional<Customer> findByEmailId1(@Param("email") String emailId);
	@Query("select c from Customer c where emailId=?1")
	Optional<Customer> findByEmailId1(String emailId);
}
