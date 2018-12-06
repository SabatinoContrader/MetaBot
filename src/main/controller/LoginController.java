package main.controller;

import main.MainDispatcher;
import main.service.LoginService;

public class LoginController implements Controller {

    private LoginService loginService;
    
    public LoginController() {
        loginService = new LoginService();
    }

    public void doControl (Request request) {
        if (request != null) {
            String nomeUtente = request.get("username").toString();
            String password = request.get("password").toString();
            String type = loginService.login(nomeUtente, password);
            String[] types = type.split(":");
            String part1 = types[0]; 
            String part2 = types[1];
            switch (part2) {
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
        }
        else MainDispatcher.getInstance().callView("Login", null);
    }
}
