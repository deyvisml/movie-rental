package com.jalasoft.movies.strategies;

/**
 * @author Deyvis Mamani L.
 */
public class NewReleasePricingStrategy implements PricingStrategy {
  @Override
  public double calculateAmount(int daysRented) {
    return daysRented * 3;
  }
}
