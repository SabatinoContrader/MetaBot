package com.virtualpairprogrammers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;
import com.virtualpairprogrammers.model.UserTypes;

public class UserTypesDAO {
	
	String param="";
	
	private final String QUERY_ALL = "select * from user_types";
	private final String QUERY_INSERT = "insert into user_types (user_types_id, user_types) values (?,?)";
	private final String QUERY_DELETE = "DELETE FROM user_types WHERE user_types_id = (?)"; 

	public List<UserTypes> getAllUserTypes () {
        List<UserTypes> usertypes = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(QUERY_ALL);
           while (resultSet.next()) {
               Integer userTypeId = resultSet.getInt("user_types_id");
               String userType = resultSet.getString("user_types");
               
               usertypes.add(new UserTypes(userTypeId, userType));
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return usertypes;
    }
	
	public List<UserTypes> getUserTypes (int id) {
        List<UserTypes> usertypes = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery("select * from user_types WHERE user_types_id = "+id);
           while (resultSet.next()) {
               Integer userTypeId = resultSet.getInt("user_types_id");
               String userType = resultSet.getString("user_types");
               
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
            preparedStatement.setInt(1, usertypes.getUserTypesId());
            preparedStatement.setString(2, usertypes.getUserTypes());
            preparedStatement.execute();
            return true;
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
    }
        public boolean updateUserTypes(HttpServletRequest request) {
            Connection connection = ConnectionSingleton.getInstance();
            try {
            	param=(String)request.getParameter("campo");
                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE user_types SET "+param+" = (?) WHERE user_types_id = (?)");
                preparedStatement.setString(1, (String)request.getParameter("newData"));
                preparedStatement.setInt(2, Integer.parseInt(request.getParameter("idUserTypes")));
                preparedStatement.execute();
                return true;
            }
            catch (SQLException e) {
                GestoreEccezioni.getInstance().gestisciEccezione(e);
                return false;
            }
    }
        
        public boolean deleteUserTypes(int userTypeId) {
            Connection connection = ConnectionSingleton.getInstance();
            try {
            	PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
                preparedStatement.setInt(1, userTypeId);
                preparedStatement.execute();
                return true;
            }
            catch (SQLException e) {
                GestoreEccezioni.getInstance().gestisciEccezione(e);
                return false;
            }
    }

}
