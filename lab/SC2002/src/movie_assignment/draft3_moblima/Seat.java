package moblima;

public class Seat {
	private boolean isOccupied = false;
	private boolean isCouple = false;

	
	public Seat(boolean isOccupied, boolean isCouple) 
	{

		this.isOccupied = isOccupied;
		this.isCouple = isCouple;
	}

	public boolean getIsOccupied()
	{
		return isOccupied;
	}
	public boolean getIsCouple()
	{
		return isCouple;
	}

	public void assignSeat()
	{
		this.isOccupied = true;
	}
	


}