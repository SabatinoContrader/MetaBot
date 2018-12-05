package com.pCarpet.converter;

import com.pCarpet.dto.AbbonamentoDTO;
import com.pCarpet.model.Abbonamento;

public class AbbonamentoConverter{

	public static Abbonamento converToEntity(AbbonamentoDTO abbonamentoDTO) {

		Abbonamento a=new Abbonamento();
		a.setId(abbonamentoDTO.getId());
		a.setNome(abbonamentoDTO.getNome());
		a.setPrezzo(abbonamentoDTO.getPrezzo());
		
		
		return a;
	}
	
	
	public static AbbonamentoDTO convertToDTO(Abbonamento a) {
		
		AbbonamentoDTO aDTO=new AbbonamentoDTO();
		aDTO.setId(a.getId());
		aDTO.setNome(a.getNome());
		aDTO.setPrezzo(a.getPrezzo());
		
		return aDTO;
		
	}
	
	
	
}
