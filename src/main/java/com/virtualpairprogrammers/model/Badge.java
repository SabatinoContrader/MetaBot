package com.virtualpairprogrammers.model;

public class Badge {
	private int idBadge;
	private String descrizione;
	private String tipologia;
	
	public Badge(int idBadge, String descrizione, String tipologia) {
		super();
		this.idBadge = idBadge;
		this.descrizione = descrizione;
		this.tipologia = tipologia;
	}
	
	public int getIdBadge() {
		return idBadge;
	}
	
	public void setIdBadge(int idBadge) {
		this.idBadge = idBadge;
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
	
	@Override
    public String toString() {
        return "\nId:" + idBadge + "\n1)Tipologia: " + tipologia + "\n2)Descrizione: " + descrizione + "\n";
    }
	
	
}
