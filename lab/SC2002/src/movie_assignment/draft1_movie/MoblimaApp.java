package moblima;

import java.time.LocalDate;
import java.util.*;

public class MoblimaApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Movie> MovieList = new ArrayList<Movie>();
		ArrayList<MovieSlot> MovieSlotList = new ArrayList<MovieSlot>();
		ArrayList<Customer> CustomerList = new ArrayList<Customer>();
		ArrayList<Cineplex> CineplexList = new ArrayList<Cineplex>();
		
		
		
		boolean exit = false;
		while (exit == false) {
			System.out.println("|======================================|");
			System.out.println("|=========|Welcome to MOBLIMA|=========|");
			System.out.println("|======================================|\n" + 
					"\n\n" +
					"Please select option:\n" +
					"1. Admin Login\n" +
					"2. Guest Login\n" +
					"3. Exit Application\n");
			System.out.print("Select action: ");
			int choice=sc.nextInt();
			switch(choice) {
				case 1:

					break;
				case 2:
					System.out.println("\n|=========================================|");
					System.out.println("|===============|Guest Mode|==============|");
					System.out.println("|=========================================|");
					System.out.print("\n"+
							   "1. Search movie\n"+
							   "2. View movie details\n"+
							   "3. Check seat availibility\n" +
							   "4. Purchase ticket\n" +
							   "5. View booking history\n" +
							   "6. List Top 5 Ranking Movies by ticket sales\n" +
							   "7. List Top 5 Ranking Movies by overall reviewer's ratings\n" +
							   "8. Exit\n");
					System.out.println("Select action: ");
					int choice2=sc.nextInt();
					switch(choice2) {
						case 1:
							
							break;
						case 2:
							
							break;
						case 3:

							break;
						case 4:
							System.out.println("Enter your name");
							String name = sc.nextLine();
							System.out.println("Enter your mobile phone number");
							String mobile = sc.nextLine();
							while (!mobile.matches("\\d{8}")) {
								System.out.println("Error! Invalid phone number!");
								System.out.println("Input your mobile phone number");
								mobile = sc.nextLine();
							}
							System.out.println("Input your email");
							String email = sc.nextLine();
							Customer user = new Customer();
							
							int tickettype = 0;
							System.out.println("Choose type of ticket you want to buy");
							System.out.println("1.Adult Ticket");
							System.out.println("2.Senior Ticket");
							System.out.println("3.Children Ticket");
							System.out.println("Select your choice: ");
							while (true) {
								try {
									tickettype = sc.nextInt();
									if (1 <= tickettype && tickettype <= 3)
										break;
									else
										System.out.println("Error! Enter your selection again!");
								} catch (NumberFormatException e) {
									System.out.println("Error! Enter your selection again!");
								}
							}
							
							Ticket t = new Ticket();

							break;

						case 5:
							boolean findUser = false;
							boolean quit = false;
							Customer currentUser = new Customer();

							while (true) {
								System.out.println("Input your mobile phone number");
								System.out.println("Input \"quit\" to quit");
								String mobileNumber = sc.nextLine();
								if (mobileNumber.contentEquals("quit")) {
									quit = true;
									break;
								}
								/*
								while (!mobileNumber.matches("\\d{8}")) {
									System.out.println("Wrong format");
									System.out.println("Input your mobile phone number");
									mobileNumber = sc.nextLine();
									if (mobileNumber.contentEquals("quit")) {
										quit = true;
										break;
									}
								}
								*/
								for (Customer m : CustomerList) {
									if (mobileNumber.equals(m.getMobile())) {
										findUser = true;
										currentUser = m;
										break;
									}
								}
								if (findUser)
									break;
								System.out.println("No matching entries");
							}
							if (quit)
								break;
							if (currentUser.getBookingHistory().isEmpty()) {
								System.out.println("No bookings available");
								break;
							}
							for (Ticket tk : currentUser.getBookingHistory()) {
								System.out.println("Ticket " + (currentUser.getBookingHistory().indexOf(tk) + 1));
								try {
									tk.printTicket();
								} catch (NullPointerException e) {
									System.out.println("Fail to purchase");
								}
							}
							break;
						case 6:
							for (Movie m : MovieList) {
								if (m.getShowingStatus().equals(Status.PREVIEW) || m.getShowingStatus().equals(Status.NOW_SHOWING))
									visible.add(m);
							}
							MovieView.displayTopRate(visible);
							break;
						case 7:
							
							break;
						case 8:
							System.out.println("Logged out successfully!");
							break;
						default:
							System.out.println("Invalid option, please try again.");
							break;
					}
							
				
	
					break;
				case 3:
					exit = true;
					System.out.println("Exiting MOBLIMA");
					System.out.println("Goodbye!");
					break;
				default:
					System.out.println("Wrong input!");
				}
				
			}
	}
}