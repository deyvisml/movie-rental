package movies.movies.strategies;

/**
 * @author Deyvis Mamani L.
 * @created 03/11/2024
 */
public class RegularPointsStrategy implements PointsStrategy {
  @Override
  public int calculateFrequentRenterPoints(int daysRented) {
    return 1;
  }
}
