package com.jalasoft.movierental.entity.movies.strategies;

/**
 * @author Deyvis Mamani L.
 */
public class RegularPricingStrategy implements PricingStrategy {
  @Override
  public double calculateAmount(int daysRented) {
    double amount = 2;
    if (daysRented > 2) {
      amount += (daysRented - 2) * 1.5;
    }
    return amount;
  }
}
