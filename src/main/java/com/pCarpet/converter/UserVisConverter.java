package com.pCarpet.converter;

import com.pCarpet.dto.UserDTO;
import com.pCarpet.model.User;

public class UserVisConverter{

	
	public static User converToEntity(UserDTO dto) {
		return null;
	}

	
	
	public static UserDTO covertToDTO(User entity) {
		UserDTO userDTO = new UserDTO();
		
		userDTO.setIduser(entity.getIduser());
		userDTO.setUsername(entity.getUsername());
		userDTO.setRagioneSociale(entity.getRagioneSociale());
		userDTO.setPartitaiva(entity.getPartitaiva());
		userDTO.setStato(StatoConverter.convertToDTO(entity.getStato()));
		
		return userDTO;
	}
	
}
