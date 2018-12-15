package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtualpairprogrammers.dto.ChatbotsDTO;
import com.virtualpairprogrammers.model.Chatbots;
import com.virtualpairprogrammers.service.ChatbotsServiceDTO;


/**
 * La servlet si occupa di parlare con la JSP e utilizza i servizi opportuni.
 * Per chi farà User dovrà anche occuparsi del Login che abbiamo lasciato come struttura e va modificata in modo opportuno
 *
 */
public class ChatbotsServlet extends HttpServlet {

	private final ChatbotsServiceDTO chatbotsServiceDTO = new ChatbotsServiceDTO();
	private List<ChatbotsDTO> allChat= new ArrayList<>();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final String scelta = request.getParameter("richiesta");
		final HttpSession session = request.getSession(true);

		switch (scelta) {

		case "chatbotsManager":
			allChat = this.chatbotsServiceDTO.getAllChatbots();
			request.setAttribute("allChat", allChat);
			getServletContext().getRequestDispatcher("/chatbots.jsp").forward(request, response);
			break;			 

		case "Indietro":
			response.sendRedirect("home.jsp");
			break;

		}

	}
}