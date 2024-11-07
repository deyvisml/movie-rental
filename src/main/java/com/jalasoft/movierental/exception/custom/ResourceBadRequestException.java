package com.jalasoft.movierental.exception.custom;

/**
 * Custom exception class for handling bad request errors.
 * This exception is thrown when there is an issue with the request parameters.
 *
 * Author: Deyvis Mamani L.
 */
public class ResourceBadRequestException extends RuntimeException {
  private String error;            // Predefined error message, e.g., "Bad Request"
  private String customMessage;    // Specific message like "Invalid parameters"

  /**
   * Constructs a ResourceBadRequestException with the specified detail message.
   * Initializes the error with a predefined message and sets the custom message.
   *
   * @param message the detail message
   */
  public ResourceBadRequestException(String message) {
    super(message);
    this.error = "Bad Request";  // Predefined error message
    this.customMessage = message;
  }
}