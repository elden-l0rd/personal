package lab3;

public class Plane {
    private lab3.PlaneSeat[] seat = new PlaneSeat[12];
    private int numEmptySeat=12;
    

    public Plane() {
        for (int i=0; i<12; i++) {
            seat[i].seatId = i+1;   // initialise seatID number [1,12]
        }
    }

    private void sortSeats() { // SORT by ascending customerID
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
        System.out.println("There are "+numEmptySeat+" seats");
    }

    public void showEmptySeats() {
        for (int i=0; i<12; i++) {
            if (seat[i].isOccupied()==false) {
                System.out.println("SeatID "+(i+1));
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
        }
    }
    public void assignSeat(int seatId, int cust_id) {
        if (seat[seatId].isOccupied()==true) {
            System.out.println("Seat Assigned!");
            return;
        }
        else {
            seat[seatId].assign(cust_id);
            numEmptySeat--;
        }
    }

    public void unAssignSeat(int seatId) {
        seat[seatId].unAssign();
        numEmptySeat++;
        System.out.println("Seat Unassigned!");
    }
}