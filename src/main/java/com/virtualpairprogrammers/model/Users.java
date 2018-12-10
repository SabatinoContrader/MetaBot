package com.virtualpairprogrammers.model;

public class Users {

	private Integer usersId;
	private String username;
	private String password;
	private UserTypes userTypeFk;

	public Users(Integer usersId, String username, String password, UserTypes userTypeFk) {
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

	public UserTypes getUserTypeFk() {
		return userTypeFk;
	}

	public void setUserTypeFk(UserTypes userTypeFk) {
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

	@Override
	public String toString() {
		return "Users [usersId=" + usersId + ", username=" + username + ", password=" + password + ", userTypeFk="
				+ userTypeFk.toString() + "]";
	}

}
