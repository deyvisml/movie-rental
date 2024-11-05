package com.jalasoft.rental;

import com.jalasoft.customer.Customer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Deyvis Mamani L.
 */
public class RentalManagement {

  private static RentalManagement instance;

  private Map<String, List<Rental>> rentals;
  private final RentalRepository rentalRepository;

  private RentalManagement() {
    this.rentalRepository = JsonRentalRepository.getInstance();
    this.rentals = new HashMap<>();
    try {
      rentals.putAll(rentalRepository.loadRentals());
    } catch (IOException e) {
      System.out.println("Error al cargar las rentas: " + e.getMessage());
    }
  }

  public static RentalManagement getInstance() {
    if (instance == null) {
      instance = new RentalManagement();
    }
    return instance;
  }

  public void addRental(Customer customer, Rental rental) {
    rentals.computeIfAbsent(customer.getName(), k -> new ArrayList<>()).add(rental);
    try {
      rentalRepository.saveRentals(rentals);
    } catch (IOException e) {
      System.out.println("Error al guardar la renta: " + e.getMessage());
    }
  }

  public void showDetailsByCustomer(Customer customer) {
    System.out.println("Rental record for: " + customer.getName());
    rentals.get(customer.getName()).forEach(rental -> {
      double rentalAmount = calculateRentalAmount(rental);
      System.out.println("\t" + rental.getMovie().getTitle() + "\t" + rentalAmount);
    });

    System.out.println("Amount owed is: " + calculateTotalRentalAmount(customer));
    System.out.println("You earn: " + calculateTotalRentalPoints(customer) + " frequent renter points");
  }

  public double calculateTotalRentalAmount(Customer customer) {
    return rentals
        .get(customer.getName())
        .stream()
        .mapToDouble(this::calculateRentalAmount)
        .sum();
  }

  public double calculateRentalAmount(Rental rental) {
    return rental.getMovie().calculateAmount(rental.getDaysRented());
  }

  public int calculateTotalRentalPoints(Customer customer) {
    return rentals
        .get(customer.getName())
        .stream()
        .mapToInt(this::calculateRentalPoints)
        .sum();
  }

  public int calculateRentalPoints(Rental rental) {
    return rental.getMovie().calculateFrequentRenterPoints(rental.getDaysRented());
  }
}
