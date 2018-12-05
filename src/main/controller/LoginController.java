package main.controller;

import main.MainDispatcher;

public class LoginController implements Controller {

    public LoginController() {
    }

    public void doControl (Request request) {
        MainDispatcher.getInstance().callView("Login", request);
    }
}
