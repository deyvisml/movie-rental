package com.jalasoft;

import com.jalasoft.customer.Customer;
import com.jalasoft.movies.Movie;
import com.jalasoft.movies.MovieType;
import com.jalasoft.movies.factory.MovieFactory;
import com.jalasoft.rental.Rental;
import com.jalasoft.rental.RentalManagement;

/**
 * @author Deyvis Mamani L.
 */
public class Main {

  public static void main(String[] args) {
    Customer customer = new Customer("Deyvis");

    RentalManagement rentalManagement = RentalManagement.getInstance();

    Movie movie1 = MovieFactory.createMovie(MovieType.NEW_RELEASE, "Zack Snyder's Justice League");
    Movie movie2 = MovieFactory.createMovie(MovieType.REGULAR, "Terminator");
    Movie movie3 = MovieFactory.createMovie(MovieType.CHILDREN, "Soul");

    rentalManagement.addRental(customer, new Rental(movie1, 5));
    rentalManagement.addRental(customer, new Rental(movie2, 1));
    rentalManagement.addRental(customer, new Rental(movie3, 3));

    rentalManagement.showDetailsByCustomer(customer);
  }
}