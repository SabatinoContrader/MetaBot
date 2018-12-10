package com.virtualpairprogrammers.model;

public class UserTypes {

	private Integer userTypesId;
	private String userTypes;
	
	public UserTypes(Integer userTypesId, String userTypes) {
		this.userTypesId = userTypesId;
		this.userTypes = userTypes;
	}
	
	public Integer getUserTypesId() {
		return userTypesId;
	}
	public void setUserTypesId(Integer userTypesId) {
		this.userTypesId = userTypesId;
	}
	public String getUserTypes() {
		return userTypes;
	}
	public void setUserTypes(String userTypes) {
		this.userTypes = userTypes;
	}
	@Override
	public String toString() {
		return "UserTypes [userTypesId=" + userTypesId + ", userTypes=" + userTypes + "]";
	}

	
	
}
