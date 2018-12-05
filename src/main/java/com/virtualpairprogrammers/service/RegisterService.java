package com.virtualpairprogrammers.service;

import com.virtualpairprogrammers.dao.UtenteDAO;
import com.virtualpairprogrammers.model.Utente;

public class RegisterService {

    private UtenteDAO utenteDAO;

    public RegisterService() {
        this.utenteDAO = new UtenteDAO();
    }

    public int insert(Utente utente) {
         return this.utenteDAO.insert(utente);

    }

}
