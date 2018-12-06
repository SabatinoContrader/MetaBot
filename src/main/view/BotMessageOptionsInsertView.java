package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.model.BotMessageOptions;
import main.controller.BotMessageOptionsController;

import java.util.Scanner;

public class BotMessageOptionsInsertView implements View {

	private BotMessageOptionsController botMessageOptionsController;
	private Request request;

	public BotMessageOptionsInsertView() {
		this.botMessageOptionsController = new BotMessageOptionsController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		int botMessageOptionId;
		String botMessageOption;
		int botMessageFk;
        
        System.out.println("Inserisci i dati BotMessageOptions:");
        System.out.println("bot_message_option_id:");
        botMessageOptionId = Integer.parseInt(getInput());
        System.out.println("bot_message_option:");
        botMessageOption = getInput();
        System.out.println("bot_message_fk:");
        botMessageFk = Integer.parseInt(getInput());
        botMessageOptionsController.insertBotMessageOptions(new BotMessageOptions(botMessageOptionId, botMessageOption, botMessageFk ));
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
