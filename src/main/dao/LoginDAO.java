package main.dao;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.BotMessageOptions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDAO {

	private final String QUERY_LOGIN = "select u.username, ut.user_type from users u inner join user_types ut where u.username = (?) and password = (?) and u.user_type_fk = ut.user_type_id";

	public String login(String username, String password) {

		String userName = "";
		String userType = "";
		String loginUser = "";

		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement statement = connection.prepareStatement(QUERY_LOGIN);
			statement.setString(1, username);
			statement.setString(2, password);
			statement.execute();
			ResultSet resultSet = statement.getResultSet();

			while (resultSet.next()) {
				userName = resultSet.getString("username");
				userType = resultSet.getString("user_type");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (!userName.equals("") || !userType.equals("")) {
			loginUser = userName + ":" + userType;
		}
		return loginUser;
	}
}
