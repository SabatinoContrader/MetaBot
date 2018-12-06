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
import main.model.UserTypes;

public class UserTypesDAO {
	private final String QUERY_ALL = "select * from user_types";
	private final String QUERY_INSERT = "insert into user_types (user_type_id, user_type) values (?,?)";
	private final String QUERY_UPDATE = "UPDATE user_types SET user_type = (?) WHERE user_type_id = (?)"; 
	private final String QUERY_DELETE = "DELETE FROM user_types WHERE user_type_id = (?)"; 

	public List<UserTypes> getAllUserTypes () {
        List<UserTypes> usertypes = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(QUERY_ALL);
           while (resultSet.next()) {
               Integer userTypeId = resultSet.getInt("user_type_id");
               String userType = resultSet.getString("user_type");
               
               usertypes.add(new UserTypes(userTypeId, userType));
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return usertypes;
    }
	
    public boolean insertUserTypes(UserTypes usertypes) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setInt(1, usertypes.getUserTypeId());
            preparedStatement.setString(2, usertypes.getUserType());
            return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
    }
        public boolean updateUserTypes(UserTypes usertypes) {
            Connection connection = ConnectionSingleton.getInstance();
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);
                preparedStatement.setString(1, usertypes.getUserType());
                preparedStatement.setInt(2, usertypes.getUserTypeId());
                return preparedStatement.execute();
            }
            catch (SQLException e) {
                GestoreEccezioni.getInstance().gestisciEccezione(e);
                return false;
            }
    }
        
        public boolean deleteUserTypes(UserTypes usertypes) {
            Connection connection = ConnectionSingleton.getInstance();
            try {
            	PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
                preparedStatement.setInt(1, usertypes.getUserTypeId());
                return preparedStatement.execute();
            }
            catch (SQLException e) {
                GestoreEccezioni.getInstance().gestisciEccezione(e);
                return false;
            }
    }

}
