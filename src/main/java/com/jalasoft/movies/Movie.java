package com.jalasoft.movies;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.jalasoft.movies.strategies.PointsStrategy;
import com.jalasoft.movies.strategies.PricingStrategy;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = ChildrenMovie.class, name = "children"),
    @JsonSubTypes.Type(value = RegularMovie.class, name = "regular"),
    @JsonSubTypes.Type(value = NewReleaseMovie.class, name = "new_release")
})
public abstract class Movie {
    private final String title;
    private final PricingStrategy pricingStrategy;
    private final PointsStrategy pointsStrategy;

    public Movie(String title, PricingStrategy pricingStrategy, PointsStrategy pointsStrategy) {
        this.title = title;
        this.pricingStrategy = pricingStrategy;
        this.pointsStrategy = pointsStrategy;
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
