package com.pCarpet.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor



@Entity
public class Asset {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idasset;
	@Column
	@NotNull
	private String descrizione;
	@Column
	@NotNull
	private String tipo;
	@Column
	@NotNull
	private double prezzo;
	@Column
	private long flag=1l;
	
//	public Asset() {
//		
//	}
//	
//	public Asset(long idAsset, String descrizione, String tipo, double prezzo) {
//		this();
//		this.idAsset = idAsset;
//		this.descrizione = descrizione;
//		this.tipo = tipo;
//		this.prezzo=prezzo;
//	}
	
//	public long getIdAsset() {
//		return idAsset;
//	}
//	
//	public void setIdAsset(long idAsset) {
//		this.idAsset = idAsset;
//	}
//	public String getDescrizione() {
//		return descrizione;
//	}
//	public void setDescrizione(String descrizione) {
//		this.descrizione = descrizione;
//	}
//	public String getTipo() {
//		return tipo;
//	}
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
	
	@Override
    public String toString() {
        return "\nId:" + idasset + "\n1)Tipologia: " + tipo + "\n2)Descrizione: " + descrizione + "\n";
    }
	
	
}