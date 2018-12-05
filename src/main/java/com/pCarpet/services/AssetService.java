package com.pCarpet.services;



import com.pCarpet.converter.AssegnazioneConverter;
import com.pCarpet.converter.AssetConverter;
import com.pCarpet.converter.BadgeConverter;
import com.pCarpet.converter.BadgeReaderConverter;
import com.pCarpet.converter.UserConverter;
import com.pCarpet.dao.AssetRepository;
import com.pCarpet.dao.BadgeReaderRepository;
import com.pCarpet.dto.AssegnazioneDTO;
import com.pCarpet.dto.AssetDTO;
import com.pCarpet.dto.BadgeDTO;
import com.pCarpet.dto.BadgeReaderDTO;
import com.pCarpet.dto.UserDTO;
import com.pCarpet.model.Assegnazione;
import com.pCarpet.model.Asset;
import com.pCarpet.model.Badge;
import com.pCarpet.model.BadgeReader;
import com.pCarpet.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

	@Service
	public class AssetService {

    private AssetRepository assetRepository;
    private BadgeReaderService badgeReaderService;
    private BadgeReaderRepository badgeReaderRepository;
    
    //private UserAssetDAO userAssetDAO;
    
    @Autowired
    public AssetService(AssetRepository assetRepository, BadgeReaderService brs, BadgeReaderRepository brp) {
        this.assetRepository = assetRepository;
        this.badgeReaderService = brs;
        this.badgeReaderRepository = brp;
    }

    public List<AssetDTO> getAllAssets () {
    	
    	
    	List<Asset> aList=(List<Asset>)this.assetRepository.findAll();
    	List<Asset> ll=new LinkedList<Asset>();
    	List<AssetDTO> aDTOlist=new ArrayList<>();
    	
        for(Asset u:aList) {
        	if(u.getFlag()==1) {
        		ll.add(u);
        	}
        }
        
    	for(Asset a: ll) {
    		aDTOlist.add(AssetConverter.convertToDTO(a));
    	}
    	
    	return aDTOlist;
    	
    }
    
    public List<AssetDTO> getAllAssetsN () {
    	
    	List<Asset> aList=(List<Asset>)this.assetRepository.findAll();
    	List<BadgeReader> bList=(List<BadgeReader>)this.badgeReaderRepository.findAll();
        
        
        
    	List<AssetDTO> listADTO = new ArrayList<>();
        List<BadgeReaderDTO> listBRDTO=new ArrayList<>();
        List<AssetDTO> llAS = new LinkedList<>();
        
         for(BadgeReader b: bList) {
        	listBRDTO.add(BadgeReaderConverter.convertToDTO(b));
         }
        for(Asset a: aList) {
        	listADTO.add(AssetConverter.convertToDTO(a));
        }
        llAS.addAll(listADTO);
        for(AssetDTO a:llAS) {

        }
        
        
        for(AssetDTO aaDTO:listADTO) {
        	
        	for(BadgeReaderDTO brDTO: listBRDTO) {
        		if(aaDTO.getIdAsset()==brDTO.getAsset().getIdAsset()) {

        			if(brDTO.getFlag()==1l) {
        				llAS.remove(aaDTO);
        			}
        		}
        	}
        }
    	return llAS;
    	
    }
    public AssetDTO getAsset (long id) {
        Asset a = (Asset)this.assetRepository.findById(id).get();
        return AssetConverter.convertToDTO(a);
    }
    /*
    public List<User> getAllClienti () {
        return this.userDAO.getAllClienti();
    }
    
    public List<User> getAllClientiAss(){
    	return this.userDAO.getAllClientiAss();
    }
    */

    public void insertAsset (AssetDTO assetDTO) {
    	
    	Asset asset = AssetConverter.converToEntity(assetDTO);
    	
        this.assetRepository.save(asset);
        
    }
    
    public void deleteAsset(long id) {
    	Asset ass = assetRepository.findById(id).get();
    	List<BadgeReaderDTO> brList=this.badgeReaderService.getAllBadgeReaders();
    	List<BadgeReader> listBR = new LinkedList<>();
    	 for(BadgeReaderDTO b: brList) {
        	
			listBR.add(BadgeReaderConverter.converToEntity(b));
         }
    	 for(BadgeReader br: listBR) {
    		 if(br.getAsset().getIdasset()==id) {
    			 br.getAsset().setIdasset(1l);
    			 br.setFlag(2l);
    			 br.setDescrizione("non associato");
    			 br.setTipologia("non associato");
    			 badgeReaderRepository.save(br);
    		 }
    		 
    	 }
    	 ass.setFlag(2l);
    	 this.assetRepository.save(ass);
    	
    }
    
    
    
    /*
    public List<User> getAllUsersN(){
    	return this.userAssetDAO.getAllUsersN();
    }
    */
    
//    public boolean updateAsset(HttpServletRequest request) {
//    	return this.assetRepository.updateAsset(request);
//    }
}