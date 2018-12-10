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

import com.virtualpairprogrammers.model.UserTypes;
import com.virtualpairprogrammers.service.LoginService;
import com.virtualpairprogrammers.service.UserTypesService;

public class UserTypesServlet extends HttpServlet {

	private UserTypesService userTypesService;
	private List<UserTypes> allUserTypes;

	public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
	{
		String scelta = request.getParameter("richiesta");
		HttpSession session = request.getSession(true);
		userTypesService =  new UserTypesService();

		switch (scelta) {
		case "userTypesManagement":
			this.allUserTypes = this.userTypesService.getAllUserTypes();
			request.setAttribute("allUserTypes", this.allUserTypes);
			getServletContext().getRequestDispatcher("/userTypes.jsp").forward(request,response);
			break;
		case "insert":
			response.sendRedirect("insertUserTypes.jsp");
			break;
		case "insertUserTypes":
			if (request != null) {
				int id = 0;
				String tipo = request.getParameter("tipo").toString();
				if (userTypesService.insertUserTypes(new UserTypes( id, tipo))) {
					this.allUserTypes = this.userTypesService.getAllUserTypes();
					request.setAttribute("allUserTypes", this.allUserTypes);
					getServletContext().getRequestDispatcher("/userTypes.jsp").forward(request,response);
				} 
				else {
					response.sendRedirect("insertUserTypes.jsp");
				}
			}
			break;
		case "eliminaUserTypes":

			this.userTypesService.deleteUserTypes(Integer.parseInt(request.getParameter("id")));
			this.allUserTypes = this.userTypesService.getAllUserTypes();
			request.setAttribute("allUserTypes", this.allUserTypes);
			getServletContext().getRequestDispatcher("/userTypes.jsp").forward(request,response);
			break;
		case "Indietro":
			getServletContext().getRequestDispatcher("/home.jsp").forward(request,response);
			break;
		case "update":
			int id=Integer.parseInt(request.getParameter("id"));
			this.allUserTypes = this.userTypesService.getUserTypes(id);
			request.setAttribute("allUserTypes", this.allUserTypes);
			getServletContext().getRequestDispatcher("/updateUserTypes.jsp").forward(request,response);
			break;
		case "updateUserTypes":
			this.userTypesService.updateUserTypes(request);
			this.allUserTypes = this.userTypesService.getAllUserTypes();
			request.setAttribute("allUserTypes", this.allUserTypes);
			getServletContext().getRequestDispatcher("/userTypes.jsp").forward(request,response);
			break;
		}
	}
}
