package main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.SubNodes;

public class SubNodesDAO {
	private final String QUERY_ALL = "select * from sub_nodes";
	private final String QUERY_INSERT = "insert into sub_nodes (id_sub_nodes, id_bot_message_options_fk,sequence,id_nodes_fk) values (?,?,?,?)";
	private final String QUERY_UPDATE = "UPDATE sub_nodes SET sequence = (?) WHERE id_sub_nodes = (?)"; 
	private final String QUERY_DELETE = "DELETE FROM sub_nodes WHERE id_sub_nodes = (?)"; 

	public List<SubNodes> getAllSubNodes () {
        List<SubNodes> subNodes = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(QUERY_ALL);
           while (resultSet.next()) {
               Integer idSubNodes = resultSet.getInt("id_sub_nodes");
        	   Integer isBotMessageOptionFk = resultSet.getInt("id_bot_message_options_fk");
        	   Integer sequence = resultSet.getInt("sequence");
        	   Integer idNodesFk = resultSet.getInt("id_nodes_fk");

               
        	   subNodes.add(new SubNodes(idSubNodes, isBotMessageOptionFk,sequence,idNodesFk));
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return subNodes;
    }
	
    public boolean insertSubNodes(SubNodes subNodes) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setInt(1, subNodes.getIdSubNodes());
            preparedStatement.setInt(2, subNodes.getIsBotMessageOptionFk());
            preparedStatement.setInt(3, subNodes.getSequence());
            preparedStatement.setInt(4, subNodes.getIdNodesFk());


            return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }
    
    public boolean updateSubNodes(SubNodes subNodes) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);
            preparedStatement.setInt(1, subNodes.getSequence());
            
            return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
}
    
    public boolean deleteSubNodes(SubNodes subNodes) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
        	PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
            preparedStatement.setInt(1, subNodes.getIdSubNodes());
            return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
    }

}
