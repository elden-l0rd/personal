package movie_assignment.draft1_movie;
import java.util.*;

public class loginApp {
	private staff[] s = new staff[15];
	
	Scanner sc = new Scanner(System.in);
	
	public loginApp() {
		for(int i=0; i<15; i++)
			s[i]=new staff("0","0");
	}
	
	public void assignLogin(String userName, String password) {
		for(int i=0; i<15; i++) {
			if(s[i].getUserName()=="0") {
				s[i].assign(userName, password);
				System.out.println("User " + userName + " successfully created!");
				break;
			}
		}
	}
	
	public boolean authenticate(String userName, String password) {
		for(int i=0; i<15; i++) {
//			System.out.print(s[i].getUserName());
//			System.out.print(userName);
//			System.out.println(s[i].getUserName().equals(userName));
			if(s[i].getUserName().equals(userName) && s[i].getPassword().equals(password))
				return true;
		}return false;
	}
	
	public boolean valid(String userName) {
		for(int i=0; i<15; i++) {
			if(s[i].getUserName().equals(userName))
				return false;
		}return true;
	}
}
