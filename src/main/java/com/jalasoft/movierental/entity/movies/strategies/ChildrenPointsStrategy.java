package com.jalasoft.movierental.entity.movies.strategies;

/**
 * Strategy for calculating frequent renter points for children's movies.
 * This strategy awards a fixed number of points regardless of the rental duration.
 *
 * Author: Deyvis Mamani L.
 */
public class ChildrenPointsStrategy implements PointsStrategy {

  private final int CHILDREN_POINTS = 1;

  /**
   * Calculates the frequent renter points for a children's movie.
   *
   * @param daysRented the number of days the movie was rented
   * @return the frequent renter points
   */
  @Override
  public int calculateFrequentRenterPoints(int daysRented) {
    return CHILDREN_POINTS;
  }
}