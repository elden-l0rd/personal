package moblima;

import java.io.Serializable;
import java.util.ArrayList;

//public enum Cineplex {
//	CINELEISURE,
//	CAUSEWAY_POINT,
//	AMK_HUB;
//
//	public String getID(Cineplex cineplex) {
//		switch(cineplex) {
//		case CINELEISURE:
//			return "CL";
//		case CAUSEWAY_POINT:
//			return "CP";
//		case AMK_HUB:
//			return "AH";
//		default:
//			return "0";
//		}
//	}
//
//	public String getName(Cineplex cineplex) {
//		return this.
//		return null;
//	}
//}
public class Cineplex implements Serializable {
    private String Name;
    private int ID;
    private ArrayList<Cinema> cinemas;
    private ArrayList<MovieSlot> slots;
    
    public Cineplex(String name, int iD) {
        super();
        Name = name;
        ID = iD;
        this.cinemas = new ArrayList<Cinema>();
        this.slots = new ArrayList<MovieSlot>();
    }

    public Cineplex() {
    	
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public ArrayList<Cinema> getCinemas() {
        return cinemas;
    }

    public void setCinemas(ArrayList<Cinema> cinemas) {
        this.cinemas = cinemas;
    }

    public void addCinemas(Cinema cinema) {
        this.cinemas.add(cinema);
        for (MovieSlot mv : cinema.getMovieSlots()) {
            this.slots.add(mv);
        }
    }
    
    public ArrayList<MovieSlot> getSlots() {
        return slots;
    }

    public void setSlots(ArrayList<MovieSlot> slots) {
        this.slots = slots;
    }

    public void addSlots(MovieSlot slot) {
        this.slots.add(slot);
    }


}