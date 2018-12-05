package main.service;

import main.dao.UserTypeDAO;
import main.model.UserType;

import java.util.List;

public class UserTypeService {

    private UserTypeDAO userTypeDAO;

    public UserTypeService() {
        this.userTypeDAO = new UserTypeDAO();
    }

    public List<UserType> getAllUserType () {
        return this.userTypeDAO.getAllUserType();
    }

}


