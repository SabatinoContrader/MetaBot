package main.view.botmessages;

import main.MainDispatcher;
import main.controller.Request;
import main.model.BotMessages;
import main.view.View;
import main.controller.BotMessagesController;

import java.util.List;
import java.util.Scanner;

public class BotMessagesDeleteView implements View {

	private BotMessagesController botMessagesController;
	private Request request;

	public BotMessagesDeleteView() {
		this.botMessagesController = new BotMessagesController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		List<BotMessages> botMessages;
		Integer botMessageId;

		botMessages = botMessagesController.getAllBotMessages();
		System.out.println("\n----- Seleziona l'elemento da cancellare dalla lista elencata-----\n");
		botMessages.forEach(us_type -> System.out.println(us_type.toString()));
		System.out.println("\nDigita l'ID:");
		botMessageId = Integer.parseInt(getInput());
		if (botMessageId != null) {
			botMessagesController.deleteBotMessages(new BotMessages(botMessageId, ""));
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
