package com.virtualpairprogrammers.model;

/**
 * Classe Model di esempio
 *
 */
public class Chatbots {

	/**
	 * I campi che sono attributi di una certa tabella che vogliamo rappresentare
	 * <br>
	 * Possiamo avere n colonne
	 */
	private Integer id;
	private Integer idUserFk;
	private Integer idNodoRootFk;
    private String nameChat;
	/**
	 * Costruttore con parametri
	 */
	public Chatbots(Integer id, Integer idUserFk, Integer idNodoRootFk, String nameChat) {
		super();
		this.id = id;
		this.idUserFk = idUserFk;
		this.idNodoRootFk = idNodoRootFk;
		this.nameChat = nameChat;
		/**
		 * Metodi setter e getter che ci permettono di recuperare le informazioni del
		 * model o di settarle
		 */
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdUserFk() {
		return idUserFk;
	}
	public void setIdUserFk(Integer idUserFk) {
		this.idUserFk = idUserFk;
	}
	public Integer getIdNodoRootFk() {
		return idNodoRootFk;
	}
	public void setIdNodoRootFk(Integer idNodoRootFk) {
		this.idNodoRootFk = idNodoRootFk;
	}
	public String getNameChat() {
		return nameChat;
	}
	public void setNameChat(String nameChat) {
		this.nameChat = nameChat;
	}

	

}
