package com.virtualpairprogrammers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.virtualpairprogrammers.model.ChatBots;
import com.virtualpairprogrammers.model.Nodes;
import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;

public class NodesDAO {

	String param = "";

	private final String QUERY_ALL = "SELECT * FROM nodes inner join chatbots on (chatbots_id_fk = chatbots_id) inner join bot_messages on (bot_messages_id_fk = bot_messages_id)";
	private final String QUERY_INSERT = "insert into nodes (nodes_id, chatbots_id_fk, bot_messages_id_fk, sequence) values (?,?,?,?)";
	private final String QUERY_DELETE = "DELETE FROM nodes WHERE nodes_id = (?)";

	public List<Nodes> getAllNodes() {

		final List<Nodes> nodes = new ArrayList<>();
		final Connection connection = ConnectionSingleton.getInstance();

		try {
			final Statement statement = connection.createStatement();
			final ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			while (resultSet.next()) {
				final Integer nodesId = resultSet.getInt("nodes_id");

				final Integer chatbotsIdFK = resultSet.getInt("chatbots_id_fk");
				final String initialMessage = resultSet.getString("initial_message");
				final Integer usersIdFK = resultSet.getInt("users_id_fk");
				final ChatBots chatBotsObj = new ChatBots(chatbotsIdFK, initialMessage, null);

				final Integer botMessagesIdFK = resultSet.getInt("bot_messages_id_fk");
				final String botMessages = resultSet.getString("bot_messages");

				final Integer sequence = resultSet.getInt("sequence");

				nodes.add(new Nodes(nodesId, chatBotsObj, sequence));
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return nodes;
	}

	public List<Nodes> getNodes(int id) {

		final List<Nodes> nodes = new ArrayList<>();
		final Connection connection = ConnectionSingleton.getInstance();

		try {
			final Statement statement = connection.createStatement();
			final ResultSet resultSet = statement.executeQuery(
					"SELECT * FROM nodes inner join chatbots on (chatbots_id_fk = chatbots_id) inner join bot_messages on (bot_messages_id_fk = bot_messages_id) WHERE nodes_id = "
							+ id);
			while (resultSet.next()) {
				final Integer nodesId = resultSet.getInt("nodes_id");

				final Integer chatbotsIdFK = resultSet.getInt("chatbots_id_fk");
				final String initialMessage = resultSet.getString("initial_message");
				final Integer usersIdFK = resultSet.getInt("users_id_fk");
				final ChatBots chatBotsObj = new ChatBots(chatbotsIdFK, initialMessage, null);

				final Integer botMessagesIdFK = resultSet.getInt("bot_messages_id_fk");
				final String botMessages = resultSet.getString("bot_messages");

				final Integer sequence = resultSet.getInt("sequence");

				nodes.add(new Nodes(nodesId, chatBotsObj, sequence));
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return nodes;
	}

	public boolean insertNodes(Nodes node) {
		final Connection connection = ConnectionSingleton.getInstance();
		try {
			final PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setInt(1, node.getNodesId());
			preparedStatement.setInt(2, node.getChatbotsIdFK().getChatBotsId());
			preparedStatement.setInt(4, node.getSequence());
			preparedStatement.execute();
			return true;
		} catch (final SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}

	public boolean updateNodes(HttpServletRequest request) {
		final Connection connection = ConnectionSingleton.getInstance();
		try {
			param = request.getParameter("campo");
			final PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE nodes SET " + param + " = (?) WHERE nodes_id = (?)");
			preparedStatement.setString(1, request.getParameter("newData"));
			preparedStatement.setInt(2, Integer.parseInt(request.getParameter("idNodes")));
			preparedStatement.execute();
			return true;
		} catch (final SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}

	public boolean deleteNodes(int nodesId) {
		final Connection connection = ConnectionSingleton.getInstance();
		try {
			final PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, nodesId);
			preparedStatement.execute();
			return true;
		} catch (final SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}

}
