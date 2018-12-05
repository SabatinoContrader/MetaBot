package com.pCarpet.services;

import com.pCarpet.converter.AssegnazioneConverter;
import com.pCarpet.converter.BadgeConverter;
import com.pCarpet.dao.AssegnaRepository;
import com.pCarpet.dao.BadgeRepository;
import com.pCarpet.dto.AssegnazioneDTO;
import com.pCarpet.dto.BadgeDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pCarpet.model.Assegnazione;
import com.pCarpet.model.Badge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

@Service
public class BadgeService {
	
	 private BadgeRepository badgeRepository;
	 private AssegnaRepository assegnazioneRepository;
	 	
	 @Autowired
	    public BadgeService(BadgeRepository br, AssegnaRepository assegnazioneRepository) {
	        this.badgeRepository = br;
	        this.assegnazioneRepository=assegnazioneRepository;
	        
	    }
	 public BadgeService() {}

	 	public BadgeRepository getBadgeRepository() {
	 		return this.badgeRepository;
	 	}
	 
	    public List<BadgeDTO> getAllBadges () {
	    	
	    	List<Badge> listBadges = (List<Badge>) this.badgeRepository.findAll();
	    	
	    	List<BadgeDTO> listBDTO=new ArrayList<>();
	    	
	    	for(Badge b: listBadges) {
	    		if(b.getFlag()==1l)
	    		listBDTO.add(BadgeConverter.convertToDTO(b));
	    	}
	    	
	        return listBDTO;
	    }
	    
	    public BadgeDTO getBadge (int id) {
	    	
	    	Badge b=this.badgeRepository.findById(Long.valueOf(id)).get();
	    	
	    	return BadgeConverter.convertToDTO(b);
	    }
	    
	    public List<BadgeDTO> getAllBadgesN () {
	        List<Badge> bList=(List<Badge>) this.badgeRepository.findAll();
	        List<Assegnazione> aList=(List<Assegnazione>) this.assegnazioneRepository.findAll();
	        
	        
	        
	    	List<AssegnazioneDTO> listADTO = new ArrayList<>();
	        List<BadgeDTO> listBDTO=new ArrayList<>();
	        List<BadgeDTO> ll = new LinkedList<>();
	        
	        
	        for(Badge b: bList) {
	        	if(b.getFlag()==1l)
	        	listBDTO.add(BadgeConverter.convertToDTO(b));
	        }
	        for(Assegnazione a: aList) {
	        	listADTO.add(AssegnazioneConverter.convertToDTO(a));
	        }
	        ll.addAll(listBDTO);
	        
	        for(BadgeDTO bbDTO:listBDTO) {
	        	
	        	for(AssegnazioneDTO aaDTO: listADTO) {
	        		
	        		if((bbDTO.getIdBadge()==aaDTO.getBadge().getIdBadge()) && aaDTO.getFlag()==1l) {
	        			ll.remove(bbDTO);
	        		}
	        	}
	        }
	    	return ll;
	    	
	    }

	    public boolean insertBadge (BadgeDTO badgeDTO) {
	    	
	    	Badge badge=BadgeConverter.converToEntity(badgeDTO);
	    	
	        return this.badgeRepository.save(badge)!=null;
	    }
	    public void deleteBadge (long idBadge) {
	    	
	    	Badge badge=badgeRepository.findById(idBadge).get();
	    	badge.setFlag(2l);
	    	
	    	List<Assegnazione> a =new LinkedList<>();
	    	a=(List<Assegnazione>) assegnazioneRepository.findAll();
	    	for (Assegnazione p:a)
	    	{
	    		if(p.getBadge().getIdbadge()==idBadge) {
	    			p.setFlag(2l);
	    		this.assegnazioneRepository.save(p);}
	    	}
	    	
	    	
	    	this.badgeRepository.save(badge);
	    	
	    }
	    
	    public boolean updateBadge(HttpServletRequest request) {
	    	/*
	    	return this.badgeRepository.UpdateBadge(request);
	    	*/
	    	return true;
	    }
	}




