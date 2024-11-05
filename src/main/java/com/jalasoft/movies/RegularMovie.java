package com.jalasoft.movies;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jalasoft.movies.strategies.RegularPointsStrategy;
import com.jalasoft.movies.strategies.RegularPricingStrategy;

/**
 * @author Deyvis Mamani L.
 */
public class RegularMovie extends Movie {

  @JsonCreator
  public RegularMovie(@JsonProperty("title") String title) {
    super(title, new RegularPricingStrategy(), new RegularPointsStrategy());
  }
}
