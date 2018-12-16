package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtualpairprogrammers.dto.EsempioDTO;
import com.virtualpairprogrammers.dto.UsersDTO;
import com.virtualpairprogrammers.model.Esempio;
import com.virtualpairprogrammers.service.EsempioServiceDTO;
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

		case "esempioManager":
			allUsers = this.usersServiceDTO.getAllUsers();
			request.setAttribute("allUsers", allUsers);
			getServletContext().getRequestDispatcher("/users.jsp").forward(request, response);
			break;			

		case "Indietro":
			response.sendRedirect("home.jsp");
			break;

		}

	}
}