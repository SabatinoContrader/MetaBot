package com.virtualpairprogrammers.dao;

import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;
import com.virtualpairprogrammers.model.BotMessageOptions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDAO {

	private final String QUERY_LOGIN = "select u.username, ut.user_types from users u inner join user_types ut where u.username = (?) and password = (?) and u.user_types_id_fk = ut.user_types_id";

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
				userType = resultSet.getString("user_types");
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
