package movie_assignment.admin;

public class video {
    private String name;

    public video(String n) {
        this.name=n;
    }

    public void assignName(String n) {
        this.name=n;
    }

    public String getName() {
        return this.name;
    }
}