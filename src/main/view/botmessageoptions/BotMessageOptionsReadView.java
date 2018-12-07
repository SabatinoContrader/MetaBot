package main.view.botmessageoptions;

import main.MainDispatcher;
import main.controller.Request;
import main.model.BotMessageOptions;
import main.view.View;
import main.controller.BotMessageOptionsController;

import java.util.List;
import java.util.Scanner;

public class BotMessageOptionsReadView implements View {

	private BotMessageOptionsController botMessageOptionsController;
	private Request request;
	
	public BotMessageOptionsReadView() {
		this.botMessageOptionsController = new BotMessageOptionsController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		List<BotMessageOptions> botMessageOptions = botMessageOptionsController.getAllBotMessageOptions();
		botMessageOptions.forEach(botMessageOption -> System.out.println(botMessageOption.toString()));
		
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
