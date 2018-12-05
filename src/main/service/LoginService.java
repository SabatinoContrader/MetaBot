package main.service;

import main.dao.LoginDAO;

public class LoginService {

    private LoginDAO loginDAO;

    public LoginService() {
        this.loginDAO = new LoginDAO();
    }

    public boolean login (String username, String password) {
        return this.loginDAO.login(username, password);
    }
}
