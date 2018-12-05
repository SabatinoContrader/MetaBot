package com.pCarpet.converter;

import com.pCarpet.dto.BadgeDTO;
import com.pCarpet.model.Badge;

public class BadgeConverter {

	public static Badge converToEntity(BadgeDTO badgeDTO) {

		Badge b=new Badge();
		b.setIdbadge(badgeDTO.getIdBadge());
		b.setTipologia(badgeDTO.getTipologia());
		b.setDescrizione(badgeDTO.getDescrizione());
		b.setFlag(badgeDTO.getFlag());
		
		
		return b;
	}
	
	
	public static BadgeDTO convertToDTO(Badge b) {
		
		BadgeDTO bDTO=new BadgeDTO();
		bDTO.setIdBadge(b.getIdbadge());
		bDTO.setTipologia(b.getTipologia());
		bDTO.setDescrizione(b.getDescrizione());
		bDTO.setFlag(b.getFlag());
		
		return bDTO;
		
	}
	
}
