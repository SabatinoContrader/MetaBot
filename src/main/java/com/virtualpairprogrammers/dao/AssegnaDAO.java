package com.virtualpairprogrammers.dao;

import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;
import com.virtualpairprogrammers.model.Assegnazione;
import com.virtualpairprogrammers.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AssegnaDAO {
	
	String param="";
	
	private final String QUERY_ALL = "select * from assegnazione";
	private final String QUERY_DELETE = "delete from assegnazione where iduser=? and idbadge=?";
    private final String QUERY_CLIENTI = "select * from user where ruolo='cliente'";
    private final String QUERY_CLIENTIASS= "select distinct u.iduser,username,nome,cognome,partitaiva from user as u join userasset as us on u.iduser=us.iduser where ruolo='cliente'";
    private final String QUERY_ASSEGNA= "insert into assegnazione (iduser,idbadge,dataassegnazione) values (?,?,?)";
    //private final String QUERY_UPDATE = "update user set "+param+"=? where idutente=?";
    
    public AssegnaDAO() {

    }
//    public List<User> getAllClienti () {
//        List<User> listUsers = new ArrayList<>();
//        Connection connection = ConnectionSingleton.getInstance();
//        try {
//           Statement statement = connection.createStatement();
//           ResultSet resultSet = statement.executeQuery(QUERY_CLIENTI);
//           while (resultSet.next()) {
//        	   int idutente = resultSet.getInt("iduser");
//        	   String username = resultSet.getString("username");
//        	   String password = resultSet.getString("password");
//        	   String nome = resultSet.getString("nome");
//        	   String cognome = resultSet.getString("cognome");
//        	   String telefono = resultSet.getString("telefono");
//        	   String mail = resultSet.getString("mail");
//        	   String partitaiva = resultSet.getString("partitaiva");
//        	   String ruolo = resultSet.getString("ruolo");
//        	   listUsers.add(new User(idutente, username, password,nome,cognome,telefono,mail,partitaiva,ruolo));
//           }
//        }
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return listUsers;
//    }
//    
//    public List<User> getAllClientiAss () {
//        List<User> listUsers = new ArrayList<>();
//        Connection connection = ConnectionSingleton.getInstance();
//        try {
//           Statement statement = connection.createStatement();
//           ResultSet resultSet = statement.executeQuery(QUERY_CLIENTIASS);
//           while (resultSet.next()) {
//        	   int idutente = resultSet.getInt("iduser");
//        	   String username = resultSet.getString("username");
//        	   String nome = resultSet.getString("nome");
//        	   String cognome = resultSet.getString("cognome");
//        	   String partitaiva = resultSet.getString("partitaiva");
//        	   listUsers.add(new User(idutente, username,nome,cognome,partitaiva));
//           }
//        }
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return listUsers;
//    }
//    
    public List<Assegnazione> getAllAssegnazioni () {
        List<Assegnazione> listAssegnazioni = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(QUERY_ALL);
           while (resultSet.next()) {
        	   int iduser = resultSet.getInt("iduser");
        	   int idbadge = resultSet.getInt("idbadge");
        	   String dataassegnazione = resultSet.getString("dataassegnazione");
        	   listAssegnazioni.add(new Assegnazione(iduser,idbadge, dataassegnazione));
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listAssegnazioni;
    }

    public boolean assegnaBadge(Assegnazione assegnazione) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_ASSEGNA);
            preparedStatement.setInt(1, assegnazione.getIdUtente());
            preparedStatement.setInt(2, assegnazione.getIdBadge());
            preparedStatement.setString(3, assegnazione.getData());
            preparedStatement.execute();
            return true;
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }
    
    public boolean deleteAssegnazione(int iduser, int idbadge) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
            preparedStatement.setInt(1, iduser);
            preparedStatement.setInt(2, idbadge);
            preparedStatement.execute();
            return true;
        }
        catch (SQLException e) {
        	if(e instanceof SQLIntegrityConstraintViolationException) {
        		System.out.println("Impossibile eliminare badge");
        		return false;
        	}
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
//
//    }
//    
//    public boolean udpateUser(Request request) {
//        Connection connection = ConnectionSingleton.getInstance();
//        try {
//            param=(String)request.get("campo");
//        	PreparedStatement preparedStatement = connection.prepareStatement("update user set "+param+"=? where iduser=?");
//            preparedStatement.setString(1, (String)request.get("newData"));
//            preparedStatement.setInt(2, (Integer)request.get("idUtente"));
//            preparedStatement.execute();
//            return true;
//        }
//        catch (SQLException e) {
//            GestoreEccezioni.getInstance().gestisciEccezione(e);
//            return false;
//        }
//
//    }
    
    }}
