package admin;
import java.util.Scanner;

public class login {
	public static void main(String[]args) {
	//System staff needs to login to access its functions
	Scanner sc = new Scanner(System.in);
	loginApp l = new loginApp();
	int choice;
	
	System.out.println("Welcome to admin login, please enter the following options:\n 1. Login\n 2. Register");
	//3. Delete User?
	choice = sc.nextInt();
	while(choice != 2 && choice != 1) {
		System.out.println("Please enter a valid input");
		choice = sc.nextInt();
	}
	switch(choice) {
		case 1:
			System.out.println("hello");
			break;
		case 2:
			System.out.println("Please enter a username:");
			String newUser;
			newUser = sc.next();
			
			//validity check 
//			if(false) {
//				System.out.println("Username has been used");
//				System.out.println("Please enter another username:");
//				newUser = sc.next();
//			}
			System.out.println("Please enter a password:");
			String newPassword;
			newPassword = sc.next();
			//strength of password?
			//double check password?
			
			
			break;
		}
	}

}
