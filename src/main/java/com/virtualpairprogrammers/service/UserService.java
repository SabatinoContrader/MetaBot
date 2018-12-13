package com.virtualpairprogrammers.service;

import com.virtualpairprogrammers.dao.UserDAO;
import com.virtualpairprogrammers.model.User;

import java.util.List;

public class UserService {

	private UserDAO userDAO;

	public UserService() {
		this.userDAO = new UserDAO();
	}

	public List<User> getAllUsers() {
		return this.userDAO.getAllUsers();
	}

	public User getUserById(Integer idUser) {
		return userDAO.getUserById(idUser);
	}

	public User getUserByUsernameAndPassword(String username, String password) {
		return userDAO.getUserByUsernameAndPassword(username, password);
	}

	public boolean insertUser(User user) {
		return userDAO.insertUser(user);
	}

	public boolean updateUser(Integer idUser, String campo, String valore) {
		return userDAO.updateUser(idUser, campo, valore);
	}
	
	public boolean deleteUser(Integer idUser) {
		return userDAO.deleteUser(idUser);
	}
}
