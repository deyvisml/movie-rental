package com.jalasoft.movierental.entity;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a rental transaction.
 * This class contains information about a rental, including the customer, movie, and rental duration.
 *
 * Author: Deyvis Mamani L.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rental {
  private UUID id; // Unique identifier for the rental
  private UUID customerId; // Unique identifier for the customer
  private UUID movieId; // Unique identifier for the movie
  private int daysRented; // Number of days the movie is rented

  /**
   * Constructs a Rental instance with the specified customer ID, movie ID, and rental duration.
   * Initializes the rental with a unique identifier.
   *
   * @param customerId the unique identifier of the customer
   * @param movieId the unique identifier of the movie
   * @param daysRented the number of days the movie is rented
   */
  public Rental(UUID customerId, UUID movieId, int daysRented) {
    this.id = UUID.randomUUID();
    this.customerId = customerId;
    this.movieId = movieId;
    this.daysRented = daysRented;
  }
}