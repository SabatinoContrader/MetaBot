package com.virtualpairprogrammers.converter;

import java.util.ArrayList;
import java.util.List;

import com.virtualpairprogrammers.dto.ChatbotsDTO;
import com.virtualpairprogrammers.model.Chatbots;

/**
 * Il converter si occupa di "convertire" un model in un dto e viceversa
 *
 */
public class ChatbotsConverter {


	/**
	 * Converte un NodesDTO in Nodes
	 */
	public static Chatbots toEntity(ChatbotsDTO chatbotsDTO) {

		Chatbots chatbots = null;
		if (chatbotsDTO != null) {
			chatbots = new Chatbots(chatbots.getId(),chatbots.getIdUserFk(),chatbots.getIdNodoRootFk(),chatbots.getNameChat());
		}

		return chatbots;
	}

	/**
	 * Converte un Nodes in NodesDTO
	 */
	public static ChatbotsDTO toDTO(Chatbots chatbots) {

		ChatbotsDTO chatbotsDTO = null;
		if (chatbots != null) {
			chatbotsDTO = new ChatbotsDTO(chatbots.getId(),chatbots.getIdUserFk(),chatbots.getIdNodoRootFk(),chatbots.getNameChat());
		}

		return chatbotsDTO;
	}

}
