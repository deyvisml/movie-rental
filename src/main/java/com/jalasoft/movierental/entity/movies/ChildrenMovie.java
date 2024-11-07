package com.jalasoft.movierental.entity.movies;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jalasoft.movierental.entity.movies.strategies.ChildrenPointsStrategy;
import com.jalasoft.movierental.entity.movies.strategies.ChildrenPricingStrategy;

/**
 * Represents a children's movie.
 * This class extends the Movie class and uses specific pricing and points strategies for children's movies.
 *
 * Author: Deyvis Mamani L.
 */
public class ChildrenMovie extends Movie {

  /**
   * Constructs a ChildrenMovie instance with the specified title.
   * Initializes the movie with ChildrenPricingStrategy and ChildrenPointsStrategy.
   *
   * @param title the title of the movie
   */
  @JsonCreator
  public ChildrenMovie(@JsonProperty("title") String title) {
    super(title, new ChildrenPricingStrategy(), new ChildrenPointsStrategy());
  }
}