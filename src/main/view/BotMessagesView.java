package main.view;

import main.MainDispatcher;
import main.controller.Request;
import java.util.Scanner;

public class BotMessagesView implements View {

	private Request request;
	private int choice;

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		System.out.println("\n----- MENU BotMessages -----\n");
		System.out.println("Scegli l'operazione da effettuare:");
		System.out.println("1) Visualizza tutti i BotMessages");
		System.out.println("2) Inserisci un BotMessage");
		System.out.println("3) Modifica un BotMessage");
		System.out.println("4) Cancella un BotMessage");
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
		    MainDispatcher.getInstance().callAction("BotMessages", "doControl", this.request);
	}

}
