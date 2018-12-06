package main.view.botmessages;

import main.MainDispatcher;
import main.controller.Request;
import main.model.BotMessages;
import main.view.View;
import main.controller.BotMessagesController;

import java.util.List;
import java.util.Scanner;

public class BotMessagesReadView implements View {

	private BotMessagesController botMessagesController;
	private Request request;
	
	public BotMessagesReadView() {
		this.botMessagesController = new BotMessagesController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		List<BotMessages> botMessages = botMessagesController.getAllBotMessages();
		System.out.println("----- Gli BotMessages nel tuo database sono -----");
		System.out.println();
		botMessages.forEach(us_type -> System.out.println(us_type.toString()));
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
	    MainDispatcher.getInstance().callAction("BotMessages", "doControl", request);
	}

}
