package com.virtualpairprogrammers.servlets;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtualpairprogrammers.model.Utente;
import com.virtualpairprogrammers.service.ProdottoService;
import com.virtualpairprogrammers.service.RegisterService;
import com.virtualpairprogrammers.service.UserService;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import com.virtualpairprogrammers.dao.AssetDAO;
import com.virtualpairprogrammers.model.Asset;
import com.virtualpairprogrammers.model.BadgeReader;
import com.virtualpairprogrammers.model.Movimento;
import com.virtualpairprogrammers.model.User;
import com.virtualpairprogrammers.service.AssetService;
import com.virtualpairprogrammers.service.BadgeReaderService;
import com.virtualpairprogrammers.service.MovimentoService;

/**
 * Servlet implementation class ServletAsset
 */
public class MovimentoServlet extends HttpServlet {
	
	private String message;
	private BadgeReaderService badgeReaderService;
	private MovimentoService movimentoService;
	private UserService userService;
	private List<Movimento> allMovimenti;
	private List<User> allUsers;
	private List<Asset> allAssets;
	private WritableFont wfont;
	private WritableFont wc;
	private WritableCellFormat wcfFC;
	private WritableCellFormat wC;
    @Override
    public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
    	this.movimentoService = new MovimentoService();
    	this.userService = new UserService();
    	this.message = "";
    	String choice = request.getParameter("richiesta");
        if (choice != null) {
        	switch (choice) {
            case "movimentiManagement":
            	this.allMovimenti = this.movimentoService.getAllMovimenti();
                request.setAttribute("visualizzaMovimenti", allMovimenti);
            	getServletContext().getRequestDispatcher("/movimentiHome.jsp").forward(request,response);
            	break;
            	
            case "indietro":
            	response.sendRedirect("home.jsp");
            	break;
            case "indietrohome":
            	response.sendRedirect("homeLogs.jsp");
            	break;
            
            case "export":
            	this.allUsers = this.userService.getAllUsers();
            	  request.setAttribute("visualizzaUsers", allUsers);
            	getServletContext().getRequestDispatcher("/movimentiExportHome.jsp").forward(request,response);
            	break;
            case "exportMov":	
            	if (writeOnExcel(request)) 
            	{
            		this.message = "Export avvenuto correttamente";
            	}
            	else {
            		this.message = "Errore durante la procedura di export";
            	}
            	//request.setAttribute("message", this.message);
            	getServletContext().getRequestDispatcher("/homeLogs.jsp").forward(request,response);
                break;
          
        	}}
        	
        	
        
        else {
        	response.sendRedirect("assetHome.jsp");
        }
    }
        public boolean writeOnExcel(HttpServletRequest request) {
        	String par=request.getParameter("dir").toString();
        	String storico=request.getParameter("name").toString();
        	File f=new File(par+"\\"+storico+".xls");
        	String iduser = request.getParameter("scelta").toString();
        	
    		MovimentoService users = new MovimentoService();
    		
    		try {
    	    	wfont = new WritableFont(WritableFont.createFont("Arial"), 12, WritableFont.BOLD, true,
    	        UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.RED);
    	    	wc = new WritableFont(WritableFont.createFont("Arial"), 10, WritableFont.NO_BOLD, false,
    	    	UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
    	    
    	        wcfFC = new WritableCellFormat(wfont);
    	        wC = new WritableCellFormat(wc);
    	   	 	wC.setAlignment(Alignment.CENTRE);
    	        wcfFC.setAlignment(Alignment.CENTRE);
    	        
    	        
    			WritableWorkbook myexel = Workbook.createWorkbook(f);
    			WritableSheet mysheet = myexel.createSheet("mySheet", 0);
    			mysheet.setColumnView(0, 25);
    			mysheet.setColumnView(1,15);
    			mysheet.setColumnView(2, 20);
    			mysheet.setColumnView(3,20);
    			Label l=null;
    			Label l2=null;
    			Label l3=null;
    			Label l4=null;
    			
    			mysheet.addCell(new Label(0,0,"ID Badge Reader",wcfFC));
    			mysheet.addCell(new Label(1,0,"ID Badge",wcfFC));
    			mysheet.addCell(new Label(2,0,"Ora Inizio",wcfFC));
    			mysheet.addCell(new Label(3,0,"Ora Fine",wcfFC));
    			if (iduser.equalsIgnoreCase("")) {
    			for(int i=1; i<=users.getAllMovimenti().size(); i++) {
    				for(int j=0; j<4; j++) {
    					l=new Label(0,i, String.valueOf(users.getAllMovimenti().get(i-1).getIdbadgereader()),wC );
    					l2=new Label(1,i, String.valueOf(users.getAllMovimenti().get(i-1).getIdbadge()),wC );
    					l3=new Label(2,i, users.getAllMovimenti().get(i-1).getDatainizio(),wC);
    					l4=new Label(3,i, users.getAllMovimenti().get(i-1).getDatafine(),wC);
    					mysheet.addCell(l);
    					mysheet.addCell(l2);
    					mysheet.addCell(l3);
    					mysheet.addCell(l4);
    				}
    			}
    			}else if (! iduser.equalsIgnoreCase("")) {
    				for(int i=1; i<=users.getAllUserMovimenti(iduser).size(); i++) {
    					for(int j=0; j<4; j++) {
    						l=new Label(0,i, String.valueOf(users.getAllUserMovimenti(iduser).get(i-1).getIdbadgereader()),wC );
    						l2=new Label(1,i, String.valueOf(users.getAllUserMovimenti(iduser).get(i-1).getIdbadge()),wC );
    						l3=new Label(2,i, users.getAllUserMovimenti(iduser).get(i-1).getDatainizio(),wC);
    						l4=new Label(3,i, users.getAllUserMovimenti(iduser).get(i-1).getDatafine(),wC);
    						mysheet.addCell(l);
    						mysheet.addCell(l2);
    						mysheet.addCell(l3);
    						mysheet.addCell(l4);
    					}
    				}
    			
    			}
    			myexel.write();	
    			myexel.close();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    			return false;
    		} catch (RowsExceededException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    			return false;
    		} catch (WriteException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    			return false;
    		}	
    		return true;
        
    }
	}
	 
	 
	 