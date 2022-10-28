package movie_assignment.admin;

public class movie extends video {
    private String[] reviews; //store in array of (strings)reviews
    private int ratings;
    private int hall;
    private int status;

    public movie(String n, String[] re, int rat, int s) {
        super(n);
        this.reviews = re;
        this.ratings = rat;
        this.status = s;
    }

    //for new movies w/o ratings and reviews
    public movie(String n, int s) {
        super(n);
        this.status = s;
    }

    @Override
    public void assignName(String n) {
        super.assignName(n);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public void assignReviews() {
        //
    }

    public String[] getReviews() {
        return this.reviews;
    }

    public void assignRatings() {
        //
    }

    public int getRatings() {
        return this.ratings;
    }

    public void assignHallNumber(int num) {
        this.hall = num;
    }

    public int getHallNumber() {
        return this.hall;
    }

    public void assignStatus(int num) {

        // 0 -> empty, no movie stored
        // 1 -> NOW_SHOWING
        // 2 -> coming Soon

        this.status = num;
    }

    public int getStatus() {
        return this.status;
    }

}
