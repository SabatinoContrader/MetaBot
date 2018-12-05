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

//@Data

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Assegnazione{
	
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idassegnazione;
	
	
	@ManyToOne
	@JoinColumn(name="idbadge")
	private Badge badge;
	
	@ManyToOne
	@JoinColumn(name="iduser")
	private User user;
	
	@Column
	@NotNull
	private String nome;
	
	@Column
	@NotNull
	private String cognome;
	
	@Column
	@NotNull
	private String dataassegnazione;
	
	@Column
	@NotNull
    private long flag=1l;
	
    
	@Override
    public String toString() {
        return "\nIdUser:" + /*user.getIduser()*/"" + "\n1)IdBadge: " + ""/*badge.getIdBadge()*/ + "\n2)Nome: "+nome+"\n3)Cognome: "+cognome+"\n4)Data assegnazione: " + dataassegnazione +"\n";
    }
}
