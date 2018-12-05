package com.pCarpet.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExportDTO {
	
	//User
	private long iduser;
	private String ragioneSociale;
	
	//Assegnazione
	private String nome;
	private String cognome;
	
	//Movimento
	private String datainizio;
	private String datafine;
	
	//Asset
	private long idasset;
	private String tipo;
	private double prezzo;
	private String descrizione;
	
	public ExportDTO() {
		
	}
	
	public ExportDTO(long iduser, String ragioneSociale, String nome, String cognome, String datainizio, String datafine, long idasset, String tipo, double prezzo, String descrizione) {
		this();
		this.iduser=iduser;
		this.ragioneSociale=ragioneSociale;
		this.nome=nome;
		this.cognome=cognome;
		this.datainizio=datainizio;
		this.datafine=datafine;
		this.idasset=idasset;
		this.tipo=tipo;
		this.prezzo=prezzo;
		this.descrizione=descrizione;
	}
	
	
	
}
