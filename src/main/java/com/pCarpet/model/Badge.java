package com.pCarpet.model;

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
public class Badge {
	
	@Id
	@Column(name="idbadge")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idbadge;
	
	@Column
	@NotNull
	private String descrizione;
	
	@Column
	@NotNull
	private String tipologia;
	
	@Column
	@NotNull
	private long flag;
	

	
	
	@Override
    public String toString() {
        return "\nId:" + idbadge + "\n1)Tipologia: " + tipologia + "\n2)Descrizione: " + descrizione + "\n";
    }
	
	
}