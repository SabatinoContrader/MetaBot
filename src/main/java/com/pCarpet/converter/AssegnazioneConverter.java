package com.pCarpet.converter;

import com.pCarpet.dto.AssegnazioneDTO;
import com.pCarpet.model.Assegnazione;
import com.pCarpet.model.Badge;
import com.pCarpet.model.User;

public class AssegnazioneConverter {

	
	public static Assegnazione converToEntity(AssegnazioneDTO aDTO) {

		Assegnazione a=new Assegnazione();
		a.setIdassegnazione(aDTO.getIdassegnazione());
		a.setUser(UserConverter.converToEntity(aDTO.getUser()));
		a.setBadge(BadgeConverter.converToEntity(aDTO.getBadge()));
		a.setNome(aDTO.getNome());
		a.setCognome(aDTO.getCognome());
		a.setDataassegnazione(aDTO.getDataassegnazione());
		a.setFlag(aDTO.getFlag());
		
		
		return a;
	}
	

	
	public static AssegnazioneDTO convertToDTO(Assegnazione a) {
		
		AssegnazioneDTO aDTO=new AssegnazioneDTO();
		aDTO.setIdassegnazione(a.getIdassegnazione());
		aDTO.setUser(UserConverter.covertToDTO(a.getUser()));
		aDTO.setBadge(BadgeConverter.convertToDTO(a.getBadge()));
		aDTO.setNome(a.getNome());
		aDTO.setCognome(a.getCognome());
		aDTO.setDataassegnazione(a.getDataassegnazione());
		aDTO.setFlag(a.getFlag());
		return aDTO;
		
	}
}
