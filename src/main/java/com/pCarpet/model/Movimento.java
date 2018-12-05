package com.pCarpet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Movimento {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idmovimento")
	private Long idmovimento;
	
	@ManyToOne
	@JoinColumn(name="idbadgereader")
	private BadgeReader badgereader;
	
	@ManyToOne
	@JoinColumn(name="idbadge")
	private Badge badge;
	
	@Column(name="datainizio")
	@NotNull
	private String orainizio;
	
	@Column(name="datafine")
	@NotNull
	private String orafine;
	
	@ManyToOne
	@JoinColumn(name="idassegnazione")
	private Assegnazione assegnazione;

	public Movimento(Long idmovimento, BadgeReader badgereader, Badge badge, String orainizio, String orafine, Assegnazione assegnazione) {
		this();
		this.idmovimento = idmovimento;
		this.badgereader = badgereader;
		this.badge = badge;
		this.orainizio = orainizio;
		this.orafine = orafine;
		this.assegnazione=assegnazione;
	}
	
	
	public Movimento(Long idmovimento, BadgeReader badgereader, Badge badge, String orainizio, String orafine) {
		this();
		this.idmovimento = idmovimento;
		this.badgereader = badgereader;
		this.badge = badge;
		this.orainizio = orainizio;
		this.orafine = orafine;
	}
	
	public Movimento() {
		
	}

	
	public Movimento(long idmovimento, long idbadgereader, long idbadge, String orainizio, String orafine, Assegnazione assegnazione) {
		this();
		this.idmovimento = idmovimento;
		this.badgereader.setIdBadgeReader(idbadgereader);
		this.badge.setIdbadge(idbadge);
		this.orainizio = orainizio;
		this.orafine = orafine;
		this.assegnazione=assegnazione;
	}
	
	
	
	
	
}
