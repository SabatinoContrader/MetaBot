package com.contrader.react.web;

import java.io.BufferedOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.contrader.react.dto.ChatbotDTO;
import com.contrader.react.dto.NodoDTO;
import com.contrader.react.service.ChatbotService;
import com.contrader.react.service.NodoService;




@CrossOrigin(value="*")
@RestController
@RequestMapping("/Nodo")
public class NodoController {

	private final NodoService nodoService;
	private final ChatbotService chatbotService;
	private final String mainPath = "src/main/resources/static/files/";

	@Autowired
	public NodoController(NodoService nodoService,ChatbotService chatbotService) {
		this.nodoService = nodoService;
		this.chatbotService = chatbotService;
	}

	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<NodoDTO> all() {
		System.out.println(this.nodoService.findAllNodesDTO());
		return this.nodoService.findAllNodesDTO();
	}
		
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public void delete(@RequestParam("idNodo")Integer idNodo) {
		this.nodoService.deleteById(idNodo);	
	}
	
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public NodoDTO insert(@RequestBody NodoDTO nodoDTO ) {
		return  nodoService.save(nodoDTO);
	}
	
	@RequestMapping(value = "/percentuale", method = RequestMethod.GET)
	public Float calcolo(@RequestParam("idChat")Integer idChat,@RequestParam("idNodo")Integer idNodo) {
		ChatbotDTO chat = chatbotService.findChatbotDTOByIdChatbot(idChat);
		//NodoDTO nodoPadre = nodoService.findByIdNodoDTO(chat.getNodoPadre().getIdNodo());
		
		NodoDTO nodo = this.nodoService.findByIdNodoDTO(idNodo);
		float nodo1 = (float) nodo.getContatore();
		float nodo2 =(float) chat.getNodoPadre().getContatore();
		float percentuale = nodo1/nodo2;
		return percentuale*100;
	}

	
	
  

	
	
	
/*	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(@RequestParam(value = "file", required = false) MultipartFile file,
			HttpServletRequest request, HttpServletResponse response) {

		final Integer idNodo = Integer.parseInt(request.getParameter("choiceIdNodoFiglio"));
		final NodoDTO nodo = nodoService.findByIdNodoDTO(idNodo);

		if (!file.isEmpty()) {
			try {
				f
				inal BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File(mainPath + file.getOriginalFilename())));

				nodo.setPath(mainPath + file.getOriginalFilename());

				nodoService.save(nodo);

				stream.write(file.getBytes());
				stream.flush();
				stream.close();

			} catch (final IOException e) {
				e.printStackTrace();
			}
		}
		return "gestisciChatbot";
	}

	public void visualizzaChat(HttpServletRequest request) {
		// prendo la chat da gestire tramite l'id recuperato dalla session, poi la salvo
		// nella request
		final ChatbotDTO chatbotDTODaGestire = chatbotService
				.findChatbotDTOByIdChatbot(Integer.parseInt(request.getParameter("idChatDaGestire")));
		request.setAttribute("chatbotDTODaGestire", chatbotDTODaGestire);

		// prendo la lista dei nodi, la ordino e la recupero, poi la salvo nella request
		final List<NodoDTO> listDTOOrdinata = FunzioniDiUtilita.recuperaAlberoOrdinato(nodoService.findAllNodesDTO(),
				chatbotDTODaGestire.getNodoPadre().getIdNodo());
		request.setAttribute("listDTOOrdinata", listDTOOrdinata);

		final HashMap<NodoDTO, Integer> hashElimina = new HashMap<>();
		for (final NodoDTO lista : listDTOOrdinata) {

			if (nodoService.findUserByIdNodoPadre(lista.getIdNodo()) == 1) {
				hashElimina.put(lista, 1);
			} else {
				hashElimina.put(lista, 0);
			}
		}
		request.setAttribute("hashElimina", hashElimina);

		// lista di nodi disponibili per essere aggiunti nella chat, poi salvo nella
		// request
		final List<Nodo> nodiSenzaPadreDisponibili = nodoService.trovaNodiSenzaPadreDisponibili();
		request.setAttribute("nodiSenzaPadreDisponibili", nodiSenzaPadreDisponibili);

		// final List<NodoDTO> allNodeDTO = nodoService.findAllNodesDTO();
		// request.setAttribute("allNodeDTO", allNodeDTO);
		request.setAttribute("idChatDaGestire", request.getParameter("idChatDaGestire"));

	}

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public String download(@RequestParam(value = "file", required = false) MultipartFile file,
			HttpServletRequest request, HttpServletResponse response) {

		final Integer idNodo = Integer.parseInt(request.getParameter("idNodoPerPath"));
		System.out.println("sono quaaa" + idNodo);
		final NodoDTO nodo = nodoService.findByIdNodoDTO(idNodo);

		System.out.println("nodo path " + nodo.getPath());
		if (!StringUtils.isEmpty(nodo.getPath())) {
			try {
				final File fileToDownload = new File(nodo.getPath());
				final InputStream inputStream = new FileInputStream(fileToDownload);
				response.setContentType("application/force-download");
				response.setHeader("Content-Disposition", "attachment; filename=" + fileToDownload.getName());
				IOUtils.copy(inputStream, response.getOutputStream());
				response.flushBuffer();
				inputStream.close();
			} catch (final Exception e) {
				e.printStackTrace();
			}
		}
		return "gestisciChatbot";
	}*/
}