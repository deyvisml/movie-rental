package com.jalasoft.movierental.exception.custom;

/**
 * @author Deyvis Mamani L.
 */
public class ResourceBadRequestException extends RuntimeException {
  private String error;            // e.g. "Bad Request"
  private String customMessage;    // Specific message like "Invalid parameters"

  public ResourceBadRequestException(String message) {
    super(message);
    this.error = "Bad Request";  // Predefine error
    this.customMessage = message;
  }
}
