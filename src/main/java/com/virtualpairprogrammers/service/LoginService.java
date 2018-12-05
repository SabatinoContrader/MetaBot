package com.virtualpairprogrammers.service;



import com.virtualpairprogrammers.dao.LoginDAO;

public class LoginService {

    private LoginDAO loginDAO;

    public LoginService() {
        this.loginDAO = new LoginDAO();
    }

    public boolean login (String username, String password) {
        return this.loginDAO.login(username, password);
    }
    
    public boolean login (String username, String password, String ruolo) {
        return this.loginDAO.login(username, password, ruolo);
    }
}