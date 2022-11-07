package moblima;

import java.util.Comparator;

public class SortbyScore implements Comparator<Movie> {
    public int compare(Movie a, Movie b) {
        if (a.getOverallRating() < b.getOverallRating()) return -1;
        if (a.getOverallRating() > b.getOverallRating()) return 1;
        return 0;
    }
}
