/*
 * set total number of cinemas available = 10
 * set total number of movies available for viewing = 15
 * assign each movie to a fixed cinema Hall
 * set cinema opening hours from 0900-0100
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
                    break;
                case 2:
                    //show NOW-SHOWING movies
                    cinema.showMovies(1);
                    break;
                case 3:
                    //show COMING_SOON movies
                    cinema.showMovies(2);
                    break;
                case 4:
                    //show all
                    cinema.showMovies(1);
                    cinema.showMovies(2);
                    cinema.showMovies(3);
                    break;
                case 5:
                    //edit movie listing
                    int a;
                    do{
                        System.out.println("    Choose desired function:\n"+
                                            "       (1) Create\n"+
                                            "       (2) Update\n"+
                                            "       (3) Remove\n"+
                                            "       (4) Quit editing.");
                        a = sc.nextInt();

                        if (a==4) {
                            System.out.println("Returning to main application..");
                            a=9999;
                        }
                        else if (a>0 && a<4) {
                            System.out.println("Enter name of movie");
                            String name = sc.nextLine();
                            if (a==1) {
                                //alr got name
                                //left director, cast, synopsis, status, price, type
                                //initialise ratings to 0
                                cinema.editMovie(a, name, choice, a);

                            }
                            if (a==2) {
                                System.out.println("        What to update?\n"+
                                                    "           (1) Hall number\n"+
                                                    "           (2) Status"+
                                                    "           (3) Price");
                                int updatenum = sc.nextInt();
                                switch(updatenum) {
                                    case 1:
                                        System.out.println("Enter new hall number:");
                                        int changeHall = sc.nextInt();
                                        cinema.editMovie(a, name, updatenum, (double)changeHall);
                                        break;
                                    case 2:
                                        System.out.println("Enter new status:");
                                        int changeStat = sc.nextInt();
                                        cinema.editMovie(a, name, updatenum, (double)changeStat);
                                        break;
                                    case 3:
                                        System.out.println("Enter new price:");
                                        double changePr = sc.nextDouble();
                                        cinema.editMovie(a, name, updatenum, changePr);
                                        break;
                                }
                            }
                            if (a==3) {
                                cinema.editMovie(a, name, 0, 0);
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
