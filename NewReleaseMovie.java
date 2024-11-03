package movies;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Deyvis Mamani L.
 */
public class NewReleaseMovie extends Movie{

  public NewReleaseMovie() {

  }

  public NewReleaseMovie( String title) {
    super(title);
  }

  @Override
  public double calculateAmount(int daysRented) {
    return daysRented * 3;
  }

  @Override
  public int calculateFrequentRenterPoints(int daysRented) {
    int frequentRenterPoints = 1;
    if (daysRented > 1) {
      frequentRenterPoints++;
    }
    return frequentRenterPoints;
  }
}
