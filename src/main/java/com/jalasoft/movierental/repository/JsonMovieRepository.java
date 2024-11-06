package com.jalasoft.movierental.repository;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jalasoft.movierental.entity.movies.Movie;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author Deyvis Mamani L.
 */
public class JsonMovieRepository implements MovieRepository{

  private static JsonMovieRepository instance;
  private ObjectMapper mapper;
  private static final String FILE_PATH = "data/movies.json";
  private final File file;
  private List<Movie> movies;

  private JsonMovieRepository() {
    this.mapper = new ObjectMapper();
    this.file = new File(FILE_PATH);

    this.movies = readMovies();
  }

  public static JsonMovieRepository getInstance() {
    if (instance == null) {
      instance = new JsonMovieRepository();
    }
    return instance;
  }

  @Override
  public Movie saveMovie(Movie movie) {
    movies.stream().filter(movieI -> movieI.getTitle().equals(movie.getTitle())).findFirst().ifPresent(m -> {
      throw new RuntimeException("Movie already exists");
    });

    movies.add(movie);
    writeMovies();
    return movie;
  }

  @Override
  public Movie getMovieById(UUID id) {
    return movies.stream()
        .filter(movie -> movie.getId().equals(id))
        .findFirst()
        .orElseThrow();
  }

  @Override
  public List<Movie> getAllMovies() {
    return movies;
  }

  private List<Movie> readMovies() {
    if (!file.exists()) {
      return new ArrayList<>();
    }

    try {
      return mapper.readValue(file, new TypeReference<List<Movie>>() {});

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private void writeMovies() {
    try {
      mapper.writerFor(new TypeReference<List<Movie>>() {})
          .withDefaultPrettyPrinter()
          .writeValue(file, this.movies);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
