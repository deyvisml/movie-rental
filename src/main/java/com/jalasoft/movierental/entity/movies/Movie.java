package com.jalasoft.movierental.entity.movies;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.jalasoft.movierental.entity.movies.strategies.PointsStrategy;
import com.jalasoft.movierental.entity.movies.strategies.PricingStrategy;
import java.util.UUID;

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

    public Movie(String title, PricingStrategy pricingStrategy, PointsStrategy pointsStrategy) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.pricingStrategy = pricingStrategy;
        this.pointsStrategy = pointsStrategy;
    }

    public UUID getId() {
        return this.id;
    }

    public String getTitle() {
        return title;
    }

    public  double calculateAmount(int daysRented) {
        return pricingStrategy.calculateAmount(daysRented);
    }

    public  int calculateFrequentRenterPoints(int daysRented) {
        return pointsStrategy.calculateFrequentRenterPoints(daysRented);
    }
}
