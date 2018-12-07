package main.view.chatbots;

import main.MainDispatcher;
import main.controller.Request;
import main.model.ChatBots;
import main.view.View;
import main.controller.ChatBotsController;

import java.util.List;
import java.util.Scanner;

import org.springframework.util.StringUtils;

public class ChatBotsUpdateView implements View {

	private ChatBotsController chatBotsController;
	private Request request;

	public ChatBotsUpdateView() {
		this.chatBotsController = new ChatBotsController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		List<ChatBots> chatBots;
		Integer chatbotId;
		String initialMessage;

		chatBots = chatBotsController.getAllChatBots();
		System.out.println("\n----- Seleziona l'elemento da modificare dalla lista elencata -----\n");
		chatBots.forEach(us_type -> System.out.println(us_type.toString()));
		
		System.out.println("Seleziona l'ID della ChatBot da modificare:");
		chatbotId = Integer.parseInt(getInput());
		System.out.println("Nuovo messaggio di benvenuto:");
		initialMessage = getInput();

		if (chatbotId != null && !initialMessage.equals("")) {
			chatBotsController.updateChatBots(new ChatBots(chatbotId, initialMessage));
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
