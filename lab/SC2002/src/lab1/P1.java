package lab1;

import java.util.*;

public class P1 {

	public static void main(String[] args) {
		P1 ob = new P1();
		Scanner sc = new Scanner(System.in);
		char choice;
		System.out.println("Enter a character: ");
		choice = sc.next().charAt(0);
		ob.statement(choice);
		sc.close(); //close scanner to avoid resource leak;

	}
	
	void statement(char in) {
		switch(in) {
		case 'A':
		case 'a':
			System.out.println("Action movie fan");
			break;
		case 'C':
		case 'c':
			System.out.println("Comedy movie fan");
			break;
		case 'D':
		case 'd':
			System.out.println("Drama movie fan");
			break;
		
		default:
			System.out.println("Invalid choice");
		}
			
	}	

}