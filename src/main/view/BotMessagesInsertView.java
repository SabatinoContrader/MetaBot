package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.model.BotMessages;
import main.controller.BotMessagesController;

import java.util.Scanner;

public class BotMessagesInsertView implements View {

	private BotMessagesController botMessagesController;
	private Request request;

	public BotMessagesInsertView() {
		this.botMessagesController = new BotMessagesController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		Integer botMessageId;
		String botMessage;
		Integer chatbotFk;

		System.out.println("Inserisci i dati BotMessages:");
		System.out.println("bot_message_id	:");
		botMessageId = Integer.parseInt(getInput());
		System.out.println("bot_message:");
		botMessage = getInput();
		System.out.println("chatbot_fk:");
		chatbotFk = Integer.parseInt(getInput());
		if (botMessageId != null && !botMessage.equals("") && chatbotFk != null) {
			botMessagesController.insertBotMessages(new BotMessages(botMessageId, botMessage, chatbotFk));
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
