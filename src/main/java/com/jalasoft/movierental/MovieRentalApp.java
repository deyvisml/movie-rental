package com.jalasoft.movierental;

import com.jalasoft.movierental.controller.MenuController;

/**
 * @author Deyvis Mamani L.
 */
public class MovieRentalApp {

  private static MovieRentalApp instance;
  private final MenuController menuController;

  public MovieRentalApp() {
    this.menuController = MenuController.getInstance();
  }

  public static MovieRentalApp getInstance() {
    if (instance == null) {
      instance = new MovieRentalApp();
    }
    return instance;
  }

  public void run() {
      menuController.displayMenu();
  }
}
