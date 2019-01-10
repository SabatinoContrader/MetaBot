package com.pCarpet.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.h2.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pCarpet.dto.NodoDTO;
import com.pCarpet.services.NodoService;

@RestController
@RequestMapping("/File")
public class GestioneFileController {

	private final NodoService nodoService;

	private final String mainPath = "src/main/resources/static/files/";

	@Autowired
	public GestioneFileController(NodoService nodoService) {
		this.nodoService = nodoService;
	}

	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public void directoryMethod(@RequestParam("file") MultipartFile file, HttpServletRequest request) {

		final Integer idNodo = Integer.parseInt(request.getParameter("idNodo"));

		final NodoDTO nodo = nodoService.findByIdNodoDTO(idNodo);

		System.out.println("ID NODO -> " + nodo.getIdNodo());

		// mettere if su controllo del nodo corrente per non sovrascrivere il file che
		// c'e nel path corrente del nodo
		// esempio
		// if Nodo.getPath == null

		if (!file.isEmpty()) {
			try {

				final BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File(mainPath + file.getOriginalFilename())));

				// salvare il nodo con il path aggioranto
				// mainPath + file.getOriginalFilename()))

				stream.write(file.getBytes());
				stream.flush();
				stream.close();

			} catch (final IOException e) {
				e.printStackTrace();
			}
		}
	}

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public void getLogFile(HttpSession session, HttpServletResponse response) throws Exception {
		try {
			final String filePathToBeServed = "src/main/resources/static/files/European_CV_GiacomoAstore.docx";
			final File fileToDownload = new File(filePathToBeServed);
			final InputStream inputStream = new FileInputStream(fileToDownload);
			response.setContentType("application/force-download");
			response.setHeader("Content-Disposition", "attachment; filename=European_CV_GiacomoAstore.docx");
			IOUtils.copy(inputStream, response.getOutputStream());
			response.flushBuffer();
			inputStream.close();
		} catch (final Exception e) {
			e.printStackTrace();
		}

	}

}
