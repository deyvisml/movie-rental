package movies.movies.strategies;

/**
 * @author Deyvis Mamani L.
 * @created 03/11/2024
 */
public class ChildrenPointsStrategy implements PointsStrategy {
  @Override
  public int calculateFrequentRenterPoints(int daysRented) {
    return 1;
  }
}
