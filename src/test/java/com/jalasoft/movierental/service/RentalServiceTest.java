package com.jalasoft.movierental.service;

import com.jalasoft.movierental.entity.Customer;
import com.jalasoft.movierental.entity.Rental;
import com.jalasoft.movierental.entity.movies.Movie;
import com.jalasoft.movierental.entity.movies.MovieType;
import com.jalasoft.movierental.factory.MovieFactory;
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

class RentalServiceTest {

  private AutoCloseable closeable;

  private RentalService rentalService;

  @Mock
  private Repository<Rental> rentalRepository;

  @Mock
  private Repository<Movie> movieRepository;

  @Mock
  private Repository<Customer> customerRepository;

  @BeforeEach
  void setUp() throws Exception {
    closeable = MockitoAnnotations.openMocks(this);

    // Get the singleton instance of RentalService
    rentalService = RentalService.getInstance();

    // Use reflection to inject mocks into the singleton
    setMock(rentalService, "rentalRepository", rentalRepository);
    setMock(rentalService, "movieRepository", movieRepository);
    setMock(rentalService, "customerRepository", customerRepository);
  }

  @AfterEach
  void tearDown() throws Exception {
    resetSingleton();
    closeable.close();
  }

  @Test
  void addRental_WhenCalledWithValidRental_ShouldSaveRental() {
    // Arrange
    UUID customerId = UUID.randomUUID();
    UUID movieId = UUID.randomUUID();
    Rental rental = new Rental(customerId, movieId, 5);

    Customer customer = new Customer("John Doe");
    Movie movie = MovieFactory.createMovie(MovieType.NEW_RELEASE, "Inception");

    when(customerRepository.findById(customerId)).thenReturn(customer);
    when(movieRepository.findById(movieId)).thenReturn(movie);

    // Act
    rentalService.addRental(rental);

    // Assert
    verify(customerRepository, times(1)).findById(customerId);
    verify(movieRepository, times(1)).findById(movieId);
    verify(rentalRepository, times(1)).save(rental);
  }

  @Test
  void showAllCustomerRentals_WhenCalled_ShouldDisplayAllCustomerRentals() {
    // Arrange
    Customer customer1 = new Customer("Alice");
    customer1.setId(UUID.randomUUID());
    Customer customer2 = new Customer("Bob");
    customer2.setId(UUID.randomUUID());

    when(customerRepository.findAll()).thenReturn(Arrays.asList(customer1, customer2));
    when(customerRepository.findById(any(UUID.class))).thenReturn(customer1);

    // Act
    rentalService.showAllCustomerRentals();

    // Assert
    verify(customerRepository, times(1)).findAll();
  }

  @Test
  void getAllRentalsByCustomerId_WhenCalledWithCustomerId_ShouldReturnCustomerRentals() {
    // Arrange
    UUID customerId = UUID.randomUUID();
    Rental rental1 = new Rental(customerId, UUID.randomUUID(), 3);
    Rental rental2 = new Rental(customerId, UUID.randomUUID(), 7);

    when(rentalRepository.findAll()).thenReturn(Arrays.asList(rental1, rental2));

    // Act
    List<Rental> rentals = rentalService.getAllRentalsByCustomerId(customerId);

    // Assert
    assertNotNull(rentals);
    assertEquals(2, rentals.size());
    verify(rentalRepository, times(1)).findAll();
  }

  private void setMock(Object instance, String fieldName, Object mock) throws Exception {
    Field field = instance.getClass().getDeclaredField(fieldName);
    field.setAccessible(true);
    field.set(instance, mock);
  }

  private void resetSingleton() throws Exception {
    Field instance = RentalService.class.getDeclaredField("instance");
    instance.setAccessible(true);
    instance.set(null, null);
  }
}
