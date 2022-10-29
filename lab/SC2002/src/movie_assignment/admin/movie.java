package movie_assignment.admin;
import java.util.*;

public class movie extends video {
    private ArrayList<String> reviews;
    private double ratings;
    private static int numOfRatings;
    private int hall;
    private int status;
    private double price;
    private String type;

    //first add name,director,cast,synopsis,status,price,type
    //ratings initialised to 0
    //hall,reviews to be added in future
    public movie(String n, String d, String c, String syp, int s, double p, int t) {
        super(n,d,c,syp);
        this.price=p;
        this.status=s;
        this.ratings=.0;
        numOfRatings=0;
        assignType(t);
    }

    @Override
    public void assignName(String n) {
        super.assignName(n);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public void addReviews(String r) {
        this.reviews.add(r);
    }

    public ArrayList<String> getReviews() {
        return this.reviews;
    }

    public void assignRatings(double rat) {
        numOfRatings++;
        this.ratings+=rat;
    }

    public void getRatings() {
        System.out.printf("%.1f\n", this.ratings/numOfRatings);
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

        this.status = num;
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
        this.ratings=0;
        this.reviews=null;
        this.type=null;
    }

}
