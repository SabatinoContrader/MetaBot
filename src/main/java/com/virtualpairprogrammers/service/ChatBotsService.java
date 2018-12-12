package com.virtualpairprogrammers.service;

import com.virtualpairprogrammers.dao.ChatBotsDAO;
import com.virtualpairprogrammers.model.ChatBots;

import java.util.List;

public class ChatBotsService {
    private ChatBotsDAO chatbotDAO;
    
    public ChatBotsService () {
        this.chatbotsDAO = new ChatBotsDAO();
    }
    
    public List<ChatBots> getAllChatBots(){
        return this.chatbotsDAO.getAllChatBots();
    }
    public List<ChatBots> getAllValidChatBots(){
        return this.chatbotsDAO.getAllValidChatBots();
    }
    public boolean insertChatBot(ChatBots chat_bot){
        return this.chatbotsDAO.insertChatBot(chat_bot);
    }
    public boolean updateChatBot(ChatBots chat_bot){
        return this.chatbotsDAO.updateChatBot(chat_bot);
    }
    public boolean softDeleteChatBot(ChatBots chat_bot){
        return this.chatbotsDAO.softDeleteChatBot(chat_bot);
    }
    public boolean deleteChatBot(ChatBots chat_bot){
        return this.chatbotsDAO.deleteChatBot(chat_bot);
    }
}
