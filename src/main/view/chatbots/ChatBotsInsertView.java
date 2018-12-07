package main.view.chatbots;

import main.MainDispatcher;
import main.controller.Request;
import main.model.ChatBots;
import main.view.View;
import main.controller.ChatBotsController;

import java.util.Scanner;

public class ChatBotsInsertView implements View {

	private ChatBotsController chatBotsController;
	private Request request;

	public ChatBotsInsertView() {
		this.chatBotsController = new ChatBotsController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		Integer chatbotId;
		String initialMessage;
		String userFk;

		System.out.println("\n Inserisci i campi della ChatBot");
		System.out.println("\nDigita l'ID :");
		chatbotId = Integer.parseInt(getInput());
		System.out.println("\nDigita il messaggio di benvenuto: ");
		initialMessage = getInput();
		if (chatbotId != null && !initialMessage.equals("")) {
			chatBotsController.insertChatBots(new ChatBots(chatbotId, initialMessage));
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
		MainDispatcher.getInstance().callAction("ChatBots", "doControl", request);
	}

}
