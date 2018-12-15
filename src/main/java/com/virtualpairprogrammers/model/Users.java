package com.virtualpairprogrammers.model;

/**
 * Classe Model di esempio
 *
 */
public class Users {

	/**
	 * I campi che sono attributi di una certa tabella che vogliamo rappresentare
	 * <br>
	 * Possiamo avere n colonne
	 */
	private Integer id;
	private String username;
	private String password;
	private String ruolo;

	/**
	 * Costruttore con parametri
	 */
	public Users(Integer id, String username, String password, String ruolo) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.ruolo = ruolo;

		
	}

	/**
	 * Metodi setter e getter che ci permettono di recuperare le informazioni del
	 * model o di settarle
	 */
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
