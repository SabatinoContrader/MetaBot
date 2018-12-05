package com.pCarpet.controller;


import com.pCarpet.dto.AssetDTO;
import com.pCarpet.dto.BadgeReaderDTO;
import com.pCarpet.dto.UserDTO;
import com.pCarpet.services.AssetService;
import com.pCarpet.services.BadgeReaderService;

import com.pCarpet.services.UserService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/BadgeReader")
public class BadgeReaderController {
	private String message;
	private BadgeReaderService badgeReaderService;
	private AssetService assetService;
	private List<BadgeReaderDTO> allBadgeReader;
	private List<AssetDTO> allAssets;
	private List<AssetDTO> allAssets1;
	

	

	@Autowired
	public BadgeReaderController(AssetService assetService,BadgeReaderService badgeReaderService) {
		this.assetService = assetService;
		this.badgeReaderService=badgeReaderService;
	}
	
	@RequestMapping(value = "/homeBadgeReader", method = RequestMethod.POST)
	public String AsseBad2(HttpServletRequest request) {
		String scelta= request.getParameter("scelta");
		
		if (scelta.equals("insert")) {
			 allAssets1 = this.assetService.getAllAssetsN();
        	 request.setAttribute("allAssets", allAssets1);
		return "insertBadgeReader";
		
		}
		else if (scelta.equals("insertbadgereader")) {
			if (request != null) 
			{
            long idbadgereader = 0l;
            String descrizione = request.getParameter("descrizione").toString();
            String tipologia = request.getParameter("tipologia").toString();
            long idasset = Integer.parseInt(request.getParameter("idasset"));
            AssetDTO ADTO = this.assetService.getAsset(idasset);
            badgeReaderService.insertBadgeReader(new BadgeReaderDTO( idbadgereader,ADTO, descrizione, tipologia )); 
            this.allBadgeReader = this.badgeReaderService.getAllBadgeReaders();
            request.setAttribute("visualizzaBadgeReaders", this.allBadgeReader);
            return ("badgeReaderHome");
               	} 
              	}
		else if (scelta.equals("indietro")) {
			this.allBadgeReader = this.badgeReaderService.getAllBadgeReaders();
            request.setAttribute("visualizzaBadgeReaders", allBadgeReader);
        	return "badgeReaderHome";
        	}
		return "";}
		
		
		
	
	
	
	@RequestMapping(value = "/homeBadgeReader", method = RequestMethod.GET)
	public String AsseBad(HttpServletRequest request) {
		String scelta= request.getParameter("scelta");
		//this.assetService = new AssetService();
    	this.message = "";
    	
		if (scelta.equals("BadgeReaderManagement")) {
			this.allBadgeReader = this.badgeReaderService.getAllBadgeReaders();
			
            request.setAttribute("visualizzaBadgeReaders", allBadgeReader);
        	
			return "badgeReaderHome";}
		
		if (scelta.equals("indietro")) {
			this.allBadgeReader = this.badgeReaderService.getAllBadgeReaders();
            request.setAttribute("visualizzaBadgeReaders", allBadgeReader);
        	return "homeAssBadRead";
        	}
		else if (scelta.equals("update")) {
			int id=Integer.parseInt(request.getParameter("id"));
				
				request.setAttribute("id1", id);
            	request.setAttribute("id", this.badgeReaderService.getBadgeReader(id));
            	this.allAssets = this.assetService.getAllAssets();
                request.setAttribute("allAssets", allAssets);
                return "updateBadgeReader";
		 }
		 if (scelta.equals("updateBadgeReader")) {
			 int a=Integer.parseInt(request.getParameter("asset"));
             int b=Integer.parseInt(request.getParameter("Badge"));
             request.setAttribute("asset", a);
         	 request.setAttribute("Badge", b);
		 }
//         	 if (badgeReaderService.updateBadgeReader(request)) {
//          		this.message = "Aggiornamento asset avvenuto correttamente";
//          	}
//          	else {
//          		this.message = "Errore durante la procedura di aggiornamento asset";
//          	}
//          	request.setAttribute("message", this.message);
//          	request.setAttribute("visualizzaAssets", this.assetService.getAllAssets());
//          	request.setAttribute("visualizzaBadgeReaders", this.badgeReaderService.getAllBadgeReaders());
//          	return "badgeReaderHome";
//	}
			
			if (scelta.equals("Delete"))
				this.badgeReaderService.deleteBadgeReadear(Integer.parseInt(request.getParameter("delBadgeReader")));
            		
            		this.message = "Cancellazione asset avvenuto correttamente";
            	      	
            	request.setAttribute("message", this.message);
            	this.allBadgeReader = this.badgeReaderService.getAllBadgeReaders();
                request.setAttribute("visualizzaBadgeReaders", this.allBadgeReader);
			return "badgeReaderHome";
	}
}