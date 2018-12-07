package main.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.ChatBots;
import main.model.Nodes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class NodesDAO {

	private final String QUERY_ALL = "select * from nodes";
	private final String QUERY_INSERT = "insert into nodes (nodes_id, chatbots_id_fk, users_id_fk,bot_messages_id_fk, sequence) values (?,?,?,?,?)";
	private final String QUERY_UPDATE = "update nodes set sequence = (?) where nodes_id = (?)";
	private final String QUERY_DELETE = "DELETE FROM nodes WHERE nodes_id = (?)";

	// ritorna tutti i nodi presenti
	public List<Nodes> getAllNodes() {
		
		List<Nodes> nodes = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			while (resultSet.next()) {
				Integer nodesId = resultSet.getInt("nodes_id");
				Integer chatbotsIdFK = resultSet.getInt("chatbots_id_fk");
				Integer usersIdFK = resultSet.getInt("users_id_fk");
				Integer botMessagesIdFK = resultSet.getInt("bot_messages_id_fk");
				Integer sequence = resultSet.getInt("sequence");

				nodes.add(new Nodes(nodesId, chatbotsIdFK, usersIdFK, botMessagesIdFK, sequence));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nodes;
	}

	// Inserisce un nodo
	public boolean insertNodes(Nodes node) {
	        Connection connection = ConnectionSingleton.getInstance();
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
	            preparedStatement.setInt(1, node.getNodesId());
	            preparedStatement.setInt(2, node.getChatbotsIdFK());
	            preparedStatement.setInt(3, node.getUsersIdFK());
	            preparedStatement.setInt(4, node.getBotMessagesIdFK());
	            preparedStatement.setInt(5, node.getSequence());

	            return preparedStatement.execute();
	        }
	        catch (SQLException e) {
	            GestoreEccezioni.getInstance().gestisciEccezione(e);
	            return false;
	        }

	    }

	// aggiorna una sequenza di un certo nodo
	public boolean updateNodes(Integer nodesId, Integer sequence) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);
			preparedStatement.setInt(1, sequence);
			preparedStatement.setInt(2, nodesId);
			return preparedStatement.execute();
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}

	// cancella un nodo
	public boolean deleteNodes(Integer nodesId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, nodesId);
			return preparedStatement.execute();

		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}

}
