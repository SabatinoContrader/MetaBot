package com.virtualpairprogrammers.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;
import com.virtualpairprogrammers.model.Nodes;
import com.virtualpairprogrammers.model.ChatBots;
import com.virtualpairprogrammers.model.BotMessages;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class NodesDAO {

	String param="";
	
	
	private final String QUERY_ALL = "SELECT * FROM nodes inner join chatbots on (chatbots_id_fk = chatbots_id) inner join bot_messages on (bot_messages_id_fk = bot_messages_id)";
	private final String QUERY_INSERT = "insert into nodes (nodes_id, chatbots_id_fk, bot_messages_id_fk, sequence) values (?,?,?,?)";
	private final String QUERY_DELETE = "DELETE FROM nodes WHERE nodes_id = (?)";

	public List<Nodes> getAllNodes() {
		
		List<Nodes> nodes = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			while (resultSet.next()) {
				Integer nodesId = resultSet.getInt("nodes_id");
				
				Integer chatbotsIdFK = resultSet.getInt("chatbots_id_fk");
				String initialMessage = resultSet.getString("initial_message");
				Integer usersIdFK = resultSet.getInt("users_id_fk");
				ChatBots chatBotsObj = new ChatBots(chatbotsIdFK,initialMessage,null);
				
				Integer botMessagesIdFK = resultSet.getInt("bot_messages_id_fk");
				String botMessages = resultSet.getString("bot_messages");
				BotMessages botMessagesObj = new BotMessages(botMessagesIdFK, botMessages);
				
				Integer sequence = resultSet.getInt("sequence");

				nodes.add(new Nodes(nodesId, chatBotsObj, botMessagesObj, sequence));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nodes;
	}

	public List<Nodes> getNodes(int id) {
		
		List<Nodes> nodes = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM nodes inner join chatbots on (chatbots_id_fk = chatbots_id) inner join bot_messages on (bot_messages_id_fk = bot_messages_id) WHERE nodes_id = "+id);
			while (resultSet.next()) {
				Integer nodesId = resultSet.getInt("nodes_id");
				
				Integer chatbotsIdFK = resultSet.getInt("chatbots_id_fk");
				String initialMessage = resultSet.getString("initial_message");
				Integer usersIdFK = resultSet.getInt("users_id_fk");
				ChatBots chatBotsObj = new ChatBots(chatbotsIdFK,initialMessage,null);
				
				Integer botMessagesIdFK = resultSet.getInt("bot_messages_id_fk");
				String botMessages = resultSet.getString("bot_messages");
				BotMessages botMessagesObj = new BotMessages(botMessagesIdFK, botMessages);
				
				Integer sequence = resultSet.getInt("sequence");

				nodes.add(new Nodes(nodesId, chatBotsObj, botMessagesObj, sequence));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nodes;
	}
	
	public boolean insertNodes(Nodes node) {
	        Connection connection = ConnectionSingleton.getInstance();
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
	            preparedStatement.setInt(1, node.getNodesId());
	            preparedStatement.setInt(2, node.getChatbotsIdFK().getChatBotsId());
	            preparedStatement.setInt(3, node.getBotMessagesIdFK().getBotMessagesId());
	            preparedStatement.setInt(4, node.getSequence());
	            preparedStatement.execute();
	            return true;
	        }
	        catch (SQLException e) {
	            GestoreEccezioni.getInstance().gestisciEccezione(e);
	            return false;
	        }

	    }
	public boolean updateNodes(HttpServletRequest request) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			param=(String)request.getParameter("campo");
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE nodes SET "+param+" = (?) WHERE nodes_id = (?)");
            preparedStatement.setString(1, (String)request.getParameter("newData"));
            preparedStatement.setInt(2, Integer.parseInt(request.getParameter("idNodes")));
            preparedStatement.execute();
            return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}

	public boolean deleteNodes(int nodesId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, nodesId);
            preparedStatement.execute();
            return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}

}
