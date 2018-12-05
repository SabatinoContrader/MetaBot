package com.pCarpet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pCarpet.converter.AbbonamentoConverter;
import com.pCarpet.converter.StatoConverter;
import com.pCarpet.dao.AbbonamentoRepository;
import com.pCarpet.dao.StatoRepository;
import com.pCarpet.dto.AbbonamentoDTO;
import com.pCarpet.dto.StatoDTO;
import com.pCarpet.model.Abbonamento;
import com.pCarpet.model.Stato;

@Service
public class StatoService {

private StatoRepository statoRepository;
	
	@Autowired
	public StatoService(StatoRepository statoRepository) {
		this.statoRepository=statoRepository;
	}
	
	public boolean insertStato(StatoDTO statoDTO) {
		Stato abb=StatoConverter.converToEntity(statoDTO);
		
		return statoRepository.save(abb)!=null;
	}
	
	public StatoDTO findById(long id) {
		Stato s=this.statoRepository.findById(id).get();
		return StatoConverter.convertToDTO(s);
	}
	
}
