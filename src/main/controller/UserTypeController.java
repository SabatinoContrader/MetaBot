package main.controller;

import main.MainDispatcher;

public class UserTypeController implements Controller {

	public UserTypeController() {
    }
	
	  @Override
	    public void doControl(Request request) {
	        int choice = (int) request.get("choice");
	        switch (choice) {
	            case 1:
	                request.put("mode", "all");
	                break;
	        }
	        MainDispatcher.getInstance().callView("UserType", request);

	    }

}
