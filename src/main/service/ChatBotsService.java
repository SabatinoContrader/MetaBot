package main.service;

import main.dao.ChatBotsDAO;
import main.model.ChatBots;

import java.util.List;

public class ChatBotsService {

    private ChatBotsDAO chatBotsDAO;

    public ChatBotsService() {
        this.chatBotsDAO = new ChatBotsDAO();
    }

    public List<ChatBots> getAllUserType () {
        return this.chatBotsDAO.getAllChatBots();
    }
    
    public boolean insertChatBots (ChatBots chatBots) {
        return this.chatBotsDAO.insertChatBots(chatBots);
    }
    
    public boolean updateChatBots (ChatBots chatBots) {
        return this.chatBotsDAO.updateChatBots(chatBots);
    }
    
    public boolean deleteChatBots (ChatBots chatBots) {
        return this.chatBotsDAO.deleteChatBots(chatBots);
    }

}


