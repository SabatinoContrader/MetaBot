package com.pCarpet.dto;

public class BadgeDTO {

	private long idbadge;
	private String descrizione;
	private String tipologia;
	private long flag;
	
	public BadgeDTO() {
		
	}
	
	public BadgeDTO(long idbadge, String descrizione, String tipologia,long flag) {
		this();
		this.idbadge=idbadge;
		this.descrizione=descrizione;
		this.tipologia=tipologia;
		this.flag=flag;
		
	}


	public long getFlag() {
		return flag;
	}

	public void setFlag(long flag) {
		this.flag = flag;
	}

	public long getIdBadge() {
		return idbadge;
	}

	public void setIdBadge(long idbadge) {
		this.idbadge = idbadge;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
	
	
	
}
