package com.pCarpet.dao;

import com.pCarpet.utils.ConnectionSingleton;
import com.pCarpet.utils.GestoreEccezioni;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;


public class LoginRepository{

    private final String QUERY_LOGIN = "select * from user where username = ? and password = ?";
    private final String QUERY_LOGIN_RUOLO = "select * from user where username = ? and password = ? and ruolo = ?";

    public boolean login (String username, String password) {

        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_LOGIN);
            statement.setString(1, username);
            statement.setString(2, password);
            return statement.executeQuery().next();
            
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
    }
    
    public boolean login (String username, String password, String ruolo) {

        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_LOGIN_RUOLO);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, ruolo);
            return statement.executeQuery().next();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
    }
}
