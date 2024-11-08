package com.jalasoft.movierental.repository;

import java.util.List;
import java.util.UUID;

/**
 * Generic repository interface for managing entities.
 * Provides methods for saving, retrieving by ID, and listing all entities.
 *
 * @param <T> the type of the entity
 *
 * Author: Deyvis Mamani L.
 */
public interface Repository<T> {

  /**
   * Saves an entity to the repository.
   *
   * @param entity the entity to save
   * @return the saved entity
   */
  T save(T entity);

  /**
   * Retrieves an entity by its unique identifier.
   *
   * @param id the unique identifier of the entity
   * @return the entity with the specified identifier
   */
  T findById(UUID id);

  /**
   * Retrieves all entities from the repository.
   *
   * @return a list of all entities
   */
  List<T> findAll();
}