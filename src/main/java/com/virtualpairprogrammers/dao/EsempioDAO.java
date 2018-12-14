package com.virtualpairprogrammers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.virtualpairprogrammers.model.Esempio;
import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;

public class EsempioDAO {

	/**
	 * Qui possiamo se vogliamo dichiarare delle stringhe rappresentanti le query che verranno utilizzate dai service,
	 * Non è obbligatorio ma è consigliato usare un ordine e dei nomi significativi per tutte le query.
	 * Con GET_ALL intendiamo recuperare tutte le tuple dal db.
	 * Se volessimo creare una query per l'inserimento, un nome identificativo potrebbe essere INSERT_ESEMPIO
	 */
	private final String GET_ALL = "select * from esempio";


	/**
	 * Il suddetto metodo si occupa interagire con il database e restituire tutte le tuple al servizio che ha chiamato questo metodo
	 */
	public List<Esempio> getAllEsempio() {

		final List<Esempio> esempi = new ArrayList<>();
		final Connection connection = ConnectionSingleton.getInstance();

		try {
			final Statement statement = connection.createStatement();
			final ResultSet resultSet = statement.executeQuery(GET_ALL);
			while (resultSet.next()) {
				final Integer colonna_id_esempio = resultSet.getInt("colonna_id_esempio");
				final String colonna2_esempio = resultSet.getString("colonna2_esempio");

				esempi.add(new Esempio(colonna_id_esempio, colonna2_esempio));
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return esempi;
	}

}
