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

        System.out.println("(1) Show movie list\n"+
                            "(2) Show NOW_SHOWING movies\n"+
                            "(3) Edit movie listing\n"+
                            "(0) Close current application\n");
        do {
            System.out.println("Enter the number of choice: ");
            choice = sc.nextInt();
            switch(choice) {
                case 1:
                    //Show movie list
                    break;
                case 2:
                    //Show NOW-SHOWING movies
                    break;
                case 3:
                    //Edit movie listing
                    int a;
                    do{
                        System.out.println("Choose desired function:\n"+
                                            "(1) Create\n"+
                                            "(2) Update\n"+
                                            "(3) Remove\n"+
                                            "(4) Quit editing.");
                        a = sc.nextInt();
                        switch(a) {
                            case 1:
                                //create
                                break;
                            case 2:
                                //update
                                break;
                            case 3:
                                //remove
                                break;
                            case 4:
                                System.out.println("Returning to main application..");
                                a=9999;
                                break;
                            default:
                                System.out.println("Choice is invalid, try again.");
                                break;
                        }
                    }while(a!=9999);
                    break;
                
                case 0:
                    System.out.println("System shutting down...");
                    return;
                default:
                    System.out.println("Choice is invalid, try again.");
                    break;
            }

        }while (choice!=0);

        sc.close();
    }
}
