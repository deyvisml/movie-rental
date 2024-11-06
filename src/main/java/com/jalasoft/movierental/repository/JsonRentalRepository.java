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
 * @author Deyvis Mamani L.
 */
public class JsonRentalRepository implements RentalRepository {

  private static JsonRentalRepository instance;
  private final ObjectMapper mapper;
  private static final String FILE_PATH = "data/rentals.json";
  private final File file;
  private final List<Rental> rentals;

  private JsonRentalRepository() {
    this.mapper = new ObjectMapper();
    this.file = new File(FILE_PATH);

    this.rentals = readRentals();
  }

  public static JsonRentalRepository getInstance() {
    if (instance == null) {
      instance = new JsonRentalRepository();
    }
    return instance;
  }

  @Override
  public void saveRental(Rental rental) {
    rentals.add(rental);
    writeRentals();
  }

  @Override
  public List<Rental> getAllRentalsByCustomerId(UUID customerId) {
    return rentals.stream()
        .filter(rental -> rental.getCustomerId().equals(customerId))
        .toList();
  }

  @Override
  public List<Rental> getAllRentals() {
    return rentals;
  }

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

  public void writeRentals() {
    try {
      mapper.writerWithDefaultPrettyPrinter().writeValue(file, rentals);
    } catch (IOException e) {
      throw new FileAccessException("Error writing rentals", e);
    }
  }
}
