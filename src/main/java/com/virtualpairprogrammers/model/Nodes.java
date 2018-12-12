package com.virtualpairprogrammers.model;

import java.sql.Date;

public class Nodes {
    
    private Integer nodeID;
    private Integer chatbotFK;
    private String content;
    private Date    createdAt;
    private Date    updatedAt;
    private Date    deletedAt;
    
    
    public Nodes (Integer nodeID, Integer chatbotFK, String content, Date createdAt, Date updatedAt, Date deletedAt) {
        this.nodeID = nodeID;
        this.chatbotFK = chatbotFK;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }
    
    public Integer getNodeID () {
        return nodeID;
    }
    
    public void setNodeID (Integer nodeID) {
        this.nodeID = nodeID;
    }
    
    public Integer getChatbotFK () {
        return chatbotFK;
    }
    
    public void setChatbotFK (Integer chatbotFK) {
        this.chatbotFK = chatbotFK;
    }
    
    public String getContent () {
        return content;
    }
    
    public void setContent (String content) {
        this.content = content;
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
        return "Node [node_ID =" + nodeID + ", chatbot_FK =" + chatbotFK + ", content =" + content
                + "]\n\t [created_at =" + createdAt.toString () + ", updated_at=" + updatedAt.toString () + ", deleted_at =" + deletedAt.toString () + "]";
    }
    
}
