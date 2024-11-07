package com.jalasoft.movierental.entity.movies.strategies;

/**
 * Strategy for calculating the rental amount for children's movies.
 * This strategy applies a base amount for the first few days and an additional amount for extra days.
 *
 * Author: Deyvis Mamani L.
 */
public class ChildrenPricingStrategy implements PricingStrategy {
  private double BASE_AMOUNT = 1.5;
  private final int MAX_DAYS_FOR_BASE_AMOUNT = 3;
  private final double FACTOR_FOR_EXTRA_DAYS = 1.5;

  /**
   * Calculates the rental amount for a children's movie.
   *
   * @param daysRented the number of days the movie was rented
   * @return the rental amount
   */
  @Override
  public double calculateAmount(int daysRented) {
    if (daysRented > MAX_DAYS_FOR_BASE_AMOUNT) {
      BASE_AMOUNT += (daysRented - MAX_DAYS_FOR_BASE_AMOUNT) * FACTOR_FOR_EXTRA_DAYS;
    }
    return BASE_AMOUNT;
  }
}