package com.jalasoft.movierental.entity.movies.strategies;

/**
 * Interface for defining the strategy to calculate frequent renter points.
 * Implementations of this interface will provide specific strategies for different movie types.
 *
 * Author: Deyvis Mamani L.
 */
public interface PointsStrategy {
  /**
   * Calculates the frequent renter points based on the number of days the movie was rented.
   *
   * @param daysRented the number of days the movie was rented
   * @return the frequent renter points
   */
  int calculateFrequentRenterPoints(int daysRented);
}