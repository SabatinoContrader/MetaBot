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
		System.out.println("----- Scegli Id per modificare -----");
		System.out.println();
		botMessageOptions.forEach(us_type -> System.out.println(us_type.toString()));
		System.out.println();
		System.out.println("bot_message_option_id:");
		botMessageOptionId = Integer.parseInt(getInput());
		System.out.println("bot_message_option:");
		botMessageOption = getInput();
		if (botMessageOptionId != null && !botMessageOption.equals("")) {
			botMessageOptionsController
					.updateBotMessageOptions(new BotMessageOptions(botMessageOptionId, botMessageOption, 0));
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
