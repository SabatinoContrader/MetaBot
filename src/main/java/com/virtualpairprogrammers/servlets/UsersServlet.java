package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtualpairprogrammers.converter.NodesConverter;
import com.virtualpairprogrammers.converter.UsersConverter;
import com.virtualpairprogrammers.dto.NodesDTO;
import com.virtualpairprogrammers.dto.UsersDTO;
import com.virtualpairprogrammers.service.UsersServiceDTO;


/**
 * La servlet si occupa di parlare con la JSP e utilizza i servizi opportuni.
 * Per chi farà User dovrà anche occuparsi del Login che abbiamo lasciato come struttura e va modificata in modo opportuno
 *
 */
public class UsersServlet extends HttpServlet {

	private final UsersServiceDTO usersServiceDTO = new UsersServiceDTO();
	private List<UsersDTO> allUsers= new ArrayList<>();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final String scelta = request.getParameter("richiesta");
		final HttpSession session = request.getSession(true);

		switch (scelta) {

		case "UsersManager":
			allUsers = this.usersServiceDTO.getAllUsers();
			request.setAttribute("allUsers", allUsers);
			getServletContext().getRequestDispatcher("/users.jsp").forward(request, response);
			break;			

		case "insert":
			final Integer id = Integer.parseInt(request.getParameter("id"));
			final String username = request.getParameter("username");
			final String password = request.getParameter("password");
			final String ruolo = request.getParameter("ruolo");
			final UsersDTO users = new UsersDTO(id,username, password, ruolo);
			usersServiceDTO.insertUsers(users);
			showAllUsers(request, response);
			break;
					
		case "update":
			System.out.println("id: "+Integer.parseInt(request.getParameter("id")));
			System.out.println("username: "+request.getParameter("username"));
			System.out.println("password: "+request.getParameter("password"));
			System.out.println("ruolo: "+request.getParameter("ruolo"));

		     	
			final Integer idUpdate = Integer.parseInt(request.getParameter("id"));
			final String usernameUpdate = request.getParameter("username");
			final String passwordUpdate = request.getParameter("password");
			final String ruoloUpdate = request.getParameter("ruolo");
			final UsersDTO user = new UsersDTO(idUpdate, usernameUpdate,passwordUpdate, ruoloUpdate);
					
				
					
			usersServiceDTO.updateUsers(user);
			showAllUsers(request, response);
			break;

		case "delete":
			final Integer idUpdat = Integer.parseInt(request.getParameter("id"));
			
			final UsersDTO use = new UsersDTO(idUpdat,"" ,"","");
			usersServiceDTO.deleteUsers(use);
			showAllUsers(request, response);
			break;

		case "Indietro":
			response.sendRedirect("home.jsp");
			break;

		case "LogsMenu":
			response.sendRedirect("homeLogs.jsp");
			break;

				}

			}

		

	

private void showAllUsers(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	allUsers = this.usersServiceDTO.getAllUsers();
	request.setAttribute("allUsers", allUsers);
	getServletContext().getRequestDispatcher("/users.jsp").forward(request, response);
}
}
