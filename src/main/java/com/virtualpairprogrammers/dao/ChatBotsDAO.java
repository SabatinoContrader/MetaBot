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
import com.virtualpairprogrammers.model.ChatBots;
import com.virtualpairprogrammers.model.UserTypes;
import com.virtualpairprogrammers.model.Users;

public class ChatBotsDAO {
	String param="";
	
	private final String QUERY_ALL 		= "SELECT * from chatbots inner join users on (users_id_fk = users_id) inner join user_types on (user_types_id_fk = user_types_id)";
	private final String QUERY_INSERT 	= "INSERT INTO chatbots (chatbots_id, initial_message, users_id_fk) values (?,?,?)";
	private final String QUERY_DELETE 	= "DELETE FROM chatbots WHERE chatbots_id = (?)"; 

	public List<ChatBots> getAllChatBots () {
        List<ChatBots> chatBots = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(QUERY_ALL);
           while (resultSet.next()) {
               Integer chatbotId = resultSet.getInt("chatbots_id");
        	   String initialMessage = resultSet.getString("initial_message");
			   Integer usersId = resultSet.getInt("users_id");
			   String username= resultSet.getString("username");
			   String password= resultSet.getString("password");
			   
			   Integer userTypesID = resultSet.getInt("user_types_id_fk"); 
			   String userTypes= resultSet.getString("user_types");
			   
			   UserTypes userTypesObj = new UserTypes(userTypesID,userTypes);
			   Users usersObj = new Users(usersId,username, password,userTypesObj);
        	   chatBots.add(new ChatBots(chatbotId, initialMessage,usersObj));
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return chatBots;
    }
	
	public List<ChatBots> getChatBots (int id) {
        List<ChatBots> chatBots = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery("SELECT * from chatbots inner join users on (users_id_fk = users_id) inner join user_types on (user_types_id_fk = user_types_id)WHERE chatbots_id = "+id);
           while (resultSet.next()) {
               Integer chatbotId = resultSet.getInt("chatbots_id");
        	   String initialMessage = resultSet.getString("initial_message");
			   Integer usersId = resultSet.getInt("users_id");
			   String username= resultSet.getString("username");
			   String password= resultSet.getString("password");
			   
			   Integer userTypesID = resultSet.getInt("user_types_id_fk"); 
			   String userTypes= resultSet.getString("user_types");
			   
			   UserTypes userTypesObj = new UserTypes(userTypesID,userTypes);
			   Users usersObj = new Users(usersId,username, password,userTypesObj);
        	   chatBots.add(new ChatBots(chatbotId, initialMessage,usersObj));
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return chatBots;
    }
	
    public boolean insertChatBots(ChatBots chatBots) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setInt(1, chatBots.getChatBotsId());
            preparedStatement.setString(2, chatBots.getInitialMessage());
            preparedStatement.setInt(3, chatBots.getUsersFK().getUsersId());
            preparedStatement.execute();
            return true;
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }
    
    public boolean updateChatBots(HttpServletRequest request) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
        	param=(String)request.getParameter("campo");        	
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE chatbots SET "+param+" = (?) WHERE chatbots_id = (?)");
            preparedStatement.setString(1, (String)request.getParameter("newData"));
            preparedStatement.setInt(2, Integer.parseInt(request.getParameter("idChatBots")));
            preparedStatement.execute();
            return true;
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
}
    
    public boolean deleteChatBots(int chatBotsId) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
        	PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
            preparedStatement.setInt(1, chatBotsId);
            preparedStatement.execute();
            return true;
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
    }

}
