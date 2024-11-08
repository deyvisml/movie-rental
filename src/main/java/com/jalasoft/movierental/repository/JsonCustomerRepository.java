package com.jalasoft.movierental.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jalasoft.movierental.entity.Customer;
import com.jalasoft.movierental.exception.custom.FileAccessException;
import com.jalasoft.movierental.exception.custom.ResourceNotFoundException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository class for managing Customer entities using JSON file storage.
 * Provides methods for saving, retrieving, and listing customers.
 *
 * Author: Deyvis Mamani L.
 */
public class JsonCustomerRepository implements Repository<Customer> {

  private static JsonCustomerRepository instance;
  private final ObjectMapper mapper;
  private static final String FILE_PATH = "data/customers.json";
  private final File file;
  private final List<Customer> customers;

  /**
   * Private constructor to initialize the repository.
   * Reads the customers from the JSON file.
   */
  private JsonCustomerRepository() {
    this.mapper = new ObjectMapper();
    this.file = new File(FILE_PATH);
    this.customers = readCustomers();
  }

  /**
   * Returns the singleton instance of JsonCustomerRepository.
   *
   * @return the singleton instance
   */
  public static JsonCustomerRepository getInstance() {
    if (instance == null) {
      instance = new JsonCustomerRepository();
    }
    return instance;
  }

  /**
   * Saves a new customer to the repository.
   *
   * @param customer the customer to save
   * @return the saved customer
   */
  @Override
  public Customer save(Customer customer) {
    customers.add(customer);
    writeCustomers();
    return customer;
  }

  /**
   * Retrieves a customer by their unique identifier.
   *
   * @param id the unique identifier of the customer
   * @return the customer with the specified identifier
   * @throws ResourceNotFoundException if the customer is not found
   */
  @Override
  public Customer findById(UUID id) {
    Optional<Customer> customer = customers.stream()
        .filter(c -> c.getId().equals(id))
        .findFirst();
    if (customer.isEmpty()) {
      throw new ResourceNotFoundException("Customer not found");
    }
    return customer.get();
  }

  /**
   * Retrieves all customers from the repository.
   *
   * @return a list of all customers
   */
  @Override
  public List<Customer> findAll() {
    return new ArrayList<>(customers);
  }

  /**
   * Reads the customers from the JSON file.
   *
   * @return a list of customers
   * @throws FileAccessException if there is an error reading the file
   */
  private List<Customer> readCustomers() {
    if (!file.exists()) {
      return new ArrayList<>();
    }

    try {
      return mapper.readValue(file, new TypeReference<List<Customer>>() {});
    } catch (IOException e) {
      throw new FileAccessException("Error reading customers", e);
    }
  }

  /**
   * Writes the customers to the JSON file.
   *
   * @throws FileAccessException if there is an error writing the file
   */
  private void writeCustomers() {
    try {
      mapper.writerWithDefaultPrettyPrinter().writeValue(file, customers);
    } catch (IOException e) {
      throw new FileAccessException("Error writing customers", e);
    }
  }
}