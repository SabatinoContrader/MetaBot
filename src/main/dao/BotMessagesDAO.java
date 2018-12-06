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
import main.model.BotMessages;

public class BotMessagesDAO {
	private final String QUERY_ALL = "select * from bot_messages";
	private final String QUERY_INSERT = "insert into bot_messages (bot_message_id, bot_message, chatbot_fk) values (?,?,?)";
	private final String QUERY_UPDATE = "UPDATE bot_messages SET bot_message = (?) WHERE bot_message_id = (?)"; 
	private final String QUERY_DELETE = "DELETE FROM bot_messages WHERE bot_message_id = (?)"; 
	
	public List<BotMessages> getAllBotMessages () {
        List<BotMessages> botMessages = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(QUERY_ALL);
           while (resultSet.next()) {
               Integer botMessageId = resultSet.getInt("bot_message_id");
        	   String botMessage = resultSet.getString("bot_message");
               Integer chatbotFk = resultSet.getInt("chatbot_fk");

               botMessages.add(new BotMessages(botMessageId, botMessage, chatbotFk));
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
            preparedStatement.setInt(1, botMessages.getBotMessageId());
            preparedStatement.setString(2, botMessages.getBotMessage());
            preparedStatement.setInt(3, botMessages.getChatbotFk());

            return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }
    
    public boolean updateBotMessages(BotMessages botMessages) {
    	Connection connection = ConnectionSingleton.getInstance();
    	try {
    		PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);
    		preparedStatement.setString(1, botMessages.getBotMessage());
    		preparedStatement.setInt(2, botMessages.getBotMessageId());
    		return preparedStatement.execute();
    	}
    	catch (SQLException e) {
    		GestoreEccezioni.getInstance().gestisciEccezione(e);
    		return false;
    	}
    }

    public boolean deleteBotMessages(BotMessages botMessages) {
    	Connection connection = ConnectionSingleton.getInstance();
    	try {
    		PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
    		preparedStatement.setInt(1, botMessages.getBotMessageId());
    		return preparedStatement.execute();
    	}
    	catch (SQLException e) {
    		GestoreEccezioni.getInstance().gestisciEccezione(e);
    		return false;
    	}
    }

}
