package com.jalasoft.movierental.exception.custom;

/**
 * Custom exception class for handling file access errors.
 * This exception is thrown when there is an issue accessing a file.
 *
 * Author: Deyvis Mamani L.
 */
public class FileAccessException extends RuntimeException {
  private String error;            // Predefined error message, e.g., "Internal Server Error"
  private String customMessage;    // Specific message like "File not found"

  /**
   * Constructs a FileAccessException with the specified detail message and cause.
   * Initializes the error with a predefined message and sets the custom message.
   *
   * @param message the detail message
   * @param cause the cause of the exception
   */
  public FileAccessException(String message, Throwable cause) {
    super(message, cause);
    this.error = "Internal Server Error";  // Predefined error message
    this.customMessage = message;
  }
}