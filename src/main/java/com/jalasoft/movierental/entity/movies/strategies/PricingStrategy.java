package com.jalasoft.movierental.entity.movies.strategies;

/**
 * @author Deyvis Mamani L.
 */
public interface PricingStrategy {
  double calculateAmount(int daysRented);
}
