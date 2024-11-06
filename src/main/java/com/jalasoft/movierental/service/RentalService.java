package com.jalasoft.movierental.service;

import com.jalasoft.movierental.entity.Customer;
import com.jalasoft.movierental.repository.JsonMovieRepository;
import com.jalasoft.movierental.repository.JsonRentalRepository;
import com.jalasoft.movierental.entity.Rental;
import com.jalasoft.movierental.repository.MovieRepository;
import com.jalasoft.movierental.repository.RentalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Deyvis Mamani L.
 */
public class RentalService {

  private static RentalService instance;
  private static final Logger logger = LoggerFactory.getLogger(RentalService.class);
  private final RentalRepository rentalRepository;
  private final MovieRepository movieRepository;

  private RentalService() {
    this.rentalRepository = JsonRentalRepository.getInstance();
    this.movieRepository = JsonMovieRepository.getInstance();
  }

  public static RentalService getInstance() {
    if (instance == null) {
      instance = new RentalService();
    }
    return instance;
  }

  public void addRental(Rental rental) {
    rentalRepository.saveRental(rental);
  }

  public void showDetailsByCustomer(Customer customer) {
    System.out.println("Rental record for: " + customer.getName());

    rentalRepository.getAllRentalsByCustomerId(customer.getId()).forEach(rental -> {
      double rentalAmount = calculateRentalAmount(rental);
      System.out.println("\t" + movieRepository.getMovieById(rental.getMovieId()).getTitle() + "\t" + rentalAmount);
    });

    System.out.println("Amount owed is: " + calculateTotalRentalAmount(customer));
    System.out.println("You earn: " + calculateTotalRentalPoints(customer) + " frequent renter points");
  }

  public double calculateTotalRentalAmount(Customer customer) {

    return rentalRepository.getAllRentalsByCustomerId(customer.getId())
        .stream()
        .mapToDouble(this::calculateRentalAmount)
        .sum();
  }

  public double calculateRentalAmount(Rental rental) {
    return movieRepository.getMovieById(rental.getMovieId()).calculateAmount(rental.getDaysRented());
  }

  public int calculateTotalRentalPoints(Customer customer) {
    return rentalRepository.getAllRentalsByCustomerId(customer.getId())
        .stream()
        .mapToInt(this::calculateRentalPoints)
        .sum();
  }

  public int calculateRentalPoints(Rental rental) {
    return movieRepository.getMovieById(rental.getMovieId()).calculateFrequentRenterPoints(rental.getDaysRented());
  }
}
