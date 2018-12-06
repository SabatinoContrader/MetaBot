package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.model.UserTypes;
import main.dao.UserTypesDAO;
import main.controller.UserTypesController;

import java.util.List;
import java.util.Scanner;

public class UserTypesInsertView implements View {

	private UserTypesController usertypesController;
	private Request request;

	public UserTypesInsertView() {
		this.usertypesController = new UserTypesController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		int idUserType;
		String typeUser;
        
        System.out.println("Inserisci i dati user_types:");
        System.out.println("user_type_id:");
        idUserType = Integer.parseInt(getInput());
        System.out.println("user_type:");
        typeUser = getInput();
        usertypesController.insertUserTypes(new UserTypes(idUserType, typeUser));
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
