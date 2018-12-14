package com.virtualpairprogrammers.service;

import java.util.ArrayList;
import java.util.List;

import com.virtualpairprogrammers.converter.ChatbotsConverter;
import com.virtualpairprogrammers.dao.ChatbotsDAO;
import com.virtualpairprogrammers.dto.ChatbotsDTO;
import com.virtualpairprogrammers.model.Chatbots;

/**
 * Classe che si occupa di interfacciarsi con la persistenza e recuperare
 * attraverso i metodi del Data Access Object le tuple desiderate, Le converte
 * in un oggetto DTO e le restituisce al controller opportuno
 */
public class ChatbotsServiceDTO {

	private final ChatbotsDAO chatbotsDAO;

	public ChatbotsServiceDTO() {
		this.chatbotsDAO = new ChatbotsDAO();
	}

	/**
	 * Come vediamo la lista recuperata è di tipo Esempio ma noi la convertiamo in EsempioDTO
	 * Invito chi fa i converter a fare un metodo per convertire direttamente la lista senza farli uno ad uno perchè è sporco e poco efficiente
	 */
	public List<ChatbotsDTO> getAllChatbots() {

		List<Chatbots> list = chatbotsDAO.getAllChatbots();
		List<ChatbotsDTO> listDTO = new ArrayList<>();

		for (Chatbots chatbots : list) {
			listDTO.add(ChatbotsConverter.toDTO(chatbots));
		}

		return listDTO;
	}

}
