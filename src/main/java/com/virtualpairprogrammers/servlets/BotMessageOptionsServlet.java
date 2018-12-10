package com.virtualpairprogrammers.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import com.virtualpairprogrammers.model.BotMessageOptions;
import com.virtualpairprogrammers.service.BotMessageOptionsService;

public class BotMessageOptionsServlet extends HttpServlet {

	private BotMessageOptionsService botMessageOptionsService;
	private List<BotMessageOptions> allBotMessageOptions;

	public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
	{
		String scelta = request.getParameter("richiesta");
		HttpSession session = request.getSession(true);
		botMessageOptionsService =  new BotMessageOptionsService();

		switch (scelta) {
		case "botMessageOptionsManagement":
			this.allBotMessageOptions = this.botMessageOptionsService.getAllBotMessageOptions();
			request.setAttribute("allBotMessageOptions", this.allBotMessageOptions);
			getServletContext().getRequestDispatcher("/botMessageOptions.jsp").forward(request,response);
			break;
		case "insert":
			response.sendRedirect("insertBotMessageOptions.jsp");
			break;
		case "insertBotMessageOptions":
			if (request != null) {
				int id = 0;
				String message = request.getParameter("message").toString();
				if (botMessageOptionsService.insertBotMessageOptions(new BotMessageOptions( id, message))) {
					this.allBotMessageOptions = this.botMessageOptionsService.getAllBotMessageOptions();
					request.setAttribute("allBotMessageOptions", this.allBotMessageOptions);
					getServletContext().getRequestDispatcher("/botMessageOptions.jsp").forward(request,response);
				} 
				else {
					response.sendRedirect("insertBotMessageOptions.jsp");
				}
			}
			break;
		case "eliminaBotMessageOptions":

			this.botMessageOptionsService.deleteBotMessageOptions(Integer.parseInt(request.getParameter("id")));
			this.allBotMessageOptions = this.botMessageOptionsService.getAllBotMessageOptions();
			request.setAttribute("allBotMessageOptions", this.allBotMessageOptions);
			getServletContext().getRequestDispatcher("/botMessageOptions.jsp").forward(request,response);
			break;
		case "Indietro":
			getServletContext().getRequestDispatcher("/home.jsp").forward(request,response);
			break;
		case "update":
			int id=Integer.parseInt(request.getParameter("id"));
			this.allBotMessageOptions = this.botMessageOptionsService.getBotMessageOptions(id);
			request.setAttribute("allBotMessageOptions", this.allBotMessageOptions);
			getServletContext().getRequestDispatcher("/updateBotMessageOptions.jsp").forward(request,response);
			break;
		case "updateBotMessageOptions":
			this.botMessageOptionsService.updateBotMessageOptions(request);
			this.allBotMessageOptions = this.botMessageOptionsService.getAllBotMessageOptions();
			request.setAttribute("allBotMessageOptions", this.allBotMessageOptions);
			getServletContext().getRequestDispatcher("/botMessageOptions.jsp").forward(request,response);
			break;
		}
	}
}
