package com.virtualpairprogrammers.service;

import com.virtualpairprogrammers.dao.UserDAO;
import com.virtualpairprogrammers.dao.UtenteDAO;
import com.virtualpairprogrammers.model.Utente;

public class LoginServicertt {

    private UserDAO userDAO;

    public LoginServicertt() {
        this.userDAO = new UserDAO();
    }

    public boolean login (String username, String password) {
        Utente utente = userDAO.getByNomeUtente(username);
        if(utente == null){
            return false;
        }else{
            if(utente.getPassword().equals(password)) return true;
            else return false;
        }

    }


}
