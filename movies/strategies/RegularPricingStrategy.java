package movies.movies.strategies;

/**
 * @author Deyvis Mamani L.
 * @created 03/11/2024
 */
public class RegularPricingStrategy implements PricingStrategy {
  @Override
  public double calculateAmount(int daysRented) {
    double amount = 2;
    if (daysRented > 2) {
      amount += (daysRented - 2) * 1.5;
    }
    return amount;
  }
}
