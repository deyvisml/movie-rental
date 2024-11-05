package com.jalasoft.movies.strategies;

import com.jalasoft.movies.strategies.PointsStrategy;

/**
 * @author Deyvis Mamani L.
 */
public class ChildrenPointsStrategy implements PointsStrategy {
  @Override
  public int calculateFrequentRenterPoints(int daysRented) {
    return 1;
  }
}
