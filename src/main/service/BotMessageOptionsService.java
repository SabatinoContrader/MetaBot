package main.service;

import main.dao.BotMessageOptionsDAO;
import main.model.BotMessageOptions;
import main.model.UserTypes;

import java.util.List;

public class BotMessageOptionsService {

    private BotMessageOptionsDAO botMessageOptionsDAO;

    public BotMessageOptionsService() {
        this.botMessageOptionsDAO = new BotMessageOptionsDAO();
    }

    public List<BotMessageOptions> getAllBotMessageOptions () {
        return this.botMessageOptionsDAO.getAllBotMessageOptions();
    }
    
    public boolean insertBotMessageOptions (BotMessageOptions botMessageOptions) {
        return this.botMessageOptionsDAO.insertBotMessageOptions(botMessageOptions);
    }
    
    public boolean updateBotMessageOptions (BotMessageOptions botMessageOptions) {
        return this.botMessageOptionsDAO.updateBotMessageOptions(botMessageOptions);
    }
    
    public boolean deleteBotMessageOptions (BotMessageOptions botMessageOptions) {
        return this.botMessageOptionsDAO.deleteBotMessageOptions(botMessageOptions);
    }

}


