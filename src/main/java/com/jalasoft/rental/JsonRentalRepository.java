package com.jalasoft.rental;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Deyvis Mamani L.
 */
public class JsonRentalRepository implements RentalRepository {

  private static JsonRentalRepository instance;

  private static final String FILE_PATH = "data/rentals.json";
  private final ObjectMapper mapper;

  private JsonRentalRepository() {
    this.mapper = new ObjectMapper();
  }

  public static JsonRentalRepository getInstance() {
    if (instance == null) {
      instance = new JsonRentalRepository();
    }
    return instance;
  }

  @Override
  public void saveRentals(Map<String, List<Rental>> rentals) throws IOException {
      mapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH), rentals);
  }

  @Override
  public Map<String, List<Rental>> loadRentals() throws IOException {
    File file = new File(FILE_PATH);
    if (!file.exists()) {
      return new HashMap<>();
    }
    return mapper.readValue(file, new TypeReference<Map<String, List<Rental>>>() {});
  }
}
