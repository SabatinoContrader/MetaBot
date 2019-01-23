package com.contrader.react.service;

import com.contrader.react.converter.ConverterAzienda;
import com.contrader.react.dto.AziendaDTO;
import com.contrader.react.model.Azienda;
import com.contrader.react.repository.AziendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AziendaService {
    private final AziendaRepository aziendaRepository;
    
    @Autowired
    public AziendaService(AziendaRepository aziendaRepository){
        this.aziendaRepository = aziendaRepository;
    }
    
    public List<AziendaDTO> getAll(){
        return ConverterAzienda.toDTOList((List<Azienda>) aziendaRepository.findAll());
    }
    public AziendaDTO getById(Integer id){
        return ConverterAzienda.toDTO(aziendaRepository.findById(id).get());
    }
    public AziendaDTO add(AziendaDTO aziendaDTO){
        return ConverterAzienda.toDTO(aziendaRepository.save(ConverterAzienda.toEntity(aziendaDTO)));
    }
    public AziendaDTO edit(AziendaDTO aziendaDTO){
        return ConverterAzienda.toDTO(aziendaRepository.save(ConverterAzienda.toEntity(aziendaDTO)));
    }
    public void deleteById(Integer id){
        aziendaRepository.deleteById(id);
    }
}
