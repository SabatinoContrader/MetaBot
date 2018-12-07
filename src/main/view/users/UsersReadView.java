package main.view.users;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Users;
import main.view.View;
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
		users.forEach(user -> System.out.println(user.toString()));
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
