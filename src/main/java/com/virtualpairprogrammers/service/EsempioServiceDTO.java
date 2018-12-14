package com.virtualpairprogrammers.service;

import java.util.ArrayList;
import java.util.List;

import com.virtualpairprogrammers.converter.EsempioConverter;
import com.virtualpairprogrammers.dao.EsempioDAO;
import com.virtualpairprogrammers.dto.EsempioDTO;
import com.virtualpairprogrammers.model.Esempio;

/**
 * Classe che si occupa di interfacciarsi con la persistenza e recuperare
 * attraverso i metodi del Data Access Object le tuple desiderate, Le converte
 * in un oggetto DTO e le restituisce al controller opportuno
 */
public class EsempioServiceDTO {

	private final EsempioDAO esempioDAO;

	public EsempioServiceDTO() {
		this.esempioDAO = new EsempioDAO();
	}

	/**
	 * Come vediamo la lista recuperata è di tipo Esempio ma noi la convertiamo in EsempioDTO
	 * Invito chi fa i converter a fare un metodo per convertire direttamente la lista senza farli uno ad uno perchè è sporco e poco efficiente
	 */
	public List<EsempioDTO> getAllEsempio() {

		List<Esempio> list = esempioDAO.getAllEsempio();
		List<EsempioDTO> listDTO = new ArrayList<>();

		for (Esempio esempio : list) {
			listDTO.add(EsempioConverter.toDTO(esempio));
		}

		return listDTO;
	}

}
