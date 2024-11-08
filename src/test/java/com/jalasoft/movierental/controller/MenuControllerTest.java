package com.jalasoft.movierental.controller;

import com.jalasoft.movierental.entity.Customer;
import com.jalasoft.movierental.entity.Rental;
import com.jalasoft.movierental.entity.movies.Movie;
import com.jalasoft.movierental.service.CustomerService;
import com.jalasoft.movierental.service.MovieService;
import com.jalasoft.movierental.service.RentalService;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class MenuControllerTest {

  private AutoCloseable closeable;

  @Mock
  private CustomerService customerService;

  @Mock
  private MovieService movieService;

  @Mock
  private RentalService rentalService;

  private MenuController menuController;

  @BeforeEach
  void setUp() throws Exception {
    closeable = MockitoAnnotations.openMocks(this);

    menuController = MenuController.getInstance();

    setMock(menuController, "customerService", customerService);
    setMock(menuController, "movieService", movieService);
    setMock(menuController, "rentalService", rentalService);
  }

  @AfterEach
  void tearDown() throws Exception {
    resetSingleton();
    closeable.close();
  }

  @Test
  void addCustomer_WhenCalled_ShouldAddCustomerSuccessfully() {
    // Arrange
    String input = "John Doe\n";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    // Act
    assertDoesNotThrow(() -> menuController.addCustomer());

    // Assert
    verify(customerService, times(1)).addCustomer(any(Customer.class));
  }

  @Test
  void addMovie_WhenCalled_ShouldAddMovieSuccessfully() {
    // Arrange
    String input = "NEW_RELEASE\nInception\n";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    // Act
    assertDoesNotThrow(() -> menuController.addMovie());

    // Assert
    verify(movieService, times(1)).addMovie(any(Movie.class));
  }

  @Test
  void addRental_WhenCalled_ShouldAddRentalSuccessfully() {
    // Arrange
    UUID customerId = UUID.randomUUID();
    UUID movieId = UUID.randomUUID();
    String input = customerId + "\n" + movieId + "\n7\n";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    // Act
    assertDoesNotThrow(() -> menuController.addRental());

    // Assert
    verify(rentalService, times(1)).addRental(any(Rental.class));
  }

  @Test
  void showAllCustomerRentals_WhenCalled_ShouldDisplayAllRentals() {
    // Arrange
    // No setup needed as the method simply displays all rentals

    // Act
    assertDoesNotThrow(() -> menuController.showAllCustomerRentals());

    // Assert
    verify(rentalService, times(1)).showAllCustomerRentals();
  }

  @Test
  void showCustomerRentalsByCustomerId_WhenCalledWithValidId_ShouldDisplayCustomerRentals() {
    // Arrange
    UUID customerId = UUID.randomUUID();
    String input = customerId + "\n";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    // Act
    assertDoesNotThrow(() -> menuController.showCustomerRentalsByCustomerId());

    // Assert
    verify(rentalService, times(1)).showDetailsByCustomerId(customerId);
  }

  private void setMock(Object instance, String fieldName, Object mock) throws Exception {
    Field field = instance.getClass().getDeclaredField(fieldName);
    field.setAccessible(true);
    field.set(instance, mock);
  }

  private void resetSingleton() throws Exception {
    Field instance = MenuController.class.getDeclaredField("instance");
    instance.setAccessible(true);
    instance.set(null, null);
  }
}
