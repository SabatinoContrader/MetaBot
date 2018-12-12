package com.virtualpairprogrammers.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;
import com.virtualpairprogrammers.model.ChatBots;

public class ChatBotsDAO {
    private final String QUERY_ALL         = "SELECT * FROM chatbots";
    private final String QUERT_ALL_VALID   = "SELECT * FROM chatbots WHERE deleted_at IS NULL";
    private final String QUERTY_ONE        = "SELECT * FROM chatbots WHERE chatbot_ID";
    private final String QUERY_INSERT      = "INSERT INTO chatbots (owner_FK, enter_node, end_node, bot_name, welcome, created_at, updated_at, deleted_at) VALUES (?,?,?,?,?,?,?,?)";
    private final String QUERY_UPDATE      = "UPDATE chatbots SET owner_FK= (?), enter_node= (?), end_node=(?), bot_name=(?),welcome=(?),updated_at=(?) WHERE chatbot_ID = (?)";
    private final String QUERY_SOFT_DELETE = "UPDATE chatbots SET deleted_at=(?) WHERE chatbot_ID = (?)";
    private final String QUERY_DELETE      = "DELETE FROM chatbots WHERE chatbot_ID = (?)";
    
    public  List<ChatBots>getAllChatBots(){
        return getChatBots(QUERY_ALL);
    }
    public List<ChatBots>getAllValidChatBots(){
        return getChatBots(QUERT_ALL_VALID);
    }
    
    private List<ChatBots> getChatBots (String select_query) {
        List<ChatBots> chatbots   = new ArrayList<>();
        Connection    connection = ConnectionSingleton.getInstance();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(select_query);
            while (resultSet.next()) {
                Integer chatbotID = resultSet.getInt("chatbot_ID");
                Integer ownerFK   = resultSet.getInt("owner_FK");
                Integer enterNode = resultSet.getInt("enter_node");
                Integer endNode   = resultSet.getInt("end_node");
                String  botName   = resultSet.getString("bot_name");
                String  welcome   = resultSet.getString("welcome");
                Date    createdAt = resultSet.getDate("created_at");
                Date    updatedAt = resultSet.getDate("update_at");
                Date    deletedAt = resultSet.getDate("deleted_at");
                chatbots.add(new ChatBots(chatbotID, ownerFK, enterNode, endNode, botName, welcome, createdAt, updatedAt, deletedAt));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chatbots;
    }
    
    public boolean insertChatBot (ChatBots chatbot) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setInt(1, chatbot.getOwnerFK());
            preparedStatement.setInt(2, chatbot.getEndPoint());
            preparedStatement.setInt(3, chatbot.getEndPoint());
            preparedStatement.setString(4, chatbot.getName());
            preparedStatement.setString(5, chatbot.getWelcome());
            preparedStatement.setDate(6, chatbot.getCreatedAt());
            preparedStatement.setDate(7, chatbot.getUpdatedAt());
            preparedStatement.setDate(8, chatbot.getDeletedAt());
            return preparedStatement.execute();
        } catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
        
    }
    
    public boolean updateChatBot (ChatBots chatbot) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);
            preparedStatement.setInt(1, chatbot.getOwnerFK());
            preparedStatement.setInt(2, chatbot.getEnterPoint());
            preparedStatement.setInt(3,chatbot.getEndPoint());
            preparedStatement.setString(4,chatbot.getName());
            preparedStatement.setString(5,chatbot.getWelcome());
            preparedStatement.setDate(6,chatbot.getUpdatedAt());
            preparedStatement.setInt(7,chatbot.getChatBotID());
            return preparedStatement.execute();
        } catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
    }
    
    public boolean softDeleteChatBot(ChatBots chatbot){
        Connection connection = ConnectionSingleton.getInstance();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_SOFT_DELETE);
            preparedStatement.setDate(1,chatbot.getDeletedAt());
            preparedStatement.setInt(2,chatbot.getChatBotID());
            return preparedStatement.execute();
        }catch (SQLException e){
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
    }
    
    public boolean deleteChatBot (ChatBots chatbot) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
            preparedStatement.setInt(1, chatbot.getChatBotID());
            return preparedStatement.execute();
        } catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
    }
    
}
