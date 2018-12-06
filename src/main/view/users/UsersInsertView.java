package main.view.users;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Users;
import main.view.View;
import main.controller.UsersController;

import java.util.Scanner;

public class UsersInsertView implements View {

	private UsersController usersController;
	private Request request;

	public UsersInsertView() {
		this.usersController = new UsersController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		Integer usersId;
		String username;
		String password;
		Integer userTypeFk;

		System.out.println("Inserisci i dati users:");
		System.out.println("id:");
		usersId = Integer.parseInt(getInput());
		System.out.println("username:");
		username = getInput();
		System.out.println("password:");
		password = getInput();
		System.out.println("user_type_fk:");
		userTypeFk = Integer.parseInt(getInput());
		if (usersId!= null &&!username.equals("") && !password.equals("") && userTypeFk != null) {
			usersController.insertUsers(new Users(usersId,username, password, userTypeFk));
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
