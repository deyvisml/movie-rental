package com.jalasoft.movierental.entity.movies.strategies;

/**
 * @author Deyvis Mamani L.
 */
public class NewReleasePricingStrategy implements PricingStrategy {
  private int FACTOR_FOR_EXTRA_DAYS = 3;

  @Override
  public double calculateAmount(int daysRented) {
    return daysRented * FACTOR_FOR_EXTRA_DAYS;
  }
}
