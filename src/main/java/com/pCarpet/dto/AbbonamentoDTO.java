package com.pCarpet.dto;

public class AbbonamentoDTO {

	private long id;
	private String nome;
	private double prezzo;
	
	public AbbonamentoDTO() {
		
	}
	
	public AbbonamentoDTO(long id,String nome, double prezzo) {
		this();
		this.id=id;
		this.nome = nome;
		this.prezzo=prezzo;
	}

	
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPrezzo() {
		return prezzo;
	}


	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	
	
	
	
}
