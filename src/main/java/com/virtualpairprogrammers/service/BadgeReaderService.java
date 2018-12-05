package com.virtualpairprogrammers.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import com.virtualpairprogrammers.dao.BadgeReaderDAO;
import com.virtualpairprogrammers.model.BadgeReader;

public class BadgeReaderService {

	private BadgeReaderDAO badgeReaderDAO;

    public BadgeReaderService() {
        this.badgeReaderDAO = new BadgeReaderDAO();
    }

    public List<BadgeReader> getAllBadgeReaders () {
        return this.badgeReaderDAO.getAllBadgeReaders();
    }
    
    public List<BadgeReader> getAllBadgeReadersIdAsset (int idAsset) {
        return this.badgeReaderDAO.getAllBadgeReadersIdAsset(idAsset);
    }
    
    public List<BadgeReader> getBadgeReader (int id) {
        return this.badgeReaderDAO.getBadgeReader(id);
    }

    public boolean insertBadgeReader (BadgeReader badgeReader) {
        return this.badgeReaderDAO.insertBadgeReader(badgeReader);
    }
    public boolean deleteBadgeReadear (int idBadgeReader) {
    	return this.badgeReaderDAO.deleteBadgeReadear(idBadgeReader);
    }
    
    public boolean updateBadgeReader(HttpServletRequest request) {
    	return this.badgeReaderDAO.updateBadgeReader(request);
    }
	
}
