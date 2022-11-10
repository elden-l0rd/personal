package moblima;


public class SeatApp {
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    private static final int totalRows = 10;
    private static final int totalCols = 16;
	
	private Seat[][] s = new Seat[totalRows][totalCols];

	//initialise all seats to unoccupied
	public SeatApp() {
		for (int i=0; i<totalRows; i++)
			for (int k=0; k<totalCols; k++) {
				if ((i>5) && (i<9)) s[i][k] = new Seat(false, true); //A-C couple seats
				else s[i][k] = new Seat(false, false); //non-couple seats
			}
	}

	
	public void printSeats() {
        System.out.println("   ---------------------Screen-----------------------");
        System.out.println("   --------------------------------------------------\n");
        System.out.println("    1  2  3  4  5  6  7  8   9  10 11 12 13 14 15 16  ");
        
        char j = 'J';
        for (int x=0; x<10; x++) {	//rows A-J
        	System.out.printf("%c", j-x);
        	System.out.print("  ");
        	for (int y=0; y<8; y++) {
        		if ((x<4) && (y<2)) System.out.print("   ");
        		else if (!s[x][y].getIsOccupied()) System.out.print(" o ");
        		else System.out.print(" x ");
        	}
        	System.out.print(" "); // aisle
        	for (int z=0; z<8; z++) {
        		if ((x==9) && (z<2)) System.out.print("   ");
        		else if (!s[x][z].getIsOccupied()) System.out.print(" o ");
        		else System.out.print(" x ");
        	}
        	System.out.print("  ");
        	System.out.printf("%c", j-x);
        	System.out.print("\n");
        }
        System.out.print("\n");
        System.out.println("   --------------------Entrance---------------------");
        System.out.println("\nKEY- o =unbook, x = booked");
	}


}
