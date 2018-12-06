package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.controller.UserTypesController;
import main.model.Users;
import main.controller.UsersController;

import java.util.List;
import java.util.Scanner;

public class UsersView implements View {

	private UsersController usersController;
	private Request request;
	private int choice;
	
	public UsersView() {
		this.usersController = new UsersController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		System.out.println("");
		System.out.println("");
		System.out.println("-------MENU User-------");
		System.out.println("Scegli l'operazione che vuoi fare:");
		System.out.println("1) Visualizza User");
		System.out.println("2) Inserire User");
		System.out.println("3) Modificare User");
		System.out.println("4) Cancellare User");
		System.out.println("5) Logout");
		try {
			this.choice = Integer.parseInt(getInput());
		} catch(Exception e) {
			this.choice = 0;
		}
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "");
	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	@Override
	public void submit() {
		    MainDispatcher.getInstance().callAction("Users", "doControl", this.request);
	}

}
