package com.pCarpet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


@Entity(name="Badgereader")
public class BadgeReader {
	
	@Id
	@Column(name="idbadgereader")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idBadgeReader;
	
	@ManyToOne
	@JoinColumn(name="idasset")
	private Asset asset;
	
	@Column
	@NotNull
	private String descrizione;
	
	@Column
	@NotNull
	private String tipologia;
	
	@Column
	@NotNull
	private long flag=1l;

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((descrizione == null) ? 0 : descrizione.hashCode());
//		result = prime * result + Integer.parseInt(idAsset+"");
//		result = prime * result + Integer.parseInt(idBadgeReader+"");
//		result = prime * result + ((tipologia == null) ? 0 : tipologia.hashCode());
//		return result;
//	}
//
//	@Override
//    public boolean equals(Object o) {
//		
//		if(this==o)return true;
//		if(!(this instanceof BadgeReader)) return false;
//		
//		BadgeReader br=(BadgeReader)o;
//		
//		if(idBadgeReader==br.idBadgeReader && idAsset==br.idAsset) return true;
//		
//		return false;
//    }
	
	 @Override
	    public String toString() {
	        return "1)ID BadgeReader: "+idBadgeReader+"\n2)ID Asset: " + getAsset().getIdasset() + "\n3)Descrizione: "+descrizione+"\n4)Tipologia: "+tipologia+"\n";

	    }
	
	
	
}
