package com.virtualpairprogrammers.service;

import com.virtualpairprogrammers.dao.BotMessagesDAO;
import com.virtualpairprogrammers.model.BotMessages;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class BotMessagesService {

    private BotMessagesDAO botMessagesDAO;

    public BotMessagesService() {
        this.botMessagesDAO = new BotMessagesDAO();
    }

    public List<BotMessages> getAllBotMessages () {
        return this.botMessagesDAO.getAllBotMessages();
    }
   
    public List<BotMessages> getBotMessages (int id) {
        return this.botMessagesDAO.getBotMessages(id);
    }
    
    public boolean insertBotMessages (BotMessages botMessages) {
        return this.botMessagesDAO.insertBotMessages(botMessages);
    }

    public boolean updateBotMessages (HttpServletRequest request) {
        return this.botMessagesDAO.updateBotMessages(request);
    }
    
    public boolean deleteBotMessages (int botMessagesId) {
        return this.botMessagesDAO.deleteBotMessages(botMessagesId);
    }

}


