package com.jalasoft.movierental.exception.handler;

import com.jalasoft.movierental.exception.custom.FileAccessException;
import com.jalasoft.movierental.exception.custom.ResourceBadRequestException;
import com.jalasoft.movierental.exception.custom.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Deyvis Mamani L.
 */
public class CustomExceptionHandler {

  private static final Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

  public static void handleException(Exception e) {
    if (e instanceof ResourceNotFoundException) {
      logger.error("Not found error: {}", e.getMessage(), e);
    } else if (e instanceof ResourceBadRequestException) {
      logger.warn("Bad request error: {}", e.getMessage(), e);
    } else if (e instanceof FileAccessException) {
      logger.error("File access error: {}", e.getMessage(), e);
    } else {
      logger.error("An unexpected error occurred: {}", e.getMessage(), e);
    }
  }
}
