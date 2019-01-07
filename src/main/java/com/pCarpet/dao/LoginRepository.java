package com.pCarpet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.pCarpet.utils.ConnectionSingleton;
import com.pCarpet.utils.GestoreEccezioni;

public class LoginRepository {

	private final String QUERY_LOGIN = "select * from user where username = ? and password = ?";
	private final String QUERY_LOGIN_RUOLO = "select * from user where username = ? and password = ? and ruolo = ?";

	public boolean login(String username, String password) {

		final Connection connection = ConnectionSingleton.getInstance();
		try {
			final PreparedStatement statement = connection.prepareStatement(QUERY_LOGIN);
			statement.setString(1, username);
			statement.setString(2, password);
			return statement.executeQuery().next();

		} catch (final SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}

	public boolean login(String username, String password, String ruolo) {

		final Connection connection = ConnectionSingleton.getInstance();
		try {
			final PreparedStatement statement = connection.prepareStatement(QUERY_LOGIN_RUOLO);
			statement.setString(1, username);
			statement.setString(2, password);
			statement.setString(3, ruolo);
			return statement.executeQuery().next();
		} catch (final SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}
}
