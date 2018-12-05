package com.virtualpairprogrammers.model;

public class BadgeReader {
	
	private int idBadgeReader;
	private int idAsset;
	private String descrizione;
	private String tipologia;
	
	public BadgeReader(int idBadgeReader, int idAsset, String descrizione, String tipologia) {
		this.idBadgeReader = idBadgeReader;
		this.idAsset=idAsset;
		this.descrizione=descrizione;
		this.tipologia=tipologia;
	}

	

	public int getIdBadgeReader() {
		return idBadgeReader;
	}



	public void setIdBadgeReader(int idBadgeReader) {
		this.idBadgeReader = idBadgeReader;
	}



	public int getIdAsset() {
		return idAsset;
	}



	public void setIdAsset(int idAsset) {
		this.idAsset = idAsset;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descrizione == null) ? 0 : descrizione.hashCode());
		result = prime * result + idAsset;
		result = prime * result + idBadgeReader;
		result = prime * result + ((tipologia == null) ? 0 : tipologia.hashCode());
		return result;
	}

	@Override
    public boolean equals(Object o) {
		
		if(this==o)return true;
		if(!(this instanceof BadgeReader)) return false;
		
		BadgeReader br=(BadgeReader)o;
		
		if(idBadgeReader==br.idBadgeReader && idAsset==br.idAsset) return true;
		
		return false;
    }
	
	 @Override
	    public String toString() {
	        return "1)ID BadgeReader: "+idBadgeReader+"\n2)ID Asset: " + idAsset + "\n3)Descrizione: "+descrizione+"\n4)Tipologia: "+tipologia+"\n";

	    }
	
	
	
}
