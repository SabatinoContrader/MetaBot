package com.pCarpet.services;


import com.pCarpet.converter.AssegnazioneConverter;
import com.pCarpet.dao.AssegnaRepository;
import com.pCarpet.dto.AssegnazioneDTO;
import com.pCarpet.dto.BadgeDTO;
import com.pCarpet.dto.UserDTO;
import com.pCarpet.model.Assegnazione;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssegnazioneService
{

    private AssegnaRepository assegnaRepository;
    
    private UserService userService;
    
    private BadgeService badgeService;
    
    @Autowired
    public AssegnazioneService(AssegnaRepository ar, UserService us, BadgeService bs)
    {
        this.assegnaRepository = ar;
        this.userService = us;
        this.badgeService = bs;
    }
    
    public AssegnazioneService() {}

    
    public List<AssegnazioneDTO> getAllAssegnazioni ()
    {
        List<Assegnazione> lAss= (List<Assegnazione>)this.assegnaRepository.findAll();
        List<Assegnazione> la=new LinkedList<Assegnazione>();
        for(Assegnazione a:lAss) {
        	if(a.getFlag()==1) {
        		la.add(a);
        	}
        }
        List<AssegnazioneDTO> lDTO=new ArrayList<>();
        for(Assegnazione a: la) {
        	lDTO.add(AssegnazioneConverter.convertToDTO(a));
        	
        }
        
        return lDTO;
        
    }
    
    
    public List<UserDTO> getAllUsers(){
    	List<UserDTO> lUser = this.userService.getAllUsers();
    	return lUser;
    }
    
    public List<BadgeDTO> getAllBadgesN(){
    	List<BadgeDTO> lBadge = this.badgeService.getAllBadgesN();
    	return lBadge;
    }
    
    
    public void assegnaBadge(AssegnazioneDTO assegnazioneDTO)
    {	
    	Assegnazione assegnazione=AssegnazioneConverter.converToEntity(assegnazioneDTO);
    	//System.out.println("dim"+assegnazione.getBadge().size());
    	this.assegnaRepository.save(assegnazione);	
    }
    public void deleteAssegnazione(int iduser,int idbadge) {
    	List<Assegnazione> listAss =(List<Assegnazione>) this.assegnaRepository.findAll();
    	Assegnazione b=new Assegnazione();
    	for(Assegnazione a:listAss) {
    		if(a.getBadge().getIdbadge()==idbadge)
    		{
    			
    			b=a;
    			b.setFlag(2l);
    		}
    	}
    	
    	this.assegnaRepository.save(b);
    	
    }
}


