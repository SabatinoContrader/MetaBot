package com.virtualpairprogrammers.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;
import com.virtualpairprogrammers.model.Node;

public class NodeDAO {
    
    private final String QUERY_ALL         = "SELECT * FROM nodes";
    private final String QUERY_ALL_VALID   = "SELECT * FROM nodes WHERE deleted_at IS NULL";
    private final String QUERY_ONE         = "SELECT * from nodes WHERE node_ID =(?)";
    private final String QUERY_INSERT      = "INSERT INTO nodes (chatbot_FK, content, created_at, updated_at, deleted_at) VALUES (?,?,?,?,?)";
    private final String QUERY_UPDATE      = "UPDATE nodes SET chatbot_FK = (?), content =(?), updated_at =(?) WHERE node_ID = (?)";
    private final String QUERY_SOFT_DELETE = "UPDATE nodes SET deleted_at = (?)  WHERE node_ID = (?)";
    private final String QUERY_DELETE      = "DELETE FROM nodes WHERE node_ID = (?)";
    
    
    public List<Node> getAllNodes () {
        return getNodes(QUERY_ALL);
    }
    
    public List<Node> getAllValidNodes () {
        return getNodes(QUERY_ALL_VALID);
    }
    
    /*
     * QUESTO METODO VIENE INVOCATO DAI METODI QUI SOPRA, ESSENDO GLI STESSI DATI RICHIAMATI DA 2 QUERY
     * DIVERSE ALLORA HO CREATO 2 METODI CON NOMI DIVERSI CHE RICHIAMANO QUESTO METODO CAMBIANDO LA QUERY DESIDERATA
     * CON QUESTA METODOLOGIA EVITO DI SCRIVERE 2 VOLTE LO STESSO CODICE IN CUI CAMBIA SOLO LA QUERY DESIDERATA
     */
    private List<Node> getNodes (String select_query) {
        List<Node> nodes      = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(select_query);
            while (resultSet.next()) {
                Integer node_ID    = resultSet.getInt("node_ID");
                Integer chatbot_FK = resultSet.getInt("chatbot_FK");
                String  content    = resultSet.getString("content");
                Date    createdAT  = resultSet.getDate("created_at");
                Date    updatedAT  = resultSet.getDate("updated_at");
                Date    deletedAT  = resultSet.getDate("deleted_at");
                nodes.add(new Node(node_ID, chatbot_FK, content, createdAT, updatedAT, deletedAT));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nodes;
    }
    
    // INSERISCE UN NUOVO RECORD
    public boolean insertNode (Node node) {
        Connection connection       = ConnectionSingleton.getInstance();
        //int        inserted_primary = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setInt(1, node.getChatbotFK());
            preparedStatement.setString(2, node.getContent());
            preparedStatement.setDate(3, node.getCreatedAt());
            preparedStatement.setDate(4, node.getUpdatedAt());
            preparedStatement.setDate(5, node.getDeletedAt());
            //preparedStatement.execute();
            //inserted_primary = preparedStatement.getGeneratedKeys().getInt(1);
            return /*inserted_primary;*/ preparedStatement.execute();
            
        } catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return /*inserted_primary*/false;
        }
    }
    
    //MODIFICARE LA STRUTTURA DEI NODI.
    public boolean updateNode (Node node) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);
            preparedStatement.setInt(1, node.getChatbotFK());
            preparedStatement.setString(2, node.getContent());
            preparedStatement.setDate(3, node.getUpdatedAt());
            preparedStatement.setInt(4, node.getNodeID());
            return preparedStatement.execute();
        } catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
    }
    
    //ESEGUE UN SOFT DELETE DEL RECORD. OVVERO INSERISCE UNA DATA DELLA COLONNA DELETED_AT
    public boolean softDeleteNode (Node node) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_SOFT_DELETE);
            preparedStatement.setDate(1, node.getDeletedAt());
            preparedStatement.setInt(2, node.getNodeID());
            return preparedStatement.execute();
        } catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
    }
    
    //CANCELLA DEFINITIVAMENTE DAL DATABASE UN RECORD
    public boolean deleteNode (Node node) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
            preparedStatement.setInt(1, node.getNodeID());
            return preparedStatement.execute();
        } catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
    }
    
}
