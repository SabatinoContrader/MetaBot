package com.virtualpairprogrammers.dto;

/**
 * Il DTO (Data transfer object) � un ponte che ci permette di nascondere le
 * informazioni principali del nostro model
 * 
 */
public class UsersDTO {

	private Integer id;
	private String username;
	private String password;
	private String ruolo;
	
	public UsersDTO(Integer id, String username, String password, String ruolo) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.ruolo = ruolo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

}
