package com.jalasoft.movierental.entity.movies;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jalasoft.movierental.entity.movies.strategies.RegularPointsStrategy;
import com.jalasoft.movierental.entity.movies.strategies.RegularPricingStrategy;

/**
 * Represents a regular movie.
 * This class extends the Movie class and uses specific pricing and points strategies for regular movies.
 *
 * Author: Deyvis Mamani L.
 */
public class RegularMovie extends Movie {

  /**
   * Constructs a RegularMovie instance with the specified title.
   * Initializes the movie with RegularPricingStrategy and RegularPointsStrategy.
   *
   * @param title the title of the movie
   */
  @JsonCreator
  public RegularMovie(@JsonProperty("title") String title) {
    super(title, new RegularPricingStrategy(), new RegularPointsStrategy());
  }
}