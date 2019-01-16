package com.contrader.react.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Nodo {

	@Id
	@Column(name = "id_nodo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idNodo;

	@Column(name = "text")
	private String text;

	@Column(name = "path")
	private String path;

	@ManyToOne()
	@JoinColumn(name = "id_nodo_padre")
	private Nodo nodoPadre;

	@Column(name = "tipoNodo")
	private String tipoNodo;
}