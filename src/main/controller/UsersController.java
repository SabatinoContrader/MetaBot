package main.controller;

import java.util.List;

import main.MainDispatcher;
import main.model.Users;
import main.service.UsersService;

public class UsersController implements Controller {

	private static String sub_package = "users.";
	private UsersService usersService;
	private Request request;
	
	public UsersController() {
        this.usersService = new UsersService();
    }
	
	public List<Users> getAllUsers() {
		return this.usersService.getAllUsers();
	}
	    
	public boolean insertUsers (Users users) {
	    return this.usersService.insertUsers(users);
	}

    public boolean updateUsers (Users users) {
        return this.usersService.updateUsers(users);
    }
    
    public boolean deleteUsers (Users users) {
    	return this.usersService.deleteUsers(users);
    }
	    
	@Override
    public void doControl(Request request) {
        String mode = (String) request.get("mode");
        int choice = (int) request.get("choice");
   
        
        if(mode == "menu"){
        		MainDispatcher.getInstance().callView("Users", null);
        }else {
        switch (choice) {
		case 1:
			MainDispatcher.getInstance().callView(sub_package + "UsersRead", null);
			break;
		case 2:
			MainDispatcher.getInstance().callView(sub_package + "UsersInsert", null);
			break;
		case 3:
			MainDispatcher.getInstance().callView(sub_package + "UsersUpdate", null);
			break;
		case 4:
			MainDispatcher.getInstance().callView(sub_package + "UsersDelete", null);
			break;
		default:
        	MainDispatcher.getInstance().callView("Login", null);
			break;
        }}
    }


}
