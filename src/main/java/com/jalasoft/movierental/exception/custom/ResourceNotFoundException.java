package com.jalasoft.movierental.exception.custom;

/**
 * Custom exception class for handling resource not found errors.
 * This exception is thrown when a requested resource is not found.
 *
 * Author: Deyvis Mamani L.
 */
public class ResourceNotFoundException extends RuntimeException {
  private String error;            // Predefined error message, e.g., "Not Found"
  private String customMessage;    // Specific message like "Resource not found"

  /**
   * Constructs a ResourceNotFoundException with the specified detail message.
   * Initializes the error with a predefined message and sets the custom message.
   *
   * @param message the detail message
   */
  public ResourceNotFoundException(String message) {
    super(message);
    this.error = "Not Found";  // Predefined error message
    this.customMessage = message;
  }
}