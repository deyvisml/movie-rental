package com.jalasoft.movierental.entity.movies.strategies;

/**
 * Strategy for calculating the rental amount for new release movies.
 * This strategy applies a factor to the number of days rented to calculate the total amount.
 *
 * Author: Deyvis Mamani L.
 */
public class NewReleasePricingStrategy implements PricingStrategy {
  private int FACTOR_FOR_EXTRA_DAYS = 3;

  /**
   * Calculates the rental amount for a new release movie.
   *
   * @param daysRented the number of days the movie was rented
   * @return the rental amount
   */
  @Override
  public double calculateAmount(int daysRented) {
    return daysRented * FACTOR_FOR_EXTRA_DAYS;
  }
}