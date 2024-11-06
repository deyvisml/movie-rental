package com.jalasoft.movierental.entity;

import java.util.UUID;

public class Rental {
  private UUID id;
  private UUID customerId;
  private UUID movieId;
  private int daysRented;

  public Rental() {
  }

  public Rental(UUID customerId, UUID movieId, int daysRented) {
    this.id = UUID.randomUUID();
    this.customerId = customerId;
    this.movieId = movieId;
    this.daysRented = daysRented;
  }

  public UUID getMovieId() {
    return movieId;
  }

  public UUID getCustomerId() {
    return this.customerId;
  }

  public int getDaysRented() {
    return daysRented;
  }

  public void setDaysRented(int daysRented) {
    this.daysRented = daysRented;
  }
}