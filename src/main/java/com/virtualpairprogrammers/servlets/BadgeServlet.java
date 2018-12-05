package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtualpairprogrammers.model.Badge;
import com.virtualpairprogrammers.model.User;
import com.virtualpairprogrammers.service.BadgeService;
import com.virtualpairprogrammers.service.UserService;


public class BadgeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private BadgeService badgeService;
	private String message;
	private  Badge l;
	private List<Badge> x;
 
    public BadgeServlet() {
        super();
   
    }

	
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String choice = request.getParameter("richiesta");
		this.badgeService = new BadgeService();
		
	    if (choice != null) {
	    	switch (choice) {
	        case "badgesManagement":
	        	request.setAttribute("allBadges", this.badgeService.getAllBadges());
	        	getServletContext().getRequestDispatcher("/badgeManagement.jsp").forward(request,response);
	        	
	        	break;
	        case "insert":
	        	getServletContext().getRequestDispatcher("/insertBadge.jsp").forward(request,response);
	            break;
	        case "update":
	        	int id=Integer.parseInt(request.getParameter("id"));
	        	l = badgeService.getBadge(id);
            	request.setAttribute("id1", id);
	         	request.setAttribute("allBadges", l);
	            getServletContext().getRequestDispatcher("/modificaBadge.jsp").forward(request,response);
	            break;
	        case "insertBadge":
            	
            	String descrizione = request.getParameter("descrizione");
            	String tipologia = request.getParameter("tipologia");
            	
            	Badge badge=new Badge(0,descrizione,tipologia);
            	
            	
            	if (this.badgeService.insertBadge(badge)) {
            		//this.message = "Inserimento utente avvenuto correttamente";
            	}
            	else {
            		//this.message = "Errore durante la procedura di inserimento utente";
            	}
            	
            	x = badgeService.getAllBadges();
        		request.setAttribute("allBadges", x);
        		getServletContext().getRequestDispatcher("/badgeManagement.jsp").forward(request,response);
	        	
	        case "deleteBadge":
	        	if (this.badgeService.deleteBadge(Integer.parseInt(request.getParameter("id")))) {
            		//this.message = "Cancellazione utente avvenuta correttamente";
            	}
            	else {
            		//this.message = "Errore durante la procedura di cancellazione utente";
            	}
            	x = badgeService.getAllBadges();
        		request.setAttribute("allBadges", x);
        		
        		getServletContext().getRequestDispatcher("/badgeManagement.jsp").forward(request,response);
            	break;
	        case "updateBadge":
	        	
	        	 int b=Integer.parseInt(request.getParameter("Badge"));
	        	request.setAttribute("id2", b);
	        	if (this.badgeService.updateBadge(request)) {
            		//this.message = "Aggiornamento utente avvenuto correttamente";
            	}
            	else {
            		//this.message = "Errore durante la procedura di aggiornamento utente";
            	}
            	
            	x = badgeService.getAllBadges();
        		request.setAttribute("allBadges", x);
        		
        		getServletContext().getRequestDispatcher("/badgeManagement.jsp").forward(request,response);
            	
            	break;
	        case "home":
            	getServletContext().getRequestDispatcher("/home.jsp").forward(request,response);
	        }
	    	
	    }
	    else {
	    	getServletContext().getRequestDispatcher("/home.jsp").forward(request,response);
	    }
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
