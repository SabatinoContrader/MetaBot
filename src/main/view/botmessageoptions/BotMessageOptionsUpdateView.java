package main.view.botmessageoptions;

import main.MainDispatcher;
import main.controller.Request;
import main.model.BotMessageOptions;
import main.view.View;
import main.controller.BotMessageOptionsController;

import java.util.List;
import java.util.Scanner;

public class BotMessageOptionsUpdateView implements View {

	private BotMessageOptionsController botMessageOptionsController;
	private Request request;

	public BotMessageOptionsUpdateView() {
		this.botMessageOptionsController = new BotMessageOptionsController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		List<BotMessageOptions> botMessageOptions;
		Integer botMessageOptionId;
		String botMessageOption;

		botMessageOptions = botMessageOptionsController.getAllBotMessageOptions();
		System.out.println("\n----- Seleziona l'opzione da modificare dalla lista elencata-----\n");
		System.out.println();
		botMessageOptions.forEach(botMexOption -> System.out.println(botMexOption.toString()));
		System.out.println();
		System.out.println("Seleziona l'ID dell'elemento da modificare: ");
		botMessageOptionId = Integer.parseInt(getInput());
		System.out.println("Digita il nuovo messaggio dell'opzione: ");
		botMessageOption = getInput();
		if (botMessageOptionId != null && !botMessageOption.equals("")) {
			botMessageOptionsController
					.updateBotMessageOptions(new BotMessageOptions(botMessageOptionId, botMessageOption));
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
		MainDispatcher.getInstance().callAction("BotMessageOptions", "doControl", request);
	}

}
