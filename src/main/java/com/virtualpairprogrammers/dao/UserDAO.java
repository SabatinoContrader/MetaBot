package com.virtualpairprogrammers.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;
import com.virtualpairprogrammers.model.User;

public class UserDAO {

	private final String GET_ALL_NOT_DELETED = "SELECT * FROM users WHERE deleted_at IS NULL";
	private final String GET_USER_BY_USERNAME_AND_PASSWORD = "SELECT * FROM users WHERE  username = (?) and password = (?)";
	private final String GET_USER_BY_ID = "select * from users where user_ID = (?)";
	private final String INSERT = "INSERT INTO users (user_ID,username, password, first_name, last_name, email, user_type_FK) VALUES (?,?,?,?,?,?,?)";
	private final String PERMANENT__DELETE = "DELETE FROM users WHERE user_ID = (?)";

	/**
	 * Recupera un User passando un id
	 * 
	 * @param id
	 */
	public User getUserById(Integer id) {
		User user = null;
		Connection connection = ConnectionSingleton.getInstance();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_ID);
			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				String firstName = resultSet.getString("first_name");
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				String lastName = resultSet.getString("last_name");
				String email = resultSet.getString("email");
				Integer userTypeFK = resultSet.getInt("user_type_FK");
				user = new User(id, username, firstName, lastName, password, email, userTypeFK, null, null, null);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	/**
	 * Dato un username e una password recuperiamo L'utente desiderato
	 * 
	 * @param username
	 * @param password
	 */
	public User getUserByUsernameAndPassword(String username, String password) {
		User user = null;
		Connection connection = ConnectionSingleton.getInstance();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_USERNAME_AND_PASSWORD);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				Integer userID = resultSet.getInt("user_ID");
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				String email = resultSet.getString("email");
				Integer userTypeFK = resultSet.getInt("user_type_FK");
				user = new User(userID, username, firstName, lastName, password, email, userTypeFK, null, null, null);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	/**
	 * Recupera tutti gli utenti, esclusi quelli con il campo data deleted_at not
	 * null, ossia gli utenti anche validi all'interno dell'applicazione
	 * 
	 * @return
	 */
	public List<User> getAllUsers() {

		Connection connection = ConnectionSingleton.getInstance();
		List<User> users = new ArrayList<>();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(GET_ALL_NOT_DELETED);

			while (resultSet.next()) {
				Integer userID = resultSet.getInt("user_ID");
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				String email = resultSet.getString("email");
				Integer userTypeFK = resultSet.getInt("user_type_FK");
				users.add(
						new User(userID, username, password, firstName, lastName, email, userTypeFK, null, null, null));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	/**
	 * Inserisce un User nel database
	 * 
	 * @param user
	 * @return
	 */
	public boolean insertUser(User user) {

		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
			preparedStatement.setInt(1, 0);
			preparedStatement.setString(2, user.getUsername());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setString(4, user.getFirstName());
			preparedStatement.setString(5, user.getLastName());
			preparedStatement.setString(6, user.getEmail());
			preparedStatement.setInt(7, user.getUserTypeFK());
			return preparedStatement.execute();

		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
		}
		return false;
	}

	/**
	 * Modifica un campo di una tupla Users passando un id
	 * 
	 * @param campo
	 * @param idUser
	 */
	public boolean updateUser(Integer idUser, String campo, String valore) {
		Connection connection = ConnectionSingleton.getInstance();

		try {

			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE users SET " + campo + " = (?) WHERE user_ID = (?)");
			preparedStatement.setString(1, valore);
			preparedStatement.setInt(2, idUser);
			return preparedStatement.execute();
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
		}
		return false;
	}

	/**
	 * Elimina in modo permanente un User dal database
	 * 
	 * @param idUser
	 */
	public boolean deleteUser(Integer idUser) {
		Connection connection = ConnectionSingleton.getInstance();
		try {

			PreparedStatement preparedStatement;
			preparedStatement = connection.prepareStatement(PERMANENT__DELETE);
			preparedStatement.setInt(1, idUser);
			return preparedStatement.execute();
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}

}
