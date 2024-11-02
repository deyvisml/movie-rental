package movies;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Deyvis");

        RentalManagement rentalManagement = new RentalManagement();

        rentalManagement.addRental(customer, new Rental(new NewReleaseMovie("Zack Snyder's Justice League"), 5));
        rentalManagement.addRental(customer, new Rental(new RegularMovie("Terminator"), 1));
        rentalManagement.addRental(customer, new Rental(new ChildrenMovie("Soul"), 3));

        rentalManagement.showDetailsByCustomer(customer);
    }
}
