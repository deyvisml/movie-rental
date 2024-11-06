package com.jalasoft.movierental.entity.movies.strategies;

/**
 * @author Deyvis Mamani L.
 */
public class NewReleasePointsStrategy implements PointsStrategy {
  private int MAX_DAYS_FOR_BASE_POINTS = 1;
  private int POINTS_FOR_EXTRA_DAYS = 2;
  private int POINTS_FOR_BASE_DAYS = 1;

  @Override
  public int calculateFrequentRenterPoints(int daysRented) {
    return daysRented > MAX_DAYS_FOR_BASE_POINTS ? POINTS_FOR_EXTRA_DAYS : POINTS_FOR_BASE_DAYS;
  }
}
