package main.service;

import main.dao.UsersDAO;
import main.model.UserTypes;
import main.model.Users;

import java.util.List;

public class UsersService {

    private UsersDAO usersDAO;

    public UsersService() {
        this.usersDAO = new UsersDAO();
    }

    public List<Users> getAllUsers () {
        return this.usersDAO.getAllUsers();
    }
    
    public boolean insertUsers (Users user) {
        return this.usersDAO.insertUsers(user);
    }

    public boolean updateUsers (Users users) {
        return this.usersDAO.updateUsers(users);
    }
    
    public boolean deleteUsers (Users users) {
        return this.usersDAO.deleteUsers(users);
    }
}


