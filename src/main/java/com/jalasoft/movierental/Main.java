package com.jalasoft.movierental;

import com.jalasoft.movierental.entity.Customer;
import com.jalasoft.movierental.entity.movies.MovieType;
import com.jalasoft.movierental.exception.handler.CustomExceptionHandler;
import com.jalasoft.movierental.service.CustomerService;
import com.jalasoft.movierental.service.MovieService;
import com.jalasoft.movierental.service.RentalService;
import com.jalasoft.movierental.factory.MovieFactory;
import com.jalasoft.movierental.entity.Rental;
import java.util.UUID;

/**
 * @author Deyvis Mamani L.
 */
public class Main {

  public static void main(String[] args) {
    try {
      // add customer
      CustomerService customerService = CustomerService.getInstance();
      Customer customer = customerService.addCustomer(new Customer("Deyvis"));

      // add movies to the catalog
      MovieService movieService = MovieService.getInstance();
      movieService.addMovie(MovieFactory.createMovie(MovieType.NEW_RELEASE, "Zack Snyder's Justice League"));
      movieService.addMovie(MovieFactory.createMovie(MovieType.REGULAR, "Terminator"));
      movieService.addMovie(MovieFactory.createMovie(MovieType.CHILDREN, "Soul"));

      // rental movies
      RentalService rentalService = RentalService.getInstance();
      rentalService.addRental(new Rental(customer.getId(), UUID.fromString("c0ef0faf-034f-4b4f-bd0f-bd9734b821df"), 5));
      rentalService.addRental(new Rental(customer.getId(), UUID.fromString("4d506af1-93eb-4c4a-9843-3bdb491e5a29"), 1));
      rentalService.addRental(new Rental(customer.getId(), UUID.fromString("c363f2aa-b862-4c5f-8c0d-546f01b743c5"), 3));

      Customer customer1 = customerService.getCustomerById(UUID.fromString("46843f51-34f0-4c1e-b733-f07ee17c0efd"));
      rentalService.showDetailsByCustomer(customer1);
    } catch (Exception e) {
      CustomExceptionHandler.handleException(e);
    }
  }
}