package com.pCarpet.converter;

import com.pCarpet.dto.BadgeReaderDTO;
import com.pCarpet.model.BadgeReader;

public class BadgeReaderConverter {

	public static BadgeReader converToEntity(BadgeReaderDTO badgeReaderDTO) {

		BadgeReader br=new BadgeReader();
		br.setAsset(AssetConverter.converToEntity(badgeReaderDTO.getAsset()));
		br.setIdBadgeReader(badgeReaderDTO.getIdBadgeReader());
		br.setDescrizione(badgeReaderDTO.getDescrizione());
		br.setTipologia(badgeReaderDTO.getTipologia());
		br.setFlag(badgeReaderDTO.getFlag());
		return br;
	}
	
	
	public static BadgeReaderDTO convertToDTO(BadgeReader br) {
		
		BadgeReaderDTO brDTO=new BadgeReaderDTO();
		brDTO.setAsset(AssetConverter.convertToDTO(br.getAsset()));
		brDTO.setIdBadgeReader(br.getIdBadgeReader());
		brDTO.setDescrizione(br.getDescrizione());
		brDTO.setTipologia(br.getTipologia());
		brDTO.setFlag(br.getFlag());
		
		return brDTO;
		
	}
	
}
