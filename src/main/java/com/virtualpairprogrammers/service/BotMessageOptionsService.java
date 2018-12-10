package com.virtualpairprogrammers.service;

import com.virtualpairprogrammers.dao.BotMessageOptionsDAO;
import com.virtualpairprogrammers.model.BotMessageOptions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class BotMessageOptionsService {

    private BotMessageOptionsDAO botMessageOptionsDAO;

    public BotMessageOptionsService() {
        this.botMessageOptionsDAO = new BotMessageOptionsDAO();
    }

    public List<BotMessageOptions> getAllBotMessageOptions () {
        return this.botMessageOptionsDAO.getAllBotMessageOptions();
    }
  
    public List<BotMessageOptions> getBotMessageOptions (int id) {
        return this.botMessageOptionsDAO.getBotMessageOptions(id);
    }
    
    public boolean insertBotMessageOptions (BotMessageOptions botMessageOptions) {
        return this.botMessageOptionsDAO.insertBotMessageOptions(botMessageOptions);
    }
    
    public boolean updateBotMessageOptions (HttpServletRequest request) {
        return this.botMessageOptionsDAO.updateBotMessageOptions(request);
    }
    
    public boolean deleteBotMessageOptions (int botMessagesId) {
        return this.botMessageOptionsDAO.deleteBotMessageOptions(botMessagesId);
    }

}


