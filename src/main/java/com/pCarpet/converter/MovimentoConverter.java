package com.pCarpet.converter;

import com.pCarpet.dto.MovimentoDTO;
import com.pCarpet.model.Badge;
import com.pCarpet.model.Movimento;

public class MovimentoConverter {

	
	
	public static MovimentoDTO convertToDTO(Movimento m) {
		
		MovimentoDTO mDTO=new MovimentoDTO();
		mDTO.setBadge(BadgeConverter.convertToDTO(m.getBadge()));
		mDTO.setBadgereader(BadgeReaderConverter.convertToDTO(m.getBadgereader()));
		mDTO.setOrainizio(m.getOrainizio());
		mDTO.setOrafine(m.getOrafine());
		mDTO.setAssDTO(AssegnazioneConverter.convertToDTO(m.getAssegnazione()));
		
		return mDTO;
		
	}
	
}
