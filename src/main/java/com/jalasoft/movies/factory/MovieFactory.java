package com.jalasoft.movies.factory;


import com.jalasoft.movies.ChildrenMovie;
import com.jalasoft.movies.Movie;
import com.jalasoft.movies.MovieType;
import com.jalasoft.movies.NewReleaseMovie;
import com.jalasoft.movies.RegularMovie;

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
