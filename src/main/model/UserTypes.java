package main.model;

public class UserTypes {

	private Integer userTypeId;
	private String userType;
	
	public UserTypes(Integer userTypeId, String userType) {
		this.userTypeId = userTypeId;
		this.userType = userType;
	}
	
	public Integer getUserTypeId() {
		return userTypeId;
	}
	public void setUserTypeId(Integer userTypeId) {
		this.userTypeId = userTypeId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	@Override
	public String toString() {
		return "UserTypes [userTypeId=" + userTypeId + ", userType=" + userType + "]";
	}

	
	
}
