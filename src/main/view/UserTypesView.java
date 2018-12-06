package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.controller.UserTypesController;

import java.util.Scanner;

public class UserTypesView implements View {

	private UserTypesController usertypesController;
	private Request request;
	private int choice;
	
	public UserTypesView() {
		this.usertypesController = new UserTypesController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		System.out.println("");
		System.out.println("");
		System.out.println("-------MENU UserTypes-------");
		System.out.println("Scegli l'operazione che vuoi fare:");
		System.out.println("1) Visualizza UserTypes");
		System.out.println("2) Inserire UserTypes");
		System.out.println("3) Modificare UserTypes");
		System.out.println("4) Cancellare UserTypes");
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
		    MainDispatcher.getInstance().callAction("UserTypes", "doControl", this.request);
	}

}
