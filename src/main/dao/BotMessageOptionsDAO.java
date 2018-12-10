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
import main.model.BotMessageOptions;

public class BotMessageOptionsDAO {
	private final String QUERY_ALL = "select * from bot_message_options";
	private final String QUERY_INSERT = "insert into bot_message_options (bot_message_option_id, bot_message_option) values (?,?)";
	private final String QUERY_UPDATE = "UPDATE bot_message_options SET bot_message_option = (?) WHERE bot_message_option_id = (?)"; 
	private final String QUERY_DELETE = "DELETE FROM bot_message_options WHERE bot_message_option_id = (?)"; 
	
	public List<BotMessageOptions> getAllBotMessageOptions () {
        List<BotMessageOptions> botMessageOptions = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(QUERY_ALL);
           while (resultSet.next()) {
               Integer botMessageOptionId = resultSet.getInt("bot_message_option_id");
        	   String botMessageOption = resultSet.getString("bot_message_option");
       

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
            preparedStatement.setInt(1, botMessageOptions.getBotMessageOptionId());
            preparedStatement.setString(2, botMessageOptions.getBotMessageOption());
            
            return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }
    
    public boolean updateBotMessageOptions(BotMessageOptions botMessageOptions) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);
            preparedStatement.setString(1, botMessageOptions.getBotMessageOption());
            preparedStatement.setInt(2, botMessageOptions.getBotMessageOptionId());
            return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
    }
    
    public boolean deleteBotMessageOptions(BotMessageOptions botMessageOptions) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
        	PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
            preparedStatement.setInt(1, botMessageOptions.getBotMessageOptionId());
            return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
    }

}
