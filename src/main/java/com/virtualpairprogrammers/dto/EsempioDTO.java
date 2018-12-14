package com.virtualpairprogrammers.dto;

/**
 * Il DTO (Data transfer object) è un ponte che ci permette di nascondere le
 * informazioni principali del nostro model
 * 
 */
public class EsempioDTO {

	private Integer colonna_id_esempio;
	private String colonna2_esempio;

	public EsempioDTO(Integer colonna_id_esempio, String colonna2_esempio) {
		super();
		this.colonna_id_esempio = colonna_id_esempio;
		this.colonna2_esempio = colonna2_esempio;
	}

	public Integer getColonna_id_esempio() {
		return colonna_id_esempio;
	}

	public void setColonna_id_esempio(Integer colonna_id_esempio) {
		this.colonna_id_esempio = colonna_id_esempio;
	}

	public String getColonna2_esempio() {
		return colonna2_esempio;
	}

	public void setColonna2_esempio(String colonna2_esempio) {
		this.colonna2_esempio = colonna2_esempio;
	}

}
