package movie_assignment.draft1_movie;

import java.util.*;

public class Showtime {
	private String cineplexId;
	private String cinemaId;
	private Calendar date;
	
	public Showtime(String cineplexId, String cinemaId, Calendar date) {
		this.cineplexId = cineplexId;
		this.cinemaId = cinemaId;
		this.date = date;
	}
	public String getCineplexId() {
		return cineplexId;
	}
	public String getCinemaId() {
		return cinemaId;
	}
	public Calendar getCalendar() {
		return date;
	}
	public void setCineplexId(String cineplexId) {
		this.cineplexId = cineplexId;
	}
	public void setCinemaId(String cinemaId) {
		this.cinemaId = cinemaId;
	}
	public void setCalendar(Calendar date) {
		this.date = date;
	}
}





