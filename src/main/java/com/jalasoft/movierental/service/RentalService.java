package com.jalasoft.movierental.service;

import com.jalasoft.movierental.entity.Customer;
import com.jalasoft.movierental.entity.movies.Movie;
import com.jalasoft.movierental.repository.JsonCustomerRepository;
import com.jalasoft.movierental.repository.JsonMovieRepository;
import com.jalasoft.movierental.repository.JsonRentalRepository;
import com.jalasoft.movierental.entity.Rental;
import com.jalasoft.movierental.repository.Repository;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Service class for managing Rental entities.
 * Provides methods for adding, retrieving, and listing rentals.
 *
 * Author: Deyvis Mamani L.
 */
public class RentalService {

  private static RentalService instance;
  private static final Logger logger = LoggerFactory.getLogger(RentalService.class);
  private final Repository<Rental> rentalRepository;
  private final Repository<Movie> movieRepository;
  private final Repository<Customer> customerRepository;

  /**
   * Private constructor to initialize the service.
   * Uses JsonRentalRepository, JsonMovieRepository, and JsonCustomerRepository as the repository implementations.
   */
  private RentalService() {
    this.rentalRepository = JsonRentalRepository.getInstance();
    this.movieRepository = JsonMovieRepository.getInstance();
    this.customerRepository = JsonCustomerRepository.getInstance();
  }

  /**
   * Returns the singleton instance of RentalService.
   *
   * @return the singleton instance
   */
  public static RentalService getInstance() {
    if (instance == null) {
      instance = new RentalService();
    }
    return instance;
  }

  /**
   * Adds a new rental to the repository.
   * Validates if the customer and movie exist before saving the rental.
   *
   * @param rental the rental to add
   */
  public void addRental(Rental rental) {
    logger.info("Adding rental: {}", rental);
    // Validate if the customer and movie exist
    customerRepository.findById(rental.getCustomerId());
    movieRepository.findById(rental.getMovieId());

    rentalRepository.save(rental);
  }

  public List<Rental> getAllRentalsByCustomerId(UUID customerId) {
    return rentalRepository.findAll()
        .stream()
        .filter(rental -> rental.getCustomerId().equals(customerId))
        .collect(Collectors.toList());
  }

  /**
   * Displays all rentals for all customers.
   */
  public void showAllCustomerRentals() {
    customerRepository.findAll().forEach(customer -> showDetailsByCustomerId(customer.getId()));
  }

  /**
   * Displays rental details for a specific customer by their unique identifier.
   *
   * @param customerId the unique identifier of the customer
   */
  public void showDetailsByCustomerId(UUID customerId) {
    Customer customer = customerRepository.findById(customerId);
    StringBuilder details = new StringBuilder();
    details.append("Rental record for: ").append(customer.getName()).append("\n");

    getAllRentalsByCustomerId(customerId).forEach(rental -> {
      double rentalAmount = calculateRentalAmount(rental);
      details.append("\t")
          .append(movieRepository.findById(rental.getMovieId()).getTitle())
          .append("\t")
          .append(rentalAmount)
          .append("\n");
    });

    details.append("Amount owed is: ").append(calculateTotalRentalAmount(customer)).append("\n");
    details.append("You earn: ").append(calculateTotalRentalPoints(customer)).append(" frequent renter points");
    details.append("\n");

    System.out.println(details);
  }

  /**
   * Calculates the total rental amount for a specific customer.
   *
   * @param customer the customer for whom to calculate the total rental amount
   * @return the total rental amount
   */
  public double calculateTotalRentalAmount(Customer customer) {
    return getAllRentalsByCustomerId(customer.getId())
        .stream()
        .mapToDouble(this::calculateRentalAmount)
        .sum();
  }

  /**
   * Calculates the rental amount for a specific rental.
   *
   * @param rental the rental for which to calculate the amount
   * @return the rental amount
   */
  public double calculateRentalAmount(Rental rental) {
    return movieRepository.findById(rental.getMovieId()).calculateAmount(rental.getDaysRented());
  }

  /**
   * Calculates the total frequent renter points for a specific customer.
   *
   * @param customer the customer for whom to calculate the total frequent renter points
   * @return the total frequent renter points
   */
  public int calculateTotalRentalPoints(Customer customer) {
    return getAllRentalsByCustomerId(customer.getId())
        .stream()
        .mapToInt(this::calculateRentalPoints)
        .sum();
  }

  /**
   * Calculates the frequent renter points for a specific rental.
   *
   * @param rental the rental for which to calculate the frequent renter points
   * @return the frequent renter points
   */
  public int calculateRentalPoints(Rental rental) {
    return movieRepository.findById(rental.getMovieId()).calculateFrequentRenterPoints(rental.getDaysRented());
  }
}