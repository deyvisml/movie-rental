package com.jalasoft.movierental.service;

import com.jalasoft.movierental.entity.Customer;
import com.jalasoft.movierental.repository.CustomerRepository;
import com.jalasoft.movierental.repository.JsonCustomerRepository;
import java.util.List;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Deyvis Mamani L.
 */
public class CustomerService {

  private static CustomerService instance;
  private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);
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
    logger.info("Adding customer: {}", customer);
    return customerRepository.saveCustomer(customer);
  }

  public Customer getCustomerById(UUID id) {
    logger.info("Getting customer by id: {}", id);
    customerRepository.getCustomerById(id);
    return customerRepository.getCustomerById(id);
  }

  public List<Customer> getAllCustomers() {
    logger.info("Getting all customers");
    return customerRepository.getAllCustomers();
  }
}
