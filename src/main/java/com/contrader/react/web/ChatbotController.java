package com.contrader.react.web;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.contrader.react.dto.ChatbotDTO;
import com.contrader.react.dto.NodoDTO;
import com.contrader.react.dto.UserDTO;
import com.contrader.react.service.ChatbotService;
import com.contrader.react.service.NodoService;
import com.contrader.react.utils.FunzioniDiUtilita;

@RestController
@CrossOrigin(value = "*", allowedHeaders = "*")
@RequestMapping("/Chatbot")
public class ChatbotController {

	/**
	 * Costante percorso directory per chatImportate
	 */
	private static final String MAIN_PATH_IMPORT_EXPORT = "src/main/resources/files/chatImportate/";

	private final ChatbotService chatbotService;
	private final NodoService nodoService;

	@Autowired
	public ChatbotController(NodoService nodoService, ChatbotService chatbotService) {
		this.chatbotService = chatbotService;
		this.nodoService = nodoService;
	}

	@RequestMapping(value = "/allChatbots", method = RequestMethod.GET)
	public List<ChatbotDTO> gestisci() {
		return chatbotService.findAll();
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<ChatbotDTO> all() {
		return chatbotService.getAll();
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public void delete(@RequestParam("idChatbot") Integer idChatbot) {
		chatbotService.deleteChatbotByIdChatbot(idChatbot);

	}

	@RequestMapping(value = "/deleteByID", method = RequestMethod.GET)
	public boolean deleteByID(@RequestParam("idChatbot") Integer idChatbot) {
		return chatbotService.deleteById(idChatbot);

	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public ChatbotDTO get(@RequestParam("idChatbot") Integer idChatbot) {
		return chatbotService.findChatbotDTOByIdChatbot(idChatbot);
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ChatbotDTO insert(@RequestBody ChatbotDTO chatbotDTO) {
		return chatbotService.insert(chatbotDTO);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ChatbotDTO update(@RequestBody ChatbotDTO chatbotDTO) {
		return chatbotService.update(chatbotDTO);
	}

	@RequestMapping(value = "/esportareXML", method = RequestMethod.GET)
	public boolean esportareXML(@RequestParam("idChatbot") Integer idChatbot,
			@RequestParam("nomeFile") String nomeFile) {
		System.out.println("nomeFile " + nomeFile);
		// prendo la chat da gestire tramite l'id recuperato dalla session
		final ChatbotDTO chatbotDTODaGestire = chatbotService.findChatbotDTOByIdChatbot(idChatbot);

		// prendo la lista dei nodi, la ordino e la recupero
		final List<NodoDTO> listDTOOrdinata = FunzioniDiUtilita.recuperaAlberoOrdinato(nodoService.findAllNodesDTO(),
				chatbotDTODaGestire.getNodoPadre().getIdNodo());

		return FunzioniDiUtilita.printXML(idChatbot, listDTOOrdinata, MAIN_PATH_IMPORT_EXPORT + nomeFile);
	}
//		return request.setAttribute(	"chatbotDTODaGestire", chatbotDTODaGestire);

//	@RequestMapping(value = "/gestisci", method = RequestMethod.GET)
//	public String gestisci(HttpServletRequest request) {
//		// prendo la chat da gestire tramite l'id recuperato dalla session, poi la salvo
//		// nella request
//		final ChatbotDTO chatbotDTODaGestire = chatbotService
//				.findChatbotDTOByIdChatbot(Integer.parseInt(request.getParameter("idChatDaGestire")));
//		request.setAttribute("chatbotDTODaGestire", chatbotDTODaGestire);
//
//		// prendo la lista dei nodi, la ordino e la recupero, poi la salvo nella request
//		final List<NodoDTO> listDTOOrdinata = FunzioniDiUtilita.recuperaAlberoOrdinato(nodoService.findAllNodesDTO(),
//				chatbotDTODaGestire.getNodoPadre().getIdNodo());
//		request.setAttribute("listDTOOrdinata", listDTOOrdinata);
//
//		final HashMap<NodoDTO, Integer> hashElimina = new HashMap<>();
//		for (final NodoDTO lista : listDTOOrdinata) {
//
//			if (nodoService.findUserByIdNodoPadre(lista.getIdNodo()) == 1) {
//				hashElimina.put(lista, 1);
//			} else {
//				hashElimina.put(lista, 0);
//			}
//		}
//		request.setAttribute("hashElimina", hashElimina);
//		// lista di nodi disponibili per essere aggiunti nella chat, poi salvo nella
//		// request
//		final List<Nodo> nodiSenzaPadreDisponibili = nodoService.trovaNodiSenzaPadreDisponibili();
//		request.setAttribute("nodiSenzaPadreDisponibili", nodiSenzaPadreDisponibili);
//
//		// final List<NodoDTO> allNodeDTO = nodoService.findAllNodesDTO();
//		// request.setAttribute("allNodeDTO", allNodeDTO);
//		request.setAttribute("idChatDaGestire", request.getParameter("idChatDaGestire"));
//		return "gestisciChatbot";
//	}

//	@RequestMapping(value = "/crea", method = RequestMethod.GET)
//	public String crea(HttpServletRequest request) {
//		final List<NodoDTO> listNodesDTONodoPadreNull = nodoService.findByNodoPadreIsNull();
//		request.setAttribute("listNodesDTONodoPadreNull", listNodesDTONodoPadreNull);
//
//		final UserDTO user = (UserDTO) request.getSession().getAttribute("utenteCollegato");
//		final List<ChatbotDTO> allChatbotsDTO = chatbotService.findAllChatbotsDTOByIdUser(user);
//		request.setAttribute("allChatbotsDTO", allChatbotsDTO);
//
//		return "creaChatbot";
//	}

	@RequestMapping(value = "/importareXML", method = RequestMethod.GET)
	public ChatbotDTO importareXML(@RequestParam("nomeFile") String nomeFile) {

		final ChatbotDTO chatbotDTODaImportare = chatbotService
				.findChatbotDTOByIdChatbot(FunzioniDiUtilita.readXML(MAIN_PATH_IMPORT_EXPORT + nomeFile));
		final ChatbotDTO chatbotDTO = new ChatbotDTO(0, chatbotDTODaImportare.getNomeChatbot(),
				chatbotDTODaImportare.getUser(), chatbotDTODaImportare.getNodoPadre());
		return chatbotService.inserisciChatbotDTO(chatbotDTO);

	}

	@RequestMapping(value = "/cercaChatbot", method = RequestMethod.GET)
	public List<ChatbotDTO> cercaChatbot(HttpServletRequest request) {
		final String content = request.getParameter("search");
		return chatbotService.findChatbotDTOByNomeChatbot(content);
	}

	/**
	 * Recuperiamo i nomi di tutti i file dentro la cartella della chatImportate,
	 * cosi nel frontend decidiamo quale chat importare e visualizzare
	 * 
	 * @return lista di nomi dei file nella cartella chatImportate
	 */
	@RequestMapping(value = "/getListaChatImportate", method = RequestMethod.GET)
	public List<String> getListaChatImportate() {

		final List<String> listaNomi = new ArrayList<>();
		final File[] files = new File(MAIN_PATH_IMPORT_EXPORT).listFiles();

		for (final File file : files) {
			// controllo di realtà del file
			if (file.isFile()) {
				listaNomi.add(file.getName());
			}
		}
		return listaNomi;
	}

	@RequestMapping(value = "/creaChatbot", method = RequestMethod.GET)
	public ChatbotDTO creaChatbot(HttpServletRequest request) {

		final String nomeChat = request.getParameter("nomeChatbot");

		final UserDTO user = (UserDTO) request.getSession().getAttribute("utenteCollegato");

		final Integer nodoPadreSelezionato = Integer.parseInt(request.getParameter("nodoPadreSelezionato"));

		final NodoDTO nodo = nodoService.findByIdNodoDTO(nodoPadreSelezionato);

		final ChatbotDTO chatbotDTO = new ChatbotDTO(0, nomeChat, user, nodo);

		return chatbotService.inserisciChatbotDTO(chatbotDTO);

//		final List<ChatbotDTO> allChatbotsDTO = chatbotService.findAllChatbotsDTOByIdUser(user);
//		request.setAttribute("allChatbotsDTO", allChatbotsDTO);s

		// return "homeChatbot";

	}

//	@RequestMapping(value = "/simulazione/", method = RequestMethod.GET)
//	public String avviaSimulazione(@RequestParam("chatbotID") Integer cID, HttpServletRequest request) {
//		List<String> log = new ArrayList<>();
//		ChatbotDTO chat = chatbotService.findChatbotDTOByIdChatbot(cID);
//		log.add(nodoService.findByIdNodoDTO(chat.getNodoPadre().getIdNodo()).getText());
//		final List<NodoDTO> next = nodoService.findAllByNodoPadre(chat.getNodoPadre());
//
//		request.setAttribute("chatlog", log);
//		request.setAttribute("simulatedChatID", cID);
//		request.setAttribute("simulatedChatName", chat.getNomeChatbot());
//		request.setAttribute("prossimiNodi", next);
//
//		return "simulaChat";
//	}

//	@RequestMapping(value = "/simulazione/", method = RequestMethod.POST)
//	public String prossimiNodi(@RequestParam("chatbotID") Integer cID, HttpServletRequest request,
//			@RequestParam(value = "chatlog") ArrayList<String> log) {
//		NodoDTO nodo = nodoService.findByIdNodoDTO(Integer.parseInt(request.getParameter("nodoScelto")));
	// nodoService.updateContatore(Integer.parseInt(request.getParameter("nodoScelto")));
//		log.add(nodo.getText());
//		final List<NodoDTO> next = nodoService.findAllByNodoPadre(nodo);
//		ChatbotDTO chat = chatbotService.findChatbotDTOByIdChatbot(cID);
//		request.setAttribute("simulatedChatID", cID);
//		request.setAttribute("simulatedChatName", chat.getNomeChatbot());
//		request.setAttribute("prossimiNodi", next);
//		request.setAttribute("chatlog", log);
//		return "simulaChat";
//	}
}