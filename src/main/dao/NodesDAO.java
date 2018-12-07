package main.dao;

import java.sql.SQLException;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class NodesDAO {

	private final String QUERY_ALL = "";
	private final String QUERY_INSERT = "";
	private final String QUERY_UPDATE = "update nodes set sequence = (?) where nodes_id = (?)";
	private final String QUERY_DELETE = "DELETE FROM nodes WHERE nodes_id = (?)";

	
	
	public boolean updateNodes(Integer sequence, Integer nodesId) {
		Connection connection = ConnectionSingleton.getInstance();
    	try {
    		PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);
    		preparedStatement.setInt(1, sequence);
    		preparedStatement.setInt(2, nodesId);
    		return preparedStatement.execute();
    	}
    	catch (SQLException e) {
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
