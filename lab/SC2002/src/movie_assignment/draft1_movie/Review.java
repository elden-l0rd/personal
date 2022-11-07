package movie_assignment.draft1_movie;

public class Review {
	private int score;
	private String review;
	
	Review(int score, String review){
		this.score = score;
		this.review = review;
	}
	
	void setScore(int score) {
		this.score = score;
	}
	
	int getScore() {
		return score;
	}
	
	void setReview(String review) {
		this.review = review;
	}
	
	String getReview() {
		return review;
	}
}