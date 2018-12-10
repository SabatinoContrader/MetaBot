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
import com.virtualpairprogrammers.model.BotMessages;

public class BotMessagesDAO {
	
	String param="";
	
	private final String QUERY_ALL 		= "SELECT * from bot_messages";
	private final String QUERY_INSERT 	= "INSERT INTO bot_messages (bot_messages_id, bot_messages) values (?,?)";
	private final String QUERY_DELETE 	= "DELETE FROM bot_messages WHERE bot_messages_id = (?)"; 
	
	public List<BotMessages> getAllBotMessages () {
        List<BotMessages> botMessages = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(QUERY_ALL);
           while (resultSet.next()) {
               Integer botMessageId = resultSet.getInt("bot_messages_id");
        	   String botMessage = resultSet.getString("bot_messages");

               botMessages.add(new BotMessages(botMessageId, botMessage));
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return botMessages;
    }
	
	public List<BotMessages> getBotMessages (int id) {
        List<BotMessages> botMessages = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery("SELECT * from bot_messages WHERE bot_messages_id = "+id);
           while (resultSet.next()) {
               Integer botMessageId = resultSet.getInt("bot_messages_id");
        	   String botMessage = resultSet.getString("bot_messages");

               botMessages.add(new BotMessages(botMessageId, botMessage));
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return botMessages;
    }
	
    public boolean insertBotMessages(BotMessages botMessages) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setInt(1, botMessages.getBotMessagesId());
            preparedStatement.setString(2, botMessages.getBotMessages());
            preparedStatement.execute();
            return true;
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }
    
    public boolean updateBotMessages(HttpServletRequest request) {
    	Connection connection = ConnectionSingleton.getInstance();
    	try {
        	param=(String)request.getParameter("campo");
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE bot_messages SET "+param+" = (?) WHERE bot_messages_id = (?)");
            preparedStatement.setString(1, (String)request.getParameter("newData"));
            preparedStatement.setInt(2, Integer.parseInt(request.getParameter("idBotMessages")));
            preparedStatement.execute();
            return true;
    	}
    	catch (SQLException e) {
    		GestoreEccezioni.getInstance().gestisciEccezione(e);
    		return false;
    	}
    }

    public boolean deleteBotMessages(int botMessagesId) {
    	Connection connection = ConnectionSingleton.getInstance();
    	try {
    		PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
    		preparedStatement.setInt(1, botMessagesId);
            preparedStatement.execute();
            return true;
    	}
    	catch (SQLException e) {
    		GestoreEccezioni.getInstance().gestisciEccezione(e);
    		return false;
    	}
    }

}
