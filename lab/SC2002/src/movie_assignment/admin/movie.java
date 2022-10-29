package movie_assignment.admin;

public class movie extends video {
    private String[] reviews;
    private int ratings;
    private int hall;
    private int status;
    private int price;
    private String type;

    public movie(String n, String d, String[] c, String[] re, int rat, int s, int p) {
        super(n,d,c);
        this.reviews = re;
        this.ratings = rat;
        this.status = s;
        this.price=p;
    }

    //for new movies w/o ratings and reviews
    public movie(String n, String d, String[] c, int s) {
        super(n,d,c);
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
        // 1 -> preview
        // 2 -> NOW_SHOWING
        // 3 -> coming Soon

        this.status = num;
    }

    public int getStatus() {
        return this.status;
    }

    public void assignPrice(int p) {
        this.price=p;
    }

    public int getPrice() {
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

}
