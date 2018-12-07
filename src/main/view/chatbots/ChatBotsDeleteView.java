package main.view.chatbots;

import main.MainDispatcher;
import main.controller.Request;
import main.model.ChatBots;
import main.view.View;
import main.controller.ChatBotsController;

import java.util.List;
import java.util.Scanner;

public class ChatBotsDeleteView implements View {

	private ChatBotsController chatBotsControllerController;
	private Request request;

	public ChatBotsDeleteView() {
		this.chatBotsControllerController = new ChatBotsController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		List<ChatBots> chatBots;
		Integer chatbotId;

		chatBots = chatBotsControllerController.getAllChatBots();
		System.out.println("\n----- Seleziona l'elemento da cancellare dalla lista elencata-----\n");
		chatBots.forEach(us_type -> System.out.println(us_type.toString()));
		System.out.println("\nDigita l'ID:");
		chatbotId = Integer.parseInt(getInput());
		if (chatbotId != null) {
			chatBotsControllerController.deleteChatBots(new ChatBots(chatbotId, ""));
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
