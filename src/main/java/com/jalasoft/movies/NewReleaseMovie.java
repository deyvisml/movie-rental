package com.jalasoft.movies;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jalasoft.movies.strategies.NewReleasePointsStrategy;
import com.jalasoft.movies.strategies.NewReleasePricingStrategy;

/**
 * @author Deyvis Mamani L.
 */
public class NewReleaseMovie extends Movie {

  @JsonCreator
  public NewReleaseMovie(@JsonProperty("title") String title) {
    super(title, new NewReleasePricingStrategy(), new NewReleasePointsStrategy());
  }
}
