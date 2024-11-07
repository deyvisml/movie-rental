package com.jalasoft.movierental.entity.movies.strategies;

/**
 * Interface for defining the strategy to calculate the rental amount.
 * Implementations of this interface will provide specific strategies for different movie types.
 *
 * Author: Deyvis Mamani L.
 */
public interface PricingStrategy {
  /**
   * Calculates the rental amount based on the number of days the movie was rented.
   *
   * @param daysRented the number of days the movie was rented
   * @return the rental amount
   */
  double calculateAmount(int daysRented);
}