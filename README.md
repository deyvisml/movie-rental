# Movie Rental

A simple Movie Rental System built with Java 17. This application allows users to browse, rent, and return the details of their rents. Data is persisted using a JSON file, enabling users to retrieve their rental history even after restarting the application.

## Features

- Browse a catalog of movies.
- Rent and return movies.
- Persistent storage of data in JSON format.
- The code follows the principles of **Clean Code** like meaningful names and small methods.
- The code also follows the **SOLID** principles like:
  - Single Responsibility
  - Open/Closed Principle
  - and Dependency Inversion (json).
- It was also include some **Design Patterns** like:
  - Singleton (management)
  - Factory (movie)
  - and Strategy (movie strategies).

## Requirements

- **Java 17** or higher

## How to Run

1. Clone this repository:
   ```bash
   git clone https://github.com/deyvisml/movie-rental.git
   ```
2. Navigate to the project directory:
   ```bash
   cd movie-rental
3. Run the project with your IDE.