package com.contrader.react.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.contrader.react.model.Chatbot;
import com.contrader.react.model.Nodo;
import com.contrader.react.model.User;
import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface ChatbotRepository extends CrudRepository<Chatbot, Integer> {

	public List<Chatbot> findAllByUser(User user);

	public List<Chatbot> findAllByNomeChatbot(String nomeChatbot);
	
	public List<Chatbot> findByDeleteATIsNull();

	@Query(value = "select c.* from chatbot c inner join user u on(c.id_user = u.id_user) inner join azienda a on (u.id_azienda = a.id_azienda) where c.deleteat is null and a.id_azienda = :idAzienda ; ", nativeQuery = true)
	public List<Chatbot> getAllByUtenteAndAzienda(@Param("idAzienda") Integer idAzienda);;
}