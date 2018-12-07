package main.view.chatbots;

import main.MainDispatcher;
import main.controller.Request;
import main.model.ChatBots;
import main.view.View;
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
		List<ChatBots> chatbots = chatBotsController.getAllChatBots();
		chatbots.forEach(chatbot -> System.out.println(chatbot.toString()));	
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
