package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.model.ChatBots;
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

		System.out.println("Inserisci i dati user_types:");
		System.out.println("user_type_id:");
		chatbotId = Integer.parseInt(getInput());
		System.out.println("user_type:");
		initialMessage = getInput();
		System.out.println("user_type:");
		userFk = getInput();
		if (chatbotId != null && !initialMessage.equals("") && !userFk.equals("")) {
			chatBotsController.insertChatBots(new ChatBots(chatbotId, initialMessage, userFk));
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
