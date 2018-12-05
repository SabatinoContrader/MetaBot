package main.model;

/**
 * 
 * @author Radek
 *
 */
public class UserType {
	// colonna idUserType della tabella UserType
	private Integer idUserType;
	// colonna typeUser della tabella UserType
	private String typeUser;
	
	 public UserType(Integer id, String type) {
	        this.idUserType = id;
	        this.typeUser = type;
	  }
	 
	public Integer getIdUserType() {
		return idUserType;
	}
	public void setIdUserType(Integer idUserType) {
		this.idUserType = idUserType;
	}
	public String getTypeUser() {
		return typeUser;
	}
	public void setTypeUser(String typeUser) {
		this.typeUser = typeUser;
	}
}
