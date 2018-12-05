package com.pCarpet.converter;

import com.pCarpet.dto.UserDTO;
import com.pCarpet.model.User;

public class UserConverter{

	
	public static User converToEntity(UserDTO dto) {

		User u=new User();
		u.setIduser(dto.getIduser());
		u.setUsername(dto.getUsername());
		u.setPassword(dto.getPassword());
		u.setRagioneSociale(dto.getRagioneSociale());
		u.setTelefono(dto.getTelefono());
		u.setMail(dto.getMail());
		u.setPartitaiva(dto.getPartitaiva());
		u.setRuolo(dto.getRuolo());
		u.setAbbonamento(AbbonamentoConverter.converToEntity(dto.getAbbonamento()));
		u.setStato(StatoConverter.converToEntity(dto.getStato()));
		//u.setFlag(dto.getFlag());
		
		return u;
	}


	public static UserDTO covertToDTO(User entity) {
		UserDTO userDTO=new UserDTO();
		userDTO.setIduser(entity.getIduser());
		userDTO.setRagioneSociale(entity.getRagioneSociale());
		userDTO.setUsername(entity.getUsername());
		userDTO.setPassword(entity.getPassword());
		userDTO.setTelefono(entity.getTelefono());
		userDTO.setMail(entity.getMail());
		userDTO.setPartitaiva(entity.getPartitaiva());
		userDTO.setRuolo(entity.getRuolo());
		userDTO.setNomeAbb(AbbonamentoConverter.convertToDTO(entity.getAbbonamento()));
		userDTO.setStato(StatoConverter.convertToDTO(entity.getStato()));
		return userDTO;
	}
	
}
