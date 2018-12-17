package com.virtualpairprogrammers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.virtualpairprogrammers.model.Chatbots;
import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;

public class ChatbotsDAO {

	/**
	 * Qui possiamo se vogliamo dichiarare delle stringhe rappresentanti le query che verranno utilizzate dai service,
	 * Non è obbligatorio ma è consigliato usare un ordine e dei nomi significativi per tutte le query.
	 * Con GET_ALL intendiamo recuperare tutte le tuple dal db.
	 * Se volessimo creare una query per l'inserimento, un nome identificativo potrebbe essere INSERT_ESEMPIO
	 */
	private final String GET_ALL = "select * from Chatbots";
	private final String GET_ALL_BY_USER = "SELECT * Chatbots WHERE id_user_fk = (?)";
	private final String QUERY_INSERT 	= "INSERT INTO Chatbots (id, id_user_fk, id_nodo_root_fk, name_chat) values (?,?,?,?)";
	private final String QUERY_DELETE 	= "DELETE FROM Chatbots WHERE id = (?)";
	private final String QUERY_UPDATE   = "UPDATE Chatbots SET id_user_fk, id_nodo_root_fk, name_chat =(?,?,?) WHERE id = (?)";
	
	/**
	 * Il suddetto metodo si occupa interagire con il database e restituire tutte le tuple al servizio che ha chiamato questo metodo
	 */
	public List<Chatbots> getAllChatbots() {

		final List<Chatbots> chatbots = new ArrayList<>();
		final Connection connection = ConnectionSingleton.getInstance();

		try {
			final Statement statement = connection.createStatement();
			final ResultSet resultSet = statement.executeQuery(GET_ALL);
			while (resultSet.next()) {
				final Integer id = resultSet.getInt("id");
				final Integer id_user_fk = resultSet.getInt("id_user_fk");
				final Integer id_nodo_root_fk = resultSet.getInt("id_nodo_root_fk");
				final String name_chat = resultSet.getString("name_chat");

				chatbots.add(new Chatbots(id, id_user_fk, id_nodo_root_fk,name_chat));
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return chatbots;
	}
	
	// Inserimento
	
	public boolean insertChatbots (Chatbots chatbots) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setInt(1, chatbots.getId());
            preparedStatement.setInt(2, chatbots.getIdUserFk());
            preparedStatement.setInt(3, chatbots.getIdNodoRootFk());
            preparedStatement.setString(4, chatbots.getNameChat());
            return true;
        } catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
	}
	
	// 
	public List <Chatbots> getAllChatbotsByUserID (Integer id) {
	final List <Chatbots>  chatbots = new ArrayList<>();
    final Connection  connection = ConnectionSingleton.getInstance();   
    final PreparedStatement preparedStatement;
	
    try {
    	preparedStatement = connection.prepareStatement(GET_ALL_BY_USER);
    	preparedStatement.setInt(1, id);
    	ResultSet resultSet = preparedStatement.executeQuery();
    	while ( resultSet.next()) {
    		chatbots.add(
    			     new Chatbots (
    			    	 resultSet.getInt("id"),
    			    	 resultSet.getInt("id_user_fk"),
    			    	 resultSet.getInt("id_nodo_root_fk"),
    			    	 resultSet.getString("name_chat")
    			    	 ));
    			                  
    		             }
                                	
      }catch (SQLException e)  {
    	e.printStackTrace();
    }
      return chatbots ;
    } 
    
     // cancella una chat
        public boolean deleteChatbots (Chatbots chatbots) {
            Connection connection = ConnectionSingleton.getInstance();
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
                preparedStatement.setInt(1, chatbots.getId());
                preparedStatement.execute();
                return true;
            } catch (SQLException e) {
                GestoreEccezioni.getInstance().gestisciEccezione(e);
                return false;
            }
        }
	
	
     // Modifica Chat
        
        public boolean updateChatbots (Chatbots chatbots) {
            Connection connection = ConnectionSingleton.getInstance();
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);
                preparedStatement.setInt(1, chatbots.getIdUserFk());
                preparedStatement.setInt(2, chatbots.getIdNodoRootFk());
                preparedStatement.setString(3, chatbots.getNameChat());
                preparedStatement.execute();
                return true;
            } catch (SQLException e) {
            	
                GestoreEccezioni.getInstance().gestisciEccezione(e);
                return false;
            }
	
        }
	}
