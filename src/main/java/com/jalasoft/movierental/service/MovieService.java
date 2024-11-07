package com.jalasoft.movierental.service;

import com.jalasoft.movierental.entity.movies.Movie;
import com.jalasoft.movierental.repository.JsonMovieRepository;
import com.jalasoft.movierental.repository.MovieRepository;
import java.util.List;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Service class for managing Movie entities.
 * Provides methods for adding, retrieving, and listing movies.
 *
 * Author: Deyvis Mamani L.
 */
public class MovieService {

  private static MovieService instance;
  private static final Logger logger = LoggerFactory.getLogger(MovieService.class);
  private final MovieRepository movieRepository;

  /**
   * Private constructor to initialize the service.
   * Uses JsonMovieRepository as the repository implementation.
   */
  private MovieService() {
    this.movieRepository = JsonMovieRepository.getInstance();
  }

  /**
   * Returns the singleton instance of MovieService.
   *
   * @return the singleton instance
   */
  public static MovieService getInstance() {
    if (instance == null) {
      instance = new MovieService();
    }
    return instance;
  }

  /**
   * Adds a new movie to the repository.
   *
   * @param movie the movie to add
   * @return the added movie
   */
  public Movie addMovie(Movie movie) {
    logger.info("Adding movie: {}", movie);
    return movieRepository.saveMovie(movie);
  }

  /**
   * Retrieves a movie by its unique identifier.
   *
   * @param id the unique identifier of the movie
   * @return the movie with the specified identifier
   */
  public Movie getMovieById(UUID id) {
    logger.info("Getting movie by id: {}", id);
    return movieRepository.getMovieById(id);
  }

  /**
   * Retrieves all movies from the repository.
   *
   * @return a list of all movies
   */
  public List<Movie> getAllMovies() {
    logger.info("Getting all movies");
    return movieRepository.getAllMovies();
  }
}