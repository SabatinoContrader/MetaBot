package com.pCarpet.dto;

public class StatoDTO {

	private long id;
	private String valore;
	
	public StatoDTO() {
		
	}
	
	public StatoDTO(long id,String valore) {
		this();
		this.id=id;
		this.valore = valore;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getValore() {
		return valore;
	}

	public void setValore(String valore) {
		this.valore = valore;
	}
	
	
	
}
