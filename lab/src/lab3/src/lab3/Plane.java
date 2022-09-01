package lab3;

public class Plane {
    private static lab3.PlaneSeat[] seat = new PlaneSeat[12];
    private int numEmptySeat=12;
    

    public Plane() {
        for (int i=0; i<12; i++) {
            seat[i].seatId = i+1;   // initialise seatID number [1,12]
        }
    }

    private void sortSeats() { // SORT by ascending customerID
        lab3.PlaneSeat[] copy = new PlaneSeat[12];
        copy = seat;
        // ** sorting algorithm TODO ** //
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
        if (bySeatId==false)
            sortSeats();
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
        seat[seatId].assign(cust_id);
    }

    public void unAssignSeat(int seatId) {
        seat[seatId].unAssign();
    }
}