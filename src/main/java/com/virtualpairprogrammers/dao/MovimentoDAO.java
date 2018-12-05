package com.virtualpairprogrammers.dao;

import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;
//import com.virtualpairprogrammers.model.Badge;
//import main.model.BadgeReader;
import com.virtualpairprogrammers.model.Movimento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MovimentoDAO {

    private final String QUERY_ALLMOV = "select * from movimento";
    private final String QUERY_ALLUSERMOV = "SELECT * from movimento as m,assegnazione as a where m.idbadge=a.idbadge and a.iduser=?";
    private final String QUERY_SELIDB = "select ";
    private final String QUERY_INSMOV = "insert into movimento(idbadgereader,idbadge,datainizio,datafine) values (?,?,?,?) ";
    private final String QUERY_DELMOV = "delete from movimento where idbadgereader=? and idbadge=? and datainizio=?";
    
    public boolean assMovimento(int idBadgeReader, int idBadge, String datainizio, String datafine) {
    	 Connection connection = ConnectionSingleton.getInstance();
         try {
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY_SELIDB);
             
             preparedStatement.setInt(2, idBadgeReader);
             preparedStatement.setInt(1, idBadge);
             preparedStatement.setString(3, datainizio);
             preparedStatement.setString(3, datafine);
             preparedStatement.execute();
             return true;
         }
         catch (SQLException e) {
             GestoreEccezioni.getInstance().gestisciEccezione(e);
             return false;
         }
    }
    
    
    public List<Movimento> getAllMovimenti() {
        List<Movimento> movimenti = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(QUERY_ALLMOV);
           while (resultSet.next()) {
        	   int idBadgeReader = resultSet.getInt("idbadgereader");
        	   int idbadge = resultSet.getInt("idbadge");
        	   String datainizio = resultSet.getString("datainizio");
        	   String datafine = resultSet.getString("datafine");
        	   
               movimenti.add(new Movimento(idBadgeReader,idbadge,datainizio,datafine));
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return movimenti;
    }
    public List<Movimento> getAllUserMovimenti(String iduser) {
        List<Movimento> movimenti = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery("SELECT * from movimento as m,assegnazione as a where m.idbadge=a.idbadge and a.iduser="+iduser);
           while (resultSet.next()) {
        	   int idBadgeReader = resultSet.getInt("idbadgereader");
        	   int idbadge = resultSet.getInt("idbadge");
        	   String datainizio = resultSet.getString("datainizio");
        	   String datafine = resultSet.getString("datafine");
        	   
               movimenti.add(new Movimento(idBadgeReader,idbadge,datainizio,datafine));
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return movimenti;
    }
    public boolean deleteMovimento(int idbadgereader, int idbadge, String datainizio) {
   	 Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELMOV);
            
            preparedStatement.setInt(1, idbadgereader);
            preparedStatement.setInt(2, idbadge);
            preparedStatement.setString(3, datainizio);
            preparedStatement.execute();
            System.out.println("OKOKOK");
            return true;
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
   }
public boolean insertMovimento(Movimento movimento) {
    Connection connection = ConnectionSingleton.getInstance();
    try {
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSMOV);
        preparedStatement.setInt(1, movimento.getIdbadgereader());
        preparedStatement.setInt(2, movimento.getIdbadge());
        preparedStatement.setString(3, movimento.getDatainizio());
        preparedStatement.setString(4, movimento.getDatafine());
        preparedStatement.execute();
        return true;
    }
    catch (SQLException e) {
        GestoreEccezioni.getInstance().gestisciEccezione(e);
        return false;
    }

}
}

    /*
    public List<UserAsset> getAllUsersAssets () {
        List<UserAsset> userassets = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(QUERY_ALLUSERASS);
           while (resultSet.next()) {
        	   int iduser = resultSet.getInt("iduser");
        	   int idasset = resultSet.getInt("idasset");
        	   String orainizio = resultSet.getString("orainizio");
               String orafine = resultSet.getString("orafine");
               userassets.add(new UserAsset(iduser,idasset,orainizio,orafine));
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return userassets;
    }
    
    public List<UserAsset> getAllStorico () {
        List<UserAsset> userassets = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(QUERY_ALLSTORICO);
           while (resultSet.next()) {
        	   int iduser = resultSet.getInt("iduser");
        	   int idasset = resultSet.getInt("idasset");
        	   String orainizio = resultSet.getString("orainizio");
               String orafine = resultSet.getString("orafine");
               userassets.add(new UserAsset(iduser,idasset,orainizio,orafine));
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return userassets;
    }
    
    public boolean insertUserAsset(UserAsset userAsset) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSUSERASS);
            preparedStatement.setInt(1, userAsset.getIduser());
            preparedStatement.setInt(2, userAsset.getIdasset());
            preparedStatement.setString(3, userAsset.getOrainizio());
            preparedStatement.setString(4, userAsset.getOrafine());
            preparedStatement.execute();
            return true;
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }
    
    public boolean insertStorico(UserAsset userasset) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSUSERASSS);
            preparedStatement.setInt(1, userasset.getIduser());
            preparedStatement.setInt(2, userasset.getIdasset());
            preparedStatement.setString(3, userasset.getOrainizio());
            preparedStatement.setString(4, userasset.getOrafine());   
            return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
    }
}
*/