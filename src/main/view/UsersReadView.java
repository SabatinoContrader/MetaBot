package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Users;
import main.controller.UsersController;

import java.util.List;
import java.util.Scanner;

public class UsersReadView implements View {

	private UsersController usersController;
	private Request request;
	
	public UsersReadView() {
		this.usersController = new UsersController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		List<Users> users = usersController.getAllUsers();
		System.out.println("----- Gli users nel tuo database sono -----");
		System.out.println();
		users.forEach(us_type -> System.out.println(us_type.toString()));
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
	    MainDispatcher.getInstance().callAction("Users", "doControl", request);
	}

}
