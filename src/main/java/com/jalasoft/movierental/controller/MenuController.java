package com.jalasoft.movierental.controller;

import com.jalasoft.movierental.entity.Customer;
import com.jalasoft.movierental.entity.Rental;
import com.jalasoft.movierental.entity.movies.Movie;
import com.jalasoft.movierental.entity.movies.MovieType;
import com.jalasoft.movierental.exception.handler.CustomExceptionHandler;
import com.jalasoft.movierental.factory.MovieFactory;
import com.jalasoft.movierental.service.CustomerService;
import com.jalasoft.movierental.service.MovieService;
import com.jalasoft.movierental.service.RentalService;
import java.util.Scanner;
import java.util.UUID;

/**
 * @author Deyvis Mamani L.
 */
public class MenuController {

  private static MenuController instance;
  private final CustomerService customerService;
  private final MovieService movieService;
  private final RentalService rentalService;
  private final Scanner scanner;

  private MenuController() {
    this.customerService = CustomerService.getInstance();
    this.movieService = MovieService.getInstance();
    this.rentalService = RentalService.getInstance();
    this.scanner = new Scanner(System.in);
  }

  public static MenuController getInstance() {
    if (instance == null) {
      instance = new MenuController();
    }
    return instance;
  }

  public void displayMenu() {
    boolean exit = false;

    while (!exit) {
      try {
        System.out.println("\n=== Movie Rental System ===");
        System.out.println("1. Add Customer");
        System.out.println("2. Add Movie");
        System.out.println("3. Add Rental");
        System.out.println("4. Show All Customer Rentals");
        System.out.println("5. Show Customer Rentals by Customer ID");
        System.out.println("6. Exit");
        System.out.print("Choose an option: ");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
          case 1:
            addCustomer();
            break;
          case 2:
            addMovie();
            break;
          case 3:
            addRental();
            break;
          case 4:
            showAllCustomerRentals();
            break;
          case 5:
            showCustomerRentalsByCustomerId();
            break;
          case 6:
            exit = true;
            System.out.println("Exiting...");
            break;
          default:
            System.out.println("Invalid choice. Please try again.");
        }
      } catch (Exception e) {
        CustomExceptionHandler.handleException(e);
      }
    }
    scanner.close();
  }

  private void addCustomer() {
    System.out.print("Enter customer name: ");
    String name = scanner.nextLine();
    Customer customer = new Customer(name);
    customerService.addCustomer(customer);
    System.out.println("Customer added successfully.");
  }

  private void addMovie() {
    System.out.print("Enter movie type (NEW_RELEASE, REGULAR, CHILDREN): ");
    MovieType type = MovieType.valueOf(scanner.nextLine().toUpperCase());
    System.out.print("Enter movie title: ");
    String title = scanner.nextLine();
    Movie movie = MovieFactory.createMovie(type, title);
    movieService.addMovie(movie);
    System.out.println("Movie added successfully.");
  }

  private void addRental() {
    System.out.print("Enter customer ID: ");
    UUID customerId = UUID.fromString(scanner.nextLine());
    System.out.print("Enter movie ID: ");
    UUID movieId = UUID.fromString(scanner.nextLine());
    System.out.print("Enter days rented: ");
    int daysRented = Integer.parseInt(scanner.nextLine());
    rentalService.addRental(new Rental(customerId, movieId, daysRented));
    System.out.println("Rental added successfully.");
  }

  private void showAllCustomerRentals() {
    rentalService.showAllCustomerRentals();
  }

  private void showCustomerRentalsByCustomerId() {
    System.out.print("Enter customer ID: ");
    UUID customerId = UUID.fromString(scanner.nextLine());
    rentalService.showDetailsByCustomerId(customerId);
  }
}
