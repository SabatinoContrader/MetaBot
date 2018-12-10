package main.view;

import main.MainDispatcher;
import main.controller.Request;

import java.util.Scanner;

public class HomeChatMasterView implements View {

	private int choice;

	public void showResults(Request request) {

	}

	public void showOptions() {
		System.out.println("\nBenvenuto in MetaBot\n\n");
		System.out.println("-------MENU-------");
		System.out.println("1) Gestione BotMssageOptions");
		System.out.println("2) Gestione BotMessages");
		System.out.println("3) Gestione Nodes");
		System.out.println("4) Gestione SubNodes");
		System.out.println("5) Logout");
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
			MainDispatcher.getInstance().callAction("BotMessageOptions", "doControl", request);
			break;

		case 2:
			MainDispatcher.getInstance().callAction("BotMessages", "doControl", request);
			break;

		case 3:
			MainDispatcher.getInstance().callAction("Nodes", "doControl", request);
			break;
			
		case 4:
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
