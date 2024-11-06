package com.jalasoft.movierental.repository;

import com.jalasoft.movierental.entity.movies.Movie;
import java.util.List;
import java.util.UUID;

/**
 * @author Deyvis Mamani L.
 */
public interface MovieRepository {
  Movie saveMovie(Movie movie);
  Movie getMovieById(UUID id);
  List<Movie> getAllMovies();
}
