package com.jalasoft.movierental.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jalasoft.movierental.entity.movies.Movie;
import com.jalasoft.movierental.exception.custom.FileAccessException;
import com.jalasoft.movierental.exception.custom.ResourceNotFoundException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Repository implementation for managing Movie entities using JSON files.
 * Provides methods for saving, retrieving, and listing movies.
 *
 * Author: Deyvis Mamani L.
 */
public class JsonMovieRepository implements MovieRepository {

  private static JsonMovieRepository instance;
  private final ObjectMapper mapper;
  private static final String FILE_PATH = "data/movies.json";
  private final File file;
  private final List<Movie> movies;

  /**
   * Private constructor to initialize the repository.
   * Reads the movies from the JSON file.
   */
  private JsonMovieRepository() {
    this.mapper = new ObjectMapper();
    this.file = new File(FILE_PATH);
    this.movies = readMovies();
  }

  /**
   * Returns the singleton instance of JsonMovieRepository.
   *
   * @return the singleton instance
   */
  public static JsonMovieRepository getInstance() {
    if (instance == null) {
      instance = new JsonMovieRepository();
    }
    return instance;
  }

  /**
   * Saves the given movie to the repository.
   *
   * @param movie the movie to save
   * @return the saved movie
   */
  @Override
  public Movie saveMovie(Movie movie) {
    movies.add(movie);
    writeMovies();
    return movie;
  }

  /**
   * Retrieves a movie by its unique identifier.
   *
   * @param id the unique identifier of the movie
   * @return the movie with the specified identifier
   * @throws ResourceNotFoundException if the movie is not found
   */
  @Override
  public Movie getMovieById(UUID id) {
    return movies.stream()
        .filter(movie -> movie.getId().equals(id))
        .findFirst()
        .orElseThrow(() -> new ResourceNotFoundException("Movie with id " + id + " not found"));
  }

  /**
   * Retrieves all movies from the repository.
   *
   * @return a list of all movies
   */
  @Override
  public List<Movie> getAllMovies() {
    return movies;
  }

  /**
   * Reads the movies from the JSON file.
   *
   * @return a list of movies
   * @throws FileAccessException if there is an error reading the file
   */
  private List<Movie> readMovies() {
    if (!file.exists()) {
      return new ArrayList<>();
    }

    try {
      return mapper.readValue(file, new TypeReference<List<Movie>>() {});
    } catch (IOException e) {
      throw new FileAccessException("Error reading movies", e);
    }
  }

  /**
   * Writes the movies to the JSON file.
   *
   * @throws FileAccessException if there is an error writing the file
   */
  private void writeMovies() {
    try {
      mapper.writerFor(new TypeReference<List<Movie>>() {})
          .withDefaultPrettyPrinter()
          .writeValue(file, this.movies);
    } catch (IOException e) {
      throw new FileAccessException("Error writing movies", e);
    }
  }
}