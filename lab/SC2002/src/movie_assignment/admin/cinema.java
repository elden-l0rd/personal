package movie_assignment.admin;

public class cinema {
    private static final int numCinemaHall = 10;
    private static final int totalMovies = 15;
    private movie[] movieCata; //movie catalogue

    public cinema() {
        movieCata = new movie[15];
        for (int i=0; i<15; i++) {
            movieCata[i] = new movie(0); // WIP
        }
    }

    //methods
    //sort timings in chrono order
    private void sortTimings(int[] arr) {
        //insertion sort
        for (int i=1; i<5; i++) {
            for (int j=i; j>0; j--) {
                if (arr[j] < arr[j-1]) {
                    arr[j-1] = arr[j-1]^arr[j]^(arr[j]=arr[j-1]);
                }
                else break;
             }
        }
    }

    //show NOW SHOWING movies

    //edit movie listing

    //search for a movie in array of movie objects
    private int searchMovie(String name) {
        for (int i=0; i<totalMovies; i++) {
            if (movieCata[i].getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1; //if movie is not found
    }

}
