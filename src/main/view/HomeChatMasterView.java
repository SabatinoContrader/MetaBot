package main.view;

import main.MainDispatcher;
import main.controller.Request;
import sun.applet.Main;

import java.util.Scanner;

public class HomeChatMasterView implements View {

	private int choice;

	public void showResults(Request request) {

	}

	public void showOptions() {
		System.out.println("Benvenuto in ContraderFramework");
		System.out.println("");
		System.out.println("");
		System.out.println("-------MENU-------");
		System.out.println("Scegli quali entità vuoi visualizzare:");
		System.out.println("1) CRUD BotMssageOptions");
		System.out.println("2) CRUD BotMessages");
		System.out.println("3) CRUD ChatBots");
		System.out.println("4) Logout");
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
			MainDispatcher.getInstance().callAction("ChatBots", "doControl", request);
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
