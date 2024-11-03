package movies.movies;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import movies.movies.strategies.ChildrenPointsStrategy;
import movies.movies.strategies.ChildrenPricingStrategy;

/**
 * @author Deyvis Mamani L.
 */
public class ChildrenMovie extends Movie {

  @JsonCreator
  public ChildrenMovie(@JsonProperty("title") String title) {
    super(title, new ChildrenPricingStrategy(), new ChildrenPointsStrategy());
  }
}
