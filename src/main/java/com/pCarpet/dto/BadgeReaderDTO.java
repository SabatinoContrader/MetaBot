package com.pCarpet.dto;

public class BadgeReaderDTO {

	private long idBadgeReader;
	private AssetDTO asset;
	private String descrizione;
	private String tipologia;
	private long flag;
	
//	private long idAsset2;
//	private String descrizione2;
//	private String tipo2;
//	private double prezzo2;
	
	public BadgeReaderDTO() {
		
	}
	
	public BadgeReaderDTO(long idBadgeReader, AssetDTO asset, String descrizione, String tipologia,long flag) {
		this();
		this.idBadgeReader = idBadgeReader;
		this.asset = asset;
		this.descrizione = descrizione;
		this.tipologia = tipologia;
		this.flag = flag;
	}
	
	
	public BadgeReaderDTO(long idBadgeReader, AssetDTO asset, String descrizione, String tipologia) {
		
		this();
		this.idBadgeReader = idBadgeReader;
		this.asset = asset;
		this.descrizione = descrizione;
		this.tipologia = tipologia;
		
//		this.idAsset2=idAsset2;
//		this.descrizione2=descrizione2;
//		this.tipo2=tipo2;
//		this.prezzo2=prezzo2;
		
	}

	public long getIdBadgeReader() {
		return idBadgeReader;
	}

	public void setIdBadgeReader(long idBadgeReader) {
		this.idBadgeReader = idBadgeReader;
	}


	public void setFlag(long flag) {
		this.flag = flag;
	}

	public long getFlag() {
		return flag;
	}


	
	public AssetDTO getAsset() {
		return asset;
	}

	public void setAsset(AssetDTO asset) {
		this.asset = asset;
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

//	public long getIdAsset2() {
//		return idAsset2;
//	}
//
//	public void setIdAsset2(long idAsset2) {
//		this.idAsset2 = idAsset2;
//	}
//
//	public String getDescrizione2() {
//		return descrizione2;
//	}
//
//	public void setDescrizione2(String descrizione2) {
//		this.descrizione2 = descrizione2;
//	}
//
//	public String getTipo2() {
//		return tipo2;
//	}
//
//	public void setTipo2(String tipo2) {
//		this.tipo2 = tipo2;
//	}
//
//	public double getPrezzo2() {
//		return prezzo2;
//	}
//
//	public void setPrezzo2(double prezzo2) {
//		this.prezzo2 = prezzo2;
//	}
	
	
	
	
	
	
	
	
}
