package moblima;
import java.util.*;

public class video {
    private String name; // change to title
    private String director; // remain
//    private ArrayList<String> cast; //remain
    private String cast; //remain
    private String description; //change to synopsis

    public video(String n, String d, String c, String des) {
        this.name=n;
        this.director=d;
//        this.cast = new ArrayList<String>();
//        this.cast.add(c);
        this.cast=c;
        this.description=des;
    }
    
    public video() {
    	
    }
    public void assignName(String n) { //setTitle
        this.name=n;
    }

    public String getName() { // getTitle
        return this.name;
    }

    public String getDirector() { //getDirector
        return this.director;
    }

    public void assignDir(String dir) { //setDirector
        this.director=dir;
    }

    public void addCast(String c) { //setCast
//      this.cast.add(c);
      this.cast=c;
  }

//  public ArrayList<String> getCast() { //remain
//      return this.cast;
//  }
  public String getCast() { //remain
      return this.cast;
  }


    public void assignSypnosis(String syp) { //setSypnosis
        this.description=syp;
    }
    
    public String getSynopsis() { //remain
        return this.description;
    }

}