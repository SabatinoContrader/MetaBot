package main.controller;

import main.MainDispatcher;
import main.service.LoginService;

public class LoginController implements Controller {

	private LoginService loginService;

	public LoginController() {
		loginService = new LoginService();
	}

	public void doControl(Request request) {
		if (request != null) {
			String nomeUtente = request.get("username").toString();
			String password = request.get("password").toString();
			String type = loginService.login(nomeUtente, password);
			
			if (!type.equals("")) {

				String[] types = type.split(":");
				String username = types[0];
				String userType = types[1];
				switch (userType) {
				case "ADMIN":
					MainDispatcher.getInstance().callView("Home", request);
					break;
				case "CHAT MASTER":
					MainDispatcher.getInstance().callView("HomeChatMaster", request);
					break;
				default:
					MainDispatcher.getInstance().callView("Login", null);
					break;
				}
			}else
				MainDispatcher.getInstance().callView("Login", null);
		} else
			MainDispatcher.getInstance().callView("Login", null);
	}
}
