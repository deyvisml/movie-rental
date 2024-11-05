package com.jalasoft.movies.strategies;

/**
 * @author Deyvis Mamani L.
 */
public class RegularPointsStrategy implements PointsStrategy {
  @Override
  public int calculateFrequentRenterPoints(int daysRented) {
    return 1;
  }
}
