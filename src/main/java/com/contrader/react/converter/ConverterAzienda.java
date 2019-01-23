package com.contrader.react.converter;

import com.contrader.react.dto.AziendaDTO;
import com.contrader.react.model.Azienda;

import java.util.ArrayList;
import java.util.List;

public class ConverterAzienda {
    
    public static AziendaDTO toDTO (Azienda azienda){
        AziendaDTO aziendaDTO = null;
        if(azienda !=null){
            aziendaDTO = new AziendaDTO(azienda.getIdAzienda(),azienda.getNomeAzienda()); }
        return aziendaDTO;
    }
    
    public static Azienda toEntity(AziendaDTO aziendaDTO){
        Azienda azienda = null;
        if(aziendaDTO != null)
            azienda = new Azienda(aziendaDTO.getIdAzienda(),aziendaDTO.getNomeAzienda());
        return azienda;
    }
    
    public static List<AziendaDTO> toDTOList(List<Azienda> aziendaList){
        List<AziendaDTO> aziendaDTOList = new ArrayList<>();
        if(!aziendaList.isEmpty())
            for (Azienda azienda : aziendaList)
                aziendaDTOList.add(ConverterAzienda.toDTO(azienda));
        return aziendaDTOList;
    }
    
    public static List<Azienda> toEntityList(List<AziendaDTO> aziendaDTOList){
        List<Azienda> aziendaList = new ArrayList<>();
        if(!aziendaDTOList.isEmpty())
            for (AziendaDTO aziendaDTO : aziendaDTOList)
                aziendaList.add(ConverterAzienda.toEntity(aziendaDTO));
        return  aziendaList;
    }
}
