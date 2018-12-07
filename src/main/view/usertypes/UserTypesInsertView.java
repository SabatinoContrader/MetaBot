package main.view.usertypes;

import main.MainDispatcher;
import main.controller.Request;
import main.model.UserTypes;
import main.view.View;
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
		Integer idUserType;
		String typeUser;

		System.out.println("\nInserisci i campi degli UserTypes: ");
		System.out.println("Digita l'ID user_type: ");
		idUserType = Integer.parseInt(getInput());
		System.out.println("Digita user_type: ");
		typeUser = getInput();
		if (idUserType != null && !typeUser.equals("")) {
			usertypesController.insertUserTypes(new UserTypes(idUserType, typeUser));
		}
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
