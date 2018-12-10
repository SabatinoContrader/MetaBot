package com.virtualpairprogrammers.service;

import com.virtualpairprogrammers.dao.UsersDAO;
import com.virtualpairprogrammers.model.Users;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class UsersService {

    private UsersDAO usersDAO;

    public UsersService() {
        this.usersDAO = new UsersDAO();
    }

    public List<Users> getAllUsers () {
        return this.usersDAO.getAllUsers();
    }
 
    public List<Users> getAllUsers (int id) {
        return this.usersDAO.getAllUsers(id);
    }
    
    public boolean insertUsers (Users user) {
        return this.usersDAO.insertUsers(user);
    }

    public boolean updateUsers (HttpServletRequest request) {
        return this.usersDAO.updateUsers(request);
    }
    
    public boolean deleteUsers (int usersId) {
        return this.usersDAO.deleteUsers(usersId);
    }
}


