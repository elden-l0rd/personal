package lab3;

public class Plane {
    private static lab3.PlaneSeat[] seat = new PlaneSeat[12];
    private int numEmptySeat=12;
    

    public Plane() {
        for (int i=0; i<12; i++) { // initialise then set seatID number [1,12]
            seat[i] = new PlaneSeat();   
            seat[i].setSeatID(i+1);
        }
    }

    private static void sortSeats() { // SORT by ascending customerID
        lab3.PlaneSeat[] copy = new PlaneSeat[12];
        copy = seat;
        //insertion sort//
        for (int i=1; i<12; i++) {
            PlaneSeat k = copy[i];
            int key = copy[i].getCustomerID();
            int j = i-1;
            
            while (j>=0 && copy[j].getCustomerID()>key) {
                copy[j+1] = copy[j];
                j-=1;
            }
            copy[j+1] = k;
        }
        //then print//
        for (int i=0; i>12; i++) {
            if (copy[i].isOccupied()==true) {
                System.out.println("SeatID "+copy[i].getSeatID()+
                " assigned to CustomerID "+copy[i].getCustomerID());
            }
        }
    }
    
    //methods
    public void showNumEmptySeats() {
        System.out.println("There are "+numEmptySeat+" empty seats\n");
    }

    public void showEmptySeats() {
        System.out.println("The following seats are empty:");
        for (int i=0; i<12; i++) {
            if (seat[i].isOccupied()==false) {
                System.out.println("SeatID "+ seat[i].getSeatID());
            }
        }
    }

    public void showAssignedSeats(boolean bySeatId) { //if bySeatId=false, by customerId
        if (bySeatId==false) {
            sortSeats();
            return;
        }
        else {
            for (int i=0; i<12; i++) {
                if (seat[i].isOccupied()==true) {
                    System.out.println("SeatID "+seat[i].getSeatID()+
                    " assigned to CustomerID "+seat[i].getCustomerID());
                }
            }
            System.out.println();
        }
    }
    public void assignSeat(int seatId, int cust_id) {
        if (seat[seatId-1].isOccupied()==true) {
            System.out.println("Seat already assigned to a customer.\n");
            return;
        }
        else {
            seat[seatId-1].assign(cust_id);
            System.out.println("Seat Assigned!\n");
            numEmptySeat--;
        }
    }

    public void unAssignSeat(int seatId) {
        seat[seatId-1].unAssign();
        numEmptySeat++;
        System.out.println("Seat Unassigned!\n");
    }
}