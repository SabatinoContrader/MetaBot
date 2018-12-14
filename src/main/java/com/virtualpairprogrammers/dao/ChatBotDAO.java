package com.virtualpairprogrammers.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;
import com.virtualpairprogrammers.model.ChatBot;

public class ChatBotDAO {
    private final String QUERY_ALL         = "SELECT * FROM chatbots";
    private final String QUERY_INSERT      = "INSERT INTO chatbots (owner_FK, enter_node, end_node, bot_name, welcome) VALUES (?,?,?,?,?)";
    private final String QUERY_UPDATE      = "UPDATE chatbots SET owner_FK= (?), enter_node= (?), end_node=(?), bot_name=(?),welcome=(?)WHERE chatbot_ID = (?)";
    private final String QUERY_DELETE      = "DELETE FROM chatbots WHERE chatbot_ID = (?)";
    
    public List<ChatBot> getAllChatBot() {
        List<ChatBot> chatbots   = new ArrayList<>();
        Connection    connection = ConnectionSingleton.getInstance();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY_ALL);
            while (resultSet.next()) {
                Integer chatbotID = resultSet.getInt("chatbot_ID");
                Integer ownerFK   = resultSet.getInt("owner_FK");
                Integer enterNode = resultSet.getInt("enter_node");
                Integer endNode   = resultSet.getInt("end_node");
                String  botName   = resultSet.getString("bot_name");
                String  welcome   = resultSet.getString("welcome");
                chatbots.add(new ChatBot(chatbotID, ownerFK, enterNode, endNode, botName, welcome));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chatbots;
    }
    
    public List<ChatBot> getChatBot(int id) {
        List<ChatBot> chatbots   = new ArrayList<>();
        Connection    connection = ConnectionSingleton.getInstance();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY_ALL + "where chatbot_ID="+ id);
            while (resultSet.next()) {
                Integer chatbotID = resultSet.getInt("chatbot_ID");
                Integer ownerFK   = resultSet.getInt("owner_FK");
                Integer enterNode = resultSet.getInt("enter_node");
                Integer endNode   = resultSet.getInt("end_node");
                String  botName   = resultSet.getString("bot_name");
                String  welcome   = resultSet.getString("welcome");
                chatbots.add(new ChatBot(chatbotID, ownerFK, enterNode, endNode, botName, welcome));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chatbots;
    }
    
    public boolean insertChatBot (ChatBot chatbot) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setInt(1, chatbot.getOwnerFK());
            preparedStatement.setInt(2, chatbot.getEndPoint());
            preparedStatement.setInt(3, chatbot.getEndPoint());
            preparedStatement.setString(4, chatbot.getName());
            preparedStatement.setString(5, chatbot.getWelcome());
            return preparedStatement.execute();
        } catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
        
    }
    
    public boolean updateChatBot (ChatBot chatbot) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);
            preparedStatement.setInt(1, chatbot.getOwnerFK());
            preparedStatement.setInt(2, chatbot.getEnterPoint());
            preparedStatement.setInt(3,chatbot.getEndPoint());
            preparedStatement.setString(4,chatbot.getName());
            preparedStatement.setString(5,chatbot.getWelcome());
            preparedStatement.setInt(7,chatbot.getChatbotID());
            return preparedStatement.execute();
        } catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
    }
    
    public boolean deleteChatBot (ChatBot chatbot) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
            preparedStatement.setInt(1, chatbot.getChatbotID());
            return preparedStatement.execute();
        } catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
    }
    
}
