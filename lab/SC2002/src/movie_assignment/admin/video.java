package movie_assignment.admin;

public class video {
    private String name;
    private String director;
    private String[] cast;

    public video(String n, String d, String[] c) {
        this.name=n;
        this.director=d;
        this.cast=c;
    }

    public void assignName(String n) {
        this.name=n;
    }

    public String getName() {
        return this.name;
    }

    public String getDirector() {
        return this.director;
    }

    public String[] getCast() {
        return this.cast;
    }
    
}