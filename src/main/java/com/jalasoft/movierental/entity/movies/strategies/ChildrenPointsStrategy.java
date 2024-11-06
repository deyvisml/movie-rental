package com.jalasoft.movierental.entity.movies.strategies;

/**
 * @author Deyvis Mamani L.
 */
public class ChildrenPointsStrategy implements PointsStrategy {
  private final int CHILDREN_POINTS = 1;
  
  @Override
  public int calculateFrequentRenterPoints(int daysRented) {
    return CHILDREN_POINTS;
  }
}
