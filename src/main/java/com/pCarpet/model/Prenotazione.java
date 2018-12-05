package com.pCarpet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


@Entity
public class Prenotazione {

	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idprenotazione;
	
	
	@ManyToOne
	@JoinColumn(name="iduser")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="idasset")
	private Asset asset;
	
	@Column
	private String orainizio;
	
	@Column
	private String orafine;
	

	
	public String toString() {
		
		return "ID User:"+user.getIduser()+" ID Asset:"+asset.getIdasset()+" Ora inizio:"+orainizio+" Ora fine:"+orafine;
		
	}
	
	
}
