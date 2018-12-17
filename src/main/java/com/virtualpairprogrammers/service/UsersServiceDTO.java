package com.virtualpairprogrammers.service;

import java.util.ArrayList;
import java.util.List;

import com.virtualpairprogrammers.converter.UsersConverter;
import com.virtualpairprogrammers.dao.UsersDAO;
import com.virtualpairprogrammers.dto.UsersDTO;
import com.virtualpairprogrammers.model.Nodes;
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
	
	public UsersDTO getUserByUsernameAndPasword(String username, String password) {
		return UsersConverter.toDTO(usersDAO.login(username, password));
	}

	public boolean updateUsers (UsersDTO usersDTO) {
		return this.usersDAO.updateUsers(UsersConverter.toEntity(usersDTO));
		
}
	
	public boolean deleteUsers (UsersDTO usersDTO) {
		return this.usersDAO.deleteUsers(UsersConverter.toEntity(usersDTO));
		
}
	
	public boolean insertUsers (UsersDTO usersDTO) {
		return this.usersDAO.insertUsers(UsersConverter.toEntity(usersDTO));
	
}
		
	
	
}
