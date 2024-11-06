package com.jalasoft.movierental.entity.movies.strategies;

/**
 * @author Deyvis Mamani L.
 */
public class RegularPointsStrategy implements PointsStrategy {
  private int BASE_POINTS = 0;

  @Override
  public int calculateFrequentRenterPoints(int daysRented) {
    return BASE_POINTS;
  }
}
