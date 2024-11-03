package movies.movies.strategies;

/**
 * @author Deyvis Mamani L.
 * @created 03/11/2024
 */
public class NewReleasePricingStrategy implements PricingStrategy {
  @Override
  public double calculateAmount(int daysRented) {
    return daysRented * 3;
  }
}
