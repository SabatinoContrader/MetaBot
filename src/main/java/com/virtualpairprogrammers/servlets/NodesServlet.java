package com.virtualpairprogrammers.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import com.virtualpairprogrammers.model.ChatBots;
import com.virtualpairprogrammers.model.Users;
import com.virtualpairprogrammers.service.ChatBotsService;
import com.virtualpairprogrammers.service.UsersService;

public class NodesServlet extends HttpServlet {

	private ChatBotsService chatBotsService;
	private UsersService usersService;
	private List<ChatBots> allChatBots;
	private List<Users> allUsers;

	public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
	{
		String scelta = request.getParameter("richiesta");
		HttpSession session = request.getSession(true);
		usersService =  new UsersService();
		chatBotsService = new ChatBotsService();
		
		switch (scelta) {
		case "chatBotsManagement":
			this.allChatBots = this.chatBotsService.getAllChatBots();
			request.setAttribute("allChatBots", this.allChatBots);
			getServletContext().getRequestDispatcher("/chatBots.jsp").forward(request,response);
			break;
		case "insert":
			this.allUsers = this.usersService.getAllUsers();
			request.setAttribute("allUsers", allUsers);
			getServletContext().getRequestDispatcher("/insertChatBots.jsp").forward(request,response);
			break;
		case "insertChatBots":
			if (request != null) {
				int id = 0;
				String initialMessage = request.getParameter("initialMessage").toString();
				int idUsersId = Integer.parseInt(request.getParameter("choice").toString());
				Users users = new Users(idUsersId,"", "", null);
				if (chatBotsService.insertChatBots(new ChatBots( id,initialMessage, users))) {
					this.allChatBots = this.chatBotsService.getAllChatBots();
					request.setAttribute("allChatBots", this.allChatBots);
					getServletContext().getRequestDispatcher("/chatBots.jsp").forward(request,response);
				} 
				else {
					response.sendRedirect("insertChatBots.jsp");
				}
			}
			break;
		case "eliminaChatBots":

			this.chatBotsService.deleteChatBots(Integer.parseInt(request.getParameter("id")));
			this.allChatBots = this.chatBotsService.getAllChatBots();
			request.setAttribute("allChatBots", this.allChatBots);
			getServletContext().getRequestDispatcher("/chatBots.jsp").forward(request,response);
			break;
		case "Indietro":
			getServletContext().getRequestDispatcher("/home.jsp").forward(request,response);
			break;
		case "update":
			int id=Integer.parseInt(request.getParameter("id"));
			this.allChatBots = this.chatBotsService.getChatBots(id);
			request.setAttribute("allChatBots", this.allChatBots);
			getServletContext().getRequestDispatcher("/updateChatBots.jsp").forward(request,response);
			break;
		case "updateChatBots":
			this.chatBotsService.updateChatBots(request);
			this.allChatBots = this.chatBotsService.getAllChatBots();
			request.setAttribute("allChatBots", this.allChatBots);
			getServletContext().getRequestDispatcher("/chatBots.jsp").forward(request,response);
			break;
		}
	}
}
