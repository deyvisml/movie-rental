package com.jalasoft.movies.strategies;

import com.jalasoft.movies.strategies.PointsStrategy;

/**
 * @author Deyvis Mamani L.
 */
public class NewReleasePointsStrategy implements PointsStrategy {
  @Override
  public int calculateFrequentRenterPoints(int daysRented) {
    return daysRented > 1 ? 2 : 1;
  }
}
