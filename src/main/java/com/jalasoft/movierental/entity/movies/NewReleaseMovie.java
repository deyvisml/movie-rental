package com.jalasoft.movierental.entity.movies;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jalasoft.movierental.entity.movies.strategies.NewReleasePointsStrategy;
import com.jalasoft.movierental.entity.movies.strategies.NewReleasePricingStrategy;

/**
 * Represents a new release movie.
 * This class extends the Movie class and uses specific pricing and points strategies for new release movies.
 *
 * Author: Deyvis Mamani L.
 */
public class NewReleaseMovie extends Movie {

  /**
   * Constructs a NewReleaseMovie instance with the specified title.
   * Initializes the movie with NewReleasePricingStrategy and NewReleasePointsStrategy.
   *
   * @param title the title of the movie
   */
  @JsonCreator
  public NewReleaseMovie(@JsonProperty("title") String title) {
    super(title, new NewReleasePricingStrategy(), new NewReleasePointsStrategy());
  }
}