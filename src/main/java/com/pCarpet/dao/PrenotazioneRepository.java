package com.pCarpet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pCarpet.model.Movimento;
import com.pCarpet.model.Prenotazione;
import com.pCarpet.model.User;
import com.pCarpet.utils.ConnectionSingleton;
import com.pCarpet.utils.GestoreEccezioni;

@Repository
public interface PrenotazioneRepository extends CrudRepository<Prenotazione, Long>{
	
	
	//Prenotazione findByUserAndAssetAndOrainizio(long iduser, long idasset, String orainizio);
	
	Boolean deleteByUserAndAssetAndOrainizio(long iduser, long idasset, String orainizio);

//	String param="";
//	
//	private final String QUERY_INSERT="insert into prenotazione (iduser, idasset, orainizio, orafine) values (?,?,?,?)";
//    private final String QUERY_DELETE = "delete from prenotazione where iduser=? and idasset=? and orainizio=?";
//	private final String QUERY_ALL = "select * from prenotazione";
//	private final String QUERY_ALLID = "select * from prenotazione where iduser=? and idasset=? and orainizio=?";
//	private final String QUERY_ALLUTILIZZO= "SELECT b.idasset,m.idbadge,m.datainizio,m.datafine FROM movimento AS m LEFT OUTER JOIN badgereader AS b ON m.idbadgereader=b.idbadgereader";
//	private final String EXPORT_ALLUSER="select u.iduser,u.ragioneSociale, p.orainizio, p.orafine, ass.idasset, ass.tipo, ass.prezzo, ass.descrizione from user as u, asset as ass, prenotazione as p where u.iduser=p.iduser and ass.idasset=p.idasset";
//	
//	
//	public PrenotazioneRepository() {
//		
//	}
//	
//	public List<Prenotazione> getAllPrenotazioni(){
//		 List<Prenotazione> listPrenotazione = new ArrayList<>();
//	        Connection connection = ConnectionSingleton.getInstance();
//	        try {
//	           Statement statement = connection.createStatement();
//	           ResultSet resultSet = statement.executeQuery(QUERY_ALL);
//	           while (resultSet.next()) {
//	        	   int iduser = resultSet.getInt("iduser");
//	        	   int idasset = resultSet.getInt("idasset");
//	        	   String orainizio = resultSet.getString("orainizio");
//	        	   String orafine = resultSet.getString("orafine");
//	        	   
//	        	   listPrenotazione.add(new Prenotazione(iduser, idasset, orainizio,orafine));
//	           }
//	        }
//	        catch (SQLException e) {
//	            e.printStackTrace();
//	        }
//	        
//	        return listPrenotazione;
//	}
//	
//	
//	public List getAllExportPrenotazioni(){
//		 List list = new ArrayList();
//	     Connection connection = ConnectionSingleton.getInstance();
//	     try {
//	        Statement statement = connection.createStatement();
//	        ResultSet resultSet = statement.executeQuery(EXPORT_ALLUSER);
//	        while (resultSet.next()) {
//	           int iduser = resultSet.getInt("iduser");
//	     	   
//	     	   String ragioneSociale = resultSet.getString("ragioneSociale");
//	     	   int idasset = resultSet.getInt("idasset");
//	     	   String tipo = resultSet.getString("tipo");
//	     	   double prezzo = resultSet.getDouble("prezzo");
//	     	   String descrizione = resultSet.getString("descrizione");
//	     	   
//	     	   String orainizio = resultSet.getString("orainizio");
//	     	   String orafine = resultSet.getString("orafine");
//	        	   
//	           list.add(iduser);
//	           list.add(ragioneSociale);
//	           list.add(idasset);
//	           list.add(tipo);
//	           list.add(prezzo);
//	           list.add(descrizione);
//	           list.add(orainizio);
//	           list.add(orafine);
//	        }
//	     }
//	     catch (SQLException e) {
//	         e.printStackTrace();
//	     }
//	        
//	     return list;
//	}
//	
//	
//	
//	
//	public Prenotazione getPrenotazione(int iduser, int idasset, String orainizio){
//		 //List<Prenotazione> listPrenotazione = new ArrayList<>();
//		 Prenotazione p=null;
//	        Connection connection = ConnectionSingleton.getInstance();
//	        try {
//	        	
//	        	Statement statement = connection.createStatement();
//	        	
//	            ResultSet resultSet = statement.executeQuery("select * from prenotazione where iduser="+iduser+" and idasset="+idasset+" and orainizio=+'"+orainizio+"'");
//	          
//	            while (resultSet.next()) {
//	            	
//	        	   int iduser2 = resultSet.getInt("iduser");
//	        	   
//	        	   int idasset2 = resultSet.getInt("idasset");
//	        	   String orainizio2 = resultSet.getString("orainizio");
//	        	   String orafine2 = resultSet.getString("orafine");
//	        	   
//	        	   p=new Prenotazione(iduser2,idasset2,orainizio2,orafine2);
//	        	   System.out.println("ass:"+p.toString());
//	        	   //listPrenotazione.add(new Prenotazione(iduser2, idasset2, orainizio2,orafine2));
//	           }
//	        }
//	        catch (SQLException e) {
//	            e.printStackTrace();
//	        }
//	        
//	        return p;
//	}
//	
//	public boolean insertPrenotazione(Prenotazione p) {
//		Connection connection = ConnectionSingleton.getInstance();
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
//            preparedStatement.setLong(1, p.getIduser());
//            preparedStatement.setLong(2, p.getIdasset());
//            preparedStatement.setString(3, p.getOrainizio());
//            preparedStatement.setString(4, p.getOrafine());
//            return preparedStatement.execute();
//        }
//        catch (SQLException e) {
//            GestoreEccezioni.getInstance().gestisciEccezione(e);
//            return false;
//        }
//	}
//	
//	public boolean deletePrenotazione(int iduser, int idasset, String orainizio) {
//        Connection connection = ConnectionSingleton.getInstance();
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
//            preparedStatement.setInt(1, iduser);
//            preparedStatement.setInt(2, idasset);
//            preparedStatement.setString(3, orainizio);
//            preparedStatement.execute();
//            return true;
//        }
//        catch (SQLException e) {
//        	if(e instanceof SQLIntegrityConstraintViolationException) {
//        		System.out.println("Errore durante l'eliminazione di una Prenotazione");
//        		return false;
//        	}
//            GestoreEccezioni.getInstance().gestisciEccezione(e);
//            return false;
//        }
//
//    }
//	
//	
//	public boolean updatePrenotazione(HttpServletRequest request) {
//        Connection connection = ConnectionSingleton.getInstance();
//        try {
//        	param=(String)request.getParameter("campo");
//          	int id1=Integer.parseInt(request.getParameter("id1"));
//          	int id2=Integer.parseInt(request.getParameter("id2"));
//          	String id3="'"+request.getParameter("id3")+"'";
//          	
//          	String nuovoCampo2="'"+(String)request.getAttribute("nuovoCampo2")+"'";
//          	
//        	PreparedStatement preparedStatement = connection.prepareStatement("update prenotazione set "+param+"="+nuovoCampo2+" where iduser=? and idasset=? and orainizio="+id3);
//            //preparedStatement.setString(1, "'"+(String)request.getAttribute("nuovoCampo2")+"'");
//            preparedStatement.setInt(1, id1);
//            preparedStatement.setInt(2, id2);
//            //preparedStatement.setString(4, id3);
//            preparedStatement.execute();
//            return true;
//            
//        }
//            
//        catch (SQLException e) {
//            GestoreEccezioni.getInstance().gestisciEccezione(e);
//            return false;
//        }
//    }
//	
//	
//	
//	
//	public List<Movimento> getAllUtilizzo(){
//		List<Movimento> listUtilizzo = new ArrayList<>();
//        Connection connection = ConnectionSingleton.getInstance();
//        try {
//           Statement statement = connection.createStatement();
//           ResultSet resultSet = statement.executeQuery(QUERY_ALLUTILIZZO);
//           while (resultSet.next()) {
//        	   int idasset = resultSet.getInt("idasset");
//        	   int idbadge = resultSet.getInt("idbadge");
//        	   String datainizio = resultSet.getString("datainizio");
//        	   String datafine = resultSet.getString("datafine");
//        	   
//        	//   listUtilizzo.add(new Movimento(0l, idasset, idbadge, datainizio, datafine));
//           }
//        }
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
//        
//        return listUtilizzo;
//	}
	
}
