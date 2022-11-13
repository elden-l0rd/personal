package moblima;

import java.util.Comparator;

public class SortbySales implements Comparator<Movie> {
    public int compare(Movie a, Movie b) {
        if (a.getSalesNumber() < b.getSalesNumber()) return -1;
        if (a.getSalesNumber() > b.getSalesNumber()) return 1;
        return 0;
    }
}
