package movies.movies.strategies;

/**
 * @author Deyvis Mamani L.
 */
public class ChildrenPricingStrategy implements PricingStrategy {
  @Override
  public double calculateAmount(int daysRented) {
    double amount = 1.5;
    if (daysRented > 3) {
      amount += (daysRented - 3) * 1.5;
    }
    return amount;
  }
}
