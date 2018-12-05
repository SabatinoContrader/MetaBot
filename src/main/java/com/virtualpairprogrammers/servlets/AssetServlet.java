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
import com.virtualpairprogrammers.service.AssetService;

/**
 * Servlet implementation class ServletAsset
 */
public class AssetServlet extends HttpServlet {
	 private AssetService assetService;
     private List<Asset> allAssets;
     
     
	 public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		 String scelta = request.getParameter("richiesta");
	        HttpSession session = request.getSession(true);
	        assetService =  new AssetService();
	        switch (scelta) {
	        	case "assetsManagement":
	        		 this.allAssets = this.assetService.getAllAssets();
	                 request.setAttribute("allAssets", allAssets);
	                 getServletContext().getRequestDispatcher("/asset.jsp").forward(request,response);
	                 break;
	            case "insert":
                    response.sendRedirect("insertAsset.jsp");
	            	 break;
	            case "insertAsset":
	            	if (request != null) {
	                     int idasset = 0;
	                     String tipo = request.getParameter("tipo").toString();
	                     double prezzo = Double.parseDouble(request.getParameter("prezzo").toString());
	                     String descrizione = request.getParameter("descrizione").toString();
	                     if (assetService.insertAsset(new Asset( idasset, tipo, prezzo, descrizione))) {
	                    	 this.allAssets = this.assetService.getAllAssets();
	                    	 request.setAttribute("allAssets", this.allAssets);
	                    	 getServletContext().getRequestDispatcher("/asset.jsp").forward(request,response);
	                     } 
	                     else {
	                         response.sendRedirect("insertAsset.jsp");
	                     }
	            	}
	                break;
	            case "eliminaAsset":
	                
	                this.assetService.deleteAsset(Integer.parseInt(request.getParameter("id")));
	                this.allAssets = this.assetService.getAllAssets();
               	 	request.setAttribute("allAssets", this.allAssets);
               	 	getServletContext().getRequestDispatcher("/asset.jsp").forward(request,response);
	                break;
	            case "Indietro":
	                getServletContext().getRequestDispatcher("/homeAsset.jsp").forward(request,response);
	                break;
	            case "IndietroHome":
	                this.allAssets = this.assetService.getAllAssets();
               	 	request.setAttribute("allAssets", this.allAssets);
	                getServletContext().getRequestDispatcher("/asset.jsp").forward(request,response);
	                break;
	            case "update":
	              int id=Integer.parseInt(request.getParameter("id"));
	                this.allAssets = this.assetService.getAsset(id);
	                 request.setAttribute("allAssets", this.allAssets);
	            	 getServletContext().getRequestDispatcher("/updateAsset.jsp").forward(request,response);
	            	 break;
	            case "updateAsset":
	                this.assetService.updateAsset(request);
	                this.allAssets = this.assetService.getAllAssets();
               	 	request.setAttribute("allAssets", this.allAssets);         
	                getServletContext().getRequestDispatcher("/asset.jsp").forward(request,response);
	                //response.sendRedirect("insertProdotto.jsp");
	                break;
	                
//	            case "update":
//	                MainDispatcher.getInstance().callView("UpdateAsset", request);
//	                break;
//	            case "delete":
//	                MainDispatcher.getInstance().callView("DeleteAsset", request);
//	                break;
//	            case "insertAsset":
//	            	if (this.assetService.insertAsset((Asset)request.get("newAsset"))) {
//	            		this.message = "Inserimento asset avvenuto correttamente";
//	            	}
//	            	else {
//	            		this.message = "Errore durante la procedura di inserimento asset";
//	            	}
//	            	request.put("message", this.message);
//	            	request.put("visualizzaAssets", this.assetService.getAllAssets());
//	            	request.put("visualizzaBadgeReader", this.badgeReaderService.getAllBadgeReaders());
//	            	MainDispatcher.getInstance().callView("AssetHome", request);
//	            	break;
//	            case "deleteAsset":
//	            	if (this.assetService.deleteAsset((Integer) request.get("delAsset"))) {
//	            		this.message = "Cancellazione asset avvenuto correttamente";
//	            	}
//	            	else {
//	            		this.message = "Errore durante la procedura di cancellazione asset";
//	            	}
//	            	request.put("message", this.message);
//	            	request.put("visualizzaAssets", this.assetService.getAllAssets());
//	            	request.put("visualizzaBadgeReader", this.badgeReaderService.getAllBadgeReaders());
//	            	MainDispatcher.getInstance().callView("AssetHome", request);
//	            	break;
//	            case "updateAsset":
//	            	if (assetService.updateAsset(request)) {
//	            		this.message = "Aggiornamento asset avvenuto correttamente";
//	            	}
//	            	else {
//	            		this.message = "Errore durante la procedura di aggiornamento asset";
//	            	}
//	            	request.put("message", this.message);
//	            	request.put("visualizzaAssets", this.assetService.getAllAssets());
//	            	request.put("visualizzaBadgeReader", this.badgeReaderService.getAllBadgeReaders());
//	            	MainDispatcher.getInstance().callView("AssetHome", request);
//	            	break;
//	            }
//	        }
//	        else {
//	        	MainDispatcher.getInstance().callView("AssetHome", null);
	        }
	    }
	}
	 
	 
	 