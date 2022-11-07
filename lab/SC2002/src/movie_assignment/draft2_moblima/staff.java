package moblima;

public class staff {
	private String userName;
	private String password;
	
	public staff(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void assign(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
}
