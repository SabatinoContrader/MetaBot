package main.view.botmessageoptions;

import main.MainDispatcher;
import main.controller.Request;
import main.model.BotMessageOptions;
import main.view.View;
import main.controller.BotMessageOptionsController;

import java.util.List;
import java.util.Scanner;

public class BotMessageOptionsDeleteView implements View {

	private BotMessageOptionsController botMessageOptionsController;
	private Request request;

	public BotMessageOptionsDeleteView() {
		this.botMessageOptionsController = new BotMessageOptionsController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		List<BotMessageOptions> botmessageoptions;
		Integer idToDelete;
		botmessageoptions = botMessageOptionsController.getAllBotMessageOptions();
		System.out.println("\n----- Seleziona l'elemento da cancellare dalla lista elencata-----\n");
		
		botmessageoptions.forEach(botmessageoption -> System.out.println(botmessageoption.toString()));
		System.out.println();
		
		System.out.println("\nDigita l'ID:");
		idToDelete = Integer.parseInt(getInput());
		
		while(idToDelete == null) {
			System.out.println("\nID inserito non è corretto");
			System.out.println("\nDigita l'ID:");
			idToDelete = Integer.parseInt(getInput());
		}
		
		if (idToDelete != null) {
			botMessageOptionsController.deleteBotMessageOptions(new BotMessageOptions(idToDelete, ""));
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
