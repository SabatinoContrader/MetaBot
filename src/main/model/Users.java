package main.model;

public class Users {

	private Integer usersId;
	private String username;
	private String password;
	private Integer userTypeFk;

	public Users(Integer usersId, String username, String password, Integer userTypeFk) {
		this.usersId = usersId;
		this.username = username;
		this.password = password;
		this.userTypeFk = userTypeFk;
	}

	public Integer getUsersId() {
		return usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}

	public int getUserTypeFk() {
		return userTypeFk;
	}

	public void setUserTypeFk(int userTypeFk) {
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

	public Integer getuserTypeFk() {
		return userTypeFk;
	}

	public void setuserTypeFk(Integer userTypeFk) {
		this.userTypeFk = userTypeFk;
	}

	@Override
	public String toString() {
		return "Users [usersId=" + usersId + ", username=" + username + ", password=" + password + ", userTypeFk="
				+ userTypeFk + "]";
	}

}
