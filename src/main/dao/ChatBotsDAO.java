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
import main.model.ChatBots;
import main.model.UserTypes;

public class ChatBotsDAO {
	private final String QUERY_ALL = "select * from chatbots";
	private final String QUERY_INSERT = "insert into chatbots (chatbot_id, initial_message, user_fk) values (?,?,?)";
	private final String QUERY_UPDATE = "UPDATE chatbots SET initial_message = (?) WHERE chatbot_id = (?)"; 
	private final String QUERY_DELETE = "DELETE FROM chatbots WHERE chatbot_id = (?)"; 

	public List<ChatBots> getAllChatBots () {
        List<ChatBots> chatBots = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(QUERY_ALL);
           while (resultSet.next()) {
               Integer chatbotId = resultSet.getInt("chatbot_id");
        	   String initialMessage = resultSet.getString("initial_message");
        	   String userFk = resultSet.getString("user_fk");

               
        	   chatBots.add(new ChatBots(chatbotId, initialMessage,userFk ));
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
            preparedStatement.setInt(1, chatBots.getChatbotId());
            preparedStatement.setString(2, chatBots.getInitialMessage());
            preparedStatement.setString(3, chatBots.getUserFk());


            return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }
    
    public boolean updateChatBots(ChatBots chatBots) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);
            preparedStatement.setString(1, chatBots.getInitialMessage());
            preparedStatement.setInt(2, chatBots.getChatbotId());
            return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
}
    
    public boolean deleteChatBots(ChatBots chatBots) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
        	PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
            preparedStatement.setInt(1, chatBots.getChatbotId());
            return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
    }

}
