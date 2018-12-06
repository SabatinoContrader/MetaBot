package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.model.BotMessageOptions;
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
		System.out.println("----- Gli botMessageOptions nel tuo database sono -----");
		System.out.println();
		botMessageOptions.forEach(us_type -> System.out.println(us_type.toString()));
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
	    MainDispatcher.getInstance().callAction("BotMessageOptions", "doControl", request);
	}

}
