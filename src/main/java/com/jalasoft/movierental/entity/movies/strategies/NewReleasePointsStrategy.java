package com.jalasoft.movierental.entity.movies.strategies;

/**
 * Strategy for calculating frequent renter points for new release movies.
 * This strategy awards a higher number of points if the rental duration exceeds a certain threshold.
 *
 * Author: Deyvis Mamani L.
 */
public class NewReleasePointsStrategy implements PointsStrategy {
  private int MAX_DAYS_FOR_BASE_POINTS = 1;
  private int POINTS_FOR_EXTRA_DAYS = 2;
  private int POINTS_FOR_BASE_DAYS = 1;

  /**
   * Calculates the frequent renter points for a new release movie.
   *
   * @param daysRented the number of days the movie was rented
   * @return the frequent renter points
   */
  @Override
  public int calculateFrequentRenterPoints(int daysRented) {
    return daysRented > MAX_DAYS_FOR_BASE_POINTS ? POINTS_FOR_EXTRA_DAYS : POINTS_FOR_BASE_DAYS;
  }
}