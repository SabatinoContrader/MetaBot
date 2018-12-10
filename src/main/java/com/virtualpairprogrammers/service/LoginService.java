package com.virtualpairprogrammers.service;

import com.virtualpairprogrammers.dao.LoginDAO;

public class LoginService {

    private LoginDAO loginDAO;

    public LoginService() {
        this.loginDAO = new LoginDAO();
    }

    public String login (String username, String password) {
        return this.loginDAO.login(username, password);
    }
}
