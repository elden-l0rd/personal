package admin;
import java.util.Scanner;

public class login {
	public static void main(String[]args) {
	Scanner sc = new Scanner(System.in);
	loginApp l = new loginApp();
	int choice;
	boolean login = false;
	
	System.out.println("Welcome to admin login, please enter the following options:\n (1) Login\n (2) Register");	
	do {
		System.out.println("Please enter the number of your choice");
		choice = sc.nextInt();

	switch(choice) {
		case 1:
			System.out.print("Username: ");
			String user;
			user = sc.next();
			System.out.print("Password: ");
			String pw;
			pw = sc.next();
			if(l.authenticate(user,pw)==true) {
				login = true;
				System.out.println("Login success");
			}
			else
				System.out.println("Authentication failed, please try again");
			break;
		case 2:
			System.out.print("Please enter a username: ");
			String newUser;
			newUser = sc.next();
			
			while(l.valid(newUser)==false) {
					System.out.println("Username has been used");
					System.out.print("Please enter another username: ");
					newUser = sc.next();
				}
			System.out.print("Please enter a password: ");
			String newPassword;
			newPassword = sc.next();
			l.assignLogin(newUser, newPassword);
			break;
			}
		}while(login==false);
	
	System.out.println("Thank your for using MOBLIMA");
	sc.close();
	}

}
