package com.jalasoft.movierental.entity.movies;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jalasoft.movierental.entity.movies.strategies.ChildrenPointsStrategy;
import com.jalasoft.movierental.entity.movies.strategies.ChildrenPricingStrategy;

/**
 * @author Deyvis Mamani L.
 */
public class ChildrenMovie extends Movie {

  @JsonCreator
  public ChildrenMovie(@JsonProperty("title") String title) {
    super(title, new ChildrenPricingStrategy(), new ChildrenPointsStrategy());
  }
}
