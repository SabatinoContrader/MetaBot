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

			// final List<NodoDTO> allNodeDTO = nodoService.findAllNodesDTO();
			// request.setAttribute("allNodeDTO", allNodeDTO);

			return "gestisciChatbot";

		}else if (choice.equals("esportareXML")) {
			// prendo la chat da gestire tramite l'id recuperato dalla session
			final ChatbotDTO chatbotDTODaGestire = chatbotService
					.findChatbotDTOByIdChatbot(Integer.parseInt(request.getParameter("idChatDaEsportare")));

			// prendo la lista dei nodi, la ordino e la recupero
			final List<NodoDTO> listDTOOrdinata = FunzioniDiUtilita.recuperaAlberoOrdinato(
					nodoService.findAllNodesDTO(), chatbotDTODaGestire.getNodoPadre().getIdNodo());

			FunzioniDiUtilita.printXML(Integer.parseInt(request.getParameter("idChatDaEsportare")), listDTOOrdinata);
			return "home";
		} else if (choice.equals("importareXML")) {
			final ChatbotDTO chatbotDTODaImportare = chatbotService
					.findChatbotDTOByIdChatbot(FunzioniDiUtilita.readXML());
			final ChatbotDTO chatbotDTO = new ChatbotDTO(0, chatbotDTODaImportare.getNomeChatbot(),
					chatbotDTODaImportare.getUser(), chatbotDTODaImportare.getNodoPadre());
			chatbotService.inserisciChatbotDTO(chatbotDTO);

			return "home";
		} else {
			return "";
		}
	}

	@RequestMapping(value = "/cercaChatbot", method = RequestMethod.GET)
	public String cercaChatbot(HttpServletRequest request) {

		String content = request.getParameter("search");

		System.out.println(content);

		List<ChatbotDTO> chatbots = chatbotService.findChatbotDTOByNomeChatbot(content);
		request.setAttribute("chatbots", chatbots);

		return "cercaChatbot";

	}

	@RequestMapping(value = "/chatbotDirectory", method = RequestMethod.POST)
	public String directoryMethod2(HttpServletRequest request) {

		final String choice = request.getParameter("choice");
		
		if ( choice.equals("Aggiungi")) {
			final Integer figlioDaAggiungere = Integer.parseInt(request.getParameter("idNode"));
			final Integer idPadre = Integer.parseInt(request.getParameter("choiceIdNodoPadre"));

			final NodoDTO nodoDTODaAggiungere = nodoService.findByIdNodoDTO(figlioDaAggiungere);
			final NodoDTO nodoDTOPadre = nodoService.findByIdNodoDTO(idPadre);

			nodoDTODaAggiungere.setNodoPadre(nodoDTOPadre);

			
			nodoService.update(nodoDTODaAggiungere);
			
			
			return "home";
			
		}else if ( choice.equals("creanodo")){
			final String testo = request.getParameter("text");
			final NodoDTO nuovoNodo = new NodoDTO(0,testo,null,null);
			nodoService.save(nuovoNodo);
			return "home";
		}else {
			return "";
		}
	}

	@RequestMapping(value = "/creaChatbot", method = RequestMethod.GET)
	public String creaChatbot(HttpServletRequest request) {

		final String nomeChat = request.getParameter("nomeChatbot");
		System.out.println(nomeChat);

		final UserDTO user = (UserDTO) request.getSession().getAttribute("utenteCollegato");
		System.out.println(user);

		final Integer nodoPadreSelezionato = Integer.parseInt(request.getParameter("nodoPadreSelezionato"));
		System.out.println(nodoPadreSelezionato);

		final NodoDTO nodo = nodoService.findByIdNodoDTO(nodoPadreSelezionato);
		System.out.println(nodo);

		final ChatbotDTO chatbotDTO = new ChatbotDTO(0, nomeChat, user, nodo);
		System.out.println(chatbotDTO);

		chatbotService.inserisciChatbotDTO(chatbotDTO);

		final List<ChatbotDTO> allChatbotsDTO = chatbotService.findAllChatbotsDTOByIdUser(user);
		request.setAttribute("allChatbotsDTO", allChatbotsDTO);

		return "homeChatbot";

	}

}