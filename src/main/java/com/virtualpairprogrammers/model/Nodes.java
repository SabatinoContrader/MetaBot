package com.virtualpairprogrammers.model;


public class Nodes {
	
	private Integer id;
	private String text;
	private Integer idNodoPadre;
	
	public Nodes (Integer id, String text, Integer idNodoPadre) {
	this.id = id;
	this.text = text;
	this.idNodoPadre = idNodoPadre;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getIdNodoPadre() {
		return idNodoPadre;
	}

	public void setIdNodoPadre(Integer idNodoPadre) {
		this.idNodoPadre = idNodoPadre;
	}

}
