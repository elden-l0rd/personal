import java.util.*;
public class PlaneSeat {
	private static int seatId;
	private boolean assigned;
	private static int customerId;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PlaneSeat ob = new PlaneSeat();

		
		sc.close();
	}
	
	public int getSeatID();
	
	public int getCustomerID();
	
	public boolean isOccupied();
	
	public void assign(int cust_id);
	
	public void unAssign();

}
