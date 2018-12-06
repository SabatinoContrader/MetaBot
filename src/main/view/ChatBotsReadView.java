package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.model.ChatBots;
import main.controller.ChatBotsController;

import java.util.List;
import java.util.Scanner;

public class ChatBotsReadView implements View {

	private ChatBotsController chatBotsController;
	private Request request;
	
	public ChatBotsReadView() {
		this.chatBotsController = new ChatBotsController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		List<ChatBots> chatBots = chatBotsController.getAllChatBots();
		System.out.println("----- Gli user_types nel tuo database sono -----");
		System.out.println();
		chatBots.forEach(us_type -> System.out.println(us_type.toString()));
		System.out.println();
		
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
