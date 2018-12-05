package com.pCarpet.dto;

import com.pCarpet.model.Asset;
import com.pCarpet.model.Prenotazione;
import com.pCarpet.model.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PrenotazioneDTO {
	
	private long idprenotazione;
	private UserDTO user;
	private AssetDTO asset;
	private String orainizio;
	private String orafine;
	
//	private long iduser2;
//	private String username;
//	private String ragioneSociale;
//	private String partitaiva;
//	private long flag;
	
	
//	private long idasset2;
//	private String descrizione;
//	private String tipo;
//	private double prezzo;
	
	
	public PrenotazioneDTO() {
	}
	
	public PrenotazioneDTO(long idprenotazione,UserDTO user, AssetDTO asset, String orainizio, String orafine) {
		this.idprenotazione=idprenotazione;
		this.user=user;
		this.asset=asset;
		this.orainizio=orainizio;
		this.orafine=orafine;
	}
	


//	public PrenotazioneDTO(long iduser, long idasset, String orainizio, String orafine, User u, Asset a) {
//		this.iduser=iduser;
//		this.idasset=idasset;
//		this.orainizio=orainizio;
//		this.orafine=orafine;
		
//		this.iduser2=u.getIduser();
//		this.username=u.getUsername();
//		this.ragioneSociale=u.getRagioneSociale();
//		this.partitaiva=u.getPartitaiva();
//		this.flag=u.getFlag();
//		
//		this.idasset2=a.getIdAsset();
//		this.descrizione=a.getDescrizione();
//		this.tipo=a.getTipo();
//		this.prezzo=a.getPrezzo();
		
	//}
	
	
	
	
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public String getRagioneSociale() {
//		return ragioneSociale;
//	}
//
//	public void setRagioneSociale(String ragioneSociale) {
//		this.ragioneSociale = ragioneSociale;
//	}
//
//	public String getPartitaiva() {
//		return partitaiva;
//	}
//
//	public void setPartitaiva(String partitaiva) {
//		this.partitaiva = partitaiva;
//	}
//
//	public long getFlag() {
//		return flag;
//	}
//
//	public void setFlag(long flag) {
//		this.flag = flag;
//	}
//
//	public String getDescrizione() {
//		return descrizione;
//	}
//
//	public void setDescrizione(String descrizione) {
//		this.descrizione = descrizione;
//	}
//
//	public String getTipo() {
//		return tipo;
//	}
//
//	public void setTipo(String tipo) {
//		this.tipo = tipo;
//	}
//
//	public double getPrezzo() {
//		return prezzo;
//	}
//
//	public void setPrezzo(double prezzo) {
//		this.prezzo = prezzo;
//	}


	
	
	
//	public long getIdUser2() {
//		return iduser2;
//	}
//	
//	public void setIdUser2(long iduser2) {
//		this.iduser2=iduser2;
//	}
//	
//	public long getIdAsset2() {
//		return idasset2;
//	}
//	
//	public void setIdAsset2(long idasset2) {
//		this.idasset2=idasset2;
//	}
	
	
	
	
	
	
}
