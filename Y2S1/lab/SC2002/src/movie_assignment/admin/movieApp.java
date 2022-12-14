/*
 * video -> movie -> cinema & movieApp
 * set total number of cinemas available = 10
 * set total number of movies available for viewing = 15
 * assign each movie to a fixed cinema Hall
 * set cinema opening hours from 0900-0000 (for showtimes) (movie must end by 0000 !!)
 * set number of showtimes a day <= 5 because some shows are up to 3h long
 * manually key in the showtimes in 24h format (to separate the genres)
 *                                              eg. horror only shown at night
 * 
 */

package movie_assignment.admin;
import java.util.*;

public class movieApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        cinema cinema = new cinema();
        System.out.println("(1) Show Preview movies\n"+
                            "(2) Show NOW_SHOWING movies\n"+
                            "(3) Show COMING_SOON movies\n"+
                            "(4) Show all movies\n"+
                            "(5) Edit movie listing\n"+
                            "(0) Close current application\n");
        do {
            System.out.println("Enter the number of choice: ");
            choice = sc.nextInt();
            switch(choice) {
                case 1:
                    //show preview movies
                    cinema.showMovies(1);
                    System.out.println();
                    break;
                case 2:
                    //show NOW-SHOWING movies
                    cinema.showMovies(2);
                    System.out.println();
                    break;
                case 3:
                    //show COMING_SOON movies
                    cinema.showMovies(3);
                    System.out.println();
                    break;
                case 4:
                    //show all
                    cinema.showMovies(1);
                    cinema.showMovies(2);
                    cinema.showMovies(3);
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
                                            "       (5) Quit editing.");
                        a = sc.nextInt();
                        sc.nextLine();

                        if (a==5) {
                            System.out.println("Returning to main application..");
                            a=9999;
                        }
                        else if (a>0 && a<5) {
                            System.out.println("Enter name of movie");
                            String name = sc.nextLine();
                            if (a==1) { //create
                                System.out.println("Enter director's name: \n"+
                                                    "Enter cast: \n"+
                                                    "Enter synopsis: \n"+
                                                    "Enter price\n"+
                                                    "Enter status: \n"+
                                                    "Enter movie type: \n"+
                                                    "    (1) 3D\n"+
                                                    "    (2) Blockbuster\n"+
                                                    "    (3) Comedy\n"+
                                                    "    (4) Horror\n"+
                                                    "    (5) Exclusive");
                                String dirName = sc.nextLine();
                                String castName = sc.nextLine();
                                String sypnosis = sc.nextLine();
                                double Price = sc.nextDouble();
                                int statusCreate = sc.nextInt();
                                int typeCreate = sc.nextInt();
                                cinema.createMovie(name, dirName, castName, sypnosis,
                                                    Price, statusCreate, typeCreate);

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
                                        cinema.editMovie(a, name, numUpdate, (double)changeHall);
                                        break;
                                    case 2:
                                        System.out.println("Enter new status:");
                                        int changeStat = sc.nextInt();
                                        cinema.editMovie(a, name, numUpdate, (double)changeStat);
                                        break;
                                    case 3:
                                        System.out.println("Enter new price:");
                                        double changePr = sc.nextDouble();
                                        cinema.editMovie(a, name, numUpdate, changePr);
                                        break;
                                    case 4:
                                        do {
                                            System.out.println("Enter timings: (Press -1 to exit)");
                                            cinema.editMovie(a, null, sc.nextInt(), 0);
                                        }while (sc.nextInt()!=-1);
                                        System.out.println("Timings entered, exiting...");
                                        break;
                                }
                            }
                            else if (a==3) { //remove
                                cinema.editMovie(a, name, 0, 0);
                            }
                            else { //a==4 add review
                                System.out.println("Enter movie review: ");
                                String review = sc.nextLine();
                                cinema.editMovie(2, review, 4, 0);
                            }
                        }

                        else {
                            System.out.println("Invalid choice, try again.");
                        }

                    }while(a!=9999);
                    break;
                
                case 0:
                    System.out.println("System shutting down...");
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
                    break;
            }

        }while (choice!=0);

        sc.close();
    }
}