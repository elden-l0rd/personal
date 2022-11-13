package moblima;

public class Movies {
	private String movies;
	private int status;
	
	public Movies(String movie, int status) {
		this.movies=movie;
		this.status=status;
	}
	
	public String getName() {
		return this.movies;
	}
	
	public int getStatus() {
		return this.status;
	}
	
	public void assignMovie(String movie) {
		this.movies=movie;
	}
	
	public void assignStatus(int status) {
		this.status=status;
	}
}
