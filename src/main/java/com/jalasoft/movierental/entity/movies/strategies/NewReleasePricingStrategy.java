package com.jalasoft.movierental.entity.movies.strategies;

/**
 * @author Deyvis Mamani L.
 */
public class NewReleasePricingStrategy implements PricingStrategy {
  @Override
  public double calculateAmount(int daysRented) {
    return daysRented * 3;
  }
}
