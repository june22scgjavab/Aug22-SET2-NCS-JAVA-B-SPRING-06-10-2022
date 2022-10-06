package com.myshop.service;

import java.util.List;

import com.myshop.dto.CustomerDTO;
import com.myshop.exception.CustomerException;

public interface CustomerService {
public void addCustomer(CustomerDTO customerDTO) throws CustomerException;
public CustomerDTO getCustomer(int id) throws CustomerException;
public List<CustomerDTO> getAllCustomers();
public void deleteCustomer(int id) throws CustomerException;
public void updateCustomer(int id, String email) throws CustomerException;
public CustomerDTO getCustomerByEmail(String emailId) throws CustomerException;

}
