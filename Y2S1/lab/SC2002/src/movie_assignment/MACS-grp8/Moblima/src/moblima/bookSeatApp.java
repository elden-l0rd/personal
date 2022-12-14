package moblima;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class bookSeatApp {
	
	public boolean validateSeats(String movie,String time, String row, String col) {
		BufferedReader reader = null;
		String line, m, t, r, c;
		try {
			reader = new BufferedReader(new FileReader("seatData.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			while ((line = reader.readLine()) != null) {
				m = line.split(" ")[0];
				t = line.split(" ")[1];
				r = line.split(" ")[2];
				c = line.split(" ")[3];
				
				// occupied seat			
				if (m.equals(movie) && t.equals(time) && r.equals(row) && c.equals(col)) {
					reader.close();
					return false;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true; //unoccupied seat
	}

	
	
	public void assignSeats(String movie, String time, String row, String col) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter("seatData.txt", true));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		try {
			movie = movie.replaceAll("\\s", "");
			writer.write(movie + " " + time + " " + row + " " + col);
			writer.newLine();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	


}

