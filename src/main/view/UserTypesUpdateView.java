package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.model.UserTypes;
import main.dao.UserTypesDAO;
import main.controller.UserTypesController;

import java.util.List;
import java.util.Scanner;

public class UserTypesUpdateView implements View {

	private UserTypesController usertypesController;
	private Request request;
	
	public UserTypesUpdateView() {
		this.usertypesController = new UserTypesController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		List<UserTypes> usertypes;
		int idUserType;
		String typeUser;
		usertypes = usertypesController.getAllUserType();
		System.out.println("----- Scegli Id per modificare -----");
		System.out.println();
		usertypes.forEach(us_type -> System.out.println(us_type.toString()));
		System.out.println();
        System.out.println("user_type_id:");
        idUserType = Integer.parseInt(getInput());
        System.out.println("user_type:");
        typeUser = getInput();
        usertypesController.updateUserTypes(new UserTypes(idUserType, typeUser));			
	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("mode", "menu");
		request.put("choice", 0);
	    MainDispatcher.getInstance().callAction("UserTypes", "doControl", request);
	}

}
