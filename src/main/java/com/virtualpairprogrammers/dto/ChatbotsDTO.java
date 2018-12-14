package com.virtualpairprogrammers.dto;

/**
 * Il DTO (Data transfer object) è un ponte che ci permette di nascondere le
 * informazioni principali del nostro model
 * 
 */
public class ChatbotsDTO {

	private Integer id;
	private Integer idUserFk;
	private Integer idNodoRootFk;
    private String nameChat;

	public ChatbotsDTO(Integer id, Integer idUserFk, Integer idNodoRootFk, String nameChat) {
		super();
		this.id = id;
		this.idUserFk = idUserFk;
		this.idNodoRootFk = idNodoRootFk;
		this.nameChat = nameChat;
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
	
