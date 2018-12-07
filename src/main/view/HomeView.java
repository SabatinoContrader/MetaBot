package main.view;

import main.MainDispatcher;
import main.controller.Request;

import java.util.Scanner;

public class HomeView implements View {

	private int choice;

	public void showResults(Request request) {

	}

	public void showOptions() {
		System.out.println("\nBenvenuto in MetaBot\n\n");
		System.out.println("-------MENU-------");
		System.out.println("1) Gestione UserTypes");
		System.out.println("2) Gestione Users");
		System.out.println("3) Gestione BotMssageOptions");
		System.out.println("4) Gestione BotMessages");
		System.out.println("5) Gestione ChatBots");
		System.out.println("6) Gestione Nodes");
		System.out.println("7) Gestione SubNodes");
		System.out.println("8) Logout");
		try {
			this.choice = Integer.parseInt(getInput());
		} catch(Exception e) {
			this.choice = 0;
		}
	}

	public void submit() {
		Request request = new Request();
		request.put("mode", "menu");
		request.put("choice", choice);
		switch (choice) {
		case 1:
			MainDispatcher.getInstance().callAction("UserTypes", "doControl", request);
			
		case 2:
			MainDispatcher.getInstance().callAction("Users", "doControl", request);
			break;

		case 3:
			MainDispatcher.getInstance().callAction("BotMessageOptions", "doControl", request);
			break;

		case 4:
			MainDispatcher.getInstance().callAction("BotMessages", "doControl", request);
			break;

		case 5:
			MainDispatcher.getInstance().callAction("ChatBots", "doControl", request);
			break;

		case 6:
			MainDispatcher.getInstance().callAction("Nodes", "doControl", request);
			break;
		
		case 7:
			MainDispatcher.getInstance().callAction("SubNodes", "doControl", request);
			break;
			
		default:
			MainDispatcher.getInstance().callAction("Login", "doControl", null);
			break;
		}
	}

	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

}
