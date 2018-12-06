package main.view.users;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Users;
import main.view.View;
import main.controller.UsersController;

import java.util.List;
import java.util.Scanner;

public class UsersUpdateView implements View {

	private UsersController usersController;
	private Request request;

	public UsersUpdateView() {
		this.usersController = new UsersController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		List<Users> users;
		String username;
		String password;
		users = usersController.getAllUsers();
		System.out.println("----- Scegli Id per modificare -----");
		System.out.println();
		users.forEach(us_type -> System.out.println(us_type.toString()));
		System.out.println();
		System.out.println("username:");
		username = getInput();
		System.out.println("password:");
		password = getInput();
		if (!username.equals("") && !password.equals("")) {
			usersController.updateUsers(new Users(username, password, 0));
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
		MainDispatcher.getInstance().callAction("Users", "doControl", request);
	}

}
