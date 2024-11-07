package com.jalasoft.movierental.entity.movies;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.jalasoft.movierental.entity.movies.strategies.PointsStrategy;
import com.jalasoft.movierental.entity.movies.strategies.PricingStrategy;
import java.util.UUID;
import lombok.Data;

@Data
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    property = "type"
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = ChildrenMovie.class, name = "CHILDREN"),
    @JsonSubTypes.Type(value = RegularMovie.class, name = "REGULAR"),
    @JsonSubTypes.Type(value = NewReleaseMovie.class, name = "NEW_RELEASE")
})
public abstract class Movie {
    private final UUID id;
    private final String title;
    private final PricingStrategy pricingStrategy;
    private final PointsStrategy pointsStrategy;

    /**
     * Constructs a Movie instance with the specified title, pricing strategy, and points strategy.
     * Initializes the movie with a unique identifier.
     *
     * @param title the title of the movie
     * @param pricingStrategy the strategy to calculate the rental amount
     * @param pointsStrategy the strategy to calculate frequent renter points
     */
    public Movie(String title, PricingStrategy pricingStrategy, PointsStrategy pointsStrategy) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.pricingStrategy = pricingStrategy;
        this.pointsStrategy = pointsStrategy;
    }

    /**
     * Calculates the rental amount based on the number of days the movie was rented.
     *
     * @param daysRented the number of days the movie was rented
     * @return the rental amount
     */
    public double calculateAmount(int daysRented) {
        return pricingStrategy.calculateAmount(daysRented);
    }

    /**
     * Calculates the frequent renter points based on the number of days the movie was rented.
     *
     * @param daysRented the number of days the movie was rented
     * @return the frequent renter points
     */
    public int calculateFrequentRenterPoints(int daysRented) {
        return pointsStrategy.calculateFrequentRenterPoints(daysRented);
    }
}