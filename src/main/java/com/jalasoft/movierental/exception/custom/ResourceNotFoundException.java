package com.jalasoft.movierental.exception.custom;

/**
 * @author Deyvis Mamani L.
 */
public class ResourceNotFoundException extends RuntimeException {
  private String error;            // e.g. "Not Found"
  private String customMessage;    // Specific message like "Resource not found"

  public ResourceNotFoundException(String message) {
    super(message);
    this.error = "Not Found";  // Predefine error
    this.customMessage = message;
  }
}
