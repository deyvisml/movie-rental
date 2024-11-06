package com.jalasoft.movierental.entity.movies;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jalasoft.movierental.entity.movies.strategies.RegularPointsStrategy;
import com.jalasoft.movierental.entity.movies.strategies.RegularPricingStrategy;

/**
 * @author Deyvis Mamani L.
 */
public class RegularMovie extends Movie {

  @JsonCreator
  public RegularMovie(@JsonProperty("title") String title) {
    super(title, new RegularPricingStrategy(), new RegularPointsStrategy());
  }
}
