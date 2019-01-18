package com.contrader.react.converter;

import java.util.ArrayList;
import java.util.List;

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
	
	public static List<ChatbotDTO> toListDTO(List<Chatbot> list) {
		List<ChatbotDTO> listUserDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Chatbot user : list) {
				listUserDTO.add(ConverterChatbot.toDTO(user));
			}
		}
		return listUserDTO;
	}

	public static List<Chatbot> toListEntity(List<ChatbotDTO> listUserDTO) {
		List<Chatbot> list = new ArrayList<>();
		if (!listUserDTO.isEmpty()) {
			for (ChatbotDTO userDTO : listUserDTO) {
				list.add(ConverterChatbot.toEntity(userDTO));
			}
		}
		return list;
	}

}
