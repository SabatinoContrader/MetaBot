package com.pCarpet.controller;


import com.pCarpet.dto.AssegnazioneDTO;
import com.pCarpet.dto.BadgeDTO;
import com.pCarpet.dto.UserDTO;
import com.pCarpet.model.Assegnazione;
import com.pCarpet.services.AssegnazioneService;
import com.pCarpet.services.BadgeService;
import com.pCarpet.services.UserService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/Assegnazione")
public class AssegnazioneController {
    private AssegnazioneService assegnazioneService;
    private BadgeService badgeService;
    private UserService userService;
    private List<UserDTO> listUsers;
    private List<BadgeDTO> listBadges;
    private List<AssegnazioneDTO> listAssegnazioni;

	

	@Autowired
	public AssegnazioneController(UserService userService, AssegnazioneService assegnazioneService, BadgeService badgeService) {
		this.userService = userService;
		this.assegnazioneService= assegnazioneService;
		this.badgeService = badgeService;
	}

	
	
	@RequestMapping(value = "/homeAssegnazione", method = RequestMethod.GET)
	public String AsseBad(HttpServletRequest request) {
		String scelta= request.getParameter("scelta");
		
		if (scelta.equals("assegnazioneManagement")) {
			this.listAssegnazioni = this.assegnazioneService.getAllAssegnazioni();
    	this.listUsers = this.userService.getAllUsers();
    	this.listBadges = this.badgeService.getAllBadgesN();
        request.setAttribute("visualAssegnazioni", listAssegnazioni);
        request.setAttribute("visualUsers", listUsers);
        request.setAttribute("visualBadges", listBadges);
			return "homeAssegnazione";}
		else if (scelta.equals("indietro"))
			return "homeCustomers";
		else if (scelta.equals("rimuovi"))
		{
			int id3=Integer.parseInt(request.getParameter("idUser"));
        	request.setAttribute("id1", id3);
        	int id4=Integer.parseInt(request.getParameter("idBadge"));
        	request.setAttribute("id2", id4);
        	
        	this.assegnazioneService.deleteAssegnazione(id3,id4);
        	
        	this.listAssegnazioni = this.assegnazioneService.getAllAssegnazioni();
        	this.listUsers = this.assegnazioneService.getAllUsers();
        	this.listBadges = this.assegnazioneService.getAllBadgesN();
            request.setAttribute("visualAssegnazioni", listAssegnazioni);
            request.setAttribute("visualUsers", listUsers);
            request.setAttribute("visualBadges", listBadges);
            return "homeAssegnazione";
		}
		else
			return "";
	}
	
	@RequestMapping(value = "/homeAssegnazione", method = RequestMethod.POST)
	public String Asse(HttpServletRequest request) {
		String scelta= request.getParameter("scelta");
		if (scelta.equals("insert")) {
			int iduser=Integer.parseInt(request.getParameter("user"));
        	int idbadge=Integer.parseInt(request.getParameter("badge"));
        	String nome=request.getParameter("nome");
        	String cognome=request.getParameter("cognome");
        	UserDTO userDTO = this.userService.getUser(iduser);
        	BadgeDTO badgeDTO = this.badgeService.getBadge(idbadge);
			AssegnazioneDTO a=new AssegnazioneDTO(0l,userDTO,badgeDTO,nome,cognome,LocalDateTime.now().toString(),1l);
			assegnazioneService.assegnaBadge(a);
        	this.listAssegnazioni = this.assegnazioneService.getAllAssegnazioni();
        	this.listUsers = this.userService.getAllUsers();
        	this.listBadges = this.badgeService.getAllBadgesN();
            request.setAttribute("visualAssegnazioni", listAssegnazioni);
            request.setAttribute("visualUsers", listUsers);
            request.setAttribute("visualBadges", listBadges);
        	return "homeAssegnazione";
	}
		return "";
}}