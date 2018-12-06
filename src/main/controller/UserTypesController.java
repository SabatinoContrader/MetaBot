package main.controller;

import java.util.List;

import main.MainDispatcher;
import main.model.UserTypes;
import main.service.UserTypesService;

public class UserTypesController implements Controller {

	private UserTypesService userTypesService;
	private Request request;
	
	public UserTypesController() {
        this.userTypesService = new UserTypesService();
    }
	
	public List<UserTypes> getAllUserType() {
		return this.userTypesService.getAllUserType();
	}
	    
	public boolean insertUserTypes (UserTypes userTypes) {
	    return this.userTypesService.insertUserTypes(userTypes);
	}

    public boolean updateUserTypes (UserTypes userTypes) {
        return this.userTypesService.updateUserTypes(userTypes);
    }
    
    public boolean deleteUserTypes (UserTypes userTypes) {
    	return this.userTypesService.deleteUserTypes(userTypes);
    }
	    
	@Override
    public void doControl(Request request) {
        String mode = (String) request.get("mode");
        int choice = (int) request.get("choice");
   
        
        if(mode == "menu"){
        		MainDispatcher.getInstance().callView("UserTypes", null);
        }else {
        switch (choice) {
		case 1:
			MainDispatcher.getInstance().callView("UserTypesRead", null);
			break;
		case 2:
			MainDispatcher.getInstance().callView("UserTypesInsert", null);
			break;
		case 3:
			MainDispatcher.getInstance().callView("UserTypesUpdate", null);
			break;
		case 4:
			MainDispatcher.getInstance().callView("UserTypesDelete", null);
			break;
		default:
        	MainDispatcher.getInstance().callView("Login", null);
			break;
        }}
    }

}
