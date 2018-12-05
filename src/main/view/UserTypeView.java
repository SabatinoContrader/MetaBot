package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.model.UserType;
import main.service.UserTypeService;

import java.util.List;
import java.util.Scanner;

public class UserTypeView implements View {

	private UserTypeService usertypeService;
	private String mode;

	public UserTypeView() {
		this.usertypeService = new UserTypeService();
		this.mode = "all";
	}

	@Override
	public void showResults(Request request) {
		this.mode = (String) request.get("mode");
	}

	@Override
	public void showOptions() {
		switch (mode) {
		case "all":
			List<UserType> usertypes = usertypeService.getAllUserType();
			System.out.println("----- GLi user_type nel tuo database sono -----");
			System.out.println();
			usertypes.forEach(us_type -> System.out.println(us_type.getTypeUser()));
			System.out.println();
			break;
		}
	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	@Override
	public void submit() {
		 MainDispatcher.getInstance().callAction("Home", "doControl", null);
//		Request request = new Request();
//		request.put("mode", "all");
//		MainDispatcher.getInstance().callAction("UserType", "doControl", request);
	}

}
