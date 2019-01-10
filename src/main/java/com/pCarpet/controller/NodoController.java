package com.pCarpet.controller;

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

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	private final String mainPath = "src/main/resources/static/files/";

	@Autowired
	public NodoController(NodoService nodoService, ChatbotService chatbotService) {
		this.nodoService = nodoService;
		this.chatbotService = chatbotService;
	}

	@RequestMapping(value = "/nodoDirectory", method = RequestMethod.GET)
	public String nodoDirectoryGET(@RequestParam(value = "file", required = false) MultipartFile file,
			HttpServletRequest request, HttpServletResponse response) {
		final String choice = request.getParameter("choice");

		if (choice.equals("eliminanodo")) {

			final Integer idNodo = Integer.parseInt(request.getParameter("id"));

			nodoService.deleteById(idNodo);

			final List<NodoDTO> allNodeDTO = nodoService.findAllNodesDTO();
			request.setAttribute("allNodeDTO", allNodeDTO);

			visualizzaChat(request);
			return "gestisciChatbot";
		} else if (choice.equals("download")) {

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
		} else {
			return "";
		}
	}

	@RequestMapping(value = "/nodoDirectory", method = RequestMethod.POST)
	public String nodoDirectoryPOST(@RequestParam(value = "file", required = false) MultipartFile file,
			HttpServletRequest request, HttpServletResponse response) {
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
		} else if (choice.equals("upload")) {

			final Integer idNodo = Integer.parseInt(request.getParameter("idNode"));
			final NodoDTO nodo = nodoService.findByIdNodoDTO(idNodo);

			if (!file.isEmpty()) {
				try {
					final BufferedOutputStream stream = new BufferedOutputStream(
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

}