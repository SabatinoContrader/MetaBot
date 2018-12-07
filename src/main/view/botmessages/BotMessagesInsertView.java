package main.view.botmessages;

import main.MainDispatcher;
import main.controller.Request;
import main.model.BotMessages;
import main.view.View;
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

		System.out.println("\n Inserisci i campi del BotMessage");
		System.out.println("\nDigita l'ID :");
		botMessageId = Integer.parseInt(getInput());
		System.out.println("\nDigita il testo del messaggio:");
		botMessage = getInput();
		if (botMessageId != null && !botMessage.equals("")) {
			botMessagesController.insertBotMessages(new BotMessages(botMessageId, botMessage));
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
