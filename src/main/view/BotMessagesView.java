package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.model.BotMessages;
import main.controller.BotMessagesController;

import java.util.List;
import java.util.Scanner;

public class BotMessagesView implements View {

	private BotMessagesController botMessagesController;
	private Request request;
	private int choice;

	public BotMessagesView() {
		this.botMessagesController = new BotMessagesController();
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
		System.out.println("1) Visualizza BotMessages");
		System.out.println("2) Inserire BotMessages");
		System.out.println("3) Modificare BotMessages");
		System.out.println("4) Cancellare BotMessages");
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
