package com.virtualpairprogrammers.model;

/**
 * Classe Model di esempio
 *
 */
public class Esempio {

	/**
	 * I campi che sono attributi di una certa tabella che vogliamo rappresentare
	 * <br>
	 * Possiamo avere n colonne
	 */
	private Integer colonna_id_esempio;
	private String colonna2_esempio;

	/**
	 * Costruttore con parametri
	 */
	public Esempio(Integer colonna_id_esempio, String colonna2_esempio) {
		super();
		this.colonna_id_esempio = colonna_id_esempio;
		this.colonna2_esempio = colonna2_esempio;
	}

	/**
	 * Metodi setter e getter che ci permettono di recuperare le informazioni del
	 * model o di settarle
	 */
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
