package com.virtualpairprogrammers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;
import com.virtualpairprogrammers.model.Users;
import com.virtualpairprogrammers.model.UserTypes;

public class UsersDAO {
	String param="";
	
	private final String QUERY_ALL = "select * from users inner join user_types on user_types_id_fk = user_types_id";
	private final String QUERY_INSERT = "insert into users (users_id,username, password, user_types_id_fk) values (?,?,?,?)";
	private final String QUERY_DELETE = "DELETE FROM users WHERE users_id = (?)";

	public List<Users> getAllUsers() {
		List<Users> users = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			while (resultSet.next()) {
				Integer usersId = resultSet.getInt("users_id");
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				Integer userTypesID = resultSet.getInt("user_types_id");
				String userTypes= resultSet.getString("user_types");
				UserTypes userTypesObj = new UserTypes(userTypesID,userTypes);
				users.add(new Users(usersId, username, password, userTypesObj));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	public List<Users> getAllUsers(int id) {
		List<Users> users = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
	           Statement statement = connection.createStatement();
	           ResultSet resultSet = statement.executeQuery("select * from users inner join user_types on user_types_id_fk = user_types_id WHERE users_id = "+id);
			while (resultSet.next()) {
				Integer usersId = resultSet.getInt("users_id");
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				Integer userTypesID = resultSet.getInt("user_types_id");
				String userTypes= resultSet.getString("user_types");
				UserTypes userTypesObj = new UserTypes(userTypesID,userTypes);
				users.add(new Users(usersId, username, password, userTypesObj));
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
			preparedStatement.setInt(4, users.getUserTypeFk().getUserTypesId());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}

	public boolean updateUsers(HttpServletRequest request) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			param=(String)request.getParameter("campo");
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users SET "+param+" = (?) WHERE users_id = (?)");
            preparedStatement.setString(1, (String)request.getParameter("newData"));
            preparedStatement.setInt(2, Integer.parseInt(request.getParameter("idUsers")));
            preparedStatement.execute();
            return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}

	public boolean deleteUsers(int usersId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, usersId);
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}

}
