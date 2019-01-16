package com.contrader.react.converter;

import com.contrader.react.dto.ChatbotDTO;
import com.contrader.react.model.Chatbot;

public class ConverterChatbot {

	public static ChatbotDTO toDTO(Chatbot chatbot) {
		ChatbotDTO chatbotDTO = null;
		if (chatbot != null) {
			chatbotDTO = new ChatbotDTO();
			chatbotDTO.setIdChatbot(chatbot.getIdChatbot());
			chatbotDTO.setNomeChatbot(chatbot.getNomeChatbot());
			chatbotDTO.setNodoPadre(ConverterNodo.toDTO(chatbot.getNodoPadre()));
			chatbotDTO.setUser(ConverterUser.toDTO(chatbot.getUser()));
		}
		return chatbotDTO;
	}

	public static Chatbot toEntity(ChatbotDTO chatbotDTO) {
		Chatbot chatbot = null;
		if (chatbotDTO != null) {
			chatbot = new Chatbot();
			chatbot.setIdChatbot(chatbotDTO.getIdChatbot());
			chatbot.setNomeChatbot(chatbotDTO.getNomeChatbot());
			chatbot.setNodoPadre(ConverterNodo.toEntity(chatbotDTO.getNodoPadre()));
			chatbot.setUser(ConverterUser.toEntity(chatbotDTO.getUser()));
		}
		return chatbot;
	}

}
