package movies;

import java.io.IOException;
import movies.customer.Customer;
import movies.movies.Movie;
import movies.movies.MovieType;
import movies.movies.factory.MovieFactory;
import movies.rental.Rental;
import movies.rental.RentalManagement;

public class Main {
    public static void main(String[] args) throws IOException {
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
