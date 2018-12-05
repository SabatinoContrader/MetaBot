package com.pCarpet.services;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pCarpet.converter.AssetConverter;
import com.pCarpet.converter.MovimentoConverter;
import com.pCarpet.converter.PrenotazioneConverter;
import com.pCarpet.converter.UserConverter;
import com.pCarpet.dao.AssegnaRepository;
import com.pCarpet.dao.AssetRepository;
import com.pCarpet.dao.BadgeReaderRepository;
import com.pCarpet.dao.MovimentoRepository;
import com.pCarpet.dao.PrenotazioneRepository;
import com.pCarpet.dao.UserRepository;
import com.pCarpet.dto.AssetDTO;
import com.pCarpet.dto.MovimentoDTO;
import com.pCarpet.dto.PrenotazioneDTO;
import com.pCarpet.dto.UserDTO;
import com.pCarpet.model.Assegnazione;
import com.pCarpet.model.Asset;
import com.pCarpet.model.BadgeReader;
import com.pCarpet.model.Movimento;
import com.pCarpet.model.Prenotazione;
import com.pCarpet.model.User;

@Service
public class PrenotazioneService {

	private PrenotazioneRepository prenotazioneRepository;
	private UserService userService;
	private AssetService assetService;
	private MovimentoRepository movimentoRepository;
	private BadgeReaderRepository badgeReaderRepository;
	private AssetRepository assetRepository;
	private AssegnaRepository assegnazioneRepository;
	
	@Autowired
	public PrenotazioneService(AssetRepository ar, BadgeReaderRepository badgeReaderRepository, PrenotazioneRepository prenotazioneRepository, UserService userService, AssetService assetService, MovimentoRepository mr, AssegnaRepository assegnazioneRepository) {
		this.prenotazioneRepository = prenotazioneRepository;
		this.userService = userService;
		this.assetService = assetService;
		this.movimentoRepository = mr;
		this.badgeReaderRepository=badgeReaderRepository;
		this.assegnazioneRepository=assegnazioneRepository;
		
	}

    public List getAllExportPrenotazioni()
    {
    	
    	List<Prenotazione> lPren=new LinkedList<>();
    	List<User> lUser=new LinkedList<>();
    	
    	List<Asset> lAsset=new LinkedList<>();
    	
    	lPren=(List<Prenotazione>)this.prenotazioneRepository.findAll();
    	
    	
    	
    	List<String> l=new LinkedList<>();
    	
    	for(int i=0; i<lPren.size(); i++) {
    		
    		User UP = new User();
    		Asset AP = new Asset();
    		
    		int iduser =Integer.parseInt(String.valueOf(lPren.get(i).getUser().getIduser()));
    		UP=UserConverter.converToEntity(this.userService.getUser(iduser));
    		
    		int idasset =Integer.parseInt(String.valueOf(lPren.get(i).getAsset().getIdasset()));
    		AP=AssetConverter.converToEntity(this.assetService.getAsset(idasset));
    		
        		
        		if(UP.getStato().getFlag()==1)
        			l.add(String.valueOf(UP.getIduser()));
        		else
        			l.add(String.valueOf(UP.getIduser()+" (Deleted)"));
        		
        		
        		l.add(UP.getRagioneSociale());
        		
        		if(AP.getFlag()==1)
        			l.add(String.valueOf(AP.getIdasset()));
        		else
        			l.add(String.valueOf(AP.getIdasset()+" (Deleted)"));
        		
        		l.add(AP.getTipo());
        		l.add(String.valueOf(AP.getPrezzo()));
        		l.add(AP.getDescrizione());
        		
        		l.add(lPren.get(i).getOrainizio());
        		l.add(lPren.get(i).getOrafine());
    		}
    		
    		
    		
    		
    		
    		
    		
    	return l;
    }
    
	
    public List<PrenotazioneDTO> getAllPrenotazioni () {
    	
        List<Prenotazione> listP =(List<Prenotazione>) this.prenotazioneRepository.findAll();
        
        List<PrenotazioneDTO> listDTO=new ArrayList<>();
        
        for(Prenotazione p: listP) {
        	listDTO.add(PrenotazioneConverter.covertToDTO(p));
        }
        
        return listDTO;
        
    }
    
    
    public List<UserDTO> getAllUsers(){
    	List<UserDTO> listU = this.userService.getAllUsers();
    	return listU;
    }
    
    public List<AssetDTO> getAllAssets(){
    	List<AssetDTO> listA = this.assetService.getAllAssets();
    	return listA;
    }
    
    
    public PrenotazioneDTO getPrenotazione (long id) {
    	Prenotazione p= this.prenotazioneRepository.findById(id).get();
    
        //Prenotazione p = this.prenotazioneRepository.findByUserAndAssetAndOrainizio(iduser, idasset, orainizio);
        
        return PrenotazioneConverter.covertToDTO(p);
        
    }
    

    public boolean insertPrenotazione(PrenotazioneDTO pDTO) {
    	Prenotazione p = PrenotazioneConverter.converToEntity(pDTO);
        return this.prenotazioneRepository.save(p)!=null;
    }
    
    public void deleteUser(int iduser, int idasset, String orainizio) {
    	this.prenotazioneRepository.deleteByUserAndAssetAndOrainizio(iduser, idasset, orainizio);
    }
   
    
    public boolean updatePrenotazione(PrenotazioneDTO pDTO) {
    	Prenotazione P=PrenotazioneConverter.converToEntity(pDTO);
    	return this.prenotazioneRepository.save(P)!=null;
    }
    
    public List<MovimentoDTO> getAllUtilizzo(){
    	
    	List<Movimento> mList =(List<Movimento>)this.movimentoRepository.findAll();
    	List<BadgeReader> bList = (List<BadgeReader>) this.badgeReaderRepository.findAll();
    	//List<Asset> aList = (List<Asset>) this.assetRepository.findAll();
    	List<Movimento> mm = new LinkedList<>();
    	List<MovimentoDTO> mDTOList = new ArrayList<>();
    	Asset a = new Asset();
    	BadgeReader br=new BadgeReader();
    	for(Movimento m: mList) 
    	{
    		
    		for(BadgeReader b: bList) {
    		if(m.getBadgereader().getIdBadgeReader()==b.getIdBadgeReader()) {
    			br = b;
    		}
    			
    		
    		}
    		long idasset= a.getIdasset();
    		Assegnazione assegnazione=assegnazioneRepository.findById(7l).get();
    		
    		
    		Movimento mov=new Movimento(0l,br,m.getBadge(),m.getOrainizio(),m.getOrafine(),assegnazione);
    		mm.add(mov);
    		
    	}
    	for(Movimento m: mm)
    		mDTOList.add(MovimentoConverter.convertToDTO(m));
    	return mDTOList;
    }
	
}
