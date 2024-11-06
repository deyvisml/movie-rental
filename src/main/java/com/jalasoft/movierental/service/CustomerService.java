package com.jalasoft.movierental.service;

import com.jalasoft.movierental.entity.Customer;
import com.jalasoft.movierental.repository.CustomerRepository;
import com.jalasoft.movierental.repository.JsonCustomerRepository;
import java.util.List;
import java.util.UUID;

/**
 * @author Deyvis Mamani L.
 * @created 05/11/2024
 */
public class CustomerService {

  private static CustomerService instance;
  private final CustomerRepository customerRepository;

  private CustomerService() {
    this.customerRepository = JsonCustomerRepository.getInstance();
  }

  public static CustomerService getInstance() {
    if (instance == null) {
      instance = new CustomerService();
    }
    return instance;
  }

  public Customer addCustomer(Customer customer) {
    return customerRepository.saveCustomer(customer);
  }

  public Customer getCustomerById(UUID id) {
    return customerRepository.getCustomerById(id);
  }

  public List<Customer> getAllCustomers() {
    return customerRepository.getAllCustomers();
  }
}
