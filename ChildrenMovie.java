package movies;

/**
 * @author Deyvis Mamani L.
 */
public class ChildrenMovie extends Movie{

  public ChildrenMovie(String title) {
    super(title);
  }

  @Override
  public double calculateAmount(int daysRented) {
    double amount = 1.5;
    if(daysRented > 3) {
      amount += (daysRented - 3) * 1.5;
    }
    return amount;
  }

  @Override
  public int calculateFrequentRenterPoints(int daysRented) {
    return 1;
  }
}
