package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtualpairprogrammers.model.User;
import com.virtualpairprogrammers.service.UserService;



/**
 * Servlet implementation class CustomersServlet
 */
public class CustomersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserService userService;
	private List<User> l;
	private User u;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomersServlet() {
        super();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String choice = request.getParameter("richiesta");

		HttpSession session=request.getSession(true);
		
		this.userService = new UserService();
        if (choice != null) {
        	switch (choice) {
            case "usersManagement":
            	 l = userService.getAllUsers();
        		request.setAttribute("allUsers", l);
        		
        		getServletContext().getRequestDispatcher("/userManagement.jsp").forward(request,response);
            	
            	break;
            	
            case "insert":
            	
            	getServletContext().getRequestDispatcher("/insertUser.jsp").forward(request,response);
                break;
            case "indietro":
            	response.sendRedirect("home.jsp");
            	break;
            case "indietrohome":
            	response.sendRedirect("homeCustomers.jsp");
            	break;
            case "update":
            	int id=Integer.parseInt(request.getParameter("id"));
	        	u = userService.getUser(id);
            	request.setAttribute("id1", id);
	         	request.setAttribute("allUsers", u);
            	
            	getServletContext().getRequestDispatcher("/modificaUser.jsp").forward(request,response);
                break;
//            case "delete":
//                MainDispatcher.getInstance().callView("DeleteUser", request);
//                break;
            case "insertUser":
            
            	l = userService.getAllUsers();
        		request.setAttribute("allUsers", l);
            	this.userService = new UserService();
            	
            	
            	String username = (String) request.getParameter("username");
            	String password = (String) request.getParameter("password");
            	String nome = (String) request.getParameter("nome");
            	String cognome = (String) request.getParameter("cognome");
            	String telefono = (String) request.getParameter("telefono");
            	String mail = (String) request.getParameter("mail");
            	String partitaiva = (String) request.getParameter("partitaiva");
            	String ruolo = (String) request.getParameter("ruolo");
            	
            	User user=new User(0,username,password,nome,cognome,telefono,mail,partitaiva,ruolo);
            	
            	
            	if (this.userService.insertUser(user)) {
            		//this.message = "Inserimento utente avvenuto correttamente";
            	}
            	else {
            		//this.message = "Errore durante la procedura di inserimento utente";
            	}
            	l = userService.getAllUsers();
        		request.setAttribute("allUsers", l);
        		
        		getServletContext().getRequestDispatcher("/userManagement.jsp").forward(request,response);
            	
            	break;
            	
            case "deleteUser":
            	if (this.userService.deleteUser(Integer.parseInt(request.getParameter("id")))) {
            		//this.message = "Cancellazione utente avvenuta correttamente";
            	}
            	else {
            		//this.message = "Errore durante la procedura di cancellazione utente";
            	}
            	l = userService.getAllUsers();
        		request.setAttribute("allUsers", l);
        		
        		getServletContext().getRequestDispatcher("/userManagement.jsp").forward(request,response);
            	break;
            	
            case "updateUser":
            	int b=Integer.parseInt(request.getParameter("User"));
	        	request.setAttribute("id2", b);
            	if (this.userService.updateUser(request)) {
            		//this.message = "Aggiornamento utente avvenuto correttamente";
            	}
            	else {
            		//this.message = "Errore durante la procedura di aggiornamento utente";
            	}
            	
            	l = userService.getAllUsers();
        		request.setAttribute("allUsers", l);
        		
        		getServletContext().getRequestDispatcher("/userManagement.jsp").forward(request,response);
            	
            	break;
            	
            case "home":
            	getServletContext().getRequestDispatcher("/home.jsp").forward(request,response);

            
            }
            
        }
        else {
        	getServletContext().getRequestDispatcher("/home.jsp").forward(request,response);
        }
        
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
