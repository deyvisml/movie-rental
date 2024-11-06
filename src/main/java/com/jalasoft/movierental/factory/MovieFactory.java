package com.jalasoft.movierental.factory;

import com.jalasoft.movierental.entity.movies.ChildrenMovie;
import com.jalasoft.movierental.entity.movies.Movie;
import com.jalasoft.movierental.entity.movies.MovieType;
import com.jalasoft.movierental.entity.movies.NewReleaseMovie;
import com.jalasoft.movierental.entity.movies.RegularMovie;
import com.jalasoft.movierental.exception.custom.ResourceBadRequestException;

/**
 * @author Deyvis Mamani L.
 */
public class MovieFactory {
  public static Movie createMovie(MovieType type, String title) {
    return switch (type) {
      case NEW_RELEASE -> new NewReleaseMovie(title);
      case REGULAR -> new RegularMovie(title);
      case CHILDREN -> new ChildrenMovie(title);
      default -> throw new ResourceBadRequestException("Invalid movie type");
    };
  }
}
