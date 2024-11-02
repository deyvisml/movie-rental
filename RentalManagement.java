package movies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Deyvis Mamani L.
 * @created 02/11/2024
 */
public class RentalManagement {

  private Map<Customer, List<Rental>> rentals;

  public RentalManagement() {
    this.rentals = new HashMap<>();
  }

  public void addRental(Customer customer, Rental rental) {
    if (!rentals.containsKey(customer)) {
      rentals.put(customer, new ArrayList<>());
    }
    rentals.get(customer).add(rental);
  }

  public void showDetailsByCustomer(Customer customer) {
    System.out.println("Rental record for: " + customer.name());
    rentals.get(customer).forEach(rental -> {
      double rentalAmount = calculateRentalAmount(rental);
      System.out.println("\t" + rental.movie().getTitle() + "\t" + rentalAmount);
    });

    System.out.println("Amount owed is: " + calculateTotalRentalAmount(customer));
    System.out.println("You earn: " + calculateTotalRentalPoints(customer) + " frequent renter points");
  }

  public double calculateTotalRentalAmount(Customer customer) {
    return rentals
        .get(customer)
        .stream()
        .mapToDouble(this::calculateRentalAmount)
        .sum();
  }

  public double calculateRentalAmount(Rental rental) {
    return rental.movie().calculateAmount(rental.daysRented());
  }

  public int calculateTotalRentalPoints(Customer customer) {
    return rentals
        .get(customer)
        .stream()
        .mapToInt(this::calculateRentalPoints)
        .sum();
  }

  public int calculateRentalPoints(Rental rental) {
    return rental.movie().calculateFrequentRenterPoints(rental.daysRented());
  }
}
