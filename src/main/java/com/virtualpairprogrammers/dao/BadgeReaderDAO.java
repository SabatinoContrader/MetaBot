package com.virtualpairprogrammers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;
import javax.servlet.http.HttpServletRequest;
import com.virtualpairprogrammers.model.BadgeReader;

public class BadgeReaderDAO {
	
	String param="";
	
    private final String QUERY_ALL = "select * from badgereader";
    private final String QUERY_BADG = "select * from badgereader where idbadgereader=?";

    private final String QUERY_INSERT = "insert into badgereader (idbadgereader,descrizione,tipologia,idasset) values (?,?,?,?)";
    private final String QUERY_DEL = "delete from badgereader where idbadgereader = ?";
    private final String QUERY_ALLIDASSET = "select idbadgereader from contrader.badgereader where idasset=?";
   

    public BadgeReaderDAO() {

    }

    public List<BadgeReader> getAllBadgeReaders () {
    	List<BadgeReader> badgeReaders = new ArrayList<>();
    	
        Connection connection = ConnectionSingleton.getInstance();
        try {
        	
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(QUERY_ALL);
           while (resultSet.next()) {
        	   int idbadgereader = resultSet.getInt("idbadgereader");
        	   String descrizione = resultSet.getString("descrizione");
        	   String tipologia = resultSet.getString("tipologia");
               int idasset = resultSet.getInt("idasset");
               badgeReaders.add(new BadgeReader(idbadgereader, idasset, descrizione, tipologia));
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        return badgeReaders;
    }
    
    public List<BadgeReader> getBadgeReader (int id) {
    	List<BadgeReader> badgeReaders = new ArrayList<>();
    	
        Connection connection = ConnectionSingleton.getInstance();
        try {
        	
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery("select * from badgereader where idbadgereader="+id);
           while (resultSet.next()) {
        	   int idbadgereader = resultSet.getInt("idbadgereader");
        	   String descrizione = resultSet.getString("descrizione");
        	   String tipologia = resultSet.getString("tipologia");
               int idasset = resultSet.getInt("idasset");
               badgeReaders.add(new BadgeReader(idbadgereader, idasset, descrizione, tipologia));
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        return badgeReaders;
    }
   
    public boolean insertBadgeReader(BadgeReader badgeReader) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setInt(1, badgeReader.getIdBadgeReader());
            preparedStatement.setString(2, badgeReader.getDescrizione());
            preparedStatement.setString(3, badgeReader.getTipologia());
            preparedStatement.setInt(4, badgeReader.getIdAsset());
            preparedStatement.execute();
            return true;
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }
    public boolean deleteBadgeReadear(int idBadgeReader) {
    	Connection connection = ConnectionSingleton.getInstance();
    	try {
    		PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DEL);
            preparedStatement.setInt(1,idBadgeReader);
            preparedStatement.execute();
            return true;
    }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }	
    }
    
    public boolean updateBadgeReader(HttpServletRequest request) {
   	 int asset=(Integer)request.getAttribute("asset");
   	 int badge=(Integer)request.getAttribute("Badge");
    	 Connection connection = ConnectionSingleton.getInstance();
         try {
        	// List<BadgeReader> listBeadgeReader = getAllBadgeReaders();
//             for(BadgeReader br: listBeadgeReader) {
//            	 if(br.getIdBadgeReader()==(Integer)request.getAttribute("newIdBadgeReader") && br.getIdAsset()==(Integer)request.getAttribute("newIdAsset")) {
//            		 deleteBadgeReadear( (Integer)request.getAttribute("newIdBadgeReader") );
//            	 }
//             }
             

        	 
         	 PreparedStatement preparedStatement = connection.prepareStatement("update badgereader set idasset="+asset+" where idbadgereader="+badge);
            PreparedStatement delete = connection.prepareStatement("update badgereader set idasset=null where idasset="+asset+" and idbadgereader !="+badge);
         	 //preparedStatement.setInt(1, (Integer)request.getAttribute("asset"));
            // preparedStatement.setInt(2, (Integer)request.getAttribute("Badge"));
             
             preparedStatement.execute();
             delete.execute();             
             
             
             return true;
         }
         catch (SQLException e) {
             GestoreEccezioni.getInstance().gestisciEccezione(e);
             return false;
         }
    	
    }
    
    public List<BadgeReader> getAllBadgeReadersIdAsset(int idAsset) {
        List<BadgeReader> badgeReaders = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(QUERY_ALL);
           
           while (resultSet.next()) {
        	   
        	   PreparedStatement preparedStatement = connection.prepareStatement("QUERY_ALLIDASSET");
        	   preparedStatement.setInt(1, idAsset);
        	   
        	   int idbadgereader = resultSet.getInt("idbadgereader");
        	   int descrizione = resultSet.getInt("descrizione");
        	   String tipologia = resultSet.getString("tipologia");
               String idasset = resultSet.getString("idasset");
               badgeReaders.add(new BadgeReader(idbadgereader,descrizione,tipologia,idasset));
               
           }
           
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return badgeReaders;
    }
	
}
