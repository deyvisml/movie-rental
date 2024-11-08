package com.jalasoft.movierental.service;

import com.jalasoft.movierental.entity.movies.Movie;
import com.jalasoft.movierental.entity.movies.MovieType;
import com.jalasoft.movierental.factory.MovieFactory;
import com.jalasoft.movierental.repository.Repository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class MovieServiceTest {

  private AutoCloseable closeable;

  private MovieService movieService;

  @Mock
  private Repository<Movie> movieRepository;

  @BeforeEach
  void setUp() throws Exception {
    closeable = MockitoAnnotations.openMocks(this);

    // Get the singleton instance of MovieService
    movieService = MovieService.getInstance();

    // Use reflection to inject the mock into the singleton
    setMock(movieService, "movieRepository", movieRepository);
  }

  @AfterEach
  void tearDown() throws Exception {
    resetSingleton();
    closeable.close();
  }

  @Test
  void addMovie_WhenCalledWithValidMovie_ShouldReturnAddedMovie() {
    // Arrange
    Movie movie = MovieFactory.createMovie(MovieType.NEW_RELEASE, "Inception");
    when(movieRepository.save(movie)).thenReturn(movie);

    // Act
    Movie addedMovie = movieService.addMovie(movie);

    // Assert
    assertNotNull(addedMovie);
    assertEquals("Inception", addedMovie.getTitle());
    verify(movieRepository, times(1)).save(movie);
  }

  @Test
  void getMovieById_WhenCalledWithValidId_ShouldReturnMovie() {
    // Arrange
    UUID movieId = UUID.randomUUID();
    Movie movie = MovieFactory.createMovie(MovieType.REGULAR, "Interstellar");
    when(movieRepository.findById(movieId)).thenReturn(movie);

    // Act
    Movie retrievedMovie = movieService.getMovieById(movieId);

    // Assert
    assertNotNull(retrievedMovie);
    assertEquals("Interstellar", retrievedMovie.getTitle());
    verify(movieRepository, times(1)).findById(movieId);
  }

  @Test
  void getAllMovies_WhenCalled_ShouldReturnListOfAllMovies() {
    // Arrange
    Movie movie1 = MovieFactory.createMovie(MovieType.REGULAR, "The Matrix");
    Movie movie2 = MovieFactory.createMovie(MovieType.CHILDREN, "Avatar");
    List<Movie> movies = Arrays.asList(movie1, movie2);
    when(movieRepository.findAll()).thenReturn(movies);

    // Act
    List<Movie> allMovies = movieService.getAllMovies();

    // Assert
    assertNotNull(allMovies);
    assertEquals(2, allMovies.size());
    verify(movieRepository, times(1)).findAll();
  }

  private void setMock(Object instance, String fieldName, Object mock) throws Exception {
    Field field = instance.getClass().getDeclaredField(fieldName);
    field.setAccessible(true);
    field.set(instance, mock);
  }

  private void resetSingleton() throws Exception {
    Field instance = MovieService.class.getDeclaredField("instance");
    instance.setAccessible(true);
    instance.set(null, null);
  }
}
