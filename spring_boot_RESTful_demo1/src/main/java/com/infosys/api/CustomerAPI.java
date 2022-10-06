package com.infosys.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.entity.Customer;

 
@RestController	
@RequestMapping("/customerapi")
public class CustomerAPI {
	// http://localhost:8080/customerapi/sayhello
	@GetMapping("/sayhello")
	public Customer greet() {
		Customer customer=new Customer(1,"Ram","ram@gmail.com");
		return customer;
	}
	// http://localhost:8080/customerapi/sayhi
	@GetMapping("/sayhi")
	public String greetHi() {
		return "Hiiii";
	}
}
