package com.pCarpet.controller;


import com.pCarpet.model.User;
import com.pCarpet.services.UserService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/Home")
public class HomeController {

	private UserService userService;

	@Autowired
	public HomeController(UserService userService) {
		this.userService = userService;
	}


		

	
	@RequestMapping(value = "/homeDirectory", method = RequestMethod.GET)
	public String AsseBad(HttpServletRequest request) {
		String scelta= request.getParameter("scelta");
		if (scelta.equals("AssBadRead"))
			return "homeAssBadRead";
		else if (scelta.equals("Customers"))
			return "homeCustomers";
		else if (scelta.equals("Bookings"))
			return "homeBookings";
		else if (scelta.equals("Logs"))
			return "homeLogs";
		else if (scelta.equals("indietro"))
			return "homeSegretaria";
		else
			return "";
	}
	
	

}