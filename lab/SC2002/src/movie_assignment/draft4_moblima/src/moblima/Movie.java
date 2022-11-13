package moblima;
import java.util.*;

public class Movie extends video {
    private ArrayList<Review> reviews; //add ratings
    private int rating_guide;
//    private static int numOfRatings;
    private int hall;
    private int status;
    private double price;
    private String type;
    private SeatApp[] seat;
    private int[] timings;    
    private int salesNumber;
    private String language;
    private int runtime;
    private double rating;
	public Object[] s;
    
    //first add name,director,cast,synopsis,status,price,type
    //ratings initialised to 0
    //hall,reviews to be added in future
    public Movie(String n, String d, String c, String syp, int s, double p, int t, int sales, int rt) {
        super(n,d,c,syp);
        this.price=p;
        this.status=s;
        this.rating=.0;
//        numOfRatings=0;
        assignType(t);
        this.hall=0;
        this.reviews=new ArrayList<Review>();
        this.timings = new int[5];
        for (int x=0; x<5; x++) timings[x] = 9 + (x*3); //movie every 3h interval starting from 0900h
        this.seat = new SeatApp[5];
        for (int y=0; y<5; y++) seat[y] = new SeatApp();
        this.salesNumber = sales;
        this.language = null; //default
        this.runtime = rt;
    }


    public Movie() {
    	super();
    }
    public void assignAbsClass(String n, String d, String c, String syp) {
        super.assignName(n);
        super.assignDir(d);
        super.addCast(c);
        super.assignSypnosis(syp);
    }
    
    @Override
    public void assignName(String n) {
        super.assignName(n);
    }
    
    @Override
    public String getName() {
        return super.getName();
    }

    public void addReviews(ArrayList<Review> review, int average) {
		this.reviews.addAll(review);
		this.rating = average;
    }

    public void getReviews() {
        for (int i=0; i<(this.reviews.size()); i++) {
            System.out.println((i+1)+". "+ this.reviews.get(i)+"\n");
        }
    }

    public void removeReviews(int x) {
        this.reviews.remove(x);
        System.out.println("Review successfully deleted!");
    }

    public void assignRatingGuide(int rat) {
        this.rating_guide=rat;
    }
    
    public int getRatingGuides() {
    	return this.rating_guide;
    }

    public void getRatingGuide() {
        int r=this.rating_guide;
        switch(r) {
            case 1:
                System.out.println("Movie rating guide: G");
                break;
            case 2:
                System.out.println("Movie rating guide: PG");
                break;
            case 3:
                System.out.println("Movie rating guide: PG13");
                break;
            case 4:
                System.out.println("Movie rating guide: NC16");
                break;
            case 5:
                System.out.println("Movie rating guide: M18");
                break;
            case 6:
                System.out.println("Movie rating guide: R21");
                break;
        }
    }

    public void assignHallNumber(int num) {
        this.hall = num;
    }

    public int getHallNumber() {
        return this.hall;
    }

    public void assignStatus(int num) {

        // 0 -> empty, no movie stored
        // 1 -> preview
        // 2 -> NOW_SHOWING
        // 3 -> coming Soon
        // 4 -> END_OF_SHOWING

        this.status = num;
    }

    public String printStatus(int num) {
    	switch(num) {
    	case 0:
    		return "No movie stored";
    	case 1:
    		return "Preview";
    	case 2:
    		return "Now Showing";
    	case 3:
    		return "Coming Soon";
    	case 4:
    		return "End of Showing";
    	default:
    		return "Movie not found";
    	}
    }
    
    public String printRatingGuide(int num) {
    	switch(num) {
    	case 1:
    		return "G";
    	case 2:
    		return "PG";
    	case 3:
    		return "PG13";
    	case 4:
    		return "NC16";
    	case 5:
    		return "M18";
    	case 6:
    		return "R21";
    	default:
    		return "Movie not found";
    	}
    }
    
    public int getStatus() {
        return this.status;
    }

    public void assignPrice(double p) {
        this.price=p;
    }

    public double getPrice() {
        return this.price;
    }
    
    public void assignTypes(String t) {
    	this.type = t;
    }
    
    public void assignType(int t) {
        switch(t) { //TO assign choices for staff
            case 1:
                this.type="3D";
                break;
            case 2:
                this.type="Blockbuster";
                break;
            case 3:
                this.type="Comedy";
                break;
            case 4:
                this.type="Horror";
            case 5:
                this.type="Exclusive";
                break;
        }
    }
   
    public String getType() {
        return this.type;
    }

    public void removeMovie() {
        this.status=0;
        this.hall=0;
        this.price=.0;
        this.rating=0;
        this.reviews=null;
        this.type=null;
    }
    
    public void printTimings() {
    	System.out.println("[1] 9am");
    	System.out.println("[2] 12pm");
    	System.out.println("[3] 3pm");
    	System.out.println("[4] 6pm");
    	System.out.println("[5] 9pm");
    }
    
	public int getSalesNumber() {
        return salesNumber;
    }

    public void setSalesNumber(int salesNumber) {
        this.salesNumber = salesNumber;
    }
    public void saleMade() {
        this.salesNumber += 1;
    }
    
	 public double getOverallRating()
	 {
	 	return this.rating;
	 }
	
    public String getLang() {
        return this.language;
    }
    
    public void assignLanguage(String l) {
        this.language=l;
    }

    public int assignRuntime(int run) {
        return this.runtime=run;
    }

    public int getRuntime() {
        return this.runtime;
    }
    
    public double assignRating(double rating) {
    	return this.rating = rating;
    }
    
}