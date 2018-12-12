package com.virtualpairprogrammers.model;

import java.sql.Date;

public class Users {
    
    private Integer userID;
    private String  username;
    private String  password;
    private String  email;
    private Integer userRoleFk;
    private Date    createdAt;
    private Date    updatedAt;
    private Date    deletedAt;
    
    public Users (Integer userID, String username, String password, String email, Integer userRoleFk, Date createdAt, Date updatedAt, Date deletedAt) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.email = email;
        this.userRoleFk = userRoleFk;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }
    
    public Integer getUserID () {
        return userID;
    }
    
    public void setUserID (Integer userID) {
        this.userID = userID;
    }
    
    public String getUsername () {
        return username;
    }
    
    public void setUsername (String username) {
        this.username = username;
    }
    
    public String getPassword () {
        return password;
    }
    
    public void setPassword (String password) {
        this.password = password;
    }
    
    public String getEmail () {
        return email;
    }
    
    public void setEmail (String email) {
        this.email = email;
    }
    
    public Integer getUserRoleFk () {
        return userRoleFk;
    }
    
    public void setUserRoleFk (Integer userRoleFk) {
        this.userRoleFk = userRoleFk;
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
        return "User [user_ID =" + userID + ", username =" + username + ", password =" + password + ", email =" + email + ", user_role_FK =" + userRoleFk
                + "]\n\t [created_at =" + createdAt.toString () + ", updated_at=" + updatedAt.toString () + ", deleted_at =" + deletedAt.toString () + "]";
    }
    
}
