package movie_assignment.admin;
import java.util.*;

public class video {
    private String name;
    private String director;
    private ArrayList<String> cast;
    private String description; //synopsis

    public video(String n, String d, String c, String des) {
        this.name=n;
        this.director=d;
        this.cast.add(c);
        this.description=des;
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

    public void addCast(String c) {
        this.cast.add(c);
    }

    public ArrayList<String> getCast() {
        return this.cast;
    }
    
    public String getSynopsis() {
        return this.description;
    }
}