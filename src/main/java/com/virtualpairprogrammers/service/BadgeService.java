package com.virtualpairprogrammers.service;

import com.virtualpairprogrammers.dao.BadgeDAO;
import com.virtualpairprogrammers.model.Badge;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public class BadgeService {
	 private BadgeDAO badgeDAO;

	    public BadgeService() {
	        this.badgeDAO = new BadgeDAO();
	    }

	    public List<Badge> getAllBadges () {
	        return this.badgeDAO.getAllBadges();
	    }
	    
	    public Badge getBadge (int id) {
	        return this.badgeDAO.getBadge(id);
	    }

	    public boolean insertBadge (Badge badge) {
	        return this.badgeDAO.insertBadge(badge);
	    }
	    public boolean deleteBadge (int idBadge) {
	    	return this.badgeDAO.DeleteBadge(idBadge);
	    }
	    
	    public boolean updateBadge(HttpServletRequest request) {
	    	return this.badgeDAO.UpdateBadge(request);
	    }
	}




