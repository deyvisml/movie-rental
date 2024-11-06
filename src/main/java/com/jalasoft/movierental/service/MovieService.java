package com.jalasoft.movierental.service;

import com.jalasoft.movierental.entity.movies.Movie;
import com.jalasoft.movierental.repository.JsonMovieRepository;
import com.jalasoft.movierental.repository.MovieRepository;
import java.util.List;
import java.util.UUID;

/**
 * @author Deyvis Mamani L.
 */
public class MovieService {

  private static MovieService instance;
  private MovieRepository movieRepository;

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
    return movieRepository.saveMovie(movie);
  }

  public Movie getMovieById(UUID id) {
    return movieRepository.getMovieById(id);
  }

  public List<Movie> getAllMovies() {
    return movieRepository.getAllMovies();
  }
}
