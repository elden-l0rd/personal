package lab3;

public class Plane {
    private PlaneSeat[] seat;
    private int numEmptySeat=12;
    

    public Plane() {
        seat = new PlaneSeat[12];
        for (int i=0; i<12; i++) { // initialise then set seatID number [1,12]   
            seat[i] = new PlaneSeat(i+1);
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

    private void sortSeats() {
        PlaneSeat[] copy = new PlaneSeat[12];
		PlaneSeat tmp;
		
		for(int i=0; i<12; i++) {
			copy[i] = seat[i];
		}
		
        //insertion sort
		for(int i=1; i<12; i++)
		{
			for(int j=i; j>0; j--)
			{
				if(copy[j].getCustomerID() < copy[j-1].getCustomerID()) {
					tmp = copy[j];
					copy[j] = copy[j-1];
					copy[j-1] = tmp;
				}
				else break;
			}
		}
        //then print
        for (int i=0; i<12; i++) {
            if (copy[i].isOccupied()==true) {
                System.out.println("SeatID "+copy[i].getSeatID()+
                " assigned to CustomerID "+copy[i].getCustomerID());
            }
        }
        System.out.println();
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
        if (seat[seatId-1].isOccupied()) {
            System.out.println("Seat already assigned to a customer.\n");
        }
        else {
            seat[seatId-1].assign(cust_id);
            System.out.println("Seat Assigned!\n");
            numEmptySeat--;
        }
    }

    public void unAssignSeat(int seatId) {
        if (seat[seatId-1].isOccupied()) {
            //
            seat[seatId-1].unAssign();
            numEmptySeat++;
        }
        System.out.println("Seat Unassigned!\n");
    }
}