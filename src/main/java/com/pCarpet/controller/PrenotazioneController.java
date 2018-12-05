package com.pCarpet.controller;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pCarpet.dto.MovimentoDTO;
import com.pCarpet.dto.PrenotazioneDTO;
import com.pCarpet.dto.UserDTO;
import com.pCarpet.dto.AssetDTO;
import com.pCarpet.services.AssetService;
import com.pCarpet.services.PrenotazioneService;
import com.pCarpet.services.UserService;

@Controller
@RequestMapping("/HomePrenotazione")
public class PrenotazioneController {
	
	private PrenotazioneService prenotazioneService;
	private AssetService assetService;
	private UserService userService;
	private List<UserDTO> listUser;
	private List<AssetDTO> listAssets;
	
	private boolean isLogged = false;
	
	private PrenotazioneDTO p=null;
	private UserDTO u=null;
	private AssetDTO a=null;
	
	private long idP;

	@Autowired
	public PrenotazioneController(PrenotazioneService prenotazioneService, UserService userService, AssetService assetService) {
		this.prenotazioneService = prenotazioneService;
		this.assetService=assetService;
		this.userService= userService;
	}

	@RequestMapping(value = "/showPrenotazione", method = RequestMethod.GET)
	public String loginControl(HttpServletRequest request, Model model ) {
		
		List<PrenotazioneDTO> listPrenotazione;
				
		String choice=request.getParameter("choice");
		
		if(choice != null) {
			switch(choice) {
		
				case "managementPrenotazioni":
					listUser = userService.getAllUsers();
					listAssets = assetService.getAllAssets();
					listPrenotazione = prenotazioneService.getAllPrenotazioni();
					listPrenotazione = aggiornaPrenotazioni(listPrenotazione);
					model.addAttribute("listPrenotazione", listPrenotazione);
					model.addAttribute("listAssets", listAssets);
					model.addAttribute("listUsers", listUser);
					return "insertBookings";
				
				case "insert":
					listPrenotazione = prenotazioneService.getAllPrenotazioni();
					listPrenotazione = aggiornaPrenotazioni(listPrenotazione);
					model.addAttribute("listPrenotazione", listPrenotazione);
					return "insertBookings";
					
				case "update":
					//model.addAttribute("user",userService.getUser(Integer.parseInt(request.getParameter("id"))));
					idP=Integer.parseInt(request.getParameter("idP"));
//					int idasset=Integer.parseInt(request.getParameter("idA"));
//					String orainizio=request.getParameter("idO");
					
					p=prenotazioneService.getPrenotazione(idP);
					//prenotazioneService.updatePrenotazione(request);
					model.addAttribute("p",p);
					return "updateBookings";
					
				case "indietro":
					listUser = userService.getAllUsers();
					listAssets = assetService.getAllAssets();
					listPrenotazione = prenotazioneService.getAllPrenotazioni();
					listPrenotazione = aggiornaPrenotazioni(listPrenotazione);
					model.addAttribute("listPrenotazione", listPrenotazione);
					model.addAttribute("listAssets", listAssets);
					model.addAttribute("listUsers", listUser);
					return "insertBookings";
					
				case "indietroManagementBookings":
					listPrenotazione = prenotazioneService.getAllPrenotazioni();
					listPrenotazione = aggiornaPrenotazioni(listPrenotazione);
					model.addAttribute("listPrenotazione", listPrenotazione);
					return "homeSegretaria";
			}
		}
		
		return "insertBookings";
	}
	
	
	@RequestMapping(value = "/showPrenotazione", method = RequestMethod.POST)
	public String loginControlPost(HttpServletRequest request, Model model ) {
		
		List<PrenotazioneDTO> listPrenotazione = prenotazioneService.getAllPrenotazioni();
		listPrenotazione = aggiornaPrenotazioni(listPrenotazione);
		model.addAttribute("listPrenotazione", listPrenotazione);
			
		String choice=request.getParameter("choice");
	
		if(choice != null) {
			switch(choice) {
				case "insert":
					
					int iduser=Integer.parseInt(request.getParameter("iduser"));
					UserDTO userDTO = this.userService.getUser(iduser);
					int idasset=Integer.parseInt(request.getParameter("idasset"));
					AssetDTO assetDTO = this.assetService.getAsset(idasset);
					String oldOrainizio=request.getParameter("orainizio");
					System.out.println("TEST:"+oldOrainizio);
					String oldOrafine=request.getParameter("orafine");
					
					String orainizio=formatData(oldOrainizio);
					String orafine=formatData(oldOrafine);
					System.out.println("TEST:"+orainizio);
					listPrenotazione = prenotazioneService.getAllPrenotazioni();
					listPrenotazione = aggiornaPrenotazioni(listPrenotazione);
					
					boolean corretto=true;
					
					
					if(orafine.compareTo(orainizio)<=0) {
						corretto=false;
					}
					
					
					if( orainizio.compareTo(formatDataNow(LocalDateTime.now().toString()))<0) {
						corretto=false;
					}
					
					
					for(MovimentoDTO u: prenotazioneService.getAllUtilizzo()){
						if ( u.getBadgereader().getIdBadgeReader()==idasset && formatData(u.getOrafine()).equals("0000-00-00 00:00:00") ) {
							corretto=false;
						}
					}
					
					
					
					listPrenotazione = aggiornaPrenotazioni(listPrenotazione);
					
					for(PrenotazioneDTO p: listPrenotazione) {
						
						if( idasset==p.getAsset().getIdAsset() ) {
							
							String prenotazioneOrainizio = formatData(formatDataPoint(p.getOrainizio()));
							String prenotazioneOrafine = formatData(formatDataPoint(p.getOrafine()));
							System.out.println("PRENOTAZIONE ORA INIZIO:"+prenotazioneOrainizio+" ORA INIZIO:"+orainizio);
							if( (orainizio.compareTo(prenotazioneOrainizio)>=0 && orainizio.compareTo(prenotazioneOrafine)<0) ||
							    (orafine.compareTo(prenotazioneOrainizio)>0 && orafine.compareTo(prenotazioneOrafine)<=0) ) {
								corretto=false;
							}
							
							if( orainizio.compareTo(prenotazioneOrainizio)<=0 && orafine.compareTo(prenotazioneOrafine)>=0 ) {
								corretto=false;
								
							}
							
						}
						
					}
					
					if(corretto) {
						
						
						
						
						PrenotazioneDTO p=new PrenotazioneDTO(0l,userDTO,assetDTO,request.getParameter("orainizio"),request.getParameter("orafine"));
						prenotazioneService.insertPrenotazione(p);
						model.addAttribute("feedback", "success");
					}else {
						model.addAttribute("feedback", "wrong");
					}
					
					
					listUser = userService.getAllUsers();
					listAssets = assetService.getAllAssets();
					listPrenotazione = prenotazioneService.getAllPrenotazioni();
					listPrenotazione = aggiornaPrenotazioni(listPrenotazione);
					
					model.addAttribute("listPrenotazione", listPrenotazione);
					model.addAttribute("listAssets", listAssets);
					model.addAttribute("listUsers", listUser);
					
					return "insertBookings";
					
				case "update":
					
					
					orainizio=formatData(request.getParameter("orainizio"));
					request.setAttribute("orainizio",request.getParameter("orainizio"));
					
					orafine=formatData(request.getParameter("orafine"));
					request.setAttribute("orafine",request.getParameter("orafine"));
					
					System.out.println(request.getParameter("id1"));
					System.out.println(request.getParameter("id2"));
					
					iduser=Integer.parseInt(request.getParameter("id1"));
					idasset=Integer.parseInt(request.getParameter("id2"));
					
					System.out.println(idP);
					
					
					UserDTO user1DTO = this.userService.getUser(iduser);
					AssetDTO asset1DTO = this.assetService.getAsset(idasset);
					PrenotazioneDTO pDTO=new PrenotazioneDTO(idP,user1DTO,asset1DTO,request.getParameter("orainizio"),request.getParameter("orafine"));
					
					

					
				
					
					
					
					listPrenotazione = prenotazioneService.getAllPrenotazioni();
					listPrenotazione = aggiornaPrenotazioni(listPrenotazione);
					
					corretto=true;
					
					
					if(orafine.compareTo(orainizio)<=0) {
						corretto=false;
					}
					
					
					if( orainizio.compareTo(formatDataNow(LocalDateTime.now().toString()))<0) {
						corretto=false;
					}
					
					
					for(MovimentoDTO u: prenotazioneService.getAllUtilizzo()){
						if ( u.getBadgereader().getIdBadgeReader()==idasset && u.getOrafine().equals("0000-00-00 00:00:00") ) {
							corretto=false;
						}
					}
					
					
					
					listPrenotazione = aggiornaPrenotazioni(listPrenotazione);
					
					int cont1=0;
					int cont2=0;
					
					for(PrenotazioneDTO p: listPrenotazione) {
						
						if( idasset==p.getAsset().getIdAsset() ) {
							
							String prenotazioneOrainizio = formatDataPoint(p.getOrainizio());
							String prenotazioneOrafine = formatDataPoint(p.getOrafine());
							
							if( (orainizio.compareTo(prenotazioneOrainizio)>=0 && orainizio.compareTo(prenotazioneOrafine)<0) ||
							    (orafine.compareTo(prenotazioneOrainizio)>0 && orafine.compareTo(prenotazioneOrafine)<=0) ) {
//								System.out.println("prenotazione già presente 1");
								cont1++;
								
							}
							
							if( orainizio.compareTo(prenotazioneOrainizio)<=0 && orafine.compareTo(prenotazioneOrafine)>=0 ) {
//								System.out.println("prenotazione già presente 2");
								cont2++;
								
								
							}
							
						}
						
					}
					
					if(cont1>1)
						corretto=false;
					if(cont2>2)
						corretto=false;
					
					if(corretto) {
//						System.out.println("corretto");
						
						prenotazioneService.updatePrenotazione(pDTO);
						
//						orainizio=request.getParameter("id3");
//						
//						PrenotazioneDTO p= prenotazioneService.getPrenotazione(iduser, idasset, orainizio);
						listUser = userService.getAllUsers();
						listAssets = assetService.getAllAssets();
						listPrenotazione = prenotazioneService.getAllPrenotazioni();
						listPrenotazione = aggiornaPrenotazioni(listPrenotazione);
						model.addAttribute("listPrenotazione", listPrenotazione);
						model.addAttribute("listAssets", listAssets);
						model.addAttribute("listUsers", listUser);
						
						//model.addAttribute("p", p);
						model.addAttribute("feedback", "success");
						return "insertBookings";
						
					}else {						
						listUser = userService.getAllUsers();
						listAssets = assetService.getAllAssets();
						listPrenotazione = prenotazioneService.getAllPrenotazioni();
						listPrenotazione = aggiornaPrenotazioni(listPrenotazione);
						model.addAttribute("listPrenotazione", listPrenotazione);
						model.addAttribute("listAssets", listAssets);
						model.addAttribute("listUsers", listUser);
						
						model.addAttribute("feedback", "wrong");
						return "insertBookings";
					}
					
					
					
					
					
					
					
				
					
			}
		}
	
		return "homeBookings";
		
	}
	
	
	
	//OLD DATE
	//datetime-local --> gg/mm/yyyy hh.mm (es. 29/09/2018 10.29)
	//NEW DATE
	//String --> yyyy-mm-gg hh:mm:ss (es. 2018-09-29 10:29:00)
	public String formatData(String oldDate) {
		
		StringTokenizer st=new StringTokenizer(oldDate,"/.-T: ");
		String newDate="";
		
		int index=0;
		
		while(st.hasMoreTokens()) {
			index += 1;
			String tk=st.nextToken();
			if(tk.length()>=3 && tk.charAt(2)==('.')) {
				String temp=tk.substring(0, 1);
				tk=temp+tk.substring(1,2);
				newDate+=tk;
				break;
			}
			if(index<3) {
				newDate+=tk;
				newDate+="-";
			}
			else if(index==3) {
				newDate+=tk;
				newDate+=" ";
			}
			else if(index<5) {//index<6 se nella data ci sono anche i secondi
				newDate+=tk;
				newDate+=":";
			}else {
				newDate+=tk;
			}//if
			
		}//while
		
		newDate+=":00";
		
		return newDate;
		
		
	}//formatData
	
	
	
	//OLD DATE
	//LocalDateTime --> yyyy-mm-ggThh:mm:ss.mls (es. 2018-09-29T10:29:51.025) CAMBIA L'ULTIMO ELSE IF
	//NEW DATE
	//String --> yyyy-mm-gg hh:mm:ss (es. 2018-09-29 10:29:00)
	public String formatDataNow(String oldDate) {
		
		
		StringTokenizer st2=new StringTokenizer(LocalDateTime.now().toString(),"/.-T: ");
		String newDate="";
		
		int ind=0;
		
		while(st2.hasMoreTokens()) {
			ind += 1;
			String tk=st2.nextToken();
			if(ind==6) {
				newDate+="00";
				break;
			}
			if(ind<3) {
				newDate+=tk;
				newDate+="-";
			}
			else if(ind==3) {
				newDate+=tk;
				newDate+=" ";
			}
			else if(ind<6) {
				newDate+=tk;
				newDate+=":";
			}else {
				newDate+=tk;
			}//if
			
		}//while
		
		return newDate;
		
	}//formatDataNow
	
	
	
public String formatDataPoint(String oldDate) {
		
		
		StringTokenizer st2=new StringTokenizer(oldDate,".");
		String newDate="";
		
		int ind=0;
		
		while(st2.hasMoreTokens()) {
			newDate+=st2.nextToken();
			break;
			
			
		}//while
		
		return newDate;
		
	}//formatDataPoint
	
	
	public List<PrenotazioneDTO> aggiornaPrenotazioni(List<PrenotazioneDTO> listPrenotazione){
		List<PrenotazioneDTO> pAll = new ArrayList<>();
		
		for(PrenotazioneDTO p: listPrenotazione) {
			
			if( p.getOrafine().compareTo(formatDataNow(LocalDateTime.now().toString()))>=0 ){
				pAll.add(p);
			}
			
		}
		
	
		listPrenotazione=new ArrayList<>();
		
		listPrenotazione.addAll(pAll);
		
		return listPrenotazione;
	}
	
}
