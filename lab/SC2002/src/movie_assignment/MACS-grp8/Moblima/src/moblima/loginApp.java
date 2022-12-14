package moblima;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class loginApp {
	Scanner sc = new Scanner(System.in);
	
	public void assignLogin(String userName, String password, boolean staff) throws IOException {
	    BufferedWriter writer = new BufferedWriter(new FileWriter("userData.txt", true));
	    writer.write(userName + " " + password + " " + staff);
	    writer.newLine();
	    writer.close();
		System.out.println("User " + userName + " successfully created!");
	}
	
	public boolean validateStaff(String staffId, String staffName) throws IOException {
		FileReader fr = new FileReader("staffData.txt");
		BufferedReader br = new BufferedReader(fr);
	    String line, id, name;
	    while ((line = br.readLine()) != null) {
	    	id = line.split(" ")[0].toLowerCase();
	    	name = line.split(" ")[1].toLowerCase();
	    	if(id.equals(staffId) && name.equals(staffName)) 
	    		br.close();
	    		return true;
	}br.close();
	    return false;
	}
	
	public int authenticate(String userName, String password) throws IOException {
	    FileReader fr = new FileReader("userData.txt");
		BufferedReader br = new BufferedReader(fr);
	    String line, user, pass, staffcheck;
	    while ((line = br.readLine()) != null) {
	    	user = line.split(" ")[0].toLowerCase();
	    	pass = line.split(" ")[1].toLowerCase();
	    	staffcheck = line.split(" ")[2].toLowerCase();
	    	if(user.equals(userName) && pass.equals(password)) {
	    		if(staffcheck.equals("true")) {
	    			br.close();
	    			return 1; // staff
	    			}
	    		else
	    			br.close();
	    			return 2; // user
	    	}
	    }
	    br.close();
	    return 0; //failed
	}

	public boolean valid(String userName) throws IOException {
	    FileReader fr = new FileReader("userData.txt");
		BufferedReader br = new BufferedReader(fr);
	    String line, user;
	    while ((line = br.readLine()) != null) {
	    	user = line.split(" ")[0].toLowerCase();
	    	if(user.equals(userName)) {
	    		br.close();
	    			return false;}
	    }
	    br.close();
	    return true;
	}
}
