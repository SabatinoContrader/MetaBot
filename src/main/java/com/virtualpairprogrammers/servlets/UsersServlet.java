package com.virtualpairprogrammers.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.virtualpairprogrammers.model.Users;
import com.virtualpairprogrammers.model.UserTypes;
import com.virtualpairprogrammers.service.UsersService;
import com.virtualpairprogrammers.service.UserTypesService;

public class UsersServlet extends HttpServlet {

	private UsersService usersService;
	private UserTypesService userTypesService;
	private List<Users> allUsers;
	private List<UserTypes> allUserTypes;

	public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
	{
		String scelta = request.getParameter("richiesta");
		HttpSession session = request.getSession(true);
		usersService =  new UsersService();
		userTypesService = new UserTypesService();
		
		switch (scelta) {
		case "usersManagement":
			this.allUsers = this.usersService.getAllUsers();
			request.setAttribute("allUsers", this.allUsers);
			getServletContext().getRequestDispatcher("/users.jsp").forward(request,response);
			break;
		case "insert":
			this.allUserTypes = this.userTypesService.getAllUserTypes();
			request.setAttribute("allUserTypes", allUserTypes);
			getServletContext().getRequestDispatcher("/insertUsers.jsp").forward(request,response);
			break;
		case "insertUsers":
			if (request != null) {
				int id = 0;
				String username = request.getParameter("username").toString();
				String password = request.getParameter("password").toString();
				int idUserTypeId = Integer.parseInt(request.getParameter("choice").toString());
				UserTypes userTypes = new UserTypes(idUserTypeId,"");
				if (usersService.insertUsers(new Users( id,username, password, userTypes))) {
					this.allUsers = this.usersService.getAllUsers();
					request.setAttribute("allUsers", this.allUsers);
					getServletContext().getRequestDispatcher("/users.jsp").forward(request,response);
				} 
				else {
					response.sendRedirect("insertUsers.jsp");
				}
			}
			break;
		case "eliminaUsers":

			this.usersService.deleteUsers(Integer.parseInt(request.getParameter("id")));
			this.allUsers = this.usersService.getAllUsers();
			request.setAttribute("allUsers", this.allUsers);
			getServletContext().getRequestDispatcher("/users.jsp").forward(request,response);
			break;
		case "Indietro":
			getServletContext().getRequestDispatcher("/home.jsp").forward(request,response);
			break;
		case "update":
			int id=Integer.parseInt(request.getParameter("id"));
			this.allUsers = this.usersService.getAllUsers(id);
			request.setAttribute("allUsers", this.allUsers);
			getServletContext().getRequestDispatcher("/updateUsers.jsp").forward(request,response);
			break;
		case "updateUsers":
			this.usersService.updateUsers(request);
			this.allUsers = this.usersService.getAllUsers();
			request.setAttribute("allUsers", this.allUsers);
			getServletContext().getRequestDispatcher("/users.jsp").forward(request,response);
			break;
		}
	}
}
