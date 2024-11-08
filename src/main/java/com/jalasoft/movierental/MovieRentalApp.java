package com.jalasoft.movierental;

import com.jalasoft.movierental.controller.MenuController;

/**
 * Main application class for the Movie Rental application.
 * Provides the entry point for the application and manages the MenuController.
 *
 * Author: Deyvis Mamani L.
 */
public class MovieRentalApp {

  private static MovieRentalApp instance;
  private final MenuController menuController;

  /**
   * Constructor to initialize the MovieRentalApp.
   * Initializes the MenuController instance.
   */
  public MovieRentalApp() {
    this.menuController = MenuController.getInstance();
  }

  /**
   * Returns the singleton instance of MovieRentalApp.
   *
   * @return the singleton instance
   */
  public static MovieRentalApp getInstance() {
    if (instance == null) {
      instance = new MovieRentalApp();
    }
    return instance;
  }

  /**
   * Runs the application by displaying the menu.
   */
  public void run() {
      menuController.displayMenu();
  }
}