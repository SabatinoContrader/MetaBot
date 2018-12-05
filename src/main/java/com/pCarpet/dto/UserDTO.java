package com.pCarpet.dto;

import com.pCarpet.model.Abbonamento;
import com.pCarpet.model.Stato;

public class UserDTO {

	private long iduser;
    private String username;
    private String password;
    private String ragioneSociale;
    private String telefono;
    private String mail;
    private String partitaiva;
    private String ruolo;
    private AbbonamentoDTO nomeAbb;
    private StatoDTO flag;
    
    public UserDTO() {
    	
    }
    
	public UserDTO(long iduser, String username, String password, String ragioneSociale, String telefono,
			String mail, String partitaiva, String ruolo, AbbonamentoDTO nomeAbb) {
		this();
		this.iduser = iduser;
		this.username = username;
		this.password = password;
		this.ragioneSociale = ragioneSociale;
		this.telefono = telefono;
		this.mail = mail;
		this.partitaiva = partitaiva;
		this.ruolo = ruolo;
		this.nomeAbb = nomeAbb;
		this.flag=new StatoDTO();
		this.flag.setId(1l);
		this.flag.setValore("attivo");
	}
	
//	public UserDTO(long iduser, String username, String password, String ragioneSociale, String telefono,
//			String mail, String partitaiva, String ruolo, AbbonamentoDTO nomeAbb) {
//		this();
//		this.iduser = iduser;
//		this.username = username;
//		this.password = password;
//		this.ragioneSociale = ragioneSociale;
//		this.telefono = telefono;
//		this.mail = mail;
//		this.partitaiva = partitaiva;
//		this.ruolo = ruolo;
//		this.nomeAbb = nomeAbb;
//	}
	
	public UserDTO(String username, String ruolo) {
		this();
		this.username=username;
		this.ruolo=ruolo;
	}
	
	public UserDTO(int idutente, String username,String ragioneSociale,String partitaiva) {
    	this.iduser=idutente;
    	this.username=username;
    	this.ragioneSociale=ragioneSociale;
    	this.partitaiva=partitaiva;
    	this.flag=new StatoDTO();
		this.flag.setId(1l);
		this.flag.setValore("attivo");
    }
	
	public long getIduser() {
		return iduser;
	}
	public void setIduser(long iduser) {
		this.iduser = iduser;
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
	public String getRagioneSociale() {
		return ragioneSociale;
	}
	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPartitaiva() {
		return partitaiva;
	}
	public void setPartitaiva(String partitaiva) {
		this.partitaiva = partitaiva;
	}
	public String getRuolo() {
		return ruolo;
	}
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	public AbbonamentoDTO getAbbonamento() {
		return nomeAbb;
	}
	public void setNomeAbb(AbbonamentoDTO nomeAbb) {
		this.nomeAbb = nomeAbb;
	}
	public StatoDTO getStato() {
		return flag;
	}
	public void setStato(StatoDTO flag) {
		this.flag = flag;
	}
    
    
	
}
