package com.pCarpet.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.pCarpet.converter.BadgeReaderConverter;
import com.pCarpet.dao.BadgeReaderRepository;
import com.pCarpet.dto.BadgeReaderDTO;
import com.pCarpet.model.BadgeReader;
@Service
public class BadgeReaderService {

	private BadgeReaderRepository badgeReaderRepository;
	
	@Autowired
    public BadgeReaderService(BadgeReaderRepository badgereaderRepository) {
        this.badgeReaderRepository = badgereaderRepository;
    }

	public BadgeReaderService () {}
	
    public List<BadgeReaderDTO> getAllBadgeReaders () {
        
    	List<BadgeReader> listBadgeReader =(List<BadgeReader>) this.badgeReaderRepository.findAll();
        
    	List<BadgeReaderDTO> listDTO=new ArrayList<>();
    	
    	
    	for(BadgeReader br: listBadgeReader) {
    		listDTO.add(BadgeReaderConverter.convertToDTO(br));
    	}
    	
    	return listDTO;
    	
    }
    
    public List<BadgeReaderDTO> getAllBadgeReadersIdAsset (int idAsset) {
        BadgeReader brList=(BadgeReader)this.badgeReaderRepository.findByAsset(idAsset);
        
        List<BadgeReaderDTO> brDTOList=new ArrayList<>();
        
        //for(BadgeReader br: brList) {
        	brDTOList.add(BadgeReaderConverter.convertToDTO(brList));
       // }
        
        return brDTOList;
        
    }
    
    public List<BadgeReaderDTO> getBadgeReader (long id) {
    	
    	BadgeReader brList=(BadgeReader)this.badgeReaderRepository.findById(id).get();
        
        List<BadgeReaderDTO> brDTOList=new ArrayList<>();
        
//        for(BadgeReader br: brList) {
        	brDTOList.add(BadgeReaderConverter.convertToDTO(brList));
//        }
        
        return brDTOList;
    	
    }

    public void insertBadgeReader (BadgeReaderDTO badgeReaderDTO) {
    	
    	BadgeReader badgeReader=BadgeReaderConverter.converToEntity(badgeReaderDTO);
    	
        this.badgeReaderRepository.save(badgeReader);
        
    }
    
    public void deleteBadgeReadear (long idBadgeReader) {
    	this.badgeReaderRepository.deleteById(idBadgeReader);
    }
    
//    public void updateBadgeReader(HttpServletRequest request) {
//    	 this.badgeReaderRepository.save(request);
//    }
	
}
