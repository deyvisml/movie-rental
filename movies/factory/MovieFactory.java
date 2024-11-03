package movies.movies.factory;

import movies.movies.MovieType;
import movies.movies.ChildrenMovie;
import movies.movies.Movie;
import movies.movies.NewReleaseMovie;
import movies.movies.RegularMovie;

/**
 * @author Deyvis Mamani L.
 * @created 03/11/2024
 */
public class MovieFactory {
  public static Movie createMovie(MovieType type, String title) {
    return switch (type) {
      case NEW_RELEASE -> new NewReleaseMovie(title);
      case REGULAR -> new RegularMovie(title);
      case CHILDREN -> new ChildrenMovie(title);
    };
  }
}
