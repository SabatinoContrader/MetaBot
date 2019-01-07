package com.pCarpet.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pCarpet.dto.NodoDTO;
import com.pCarpet.services.NodoService;

@Controller
@RequestMapping("/Nodo")
public class NodoController {

	private final NodoService nodoService;

	@Autowired
	public NodoController(NodoService nodoService) {
		this.nodoService = nodoService;
	}

	@RequestMapping(value = "/nodoDirectory", method = RequestMethod.GET)
	public String directoryMethod(HttpServletRequest request) {

		final String choice = request.getParameter("choice");
		if (choice.equals("elimina")) {

			final Integer idNodo = Integer.parseInt(request.getParameter("id"));

			nodoService.deleteById(idNodo);

			final List<NodoDTO> allNodeDTO = nodoService.findAllNodesDTO();
			request.setAttribute("allNodeDTO", allNodeDTO);

			return "homeNodo";
		} else {
			return "";
		}
	}

}