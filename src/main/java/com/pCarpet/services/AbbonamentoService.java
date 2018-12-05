package com.pCarpet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pCarpet.converter.AbbonamentoConverter;
import com.pCarpet.dao.AbbonamentoRepository;
import com.pCarpet.dto.AbbonamentoDTO;
import com.pCarpet.model.Abbonamento;

@Service
public class AbbonamentoService {

	private AbbonamentoRepository abbonamentoRepository;
	
	@Autowired
	public AbbonamentoService(AbbonamentoRepository abbonamentoRepository) {
		this.abbonamentoRepository=abbonamentoRepository;
	}
	
	public boolean insertAbb(AbbonamentoDTO abbDTO) {
		Abbonamento abb=AbbonamentoConverter.converToEntity(abbDTO);
		
		return abbonamentoRepository.save(abb)!=null;
	}
	
	public AbbonamentoDTO findById(long id) {
		Abbonamento a=this.abbonamentoRepository.findById(id).get();
		return AbbonamentoConverter.convertToDTO(a);
	}
	
}
