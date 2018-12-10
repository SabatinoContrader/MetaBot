package com.virtualpairprogrammers.servlets;

import com.virtualpairprogrammers.service.LoginService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginService loginService;

    public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
    	loginService =  new LoginService();
        HttpSession session = request.getSession();
        session.setAttribute("utente", null);
		if (request != null) {
			String nomeUtente = request.getParameter("username").toString();
			String password = request.getParameter("password").toString();
			String type = loginService.login(nomeUtente, password);
			
			if (!type.equals("")) {
				String[] types = type.split(":");
				String username = types[0];
				String userType = types[1];
				 session.setAttribute("utente", username);
				switch (userType) {
				case "ADMIN":
					getServletContext().getRequestDispatcher("/home.jsp").forward(request,response);
					break;
				case "CHAT_MASTER":
					getServletContext().getRequestDispatcher("/homechatmaster.jsp").forward(request,response);
					break;
				default:
					 getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
					break;
				}
			}else
				 getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
		} else
			 getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
	}
        
}
