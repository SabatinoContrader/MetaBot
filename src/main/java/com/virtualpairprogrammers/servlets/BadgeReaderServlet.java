package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtualpairprogrammers.model.Prodotto;
import com.virtualpairprogrammers.model.Utente;
import com.virtualpairprogrammers.service.ProdottoService;
import com.virtualpairprogrammers.service.RegisterService;

import com.virtualpairprogrammers.dao.AssetDAO;
import com.virtualpairprogrammers.model.Asset;
import com.virtualpairprogrammers.model.BadgeReader;
import com.virtualpairprogrammers.service.AssetService;
import com.virtualpairprogrammers.service.BadgeReaderService;

/**
 * Servlet implementation class ServletAsset
 */
public class BadgeReaderServlet extends HttpServlet {
	
	private String message;
	private BadgeReaderService badgeReaderService;
	private AssetService assetService;
	private List<BadgeReader> allBadgeReader;
	private List<Asset> allAssets;
	
    @Override
    public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
    	this.assetService = new AssetService();
    	this.badgeReaderService = new BadgeReaderService();
    	this.message = "";
    	String choice = request.getParameter("richiesta");
        if (choice != null) {
        	switch (choice) {
            case "badgesReaderManagement":
            	this.allBadgeReader = this.badgeReaderService.getAllBadgeReaders();
                request.setAttribute("visualizzaBadgeReaders", allBadgeReader);
            	getServletContext().getRequestDispatcher("/badgeReaderHome.jsp").forward(request,response);
            	break;
            	
            case "insert":
            	response.sendRedirect("insertBadgeReader.jsp");
            	//getServletContext().getRequestDispatcher("/inserBadgereader.jsp").forward(request,response);
                break;
            case "indietro":
            	this.allBadgeReader = this.badgeReaderService.getAllBadgeReaders();
                request.setAttribute("visualizzaBadgeReaders", allBadgeReader);
            	getServletContext().getRequestDispatcher("/badgeReaderHome.jsp").forward(request,response);
            	break;
            case "indietrohome":
            	response.sendRedirect("homeAsset.jsp");
            	break;
            case "update":
            	int id=Integer.parseInt(request.getParameter("id"));
            	request.setAttribute("id1", id);
            	request.setAttribute("id", this.badgeReaderService.getBadgeReader(id));
            	this.allAssets = this.assetService.getAllAssets();
                request.setAttribute("allAssets", allAssets);
            	getServletContext().getRequestDispatcher("/updateBadgeReader.jsp").forward(request,response);
                break;
            case "delete":
            	getServletContext().getRequestDispatcher("/deleteBadgeReader.jsp").forward(request,response);
                break;
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
            	break;
            }
        	
        	
        	
        }
        else {
        	response.sendRedirect("assetHome.jsp");
        }
    }
	}
	 
	 
	 