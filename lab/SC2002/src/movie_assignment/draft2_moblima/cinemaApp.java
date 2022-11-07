package moblima;
import java.util.*;

public class cinemaApp {
    private static final int numCinemaHall = 10;
    private static final int totalMovies = 15;
    private Movie[] movieCata; //movie catalogue

    public cinemaApp() {
        movieCata = new Movie[15];
        for (int i=0; i<15; i++) {
            movieCata[i] = new Movie(null,null,null,null,0,0,0,0); // WIP
        }
    }

    //methods
    //timings for each movie
    public void sortTimings(int[] arr) {
        ///////// WIP (implementation) /////////
        for (int i=1; i<5; i++) {
            for (int j=i; j>0; j--) {
                if (arr[j] < arr[j-1]) {
                    arr[j-1] = arr[j-1]^arr[j]^(arr[j]=arr[j-1]);
                }
                else break;
             }
        }
    }

    public void sortRatings() { 
        ///////// WIP (implementation) /////////
        Movie[] tmp = new Movie[16]; //tmp[15] is intermediary
        for (int i=0; i<totalMovies; i++) {
            tmp[i] = movieCata[i];
        }

        for (int i=1; i<totalMovies; i++) {
            for (int j=i; j>0; j--) {
                if (tmp[j].getRatings() < tmp[j-1].getRatings()) {
                    tmp[15] = tmp[j-1];
                    tmp[j-1]=tmp[j];
                    tmp[j]=tmp[15];
                }
            }
        }
        movieCata=tmp;
    }

    //print movies
    public void showMovies(int a) {
        boolean check=false;
        if (a==1) {
            System.out.println("In PREVIEW:");
            for (int i=0; i<totalMovies; i++) {
                if (movieCata[i].getStatus()==1 || movieCata[i].getStatus()==2) {
                    check=true;
                    System.out.println(movieCata[i].getName());
                }
            }
            if (!check) {
                System.out.println("No movies are in preview.");
            }
        }
        else if (a==2) {
            System.out.println("NOW SHOWING:");
            for (int i=0; i<totalMovies; i++) {
                if (movieCata[i].getStatus()==2) {
                    check=true;
                    System.out.println(movieCata[i].getName());
                }
            }
            if (!check) {
                System.out.println("No movies are showing in cinemas.");
            }
        }
        else { //a==3
            System.out.println("COMING SOON:");
            for (int i=0; i<totalMovies; i++) {
                if (movieCata[i].getStatus()==3) {
                    check=true;
                    System.out.println(movieCata[i].getName());
                }
            }
            if (!check) {
                System.out.println("No upcoming movies.");
            }
        }
    }

    //edit movie listing
    public void editMovie(int option, String name, int choice2, double newNum) {
        int index = searchMovie(name);
        if (index==-1) {
            System.out.println("Movie not found!!");
            return;
        }
        switch(option) {
            // case 1: //create
            //     for (int slot=0; slot<totalMovies; slot++) { //find empty movie[slot]
            //         if (movieCata[slot].getRatings()==0) {
            //             movieCata[slot].assignName(name);
            //             break;
            //         }
            //     }
            //     break;
            case 2: //edit
                switch(choice2) {
                    case 1:
                        movieCata[index].assignHallNumber((int)newNum);
                        break;
                    case 2:
                        movieCata[index].assignStatus((int)newNum);
                        break;
                    case 3:
                        movieCata[index].assignPrice(newNum);
                        break;
                    case 4:
                        //movieCata[index].addReviews(name);
                        break;
                }
                break;
            case 3: //remove
                movieCata[index].removeMovie();
                break;
            case 4:
                Integer tim = (Integer)choice2;
                movieCata[index].assignTimings(tim);
                break;
        }
    }

    public void createMovie(String name, String dirname, String castName, String syp,
                                                                double P, int S, int T, int H)
    {
        int index=0, i;
        for (i=0; i<totalMovies; i++) {
            if (movieCata[i].getName()==null) {
                index=i;
                break;
            }
        }
        if (i==totalMovies) {
            System.out.println("Cinema is full, cannot add any new movies");
            return;
        }
        movieCata[index].assignAbsClass(name, dirname, castName, syp);
        movieCata[index].assignPrice(P);
        movieCata[index].assignStatus(S);
        movieCata[index].assignType(T);
        movieCata[index].assignHallNumber(H);
        movieCata[index].assignRatings(0);
        System.out.println("Movie added!");
    }

    //search for a movie index
    public int searchMovie(String name) {
        for (int i=0; i<totalMovies; i++) {
            if (movieCata[i].getName()==null) {
                continue;
            }
            else if (movieCata[i].getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1; //if movie is not found
    }

    

    public void displayMovieDetail(String moviename, ArrayList<Movie> Movies) {
    	int i;
        for (i = 0; i < totalMovies; i++) {
            if (movieCata[i].getName()!=null && movieCata[i].getName().equals(moviename)) {
//                chosenMovie = Movies.get(i);
                break;
            }
        }
        if(i!=totalMovies) {
	        System.out.println("Movie Title: " + movieCata[i].getName());
	        System.out.println("Showing status: " + movieCata[i].getStatus());
	        System.out.println("Director: " + movieCata[i].getDirector());
	        System.out.println("Rating: " + movieCata[i].getOverallRating());
	        System.out.println("Cast: " + movieCata[i].getCast());
	        System.out.printf("Score: %.2f\n", movieCata[i].getOverallRating());
	        System.out.println("Sypnosis: " + movieCata[i].getSynopsis());
        }else {
            System.out.println("Movie not found!");
        }

    }

    public ArrayList<Movie> displayTopRate(ArrayList<Movie> movies) {
        ArrayList<Movie> sortedMovies;
        sortedMovies = SortTop5.sortByScore(movies);
        System.out.println("All movies sorted by rating");
        for (int i = 0; i < totalMovies; i++) {
        	if(movieCata[i].getName()!=null ) {
	            System.out.println("No." + (i + 1));
	            System.out.println(movieCata[i].getName());
	            System.out.printf("Score: %.2f\n", movieCata[i].getOverallRating());
	            System.out.println(" ");
        	}
        }
        return sortedMovies;
    }
    
    public ArrayList<Movie> displayTopSale(ArrayList<Movie> movies) {
        ArrayList<Movie> sortedMovies;
        sortedMovies = SortTop5.sortBySale(movies);
        System.out.println("All movies sorted by ticket sales");
        for (int i = 0; i < totalMovies; i++) {
        	if(movieCata[i].getName()!=null ) {
	            System.out.println("No." + (i + 1));
	            System.out.println(movieCata[i].getName());
	            System.out.println(movieCata[i].getSalesNumber());
	            System.out.println(" ");
        	}
        }
        return sortedMovies;
    }
    
}