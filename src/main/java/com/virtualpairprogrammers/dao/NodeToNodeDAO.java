package com.virtualpairprogrammers.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.http.HttpServletRequest;

import com.mysql.fabric.xmlrpc.base.Data;
import com.virtualpairprogrammers.model.ChatBots;
import com.virtualpairprogrammers.model.NodeToNode;
import com.virtualpairprogrammers.model.Nodes;
import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;

public class NodeToNodeDAO {


	String param = "";

	private final String QUERY_ALL = "SELECT * FROM node_to_node ";
	private final String QUERY_INSERT = "insert into node_to_node (first_node_ID, second_node_ID) values (?,?)";
	private final String QUERY_DELETE = "DELETE FROM node_to_node WHERE first_node_ID and second_node_IS = (?,?)";
	

	
	// Visualizzazione 
	
	public List<NodeToNode> getAllNodeToNode() {

		final List<NodeToNode> nodetonode = new ArrayList<>();
		final Connection connection = ConnectionSingleton.getInstance();

		try {
			final Statement statement = connection.createStatement();
			final ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			while (resultSet.next()) {
				final Integer firstNodeID = resultSet.getInt("first_node_ID");
				final Integer secondNodeID = resultSet.getInt("second_node_ID");
				
				
				nodetonode.add(new NodeToNode(firstNodeID,secondNodeID,null,null,null));
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return nodetonode;
	}

	 // INSERISCE UN NUOVO RECORD
	
    public boolean insertNodeToNode (NodeToNode nodetonode) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setInt(1, nodetonode.getFirstNodeId());
            preparedStatement.setInt(2, nodetonode.getSecondNodeId());
           
      
            return preparedStatement.execute();
        } catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
        
    }
    
 
    
    //CANCELLA DEFINITIVAMENTE DAL DATABASE UN RECORD
    
    public boolean deleteNodeToNode (NodeToNode nodetonode) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
            preparedStatement.setInt(1, nodetonode.getFirstNodeId());
            preparedStatement.setInt(2, nodetonode.getSecondNodeId());
            return preparedStatement.execute();
        } catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
    }
    
}
