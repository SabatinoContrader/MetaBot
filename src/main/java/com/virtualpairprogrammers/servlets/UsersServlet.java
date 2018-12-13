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
			showAllUsers(request, response);
			break;
	
		case "eliminaUsers":
			Integer id = Integer.parseInt(request.getParameter("id"));
			userService.deleteUser(id);
			showAllUsers(request, response);
			break;
			
		case "insert":
			getServletContext().getRequestDispatcher("/insertUsers.jsp").forward(request,response);
			break;
			
		case "insertUser":
			if (request != null) {
				String username =request.getParameter("username");
				String password =request.getParameter("password");
				String firstName =request.getParameter("firstName");
				String lastName =request.getParameter("lastName");
				String email =request.getParameter("email");
				Integer userTypeFK = Integer.parseInt(request.getParameter("userTypeFK"));
				
				if(userTypeFK !=1 || userTypeFK!=2) {
					throw new RuntimeException("non esiste questo ruolo");
				}
				userService.insertUser(new User(0, username, firstName, lastName, password, email, userTypeFK, null, null, null));
				showAllUsers(request, response);
			}
			break;
			
		case "Indietro":
			getServletContext().getRequestDispatcher("/home.jsp").forward(request,response);
			break;
		
		
		}
	}

	private void showAllUsers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.allUsers = this.userService.getAllUsers();
		request.setAttribute("allUsers", this.allUsers);
		getServletContext().getRequestDispatcher("/users.jsp").forward(request,response);
	}
}
