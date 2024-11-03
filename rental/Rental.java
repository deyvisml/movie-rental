package movies.rental;

import movies.movies.Movie;

public class Rental {

  private Movie movie;
  private int daysRented;

  public Rental() {
  }

  public Rental( Movie movie, int daysRented) {
    this.movie = movie;
    this.daysRented = daysRented;
  }

  public Movie getMovie() {
    return movie;
  }

  public int getDaysRented() {
    return daysRented;
  }

  public void setMovie(Movie movie) {
    this.movie = movie;
  }

  public void setDaysRented(int daysRented) {
    this.daysRented = daysRented;
  }
}