package movies.movies;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import movies.movies.strategies.RegularPointsStrategy;
import movies.movies.strategies.RegularPricingStrategy;

/**
 * @author Deyvis Mamani L.
 */
public class RegularMovie extends Movie {

  @JsonCreator
  public RegularMovie(@JsonProperty("title") String title) {
    super(title, new RegularPricingStrategy(), new RegularPointsStrategy());
  }
}
