package com.virtualpairprogrammers.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import com.virtualpairprogrammers.model.ChatBot;
import com.virtualpairprogrammers.service.ChatBotService;

public class ChatBotServlet extends HttpServlet {

	private ChatBotService chatBotService;
	private List<ChatBot> allChatBot;
	int chatbotID;
	int ownerFK;
	int enterPoint;
	int endPoint;
	String name;
	String welcome;
	ChatBot objChat;
	
	public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
	{
		String scelta = request.getParameter("richiesta");
		HttpSession session = request.getSession(true);
		chatBotService = new ChatBotService();
		
		switch (scelta) {
		case "chatBotManagement":
			this.allChatBot = this.chatBotService.getAllChatBot();
			request.setAttribute("allChatBot", this.allChatBot);
			getServletContext().getRequestDispatcher("/chatBot.jsp").forward(request,response);
			break;
		case "insert":
			getServletContext().getRequestDispatcher("/insertChatBot.jsp").forward(request,response);
			break;
		case "insertChatBot":
			if (request != null) {
				chatbotID = 0;
				ownerFK = Integer.parseInt(request.getParameter("ownerFK").toString());
				enterPoint = Integer.parseInt(request.getParameter("enterPoint").toString());
				endPoint = Integer.parseInt(request.getParameter("endPoint").toString());
				name = request.getParameter("name").toString();
				welcome = request.getParameter("welcome").toString();
				if (chatBotService.insertChatBot(new ChatBot(chatbotID, ownerFK, enterPoint, endPoint, name, welcome))) {
					this.allChatBot = this.chatBotService.getAllChatBot();
					request.setAttribute("allChatBot", this.allChatBot);
					getServletContext().getRequestDispatcher("/chatBot.jsp").forward(request,response);
				} 
				else {
					response.sendRedirect("insertChatBot.jsp");
				}
			}
			break;
		case "eliminaChatBot":
			int id=Integer.parseInt(request.getParameter("id"));
			objChat = new ChatBot(id,0,0,0,"","");
			this.chatBotService.deleteChatBot(objChat);
			this.allChatBot = this.chatBotService.getAllChatBot();
			request.setAttribute("allChatBot", this.allChatBot);
			getServletContext().getRequestDispatcher("/chatBot.jsp").forward(request,response);
			break;
		case "Indietro":
			getServletContext().getRequestDispatcher("/home.jsp").forward(request,response);
			break;
		case "update":
			id=Integer.parseInt(request.getParameter("id"));
			this.allChatBot = this.chatBotService.getChatBot(id);
			request.setAttribute("allChatBot", this.allChatBot);
			getServletContext().getRequestDispatcher("/updateChatBot.jsp").forward(request,response);
			break;
		case "updateChatBot":
			int chatbotID = Integer.parseInt(request.getParameter("chatbotID").toString());
			int ownerFK = Integer.parseInt(request.getParameter("ownerFK").toString());
			int enterPoint = Integer.parseInt(request.getParameter("enterPoint").toString());
			int endPoint = Integer.parseInt(request.getParameter("enterPoint").toString());
			String name = request.getParameter("name").toString();
			String welcome = request.getParameter("welcome").toString();
			objChat = new ChatBot(chatbotID, ownerFK, enterPoint, endPoint, name, welcome);
			this.chatBotService.updateChatBot(objChat);
			this.allChatBot = this.chatBotService.getAllChatBot();
			request.setAttribute("allChatBot", this.allChatBot);
			getServletContext().getRequestDispatcher("/chatBot.jsp").forward(request,response);
			break;
		}
	}
}
