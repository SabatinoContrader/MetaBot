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
		List<BotMessages> botmessages = botMessagesController.getAllBotMessages();
		
		Integer botMessageId;
		String botMessage;
		
		System.out.println("\n----- Seleziona l'elemento da modificare dalla lista elencata -----\n");
		botmessages.forEach(us_type -> System.out.println(us_type.toString()));
		
		System.out.println("Seleziona l'ID dell'elemento da modificare:");
		botMessageId = Integer.parseInt(getInput());
		
		System.out.println("Digita il nuovo messaggio:");
		botMessage = getInput();
		
		if (botMessageId != null && !botMessage.equals("")) {
			botMessagesController.updateBotMessages(new BotMessages(botMessageId, botMessage));
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
