package com.pCarpet.converter;

import com.pCarpet.dto.StatoDTO;
import com.pCarpet.model.Stato;

public class StatoConverter {

	public static Stato converToEntity(StatoDTO statoDTO) {

		Stato s=new Stato();
		s.setFlag(statoDTO.getId());
		s.setValore(statoDTO.getValore());
		
		
		return s;
	}
	
	
	public static StatoDTO convertToDTO(Stato s) {
		
		StatoDTO sDTO=new StatoDTO();
		sDTO.setId(s.getFlag());
		sDTO.setValore(s.getValore());
		
		return sDTO;
		
	}
	
}
