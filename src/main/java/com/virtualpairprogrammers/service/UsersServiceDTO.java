package com.virtualpairprogrammers.service;

import java.util.ArrayList;
import java.util.List;

import com.virtualpairprogrammers.converter.EsempioConverter;
import com.virtualpairprogrammers.converter.UsersConverter;
import com.virtualpairprogrammers.dao.EsempioDAO;
import com.virtualpairprogrammers.dao.UsersDAO;
import com.virtualpairprogrammers.dto.EsempioDTO;
import com.virtualpairprogrammers.dto.UsersDTO;
import com.virtualpairprogrammers.model.Esempio;
import com.virtualpairprogrammers.model.Users;

/**
 * Classe che si occupa di interfacciarsi con la persistenza e recuperare
 * attraverso i metodi del Data Access Object le tuple desiderate, Le converte
 * in un oggetto DTO e le restituisce al controller opportuno
 */
public class UsersServiceDTO {

	private final UsersDAO usersDAO;

	public UsersServiceDTO() {
		this.usersDAO = new UsersDAO();
	}

	/**
	 * Come vediamo la lista recuperata è di tipo Esempio ma noi la convertiamo in EsempioDTO
	 * Invito chi fa i converter a fare un metodo per convertire direttamente la lista senza farli uno ad uno perchè è sporco e poco efficiente
	 */
	public List<UsersDTO> getAllUsers() {

		List<Users> list = usersDAO.getAllUsers();
		List<UsersDTO> listDTO = new ArrayList<>();

		for (Users users : list) {
			listDTO.add(UsersConverter.toDTO(users));
		}

		return listDTO;
	}

}
