package lab3;

public class PlaneSeat {
	private int seatId;
	private boolean assigned=false;
	private int customerId;
	
    //methods
	public int getSeatID() {
        if (assigned==true)
            return seatId;
        else return 0;
    }
	
	public int getCustomerID() {
        if (assigned==true)
            return customerId;
        else return 0;
    }
	
	public boolean isOccupied() {
        if (assigned==true)
            return true;
        else return false;
    }
	
	public void assign(int cust_id) {
        assigned=true;
        customerId=cust_id;
    }
	
	public void unAssign() {
        assigned=false;
    }

    public void setSeatID (int id) {
        seatId = id;
    }
}