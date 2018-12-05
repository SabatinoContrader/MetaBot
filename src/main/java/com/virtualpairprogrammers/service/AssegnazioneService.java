package com.virtualpairprogrammers.service;


import com.virtualpairprogrammers.dao.AssegnaDAO;
import com.virtualpairprogrammers.dao.UserDAO;
import com.virtualpairprogrammers.model.Assegnazione;
import com.virtualpairprogrammers.model.User;

import java.util.List;

public class AssegnazioneService {

	private UserDAO userDAO;
    //private UserAssetDAO userAssetDAO;
    private AssegnaDAO assegnaDAO;

    public AssegnazioneService() {
        this.assegnaDAO = new AssegnaDAO();
    }

    
    public List<Assegnazione> getAllAssegnazioni () {
        return this.assegnaDAO.getAllAssegnazioni();
    }
//    public List<User> getAllClienti () {
//        return this.userDAO.getAllClienti();
//    }
//    
//    public List<User> getAllClientiAss(){
//    	return this.userDAO.getAllClientiAss();
//    }
    public boolean assegnaBadge(Assegnazione assegnazione)
    {
    	return this.assegnaDAO.assegnaBadge(assegnazione);
    }
//    public boolean insertUser (User user) {
//        return this.userDAO.insertUser(user);
//    }
//    
    public boolean deleteAssegnazione(int iduser,int idbadge) {
    	return this.assegnaDAO.deleteAssegnazione(iduser, idbadge);
    }
//    
//    public List<User> getAllUsersN(){
//    	return this.userAssetDAO.getAllUsersN();
//    }
//    
//    public boolean updateUser(Request request) {
//    	return this.userDAO.udpateUser(request);
//    }
}


