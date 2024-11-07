package com.jalasoft.movierental.service;

import com.jalasoft.movierental.entity.Customer;
import com.jalasoft.movierental.repository.JsonCustomerRepository;
import com.jalasoft.movierental.repository.Repository;
import java.util.List;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Service class for managing Customer entities.
 * Provides methods for adding, retrieving, and listing customers.
 *
 * Author: Deyvis Mamani L.
 */
public class CustomerService {

  private static CustomerService instance;
  private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);
  private final Repository<Customer> customerRepository;

  /**
   * Private constructor to initialize the service.
   * Uses JsonCustomerRepository as the repository implementation.
   */
  private CustomerService() {
    this.customerRepository = JsonCustomerRepository.getInstance();
  }

  /**
   * Returns the singleton instance of CustomerService.
   *
   * @return the singleton instance
   */
  public static CustomerService getInstance() {
    if (instance == null) {
      instance = new CustomerService();
    }
    return instance;
  }

  /**
   * Adds a new customer to the repository.
   *
   * @param customer the customer to add
   * @return the added customer
   */
  public Customer addCustomer(Customer customer) {
    logger.info("Adding customer: {}", customer);
    return customerRepository.save(customer);
  }

  /**
   * Retrieves a customer by their unique identifier.
   *
   * @param id the unique identifier of the customer
   * @return the customer with the specified identifier
   */
  public Customer getCustomerById(UUID id) {
    logger.info("Getting customer by id: {}", id);
    return customerRepository.findById(id);
  }

  /**
   * Retrieves all customers from the repository.
   *
   * @return a list of all customers
   */
  public List<Customer> getAllCustomers() {
    logger.info("Getting all customers");
    return customerRepository.findAll();
  }
}