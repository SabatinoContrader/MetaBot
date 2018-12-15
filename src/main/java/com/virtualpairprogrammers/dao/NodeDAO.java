package com.virtualpairprogrammers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.virtualpairprogrammers.model.Node;
import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;

public class NodeDAO {
	
	private final String GET_ALL = "select * from node";
	
	public List<Node> getAllNode() {
		
		final List<Node> nodes = new ArrayList<>();
		final Connection connection = ConnectionSingleton.getInstance(); 
		
		try {
			final Statement statement = connection.createStatement();
			final ResultSet resultSet = statement.executeQuery(GET_ALL);
			while (resultSet.next()) {
				final Integer id = resultSet.getInt("id");
				final String text = resultSet.getString("text");
				final Integer idNodoPadre = resultSet.getInt("idNodoPadre");
				
				nodes.add(new Node(id, text, idNodoPadre));
				}
		} catch (final SQLException e) {
	        e.printStackTrace();
}
return nodes;
}

}
