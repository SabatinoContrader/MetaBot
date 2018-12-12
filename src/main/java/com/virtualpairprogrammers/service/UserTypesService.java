package com.virtualpairprogrammers.service;

import com.virtualpairprogrammers.dao.UserTypesDAO;
import com.virtualpairprogrammers.model.UserTypes;

import java.util.List;

public class UserTypeService {
    private UserTypesDAO userTypeDAO;
    
    public UserTypeService () {
        this.userTypeDAO = new UserTypesDAO();
    }
    
    public List<UserTypes> getAllUserTypes () {
        return this.userTypeDAO.getAllUserTypes();
    }
    
    public List<UserTypes> getAllValidUserTypes () {
        return this.userTypeDAO.getAllValidUserTypes();
    }
    
    public boolean insertUserType (UserTypes user_type) {
        return this.userTypeDAO.insertUserType(user_type);
    }
    
    public boolean updateUserType (UserTypes user_type) {
        return this.userTypeDAO.updateUserType(user_type);
    }
    
    public boolean softDeleteUserType (UserTypes user_type) {
        return this.userTypeDAO.softDeleteUserType(user_type);
    }
    
    public boolean deleteUserType (UserTypes user_type) {
        return this.userTypeDAO.deleteUserType(user_type);
    }
}
