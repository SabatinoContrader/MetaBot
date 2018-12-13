package com.virtualpairprogrammers.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtualpairprogrammers.model.User;
import com.virtualpairprogrammers.service.UserService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class UsersServlet extends HttpServlet {

	private UserService userService = new UserService();;
	private List<User> allUsers;

	public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
	{
		String scelta = request.getParameter("richiesta");
		HttpSession session = request.getSession(true);
		
		switch (scelta) {
		case "usersManagement":
			this.allUsers = this.userService.getAllUsers();
			request.setAttribute("allUsers", this.allUsers);
			getServletContext().getRequestDispatcher("/users.jsp").forward(request,response);
			break;
	
		case "Indietro":
			getServletContext().getRequestDispatcher("/home.jsp").forward(request,response);
			break;
		
		
		}
	}
}
