package moblima;

public class Seat {
	private int row;
	private int col;
	private boolean isOccupied = false;
	private boolean isCouple = false;

	
	public Seat(boolean isOccupied, boolean isCouple)
	{
		this.isOccupied = isOccupied;
		this.isCouple = isCouple;
	}
	public int getRow() {
		return this.row;
	}
	public int getCol() {
		return this.col;
	}

	public void bookSeat ()
	{
		isOccupied = true;
	}
	public void unbookSeat ()
	{
		isOccupied = false;
	}
	
	public boolean getIsOccupied()
	{
		return isOccupied;
	}
	public boolean getIsCouple()
	{
		return isCouple;
	}


}