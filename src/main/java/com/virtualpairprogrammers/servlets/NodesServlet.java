package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtualpairprogrammers.dto.NodesDTO;
import com.virtualpairprogrammers.model.Nodes;
import com.virtualpairprogrammers.service.NodesServiceDTO;

public class NodesServlet extends HttpServlet {

	private final NodesServiceDTO nodesServiceDTO = new NodesServiceDTO();
	private List<NodesDTO> allNodes = new ArrayList<>();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final String scelta = request.getParameter("richiesta");
		final HttpSession session = request.getSession(true);

		switch (scelta) {

		case "insert":
			final Integer id = Integer.parseInt(request.getParameter("id"));
			final String text = request.getParameter("text");
			final Integer idNodoPadre = Integer.parseInt(request.getParameter("idNodoPadre"));
			final NodesDTO node = new NodesDTO(id, text, idNodoPadre);
			nodesServiceDTO.insertNodes();
			showAllNodes(request, response);
			break;
			
		case "update":
			System.out.println("id: "+Integer.parseInt(request.getParameter("id")));
			System.out.println("text: "+request.getParameter("text"));
			System.out.println("idNodo: "+Integer.parseInt(request.getParameter("idNodoPadre")));
			
     	
				final Integer idUpdate = Integer.parseInt(request.getParameter("id"));
				final String textUpdate = request.getParameter("text");
				final Integer idNodoUpdate = Integer.parseInt(request.getParameter("idNodoPadre"));
		
			
			nodesServiceDTO.updateNodes();
			showAllNodes(request, response);
			break;

		case "delete":
			nodesServiceDTO.deleteNodes(Integer.parseInt(request.getParameter("id")));
			showAllNodes(request, response);
			break;

		case "Indietro":
			response.sendRedirect("home.jsp");
			break;

		case "LogsMenu":
			response.sendRedirect("homeLogs.jsp");
			break;

		}

	}

	private void showAllNodes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		allNodes = this.nodesServiceDTO.getAllNodes();
		request.setAttribute("allNodes", allNodes);
		getServletContext().getRequestDispatcher("/nodes.jsp").forward(request, response);
	}

}
