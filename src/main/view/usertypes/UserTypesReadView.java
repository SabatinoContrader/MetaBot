package main.view.usertypes;

import main.MainDispatcher;
import main.controller.Request;
import main.model.UserTypes;
import main.view.View;
import main.controller.UserTypesController;

import java.util.List;
import java.util.Scanner;

public class UserTypesReadView implements View {

	private UserTypesController usertypesController;
	private Request request;
	
	public UserTypesReadView() {
		this.usertypesController = new UserTypesController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		List<UserTypes> usertypes = usertypesController.getAllUserType();
		System.out.println();
		usertypes.forEach(us_type -> System.out.println(us_type.toString()));
		System.out.println();
		
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
