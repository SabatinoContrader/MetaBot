package main.view.botmessages;

import main.MainDispatcher;
import main.controller.Request;
import main.model.BotMessages;
import main.view.View;
import main.controller.BotMessagesController;

import java.util.List;
import java.util.Scanner;

public class BotMessagesUpdateView implements View {

	private BotMessagesController botMessagesController;
	private Request request;

	public BotMessagesUpdateView() {
		this.botMessagesController = new BotMessagesController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		List<BotMessages> botMessages;

		Integer botMessageId;
		String botMessage;

		botMessages = botMessagesController.getAllBotMessages();
		System.out.println("----- Scegli Id per modificare -----");
		System.out.println();
		botMessages.forEach(us_type -> System.out.println(us_type.toString()));
		System.out.println();
		System.out.println("bot_message_id:");
		botMessageId = Integer.parseInt(getInput());
		System.out.println("bot_message:");
		botMessage = getInput();
		if (botMessageId != null && !botMessage.equals("")) {
			botMessagesController.updateBotMessages(new BotMessages(botMessageId, botMessage, 0));
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
		MainDispatcher.getInstance().callAction("BotMessages", "doControl", request);
	}

}
