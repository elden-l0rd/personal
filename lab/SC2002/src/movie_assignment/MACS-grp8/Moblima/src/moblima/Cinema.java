package moblima;

import java.util.*;

public class Cinema {
	
	private String id;
	private String showtime;
	private List<Seat> seatList;
    private ArrayList<MovieSlot> movieSlots;
	private Cineplex cineplex;
	private CinemaClass cinemaclass;
	
	//TEST//
    public Cinema(Cineplex cineplex, String cinemaID, CinemaClass cinemaclass) {
        super();
        this.cineplex = cineplex;
        this.id = cinemaID;
        this.cinemaclass = cinemaclass;
        this.movieSlots = new ArrayList<MovieSlot>();
    }
   
	public Cinema (String id, String showtime, int rowLim, int numLim)
	{
		this.id = id;
		this.showtime = showtime;
		seatdisplay (rowLim, numLim);	
        this.movieSlots = new ArrayList<MovieSlot>();
	}

	public Cinema (String id, String showtime, List<Seat> seatList) 
	{
		this.id = id;
		this.showtime = showtime;
		this.seatList = seatList;
	}

	private void seatdisplay (int rowLim, int numLim)
	{
		seatList = new ArrayList<Seat>(rowLim * numLim);
		char row = 'A';
		for (int i = 0; i < rowLim; i++)
			for (int j = 0; j < numLim; j++)
			{
				String seatID = Character.toString((char) (row + i)) + (j + 1);
				Seat newSeat = new Seat(seatID);
				seatList.add(newSeat);
			}
	}

	public String getCinemaID ()
	{
		return id;
	}

	public String getShowtime ()
	{
		return showtime;
	}
	
	public List<Seat> getSeatList ()
	{
		return seatList;
	}

	public void setCinemaID (String id)
	{
		this.id = id;
	}

	public void setShowtime (String showtime)
	{
		this.showtime = showtime;
	}
	
	public int countRows() 
	{
		int count = 0;
		String firstrowChar = seatList.get(0).getId().substring(0,1);
		for(Seat seat : seatList) {
			if(seat.getId().substring(0,1).equals(firstrowChar))
				count++;
			else
				break;
		}
		return count;
	}

	public void printSeats(int rowLim) {
		List<String> occupiedSeat = new ArrayList();
		char row = 'A';
		int numLim = seatList.size() / rowLim;
		for(Seat seat : seatList) {
			if(seat.getIsOccupied())
				occupiedSeat.add(seat.getId());
		}
		System.out.print("\t");
		for (int i = 0; i < 3 * rowLim + 3; i++)
			System.out.print("#");
		System.out.print("\n\t# ");
		for (int i = 0; i < 3 * rowLim - 1; i++) {
				System.out.print("~");
		}
		System.out.println(" #");
		for (int i = 0; i < numLim; i++) {
			System.out.print("\t# ");
			for (int j = 0; j < rowLim; j++) {
				boolean occupied = false;
				String seatId = Character.toString((char) (row + i)) + (j + 1);
				for(String id : occupiedSeat) {
					if(id.equals(seatId)) 
						occupied = true;
				}
				if(occupied)
					System.out.print("XX");
				else
					System.out.print(seatId);
				System.out.print(" ");
			}
			System.out.println("#");
		}
		System.out.print("\t");
		for (int i = 0; i < 3 * rowLim + 3; i++)
			System.out.print("#");
		System.out.println();
	}
	
	
    public ArrayList<MovieSlot> getMovieSlots() {
        return movieSlots;
    }

    public void setMovieSlots(ArrayList<MovieSlot> movieSlots) {
        this.movieSlots = movieSlots;
    }

    public void addMovieSlot(MovieSlot mv) {
        movieSlots.add(mv);
    }
	
	
	
}