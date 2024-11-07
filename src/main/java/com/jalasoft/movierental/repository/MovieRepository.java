package com.jalasoft.movierental.repository;

import com.jalasoft.movierental.entity.movies.Movie;
import java.util.List;
import java.util.UUID;

/**
 * Repository interface for managing Movie entities.
 * Provides methods for saving, retrieving, and listing movies.
 *
 * Author: Deyvis Mamani L.
 */
public interface MovieRepository {

  /**
   * Saves the given movie to the repository.
   *
   * @param movie the movie to save
   * @return the saved movie
   */
  Movie saveMovie(Movie movie);

  /**
   * Retrieves a movie by its unique identifier.
   *
   * @param id the unique identifier of the movie
   * @return the movie with the specified identifier, or null if not found
   */
  Movie getMovieById(UUID id);

  /**
   * Retrieves all movies from the repository.
   *
   * @return a list of all movies
   */
  List<Movie> getAllMovies();
}