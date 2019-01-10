package com.pCarpet.controller;

//import net.sf.json.JSONArray;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pCarpet.dto.UserDTO;
import com.pCarpet.services.UserService;

@Controller
@RequestMapping("/Login")
public class LoginController {

	private final UserService userService;

	@Autowired
	public LoginController(UserService userService) {
		this.userService = userService;
	}

	private HttpSession session;

	@RequestMapping(value = "/loginControl", method = RequestMethod.POST)
	public String loginControl(HttpServletRequest request, Model model) {

		session = request.getSession();
		final String username = request.getParameter("username");
		final String password = request.getParameter("password");
		final UserDTO userDTO = userService.getByUsernameAndPassword(username, password);
		final String ruolo = userDTO.getRuolo();
		if (!StringUtils.isEmpty(ruolo)) {
			session.setAttribute("utenteCollegato", userDTO);
			if (ruolo.equals("ADMIN")) {
				model.addAttribute("feedback", "success");
				return "home";
			} else if (ruolo.equals("CHATMASTER")) {
				// return "homeCliente";
				return "home";
			}
		}
		return "index";
	}

	@RequestMapping(value = "/logoutControl", method = RequestMethod.GET)
	public String logoutControl(HttpServletRequest request, Model model) {
		session.invalidate();
		return "index";
	}

	public HttpSession getSession() {
		return session;
	}

}
