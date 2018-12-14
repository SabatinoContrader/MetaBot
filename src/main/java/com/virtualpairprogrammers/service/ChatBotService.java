package com.virtualpairprogrammers.service;

import com.virtualpairprogrammers.dao.ChatBotDAO;
import com.virtualpairprogrammers.model.ChatBot;

import java.util.List;

public class ChatBotService {
    private ChatBotDAO chatbotDAO;
    
    public ChatBotService () {
        this.chatbotDAO = new ChatBotDAO();
    }
    
    public List<ChatBot> getAllChatBot(){
        return this.chatbotDAO.getAllChatBot();
    }
    
    public List<ChatBot> getChatBot(int id){
        return this.chatbotDAO.getChatBot(id);
    }
    
    public boolean insertChatBot(ChatBot chat_bot){
        return this.chatbotDAO.insertChatBot(chat_bot);
    }
    public boolean updateChatBot(ChatBot chat_bot){
        return this.chatbotDAO.updateChatBot(chat_bot);
    }
    public boolean deleteChatBot(ChatBot chat_bot){
        return this.chatbotDAO.deleteChatBot(chat_bot);
    }
}
