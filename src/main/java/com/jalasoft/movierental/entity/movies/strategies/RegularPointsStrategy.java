package com.jalasoft.movierental.entity.movies.strategies;

/**
 * Strategy for calculating frequent renter points for regular movies.
 * This strategy currently awards a base number of points regardless of the rental duration.
 *
 * Author: Deyvis Mamani L.
 */
public class RegularPointsStrategy implements PointsStrategy {
  private int BASE_POINTS = 0;

  /**
   * Calculates the frequent renter points for a regular movie.
   *
   * @param daysRented the number of days the movie was rented
   * @return the frequent renter points
   */
  @Override
  public int calculateFrequentRenterPoints(int daysRented) {
    return BASE_POINTS;
  }
}