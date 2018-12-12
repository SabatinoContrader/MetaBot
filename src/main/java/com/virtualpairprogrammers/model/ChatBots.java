package com.virtualpairprogrammers.model;

import java.sql.Date;

public class ChatBots {
    
    private Integer chatbotID;
    private Integer ownerFK;
    private Integer enterPoint;
    private Integer endPoint;
    private String  name;
    private String  welcome;
    private Date    createdAt;
    private Date    updatedAt;
    private Date    deletedAt;
    
    public ChatBots (Integer chatbotID, Integer ownerFK, Integer enterPoint, Integer endPoint, String name, String welcome, Date createdAt, Date updatedAt, Date deletedAt) {
        this.chatbotID = chatbotID;
        this.ownerFK = ownerFK;
        this.enterPoint = enterPoint;
        this.endPoint = endPoint;
        this.name = name;
        this.welcome = welcome;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }
    
    public Integer getChatBotID () {
        return chatbotID;
    }
    
    public void setChatBotID (Integer chatbotID) {
        this.chatbotID = chatbotID;
    }
    
    public Integer getOwnerFK () {
        return ownerFK;
    }
    
    public void setOwnerFK (Integer ownerFK) {
        this.ownerFK = ownerFK;
    }
    
    public Integer getEnterPoint () {
        return enterPoint;
    }
    
    public void setEnterPoint (Integer enterPoint) {
        this.enterPoint = enterPoint;
    }
    
    public Integer getEndPoint () {
        return endPoint;
    }
    
    public void setEndPoint (Integer endPoint) {
        this.endPoint = endPoint;
    }
    
    public String getName () {
        return name;
    }
    
    public void setName (String name) {
        this.name = name;
    }
    
    public String getWelcome () {
        return welcome;
    }
    
    public void setWelcome (String welcome) {
        this.welcome = welcome;
    }
    
    public Date getCreatedAt () {
        return createdAt;
    }
    
    public void setCreatedAt (Date createdAt) {
        this.createdAt = createdAt;
    }
    
    public Date getUpdatedAt () {
        return updatedAt;
    }
    
    public void setUpdatedAt (Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    public Date getDeletedAt () {
        return deletedAt;
    }
    
    public void setDeletedAt (Date deletedAt) {
        this.deletedAt = deletedAt;
    }
    
    @Override
    public String toString () {
        return "ChatBot [chatbot_ID =" + chatbotPK + ", owner_FK =" + ownerFK + ", name =" + name + ", welcome =" + welcome +
                "]\n\t[enter_node =" + enterPoint + ", end_node =" + endPoint +
                "]\n\t[created_at =" + createdAt.toString () + ", updated_at=" + updatedAt.toString () + ", deleted_at =" + deletedAt.toString () + "]";
    }
    
}
