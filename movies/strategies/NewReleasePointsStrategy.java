package movies.movies.strategies;

/**
 * @author Deyvis Mamani L.
 */
public class NewReleasePointsStrategy implements PointsStrategy {
  @Override
  public int calculateFrequentRenterPoints(int daysRented) {
    return daysRented > 1 ? 2 : 1;
  }
}
