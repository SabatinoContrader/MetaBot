package com.virtualpairprogrammers.servlets;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtualpairprogrammers.model.User;
import com.virtualpairprogrammers.service.UserService;

import java.io.IOException;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("utente", null);
		if (request != null) {
			String username = request.getParameter("username").toString();
			String password = request.getParameter("password").toString();
			User user = userService.getUserByUsernameAndPassword(username, password);

			if (user != null) {
				session.setAttribute("utente", username);
				System.out.println(user.getUserTypeFK());
				switch (user.getUserTypeFK()) {
				case 1:
					getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
					break;
				case 2:
					getServletContext().getRequestDispatcher("/homechatmaster.jsp").forward(request, response);
					break;
				default:
					getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
					break;
				}
			}
		}
	}

}
