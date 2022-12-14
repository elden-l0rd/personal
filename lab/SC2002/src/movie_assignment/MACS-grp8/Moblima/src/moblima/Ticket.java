package moblima;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

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
		this.transactionID = String.valueOf(cineplex.getID()) + cinema.getCinemaID() + dtf.format(now);
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
		this.transactionID = String.valueOf(cineplex.getID()) + cinema.getCinemaID() + dtf.format(now);
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
		System.out.println(this.getMovieChosen().getName());
		System.out.println(this.getMovieChosen().getType());
		System.out.println("Cinema Class: " + this.getCinema().getClass().toString());
		System.out.println("Cinema:	" + (this.getCinema().getCinemaID() + 1) + "	Seat: "
				+ (char) (this.getSeat().getRow() + 65) + " " + (this.getSeat().getCol() + 1));
		System.out.println();
		System.out.println("Price: " + this.getPrice());
		System.out.println("Paid by:         UOB CREDIT CARD");
		System.out.println();

		System.out.println("Date" + "	" + LocalDate.now());
		System.out.println("Transaction Number :  " + this.getTransactionID());

		System.out.println();
		System.out.println("THANK YOU, PLEASE COME AGAIN\n" + "Prices Inclusive of 7% GST\n");
	}
	
	public static Ticket BookTicket(ArrayList<Movies> movies, ArrayList<MovieSlot> slots, int age) {

		Cineplex selectedCineplex = null;
		boolean available = false;
		Movie chosenmovie = new Movie();
		System.out.println("----------TICKET BOOKING----------");
		//CHOOSE MOVIE
		System.out.println("Available movies are listed below");
		for (Movies m : movies) {
			if (m.getStatus()==1 || m.getStatus()==2) {
				System.out.println(m.getName());
				available = true;
			}
		}
		if (!available) {
			System.out.println("No movies available");
			return null;
		}
		Scanner sc = new Scanner(System.in);
		boolean find = false;
		while (find != true) {
			System.out.println("Enter Movie title: ");
			String movieName = sc.nextLine();
			for (Movies m : movies) {
				if (m.getName().equals(movieName)) {
//					chosenmovie = m;
					String sel = "";
					sel = m.getName();
					find = true;
					break;
				}
			}
			if (find)
				break;
			System.out.println("Movie not found!");
		}
		//CHOOSE CINEPLEX
		ArrayList<MovieSlot> availablemovieslot = new ArrayList<MovieSlot>();
		ArrayList<Cineplex> availableCineplex = new ArrayList<Cineplex>();
//		for (MovieSlot ms : slots) {
//			if (ms.getMovie().getName().equals(sel)) {
//				availablemovieslot.add(ms);
//			}
//		}
//		if (availablemovieslot.isEmpty()) {
//			System.out.println("No movie slots available.");
//			return null;
//		}
//
//		for (MovieSlot ms : availablemovieslot) {
//			if (!availableCineplex.contains(ms.getCineplex()))
//				availableCineplex.add(ms.getCineplex());
//		}
		System.out.println("Available Cineplexes are listed below");
		for (Cineplex s : availableCineplex) {
			System.out.println(s.getName());
		}
		find = false;
		while (find != true) {
			System.out.println("Enter Cineplex name: ");
			String cineplexName = sc.nextLine();
			for (Cineplex s : availableCineplex) {
				if (s.getName().equals(cineplexName)) {
					selectedCineplex = s;
					find = true;
					break;
				}
			}
			if (find)
				break;
			System.out.println("Cannot match Cineplex");
		}
		//CHOOSE TIME SLOT
		ArrayList<MovieSlot> availableTimeslot = new ArrayList<MovieSlot>();
		System.out.println("Available Time Slots:");
		System.out.println("Select according to the choice number:");
		for (MovieSlot ms : availablemovieslot) {
			if (ms.getCineplex().equals(selectedCineplex)) {
				availableTimeslot.add(ms);
			}
		}
		for (MovieSlot ms : availableTimeslot) {
			System.out.println("Choice " + (availableTimeslot.indexOf(ms) + 1));
			System.out.println("Date: " + ms.getDate());
			System.out.println("Time: " + ms.getTime());
			System.out.println("Cinema: " + ms.getCinema().getCinemaID());
			System.out.println("Cinema Class: " + ms.getCinemaClass());
			System.out.println();
		}
		if (availableTimeslot.isEmpty()) {
			System.out.println("Nothing available");
			return null;
		}
		int choice;
		System.out.println("Enter your selection: ");
		while (true) {
			try {
				choice = sc.nextInt();
				if (1 <= choice && choice <= availableTimeslot.size())
					break;
				else
					System.out.println("Bad input! Enter your selection again!");
			} catch (NumberFormatException e) {
				System.out.println("Bad input! Enter your selection again!");
			}
		}
		
		MovieSlot msFound = availableTimeslot.get(choice - 1);
		System.out.println("Your Choice");
		System.out.println("Date: " + msFound.getDate());
		System.out.println("Time: " + msFound.getTime());
		System.out.println("Cinema: " + msFound.getCinema().getCinemaID());
		System.out.println("Cinema Class: " + msFound.getCinemaClass());
		System.out.println();
		for (MovieSlot ms : slots) {
			System.out.println("Looking for slot in Library");
			if (ms.getCineplex().getID() == msFound.getCineplex().getID()
					&& ms.getTime().equals(msFound.getTime())
					&& ms.getCinema().getCinemaID() == msFound.getCinema().getCinemaID()
					&& ms.getDate().equals(msFound.getDate())) {
				System.out.println("Slot found!");
				System.out.println("Date: " + ms.getDate());
				System.out.println("Time: " + ms.getTime());
				System.out.println("Cinema: " + ms.getCinema().getCinemaID());
				System.out.println("Cinema Class: " + ms.getCinemaClass());
				while (true) {
					System.out.println("Choose your seat");
					SeatApp seatApp = new SeatApp();
					seatApp.printSeats();
					//SeatApp.printSeats(ms.getCinemaSeats());
					System.out.println("Input the row number you selected (Capital Letter)");
					char row = sc.nextLine().charAt(0);
					System.out.println("Input the column number you selected (integer)");
					int col = Integer.parseInt(sc.nextLine());
					int rowNum = (int) row - 65;
					System.out.println((col - 1) + " " + rowNum);
					if (!ms.getCinemaSeats()[rowNum][col - 1].getIsOccupied()) {
						ms.bookSeat(rowNum, col - 1);
						ms.getMovie().saleMade();
						double ageDiscount=0;
						if (age == 2) {//senior
							Ticket ticket = new Ticket(chosenmovie, ms.getCinemaSeats()[rowNum][col - 1],
									selectedCineplex, ms.getCinema(), ms.getDate(), ms);
							System.out.printf("The price is: %0.2d\n", ticket.getPrice()*0.6);
							System.out.println("Would you like to complete the payment? Input Y/N");
							char input = sc.nextLine().charAt(0);
							if (input == 'Y') {
								ticket.printTicket();
								return ticket;
							} else
								return null;
						} else if (age == 3) {//child
							Ticket ticket = new Ticket(chosenmovie, ms.getCinemaSeats()[rowNum][col - 1],
									selectedCineplex, ms.getCinema(), ms.getDate(), ms);
							System.out.printf("The price is: %0.2d\n", ticket.getPrice()*0.8);
							System.out.println("Would you like to complete the payment? Input Y/N");
							char input = sc.nextLine().charAt(0);
							if (input == 'Y') {
								ticket.printTicket();
								return ticket;
							} else
								return null;
						} else {//standard
							Ticket ticket = new Ticket(chosenmovie, ms.getCinemaSeats()[rowNum][col - 1], selectedCineplex,
									ms.getCinema(), ms.getDate(), ms);
							System.out.printf("The price is: %0.2d\n", ticket.getPrice());
							System.out.println("Would you like to complete the payment? Input Y/N");
							char input = sc.nextLine().charAt(0);
							if (input == 'Y') {
								ticket.printTicket();
								return ticket;
							} else
								return null;
						}
					} else
						System.out.println("The seat you have chosen is occupied!");
				}
			}
		}
		return null;

	}
}
