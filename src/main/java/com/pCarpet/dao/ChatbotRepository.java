package com.pCarpet.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.pCarpet.model.Chatbot;
import com.pCarpet.model.User;

public interface ChatbotRepository extends CrudRepository<Chatbot, Integer> {

	public List<Chatbot> findAllByUser(User user);

	public List<Chatbot> findAllByNomeChatbot(String nomeChatbot);

	
	

}
