package com.jalasoft.movierental.service;

import com.jalasoft.movierental.entity.Customer;
import com.jalasoft.movierental.repository.Repository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class CustomerServiceTest {

  private AutoCloseable closeable;

  private CustomerService customerService;

  @Mock
  private Repository<Customer> customerRepository;

  @BeforeEach
  void setUp() throws Exception {
    closeable = MockitoAnnotations.openMocks(this);

    // Get the singleton instance of CustomerService
    customerService = CustomerService.getInstance();

    // Use reflection to inject the mock into the singleton
    setMock(customerService, "customerRepository", customerRepository);
  }

  @AfterEach
  void tearDown() throws Exception {
    resetSingleton();
    closeable.close();
  }

  @Test
  void addCustomer_WhenCalledWithValidCustomer_ShouldReturnAddedCustomer() {
    // Arrange
    Customer customer = new Customer("John Doe");
    when(customerRepository.save(customer)).thenReturn(customer);

    // Act
    Customer addedCustomer = customerService.addCustomer(customer);

    // Assert
    assertNotNull(addedCustomer);
    assertEquals("John Doe", addedCustomer.getName());
    verify(customerRepository, times(1)).save(customer);
  }

  @Test
  void getCustomerById_WhenCalledWithValidId_ShouldReturnCustomer() {
    // Arrange
    UUID customerId = UUID.randomUUID();
    Customer customer = new Customer("Jane Doe");
    when(customerRepository.findById(customerId)).thenReturn(customer);

    // Act
    Customer retrievedCustomer = customerService.getCustomerById(customerId);

    // Assert
    assertNotNull(retrievedCustomer);
    assertEquals("Jane Doe", retrievedCustomer.getName());
    verify(customerRepository, times(1)).findById(customerId);
  }

  @Test
  void getAllCustomers_WhenCalled_ShouldReturnListOfAllCustomers() {
    // Arrange
    Customer customer1 = new Customer("Alice");
    Customer customer2 = new Customer("Bob");
    List<Customer> customers = Arrays.asList(customer1, customer2);
    when(customerRepository.findAll()).thenReturn(customers);

    // Act
    List<Customer> allCustomers = customerService.getAllCustomers();

    // Assert
    assertNotNull(allCustomers);
    assertEquals(2, allCustomers.size());
    verify(customerRepository, times(1)).findAll();
  }

  private void setMock(Object instance, String fieldName, Object mock) throws Exception {
    Field field = instance.getClass().getDeclaredField(fieldName);
    field.setAccessible(true);
    field.set(instance, mock);
  }

  private void resetSingleton() throws Exception {
    Field instance = CustomerService.class.getDeclaredField("instance");
    instance.setAccessible(true);
    instance.set(null, null);
  }
}
