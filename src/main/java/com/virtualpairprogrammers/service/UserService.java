package com.virtualpairprogrammers.service;

import com.virtualpairprogrammers.dao.UserDAO;
import com.virtualpairprogrammers.model.User;

import java.util.List;

public class UserService {
    private UserDAO userDAO;
    
    public UserService () {
        this.userDAO = new UserDAO();
    }
    
    public List<User> getAllUsers () {
        return this.userDAO.getAllUsers();
    }
    
    public List<User> getAllValidUsers () {
        return this.userDAO.getAllValidUsers();
    }
    
    public boolean insertUser (User user) {
        return this.userDAO.insertUser(user);
    }
    
    public boolean updateUser (User user) {
        return this.userDAO.updateUser(user);
    }
    
    public boolean softDeleteUser (User user) {
        return this.userDAO.softDeleteUser(user);
    }
    
    public boolean deleteUser (User user) {
        return this.userDAO.deleteUser(user);
    }
}
