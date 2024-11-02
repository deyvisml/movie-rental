package movies;

/**
 * @author Deyvis Mamani L.
 */
public class RegularMovie extends Movie{

  public RegularMovie(String title) {
    super(title);
  }

  @Override
  public double calculateAmount(int daysRented) {
    double amount = 2;
    if (daysRented > 2) {
      amount += (daysRented - 2) * 1.5;
    }

    return amount;
  }

  @Override
  public int calculateFrequentRenterPoints(int daysRented) {
    return 0;
  }
}
