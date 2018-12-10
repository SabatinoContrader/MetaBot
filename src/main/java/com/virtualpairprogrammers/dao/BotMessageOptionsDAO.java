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
import com.virtualpairprogrammers.model.BotMessageOptions;

public class BotMessageOptionsDAO {
	
	String param="";
	
	private final String QUERY_ALL = "select * from bot_message_options";
	private final String QUERY_INSERT = "insert into bot_message_options (bot_message_options_id, bot_message_options) values (?,?)";
	private final String QUERY_DELETE = "DELETE FROM bot_message_options WHERE bot_message_options_id = (?)"; 
	
	public List<BotMessageOptions> getAllBotMessageOptions () {
        List<BotMessageOptions> botMessageOptions = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(QUERY_ALL);
           while (resultSet.next()) {
               Integer botMessageOptionId = resultSet.getInt("bot_message_options_id");
        	   String botMessageOption = resultSet.getString("bot_message_options");
       

        	   botMessageOptions.add(new BotMessageOptions(botMessageOptionId, botMessageOption));
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return botMessageOptions;
    }

	public List<BotMessageOptions> getBotMessageOptions (int id) {
        List<BotMessageOptions> botMessageOptions = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery("SELECT * from bot_message_options WHERE bot_message_options_id = "+id);
           while (resultSet.next()) {
               Integer botMessageOptionId = resultSet.getInt("bot_message_options_id");
        	   String botMessageOption = resultSet.getString("bot_message_options");
       

        	   botMessageOptions.add(new BotMessageOptions(botMessageOptionId, botMessageOption));
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return botMessageOptions;
    }
	
    public boolean insertBotMessageOptions(BotMessageOptions botMessageOptions) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setInt(1, botMessageOptions.getBotMessageOptionsId());
            preparedStatement.setString(2, botMessageOptions.getBotMessageOptions());           
            preparedStatement.execute();
            return true;
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }
    
    public boolean updateBotMessageOptions(HttpServletRequest request) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
        	param=(String)request.getParameter("campo");
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE bot_message_options SET "+param+" = (?) WHERE bot_message_options_id = (?)");
            preparedStatement.setString(1, (String)request.getParameter("newData"));
            preparedStatement.setInt(2, Integer.parseInt(request.getParameter("idBotMessageOptions")));
             preparedStatement.execute();
            return true;
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
    }
    
    public boolean deleteBotMessageOptions(int botMessageOptionsId) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
        	PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
            preparedStatement.setInt(1, botMessageOptionsId);
            preparedStatement.execute();
            return true;
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
    }

}
