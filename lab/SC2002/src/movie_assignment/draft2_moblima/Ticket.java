package moblima;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Ticket {
	protected double price;
	private Movie movieChosen;
	private String transactionID;
	private Seat seat;
	private Cinema cinema;
	private Cineplex cineplex;
	private LocalDate date;
	private String time;
	private MovieSlot slot;

	public Ticket() {
		price = -1;
	}

	public Ticket(Movie movieChosen, Seat seat, Cineplex cineplex, Cinema cinema, LocalDate date, MovieSlot slot) {
		super();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		LocalDateTime now = LocalDateTime.now();
		this.movieChosen = movieChosen;
		this.seat = seat;
		this.cinema = cinema;
		this.cineplex = cineplex;
		this.date = date;
		this.slot = slot;
		this.transactionID = String.valueOf(cineplex.getID(cineplex)) + cinema.getCinemaID() + dtf.format(now);
		this.price = this.getPrice();
	}

	public Movie getMovieChosen() {
		return movieChosen;
	}

	public void setMovieChosen(Movie movieChosen) {
		this.movieChosen = movieChosen;
	}


	public String getTransactionID() {
		return transactionID;
	}


	public void setTransactionID(String transactionID) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		LocalDateTime now = LocalDateTime.now();
		this.transactionID = String.valueOf(cineplex.getID(cineplex)) + cinema.getCinemaID() + dtf.format(now);
	}


	public double getPrice() {
		this.price = Price.calPrice(this);
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public Seat getSeat() {
		return seat;
	}


	public void setSeat(Seat seat) {
		this.seat = seat;
	}


	public Cinema getCinema() {
		return cinema;
	}


	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	
	public Cineplex getCineplex() {
		return cineplex;
	}


	public void setCineplex(Cineplex cineplex) {
		this.cineplex = cineplex;
	}

	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public MovieSlot getSlot() {
		return slot;
	}


	public void setSlot(MovieSlot slot) {
		this.slot = slot;
	}

	public void printTicket() {
		System.out.println("--------------RECEIPT--------------");
		System.out.println(this.getCineplex());
		System.out.println("Date: " + this.getDate().toString() + "	" + this.getDate().getDayOfWeek().toString());
		System.out.println("Time: " + this.getSlot().getTime());
		System.out.println(this.getMovieChosen().getTitle());
		System.out.println(this.getMovieChosen().getType());
		System.out.println("Cinema Class: " + this.getCinema().getClass().toString());
		System.out.println("Cinema:	" + (this.getCinema().getCinemaID() + 1) +
				"	Seat: " +
				(char) (this.getSeat().getRow() + 65) + " " +
				(this.getSeat().getCol() + 1));
		System.out.println();
		System.out.println("Price: " + this.getPrice());
		System.out.println("Paid by:         UOB CREDIT CARD");
		System.out.println();

		System.out.println("Date" + "	" + LocalDate.now());
		System.out.println("Transaction Number :  " + this.getTransactionID());

		System.out.println();
		System.out.println("THANK YOU, PLEASE COME AGAIN\n" +
				"Prices Inclusive of 7% GST\n");

	}

}

