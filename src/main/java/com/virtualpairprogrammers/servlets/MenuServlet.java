package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtualpairprogrammers.dto.NodesDTO;
import com.virtualpairprogrammers.service.NodesServiceDTO;

public class MenuServlet extends HttpServlet {

	private final NodesServiceDTO nodesServiceDTO = new NodesServiceDTO();
	private List<NodesDTO> allNodes;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final String scelta = request.getParameter("richiesta");
		final HttpSession session = request.getSession(true);

		switch (scelta) {

		case "NodesManagement":
			allNodes = this.nodesServiceDTO.getAllNodes();
			request.setAttribute("allNodes", allNodes);
			getServletContext().getRequestDispatcher("/nodes.jsp").forward(request, response);
			break;
		
		case "Indietro":
			response.sendRedirect("home.jsp");
			break;
	
		}

	}

}
