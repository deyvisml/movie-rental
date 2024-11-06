package com.jalasoft.movierental.service;

import com.jalasoft.movierental.entity.movies.Movie;
import com.jalasoft.movierental.repository.JsonMovieRepository;
import com.jalasoft.movierental.repository.MovieRepository;
import java.util.List;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Deyvis Mamani L.
 */
public class MovieService {

  private static MovieService instance;
  private static final Logger logger = LoggerFactory.getLogger(MovieService.class);
  private final MovieRepository movieRepository;

  private MovieService() {
    this.movieRepository = JsonMovieRepository.getInstance();
  }

  public static MovieService getInstance() {
    if (instance == null) {
      instance = new MovieService();
    }
    return instance;
  }

  public Movie addMovie(Movie movie) {
    logger.info("Adding movie: {}", movie);
    return movieRepository.saveMovie(movie);
  }

  public Movie getMovieById(UUID id) {
    logger.info("Getting movie by id: {}", id);
    return movieRepository.getMovieById(id);
  }

  public List<Movie> getAllMovies() {
    logger.info("Getting all movies");
    return movieRepository.getAllMovies();
  }
}
