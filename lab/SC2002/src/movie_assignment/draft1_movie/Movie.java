package moblima;

import java.util.*;

public class Movie {
	
	private String title;
	private String status;
	private String synopsis;
	private String director;
	private List<String> cast;
	private String type;
	private double overallRating;	
	private List<Showtime> showTime;
	private List<Review> reviewList;
    private int salesNumber;

	public Movie (String title, String status, String synopsis,String director, List<String> cast, String type,
			List<Showtime> showTime, List<Review> reviewList, int sales){
		this.title = title;
		this.status = status;
		this.synopsis = synopsis;
		this.director = director;
		this.cast = cast;
		this.type = type;
		this.showTime = showTime;
		this.reviewList = reviewList;
		this.overallRating = average ();
        this.salesNumber = sales;
	}
	
	public Movie() {
	}
	
	private double average ()
	{
		if (reviewList.size() == 1)
			return 0;
		else
		{
			double total = 0;
			for (int i = 0; i < reviewList.size(); i++)
				total += reviewList.get(i).getScore();
			return total / reviewList.size();
		}
	}
	
	public void setTitle (String title)
	{
		this.title = title;
	}
	public void setStatus (String status)
	{
		this.status = status;
	}
	public void setSynopsis (String synopsis)
	{
		this.synopsis = synopsis;
	}
	public void setDirector (String director)
	{
		this.director = director;
	}
	public void setCast (List<String> cast)
	{
		this.cast = cast;
	}
	public void setType (String type)
	{
		this.type = type;
	}
	public void setShowTime (List<Showtime> showTime)
	{
		this.showTime = showTime;
	}
	public void setReviewList (List<Review> reviewList)
	{
		this.reviewList = reviewList;
		this.overallRating = average ();
	}
	
	public String getTitle ()
	{
		return title;
	}
	public String getStatus ()
	{
		return status;
	}
	public String getSynopsis ()
	{
		return synopsis;
	}
	public String getDirector ()
	{
		return director;
	}
	public List<String> getCast ()
	{
		return cast;
	}
	public String getType ()
	{
		return type;
	}
	public List<Showtime> getShowTime ()
	{
		return showTime;
	}
	public List<Review> getReviewList ()
	{
		return reviewList;
	}
	public double getOverallRating ()
	{
		return overallRating;
	}
	
    public int getSalesNumber() {
        return salesNumber;
    }

    public void setSalesNumber(int salesNumber) {
        this.salesNumber = salesNumber;
    }
    public void saleMade() {
        this.salesNumber += 1;
    }
}