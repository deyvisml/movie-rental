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
 * The MenuController class manages the user interface for the movie rental system.
 * It follows the Singleton design pattern to ensure only one instance exists.
 * It provides methods to display the menu and handle user input for various operations.
 *
 * Author: Deyvis Mamani L.
 */
public class MenuController {

  private static MenuController instance;
  private final CustomerService customerService;
  private final MovieService movieService;
  private final RentalService rentalService;
  private final Scanner scanner;

  /**
   * Private constructor to prevent instantiation.
   * Initializes the services and scanner.
   */
  private MenuController() {
    this.customerService = CustomerService.getInstance();
    this.movieService = MovieService.getInstance();
    this.rentalService = RentalService.getInstance();
    this.scanner = new Scanner(System.in);
  }

  /**
   * Returns the singleton instance of MenuController.
   * Creates a new instance if it does not exist.
   *
   * @return the singleton instance of MenuController
   */
  public static MenuController getInstance() {
    if (instance == null) {
      instance = new MenuController();
    }
    return instance;
  }

  /**
   * Displays the menu and processes user input.
   * The menu remains active until the user chooses to exit.
   */
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
        System.out.println("Press Enter to continue...");
        scanner.nextLine();
      } catch (Exception e) {
        CustomExceptionHandler.handleException(e);
      }
    }
    scanner.close();
  }

  /**
   * Prompts the user to enter a customer name and adds the customer.
   */
  private void addCustomer() {
    System.out.print("Enter customer name: ");
    String name = scanner.nextLine();
    Customer customer = new Customer(name);
    customerService.addCustomer(customer);
    System.out.println("Customer added successfully.");
  }

  /**
   * Prompts the user to enter movie details and adds the movie.
   */
  private void addMovie() {
    System.out.print("Enter movie type (NEW_RELEASE, REGULAR, CHILDREN): ");
    MovieType type = MovieType.valueOf(scanner.nextLine().toUpperCase());
    System.out.print("Enter movie title: ");
    String title = scanner.nextLine();
    Movie movie = MovieFactory.createMovie(type, title);
    movieService.addMovie(movie);
    System.out.println("Movie added successfully.");
  }

  /**
   * Prompts the user to enter rental details and adds the rental.
   */
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

  /**
   * Displays all customer rentals.
   */
  private void showAllCustomerRentals() {
    rentalService.showAllCustomerRentals();
  }

  /**
   * Prompts the user to enter a customer ID and displays rentals for that customer.
   */
  private void showCustomerRentalsByCustomerId() {
    System.out.print("Enter customer ID: ");
    UUID customerId = UUID.fromString(scanner.nextLine());
    rentalService.showDetailsByCustomerId(customerId);
  }
}