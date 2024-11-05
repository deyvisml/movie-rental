package com.jalasoft.movies;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jalasoft.movies.strategies.ChildrenPointsStrategy;
import com.jalasoft.movies.strategies.ChildrenPricingStrategy;

/**
 * @author Deyvis Mamani L.
 */
public class ChildrenMovie extends Movie {

  @JsonCreator
  public ChildrenMovie(@JsonProperty("title") String title) {
    super(title, new ChildrenPricingStrategy(), new ChildrenPointsStrategy());
  }
}
