package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtualpairprogrammers.model.User;
import com.virtualpairprogrammers.service.UserService;

/**
 * Servlet implementation class InsertUserServlet
 */
public class InsertUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService;
	private String message;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.userService = new UserService();
    	this.message = "";
    	
    	HttpSession session = request.getSession();
    	String username = (String) request.getParameter("username");
    	String password = (String) request.getParameter("password");
    	String nome = (String) request.getParameter("nome");
    	String cognome = (String) request.getParameter("cognome");
    	String telefono = (String) request.getParameter("telefono");
    	String mail = (String) request.getParameter("mail");
    	String partitaiva = (String) request.getParameter("partitaiva");
    	String ruolo = (String) request.getParameter("ruolo");
    	
    	User user=new User(0,username,password,nome,cognome,telefono,mail,partitaiva,ruolo);
    	
    	userService.insertUser(user);
    	
    	
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
