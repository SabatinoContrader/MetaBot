package com.virtualpairprogrammers.model;

import java.sql.Date;

public class UserType {
    
    private Integer userTypeID;
    private String  userTypeName;
    private Date    createdAt;
    private Date    updatedAt;
    private Date    deletedAt;
    
    public UserType (Integer userTypeID, String userTypeName, Date createdAt, Date updatedAt, Date deletedAt) {
        this.userTypeID = userTypeID;
        this.userTypeName = userTypeName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }
    
    public Integer getUserTypeID () {
        return userTypeID;
    }
    
    public void setUserTypeID (Integer userTypeID) {
        this.userTypeID = userTypeID;
    }
    
    public String getUserTypeName () {
        return userTypeName;
    }
    
    public void setUserTypeName (String userTypeName) {
        this.userTypeName = userTypeName;
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
        return "UserType [user_type_ID =" + userTypeID + ", user_type_name =" + userTypeName +
                "]\n\t[created_at =" + createdAt.toString () + ", updated_at=" + updatedAt.toString () + ", deleted_at =" + deletedAt.toString () + "]";
    }
    
    
}
