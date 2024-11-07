package com.jalasoft.movierental.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jalasoft.movierental.entity.Rental;
import com.jalasoft.movierental.exception.custom.FileAccessException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Repository implementation for managing Rental entities using JSON files.
 * Provides methods for saving, retrieving, and listing rentals.
 *
 * Author: Deyvis Mamani L.
 */
public class JsonRentalRepository implements RentalRepository {

  private static JsonRentalRepository instance;
  private final ObjectMapper mapper;
  private static final String FILE_PATH = "data/rentals.json";
  private final File file;
  private final List<Rental> rentals;

  /**
   * Private constructor to initialize the repository.
   * Reads the rentals from the JSON file.
   */
  private JsonRentalRepository() {
    this.mapper = new ObjectMapper();
    this.file = new File(FILE_PATH);
    this.rentals = readRentals();
  }

  /**
   * Returns the singleton instance of JsonRentalRepository.
   *
   * @return the singleton instance
   */
  public static JsonRentalRepository getInstance() {
    if (instance == null) {
      instance = new JsonRentalRepository();
    }
    return instance;
  }

  /**
   * Saves the given rental to the repository.
   *
   * @param rental the rental to save
   */
  @Override
  public void saveRental(Rental rental) {
    rentals.add(rental);
    writeRentals();
  }

  /**
   * Retrieves all rentals for a specific customer by their unique identifier.
   *
   * @param customerId the unique identifier of the customer
   * @return a list of rentals for the specified customer
   */
  @Override
  public List<Rental> getAllRentalsByCustomerId(UUID customerId) {
    return rentals.stream()
        .filter(rental -> rental.getCustomerId().equals(customerId))
        .toList();
  }

  /**
   * Retrieves all rentals from the repository.
   *
   * @return a list of all rentals
   */
  @Override
  public List<Rental> getAllRentals() {
    return rentals;
  }

  /**
   * Reads the rentals from the JSON file.
   *
   * @return a list of rentals
   * @throws FileAccessException if there is an error reading the file
   */
  public List<Rental> readRentals()  {
    if (!file.exists()) {
      return new ArrayList<Rental>();
    }

    try {
      return mapper.readValue(file, new TypeReference<List<Rental>>() {});
    } catch (IOException e) {
      throw new FileAccessException("Error reading rentals", e);
    }
  }

  /**
   * Writes the rentals to the JSON file.
   *
   * @throws FileAccessException if there is an error writing the file
   */
  public void writeRentals() {
    try {
      mapper.writerWithDefaultPrettyPrinter().writeValue(file, rentals);
    } catch (IOException e) {
      throw new FileAccessException("Error writing rentals", e);
    }
  }
}