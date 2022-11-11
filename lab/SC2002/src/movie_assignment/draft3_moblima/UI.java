package moblima;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UI {
	Scanner sc = new Scanner(System.in);
	loginApp l = new loginApp();
    cinemaApp c = new cinemaApp();
	ArrayList<Movie> MovieList = new ArrayList<Movie>();
	ArrayList<MovieSlot> MovieSlotList = new ArrayList<MovieSlot>();
	ArrayList<Customer> CustomerList = new ArrayList<Customer>();
	ArrayList<Cineplex> CineplexList = new ArrayList<Cineplex>();
	public int login() throws IOException {
			System.out.println("\n|=========================================|");
			System.out.println("|===============|Login Mode|==============|");
			System.out.println("|=========================================|");
			System.out.print("Username (enter -1 to register): ");
			
			String user;
			user = sc.next();
			if(user.equals("-1")) {
				System.out.print("Please enter a username: ");
				String newUser;
				newUser = sc.next();
				
				while(l.valid(newUser)==false) {
						System.out.println("Username has been used");
						System.out.print("Please enter another username: ");
						newUser = sc.next();
					}
				System.out.print("Please enter a password: ");
				String newPassword;
				newPassword = sc.next();
				System.out.println("Are you a new staff?\n1. yes\n2. no");
				int isStaff = sc.nextInt(); 
				if(isStaff == 1) {
					System.out.println("**For verification**");
					System.out.print("Please enter your staff ID: ");
					String staffId = sc.next();
					System.out.print("Please enter your name: ");
					String staffName = sc.next();
					if(l.validateStaff(staffId,staffName))
						l.assignLogin(newUser, newPassword, true);
					else
						System.out.println("Verification failed. Please try again!");
				}else
					l.assignLogin(newUser, newPassword,false);
			}else {
			
			System.out.print("Password: ");
			String pw;
			pw = sc.next();
			if(l.authenticate(user,pw)==1) {
				System.out.println("Admin login success");
				return 1;
			}
			else if(l.authenticate(user,pw)==2) {
				System.out.println("User login Successful");
				return 2;
			}
			else {
				System.out.println("Authentication failed, please try again");
				return 0;
			}			
			}
			return 0;
	}
	
	public void admin() {
		 int choice2;
			System.out.println("\n|=========================================|");
			System.out.println("|===============|Admin Mode|==============|");
			System.out.println("|=========================================|");
	        System.out.println("1. Show Preview movies\n"+
	                            "2. Show NOW_SHOWING movies\n"+
	                            "3. Show COMING_SOON movies\n"+
								"4. Show END OF SHOWING\n"+
	                            "5. Show all movies\n"+
	                            "6. Edit movie listing\n"+
	                            "7. Log out\n");
	        do {
	            System.out.println("Select action: ");
	            choice2 = sc.nextInt();
	            switch(choice2) {
	                case 1:
	                    //show preview movies
	                    c.showMovies(1);
	                    System.out.println();
	                    break;
	                case 2:
	                    //show NOW_SHOWING movies
	                	c.showMovies(2);
	                    System.out.println();
	                    break;
	                case 3:
	                    //show COMING_SOON movies
	                    c.showMovies(3);
	                    System.out.println();
	                    break;
					case 4:
						//show END_OF_SHOWING movies
						c.showMovies(4);
						System.out.println();
						break;
	                case 5:
	                    //show all
	                    c.showMovies(1);
	                    c.showMovies(2);
	                    c.showMovies(3);
	                    System.out.println();
	                    break;
	                case 6:
	                    //edit movie listing
	                    int a;
	                    do{
	                        System.out.println("Choose desired function:\n"+
	                                            "   (1) Create\n"+
	                                            "   (2) Update\n"+
	                                            "   (3) Remove\n"+
	                                            "   (4) Add movie review\n"+
	                                            "   (5) Quit editing");
	                        a = sc.nextInt();
	                        sc.nextLine();

	                        if (a==5) {
	                            System.out.println("Returning to main application..");
	                            a=9999;
	                        }
	                        else if (a>0 && a<5) {
	                            System.out.print("Enter name of movie: ");
	                            String name = sc.nextLine();
	                            if (a==1) { //create
	                                System.out.print("Enter director's name: ");
	                                String dirName = sc.nextLine();
	                                System.out.print("Enter cast: ");							                                
	                                String castName = sc.nextLine();
	                                System.out.print("Enter synopsis: ");
	                                String sypnosis = sc.nextLine();
	                                System.out.print("Enter price: ");
	                                double Price = sc.nextDouble();
	                                System.out.print("Enter status:\n"+
	                                                    "    (1) In PREVIEW\n"+
	                                                    "    (2) NOW SHOWING:\n"+
	                                                    "    (3) COMING SOON:\n"+
														"    (4) END OF SHOWING\n");
	                                int statusCreate = sc.nextInt();
	                                System.out.print("Enter movie type: \n"+
	                                                    "    (1) 3D\n"+
	                                                    "    (2) Blockbuster\n"+
	                                                    "    (3) Comedy\n"+
	                                                    "    (4) Horror\n"+
	                                                    "    (5) Exclusive\n");
	                                int typeCreate = sc.nextInt();
									System.out.print("Enter movie type: \n"+
                                            "    (1) G\n"+
                                            "    (2) PG\n"+
                                            "    (3) PG13\n"+
                                            "    (4) NC16\n"+
                                            "    (5) M18\n"+
                                            "    (6) R21\n");
                                 	int rating_guide = sc.nextInt();
									System.out.println("Enter movie language: ");
									String lang = sc.next();
									System.out.println("Enter movie runtime(in minutes: ");
									int rt = sc.nextInt();
                                 	c.createMovie(name, dirName, castName, sypnosis,
                                                     Price, statusCreate, typeCreate,// rating_guide,
                                                     lang, rt);
	                            }
	                            else if (a==2) { //update
	                                System.out.println("What to update?\n"+
	                                                    "    (1) Hall number\n"+
	                                                    "    (2) Status\n"+
	                                                    "    (3) Price\n"+
	                                                    "    (4) Timings");
	                                int numUpdate = sc.nextInt();
	                                switch(numUpdate) {
	                                    case 1:
	                                        System.out.println("Enter new hall number:");
	                                        int changeHall = sc.nextInt();
	                                        c.editMovie(a, name, numUpdate, (double)changeHall);
	                                        break;
	                                    case 2:
	                                        System.out.println("Enter new status:\n"+
																"(1) Preview\n"+
																"(2) NOW SHOWING\n"+
																"(3) COMING SOON\n"+
																"(4) END OF SHOWING\n");
	                                        int changeStat = sc.nextInt();
	                                        c.editMovie(a, name, numUpdate, (double)changeStat);
	                                        break;
	                                    case 3:
	                                        System.out.println("Enter new price:");
	                                        double changePr = sc.nextDouble();
	                                        c.editMovie(a, name, numUpdate, changePr);
	                                        break;
	                                    case 4:
	                                        do {
	                                            System.out.println("Enter timings: (Press -1 to exit)");
	                                            c.editMovie(a, null, sc.nextInt(), 0);
	                                        }while (sc.nextInt()!=-1);
	                                        System.out.println("Timings entered, exiting...");
	                                        break;
	                                }
	                            }
	                            else if (a==3) { //remove
	                                c.editMovie(a, name, 0, 0);
	                            }
	                            else { //a==4 edit reviews
									System.out.print("Displaying all reviews for movie: ");
									c.printReviews(name);
									System.out.println("Which review to delete?");
									int x = sc.nextInt();
									c.editMovie(1, name, x, 0);
	                            }
	                        }

	                        else {
	                            System.out.println("Invalid choice, try again.");
	                        }

	                    }while(a!=9999);
	                    break;
	                
	                case 7:
	                    System.out.println("Logged out successfully!");
	                    break;
	                default:
	                    System.out.println("Invalid choice, try again.");
	                    break;
	            }

	        }while (choice2!=7);
	}
	
	public void user(boolean userAcct) throws IOException {
		System.out.println("\n|=========================================|");
		if(userAcct)
			System.out.println("|===============|User Mode|===============|");
		else
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
    			   "8. Assign movie rating and review\n"); //require login function
		if(userAcct)
			System.out.println("9. Log out\n");
		else
			System.out.println("9. Return to main page");
		int choice2;
		do {
		System.out.println("Select action: ");
		choice2=sc.nextInt();
		switch(choice2) {
			case 1:
				System.out.println("Enter movie name: ");
				String search = sc.next();
				c.displayMovieDetail(search, MovieList);
				break;
			case 2:
				
				break;
			case 3:

				break;
			case 4:
				if(!userAcct) {
					int login =this.login();
					if(login ==1)
						this.admin();
					else if(login==2)
						this.user(true);
				}
				else {
					this.purchaseTickets();
				}
				break;

			case 5:
				if(!userAcct) {
				int login =this.login();
				if(login ==1)
					this.admin();
				else if(login==2)
					this.user(true);
			}
				else {
					this.ticketsHistory();
				}
				break;
			case 6://sales
		          c.displayTopSale(MovieList);
		          break;
		    case 7://rating
		          c.displayTopRate(MovieList);
		          break;
		    case 8:
		    	System.out.print("Enter a movie name: ");
		    	String movie = sc.next();
		    	if(c.searchMovie(movie)==-1)
		    		System.out.println("Movie not found!");
		    	else {
		    		System.out.print("Enter a rating: ");
		    		int rating = sc.nextInt();
		    		System.out.print("Enter a review: ");
		    		String review = sc.next();
		    		c.assignStats(movie, rating, review);
		    		c.updateOverallRating(movie);
		    		System.out.println("Thank you for your review and rating!");
		    		System.out.printf("Rating: %.2f", c.printRating(movie));
		    		
		    	}
			case 9:
				if(userAcct)
					System.out.println("Logged out successfully!");
				break;
			default:
				System.out.println("Invalid option, please try again.");
				break;
		}
		}while(choice2!=9);
	
	}
	
	public void purchaseTickets() {
		System.out.println("Enter your name");
		String name = sc.next();
		System.out.println("Enter your mobile phone number");
		String mobile = sc.next();
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
		System.out.println("1. Adult Ticket");
		System.out.println("2. Senior Ticket");
		System.out.println("3. Children Ticket");
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
	}
	
	public void ticketsHistory() {
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
			return;
		if (currentUser.getBookingHistory().isEmpty()) {
			System.out.println("No bookings available");
			return;
		}
		for (Ticket tk : currentUser.getBookingHistory()) {
			System.out.println("Ticket " + (currentUser.getBookingHistory().indexOf(tk) + 1));
			try {
				tk.printTicket();
			} catch (NullPointerException e) {
				System.out.println("Fail to purchase");
			}
		}
	}
}
