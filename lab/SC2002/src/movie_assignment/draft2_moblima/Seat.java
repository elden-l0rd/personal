package moblima;

import java.util.*;

public class Seat {
	
	//private String ID;
	private int row;
	private int col;
	private boolean isOccupied = false;
	/*
	public Seat (String ID)
	{
		this.ID = ID;
	}
	*/
	public Seat (int rownum,int colnum, boolean isOccupied) 
	{
		this.row = rownum;
		this.col = colnum;
		this.isOccupied = isOccupied;
	}
	
	/*
	public String getId ()
	{
		
		return (this.row+this.col);
	}
	*/
	public int getRow() {
		return this.row;
	}
	public int getCol() {
		return this.col;
	}
	public boolean isOccupied ()
	{
		return isOccupied;
	}
	public void bookSeat ()
	{
		isOccupied = true;
	}
	public void unbookSeat ()
	{
		isOccupied = false;
	}
	
	//row A-J col 1-8
	//A-C couple seat
	public void printSeats(Seat[][] Seats) {
        System.out.println("-----------Screen-----------");
        System.out.println("  1  2    3  4  5  6    7  8");

        char rowChar = 'A';
        for (int item = 0; item < 8; item++) {
            System.out.print(rowChar);
            rowChar++;
            for (int j = 0; j < 8; j++) {
                if (j == 2 || j == 6)
                    System.out.print("  ");

                if (!Seats[item][j].isOccupied())
                    System.out.print(" o ");
                
                else
                    System.out.print(" x ");
            }
            System.out.println(" ");
        }
        System.out.println("KEY- o =unbook, x = booked");
	}

}