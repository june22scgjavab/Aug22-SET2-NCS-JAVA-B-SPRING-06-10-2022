package com.myshop.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	// GET http://localhost:9999/customerapi/customer/1
	@GetMapping("/customer/{customerId}")
	public CustomerDTO getCustomer(@PathVariable("customerId") int id) {
		CustomerDTO customerDTO = null;
		try {
			customerDTO = customerService.getCustomer(id);
		} catch (CustomerException e) {

			e.printStackTrace();
		}
		return customerDTO;
	}

	// GET http://localhost:9999/customerapi/customer
	@GetMapping("/customer")
	public List<CustomerDTO> getAllCustomers() {
		List<CustomerDTO> customerDTOList = customerService.getAllCustomers();

		return customerDTOList;
	}

	// POST http://localhost:9999/customerapi/addcustomer
	@PostMapping("/addcustomer")
	public String addCustomer(@RequestBody CustomerDTO customerDTO) {
		String message = "SUCCESS";
		try {
			customerService.addCustomer(customerDTO);
		} catch (CustomerException e) {

			e.printStackTrace();
		}

		return message;
	}
	// PUT http://localhost:9999/customerapi/updateCustomer/1

	@PutMapping("/updateCustomer/{id}")
	public String updateCustomer(@RequestBody CustomerDTO customerDTO, @PathVariable int id)

	{
		String message = "SUCCESS";
		try {
			customerService.updateCustomer(id, customerDTO.getEmailId());
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

	// DELETE http://localhost:9999/customerapi/deleteCustomer/1
	@DeleteMapping("/deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable int id) {
		String message = "SUCCESS";
		try {
			customerService.deleteCustomer(id);
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}
}
