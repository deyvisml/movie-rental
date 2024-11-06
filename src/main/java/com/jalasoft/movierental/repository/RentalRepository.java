package com.jalasoft.movierental.repository;

import com.jalasoft.movierental.entity.Rental;
import java.util.List;
import java.util.UUID;

/**
 * @author Deyvis Mamani L.
 */
public interface RentalRepository {
  void saveRental(Rental rental);
  List<Rental> getAllRentalsByCustomerId(UUID uuid);
  List<Rental> getAllRentals();
}
