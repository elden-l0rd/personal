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
    //timings for each movie
    public void sortTimings(int[] arr) {
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

    public void sortRatings() { 
        movie[] tmp = new movie[16]; //tmp[15] is intermediary
        for (int i=0; i<totalMovies; i++) {
            tmp[i] = movieCata[i];
        }

        for (int i=1; i<totalMovies; i++) {
            for (int j=i; j>0; j--) {
            ////////////////////////////// WIP //////////////////////////////
                if (tmp[j].getRatings() < tmp[j-1].getRatings()) {
                    tmp[15] = tmp[j-1];
                    tmp[j-1]=tmp[j];
                    tmp[j]=tmp[15];
                }
            }
        }
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
        switch(option) {
            case 1: //create
                for (int i=0; i<totalMovies; i++) {
                    if (movieCata[i].getStatus()==0) {
                        movieCata[i].assignStatus(status);
                        movieCata[i].assignName(name);
                        break;
                    }
                }
            ////////////////////////////// WIP //////////////////////////////
                break;
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
                }

                break;
            case 3: //remove
                movieCata[index].removeMovie();
                break;
        }
    }

    //search for a movie index
    public int searchMovie(String name) {
        for (int i=0; i<totalMovies; i++) {
            if (movieCata[i].getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1; //if movie is not found
    }

}