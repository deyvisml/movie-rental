package com.jalasoft.movierental.factory;

import com.jalasoft.movierental.entity.movies.ChildrenMovie;
import com.jalasoft.movierental.entity.movies.Movie;
import com.jalasoft.movierental.entity.movies.MovieType;
import com.jalasoft.movierental.entity.movies.NewReleaseMovie;
import com.jalasoft.movierental.entity.movies.RegularMovie;
import com.jalasoft.movierental.exception.custom.ResourceBadRequestException;

/**
 * Factory class for creating Movie instances based on the movie type.
 * This class provides a method to create different types of movies.
 *
 * Author: Deyvis Mamani L.
 */
public class MovieFactory {

  /**
   * Creates a Movie instance based on the specified movie type and title.
   *
   * @param type the type of the movie (NEW_RELEASE, REGULAR, CHILDREN)
   * @param title the title of the movie
   * @return a Movie instance of the specified type
   * @throws ResourceBadRequestException if the movie type is invalid
   */
  public static Movie createMovie(MovieType type, String title) {
    return switch (type) {
      case NEW_RELEASE -> new NewReleaseMovie(title);
      case REGULAR -> new RegularMovie(title);
      case CHILDREN -> new ChildrenMovie(title);
      default -> throw new ResourceBadRequestException("Invalid movie type");
    };
  }
}