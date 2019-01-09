package com.pCarpet.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pCarpet.dto.ChatbotDTO;
import com.pCarpet.dto.NodoDTO;
import com.pCarpet.model.Nodo;
import com.pCarpet.services.ChatbotService;
import com.pCarpet.services.NodoService;
import com.pCarpet.utils.FunzioniDiUtilita;

@Controller
@RequestMapping("/Nodo")
public class NodoController {

	private final NodoService nodoService;
	private final ChatbotService chatbotService;	
	
	@Autowired
	public NodoController(NodoService nodoService, ChatbotService chatbotService) {
		this.nodoService = nodoService;
		this.chatbotService = chatbotService;
	}

	@RequestMapping(value = "/nodoDirectory", method = RequestMethod.GET)
	public String nodoDirectoryGET(HttpServletRequest request) {
		final String choice = request.getParameter("choice");

		if (choice.equals("eliminanodo")) {

			final Integer idNodo = Integer.parseInt(request.getParameter("id"));

			nodoService.deleteById(idNodo);

			final List<NodoDTO> allNodeDTO = nodoService.findAllNodesDTO();
			request.setAttribute("allNodeDTO", allNodeDTO);

			visualizzaChat(request);
			return "gestisciChatbot";
		} else {
			return "";
		}
	}

	@RequestMapping(value = "/nodoDirectory", method = RequestMethod.POST)
	public String nodoDirectoryPOST(HttpServletRequest request) {
		final String choice = request.getParameter("choice");

		if (choice.equals("Aggiungi")) {
			final Integer figlioDaAggiungere = Integer.parseInt(request.getParameter("idNode"));
			final Integer idPadre = Integer.parseInt(request.getParameter("choiceIdNodoPadre"));

			final NodoDTO nodoDTODaAggiungere = nodoService.findByIdNodoDTO(figlioDaAggiungere);
			final NodoDTO nodoDTOPadre = nodoService.findByIdNodoDTO(idPadre);

			nodoDTODaAggiungere.setNodoPadre(nodoDTOPadre);

			nodoService.update(nodoDTODaAggiungere);

			visualizzaChat(request);
			return "gestisciChatbot";

		} else if (choice.equals("creanodo")) {
			final String testo = request.getParameter("text");
			final NodoDTO nuovoNodo = new NodoDTO(0, testo, null, null);
			nodoService.save(nuovoNodo);
			// System.out.println(nuovoNodo);

			visualizzaChat(request);
			return "gestisciChatbot";
		} else {
			return "";
		}
	}
	
	public void visualizzaChat(HttpServletRequest request) {
		// prendo la chat da gestire tramite l'id recuperato dalla session, poi la salvo
		// nella request
		final ChatbotDTO chatbotDTODaGestire = chatbotService
				.findChatbotDTOByIdChatbot(Integer.parseInt(request.getParameter("idChatDaGestire")));
		request.setAttribute("chatbotDTODaGestire", chatbotDTODaGestire);

		// prendo la lista dei nodi, la ordino e la recupero, poi la salvo nella request
		final List<NodoDTO> listDTOOrdinata = FunzioniDiUtilita.recuperaAlberoOrdinato(
				nodoService.findAllNodesDTO(), chatbotDTODaGestire.getNodoPadre().getIdNodo());
		request.setAttribute("listDTOOrdinata", listDTOOrdinata);

		// lista di nodi disponibili per essere aggiunti nella chat, poi salvo nella
		// request
		final List<Nodo> nodiSenzaPadreDisponibili = nodoService.trovaNodiSenzaPadreDisponibili();
		request.setAttribute("nodiSenzaPadreDisponibili", nodiSenzaPadreDisponibili);

		// final List<NodoDTO> allNodeDTO = nodoService.findAllNodesDTO();
		// request.setAttribute("allNodeDTO", allNodeDTO);
		request.setAttribute("idChatDaGestire", request.getParameter("idChatDaGestire"));
		
	}

}