package com.virtualpairprogrammers.service;

import com.virtualpairprogrammers.dao.UserTypeDAO;
import com.virtualpairprogrammers.model.UserType;

import java.util.List;

public class UserTypeService {
    private UserTypeDAO userTypeDAO;
    
    public UserTypeService () {
        this.userTypeDAO = new UserTypeDAO();
    }
    
    public List<UserType> getAllUserTypes () {
        return this.userTypeDAO.getAllUserTypes();
    }
    
    public List<UserType> getAllValidUserTypes () {
        return this.userTypeDAO.getAllValidUserTypes();
    }
    
    public boolean insertUserType (UserType user_type) {
        return this.userTypeDAO.insertUserType(user_type);
    }
    
    public boolean updateUserType (UserType user_type) {
        return this.userTypeDAO.updateUserType(user_type);
    }
    
    public boolean softDeleteUserType (UserType user_type) {
        return this.userTypeDAO.softDeleteUserType(user_type);
    }
    
    public boolean deleteUserType (UserType user_type) {
        return this.userTypeDAO.deleteUserType(user_type);
    }
}
