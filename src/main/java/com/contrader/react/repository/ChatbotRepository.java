package com.contrader.react.repository;

import org.springframework.data.repository.CrudRepository;

import com.contrader.react.model.Chatbot;
import com.contrader.react.model.User;
import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface ChatbotRepository extends CrudRepository<Chatbot, Integer> {

	public List<Chatbot> findAllByUser(User user);

	public List<Chatbot> findAllByNomeChatbot(String nomeChatbot);
	
	public List<Chatbot> findByDeleteATIsNull();
}