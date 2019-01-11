package com.pCarpet.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pCarpet.dto.ChatbotDTO;
import com.pCarpet.dto.UserDTO;
import com.pCarpet.services.ChatbotService;

@Controller
@RequestMapping("/Home")
public class HomeController {

	private final ChatbotService chatbotService;

	@Autowired
	public HomeController(ChatbotService chatbotService) {
		this.chatbotService = chatbotService;
	}

	@RequestMapping(value = "/chatManagement", method = RequestMethod.GET)
	public String chatManagement(HttpServletRequest request) {
		final UserDTO userDTO = (UserDTO) request.getSession().getAttribute("utenteCollegato");

		final List<ChatbotDTO> allChatbotsDTO = chatbotService.findAllChatbotsDTOByIdUser(userDTO);
		request.setAttribute("allChatbotsDTO", allChatbotsDTO);
		return "homeChatbot";

	}

	@RequestMapping(value = "/userManagement", method = RequestMethod.GET)
	public String userManagement(HttpServletRequest request) {
		return "homeUser";

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		return "index";

	}
	@RequestMapping(value = "/indietro", method = RequestMethod.GET)
	public String indietro(HttpServletRequest request) {
		return "home";

	}
}