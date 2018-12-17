package com.virtualpairprogrammers.converter;

import java.util.ArrayList;
import java.util.List;


import com.virtualpairprogrammers.dto.UsersDTO;
import com.virtualpairprogrammers.model.Users;

/**
 * Il converter si occupa di "convertire" un model in un dto e viceversa
 *
 */
public class UsersConverter {


	/**
	 * Converte un NodesDTO in Nodes
	 */
	public static Users toEntity(UsersDTO usersDTO) {

		Users users = null;
		if (usersDTO != null) {
			users = new Users(usersDTO.getId(), usersDTO.getUsername(), usersDTO.getPassword(), usersDTO.getRuolo());
		}

		return users;
	}

	/**
	 * Converte un Nodes in NodesDTO
	 */
	public static UsersDTO toDTO(Users users) {

		UsersDTO usersDTO = null;
		if (users != null) {
			usersDTO = new UsersDTO(users.getId(), users.getUsername(), users.getPassword(), users.getRuolo());
		}

		return usersDTO;
	}
	

}
