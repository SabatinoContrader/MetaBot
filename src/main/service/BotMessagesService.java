package main.service;

import main.dao.BotMessagesDAO;
import main.model.BotMessages;
import main.model.UserTypes;

import java.util.List;

public class BotMessagesService {

    private BotMessagesDAO botMessagesDAO;

    public BotMessagesService() {
        this.botMessagesDAO = new BotMessagesDAO();
    }

    public List<BotMessages> getAllBotMessages () {
        return this.botMessagesDAO.getAllBotMessages();
    }
    
    public boolean insertBotMessages (BotMessages botMessages) {
        return this.botMessagesDAO.insertBotMessages(botMessages);
    }

    public boolean updateBotMessages (BotMessages botMessages) {
        return this.botMessagesDAO.updateBotMessages(botMessages);
    }
    
    public boolean deleteBotMessages (BotMessages botMessages) {
        return this.botMessagesDAO.deleteBotMessages(botMessages);
    }

}


