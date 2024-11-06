package com.jalasoft.movierental.entity.movies.strategies;

/**
 * @author Deyvis Mamani L.
 */
public class RegularPricingStrategy implements PricingStrategy {
  private double BASE_AMOUNT = 2;
  private final int MAX_DAYS_FOR_BASE_AMOUNT = 2;
  private final double FACTOR_FOR_EXTRA_DAYS = 1.5;

  @Override
  public double calculateAmount(int daysRented) {
    if (daysRented > MAX_DAYS_FOR_BASE_AMOUNT) {
      BASE_AMOUNT += (daysRented - MAX_DAYS_FOR_BASE_AMOUNT) * FACTOR_FOR_EXTRA_DAYS;
    }
    return BASE_AMOUNT;
  }
}
