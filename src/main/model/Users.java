package main.model;

public class Users {

	private String username;
	private String password;
	private int userTypeFk;
	
	public Users(String username, String password, int userTypeFk) {
		this.username = username;
		this.password = password;
		this.userTypeFk = userTypeFk;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getuserTypeFk() {
		return userTypeFk;
	}
	public void setuserTypeFk(int userTypeFk) {
		this.userTypeFk = userTypeFk;
	}

	@Override
	public String toString() {
		return "Users [username=" + username + ", password=" + password + ", userTypeFk=" + userTypeFk + "]";
	}
}
