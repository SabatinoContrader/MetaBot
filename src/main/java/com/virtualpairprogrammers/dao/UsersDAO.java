package com.virtualpairprogrammers.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;
import com.virtualpairprogrammers.model.Users;

//CURRENT TIME PER LE DATE DI CREAZIONE MODIFICA E CANCELLAZIONE
//java.sql.Date currentDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());

public class UsersDAO {
    private final String QUERY_ALL         = "SELECT * FROM users";
    private final String QUERY_ALL_VALID   = "SELECT * FROM users WHERE deleted_at IS NULL";
    private final String QUERY_ONE         = "SELECT * FROM users WHERE  user_ID = (?)";
    private final String QUERY_INSERT      = "INSERT INTO users (username, password, first_name, last_name, email, user_type_FK, created_at, updated_at, deleted_at) VALUES (?,?,?,?,?,?,?)";
    private final String QUERY_UPDATE      = "UPDATE users SET password = (?), email =(?),updated_at =(?) WHERE user_ID = (?)";
    private final String QUERY_SOFT_DELETE = "UPDATE users SET deleted_at = (?) WHERE user_ID = (?)";
    private final String QUERY_DELETE      = "DELETE FROM users WHERE user_ID = (?)";
    
    public List<Users> getAllUsers () {
        return getUsers(QUERY_ALL);
    }
    public List<Users> getAllValidUsers () {
        return getUsers(QUERY_ALL_VALID);
    }
    
    /*
     * QUESTO METODO VIENE INVOCATO DAI METODI QUI SOPRA, ESSENDO GLI STESSI DATI RICHIAMATI DA 2 QUERY
     * DIVERSE ALLORA HO CREATO 2 METODI CON NOMI DIVERSI CHE RICHIAMANO QUESTO METODO CAMBIANDO LA QUERY DESIDERATA
     * CON QUESTA METODOLOGIA EVITO DI SCRIVERE 2 VOLTE LO STESSO CODICE IN CUI CAMBIA SOLO LA QUERY DESIDERATA
     */
    private List<Users> getUsers (String select_query) {
        List<Users> users      = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(select_query);
            while (resultSet.next()) {
                Integer userID     = resultSet.getInt("user_ID");
                String  username   = resultSet.getString("username");
                String  password   = resultSet.getString("password");
                String 	first_name = resultSet.getString("first_name");
                String  last_name  = resultSet.getString("last_name");
                String  email      = resultSet.getString("email");
                Integer userTypeFK = resultSet.getInt("user_type_FK");
                Date    createdAT  = resultSet.getDate("created_at");
                Date    updatedAT  = resultSet.getDate("updated_at");
                Date    deletedAT  = resultSet.getDate("deleted_at");
                
                users.add(new Users(userID, username, password, first_name, last_name, email, userTypeFK, createdAT, updatedAT, deletedAT));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    
    public boolean insertUsers (Users user) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setInt(4, user.getUserTypeFk());
            preparedStatement.setDate(5, user.getCreatedAt());
            preparedStatement.setDate(6, user.getUpdatedAt());
            preparedStatement.setDate(7, user.getDeletedAt());
            return preparedStatement.execute();
        } catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
    }
    
    public boolean updateUser (Users user) {
        Connection connection = ConnectionSingleton.getInstance();
        
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);
            preparedStatement.setString(1, user.getPassword());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setDate(3, user.getUpdatedAt());
            preparedStatement.setInt(4, user.getUserID());
            return preparedStatement.execute();
        } catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
    }
    
    public boolean softDeleteUser (Users user) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_SOFT_DELETE);
            preparedStatement.setDate(1, user.getDeletedAt());
            preparedStatement.setInt(2, user.getUserID());
            return preparedStatement.execute();
        } catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
    }
    
    public boolean deleteUser (Users user) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement(QUERY_DELETE);
            preparedStatement.setInt(1, user.getUserID());
            return preparedStatement.execute();
        } catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
    }
    
}
