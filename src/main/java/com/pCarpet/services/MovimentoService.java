package com.pCarpet.services;

import com.pCarpet.converter.BadgeConverter;
import com.pCarpet.converter.MovimentoConverter;
import com.pCarpet.dao.AssegnaRepository;
import com.pCarpet.dao.AssetRepository;
import com.pCarpet.dao.BadgeReaderRepository;
import com.pCarpet.dao.BadgeRepository;
import com.pCarpet.dao.MovimentoRepository;
import com.pCarpet.dao.UserRepository;
import com.pCarpet.dto.BadgeDTO;
import com.pCarpet.dto.ExportDTO;
import com.pCarpet.dto.MovimentoDTO;
import com.pCarpet.model.Assegnazione;
import com.pCarpet.model.Asset;
import com.pCarpet.model.Badge;
import com.pCarpet.model.BadgeReader;
import com.pCarpet.model.Movimento;
import com.pCarpet.model.User;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//ATTENZIONE!
//Quando avviene l'inserimento di un Movimento bisogna impostare l'idAssegnazione tramite java
//in base al valore del flag(1) dentro Assegnazione.

@Service
public class MovimentoService {

   private BadgeRepository badgeRepository;
   private MovimentoRepository movimentoRepository;
   private AssegnaRepository assegnazioneRepository;
   private UserRepository userRepository;
   private AssetRepository assetRepository;
   private BadgeReaderRepository badgeReaderRepository;
   
   	
   @Autowired
   public MovimentoService(BadgeRepository badgeRepository, MovimentoRepository movimentoRepository, AssegnaRepository assegnazioneRepository, UserRepository userRepository, AssetRepository assetRepository,BadgeReaderRepository badgeReaderRepository) {
	   this.badgeRepository=badgeRepository;
	   this.movimentoRepository=movimentoRepository;
	   this.assegnazioneRepository=assegnazioneRepository;
	   this.userRepository=userRepository;
	   this.assetRepository=assetRepository;
	   this.badgeReaderRepository= badgeReaderRepository;
   }
   
   public MovimentoService(){
	   
   }
	
	
   public List<BadgeDTO> getAllBadges () {
    	
    	List<Badge> bList=(List<Badge>)this.badgeRepository.findAll();
    	
    	List<BadgeDTO> bDTO=new ArrayList<>();

    	for(Badge b: bList) {
    		bDTO.add(BadgeConverter.convertToDTO(b));
    	}
    	
        return bDTO;
    }
    public boolean updateMovimento(long idbadgereader, long idbadge, String orainizio, String orafine) {
    	BadgeReader bb = badgeReaderRepository.findById(idbadgereader).get();
    	Badge bg= badgeRepository.findById(idbadge).get();
    	Movimento m = movimentoRepository.findByBadgereaderAndBadgeAndOrainizio(bb,bg,orainizio);
    	long idmov=m.getIdmovimento();
    	Movimento mov = new Movimento(idmov,bb, bg, orainizio, orafine);
    	
    	return this.movimentoRepository.save(mov)!=null;
    	
    }
    
    
    public boolean updateMovimento(long idmov, long idbadgereader, long idbadge, String orainizio, String orafine, Assegnazione ass) {
    	BadgeReader bb = badgeReaderRepository.findById(idbadgereader).get();
    	Badge bg= badgeRepository.findById(idbadge).get();
    	
    	
    	Movimento mov = new Movimento(idmov,bb, bg, orainizio, orafine,ass);
    	
    	return this.movimentoRepository.save(mov)!=null;
    	
    }
    
    public long getMovimento(BadgeReader bb, Badge bg, String orafine) {
    	
    	Movimento m = movimentoRepository.findByBadgereaderAndBadgeAndOrafine(bb,bg,orafine);
    	List<Movimento> lMov=(List<Movimento>)movimentoRepository.findAll();
    	Movimento mm=new Movimento();
    	
    	for(Movimento movimento: lMov) {
    		if(movimento.getBadgereader().getIdBadgeReader()==bb.getIdBadgeReader() && movimento.getBadge().getIdbadge()==bg.getIdbadge() && movimento.getOrafine().equals(orafine)) {
    			
    			mm=movimento;
    		}
    	}
    	
    	System.out.println(mm.getIdmovimento());
    	
    	return mm.getIdmovimento();
    }
    
    public boolean insert(Movimento movimento) {
    	return this.movimentoRepository.save(movimento)!=null;
    }
    
    public List<MovimentoDTO> getAllMovimenti () {
    	
    	List<Movimento> bList=(List<Movimento>)this.movimentoRepository.findAll();
    	
    	List<Assegnazione> aList = (List<Assegnazione>)this.assegnazioneRepository.findAll();
    	
    	List<Movimento> listUserMov = new LinkedList<>();
    	
    	for(Movimento m: bList) {
    		for(Assegnazione a: aList) {
    			
    			if(m.getBadge().getIdbadge()==a.getBadge().getIdbadge() && a.getFlag()==1l) {
    				listUserMov.add(m);
    			}
    			
    		}
    	}
    		
    	
    	List<MovimentoDTO> mDTO=new ArrayList<>();

    	for(Movimento m: listUserMov) {
    		mDTO.add(MovimentoConverter.convertToDTO(m));
    	}
    	
        return mDTO;
    	
    }
    
    public List<MovimentoDTO> getAllUserMovimenti (String iduser) {
    	
    	
    	List<Movimento> bList=(List<Movimento>)this.movimentoRepository.findAll();
    	
    	
    	
    	List<MovimentoDTO> mDTO=new ArrayList<>();

    	for(Movimento m: bList) {
    		mDTO.add(MovimentoConverter.convertToDTO(m));
    	}
    	
        return mDTO;
    }
    
    
    public List<String> getAllExportMovimenti() {
    	
    	List<Movimento> lMov=new LinkedList<>();
    	
    	lMov=(List<Movimento>)this.movimentoRepository.findAll();
    	
    	
    	
    	List<String> l=new LinkedList<>();
    	
    	for(int i=0; i<lMov.size(); i++) {
    		Assegnazione a=this.assegnazioneRepository.findById(lMov.get(i).getAssegnazione().getIdassegnazione()).get();

    			User u=this.userRepository.findById(a.getUser().getIduser()).get();
    			BadgeReader br=this.badgeReaderRepository.findById(lMov.get(i).getBadgereader().getIdBadgeReader()).get();
        		Asset asset=this.assetRepository.findById(br.getAsset().getIdasset()).get();
    		
        		System.out.println("Badge movimento: "+lMov.get(i).getBadge().getIdbadge());
        		System.out.println("Badge assegnazione: "+a.getBadge().getIdbadge());
        		
        		
        			System.out.println("Entrato! Utente: "+ u.getIduser());
        			if(a.getFlag()==1l && u.getStato().getFlag()==1l)
            			l.add(String.valueOf(u.getIduser()));
            		else
            			l.add(String.valueOf(u.getIduser()+" (Deleted)"));
            		
            		l.add(u.getRagioneSociale());
            		l.add(a.getNome());
            		l.add(a.getCognome());
            		
            		
            		l.add(String.valueOf(asset.getIdasset()));
            		l.add(asset.getTipo());
            		l.add(String.valueOf(asset.getPrezzo()));
            		l.add(asset.getDescrizione());
            		
            		l.add(lMov.get(i).getOrainizio());
            		l.add(lMov.get(i).getOrafine());
        		

    		
    	}
    	
    	
    	
    	return l;
    }
    
    public List getExportMovimento(String iduser1) {
    	
    	List<Movimento> lMov=new LinkedList<>();
    	
    	lMov=(List<Movimento>)this.movimentoRepository.findAll();
    	
    	
    	
    	List<String> l=new LinkedList<>();
    	
    	for(int i=0; i<lMov.size(); i++) {
    		
    		Assegnazione a=this.assegnazioneRepository.findById(lMov.get(i).getAssegnazione().getIdassegnazione()).get();
    		
    			User u=this.userRepository.findById(a.getUser().getIduser()).get();
    			
    			if(String.valueOf(u.getIduser()).equals(iduser1)) {
    				
    			
    			
    			BadgeReader br=this.badgeReaderRepository.findById(lMov.get(i).getBadgereader().getIdBadgeReader()).get();
        		Asset asset=this.assetRepository.findById(br.getAsset().getIdasset()).get();
        		
        		if(a.getFlag()==1l && u.getStato().getFlag()==1l)
        			l.add(String.valueOf(u.getIduser()));
        		else
        			l.add(String.valueOf(u.getIduser()+" (Deleted)"));
        		
        		l.add(u.getRagioneSociale());
        		l.add(a.getNome());
        		l.add(a.getCognome());
        		
        		
        		l.add(String.valueOf(asset.getIdasset()));
        		l.add(asset.getTipo());
        		l.add(String.valueOf(asset.getPrezzo()));
        		l.add(asset.getDescrizione());
        		
        		l.add(lMov.get(i).getOrainizio());
        		l.add(lMov.get(i).getOrafine());
        		
    			}
        	
    		
    		
    		
    		
    		
    		
    	}
    	
    	
    	
    	return l;
    
    	
    }
    
    
    
  /*  public List<BadgeReader> getAllBadgeReaders () {
        return (((BadgeReaderDAO) this.badgeReaderDAO).getBadgeReaders());
    }
*/
    
    
    //LO FA UMBERTO
    
//    public boolean insertMovimento (Movimento movimento) {
//        return this.movimentoRepository.insertMovimento(movimento);
//    }
    
//    public boolean deleteMovimento (int idBadgeReader, int idBadge, String datainizio) {
//        return this.movimentoRepository.deleteMovimento(idBadgeReader, idBadge, datainizio);
//    }
}
