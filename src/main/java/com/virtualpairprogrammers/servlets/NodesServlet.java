package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtualpairprogrammers.dto.NodesDTO;
import com.virtualpairprogrammers.model.Nodes;
import com.virtualpairprogrammers.service.NodesServiceDTO;
import com.virtualpairprogrammers.utils.FunzioniDiUtilita;
import com.virtualpairprogrammers.converter.NodesConverter;

public class NodesServlet extends HttpServlet {

	private final NodesServiceDTO nodesServiceDTO = new NodesServiceDTO();
	private List<NodesDTO> allNodes = new ArrayList<>();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final String scelta = request.getParameter("richiesta");
		final HttpSession session = request.getSession(true);

		switch (scelta) {

		case "insertnodes":
			final Integer id = Integer.parseInt(request.getParameter("id"));
			final String text = request.getParameter("text");
			final Integer idNodoPadre = Integer.parseInt(request.getParameter("idNodoPadre"));
			final NodesDTO node = new NodesDTO(id, text, idNodoPadre);
			nodesServiceDTO.insertNodes(NodesConverter.toEntity(node));
			showAllNodes(request, response);
			break;

		case "updatenodes":
			System.out.println("id: " + Integer.parseInt(request.getParameter("id")));
			System.out.println("text: " + request.getParameter("text"));
			System.out.println("idNodo: " + Integer.parseInt(request.getParameter("idNodoPadre")));

			final Integer idUpdate = Integer.parseInt(request.getParameter("id"));
			final String textUpdate = request.getParameter("text");
			final Integer idNodoUpdate = Integer.parseInt(request.getParameter("idNodoPadre"));
			final NodesDTO nodes = new NodesDTO(idUpdate, textUpdate, idNodoUpdate);

			nodesServiceDTO.updateNodes(NodesConverter.toEntity(nodes));
			showAllNodes(request, response);
			break;

		case "deletenodes":
			nodesServiceDTO.deleteNodes(Integer.parseInt(request.getParameter("id")));
			showAllNodes(request, response);
			break;

		case "Indietro":
			response.sendRedirect("home.jsp");
			break;

		case "LogsMenu":
			response.sendRedirect("homeLogs.jsp");
			break;
		case "visualizzaChat":
			// int sChatID2 = Integer.parseInt(request.getParameter("sChatID").toString());
			//session.setAttribute("sChatID", sChatID2);
			this.allNodes = FunzioniDiUtilita.stampaChat(this.nodesServiceDTO.getAllNodes(), 0,12);
			request.setAttribute("allNodesDTO", this.allNodes);
			getServletContext().getRequestDispatcher("/visualizzaChat.jsp").forward(request, response);
			break;
		case "simulaChat":
			//sChatID2 = Integer.parseInt(session.getAttribute("sChatID").toString());
			//session.setAttribute("sChatID", sChatID2);
			this.allNodes = FunzioniDiUtilita.stampaChat(this.nodesServiceDTO.getAllNodes(), 0,12);
			List<Integer> listaPadre = new ArrayList<>();
			HashMap<Integer, List<NodesDTO>> hashMessage = new HashMap<>();

			for (NodesDTO messageDTO : this.allNodes) {
				if (!listaPadre.contains(messageDTO.getIdNodoPadre())) {
					listaPadre.add(messageDTO.getIdNodoPadre());
					List<NodesDTO> listaFigli = new ArrayList<>();
					hashMessage.put(messageDTO.getIdNodoPadre(), listaFigli);
					for (NodesDTO lista2 : this.allNodes) {
						if (messageDTO.getIdNodoPadre() == lista2.getIdNodoPadre()) {
							hashMessage.get(messageDTO).add(lista2);
						}
					}

				}
			}
			session.setAttribute("hashMessage", hashMessage);
			request.setAttribute("list", hashMessage.get(allNodes.get(0)));
			// request.setAttribute("padre",
			// allMessageDTO.get(0).getMessageFK().getMessageId());
			getServletContext().getRequestDispatcher("/simulaChat.jsp").forward(request, response);
			break;
		case "NovoChat":
			hashMessage = (HashMap<Integer, List<NodesDTO>>) session.getAttribute("hashMessage");
			Integer nuovoPadre = Integer.parseInt(request.getParameter("prossimoPadre"));
			Integer find = null;
			for (Integer padreHash : hashMessage.keySet()) {
				if (padreHash == nuovoPadre) {
					find = padreHash;
					// System.out.println("padreHash: " + padreHash);
				}
			}
			if (find != null) {
				request.setAttribute("list", hashMessage.get(find));
			} else {
				request.setAttribute("foglia", "foglia");
			}
			// System.out.println("padre: " + find);
			// System.out.println("hash: " + hashMessage.get(find));
			// request.setAttribute("list", hashMessage.get(find));
			getServletContext().getRequestDispatcher("/simulaChat.jsp").forward(request, response);
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
