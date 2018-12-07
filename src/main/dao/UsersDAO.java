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
import main.model.Users;

public class UsersDAO {
	private final String QUERY_ALL = "select * from users";
	private final String QUERY_INSERT = "insert into users (users_id,username, password, user_types_id_fk) values (?,?,?,?)";
	private final String QUERY_UPDATE = "UPDATE users SET password = (?) WHERE users_id = (?)";
	private final String QUERY_DELETE = "DELETE FROM users WHERE users_id = (?)";

	public List<Users> getAllUsers() {
		List<Users> users = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			while (resultSet.next()) {
				Integer id = resultSet.getInt("users_id");
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				Integer userTypeFk = resultSet.getInt("user_types_id_fk");

				users.add(new Users(id, username, password, userTypeFk));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	public boolean insertUsers(Users users) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);

			preparedStatement.setInt(1, users.getUsersId());
			preparedStatement.setString(2, users.getUsername());
			preparedStatement.setString(3, users.getPassword());
			preparedStatement.setInt(4, users.getUserTypeFk());

			return preparedStatement.execute();
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}

	public boolean updateUsers(Users users) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);
			preparedStatement.setString(1, users.getPassword());
			preparedStatement.setInt(2, users.getUsersId());
			return preparedStatement.execute();
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}

	public boolean deleteUsers(Integer usersId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, usersId);
			return preparedStatement.execute();
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}

}
