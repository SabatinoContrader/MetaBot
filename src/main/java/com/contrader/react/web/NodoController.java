package com.contrader.react.web;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.contrader.react.dto.ChatbotDTO;
import com.contrader.react.dto.NodoDTO;
import com.contrader.react.model.Nodo;
import com.contrader.react.service.ChatbotService;
import com.contrader.react.service.NodoService;
import com.contrader.react.utils.FunzioniDiUtilita;

@CrossOrigin(value = { "*" }, exposedHeaders = { "Content-Disposition" })
@RestController
@RequestMapping("/Nodo")
public class NodoController {

	private final NodoService nodoService;
	private final ChatbotService chatbotService;
	private final String mainPath = "src/main/resources/files/";

	private final Logger logger = LoggerFactory.getLogger(NodoController.class);

	@Autowired
	public NodoController(NodoService nodoService, ChatbotService chatbotService) {
		this.nodoService = nodoService;
		this.chatbotService = chatbotService;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<NodoDTO> all() {
		return nodoService.findAllNodesDTO();
	}
	
	@RequestMapping(value = "/findByNodoPadreIsNull", method = RequestMethod.GET)
	public List<NodoDTO> findByNodoPadreIsNull() {
		return nodoService.findByNodoPadreIsNull();
	}

	@RequestMapping(value = "/getNodo", method = RequestMethod.GET)
	public NodoDTO getNodo(@RequestParam("idNodo") Integer idNodo) {
		return nodoService.findByIdNodoDTO(idNodo);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public void delete(@RequestParam("idNodo") Integer idNodo) {
		nodoService.deleteById(idNodo);
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public NodoDTO insert(@RequestBody NodoDTO nodoDTO) {
		return nodoService.save(nodoDTO);
	}

	@RequestMapping(value = "/insertCreaNodo", method = RequestMethod.POST)
	public NodoDTO insertCreaNodo(@RequestParam("testo") String testo, @RequestParam("tiponodo") String tiponodo) {
		final NodoDTO nuovoNodo = new NodoDTO(0, testo, null, tiponodo, null, 0);

		return nodoService.save(nuovoNodo);

	}

	@RequestMapping(value = "/insertCreaNodo2", method = RequestMethod.POST)
	public NodoDTO insertCreaNodo(@RequestParam("testo") String testo, @RequestParam("tiponodo") String tiponodo,
			@RequestParam("nodo") Integer idNodoPadre) {

		final NodoDTO nodoDTO = nodoService.findByIdNodoDTO(idNodoPadre);

		final NodoDTO nuovoNodo = new NodoDTO(0, testo, nodoDTO, tiponodo, null, 0);

		return nodoService.save(nuovoNodo);

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public NodoDTO update(@RequestBody NodoDTO nodoDTO) {
		return nodoService.save(nodoDTO);
	}

	@RequestMapping(value = "/updateNodo", method = RequestMethod.POST)
	public NodoDTO update(@RequestParam("idNodo") Integer idNodo, @RequestParam("testo") String testo) {

		final NodoDTO nuovoNodo = nodoService.findByIdNodoDTO(idNodo);
		nuovoNodo.setText(testo);
		return nodoService.save(nuovoNodo);
	}

	@RequestMapping(value = "/percentuale", method = RequestMethod.GET)
	public Float calcolo(@RequestParam("idChat") Integer idChat, @RequestParam("idNodo") Integer idNodo) {
		final ChatbotDTO chat = chatbotService.findChatbotDTOByIdChatbot(idChat);
		// NodoDTO nodoPadre =
		// nodoService.findByIdNodoDTO(chat.getNodoPadre().getIdNodo());

		final NodoDTO nodo = nodoService.findByIdNodoDTO(idNodo);
		final float nodo1 = nodo.getContatore();
		final float nodo2 = chat.getNodoPadre().getContatore();
		final float percentuale = nodo1 / nodo2;
		return percentuale * 100;
	}

	@RequestMapping(value = "/aumentaContatoreNodo", method = RequestMethod.GET)
	public void contatore(@RequestParam("idNodo") Integer idNodo) {
		nodoService.updateContatore(idNodo);
	}

	@RequestMapping(value = "/visualizzaChat", method = RequestMethod.GET)
	public List<NodoDTO> visualizzaChat(@RequestParam("idNodoPadre") Integer idNodoPadre) {
		return FunzioniDiUtilita.recuperaAlberoOrdinato(nodoService.findAllNodesDTO(), idNodoPadre);
	}

	@RequestMapping(value = "/recuperaSottoAlbero", method = RequestMethod.GET)
	public List<NodoDTO> recuperaSottoAlbero(@RequestParam("id") Integer id) {

		final NodoDTO nodo = nodoService.findByIdNodoDTO(id);
		return nodoService.findAllByNodoPadre(nodo);
	}

	@RequestMapping(value = "/aggiungi", method = RequestMethod.POST)
	public Nodo aggiungi(@RequestParam("idNodoCreato") Integer idNodoCreato,
			@RequestParam("choiceIdNodoPadre") Integer choiceIdNodoPadre) {

		final NodoDTO nodoDTODaAggiungere = nodoService.findByIdNodoDTO(idNodoCreato);
		final NodoDTO nodoDTOPadre = nodoService.findByIdNodoDTO(choiceIdNodoPadre);

		nodoDTODaAggiungere.setNodoPadre(nodoDTOPadre);

		return nodoService.update(nodoDTODaAggiungere);

	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public void upload(@RequestParam(value = "file", required = false) MultipartFile file,
			@RequestParam("idNodo") Integer idNodo) {

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
	}

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public ResponseEntity<byte[]> download(@RequestParam("idNodo") Integer idNodo) throws IOException {
		final NodoDTO nodo = nodoService.findByIdNodoDTO(idNodo);
		final File fileToDownload = new File(nodo.getPath());
		final Path path = Paths.get(fileToDownload.getPath());
		final byte[] data = Files.readAllBytes(path);

		final HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.valueOf(Files.probeContentType(path)));
		header.setContentLength(fileToDownload.length());
		header.set("Content-Disposition", "attachment; filename=" + fileToDownload.getName());
		return new ResponseEntity<>(data, header, HttpStatus.OK);
	}

	/**
	 * Ci occupiamo di resettare la statistica di ogni nodo per quella chat che ha
	 * come nodo root 'idNodoRoot'
	 * 
	 * @param id
	 */
	@RequestMapping(value = "/azzeraStatisticaNodiChatcorrente", method = RequestMethod.GET)
	public List<NodoDTO> azzeraStatisticaNodiChatcorrente(@RequestParam("idNodoRoot") Integer idNodoRoot) {
		final List<NodoDTO> list = FunzioniDiUtilita.recuperaAlberoOrdinato(nodoService.findAllNodesDTO(), idNodoRoot);

		list.forEach(i -> {
			i.setContatore(0);
			nodoService.azzeraContatoreNodo(i.getIdNodo());
		});
		return list;
	}
}