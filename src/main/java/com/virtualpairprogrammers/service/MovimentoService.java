package com.virtualpairprogrammers.service;

//import main.dao.BadgereaderDAO;
import com.virtualpairprogrammers.dao.MovimentoDAO;
import com.virtualpairprogrammers.model.Movimento;

import java.util.List;

public class MovimentoService {

    private MovimentoDAO movimentoDAO;
	private Object badgeDAO;
	private Object badgereaderDAO;

    public MovimentoService() {
        this.movimentoDAO = new MovimentoDAO();
    }
//    public List<Badge> getAllBadges () {
//        return ((BadgeDAO) this.badgeDAO).getAllBadges();
//    }
    public List<Movimento> getAllMovimenti () {
        return this.movimentoDAO.getAllMovimenti();
    }
    public List<Movimento> getAllUserMovimenti (String iduser) {
        return this.movimentoDAO.getAllUserMovimenti(iduser);
    }
  /*  public List<BadgeReader> getAllBadgeReaders () {
        return (((BadgeReaderDAO) this.badgeReaderDAO).getBadgeReaders());
    }
*/
    public boolean insertMovimento (Movimento movimento) {
        return this.movimentoDAO.insertMovimento(movimento);
    }
    
    public boolean deleteMovimento (int idBadgeReader, int idBadge, String datainizio) {
        return this.movimentoDAO.deleteMovimento(idBadgeReader, idBadge, datainizio);
    }
}
