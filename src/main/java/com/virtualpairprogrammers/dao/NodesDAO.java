package com.virtualpairprogrammers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.virtualpairprogrammers.model.Nodes;
import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;

public class NodesDAO {
	
	private final String GET_ALL = "select * from nodes";
	private final String QUERY_INSERT 	= "INSERT INTO nodes (id, text, idNodoPadre) values (?,?,?)";
	private final String QUERY_DELETE 	= "DELETE FROM nodes WHERE id = (?)";
	private final String QUERY_UPDATE  = "UPDATE Chatbots SET id_user_fk, id_nodo_root_fk, name_chat =(?,?,?) WHERE id = (?)";;
	
	public List<Nodes> getAllNode() {
		
		final List<Nodes> nodes = new ArrayList<>();
		final Connection connection = ConnectionSingleton.getInstance(); 
		
		try {
			final Statement statement = connection.createStatement();
			final ResultSet resultSet = statement.executeQuery(GET_ALL);
			while (resultSet.next()) {
				final Integer id = resultSet.getInt("id");
				final String text = resultSet.getString("text");
				final Integer idNodoPadre = resultSet.getInt("idNodoPadre");
				
				nodes.add(new Nodes(id, text, idNodoPadre));
				}
		} catch (final SQLException e) {
	        e.printStackTrace();
}
return nodes;
}

}
