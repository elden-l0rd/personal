package lab3;
import java.util.*;

/*
 * case 4 -> NOT PRINTING..
 * case 2 -> SeatID 0 ??!?
 */



public class PlaneApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        Plane Plane = new Plane();
        System.out.println("(1) Show number of empty seats");
        System.out.println("(2) Show the list of empty seats");
        System.out.println("(3) Show the list of seat assignments by seat ID");
        System.out.println("(4) Show the list of seat assignments by customer ID");
        System.out.println("(5) Assign a customer to a seat");
        System.out.println("(6) Remove a seat assignment");
        System.out.println("(7) Exit");
        do {
            System.out.print("    Enter the number of your choice: ");
            choice = sc.nextInt();
            switch(choice) {
                case 1:
                    Plane.showNumEmptySeats();
                    break;
                case 2:
                    Plane.showEmptySeats();
                    break;
                case 3:
                    System.out.println("The seat assignments are as follows:");
                    Plane.showAssignedSeats(true);
                    break;
                case 4:
                    System.out.println("The seat assignments are as follows:");
                    Plane.showAssignedSeats(false);
                    break;
                case 5:
                    int sid, cid;
                    System.out.println("Assigning Seat ..");
                    System.out.print("    Please enter SeatID: ");
                    sid = sc.nextInt();
                    System.out.print("    Please enter CustomerID: ");
                    cid = sc.nextInt();
                    Plane.assignSeat(sid, cid);
                    break;
                case 6:
                    System.out.print("Enter SeatID to unassign customer from: ");
                    int sd = sc.nextInt();
                    System.out.println();
                    Plane.unAssignSeat(sd);
                    break;
                case 7:
                    return;
            }
        }while(choice<8 && choice>0);

        sc.close();
    }
}