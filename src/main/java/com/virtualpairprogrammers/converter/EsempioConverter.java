package com.virtualpairprogrammers.converter;

import java.util.ArrayList;
import java.util.List;

import com.virtualpairprogrammers.dto.EsempioDTO;
import com.virtualpairprogrammers.model.Esempio;

/**
 * Il converter si occupa di "convertire" un model in un dto e viceversa
 *
 */
public class EsempioConverter {


	/**
	 * Converte un NodesDTO in Nodes
	 */
	public static Esempio toEntity(EsempioDTO esempioDTO) {

		Esempio esempio = null;
		if (esempioDTO != null) {
			esempio = new Esempio(esempioDTO.getColonna_id_esempio(), esempioDTO.getColonna2_esempio());
		}

		return esempio;
	}

	/**
	 * Converte un Nodes in NodesDTO
	 */
	public static EsempioDTO toDTO(Esempio esempio) {

		EsempioDTO esempioDTO = null;
		if (esempio != null) {
			esempioDTO = new EsempioDTO(esempio.getColonna_id_esempio(), esempio.getColonna2_esempio());
		}

		return esempioDTO;
	}

}
