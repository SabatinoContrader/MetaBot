package com.virtualpairprogrammers.dto;


public class NodeDTO { 
	
	private static Integer id;
	private String text;
	private Integer idNodoPadre;
	
	public NodeDTO(Integer id, String text, Integer idNodoPadre)  {
		this.id = id;
		this.text = text;
	    this.idNodoPadre = idNodoPadre;
	}

	public static Integer getId() {
		return id;
	}

	public static void setId(Integer id) {
		NodeDTO.id = id;
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