package movies;

import java.util.List;

/**
 * @author Deyvis Mamani L.
 */
public class CustomerRentals {
  private Customer customer;
  private List<Rental> rentals;

  public CustomerRentals() {
  }

  public CustomerRentals(Customer customer, List<Rental> rentals) {
    this.customer = customer;
    this.rentals = rentals;
  }

  public Customer getCustomer() {
    return customer;
  }

  public List<Rental> getRentals() {
    return rentals;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public void setRentals(List<Rental> rentals) {
    this.rentals = rentals;
  }

  public String getCustomerName() {
    return customer.getName();
  }
}
