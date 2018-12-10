package com.virtualpairprogrammers.service;

import com.virtualpairprogrammers.dao.UserTypesDAO;
import com.virtualpairprogrammers.model.UserTypes;
import javax.servlet.http.HttpServletRequest;

import java.util.List;

public class UserTypesService {

    private UserTypesDAO userTypesDAO;

    public UserTypesService() {
        this.userTypesDAO = new UserTypesDAO();
    }

    public List<UserTypes> getAllUserTypes () {
        return this.userTypesDAO.getAllUserTypes();
    }
    
    public List<UserTypes> getUserTypes (int id) {
        return this.userTypesDAO.getUserTypes(id);
    }
    
    public boolean insertUserTypes (UserTypes userTypes) {
        return this.userTypesDAO.insertUserTypes(userTypes);
    }

    public boolean updateUserTypes (HttpServletRequest request) {
        return this.userTypesDAO.updateUserTypes(request);
    }
    
    public boolean deleteUserTypes (int userTypeId) {
        return this.userTypesDAO.deleteUserTypes(userTypeId);
    }
}


