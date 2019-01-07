package com.pCarpet.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pCarpet.converter.ConverterChatbot;
import com.pCarpet.converter.ConverterUser;
import com.pCarpet.dao.ChatbotRepository;
import com.pCarpet.dto.ChatbotDTO;
import com.pCarpet.dto.UserDTO;
import com.pCarpet.model.Chatbot;

@Service
public class ChatbotService {

	private final ChatbotRepository chatbotRepository;

	@Autowired
	public ChatbotService(ChatbotRepository chatbotRepository) {
		this.chatbotRepository = chatbotRepository;
	}

	public List<ChatbotDTO> findAllChatbotsDTOByIdUser(UserDTO userDTO) {

		final List<Chatbot> list = chatbotRepository.findAllByUser(ConverterUser.toEntity(userDTO));
		final List<ChatbotDTO> chatbotDTOs = new ArrayList<>();
		list.forEach(i -> chatbotDTOs.add(ConverterChatbot.toDTO(i)));
		return chatbotDTOs;
	}

	public boolean inserisciChatbotDTO(ChatbotDTO chatbotDTO) {
		final Chatbot chatbot = chatbotRepository.save(ConverterChatbot.toEntity(chatbotDTO));
		if (chatbot != null) {
			return true;
		}
		return false;
	}

	public ChatbotDTO findChatbotDTOByIdChatbot(Integer idChatbot) {
		return ConverterChatbot.toDTO(chatbotRepository.findById(idChatbot).get());
	}

}
