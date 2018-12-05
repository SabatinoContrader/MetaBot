package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtualpairprogrammers.model.Assegnazione;
import com.virtualpairprogrammers.model.Badge;
import com.virtualpairprogrammers.model.BadgeReader;
import com.virtualpairprogrammers.model.User;
import com.virtualpairprogrammers.service.AssegnazioneService;
import com.virtualpairprogrammers.service.AssetService;
import com.virtualpairprogrammers.service.BadgeReaderService;
import com.virtualpairprogrammers.service.BadgeService;
import com.virtualpairprogrammers.service.UserService;

/**
 * Servlet implementation class AssegnazioneServlet
 */
public class AssegnazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private AssegnazioneService assegnazioneService;
     private BadgeService badgeService;
     private UserService userService;
     private List<User> listUsers;
     private List<Badge> listBadges;
     private List<Assegnazione> listAssegnazioni;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssegnazioneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.assegnazioneService=new AssegnazioneService();
		this.badgeService = new BadgeService();
    	this.userService = new UserService();
    	//this.message = "";
    	String choice = request.getParameter("richiesta");
        if (choice != null) {
        	switch (choice) {
            case "assegnazioneManagement":
            	this.listAssegnazioni = this.assegnazioneService.getAllAssegnazioni();
            	this.listUsers = this.userService.getAllUsers();
            	this.listBadges = this.badgeService.getAllBadges();
                request.setAttribute("visualAssegnazioni", listAssegnazioni);
                request.setAttribute("visualUsers", listUsers);
                request.setAttribute("visualBadges", listBadges);
            	getServletContext().getRequestDispatcher("/assegnazioneHome.jsp").forward(request,response);
            	break;
            	
            case "insert":
            	int id1=Integer.parseInt(request.getParameter("user"));
            	request.setAttribute("id1", id1);
            	int id2=Integer.parseInt(request.getParameter("badge"));
            	request.setAttribute("id2", id2);
            	
            	request.setAttribute("id", this.assegnazioneService.assegnaBadge(new Assegnazione(id1,id2,LocalDate.now().toString())));
            	
            	this.listAssegnazioni = this.assegnazioneService.getAllAssegnazioni();
            	this.listUsers = this.userService.getAllUsers();
            	this.listBadges = this.badgeService.getAllBadges();
                request.setAttribute("visualAssegnazioni", listAssegnazioni);
                request.setAttribute("visualUsers", listUsers);
                request.setAttribute("visualBadges", listBadges);
            	getServletContext().getRequestDispatcher("/assegnazioneHome.jsp").forward(request,response);
                break;
            	
            	
                
            case "indietro":
            	getServletContext().getRequestDispatcher("/homeCustomers.jsp").forward(request,response);
            	
            	break;
//            case "indietrohome":
//            	response.sendRedirect("homeAsset.jsp");
//            	break;
//            case "update":
//            	int id1=Integer.parseInt(request.getParameter("idUser"));
//            	request.setAttribute("id1", id1);
//            	int id2=Integer.parseInt(request.getParameter("idBadge"));
//            	request.setAttribute("id2", id2);
//            	request.setAttribute("id", this.assegnazioneService.getAssegnazione(id1,id2));
//            	request.setAttribute("id", this.assegnazioneService.getAssegnazione(id2));
//            	this.allAssets = this.assetService.getAllAssets();
//                request.setAttribute("allAssets", allAssets);
//            	getServletContext().getRequestDispatcher("/updateBadgeReader.jsp").forward(request,response);
//                break;
                
            case "delete":
            	
            	int id3=Integer.parseInt(request.getParameter("idUser"));
            	request.setAttribute("id1", id3);
            	int id4=Integer.parseInt(request.getParameter("idBadge"));
            	request.setAttribute("id2", id4);
            	
            	this.assegnazioneService.deleteAssegnazione(id3,id4);
            	
            	this.listAssegnazioni = this.assegnazioneService.getAllAssegnazioni();
            	this.listUsers = this.userService.getAllUsers();
            	this.listBadges = this.badgeService.getAllBadges();
                request.setAttribute("visualAssegnazioni", listAssegnazioni);
                request.setAttribute("visualUsers", listUsers);
                request.setAttribute("visualBadges", listBadges);
            	getServletContext().getRequestDispatcher("/assegnazioneHome.jsp").forward(request,response);
                break;
                /*
            case "insertBadgeReader":
            	if (request != null) {
                    int idbadgereader = 0;
                    String descrizione = request.getParameter("descrizione").toString();
                    String tipologia = request.getParameter("tipologia").toString();
                    int idasset = Integer.parseInt(request.getParameter("idasset").toString());
                    if (badgeReaderService.insertBadgeReader(new BadgeReader( idbadgereader,idasset, descrizione, tipologia ))) {
                   	 this.allBadgeReader = this.badgeReaderService.getAllBadgeReaders();
                   	 request.setAttribute("visualizzaBadgeReaders", this.allBadgeReader);
                   	 getServletContext().getRequestDispatcher("/badgeReaderHome.jsp").forward(request,response);
                    } 
                    else {
                        response.sendRedirect("insertBadgeReader.jsp");
                    }
           	}
               break;
            case "deleteBadgeReader":
            	if(this.badgeReaderService.deleteBadgeReadear(Integer.parseInt(request.getParameter("delBadgeReader"))))
            		
            		this.message = "Cancellazione asset avvenuto correttamente";
            	else
            		System.out.println("no");
           // this.message = "Errore durante la procedura di cancellazione asset";
            	
            	request.setAttribute("message", this.message);
            	this.allBadgeReader = this.badgeReaderService.getAllBadgeReaders();
                request.setAttribute("visualizzaBadgeReaders", this.allBadgeReader);
            	
            	getServletContext().getRequestDispatcher("/badgeReaderHome.jsp").forward(request,response);
            	break;
            	
            	
            	
            case "updateBadgeReader":
               int a=Integer.parseInt(request.getParameter("asset"));
               
               int b=Integer.parseInt(request.getParameter("Badge"));
               
               request.setAttribute("asset", a);
           	request.setAttribute("Badge", b);
                

            	if (badgeReaderService.updateBadgeReader(request)) {
            		this.message = "Aggiornamento asset avvenuto correttamente";
            	}
            	else {
            		this.message = "Errore durante la procedura di aggiornamento asset";
            	}
            	request.setAttribute("message", this.message);
            	request.setAttribute("visualizzaAssets", this.assetService.getAllAssets());
            	request.setAttribute("visualizzaBadgeReaders", this.badgeReaderService.getAllBadgeReaders());
            	getServletContext().getRequestDispatcher("/badgeReaderHome.jsp").forward(request,response);
            	break;*/
            }
        	
        	
        	
        }
        else {
        	response.sendRedirect("assetHome.jsp");
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
