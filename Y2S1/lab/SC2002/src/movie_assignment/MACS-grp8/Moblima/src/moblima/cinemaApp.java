package moblima;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;

public class cinemaApp implements java.io.Serializable {
    private static final int numCinemaHall = 10;
    private static final int totalMovies = 15;
    private Movie[] movieCata; //movie catalogue
    private int userView=3;
    
    public cinemaApp() {
        movieCata = new Movie[15];
        for (int i=0; i<15; i++) {
            movieCata[i] = new Movie(null,null,null,null,0,0,0,0,0); // WIP
        }
        try {
			this.loadMovie();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

//    public void sortRatings() { 
//        ///////// WIP (implementation) /////////
//        Movie[] tmp = new Movie[16]; //tmp[15] is intermediary
//        for (int i=0; i<totalMovies; i++) {
//            tmp[i] = movieCata[i];
//        }
//
//        for (int i=1; i<totalMovies; i++) {
//            for (int j=i; j>0; j--) {
//                if (tmp[j].getRatings() < tmp[j-1].getRatings()) {
//                    tmp[15] = tmp[j-1];
//                    tmp[j-1]=tmp[j];
//                    tmp[j]=tmp[15];
//                }
//            }
//        }
//        movieCata=tmp;
//    }

    //print movies
    public void showMovies(int a) {
        boolean check=false;
        if (a==1) {
            System.out.println("\nIn PREVIEW:");
            for (int i=0; i<totalMovies; i++) {
                if (movieCata[i].getStatus()==1) {
                    check=true;
                    System.out.println(movieCata[i].getName());
                }
            }
            if (!check) {
                System.out.println("No movies are in preview.");
            }
        }
        else if (a==2) {
            System.out.println("\nNOW SHOWING:");
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
        else if (a==3) {
            System.out.println("\nCOMING SOON:");
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
        else { //a==4
            System.out.println("\nEND OF SHOWING:");
            for (int i=0; i<totalMovies; i++) {
                if (movieCata[i].getStatus()==4) {
                    check=true;
                    System.out.println(movieCata[i].getName());
                }
            }
            if (!check) {
                System.out.println("No upcoming movies.");
            }
        }
    }
    
    public void printReviews(String name) {
        int index = searchMovie(name);
        movieCata[index].getReviews();
    }

    public void editUserView(int v) {
        this.userView=v;
    }
    public int getUserView() {
        return this.userView;
    }
    
    //edit movie listing
    public void editMovie(int option, String name, int choice2, double newNum) {
        int index = searchMovie(name);
        if (index==-1) {
            System.out.println("Movie not found!!");
            return;
        }
        switch(option) {
             case 1: //delete review
                movieCata[index].removeReviews(choice2);
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
                        break;
                    case 4:
//                        movieCata[index].addReviews(name);
                        break;
                }
                break;
            case 3: //remove
                movieCata[index].removeMovie();
                break;
//            case 4:
//                Integer tim = (Integer)choice2;
//                movieCata[index].assignTimings(tim);
//                break;
        }
    }

    public void createMovie(String name, String dirname, String castName, String syp,
                                            double P, int S, int T, String lang, int rt, int rg)
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
        movieCata[index].assignRatingGuide(0);
        movieCata[index].assignLanguage(lang);
        movieCata[index].assignRuntime(rt);
        movieCata[index].assignRatingGuide(rg);
        System.out.println("Movie added!\n");
       
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
	        System.out.println("\nMovie Title: " + movieCata[i].getName());
	        System.out.println("Showing status: " + movieCata[i].printStatus(movieCata[i].getStatus()));
	        System.out.println("Director: " + movieCata[i].getDirector());
	        System.out.println("Cast: " + movieCata[i].getCast());
	        System.out.println("Sypnosis: " + movieCata[i].getSynopsis());
	        System.out.println("Genre: " + movieCata[i].getType());
	        System.out.println("Rating Guide: " + movieCata[i].printRatingGuide(movieCata[i].getRatingGuides()));
            System.out.println("Language: " + movieCata[i].getLang());
            System.out.println("Runtime(in minutes): " + movieCata[i].getRuntime() + "\n");
//	        System.out.printf("Score: %.2f\n", movieCata[i].getOverallRating());

        }else {
            System.out.println("Movie not found!");
        }

    }

    public ArrayList<Movie> displayTopRate(ArrayList<Movie> movies) throws IOException {
        ArrayList<Movie> sortedMovies;
        sortedMovies = SortTop5.sortByScore(movies);
        System.out.println(sortedMovies);
        System.out.println("All movies sorted by rating");
//        for (int i = 0; i < totalMovies; i++) {
        for (int i = 0; i < 5; i++) {
        	if(movieCata[i].getName()!=null ) {
	            System.out.println("No." + (i + 1));
	            System.out.println(movieCata[i].getName());
	            try {
	            	this.updateOverallRating(movieCata[i].getName());
	            }
	            catch (FileNotFoundException ex) {}
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
//        for (int i = 0; i < totalMovies; i++) {
        for (int i = 0; i < 5; i++) {
        	if(movieCata[i].getName()!=null ) {
	            System.out.println("No." + (i + 1));
	            System.out.println(movieCata[i].getName());
	            System.out.println(movieCata[i].getSalesNumber());
	            System.out.println(" ");
        	}
        }
        return sortedMovies;
    }
    
    public void assignStats(String movie, int rating, String review) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(movie+ ".txt", true));
        writer.write(rating+" "+review);
        writer.newLine();
        writer.close();
        
    }
    
    public void updateOverallRating(String movie) throws IOException {
    	FileReader fr = new FileReader(movie + ".txt");
		BufferedReader br = new BufferedReader(fr);
	    String line, rating;
	    double rat = 0; int counter = 0;
	    while ((line = br.readLine()) != null) {
	    	rating = line.split(" ")[0].toLowerCase();
	    	rat += Double.valueOf(rating);
	    	counter += 1;
	    }
	    movieCata[this.searchMovie(movie)].assignRating(rat/counter);
        br.close();
    }
    
    public double printRating(String movie) throws IOException{
    	return movieCata[this.searchMovie(movie)].getOverallRating();
    }

    public void saveMovie() throws IOException {
    	BufferedWriter writer = new BufferedWriter(new FileWriter("movieData.txt", false));
        for (int i = 0; i < totalMovies; i++) {
	    writer.write(movieCata[i].getName()+ "\n" +
	    			 movieCata[i].getDirector() + "\n" +
	    			 movieCata[i].getCast() + "\n" +
	    			 movieCata[i].getSynopsis() +"\n" +
	    			 movieCata[i].getPrice() + "\n" +
	    			 movieCata[i].getStatus() + "\n" +
	    			 movieCata[i].getType() + "\n" +
	    			 movieCata[i].getRatingGuides() + "\n" +
	    			 movieCata[i].getLang() +"\n" + 
	    			 movieCata[i].getRuntime() + "\n"+ 
	    			 movieCata[i].getHallNumber() + "\n" +
	    			 "--------\n"); 
        }
	    writer.newLine();
	    writer.close();
    }
    
    public void loadMovie() throws IOException {
    	FileReader fr = new FileReader("movieData.txt");
		BufferedReader br = new BufferedReader(fr);
	    String line,a,b,c,d;
	    int flag = 0;
        for (int j = 0; j < totalMovies; j++) {
	    	a=br.readLine();
	    	b=br.readLine();
	    	c=br.readLine();
	    	d=br.readLine();
	    	if(a.equals("null")) {
	    		flag=1;}
	    	if(flag==0) {
		    	movieCata[j].assignAbsClass(a, b, c, d);
		    	movieCata[j].assignPrice(Double.valueOf(br.readLine()));
		    	movieCata[j].assignStatus(Integer.valueOf(br.readLine()));
		    	movieCata[j].assignTypes(br.readLine());
		    	movieCata[j].assignRatingGuide(Integer.valueOf(br.readLine()));
		    	movieCata[j].assignLanguage(br.readLine());
		    	movieCata[j].assignRuntime(Integer.valueOf(br.readLine()));
		    	movieCata[j].assignHallNumber(Integer.valueOf(br.readLine()));
		    	br.readLine();
	    	}
	    	else {
	    		movieCata[j].assignAbsClass(null, null, null, null);
		    	movieCata[j].assignPrice(0);
		    	movieCata[j].assignStatus(0);
		    	movieCata[j].assignTypes(null);
		    	movieCata[j].assignRatingGuide(0);
		    	movieCata[j].assignLanguage(null);
		    	movieCata[j].assignRuntime(0);
		    	movieCata[j].assignHallNumber(0);
	    	}
	    	
	    	
	    }
	    br.close();
    }
    
    public ArrayList<Movies> createArrayList() {
        ArrayList<Movies> movies = new ArrayList<Movies>();
    	for(int i=0;i<totalMovies; i++) {
    		Movies temp = new Movies(movieCata[i].getName(),movieCata[i].getStatus());
    		movies.add(temp);
    	}
    	return movies;
    }


    
}