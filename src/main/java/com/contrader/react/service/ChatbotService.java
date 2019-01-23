package com.contrader.react.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.data.repository.CrudRepository;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contrader.react.converter.ConverterChatbot;
import com.contrader.react.converter.ConverterUser;
import com.contrader.react.dto.ChatbotDTO;
import com.contrader.react.dto.UserDTO;
import com.contrader.react.model.Chatbot;
import com.contrader.react.repository.ChatbotRepository;



@Service
public class ChatbotService {

	private final ChatbotRepository chatbotRepository;

	@Autowired
	public ChatbotService(ChatbotRepository chatbotRepository) {
		this.chatbotRepository = chatbotRepository;
	}

	public void deleteChatbotByIdChatbot(Integer IdChatbot) {
		chatbotRepository.deleteById(IdChatbot);
		
	}
	
	public List<ChatbotDTO> findAll () {
		List<Chatbot> list = new ArrayList<>();
		List<ChatbotDTO> listDTO = new ArrayList<>();
		chatbotRepository.findAll().forEach(list::add);
		list.forEach(i->listDTO.add(ConverterChatbot.toDTO(i)));
	
	return listDTO;
	}
	
	public boolean deleteById(Integer id) {
		Chatbot chat = chatbotRepository.findById(id).get();
		Date date = new Date(Calendar.getInstance().getTime().getTime());
		chat.setDeleteAT(date);
		chatbotRepository.save(chat);
		return chatbotRepository.existsById(id);
	}

	public List<ChatbotDTO> getAll() {
		return ConverterChatbot.toListDTO((List<Chatbot>) chatbotRepository.findByDeleteATIsNull());
	}
	
	public ChatbotDTO insert(ChatbotDTO userDTO) {
		return ConverterChatbot.toDTO(chatbotRepository.save(ConverterChatbot.toEntity(userDTO)));
	}
	
	public ChatbotDTO update(ChatbotDTO userDTO) {
		return ConverterChatbot.toDTO(chatbotRepository.save(ConverterChatbot.toEntity(userDTO)));
	}
	
	public List<ChatbotDTO> findAllChatbotsDTOByIdUser(UserDTO userDTO) {
		return ConverterChatbot.toListDTO(chatbotRepository.findAllByUser(ConverterUser.toEntity(userDTO)));
	}

	public ChatbotDTO inserisciChatbotDTO(ChatbotDTO chatbotDTO) {
		return ConverterChatbot.toDTO(chatbotRepository.save(ConverterChatbot.toEntity(chatbotDTO)));
	}

	public ChatbotDTO findChatbotDTOByIdChatbot(Integer idChatbot) {
		return ConverterChatbot.toDTO(chatbotRepository.findById(idChatbot).get());
	}
	
	public List<ChatbotDTO> findChatbotDTOByNomeChatbot(String nomeChatbot) {
			return ConverterChatbot.toListDTO(chatbotRepository.findAllByNomeChatbot(nomeChatbot));
	}
}
