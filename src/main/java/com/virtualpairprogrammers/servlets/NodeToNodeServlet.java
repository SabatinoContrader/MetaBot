package com.virtualpairprogrammers.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import com.virtualpairprogrammers.model.ChatBot;
import com.virtualpairprogrammers.model.NodeToNode;
import com.virtualpairprogrammers.model.User;
import com.virtualpairprogrammers.service.NodeToNodeService;
import com.virtualpairprogrammers.service.UserService;

public class NodeToNodeServlet extends HttpServlet {


		private NodeToNodeService nodeToNodeService;
		private List<NodeToNode> allNodeToNode;
		

		public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
		{
			String scelta = request.getParameter("richiesta");
			HttpSession session = request.getSession(true);
			nodeToNodeService =  new NodeToNodeService();
			
			switch (scelta) {
			
		// visualizzazione 
			
			case "nodeToNodeManagement":
				this.allNodeToNode = this.nodeToNodeService.getAllNodeToNode();
				request.setAttribute("allNodeToNode", this.allNodeToNode);
				getServletContext().getRequestDispatcher("/nodeToNode.jsp").forward(request,response);
				break;
	    // inserimento 
				
			case "insertNodeToNode":
				this.allNodeToNode = this.nodeToNodeService.getAllNodeToNode();
				request.setAttribute("allNodeToNode", allNodeToNode);
				getServletContext().getRequestDispatcher("/insertNodeToNode.jsp").forward(request,response);
				break;
			
	   // Cancellazione
			 case "eliminaNodeToNode":

				this.nodeToNodeService.deleteNodeToNode(Integer.parseInt(request.getParameter("First_Id,Second_Id")));
				this.nodeToNode = this.nodeToNodeService.getAllNodeToNode();
				request.setAttribute("allNodeToNode", this.allNodeToNode);
				getServletContext().getRequestDispatcher("/NodeToNode.jsp").forward(request,response);
				break;
	
			}
		}
		
		