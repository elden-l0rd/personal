package moblima;

import java.util.ArrayList;
import java.util.Collections;

public class SortTop5 {
	
    public static ArrayList<Movie> sortByScore(ArrayList<Movie> givenMovies) {
        ArrayList<Movie> movies = new ArrayList<Movie>(givenMovies);

        ///bubble sort
        Collections.sort(movies, new SortbyScore());
        Collections.reverse(movies);

        return movies;
    }

    public static ArrayList<Movie> sortBySale(ArrayList<Movie> givenMovies) {

        ArrayList<Movie> movies = new ArrayList<Movie>(givenMovies);

        ///bubble sort
        Collections.sort(movies, new SortbySales());
        Collections.reverse(movies);

        return movies;

    }
}