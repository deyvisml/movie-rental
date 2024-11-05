package com.jalasoft.rental;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author Deyvis Mamani L.
 */
public interface RentalRepository {
  void saveRentals(Map<String, List<Rental>> rentals) throws IOException;
  Map<String, List<Rental>> loadRentals() throws IOException;
}
