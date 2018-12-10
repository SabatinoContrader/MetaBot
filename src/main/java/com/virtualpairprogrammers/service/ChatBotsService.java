package com.virtualpairprogrammers.service;

import com.virtualpairprogrammers.dao.ChatBotsDAO;
import com.virtualpairprogrammers.model.ChatBots;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class ChatBotsService {

    private ChatBotsDAO chatBotsDAO;

    public ChatBotsService() {
        this.chatBotsDAO = new ChatBotsDAO();
    }

    public List<ChatBots> getAllChatBots () {
        return this.chatBotsDAO.getAllChatBots();
    }
    
    public List<ChatBots> getChatBots (int id) {
        return this.chatBotsDAO.getChatBots(id);
    }
    
    public boolean insertChatBots (ChatBots chatBots) {
        return this.chatBotsDAO.insertChatBots(chatBots);
    }
    
    public boolean updateChatBots (HttpServletRequest request) {
        return this.chatBotsDAO.updateChatBots(request);
    }
    
    public boolean deleteChatBots (int usersId) {
        return this.chatBotsDAO.deleteChatBots(usersId);
    }

}


