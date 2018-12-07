package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.controller.BotMessageOptionsController;

import java.util.Scanner;

public class BotMessageOptionsView implements View {

	private BotMessageOptionsController botMessageOptionsController;
	private Request request;
	private int choice;

	public BotMessageOptionsView() {
		this.botMessageOptionsController = new BotMessageOptionsController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		System.out.println("");
		System.out.println("");
		System.out.println("\n-------MENU BotMessageOptions-------\n");
		System.out.println("Scegli l'operazione da effettuare:");
		System.out.println("1) Visualizza BotMessageOptions");
		System.out.println("2) Inserisci BotMessageOptions");
		System.out.println("3) Modifica BotMessageOptions");
		System.out.println("4) Cancella BotMessageOptions");
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
		    MainDispatcher.getInstance().callAction("BotMessageOptions", "doControl", this.request);
	}
}
