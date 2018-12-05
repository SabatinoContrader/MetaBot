package com.virtualpairprogrammers.dao;

import com.virtualpairprogrammers.model.Utente;
import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;

import java.sql.*;
import java.util.List;

public class UtenteDAO {

    private final String QUERY_INSERT_UTENTE = "INSERT INTO utente\n" +
            "(username,\n" +
            "password,\n" +
            "nome,\n" +
            "cognome)\n" +
            "VALUES\n" +
            "(?,\n" +
            "?,\n" +
            "?,\n" +
            "?);\n";

    private  final  String QUERY_UPDATE_UTENTE = "UPDATE utente\n" +
            "SET\n" +
            "username = ?,\n" +
            "password = ?,\n" +
            "nome = ?,\n" +
            "cognome = ?\n" +
            "WHERE id = ?;\n";

    private final String QUERY_GET_UTENTE = "SELECT * FROM utente WHERE id = ?";

    private final String QUERY_GET_UTENTE_BY_USERNAME = "SELECT * FROM utente WHERE username = ?";

    public Utente get(int id){
        Connection connection = ConnectionSingleton.getInstance();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_GET_UTENTE);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Utente utente = new Utente();
            utente.setId(id);
            if (resultSet.next()) {
                utente.setNome(resultSet.getString("nome"));
                utente.setCognome(resultSet.getString("cognome"));
                utente.setNomeUtente(resultSet.getString("username"));
                utente.setPassword(resultSet.getString("password"));
                preparedStatement.close();
                return utente;
            }
        }catch (Exception e){
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            System.out.println("Errore nella ricerca dell' utente");
            return null;
        }
        return null;
    }

    public Utente getByNomeUtente(String nomeUtente){
        Connection connection = ConnectionSingleton.getInstance();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_GET_UTENTE_BY_USERNAME);
            preparedStatement.setString(1, nomeUtente);
            ResultSet resultSet = preparedStatement.executeQuery();
            Utente utente = new Utente();
            if (resultSet.next()) {
                utente.setId(resultSet.getInt("id"));
                utente.setNomeUtente(resultSet.getString("username"));
                utente.setPassword(resultSet.getString("password"));
                utente.setNome(resultSet.getString("nome"));
                utente.setCognome(resultSet.getString("cognome"));
                preparedStatement.close();
                return utente;
            }
        }catch (Exception e){
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            System.out.println("Errore nella ricerca dell' utente");
            return null;
        }
        return null;
    }

    public List<Utente> getAll(){
        return null;
    }

    public int insert(Utente utente){
        Connection connection = ConnectionSingleton.getInstance();
        int id = -1;
        try {
            String generatedColumns[] = { "id" };
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT_UTENTE, generatedColumns);
            preparedStatement.setString(1,utente.getNomeUtente());
            preparedStatement.setString(2,utente.getPassword());
            preparedStatement.setString(3,utente.getNome());
            preparedStatement.setString(4,utente.getCognome());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                id = resultSet.getInt(1);
            }
            preparedStatement.close();

        } catch (Exception e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return -1;
        }

        return id;
    }

    public int update(Utente utente){
        return -1;
    }

    public int delete(int id){
        return -1;
    }
}
