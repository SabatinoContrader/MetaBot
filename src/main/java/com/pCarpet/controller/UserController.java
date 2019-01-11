package com.pCarpet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pCarpet.dto.UserDTO;
import com.pCarpet.services.UserService;

import java.util.List;


@Controller
@RequestMapping("/User")
public class UserController {

	private final UserService userService;
	private HttpSession session;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	private void visualUser(HttpServletRequest request){
		List<UserDTO> allUser = this.userService.getListaUserDTO();
		request.setAttribute("allUserDTO", allUser);
	}
	
	@RequestMapping(value = "/userManagement", method = RequestMethod.GET)
	public String userManagement(HttpServletRequest request) {
		visualUser(request);
		return "user";		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		this.userService.deleteUserById(id);
		visualUser(request);
		return "user";
		
	}
	
	@RequestMapping(value = "/crea", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		visualUser(request);
		request.setAttribute("option", "insert");
		return "userManagement";
		
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		UserDTO user = this.userService.getUserDTOById(id);
		request.setAttribute("user", user);
		request.setAttribute("option", "update");
		return "userManagement";
		
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		return "index";
		
	}
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public String updateUser(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("userid").toString());
		String username = request.getParameter("username").toString();
		String password = request.getParameter("password").toString();
		String ruolo = request.getParameter("ruolo").toString();

		UserDTO userObj = new UserDTO(id, username, password, ruolo,"");

		userService.updateUser(userObj);

		visualUser(request);
		return "user";
	}
	
	@RequestMapping(value = "/insertUser", method = RequestMethod.POST)
	public String insertUser(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("userid").toString());
		String username = request.getParameter("username").toString();
		String password = request.getParameter("password").toString();
		String ruolo = request.getParameter("choice").toString();

		UserDTO userObj = new UserDTO(id, username, password, ruolo,"");
		
		userService.insertUser(userObj);

		visualUser(request);
		return "user";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginControl(HttpServletRequest request) {

		session = request.getSession();
		final String username = request.getParameter("username");
		final String password = request.getParameter("password");
		final UserDTO userDTO = userService.getByUsernameAndPassword(username, password);
		final String ruolo = userDTO.getRuolo();
		if (!StringUtils.isEmpty(ruolo)) {
			session.setAttribute("utenteCollegato", userDTO);
			if (ruolo.equals("ADMIN")) {
				return "home";
			} else if (ruolo.equals("CHATMASTER")) {
				return "home";
			}
		}
		return "index";
	}
}
