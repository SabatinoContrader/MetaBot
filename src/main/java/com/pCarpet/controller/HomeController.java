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
import com.pCarpet.services.ChatbotService;
import com.pCarpet.services.NodoService;

@Controller
@RequestMapping("/Home")
public class HomeController {

	private final NodoService nodoService;
	private final ChatbotService chatbotService;

	@Autowired
	public HomeController(NodoService nodoService, ChatbotService chatbotService) {
		this.nodoService = nodoService;
		this.chatbotService = chatbotService;
	}

	@RequestMapping(value = "/homeDirectory", method = RequestMethod.GET)
	public String directoryMethod(HttpServletRequest request) {
		final String choice = request.getParameter("choice");
		if (choice.equals("Nodo")) {

			final List<NodoDTO> allNodeDTO = nodoService.findAllNodesDTO();
			request.setAttribute("allNodeDTO", allNodeDTO);
			return "homeNodo";

		} else if (choice.equals("Chatbot")) {

			final UserDTO userDTO = (UserDTO) request.getSession().getAttribute("utenteCollegato");

			final List<ChatbotDTO> allChatbotsDTO = chatbotService.findAllChatbotsDTOByIdUser(userDTO);
			request.setAttribute("allChatbotsDTO", allChatbotsDTO);
			return "homeChatbot";

		} else if (choice.equals("indietro")) {
			return "home";
		} else {
			return "";
		}
	}

}