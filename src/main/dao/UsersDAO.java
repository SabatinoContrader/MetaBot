package main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.Users;

public class UsersDAO {
	private final String QUERY_ALL = "select * from users";
	private final String QUERY_INSERT = "insert into users (username, password, user_type_fk) values (?,?,?)";
	private final String QUERY_UPDATE = "UPDATE users SET password = (?) WHERE username = (?)"; 
	private final String QUERY_DELETE = "DELETE FROM users WHERE username = (?)"; 

	public List<Users> getAllUsers() {
        List<Users> users = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(QUERY_ALL);
           while (resultSet.next()) {
        	   String username = resultSet.getString("username");
        	   String password = resultSet.getString("password");
               Integer userTypeFk = resultSet.getInt("user_type_fk");
               
               users.add(new Users(username, password,userTypeFk ));
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
	
    public boolean insertUsers(Users users) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setString(1, users.getUsername());
            preparedStatement.setString(2, users.getPassword());
            preparedStatement.setInt(3, users.getuserTypeFk());

            return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }
    public boolean updateUsers(Users users) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);
            preparedStatement.setString(1, users.getPassword());
            preparedStatement.setString(2, users.getUsername());
            return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
    }
    
    public boolean deleteUsers(Users users) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
        	PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
            preparedStatement.setString(1, users.getUsername());
            return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
}

}
