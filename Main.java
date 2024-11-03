package movies;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Customer customer = new Customer("Deyvis");

        RentalRepository repository = new JsonRentalRepository();
        RentalManagement rentalManagement = new RentalManagement(repository);

        rentalManagement.addRental(customer, new Rental(new NewReleaseMovie("Zack Snyder's Justice League"), 5));
        rentalManagement.addRental(customer, new Rental(new RegularMovie("Terminator"), 1));
        rentalManagement.addRental(customer, new Rental(new ChildrenMovie("Soul"), 3));

        rentalManagement.showDetailsByCustomer(customer);
    }
}
