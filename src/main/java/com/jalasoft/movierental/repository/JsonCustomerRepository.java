package com.jalasoft.movierental.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jalasoft.movierental.entity.Customer;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author Deyvis Mamani L.
 */
public class JsonCustomerRepository implements CustomerRepository {

  private static JsonCustomerRepository instance;
  private final ObjectMapper mapper;
  private static final String FILE_PATH = "data/customers.json";
  private final File file;
  private final List<Customer> customers;

  private JsonCustomerRepository() {
    this.mapper = new ObjectMapper();
    this.file = new File(FILE_PATH);
    this.customers = readCustomers();
  }

  public static JsonCustomerRepository getInstance() {
    if (instance == null) {
      instance = new JsonCustomerRepository();
    }
    return instance;
  }

  @Override
  public Customer saveCustomer(Customer customer) {
    customers.add(customer);
    writeCustomers();
    return customer;
  }

  @Override
  public Customer getCustomerById(UUID id) {
    return customers.stream()
        .filter(customer -> customer.getId().equals(id))
        .findFirst()
        .orElseThrow();
  }

  @Override
  public List<Customer> getAllCustomers() {
    return customers;
  }

  private List<Customer> readCustomers() {
    if (!file.exists()) {
      return new ArrayList<>();
    }

    try {
      return mapper.readValue(file, new TypeReference<List<Customer>>() {});
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private void writeCustomers() {
    try {
      mapper.writerWithDefaultPrettyPrinter().writeValue(file, customers);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
