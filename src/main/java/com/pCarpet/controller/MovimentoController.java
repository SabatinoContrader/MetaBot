package com.pCarpet.controller;
import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import com.pCarpet.converter.AssegnazioneConverter;
import com.pCarpet.converter.BadgeConverter;
import com.pCarpet.converter.BadgeReaderConverter;
import com.pCarpet.dto.AssegnazioneDTO;
import com.pCarpet.dto.BadgeDTO;
import com.pCarpet.dto.BadgeReaderDTO;
import com.pCarpet.dto.ExportDTO;
import com.pCarpet.dto.MovimentoDTO;
import com.pCarpet.dto.UserDTO;
import com.pCarpet.model.Assegnazione;
import com.pCarpet.model.Badge;
import com.pCarpet.model.BadgeReader;
import com.pCarpet.model.Movimento;
import com.pCarpet.model.User;
import com.pCarpet.services.AssegnazioneService;
import com.pCarpet.services.AssetService;
import com.pCarpet.services.BadgeReaderService;
import com.pCarpet.services.BadgeService;
import com.pCarpet.services.MovimentoService;
import com.pCarpet.services.PrenotazioneService;
import com.pCarpet.services.UserService;
import com.pCarpet.utils.Date;

@Controller
@RequestMapping("/Movimento")

public class MovimentoController{
	
	private MovimentoService movimentoService;
	private WritableFont wfont;
	private WritableFont wc;
	private WritableFont blank;
	private List<UserDTO> allUsers;
	private WritableCellFormat wcfFC;
	private WritableCellFormat wC;
	private UserService userService;
	private PrenotazioneService prenotazioneService;
	private AssegnazioneService assegnazioneService;
	private BadgeReaderService badgereaderService;
	private BadgeService badgeService;
	public static final int PORT = 1050; 
	
	@Autowired
	public MovimentoController(UserService userService, MovimentoService movimentoService, PrenotazioneService prenotazioneService,AssegnazioneService assegnazioneService,BadgeReaderService badgereaderService,BadgeService badgeService) throws IOException {
		this.userService = userService;
		this.movimentoService= movimentoService;
		this.prenotazioneService= prenotazioneService;
		
		this.assegnazioneService=assegnazioneService;
		this.badgereaderService=badgereaderService;
		this.badgeService=badgeService;
		//Server();
		
	
	}

	@RequestMapping(value = "/homeMovimento", method = RequestMethod.GET)
	public String Logs(HttpServletRequest request, Model model ) {
		String scelta= request.getParameter("scelta");
		if (scelta.equals("movimentoManagement")) {
        	request.setAttribute("visualizzaMovimenti", this.movimentoService.getAllMovimenti());
        	return "homeMovimenti";
		}
		else if(scelta.equals("export"))
				{
			this.allUsers = this.userService.getAllUsers();
			request.setAttribute("visualizzaUsers", allUsers);
            	return "logsExportHome";
    }return "";
        	
	}
	
	
	@RequestMapping(value = "/homeMovimento", method = RequestMethod.POST)
	public String LogsExp(HttpServletRequest request, Model model )
	{
		String scelta= request.getParameter("richiesta");
		if (scelta.equals("exportdue")) {
			if (writeOnExcel(request)) 
        	{
				model.addAttribute("feedback", "success");

        	}
        	else {
        		model.addAttribute("feedback", "wrong");
        	}
		}
		else if(scelta.equals("export"))
		{
	this.allUsers = this.userService.getAllUsers();
	request.setAttribute("visualizzaUsers", allUsers);
    	return "logsExportHome";
		}
		else if(scelta.equals("indietroHome"))
			return "homeLogs";
		this.allUsers = this.userService.getAllUsers();
		request.setAttribute("visualizzaUsers", allUsers);
		return "logsExportHome";
		}
	
	public boolean writeOnExcel(HttpServletRequest request) {
    	String par=request.getParameter("dir").toString();
    	String storico=request.getParameter("name").toString();
    	File f=new File(par+"\\"+storico+".xls");
    	String iduser = request.getParameter("scelta").toString();
    	
    	List<String> list= new ArrayList<>();
    	List<ExportDTO> listP = new ArrayList<>();
    	List listU= new ArrayList();
    	listP=prenotazioneService.getAllExportPrenotazioni();
    	list=movimentoService.getAllExportMovimenti();
    	listU=movimentoService.getExportMovimento(iduser);
		
		try {
	    	wfont = new WritableFont(WritableFont.createFont("Arial"), 12, WritableFont.BOLD, true,
	        UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.RED);
	    	wc = new WritableFont(WritableFont.createFont("Arial"), 10, WritableFont.NO_BOLD, false,
	    	UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
	    	
	    	blank = new WritableFont(WritableFont.createFont("Arial"), 10, WritableFont.NO_BOLD, false,
	    	UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
	    	
	    
	        wcfFC = new WritableCellFormat(wfont);
	        wC = new WritableCellFormat(wc);
	   	 	wC.setAlignment(Alignment.CENTRE);
	        wcfFC.setAlignment(Alignment.CENTRE);
	        WritableCellFormat blankColour = new WritableCellFormat(blank);
	    	blankColour.setBackground(Colour.GRAY_50);
	        
	        
	        
			WritableWorkbook myexel = Workbook.createWorkbook(f);
			
			
			
			
			
			if (iduser.equalsIgnoreCase("")) {
				
				WritableSheet mysheet = myexel.createSheet("Utilizzo", 0);
    			WritableSheet mysheetP = myexel.createSheet("Prenotazione", 1);
    			
    			//User
    			mysheet.setColumnView(0, 15);
    			mysheet.setColumnView(1,25);
    			mysheet.setColumnView(2, 20);
    			mysheet.setColumnView(3,20);
    			
    			mysheet.setColumnView(4, 2);
    			
    			//Asset
    			mysheet.setColumnView(5,15);
    			mysheet.setColumnView(6, 22);
    			mysheet.setColumnView(7,15);
    			mysheet.setColumnView(8, 20);
    			
    			mysheet.setColumnView(9,2);
    			
    			//Data
    			mysheet.setColumnView(10,20);
    			mysheet.setColumnView(11,20);
    			mysheet.setColumnView(12,20);
    			mysheet.setColumnView(13,20);
    			
    			Label l=null;
    			Label l2=null;
    			Label l3=null;
    			Label l4=null;
    			Label l5=null;
    			Label l6=null;
    			Label l7=null;
    			Label l8=null;
    			Label l9=null;
    			Label l10=null;
    			Label l11=null;
    			Label l12=null;
    			Label l13=null;
    			Label l14=null;
    			
    			
    			//Utente
    			mysheetP.setColumnView(0, 15);
    			mysheetP.setColumnView(1,25);
    			
    			mysheetP.setColumnView(2,2);
    			
    			//Asset
    			mysheetP.setColumnView(3,15);
    			mysheetP.setColumnView(4, 22);
    			mysheetP.setColumnView(5,15);
    			mysheetP.setColumnView(6, 20);
    			
    			mysheetP.setColumnView(7,2);
    			
    			//Data
    			mysheetP.setColumnView(8, 20);
    			mysheetP.setColumnView(9,20);
    			mysheetP.setColumnView(10,20);
    			mysheetP.setColumnView(11,20);
    			
    			
    			
    			//Utente
    			mysheet.addCell(new Label(0,0,"ID Utente",wcfFC));
    			mysheet.addCell(new Label(1,0,"Azienda",wcfFC));
    			mysheet.addCell(new Label(2,0,"Nome Utente",wcfFC));
    			mysheet.addCell(new Label(3,0,"Cognome Utente",wcfFC));
    			
    			mysheet.addCell(new Label(4,0,"",blankColour));
    			
    			//Asset
    			mysheet.addCell(new Label(5,0,"ID Asset",wcfFC));
    			mysheet.addCell(new Label(6,0,"Tipo",wcfFC));
    			mysheet.addCell(new Label(7,0,"Prezzo",wcfFC));
    			mysheet.addCell(new Label(8,0,"Descrizione",wcfFC));
    			
    			mysheet.addCell(new Label(9,0,"",blankColour));
    			
    			//Data
    			mysheet.addCell(new Label(10,0,"Data ingresso",wcfFC));
    			mysheet.addCell(new Label(11,0,"Ora ingresso",wcfFC));
    			mysheet.addCell(new Label(12,0,"Data uscita",wcfFC));
    			mysheet.addCell(new Label(13,0,"Ora uscita",wcfFC));
    			
    			
    			
    			mysheetP.addCell(new Label(0,0,"ID Utente",wcfFC));
    			mysheetP.addCell(new Label(1,0,"Azienda",wcfFC));
    			
    			mysheetP.addCell(new Label(2,0,"",blankColour));
    			
    			//Asset
    			mysheetP.addCell(new Label(3,0,"ID Asset",wcfFC));
    			mysheetP.addCell(new Label(4,0,"Tipo",wcfFC));
    			mysheetP.addCell(new Label(5,0,"Prezzo",wcfFC));
    			mysheetP.addCell(new Label(6,0,"Descrizione",wcfFC));
    			
    			mysheetP.addCell(new Label(7,0,"",blankColour));
    			
    			//Data
    			mysheetP.addCell(new Label(8,0,"Data ingresso",wcfFC));
    			mysheetP.addCell(new Label(9,0,"Ora ingresso",wcfFC));
    			mysheetP.addCell(new Label(10,0,"Data uscita",wcfFC));
    			mysheetP.addCell(new Label(11,0,"Ora uscita",wcfFC));
				int f1=1;
    			for(int i=1; i<=list.size()/10; i++) {
    					l=new Label(0,i, String.valueOf(list.get(f1-1)),wC );
    					l2=new Label(1,i, String.valueOf(list.get(f1)),wC );
    					l3=new Label(2,i, String.valueOf(list.get(f1+1)),wC);
    					l4=new Label(3,i,String.valueOf(list.get(f1+2)),wC);
    					l5=new Label(4,i,"",blankColour);
    					l6=new Label(5,i,String.valueOf(list.get(f1+3)),wC);
    					l7=new Label(6,i,String.valueOf(list.get(f1+4)),wC);
    					l8=new Label(7,i,String.valueOf(list.get(f1+5)),wC);
    					l9=new Label(8,i,String.valueOf(list.get(f1+6)),wC);
    					l10=new Label(9,i,"",blankColour);
    					
    					String dataOraI=String.valueOf(list.get(f1+7));
    					dataOraI=formatData(dataOraI);
    					l11=new Label(10,i,Date.formatDateHour(dataOraI).get(0),wC);
    					l12=new Label(11,i,Date.formatDateHour(dataOraI).get(1),wC);
    					
    					String dataOraF=String.valueOf(list.get(f1+8));
    					dataOraF=formatData(dataOraF);
//    					System.out.println("dataF:"+Date.formatDateHour(dataOraF).get(0));
//    					System.out.println("OraF:"+Date.formatDateHour(dataOraF).get(1));
    					
    					l13=new Label(12,i,Date.formatDateHour(dataOraF).get(0),wC);
    					l14=new Label(13,i,Date.formatDateHour(dataOraF).get(1),wC);
    					
    					mysheet.addCell(l);
    					mysheet.addCell(l2);
    					mysheet.addCell(l3);
    					mysheet.addCell(l4);
    					mysheet.addCell(l5);
    					mysheet.addCell(l6);
    					mysheet.addCell(l7);
    					mysheet.addCell(l8);
    					mysheet.addCell(l9);
    					mysheet.addCell(l10);
    					mysheet.addCell(l11);
    					mysheet.addCell(l12);
    					mysheet.addCell(l13);
    					mysheet.addCell(l14);
    					
    					f1+=10;
    					
    			}
			
    			int f2=1;
    			for(int i=1; i<=listP.size()/8; i++) {
    					System.out.println("PRENOTAZIONE FOR:"+listP.get(f2-1));
    					l=new Label(0,i, String.valueOf(listP.get(f2-1)),wC );
    					l2=new Label(1,i, String.valueOf(listP.get(f2)),wC );
    					l3=new Label(2,i,"",blankColour);
    					l4=new Label(3,i,String.valueOf(listP.get(f2+1)),wC);
    					l5=new Label(4,i,String.valueOf(listP.get(f2+2)),wC);
    					l6=new Label(5,i,String.valueOf(listP.get(f2+3)),wC);
    					l7=new Label(6,i,String.valueOf(listP.get(f2+4)),wC);
    					l8=new Label(7,i,"",blankColour);
    					
    					String dataOraI=String.valueOf(listP.get(f2+5));
    					dataOraI=formatData(dataOraI);
    					l9=new Label(8,i,Date.formatDateHour(dataOraI).get(0),wC);
    					l10=new Label(9,i,Date.formatDateHour(dataOraI).get(1),wC);
    					
    					String dataOraF=String.valueOf(listP.get(f2+6));
    					dataOraF=formatData(dataOraF);
    					System.out.println("dataF:"+Date.formatDateHour(dataOraF).get(0));
    					System.out.println("OraF:"+Date.formatDateHour(dataOraF).get(1));
    					
    					l11=new Label(10,i,Date.formatDateHour(dataOraF).get(0),wC);
    					l12=new Label(11,i,Date.formatDateHour(dataOraF).get(1),wC);
    					
    					mysheetP.addCell(l);
    					mysheetP.addCell(l2);
    					mysheetP.addCell(l3);
    					mysheetP.addCell(l4);
    					mysheetP.addCell(l5);
    					mysheetP.addCell(l6);
    					mysheetP.addCell(l7);
    					mysheetP.addCell(l8);
     					mysheetP.addCell(l9);
    					mysheetP.addCell(l10);
    					mysheetP.addCell(l11);
    					mysheetP.addCell(l12);
    					f2+=8;
    			}
			
			}else if (! iduser.equalsIgnoreCase("")) {
				
				WritableSheet mysheet = myexel.createSheet("Utilizzo", 0);
    			
    			//User
    			mysheet.setColumnView(0, 15);
    			mysheet.setColumnView(1,25);
    			mysheet.setColumnView(2, 20);
    			mysheet.setColumnView(3,20);
    			
    			mysheet.setColumnView(4, 2);
    			
    			//Asset
    			mysheet.setColumnView(5,15);
    			mysheet.setColumnView(6, 22);
    			mysheet.setColumnView(7,15);
    			mysheet.setColumnView(8, 20);
    			
    			mysheet.setColumnView(9,2);
    			
    			//Data
    			mysheet.setColumnView(10,20);
    			mysheet.setColumnView(11,20);
    			mysheet.setColumnView(12,20);
    			mysheet.setColumnView(13,20);

    			Label l=null;
    			Label l2=null;
    			Label l3=null;
    			Label l4=null;
    			Label l5=null;
    			Label l6=null;
    			Label l7=null;
    			Label l8=null;
    			Label l9=null;
    			Label l10=null;
    			Label l11=null;
    			Label l12=null;
    			Label l13=null;
    			Label l14=null;
    			
    			
    			
    			//Utente
    			mysheet.addCell(new Label(0,0,"ID Utente",wcfFC));
    			mysheet.addCell(new Label(1,0,"Azienda",wcfFC));
    			mysheet.addCell(new Label(2,0,"Nome Utente",wcfFC));
    			mysheet.addCell(new Label(3,0,"Cognome Utente",wcfFC));
    			
    			mysheet.addCell(new Label(4,0,"",blankColour));
    			
    			//Asset
    			mysheet.addCell(new Label(5,0,"ID Asset",wcfFC));
    			mysheet.addCell(new Label(6,0,"Tipo",wcfFC));
    			mysheet.addCell(new Label(7,0,"Prezzo",wcfFC));
    			mysheet.addCell(new Label(8,0,"Descrizione",wcfFC));
    			
    			mysheet.addCell(new Label(9,0,"",blankColour));
    			
    			//Data
    			mysheet.addCell(new Label(10,0,"Data ingresso",wcfFC));
    			mysheet.addCell(new Label(11,0,"Ora ingresso",wcfFC));
    			mysheet.addCell(new Label(12,0,"Data uscita",wcfFC));
    			mysheet.addCell(new Label(13,0,"Ora uscita",wcfFC));
				
				int f1=1;
    			for(int i=1; i<=listU.size()/10; i++) {
    					l=new Label(0,i, String.valueOf(listU.get(f1-1)),wC );
    					l2=new Label(1,i, String.valueOf(listU.get(f1)),wC );
    					l3=new Label(2,i, String.valueOf(listU.get(f1+1)),wC);
    					l4=new Label(3,i,String.valueOf(listU.get(f1+2)),wC);
    					l5=new Label(4,i,"",blankColour);
    					l6=new Label(5,i,String.valueOf(listU.get(f1+3)),wC);
    					l7=new Label(6,i,String.valueOf(listU.get(f1+4)),wC);
    					l8=new Label(7,i,String.valueOf(listU.get(f1+5)),wC);
    					l9=new Label(8,i,String.valueOf(listU.get(f1+6)),wC);
    					l10=new Label(9,i,"",blankColour);
    					
    					String dataOraI=String.valueOf(listU.get(f1+7));
    					dataOraI=formatData(dataOraI);
    					
    					l11=new Label(10,i,Date.formatDateHour(dataOraI).get(0),wC);
    					l12=new Label(11,i,Date.formatDateHour(dataOraI).get(1),wC);
    					
    					String dataOraF=String.valueOf(listU.get(f1+8));
    					dataOraF=formatData(dataOraF);
    					
    					l13=new Label(12,i,Date.formatDateHour(dataOraF).get(0),wC);
    					l14=new Label(13,i,Date.formatDateHour(dataOraF).get(1),wC);
    					
    					mysheet.addCell(l);
    					mysheet.addCell(l2);
    					mysheet.addCell(l3);
    					mysheet.addCell(l4);
    					mysheet.addCell(l5);
    					mysheet.addCell(l6);
    					mysheet.addCell(l7);
    					mysheet.addCell(l8);
    					mysheet.addCell(l9);
    					mysheet.addCell(l10);
    					mysheet.addCell(l11);
    					mysheet.addCell(l12);
    					mysheet.addCell(l13);
    					mysheet.addCell(l14);
    					
    					f1+=10;
    					
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
public String formatData(String oldDate) {
		
		StringTokenizer st=new StringTokenizer(oldDate,"/.-T: ");
		String newDate="";
		
		int index=0;
		
		while(st.hasMoreTokens()) {
			index += 1;
			String tk=st.nextToken();
			if(tk.length()>=3 && tk.charAt(2)==('.')) {
				String temp=tk.substring(0, 1);
				tk=temp+tk.substring(1,2);
				newDate+=tk;
				break;
			}
			if(index<3) {
				newDate+=tk;
				newDate+="-";
			}
			else if(index==3) {
				newDate+=tk;
				newDate+=" ";
			}
			else if(index<5) {//index<6 se nella data ci sono anche i secondi
				newDate+=tk;
				newDate+=":";
			}else {
				newDate+=tk;
			}//if
			
		}//while
		
		newDate+=":00";
		
		return newDate;
		
		
	}
public void Server() throws IOException {
	

	
	
	  Socket clientSocket=null;
	  BufferedReader in=null;
	  PrintWriter out=null;
	  ServerSocket serverSocket=null;
	  
	  try{
		  serverSocket = new ServerSocket(PORT);
		  System.out.println("EchoServer: started ");
		  System.out.println("Server Socket: "+ serverSocket);
		  // bloccante finchè non avviene una connessione
	    clientSocket = serverSocket.accept();
	    System.out.println("Connection accepted: "+ clientSocket);
	// creazione stream di input da clientSocket
	    InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
	    in = new BufferedReader(isr);
	// creazione stream di output su clientSocket
	    OutputStreamWriter osw = new OutputStreamWriter(clientSocket.getOutputStream());
	  BufferedWriter bw = new BufferedWriter(osw);
	    out = new PrintWriter(bw, true);
	//ciclo di ricezione dal client e invio di risposta
	while(true) {
		
	      String badgereader = in.readLine();
	      if(badgereader.equals("END")) break;
	      System.out.println("Echoing: "+ badgereader);
	      out.println(badgereader);
	      String badge = in.readLine();
	      if(badge.equals("END")) break;
	      System.out.println("Echoing: "+ badge);
	      out.println(badge);
	      System.out.println("sette");
	      simulatore(badgereader,badge);
	      System.out.println("otto");
	 }
	 }
	catch
	 (Exception e) {System.err.println("Accept failed");
	    System.exit(1);
	  }
	  finally {
		  System.out.println("EchoServer: closing...");
		  out.close();
		  in.close();
		  clientSocket.close();
		  serverSocket.close();
		  
	  }
	// chiusura di stream e socket

	 }

	

	
	public void simulatore(String badgereader, String badge) {
		Scanner scanner = new Scanner(System.in);
		List<MovimentoDTO> listMovimenti = new ArrayList<>();
		List<AssegnazioneDTO> listAssegnazioni = new ArrayList<>();
		String message;
		int idUser = 0;
		boolean found;
		boolean access;
		
			found = false;
			System.out.println("-------SIMULATOR-------");
	        System.out.println("");
	        System.out.println("Inserimento Badge Reader");
	        int idBadgeReader = Integer.parseInt(badgereader);
	        System.out.println("Inserimento Badge");
	        int idBadge = Integer.parseInt(badge);
	        String dateNow = LocalDateTime.now().toString();
	        listMovimenti = movimentoService.getAllMovimenti();
	        System.out.println("ANCORA FUORI");
	        for (MovimentoDTO movimento : listMovimenti) {
	        	
	        	if ((movimento.getBadgereader().getIdBadgeReader() == idBadgeReader) && (movimento.getOrafine().equals("0000-00-00T00:00:00"))) {
	        		if (movimento.getBadge().getIdBadge() == idBadge) {
	        			System.out.println("ENTRATO MOVIMENTO FOR");
	        			
	    	            BadgeReader br = BadgeReaderConverter.converToEntity(movimento.getBadgereader());
	    	            
	    	            Badge bgg = BadgeConverter.converToEntity(movimento.getBadge());
	    	            
	    	            long idmov=movimentoService.getMovimento(br,bgg,"0000-00-00T00:00:00");
	    	            System.out.println("ID MOV:"+idmov);
	        			message = "Uscita Badge " + idBadge;
	        			System.out.println(message);
	        			
	        			listAssegnazioni = assegnazioneService.getAllAssegnazioni();
	    	            Assegnazione ass=new Assegnazione();
	    	            for (AssegnazioneDTO assegnazione : listAssegnazioni) {
	    	            	if (assegnazione.getBadge().getIdBadge() == idBadge) {
	    	            		idUser = Integer.parseInt(String.valueOf(assegnazione.getUser().getIduser()));
	    	            		ass=AssegnazioneConverter.converToEntity(assegnazione);
	    	            		break;
	    	            	}	
	    	            }
	        			
	        			if (movimentoService.updateMovimento(idmov,movimento.getBadgereader().getIdBadgeReader(), movimento.getBadge().getIdBadge(), movimento.getOrainizio(), dateNow,ass)) {
	        				message = "Uscita Badge " + idBadge + " Avvenuta Correttamente";
	        			}
	        			else {
	        				message = "Errore Uscita Badge " + idBadge;
	        			}
	        			System.out.println(message);
	        			found = true;
	        			break;
	        		}
	        		else {
	        			access = false;
	        			listAssegnazioni = assegnazioneService.getAllAssegnazioni();
	    	            for (AssegnazioneDTO assegnazione : listAssegnazioni) {
	    	            	if ((assegnazione.getBadge().getIdBadge() == idBadge) && (assegnazione.getUser().getIduser() == idUser)) {
	    	            		access = true;
	    	            		message = "Badge Appartenente Organizzazione, Accesso Consentito";
	    	        			System.out.println(message);
	    	            		break;
	    	            	}	
	    	            }
	    	            if (! access) {
	    	            	message = "Asset Occupato, Impossibile Accedere";
	    	            	System.out.println(message);
	    	            	found = true;
	    	            	break;
	    	            }
	        		}
	        	}
	        }	
	        if (! found) {
	        	message = "Ingresso Badge " + idBadge;
	            System.out.println(message);
	            listAssegnazioni = assegnazioneService.getAllAssegnazioni();
	            Assegnazione ass=new Assegnazione();
	            for (AssegnazioneDTO assegnazione : listAssegnazioni) {
	            	if (assegnazione.getBadge().getIdBadge() == idBadge) {
	            		idUser = Integer.parseInt(String.valueOf(assegnazione.getUser().getIduser()));
	            		ass=AssegnazioneConverter.converToEntity(assegnazione);
	            		break;
	            	}	
	            }
	            
	            List<BadgeReaderDTO> bb = badgereaderService.getBadgeReader(idBadgeReader);
	            BadgeReader br = BadgeReaderConverter.converToEntity(bb.get(0));
	            BadgeDTO bg = badgeService.getBadge(idBadge);
	            Badge bgg = BadgeConverter.converToEntity(bg);
	            
	            
	        	
	        	Movimento movimento = new Movimento(0l,br, bgg, dateNow,"0000-00-00T00:00:00", ass);
	            if (movimentoService.insert(movimento)) {
	            	message = "Ingresso Badge " + idBadge + " Avvenuto correttamente";
	            }
	            else {
	            	message = "Errore Ingresso Badge " + idBadge;
	            }
	            System.out.println(message);
	        }
	        
		
	}


}