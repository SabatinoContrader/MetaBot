package com.pCarpet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Stato{
	
//	private final double PREZZO_SILVER = 200;
//	private final double PREZZO_GOLD= 100;
//	private final double PREZZO_BASE= 20;
	
	
	@Id
	@Column
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long flag;
	
	@Column
	private String valore;

	@Override
	public String toString() {
		return "Stato [flag=" + flag + ", valore=" + valore + "]";
	}

	
}
	
	
    
	
