package main.view.usertypes;

import main.MainDispatcher;
import main.controller.Request;
import main.model.UserTypes;
import main.view.View;
import main.dao.UserTypesDAO;
import main.controller.UserTypesController;

import java.util.List;
import java.util.Scanner;

public class UserTypesDeleteView implements View {

	private UserTypesController usertypesController;
	private Request request;

	public UserTypesDeleteView() {
		this.usertypesController = new UserTypesController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		List<UserTypes> usertypes;
		Integer idUserType;

		usertypes = usertypesController.getAllUserType();
		System.out.println("\n----- Seleziona l'elemento da cancellare dalla lista elencata-----\n");
		usertypes.forEach(us_type -> System.out.println(us_type.toString()));
		System.out.println("user_type_id: \n");
		idUserType = Integer.parseInt(getInput());
		if (idUserType != null)
			usertypesController.deleteUserTypes(new UserTypes(idUserType, ""));
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
