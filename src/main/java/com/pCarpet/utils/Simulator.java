package com.pCarpet.utils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.pCarpet.converter.BadgeConverter;
import com.pCarpet.converter.BadgeReaderConverter;
import com.pCarpet.dto.AssegnazioneDTO;
import com.pCarpet.dto.BadgeDTO;
import com.pCarpet.dto.BadgeReaderDTO;
import com.pCarpet.dto.MovimentoDTO;
import com.pCarpet.model.Assegnazione;
import com.pCarpet.model.Badge;
import com.pCarpet.model.BadgeReader;
import com.pCarpet.model.Movimento;
import com.pCarpet.services.AssegnazioneService;
import com.pCarpet.services.MovimentoService;
import com.pCarpet.services.BadgeReaderService;
import com.pCarpet.services.BadgeService;

public class Simulator {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		MovimentoService movimentoService = new MovimentoService();
		AssegnazioneService assegnazioneService = new AssegnazioneService();
		BadgeReaderService badgereaderService = new BadgeReaderService();
		BadgeService badgeService = new BadgeService();
		List<MovimentoDTO> listMovimenti = new ArrayList<>();
		List<AssegnazioneDTO> listAssegnazioni = new ArrayList<>();
		String message;
		int idUser = 0;
		boolean found;
		boolean access;
		while (true) {
			found = false;
			System.out.println("-------SIMULATOR-------");
	        System.out.println("");
	        System.out.println("Inserimento Badge Reader");
	        int idBadgeReader = Integer.parseInt(scanner.nextLine());
	        System.out.println("Inserimento Badge");
	        int idBadge = Integer.parseInt(scanner.nextLine());
	        String dateNow = LocalDateTime.now().toString();
	        listMovimenti = movimentoService.getAllMovimenti();
	        for (MovimentoDTO movimento : listMovimenti) {
	        	if ((movimento.getBadgereader().getIdBadgeReader() == idBadgeReader) && (movimento.getOrafine().equals("0000-00-00 00:00:00"))) {
	        		if (movimento.getBadge().getIdBadge() == idBadge) {
	        			message = "Uscita Badge " + idBadge;
	        			System.out.println(message);
	        			if (movimentoService.updateMovimento(movimento.getBadgereader().getIdBadgeReader(), movimento.getBadge().getIdBadge(), movimento.getOrainizio(), dateNow)) {
	        				message = "Uscita Badge " + idBadge + " Avvenuta Correttamente";
	        			}
	        			else {
	        				message = "Errore Uscita Badge " + idBadge;
	        			}
	        			System.out.println(message);
	        			found = true;
	        			break;
	        		}
	        		else {
	        			access = false;
	        			listAssegnazioni = assegnazioneService.getAllAssegnazioni();
	    	            for (AssegnazioneDTO assegnazione : listAssegnazioni) {
	    	            	if ((assegnazione.getBadge().getIdBadge() == idBadge) && (assegnazione.getUser().getIduser() == idUser)) {
	    	            		access = true;
	    	            		message = "Badge Appartenente Organizzazione, Accesso Consentito";
	    	        			System.out.println(message);
	    	            		break;
	    	            	}	
	    	            }
	    	            if (! access) {
	    	            	message = "Asset Occupato, Impossibile Accedere";
	    	            	System.out.println(message);
	    	            	found = true;
	    	            	break;
	    	            }
	        		}
	        	}
	        }	
	        if (! found) {
	        	message = "Ingresso Badge " + idBadge;
	            System.out.println(message);
	            listAssegnazioni = assegnazioneService.getAllAssegnazioni();
	            for (AssegnazioneDTO assegnazione : listAssegnazioni) {
	            	if (assegnazione.getBadge().getIdBadge() == idBadge) {
	            		idUser = Integer.parseInt(String.valueOf(assegnazione.getUser().getIduser()));
	            		break;
	            	}	
	            }
	            List<BadgeReaderDTO> bb = badgereaderService.getBadgeReader(idBadgeReader);
	            BadgeReader br = BadgeReaderConverter.converToEntity(bb.get(0));
	            BadgeDTO bg = badgeService.getBadge(idBadge);
	            Badge bgg = BadgeConverter.converToEntity(bg);
	            long idmov=movimentoService.getMovimento(br,bgg,LocalDateTime.now().toString());
	        	
	        	
	        	Movimento movimento = new Movimento(idmov,br, bgg, dateNow,"0000-00-00 00:00:00");
	            if (movimentoService.insert(movimento)) {
	            	message = "Ingresso Badge " + idBadge + " Avvenuto correttamente";
	            }
	            else {
	            	message = "Errore Ingresso Badge " + idBadge;
	            }
	            System.out.println(message);
	        }
		}
	}

}