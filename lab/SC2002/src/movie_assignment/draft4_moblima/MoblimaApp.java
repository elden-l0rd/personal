package moblima;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.*;

import admin.login;


public class MoblimaApp {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

        UI ui = new UI();
        cinemaApp c = new cinemaApp();
        int login = 0;

        //////////////////////////////////////////////

        /////////////////////////////////////////////
        
        
        
        
		
		boolean exit = false;
		while (exit == false) {
			System.out.println("|======================================|");
			System.out.println("|=========|Welcome to MOBLIMA|=========|");
			System.out.println("|======================================|\n" + 
					"\n\n" +
					"Please select option:\n" +
					"1. Login\n" +
					"2. Guest View\n" +
					"3. Exit Application\n");
			System.out.print("Select action: ");
			int choice=sc.nextInt();
			switch(choice) {
				case 1:
					login = ui.login();
					if(login==1)
						ui.admin();
					else if(login==2)
						ui.user(true);
					break;
				case 2:
					ui.user(false);
					break;
				case 3:
					exit = true;
					System.out.println("Exiting MOBLIMA");
					System.out.println("Goodbye!");
					break;
				default:
					System.out.println("Wrong input!");
				}
			}
		sc.close();
	}

	/*
	 * 1. cineplex
	 * 2. price (age & holiday)
	 * 3. reviews
	 * 4. int -> dbl for score
	 */
}