package main.service;

import main.dao.UserTypesDAO;
import main.model.UserTypes;

import java.util.List;

public class UserTypesService {

    private UserTypesDAO userTypesDAO;

    public UserTypesService() {
        this.userTypesDAO = new UserTypesDAO();
    }

    public List<UserTypes> getAllUserType () {
        return this.userTypesDAO.getAllUserTypes();
    }
    
    public boolean insertUserTypes (UserTypes userTypes) {
        return this.userTypesDAO.insertUserTypes(userTypes);
    }

    public boolean updateUserTypes (UserTypes userTypes) {
        return this.userTypesDAO.updateUserTypes(userTypes);
    }
    
    public boolean deleteUserTypes (UserTypes userTypes) {
        return this.userTypesDAO.deleteUserTypes(userTypes);
    }
}


