package com.virtualpairprogrammers.service;

import com.virtualpairprogrammers.dao.UsersDAO;
import com.virtualpairprogrammers.model.Users;

import java.util.List;

public class UsersService {
    private UsersDAO userDAO;
    
    public UsersService () {
        this.userDAO = new UsersDAO();
    }
    
    public List<Users> getAllUsers () {
        return this.userDAO.getAllUsers();
    }
    
    public List<Users> getAllValidUsers () {
        return this.userDAO.getAllValidUsers();
    }
    
    public boolean insertUser (Users user) {
        return this.userDAO.insertUser(user);
    }
    
    public boolean updateUser (Users user) {
        return this.userDAO.updateUser(user);
    }
    
    public boolean softDeleteUser (Users user) {
        return this.userDAO.softDeleteUser(user);
    }
    
    public boolean deleteUser (Users user) {
        return this.userDAO.deleteUser(user);
    }
}
