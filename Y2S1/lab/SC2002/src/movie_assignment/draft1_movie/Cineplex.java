package movie_assignment.draft1_movie;

public enum Cineplex {
	CATHY,
	GOLDEN_VILLAGE,
	SHAW;
	
	public String getID(Cineplex cineplex) {
		switch(cineplex) {
		case CATHY:
			return "CT";
		case GOLDEN_VILLAGE:
			return "CT";
		case SHAW:
			return "GV";
		default:
			return "0";
		}
	}
}
