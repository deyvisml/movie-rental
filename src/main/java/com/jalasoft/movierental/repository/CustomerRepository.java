package com.jalasoft.movierental.repository;

import com.jalasoft.movierental.entity.Customer;
import java.util.List;
import java.util.UUID;

/**
 * Repository interface for managing Customer entities.
 * Provides methods for saving, retrieving, and listing customers.
 *
 * Author: Deyvis Mamani L.
 */
public interface CustomerRepository {

  /**
   * Saves the given customer to the repository.
   *
   * @param customer the customer to save
   * @return the saved customer
   */
  Customer saveCustomer(Customer customer);

  /**
   * Retrieves a customer by their unique identifier.
   *
   * @param uuid the unique identifier of the customer
   * @return the customer with the specified identifier, or null if not found
   */
  Customer getCustomerById(UUID uuid);

  /**
   * Retrieves all customers from the repository.
   *
   * @return a list of all customers
   */
  List<Customer> getAllCustomers();
}