package com.myshop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.dto.CustomerDTO;
import com.myshop.entity.Customer;
import com.myshop.exception.CustomerException;
import com.myshop.repository.CustomerRepository;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	// EntityManager not required
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public void addCustomer(CustomerDTO customerDTO) throws CustomerException {
		Optional<Customer> customer = customerRepository.findById(customerDTO.getId());
		if (customer.isPresent()) {
			throw new CustomerException("Service.CUSTOMER_ALREADY_PRESENT");
		}
		Customer cust = new Customer();
		cust.setId(customerDTO.getId());
		cust.setName(customerDTO.getName());
		cust.setEmailId(customerDTO.getEmailId());
		customerRepository.save(cust);

	}

	@Override
	public CustomerDTO getCustomer(int id) throws CustomerException {
		Optional<Customer> customerOptional = customerRepository.findById(id);
		Customer customer = customerOptional.orElseThrow(() -> new CustomerException("Service.CUSTOMER_NOT_FOUND"));
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setId(customer.getId());
		customerDTO.setName(customer.getName());
		customerDTO.setEmailId(customer.getEmailId());
		return customerDTO;
	}

	@Override
	public List<CustomerDTO> getAllCustomers() {
		List<Customer> customerList = (List<Customer>) customerRepository.findAll();
		List<CustomerDTO> customerDTOList = new ArrayList<>();
		customerList.forEach((customer) -> {
			CustomerDTO customerDTO = new CustomerDTO();
			customerDTO.setId(customer.getId());
			customerDTO.setName(customer.getName());
			customerDTO.setEmailId(customer.getEmailId());
			customerDTOList.add(customerDTO);

		});
		return customerDTOList;
	}

	@Override
	public void deleteCustomer(int id) throws CustomerException {
		Optional<Customer> customerOptional = customerRepository.findById(id);
		Customer customer = customerOptional.orElseThrow(() -> new CustomerException("Service.CUSTOMER_NOT_FOUND"));
		customerRepository.deleteById(id);
	}

	@Override
	public void updateCustomer(int id, String email) throws CustomerException {
		Optional<Customer> customerOptional = customerRepository.findById(id);
		Customer customer = customerOptional.orElseThrow(() -> new CustomerException("Service.CUSTOMER_NOT_FOUND"));
		customer.setEmailId(email);
	}
	@Override
	 	public CustomerDTO getCustomerByEmail(String emailId) throws CustomerException {
         Optional<Customer> customerOptional=customerRepository.findByEmailId1(emailId); 
     	Customer customer = customerOptional.orElseThrow(() -> new CustomerException("Service.CUSTOMER_NOT_FOUND"));         
	   CustomerDTO customerDTO=new CustomerDTO();
	   customerDTO.setId(customer.getId());
	   customerDTO.setName(customer.getName());
	   customerDTO.setEmailId(customer.getEmailId());
	  return customerDTO;
	}
	}
