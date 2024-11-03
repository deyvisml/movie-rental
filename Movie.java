package movies;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type") // Ahora usa el campo `type` como String
@JsonSubTypes({
    @JsonSubTypes.Type(value = ChildrenMovie.class, name = "children"),
    @JsonSubTypes.Type(value = RegularMovie.class, name = "regular"),
    @JsonSubTypes.Type(value = NewReleaseMovie.class, name = "new_release")
})
abstract class Movie {
    private String title;

    public Movie() {
    }

    public Movie(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public abstract double calculateAmount(int daysRented);
    public abstract int calculateFrequentRenterPoints(int daysRented);
}
