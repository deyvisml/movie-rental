package com.jalasoft.movierental.entity.movies.strategies;

/**
 * @author Deyvis Mamani L.
 */
public class ChildrenPointsStrategy implements PointsStrategy {
  @Override
  public int calculateFrequentRenterPoints(int daysRented) {
    return 1;
  }
}