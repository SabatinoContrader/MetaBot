package com.pCarpet.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pCarpet.dto.ChatbotDTO;
import com.pCarpet.dto.NodoDTO;
import com.pCarpet.dto.UserDTO;
import com.pCarpet.model.Nodo;
import com.pCarpet.services.ChatbotService;
import com.pCarpet.services.NodoService;
import com.pCarpet.utils.FunzioniDiUtilita;

@Controller
@RequestMapping("/Chatbot")
public class ChatbotController {

	private final ChatbotService chatbotService;
	private final NodoService nodoService;

	@Autowired
	public ChatbotController(NodoService nodoService, ChatbotService chatbotService) {
		this.chatbotService = chatbotService;
		this.nodoService = nodoService;
	}

	@RequestMapping(value = "/chatbotDirectory", method = RequestMethod.GET)
	public String directoryMethod(HttpServletRequest request) {

		final String choice = request.getParameter("choice");
		
		if (choice.equals("crea")) {

			final List<NodoDTO> listNodesDTONodoPadreNull = nodoService.findByNodoPadreIsNull();
			request.setAttribute("listNodesDTONodoPadreNull", listNodesDTONodoPadreNull);

			final UserDTO user = (UserDTO) request.getSession().getAttribute("utenteCollegato");
			final List<ChatbotDTO> allChatbotsDTO = chatbotService.findAllChatbotsDTOByIdUser(user);
			request.setAttribute("allChatbotsDTO", allChatbotsDTO);

			return "creaChatbot";
			
			
			
			
		
				

				
				
				
				
		} else if (choice.equals("homeChatbot")) {
			return "homeChatbot";
		} else if (choice.equals("gestisci")) {

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

			return "gestisciChatbot";
		} else if (choice.equals("esportareXML")) {
			// prendo la chat da gestire tramite l'id recuperato dalla session
			final ChatbotDTO chatbotDTODaGestire = chatbotService
					.findChatbotDTOByIdChatbot(Integer.parseInt(request.getParameter("idChatDaEsportare")));

			// prendo la lista dei nodi, la ordino e la recupero
			final List<NodoDTO> listDTOOrdinata = FunzioniDiUtilita.recuperaAlberoOrdinato(
					nodoService.findAllNodesDTO(), chatbotDTODaGestire.getNodoPadre().getIdNodo());
		
			FunzioniDiUtilita.printXML(Integer.parseInt(request.getParameter("idChatDaEsportare")), listDTOOrdinata);
			return "home";
		}else if (choice.equals("importareXML")) {
			final ChatbotDTO chatbotDTODaImportare= chatbotService
					.findChatbotDTOByIdChatbot(FunzioniDiUtilita.readXML());
			final ChatbotDTO chatbotDTO = new ChatbotDTO(0, chatbotDTODaImportare.getNomeChatbot(), chatbotDTODaImportare.getUser(), chatbotDTODaImportare.getNodoPadre());
			chatbotService.inserisciChatbotDTO(chatbotDTO);

			return "home";
		}else {
			return "";
		}
	}


	@RequestMapping(value = "/creaChatbot", method = RequestMethod.GET)
	public String creaChatbot(HttpServletRequest request) {

		final String nomeChat = request.getParameter("nomeChatbot");
		final UserDTO user = (UserDTO) request.getSession().getAttribute("utenteCollegato");
		final Integer nodoPadreSelezionato = Integer.parseInt(request.getParameter("nodoPadreSelezionato"));
		final NodoDTO nodo = nodoService.findByIdNodoDTO(nodoPadreSelezionato);
		final ChatbotDTO chatbotDTO = new ChatbotDTO(0, nomeChat, user, nodo);
		chatbotService.inserisciChatbotDTO(chatbotDTO);

		final List<ChatbotDTO> allChatbotsDTO = chatbotService.findAllChatbotsDTOByIdUser(user);
		request.setAttribute("allChatbotsDTO", allChatbotsDTO);

		return "homeChatbot";

	}
	
	
	
	@RequestMapping(value = "/cercaChatbot", method = RequestMethod.GET)
	public String cercaChatbot(HttpServletRequest request) {

		String content = request.getParameter("search");
		
		System.out.println(content);
		
		List <ChatbotDTO> chatbots = chatbotService.findChatbotDTOByNomeChatbot(content);
		request.setAttribute("chatbots", chatbots);
		
		

		return "cercaChatbot";

	}
	
	
	
}