package moblima;

import java.time.LocalDate;
import java.util.*;

import admin.login;


public class MoblimaApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Movie> MovieList = new ArrayList<Movie>();
		ArrayList<MovieSlot> MovieSlotList = new ArrayList<MovieSlot>();
		ArrayList<Customer> CustomerList = new ArrayList<Customer>();
		ArrayList<Cineplex> CineplexList = new ArrayList<Cineplex>();
		loginApp l = new loginApp();
        cinemaApp c = new cinemaApp();

		
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
					int choice1;
					do {
						System.out.println("\n|=========================================|");
						System.out.println("|===============|Admin Mode|==============|");
						System.out.println("|=========================================|");
						System.out.print("\n"+
								   "1. Login\n"+
								   "2. Register\n"+
								   "3. Exit\n");
						System.out.println("Select action: ");	
						choice1 = sc.nextInt();

					switch(choice1) {
						case 1:
							System.out.print("Username: ");
							String user;
							user = sc.next();
							System.out.print("Password: ");
							String pw;
							pw = sc.next();
							if(l.authenticate(user,pw)==true) {
								System.out.println("Login success");
								 int choice2;
							        System.out.println("(1) Show Preview movies\n"+
							                            "(2) Show NOW_SHOWING movies\n"+
							                            "(3) Show COMING_SOON movies\n"+
							                            "(4) Show all movies\n"+
							                            "(5) Edit movie listing\n"+
							                            "(0) Close current application\n");
							        do {
							            System.out.println("Enter the number of choice: ");
							            choice2 = sc.nextInt();
							            switch(choice2) {
							                case 1:
							                    //show preview movies
							                    c.showMovies(1);
							                    System.out.println();
							                    break;
							                case 2:
							                    //show NOW-SHOWING movies
							                	c.showMovies(2);
							                    System.out.println();
							                    break;
							                case 3:
							                    //show COMING_SOON movies
							                    c.showMovies(3);
							                    System.out.println();
							                    break;
							                case 4:
							                    //show all
							                    c.showMovies(1);
							                    c.showMovies(2);
							                    c.showMovies(3);
							                    System.out.println();
							                    break;
							                case 5:
							                    //edit movie listing
							                    int a;
							                    do{
							                        System.out.println("    Choose desired function:\n"+
							                                            "       (1) Create\n"+
							                                            "       (2) Update\n"+
							                                            "       (3) Remove\n"+
							                                            "       (4) Add movie review\n"+
							                                            "       (5) Quit editing");
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
							                                                    "    (3) COMING SOON:\n");
							                                int statusCreate = sc.nextInt();
							                                System.out.print("Enter movie type: \n"+
							                                                    "    (1) 3D\n"+
							                                                    "    (2) Blockbuster\n"+
							                                                    "    (3) Comedy\n"+
							                                                    "    (4) Horror\n"+
							                                                    "    (5) Exclusive\n");
							                                int typeCreate = sc.nextInt();
							                                System.out.print("Enter a hall: ");
							                                int hall = sc.nextInt();
							                                c.createMovie(name, dirName, castName, sypnosis,
							                                                    Price, statusCreate, typeCreate, hall);

							                            }
							                            else if (a==2) { //update
							                                System.out.println("        What to update?\n"+
							                                                    "           (1) Hall number\n"+
							                                                    "           (2) Status\n"+
							                                                    "           (3) Price\n"+
							                                                    "           (4) Timings");
							                                int numUpdate = sc.nextInt();
							                                switch(numUpdate) {
							                                    case 1:
							                                        System.out.println("Enter new hall number:");
							                                        int changeHall = sc.nextInt();
							                                        c.editMovie(a, name, numUpdate, (double)changeHall);
							                                        break;
							                                    case 2:
							                                        System.out.println("Enter new status:");
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
							                            else { //a==4 add review
							                                System.out.println("Enter movie review: ");
							                                String review = sc.nextLine();
							                                c.editMovie(2, review, 4, 0);
							                            }
							                        }

							                        else {
							                            System.out.println("Invalid choice, try again.");
							                        }

							                    }while(a!=9999);
							                    break;
							                
							                case 0:
							                    System.out.println("System shutting down...");
							                    break;
							                default:
							                    System.out.println("Invalid choice, try again.");
							                    break;
							            }

							        }while (choice2!=0);
							}
							else
								System.out.println("Authentication failed, please try again");
							break;
						case 2:
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
							l.assignLogin(newUser, newPassword);
							break;
							}
						}while(choice1!=3);
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
							System.out.println("Enter movie name: ");
							String search = sc.next();
							c.displayMovieDetail(search, MovieList);
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
						case 6://sales
					          c.displayTopSale(MovieList);
					          break;
					    case 7://rating
					          c.displayTopRate(MovieList);
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