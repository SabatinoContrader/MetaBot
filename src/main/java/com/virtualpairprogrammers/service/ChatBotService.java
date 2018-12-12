package com.virtualpairprogrammers.service;

import com.virtualpairprogrammers.dao.ChatBotDAO;
import com.virtualpairprogrammers.model.ChatBot;

import java.util.List;

public class ChatBotService {
    private ChatBotDAO chatbotDAO;
    
    public ChatBotService () {
        this.chatbotDAO = new ChatBotDAO();
    }
    
    public List<ChatBot> getAllChatBots(){
        return this.chatbotDAO.getAllChatBots();
    }
    public List<ChatBot> getAllValidChatBots(){
        return this.chatbotDAO.getAllValidChatBots();
    }
    public boolean insertChatBot(ChatBot chat_bot){
        return this.chatbotDAO.insertChatBot(chat_bot);
    }
    public boolean updateChatBot(ChatBot chat_bot){
        return this.chatbotDAO.updateChatBot(chat_bot);
    }
    public boolean softDeleteChatBot(ChatBot chat_bot){
        return this.chatbotDAO.softDeleteChatBot(chat_bot);
    }
    public boolean deleteChatBot(ChatBot chat_bot){
        return this.chatbotDAO.deleteChatBot(chat_bot);
    }
}
