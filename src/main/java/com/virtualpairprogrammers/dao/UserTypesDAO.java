package com.virtualpairprogrammers.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;
import com.virtualpairprogrammers.model.UserTypes;

//CURRENT TIME PER LE DATE DI CREAZIONE MODIFICA E CANCELLAZIONE
//java.sql.Date currentDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());

public class UserTypesDAO {
    private final String QUERY_ALL         = "SELECT * FROM user_types";
    private final String QUERY_ALL_VALID   = "SELECT * FROM user_types WHERE deleted_at IS NULL";
    private final String QUERY_ONE         = "SELECT * FROM user_types WHERE  user_type_ID = (?)";
    private final String QUERY_INSERT      = "INSERT INTO user_types (user_type_name, created_at, updated_at, deleted_at) VALUES (?,?,?,?)";
    private final String QUERY_UPDATE      = "UPDATE user_types SET user_type_name = (?),updated_at =(?) WHERE user_type_ID = (?)";
    private final String QUERY_SOFT_DELETE = "UPDATE user_types SET deleted_at = (?) WHERE user_type_ID = (?)";
    private final String QUERY_DELETE      = "DELETE FROM user_types WHERE user_type_ID = (?)";
    
    public List<UserTypes> getAllUserTypes () {
        return getUserTypes(QUERY_ALL);
    }
    public List<UserTypes> getAllValidUserTypes () {
        return getUserTypes(QUERY_ALL_VALID);
    }
    
    /*
     * QUESTO METODO VIENE INVOCATO DAI METODI QUI SOPRA, ESSENDO GLI STESSI DATI RICHIAMATI DA 2 QUERY
     * DIVERSE ALLORA HO CREATO 2 METODI CON NOMI DIVERSI CHE RICHIAMANO QUESTO METODO CAMBIANDO LA QUERY DESIDERATA
     * CON QUESTA METODOLOGIA EVITO DI SCRIVERE 2 VOLTE LO STESSO CODICE IN CUI CAMBIA SOLO LA QUERY DESIDERATA
     */
    private List<UserTypes> getUserTypes (String select_query) {
        List<UserTypes> user_types      = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(select_query);
            while (resultSet.next()) {
                Integer usertypeID = resultSet.getInt("user_type_ID");
                String  usertypename   = resultSet.getString("user_type_name");;
                Date    createdAT  = resultSet.getDate("created_at");
                Date    updatedAT  = resultSet.getDate("updated_at");
                Date    deletedAT  = resultSet.getDate("deleted_at");
                
                user_types.add(new UserTypes(usertypeID, usertypename, createdAT, updatedAT, deletedAT));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user_types;
    }
    
    public boolean insertUserTypes (UserTypes usertype) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            
            preparedStatement.setString(1, usertype.getUserTypeName());
            preparedStatement.setDate(2, usertype.getCreatedAt());
            preparedStatement.setDate(3, usertype.getUpdatedAt());
            preparedStatement.setDate(4, usertype.getDeletedAt());
            return preparedStatement.execute();
        } catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
    }
    
    public boolean updateUserType (UserTypes usertype) {
        Connection connection = ConnectionSingleton.getInstance();
        
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);
            preparedStatement.setString(1, usertype.getUserTypeName());
            preparedStatement.setDate(2, usertype.getUpdatedAt());
            preparedStatement.setInt(3, usertype.getUserTypeID());
            return preparedStatement.execute();
        } catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
    }
    
    public boolean softDeleteUserType (UserTypes usertype) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_SOFT_DELETE);
            preparedStatement.setDate(1, usertype.getDeletedAt());
            preparedStatement.setInt(2, usertype.getUserTypeID());
            return preparedStatement.execute();
        } catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
    }
    
    public boolean deleteUserType (UserTypes usertype) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement(QUERY_DELETE);
            preparedStatement.setInt(1, usertype.getUserTypeID());
            return preparedStatement.execute();
        } catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
    }
    
}
