package movie_assignment.admin;

public class movie {
    private String name;
    private String[] reviews; //store in array of (strings)reviews
    private int ratings;
    private int hall;
    private int status;

    public movie(String n, String[] re, int rat, int s) {
        this.name = n;
        this.reviews = re;
        this.ratings = rat;
        this.status = s;
    }

    //for new movies w/o ratings and reviews
    public movie(String n, int s) {
        this.name = n;
        this.status = s;
    }

    public movie(int s) {
        this.status = s;
        this.hall = 0;
    }

    public void setName(String n) {
        this.name = n;
    }
    public String getName() {
        return this.name;
    }

    public String[] getReviews() {
        return reviews;
    }

    public int getRatings() {
        return this.ratings;
    }

    public void setHallNumber(int num) {
        this.hall = num;
    }

    public int getHallNumber() {
        return this.hall;
    }

    public void setStatus(int num) {
        this.status = num;
    }

    public int getStatus() {
        /*
        0 -> empty, no movie stored
        1 -> NOW_SHOWING
        2 -> coming Soon
        */
        return this.status;
    }
}
