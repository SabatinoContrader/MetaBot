package com.virtualpairprogrammers.model;

import java.sql.Date;

public class User {
    
    private Integer userID;
    private String  username;
    private String  password;
    private String  firstName;
    private String  lastName;
    private String  email;
    private Integer userTypeFK;
    private Date    createdAt;
    private Date    updatedAt;
    private Date    deletedAt;
    
    public User (Integer userID, String username, String firstName, String lastName ,String password, String email, Integer userTypeFK, Date createdAt, Date updatedAt, Date deletedAt) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userTypeFK = userTypeFK;
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
    
    public String getFirstName () {
        return firstName;
    }
    
    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName () {
        return lastName;
    }
    
    public void setLastName (String lastName) {
        this.lastName = lastName;
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
    
    public Integer getUserTypeFK () {
        return userTypeFK;
    }
    
    public void setUserTypeFK (Integer userTypeFK) {
        this.userTypeFK = userTypeFK;
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
        return "User [user_ID =" + userID + ", username =" + username + ", first_name =" + firstName +", last_name =" + lastName +", password =" + password + ", email =" + email + ", user_role_FK =" + userTypeFK
                + "]\n\t [created_at =" + createdAt.toString () + ", updated_at=" + updatedAt.toString () + ", deleted_at =" + deletedAt.toString () + "]";
    }
    
}
