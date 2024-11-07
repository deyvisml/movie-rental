package com.jalasoft.movierental.repository;

import com.jalasoft.movierental.entity.Rental;
import java.util.List;
import java.util.UUID;

/**
 * Repository interface for managing Rental entities.
 * Provides methods for saving, retrieving, and listing rentals.
 *
 * Author: Deyvis Mamani L.
 */
public interface RentalRepository {

  /**
   * Saves the given rental to the repository.
   *
   * @param rental the rental to save
   */
  void saveRental(Rental rental);

  /**
   * Retrieves all rentals for a specific customer by their unique identifier.
   *
   * @param uuid the unique identifier of the customer
   * @return a list of rentals for the specified customer
   */
  List<Rental> getAllRentalsByCustomerId(UUID uuid);

  /**
   * Retrieves all rentals from the repository.
   *
   * @return a list of all rentals
   */
  List<Rental> getAllRentals();
}