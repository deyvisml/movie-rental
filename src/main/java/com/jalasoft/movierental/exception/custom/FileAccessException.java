package com.jalasoft.movierental.exception.custom;

/**
 * @author Deyvis Mamani L.
 */
public class FileAccessException extends RuntimeException {
  private String error;            // e.g. "Internal Server Error"
  private String customMessage;    // Specific message like "File not found"

  public FileAccessException(String message, Throwable cause) {
    super(message, cause);
    this.error = "Internal Server Error";  // Predefine error
    this.customMessage = message;
  }
}
