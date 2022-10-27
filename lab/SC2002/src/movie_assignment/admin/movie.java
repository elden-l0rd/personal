package movie_assignment.admin;

public class movie {
    private String name;
    private String[] reviews; //store in array of (strings)reviews
    private int ratings;
    private int hall;
    private int showing;
            // 0->empty (no movie avail), 1->upcoming, 2->comingsoon

    public movie(String n, String[] re, int rat, int s) {
        this.name = n;
        this.reviews = re;
        this.ratings = rat;
        this.showing = s;
    }

    //for new movies w/o ratings and reviews
    public movie(String n, int s) {
        this.name = n;
        this.showing = s;
    }

    public movie(int s) {
        this.showing = s;
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

    public int getHallNumber() {
        return this.hall;
    }

    public int isShowing() {
        return this.showing;
    }
}
