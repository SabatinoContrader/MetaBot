package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.model.ChatBots;
import main.controller.ChatBotsController;

import java.util.List;
import java.util.Scanner;

public class ChatBotsView implements View {

	private ChatBotsController chatBotsController;
	private Request request;
	private int choice;

	public ChatBotsView() {
		this.chatBotsController = new ChatBotsController();
	}

	@Override
	public void showResults(Request request) {
	}
	
	@Override
	public void showOptions() {
		System.out.println("\n----- MENU Chatbots-----\n");
		System.out.println("Scegli l'operazione da effettuare:");
		System.out.println("1) Visualizza tutte le ChatBots");
		System.out.println("2) Inserisci una ChatBot");
		System.out.println("3) Modifica una ChatBot");
		System.out.println("4) Cancella una ChatBot");
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
		    MainDispatcher.getInstance().callAction("ChatBots", "doControl", this.request);
	}

}
