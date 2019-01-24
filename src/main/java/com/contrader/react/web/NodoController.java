package com.contrader.react.web;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.contrader.react.dto.ChatbotDTO;
import com.contrader.react.dto.NodoDTO;
import com.contrader.react.service.ChatbotService;
import com.contrader.react.service.NodoService;
import com.contrader.react.utils.FunzioniDiUtilita;

@CrossOrigin(value = "*")
@RestController
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

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<NodoDTO> all() {
		System.out.println(nodoService.findAllNodesDTO());
		return nodoService.findAllNodesDTO();
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

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public NodoDTO update(@RequestBody NodoDTO nodoDTO) {
		return nodoService.save(nodoDTO);
	}
	
	@RequestMapping(value = "/updateNodo", method = RequestMethod.POST)
	public NodoDTO update  (@RequestParam("idNodo") Integer idNodo,@RequestParam("testo") String testo) {
		
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

	/**
	 * 
	 * @RequestMapping(value = "/download", method = RequestMethod.GET) public
	 *                       String download(@RequestParam(value = "file", required
	 *                       = false) final MultipartFile file, HttpServletRequest
	 *                       request, HttpServletResponse response) {
	 * 
	 *                       final Integer idNodo =
	 *                       Integer.parseInt(request.getParameter("idNodoPerPath"));
	 *                       System.out.println("sono quaaa" + idNodo); final
	 *                       NodoDTO nodo = nodoService.findByIdNodoDTO(idNodo);
	 * 
	 *                       System.out.println("nodo path " + nodo.getPath()); if
	 *                       (!StringUtils.isEmpty(nodo.getPath())) { try { final
	 *                       File fileToDownload = new File(nodo.getPath()); final
	 *                       InputStream inputStream = new
	 *                       FileInputStream(fileToDownload);
	 *                       response.setContentType("application/force-download");
	 *                       response.setHeader("Content-Disposition", "attachment;
	 *                       filename=" + fileToDownload.getName());
	 *                       IOUtils.copy(inputStream, response.getOutputStream());
	 *                       response.flushBuffer(); inputStream.close(); } catch
	 *                       (final Exception e) { e.printStackTrace(); } } return
	 *                       "gestisciChatbot"; }
	 */
}