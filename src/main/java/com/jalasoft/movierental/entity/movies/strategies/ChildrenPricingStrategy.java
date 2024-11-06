package com.jalasoft.movierental.entity.movies.strategies;

/**
 * @author Deyvis Mamani L.
 */
public class ChildrenPricingStrategy implements PricingStrategy {
  private double BASE_AMOUNT = 1.5;
  private final int MAX_DAYS_FOR_BASE_AMOUNT = 3;
  private final double FACTOR_FOR_EXTRA_DAYS = 1.5;

  @Override
  public double calculateAmount(int daysRented) {
    if (daysRented > MAX_DAYS_FOR_BASE_AMOUNT) {
      BASE_AMOUNT += (daysRented - MAX_DAYS_FOR_BASE_AMOUNT) * FACTOR_FOR_EXTRA_DAYS;
    }
    return BASE_AMOUNT;
  }
}
