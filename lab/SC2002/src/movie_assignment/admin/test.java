package movie_assignment.admin;
import java.util.*;

public class test {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int choice;
        
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
