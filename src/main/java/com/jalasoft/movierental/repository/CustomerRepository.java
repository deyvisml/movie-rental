package com.jalasoft.movierental.repository;

import com.jalasoft.movierental.entity.Customer;
import java.util.List;
import java.util.UUID;

/**
 * @author Deyvis Mamani L.
 */
public interface CustomerRepository {
  Customer saveCustomer(Customer customer);
  Customer getCustomerById(UUID uuid);
  List<Customer> getAllCustomers();
}
