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
				final Integer id_user_fk = resultSet.getInt("id_user_fk");
				final Integer id_nodo_root_fk = resultSet.getInt("id_nodo_root_fk");
				final String name_chat = resultSet.getString("name_chat");
				
				nodes.add(new Node(id, id_user_fk, id_nodo_root_fk, name_chat));
				}
		} catch (final SQLException e) {
	        e.printStackTrace();
}
return nodes;
}

}
