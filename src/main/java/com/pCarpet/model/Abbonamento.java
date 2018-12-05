package com.pCarpet.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;

//@Data

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Abbonamento{
	
//	private final double PREZZO_SILVER = 200;
//	private final double PREZZO_GOLD= 100;
//	private final double PREZZO_BASE= 20;
	
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String nome;
	
	
	@Column
	private double prezzo;
	
	
    
	@Override
    public String toString() {
        return "Nome: "+nome+"\n3)Prezzo: "+prezzo+"\n";
    }
}
