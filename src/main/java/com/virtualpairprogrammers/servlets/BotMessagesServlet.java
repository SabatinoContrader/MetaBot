package com.virtualpairprogrammers.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.virtualpairprogrammers.model.BotMessages;
import com.virtualpairprogrammers.service.LoginService;
import com.virtualpairprogrammers.service.BotMessagesService;

public class BotMessagesServlet extends HttpServlet {

	private BotMessagesService botMessagesService;
	private List<BotMessages> allBotMessages;

	public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
	{
		String scelta = request.getParameter("richiesta");
		HttpSession session = request.getSession(true);
		botMessagesService =  new BotMessagesService();

		switch (scelta) {
		case "botMessagesManagement":
			this.allBotMessages = this.botMessagesService.getAllBotMessages();
			request.setAttribute("allBotMessages", this.allBotMessages);
			getServletContext().getRequestDispatcher("/botMessages.jsp").forward(request,response);
			break;
		case "insert":
			response.sendRedirect("insertBotMessages.jsp");
			break;
		case "insertBotMessages":
			if (request != null) {
				int id = 0;
				String message = request.getParameter("message").toString();
				if (botMessagesService.insertBotMessages(new BotMessages( id, message))) {
					this.allBotMessages = this.botMessagesService.getAllBotMessages();
					request.setAttribute("allBotMessages", this.allBotMessages);
					getServletContext().getRequestDispatcher("/botMessages.jsp").forward(request,response);
				} 
				else {
					response.sendRedirect("insertBotMessages.jsp");
				}
			}
			break;
		case "eliminaBotMessages":

			this.botMessagesService.deleteBotMessages(Integer.parseInt(request.getParameter("id")));
			this.allBotMessages = this.botMessagesService.getAllBotMessages();
			request.setAttribute("allBotMessages", this.allBotMessages);
			getServletContext().getRequestDispatcher("/botMessages.jsp").forward(request,response);
			break;
		case "Indietro":
			getServletContext().getRequestDispatcher("/home.jsp").forward(request,response);
			break;
		case "update":
			int id=Integer.parseInt(request.getParameter("id"));
			this.allBotMessages = this.botMessagesService.getBotMessages(id);
			request.setAttribute("allBotMessages", this.allBotMessages);
			getServletContext().getRequestDispatcher("/updateBotMessages.jsp").forward(request,response);
			break;
		case "updateBotMessages":
			this.botMessagesService.updateBotMessages(request);
			this.allBotMessages = this.botMessagesService.getAllBotMessages();
			request.setAttribute("allBotMessages", this.allBotMessages);
			getServletContext().getRequestDispatcher("/botMessages.jsp").forward(request,response);
			break;
		}
	}
}
