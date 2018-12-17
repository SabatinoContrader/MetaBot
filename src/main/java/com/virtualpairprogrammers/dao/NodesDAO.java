package com.virtualpairprogrammers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.virtualpairprogrammers.model.Chatbots;
import com.virtualpairprogrammers.model.Nodes;
import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;

public class NodesDAO {
	
	private final String GET_ALL = "select * from nodes";
	private final String QUERY_INSERT 	= "INSERT INTO nodes (id, text, idNodoPadre) values (?,?,?)";
	private final String QUERY_DELETE 	= "DELETE FROM nodes WHERE id = (?)";
	private final String QUERY_UPDATE  = "UPDATE nodes SET text , id_nodo_padre =(?,?) WHERE id = (?)";
	
	public List<Nodes> getAllNodes() {
		
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

		public boolean insertNodes (Nodes nodes) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setInt(1, nodes.getId());
            preparedStatement.setString(2, nodes.getText());
            preparedStatement.setInt(3, nodes.getIdNodoPadre());
           
            return true;
            }  catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
           
            return false;
}

		}
        
		public boolean deleteNodes (Integer Id) {
            Connection connection = ConnectionSingleton.getInstance();
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
                preparedStatement.setInt(1, Id);
                preparedStatement.execute();
                return true;
            } catch (SQLException e) {
                GestoreEccezioni.getInstance().gestisciEccezione(e);
                return false;
            }
        }
        
        public boolean updateNode (Nodes nodes) {
            Connection connection = ConnectionSingleton.getInstance();
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);
                preparedStatement.setString(1, nodes.getText());
                preparedStatement.setInt(2, nodes.getIdNodoPadre());
                preparedStatement.setInt(3, nodes.getId());
                preparedStatement.execute();
                return true;
            } catch (SQLException e) {
            	
                GestoreEccezioni.getInstance().gestisciEccezione(e);
                return false;
            }
	
        }
        
}
        