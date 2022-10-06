package com.myshop.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myshop.dto.CustomerDTO;
import com.myshop.exception.CustomerException;
import com.myshop.service.CustomerService;

@RestController
@RequestMapping("/customerapi")
public class CustomerAPI {

	@Autowired
	private CustomerService customerService;
	
	// http://localhost:8080/customerapi/customer/1
	@GetMapping("/customer/{customerId}")
	public CustomerDTO getCustomer(@PathVariable("customerId") int id) {
		CustomerDTO customerDTO=null;
		try {
			customerDTO = customerService.getCustomer(id);
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customerDTO;
	}
}
